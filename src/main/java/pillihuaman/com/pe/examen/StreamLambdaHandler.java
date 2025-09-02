package pillihuaman.com.pe.examen;

// === IMPORTS AÑADIDOS PARA RESOLVER EL ERROR ===
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
// ==============================================

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamLambdaHandler implements RequestStreamHandler {
    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

    static {
        try {
            // Esta línea le dice al handler cómo iniciar tu aplicación Spring Boot
            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(ExamenApplication.class);
        } catch (Exception e) {
            // Este log es crucial para depurar problemas de inicio en CloudWatch
            e.printStackTrace();
            throw new RuntimeException("No se pudo inicializar la aplicación Spring Boot", e);
        }
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        handler.proxyStream(inputStream, outputStream, context);
    }
}