package grpc.fieldservice;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: FieldService.proto")
public final class FieldServiceGrpc {

  private FieldServiceGrpc() {}

  public static final String SERVICE_NAME = "field.FieldService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      grpc.fieldservice.FieldResponse> METHOD_GET_FIELD =
      io.grpc.MethodDescriptor.<com.google.protobuf.Empty, grpc.fieldservice.FieldResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "field.FieldService", "getField"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.fieldservice.FieldResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      grpc.fieldservice.ClientIdResponse> METHOD_GET_CLIENT_ID =
      io.grpc.MethodDescriptor.<com.google.protobuf.Empty, grpc.fieldservice.ClientIdResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "field.FieldService", "getClientId"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.fieldservice.ClientIdResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.fieldservice.AddNewCommandRequest,
      grpc.fieldservice.FieldResponse> METHOD_EXECUTE_COMMAND =
      io.grpc.MethodDescriptor.<grpc.fieldservice.AddNewCommandRequest, grpc.fieldservice.FieldResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "field.FieldService", "executeCommand"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.fieldservice.AddNewCommandRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.fieldservice.FieldResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.fieldservice.NeedToRepaintRequest,
      grpc.fieldservice.NeedToRepaintResponse> METHOD_NEED_TO_REPAINT =
      io.grpc.MethodDescriptor.<grpc.fieldservice.NeedToRepaintRequest, grpc.fieldservice.NeedToRepaintResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "field.FieldService", "needToRepaint"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.fieldservice.NeedToRepaintRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.fieldservice.NeedToRepaintResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.fieldservice.SetNtrRequest,
      com.google.protobuf.Empty> METHOD_SET_NTR =
      io.grpc.MethodDescriptor.<grpc.fieldservice.SetNtrRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "field.FieldService", "setNtr"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.fieldservice.SetNtrRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FieldServiceStub newStub(io.grpc.Channel channel) {
    return new FieldServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FieldServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FieldServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FieldServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FieldServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FieldServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getField(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<grpc.fieldservice.FieldResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FIELD, responseObserver);
    }

    /**
     */
    public void getClientId(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<grpc.fieldservice.ClientIdResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CLIENT_ID, responseObserver);
    }

    /**
     */
    public void executeCommand(grpc.fieldservice.AddNewCommandRequest request,
        io.grpc.stub.StreamObserver<grpc.fieldservice.FieldResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EXECUTE_COMMAND, responseObserver);
    }

    /**
     */
    public void needToRepaint(grpc.fieldservice.NeedToRepaintRequest request,
        io.grpc.stub.StreamObserver<grpc.fieldservice.NeedToRepaintResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_NEED_TO_REPAINT, responseObserver);
    }

    /**
     */
    public void setNtr(grpc.fieldservice.SetNtrRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_NTR, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_FIELD,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                grpc.fieldservice.FieldResponse>(
                  this, METHODID_GET_FIELD)))
          .addMethod(
            METHOD_GET_CLIENT_ID,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                grpc.fieldservice.ClientIdResponse>(
                  this, METHODID_GET_CLIENT_ID)))
          .addMethod(
            METHOD_EXECUTE_COMMAND,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.fieldservice.AddNewCommandRequest,
                grpc.fieldservice.FieldResponse>(
                  this, METHODID_EXECUTE_COMMAND)))
          .addMethod(
            METHOD_NEED_TO_REPAINT,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.fieldservice.NeedToRepaintRequest,
                grpc.fieldservice.NeedToRepaintResponse>(
                  this, METHODID_NEED_TO_REPAINT)))
          .addMethod(
            METHOD_SET_NTR,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.fieldservice.SetNtrRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_SET_NTR)))
          .build();
    }
  }

  /**
   */
  public static final class FieldServiceStub extends io.grpc.stub.AbstractStub<FieldServiceStub> {
    private FieldServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FieldServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FieldServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FieldServiceStub(channel, callOptions);
    }

    /**
     */
    public void getField(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<grpc.fieldservice.FieldResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FIELD, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getClientId(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<grpc.fieldservice.ClientIdResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CLIENT_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void executeCommand(grpc.fieldservice.AddNewCommandRequest request,
        io.grpc.stub.StreamObserver<grpc.fieldservice.FieldResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_EXECUTE_COMMAND, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void needToRepaint(grpc.fieldservice.NeedToRepaintRequest request,
        io.grpc.stub.StreamObserver<grpc.fieldservice.NeedToRepaintResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_NEED_TO_REPAINT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setNtr(grpc.fieldservice.SetNtrRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_NTR, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FieldServiceBlockingStub extends io.grpc.stub.AbstractStub<FieldServiceBlockingStub> {
    private FieldServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FieldServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FieldServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FieldServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.fieldservice.FieldResponse getField(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FIELD, getCallOptions(), request);
    }

    /**
     */
    public grpc.fieldservice.ClientIdResponse getClientId(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CLIENT_ID, getCallOptions(), request);
    }

    /**
     */
    public grpc.fieldservice.FieldResponse executeCommand(grpc.fieldservice.AddNewCommandRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_EXECUTE_COMMAND, getCallOptions(), request);
    }

    /**
     */
    public grpc.fieldservice.NeedToRepaintResponse needToRepaint(grpc.fieldservice.NeedToRepaintRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_NEED_TO_REPAINT, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty setNtr(grpc.fieldservice.SetNtrRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_NTR, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FieldServiceFutureStub extends io.grpc.stub.AbstractStub<FieldServiceFutureStub> {
    private FieldServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FieldServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FieldServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FieldServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.fieldservice.FieldResponse> getField(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FIELD, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.fieldservice.ClientIdResponse> getClientId(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CLIENT_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.fieldservice.FieldResponse> executeCommand(
        grpc.fieldservice.AddNewCommandRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_EXECUTE_COMMAND, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.fieldservice.NeedToRepaintResponse> needToRepaint(
        grpc.fieldservice.NeedToRepaintRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_NEED_TO_REPAINT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> setNtr(
        grpc.fieldservice.SetNtrRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_NTR, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FIELD = 0;
  private static final int METHODID_GET_CLIENT_ID = 1;
  private static final int METHODID_EXECUTE_COMMAND = 2;
  private static final int METHODID_NEED_TO_REPAINT = 3;
  private static final int METHODID_SET_NTR = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FieldServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FieldServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FIELD:
          serviceImpl.getField((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<grpc.fieldservice.FieldResponse>) responseObserver);
          break;
        case METHODID_GET_CLIENT_ID:
          serviceImpl.getClientId((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<grpc.fieldservice.ClientIdResponse>) responseObserver);
          break;
        case METHODID_EXECUTE_COMMAND:
          serviceImpl.executeCommand((grpc.fieldservice.AddNewCommandRequest) request,
              (io.grpc.stub.StreamObserver<grpc.fieldservice.FieldResponse>) responseObserver);
          break;
        case METHODID_NEED_TO_REPAINT:
          serviceImpl.needToRepaint((grpc.fieldservice.NeedToRepaintRequest) request,
              (io.grpc.stub.StreamObserver<grpc.fieldservice.NeedToRepaintResponse>) responseObserver);
          break;
        case METHODID_SET_NTR:
          serviceImpl.setNtr((grpc.fieldservice.SetNtrRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class FieldServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.fieldservice.FieldServiceOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FieldServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FieldServiceDescriptorSupplier())
              .addMethod(METHOD_GET_FIELD)
              .addMethod(METHOD_GET_CLIENT_ID)
              .addMethod(METHOD_EXECUTE_COMMAND)
              .addMethod(METHOD_NEED_TO_REPAINT)
              .addMethod(METHOD_SET_NTR)
              .build();
        }
      }
    }
    return result;
  }
}
