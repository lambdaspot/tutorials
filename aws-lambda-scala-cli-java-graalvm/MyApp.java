//jvm "graalvm-java17:22.3.2"
//> using lib "com.amazonaws:aws-lambda-java-core:1.2.2"
//> using lib "com.amazonaws:aws-lambda-java-events:3.11.1"
//> using lib "com.amazonaws:aws-lambda-java-runtime-interface-client:2.3.2"
//> using mainClass "com.amazonaws.services.lambda.runtime.api.client.AWSLambda"
//> using resourceDir "../resources"

package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.*;

public class MyApp implements RequestHandler<APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse> {
    @Override
    public APIGatewayV2HTTPResponse handleRequest(APIGatewayV2HTTPEvent event, Context context) {
        return APIGatewayV2HTTPResponse.builder()
                .withStatusCode(200)
                .withBody("Hello world!")
                .build();
    }
}
