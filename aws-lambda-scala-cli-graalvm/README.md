## Example AWS Lambda Application in Scala with GraalVM Native Image

This example illustrates creating a simple AWS Lambda function in Scala with GraalVM Native Image.

## Building deployable artifact

To build a deployment package using [Scala-CLI](https://scala-cli.virtuslab.org/), run the following command:

If you're using Linux, it's enough to run:
```bash
scala-cli --power package MyApp.scala --native-image
```

If you're macOS or Windows user, you need to use Docker, to build a Linux native image.<br/>
However, no need for manually created `Dockerfile` - Scala-CLI [will take care of it for you](https://github.com/VirtusLab/scala-cli/blob/main/website/docs/release_notes.md#added-support-for-packaging-native-images-from-docker).

Discover more about Scala-CLI in this comprehensive article: [One and Done: Embrace single-file JVM apps for speedy development](https://blog.lambdaspot.dev/one-and-done-embrace-single-file-jvm-apps-for-speedy-development).

## Testing locally

Testing locally requires using the [AWS Lambda Runtime Interface Emulator](https://github.com/aws/aws-lambda-java-libs/blob/main/aws-lambda-java-runtime-interface-client/README.md#local-testing).

# Manual deployment and testing

Upload the packaged `bootstrap` and compiled `MyApp` native executable to S3.<br/>
Then "Upload from Amazon S3 location" to AWS Lambda.

Invoke the function with event: `{"name": "John Doe", "age": 44}`

See result:
```json
{
  "statusCode": 200,
  "headers": {
    "Content-Type": "text/plain"
  },
  "body": "Hello John Doe!"
}
```

## Deploying

Extend the `template.yaml` according to your needs, add an `Events` section, and then use `sam deploy --guided`.
