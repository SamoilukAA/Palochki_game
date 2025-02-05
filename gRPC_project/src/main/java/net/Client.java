package net;

import field.PaintField;
import field.PlayingField;
import grpc.fieldservice.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    static String host = "localhost";
    static int port = 8080;
    static int id;
    static SerializableCommand command;
    static PlayingField pfield;
    static PaintField pf;
    static boolean ntr;

    static Thread changeFild, fieldIsChanged;

    static void parseField(FieldResponse fieldResponse) {
        pfield.rows = fieldResponse.getRows();
        pfield.cols = fieldResponse.getCols();
        for (int i = 0; i < pfield.rows; i++) {
            for (int j = 0; j < pfield.cols; j++) {
                pfield.setCellState(i, j, fieldResponse.getCells(i * pfield.cols + j));
            }
        }
        for (int i = 0; i < pfield.rows; i++) {
            for (int j = 0; j < pfield.cols + 1; j++) {
                pfield.setHlineState(i, j, fieldResponse.getHlines(i * (pfield.cols + 1) + j));
            }
        }
        for (int i = 0; i < pfield.rows + 1; i++) {
            for (int j = 0; j < pfield.cols; j++) {
                pfield.setVlineState(i, j, fieldResponse.getVlines(i * pfield.cols + j));
            }
        }
        pfield.whoMove = fieldResponse.getWhoMove();
    }

    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        FieldServiceGrpc.FieldServiceBlockingStub stub =  FieldServiceGrpc.newBlockingStub(channel);
        ntr = false;
        //HelloRequest request = HelloRequest.newBuilder().setMsg("Hello").setWho("Nastya").build();
        ClientIdResponse idResponse = stub.getClientId(com.google.protobuf.Empty.getDefaultInstance());
        id = idResponse.getClientId();
        System.out.println(id);
        FieldResponse fieldResponse = stub.getField(com.google.protobuf.Empty.getDefaultInstance());
        parseField(fieldResponse);
        command = new SerializableCommand();
        pf = new PaintField(id, pfield, command);

        changeFild = new Thread(
                ()-> {
                    while (true) {
                        command = pf.getCommand();
                        if (command.status == 1){
                            AddNewCommandRequest newCommandRequest = AddNewCommandRequest.newBuilder()
                                    .setPlayerIndex(id)
                                    .setCommandName(command.commandName)
                                    .setIIndex(command.iIndex)
                                    .setJIndex(command.jIndex).build();
                            FieldResponse fieldResponse1 = stub.executeCommand(newCommandRequest);
                            parseField(fieldResponse1);
                            command.status = 0;
                            ntr = true;
                            SetNtrRequest ntrRequest = SetNtrRequest.newBuilder().setClientId(id).setNtr(ntr).build();
                            pf.repaintField(pfield);
                        }
                    }
                }
        );
        changeFild.start();

        fieldIsChanged = new Thread(
                ()-> {
                    while (true) {
                        NeedToRepaintRequest needToRepaintRequest = NeedToRepaintRequest.newBuilder()
                                .setClientId(id).build();
                        NeedToRepaintResponse needToRepaintResponse = stub.needToRepaint(needToRepaintRequest);
                        ntr = needToRepaintResponse.getNtr();
                        if (ntr){
                            FieldResponse fieldResponse2 = stub.getField(com.google.protobuf.Empty.getDefaultInstance());
                            parseField(fieldResponse2);
                            pf.repaintField(pfield);
                            ntr = false;
                                if (id == 1) {
                                    SetNtrRequest setNtrRequest = SetNtrRequest.newBuilder()
                                            .setClientId(2)
                                            .setNtr(ntr).build();
                                    stub.setNtr(setNtrRequest);
                                } else {
                                    SetNtrRequest setNtrRequest = SetNtrRequest.newBuilder()
                                            .setClientId(1)
                                            .setNtr(ntr).build();
                                    stub.setNtr(setNtrRequest);
                                }
                            }
                        }
                    }
        );
        fieldIsChanged.start();
    }
}
