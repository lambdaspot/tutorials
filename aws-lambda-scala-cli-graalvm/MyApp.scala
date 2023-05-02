//> using scala "3"
//> using jvm "graalvm-java17:22.3.2"
//> using dep "com.amazonaws:aws-lambda-java-core:1.2.2"
//> using dep "com.amazonaws:aws-lambda-java-events:3.11.1"
//> using dep "com.amazonaws:aws-lambda-java-runtime-interface-client:2.3.2"
//> using mainClass "com.amazonaws.services.lambda.runtime.api.client.AWSLambda"

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events._

class MyApp extends RequestHandler[APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent] {
  override def handleRequest(event: APIGatewayProxyRequestEvent, context: Context): APIGatewayProxyResponseEvent =
    new APIGatewayProxyResponseEvent()
      .withStatusCode(200)
      .withBody("Hello world!")
}


