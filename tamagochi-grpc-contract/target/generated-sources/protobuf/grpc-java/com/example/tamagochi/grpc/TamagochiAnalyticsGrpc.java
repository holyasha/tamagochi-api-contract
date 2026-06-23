package com.example.tamagochi.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Сервис
 * Unary RPC - один запрос = один ответ (аналог REST GET/POST)
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: tamagochi_analytics.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TamagochiAnalyticsGrpc {

  private TamagochiAnalyticsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "tamagochianalytics.TamagochiAnalytics";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.tamagochi.grpc.AnalyzeTamagochiRequest,
      com.example.tamagochi.grpc.TamagochiAnalysisResponse> getAnalyzeTamagochiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeTamagochi",
      requestType = com.example.tamagochi.grpc.AnalyzeTamagochiRequest.class,
      responseType = com.example.tamagochi.grpc.TamagochiAnalysisResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.tamagochi.grpc.AnalyzeTamagochiRequest,
      com.example.tamagochi.grpc.TamagochiAnalysisResponse> getAnalyzeTamagochiMethod() {
    io.grpc.MethodDescriptor<com.example.tamagochi.grpc.AnalyzeTamagochiRequest, com.example.tamagochi.grpc.TamagochiAnalysisResponse> getAnalyzeTamagochiMethod;
    if ((getAnalyzeTamagochiMethod = TamagochiAnalyticsGrpc.getAnalyzeTamagochiMethod) == null) {
      synchronized (TamagochiAnalyticsGrpc.class) {
        if ((getAnalyzeTamagochiMethod = TamagochiAnalyticsGrpc.getAnalyzeTamagochiMethod) == null) {
          TamagochiAnalyticsGrpc.getAnalyzeTamagochiMethod = getAnalyzeTamagochiMethod =
              io.grpc.MethodDescriptor.<com.example.tamagochi.grpc.AnalyzeTamagochiRequest, com.example.tamagochi.grpc.TamagochiAnalysisResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeTamagochi"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.tamagochi.grpc.AnalyzeTamagochiRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.tamagochi.grpc.TamagochiAnalysisResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TamagochiAnalyticsMethodDescriptorSupplier("AnalyzeTamagochi"))
              .build();
        }
      }
    }
    return getAnalyzeTamagochiMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TamagochiAnalyticsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TamagochiAnalyticsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TamagochiAnalyticsStub>() {
        @java.lang.Override
        public TamagochiAnalyticsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TamagochiAnalyticsStub(channel, callOptions);
        }
      };
    return TamagochiAnalyticsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TamagochiAnalyticsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TamagochiAnalyticsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TamagochiAnalyticsBlockingStub>() {
        @java.lang.Override
        public TamagochiAnalyticsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TamagochiAnalyticsBlockingStub(channel, callOptions);
        }
      };
    return TamagochiAnalyticsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TamagochiAnalyticsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TamagochiAnalyticsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TamagochiAnalyticsFutureStub>() {
        @java.lang.Override
        public TamagochiAnalyticsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TamagochiAnalyticsFutureStub(channel, callOptions);
        }
      };
    return TamagochiAnalyticsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Сервис
   * Unary RPC - один запрос = один ответ (аналог REST GET/POST)
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Анализирует тамагочи и возвращает вычисленные метрики
     * </pre>
     */
    default void analyzeTamagochi(com.example.tamagochi.grpc.AnalyzeTamagochiRequest request,
        io.grpc.stub.StreamObserver<com.example.tamagochi.grpc.TamagochiAnalysisResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAnalyzeTamagochiMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TamagochiAnalytics.
   * <pre>
   * Сервис
   * Unary RPC - один запрос = один ответ (аналог REST GET/POST)
   * </pre>
   */
  public static abstract class TamagochiAnalyticsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TamagochiAnalyticsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TamagochiAnalytics.
   * <pre>
   * Сервис
   * Unary RPC - один запрос = один ответ (аналог REST GET/POST)
   * </pre>
   */
  public static final class TamagochiAnalyticsStub
      extends io.grpc.stub.AbstractAsyncStub<TamagochiAnalyticsStub> {
    private TamagochiAnalyticsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TamagochiAnalyticsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TamagochiAnalyticsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Анализирует тамагочи и возвращает вычисленные метрики
     * </pre>
     */
    public void analyzeTamagochi(com.example.tamagochi.grpc.AnalyzeTamagochiRequest request,
        io.grpc.stub.StreamObserver<com.example.tamagochi.grpc.TamagochiAnalysisResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeTamagochiMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TamagochiAnalytics.
   * <pre>
   * Сервис
   * Unary RPC - один запрос = один ответ (аналог REST GET/POST)
   * </pre>
   */
  public static final class TamagochiAnalyticsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TamagochiAnalyticsBlockingStub> {
    private TamagochiAnalyticsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TamagochiAnalyticsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TamagochiAnalyticsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Анализирует тамагочи и возвращает вычисленные метрики
     * </pre>
     */
    public com.example.tamagochi.grpc.TamagochiAnalysisResponse analyzeTamagochi(com.example.tamagochi.grpc.AnalyzeTamagochiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeTamagochiMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TamagochiAnalytics.
   * <pre>
   * Сервис
   * Unary RPC - один запрос = один ответ (аналог REST GET/POST)
   * </pre>
   */
  public static final class TamagochiAnalyticsFutureStub
      extends io.grpc.stub.AbstractFutureStub<TamagochiAnalyticsFutureStub> {
    private TamagochiAnalyticsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TamagochiAnalyticsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TamagochiAnalyticsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Анализирует тамагочи и возвращает вычисленные метрики
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.tamagochi.grpc.TamagochiAnalysisResponse> analyzeTamagochi(
        com.example.tamagochi.grpc.AnalyzeTamagochiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeTamagochiMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANALYZE_TAMAGOCHI = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ANALYZE_TAMAGOCHI:
          serviceImpl.analyzeTamagochi((com.example.tamagochi.grpc.AnalyzeTamagochiRequest) request,
              (io.grpc.stub.StreamObserver<com.example.tamagochi.grpc.TamagochiAnalysisResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAnalyzeTamagochiMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.tamagochi.grpc.AnalyzeTamagochiRequest,
              com.example.tamagochi.grpc.TamagochiAnalysisResponse>(
                service, METHODID_ANALYZE_TAMAGOCHI)))
        .build();
  }

  private static abstract class TamagochiAnalyticsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TamagochiAnalyticsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.tamagochi.grpc.TamagochiAnalyticsOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TamagochiAnalytics");
    }
  }

  private static final class TamagochiAnalyticsFileDescriptorSupplier
      extends TamagochiAnalyticsBaseDescriptorSupplier {
    TamagochiAnalyticsFileDescriptorSupplier() {}
  }

  private static final class TamagochiAnalyticsMethodDescriptorSupplier
      extends TamagochiAnalyticsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TamagochiAnalyticsMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TamagochiAnalyticsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TamagochiAnalyticsFileDescriptorSupplier())
              .addMethod(getAnalyzeTamagochiMethod())
              .build();
        }
      }
    }
    return result;
  }
}
