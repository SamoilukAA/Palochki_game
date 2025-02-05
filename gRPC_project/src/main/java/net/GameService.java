package net;

import field.PlayingField;
import grpc.fieldservice.ClientIdResponse;
import grpc.fieldservice.FieldResponse;
import grpc.fieldservice.FieldServiceGrpc;
import grpc.fieldservice.NeedToRepaintResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.util.LinkedList;
import java.util.Queue;

public class GameService extends FieldServiceGrpc.FieldServiceImplBase {

    static PlayingField pfield;
    static Queue<Integer> clientIds;
    static boolean ntr1, ntr2;

    public GameService() {
        pfield = new PlayingField(6, 6);
        clientIds = new LinkedList<Integer>();
        clientIds.add(1);
        clientIds.add(2);
        ntr1 = false;
        ntr2 = false;
    }

    public void getField(com.google.protobuf.Empty request,
                         io.grpc.stub.StreamObserver<grpc.fieldservice.FieldResponse> responseObserver) {
        FieldResponse.Builder buildresponse = FieldResponse.newBuilder();
        for (int i = 0; i < pfield.rows; i++) {
            for (int j = 0; j < pfield.cols; j++) {
                buildresponse.addCells(pfield.getCellState(i, j));
            }
        }
        for (int i = 0; i < pfield.rows; i++) {
            for (int j = 0; j < pfield.cols + 1; j++) {
                buildresponse.addHlines(pfield.getHlineState(i, j));
            }
        }
        for (int i = 0; i < pfield.rows + 1; i++) {
            for (int j = 0; j < pfield.cols; j++) {
                buildresponse.addVlines(pfield.getVlineState(i, j));
            }
        }
        buildresponse.addScore(pfield.getScore()[0]);
        buildresponse.addScore(pfield.getScore()[1]);
        buildresponse.setRows(pfield.rows);
        buildresponse.setCols(pfield.cols);
        buildresponse.setWhoMove(pfield.whoMove);
        FieldResponse response = buildresponse.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void getClientId(com.google.protobuf.Empty request,
                            io.grpc.stub.StreamObserver<grpc.fieldservice.ClientIdResponse> responseObserver) {
        ClientIdResponse response = ClientIdResponse.newBuilder().setClientId(clientIds.remove()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void executeCommand(grpc.fieldservice.AddNewCommandRequest request,
                               io.grpc.stub.StreamObserver<grpc.fieldservice.FieldResponse> responseObserver) {
        if (request.getPlayerIndex() == 1) {
            if (request.getCommandName().equals("ChooseHLine")){
                pfield.setHlineState(request.getIIndex(), request.getJIndex(), "RED");
                if (!pfield.needToSetSymbol()){
                    pfield.whoMove = pfield.switchMove();
                }
            }
            if (request.getCommandName().equals("ChooseVLine")){
                pfield.setVlineState(request.getIIndex(), request.getJIndex(), "RED");
                if (!pfield.needToSetSymbol()){
                    pfield.whoMove = pfield.switchMove();
                }
            }
            if (request.getCommandName().equals("SetSymbol")) {
                pfield.setCellState(request.getIIndex(), request.getJIndex(), "A");
                pfield.countScore();
            }
        }
        if (request.getPlayerIndex() == 2) {
            if (request.getCommandName().equals("ChooseHLine")){
                pfield.setHlineState(request.getIIndex(), request.getJIndex(), "GREEN");
                if (!pfield.needToSetSymbol()){
                    pfield.whoMove = pfield.switchMove();
                }
            }
            if (request.getCommandName().equals("ChooseVLine")){
                pfield.setVlineState(request.getIIndex(), request.getJIndex(), "GREEN");
                if (!pfield.needToSetSymbol()){
                    pfield.whoMove = pfield.switchMove();
                }
            }
            if (request.getCommandName().equals("SetSymbol")) {
                pfield.setCellState(request.getIIndex(), request.getJIndex(), "B");
                pfield.countScore();
            }
        }
        FieldResponse.Builder buildresponse = FieldResponse.newBuilder();
        for (int i = 0; i < pfield.rows; i++) {
            for (int j = 0; j < pfield.cols; j++) {
                buildresponse.addCells(pfield.getCellState(i, j));
            }
        }
        for (int i = 0; i < pfield.rows; i++) {
            for (int j = 0; j < pfield.cols + 1; j++) {
                buildresponse.addHlines(pfield.getHlineState(i, j));
            }
        }
        for (int i = 0; i < pfield.rows + 1; i++) {
            for (int j = 0; j < pfield.cols; j++) {
                buildresponse.addVlines(pfield.getVlineState(i, j));
            }
        }
        buildresponse.addScore(pfield.getScore()[0]);
        buildresponse.addScore(pfield.getScore()[1]);
        buildresponse.setRows(pfield.rows);
        buildresponse.setCols(pfield.cols);
        buildresponse.setWhoMove(pfield.whoMove);
        FieldResponse response = buildresponse.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void needToRepaint(grpc.fieldservice.NeedToRepaintRequest request,
                              io.grpc.stub.StreamObserver<grpc.fieldservice.NeedToRepaintResponse> responseObserver) {
        if (request.getClientId() == 1) {
            NeedToRepaintResponse response = NeedToRepaintResponse.newBuilder().setNtr(ntr2).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            NeedToRepaintResponse response = NeedToRepaintResponse.newBuilder().setNtr(ntr1).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    public void setNtr(grpc.fieldservice.SetNtrRequest request,
                       io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
        if (request.getClientId() == 1){
            ntr1 = request.getNtr();
        } else {
            ntr2 = request.getNtr();
        }
    }

    public static void main(String[] args) throws Exception {
        /* pfield = new PlayingField(6, 6);
        clientIds = new LinkedList<Integer>();
        clientIds.add(1);
        clientIds.add(2);
        ntr1 = false;
        ntr2 = false; */
        GameService service = new GameService();
        Server server = ServerBuilder.forPort(8080).addService(service).build();
        server.start();
        System.out.println("server started");
        server.awaitTermination();
    }
}
