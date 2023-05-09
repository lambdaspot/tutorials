## Example AWS Lambda Application in Java with GraalVM Native Image

This example demonstrates the creation of a basic AWS Lambda function in Java, utilizing GraalVM Native Image for
enhanced performance. Additionally, the example highlights the option to compile the Java source code using Scala-CLI.

## Building deployable artifact

To build a deployment package using [Scala-CLI](https://scala-cli.virtuslab.org/), run the following command:

```bash
scala-cli --power package MyApp.java --native-image -o dist/native
```

If you're using Linux, the above is enough.

If you're using macOS or Windows, you must utilize Docker to build a Linux-based native image.<br/>
However, there is no need to create a Dockerfile manually, as you can also utilize
the [Scala-CLI's Docker image](https://github.com/VirtusLab/scala-cli/blob/main/website/docs/release_notes.md#added-support-for-packaging-native-images-from-docker)
for this purpose.

```bash
docker pull virtuslab/scala-cli
docker run --rm -v $(pwd)/MyApp.java:/MyApp.java -v $(pwd)/dist:/dist -v $(pwd)/resources:/resources virtuslab/scala-cli --power package --native-image -o dist/native /MyApp.java
```

You can find the files generated in the `dist` directory.

Discover more about Scala-CLI in this comprehensive
article: [One and Done: Embrace single-file JVM apps for speedy development](https://blog.lambdaspot.dev/one-and-done-embrace-single-file-jvm-apps-for-speedy-development).

## Preparing deployment package

Create a zip archive containing the `bootstrap` and `native` files:

```shell
zip -j dist/package.zip dist/*
```
_(Make sure to `chmod 775 dist/bootstrap` earlier)_.

## Testing locally

In order to conduct local testing, it is necessary to utilize
the [AWS Lambda Runtime Interface Emulator](https://github.com/aws/aws-lambda-java-libs/blob/main/aws-lambda-java-runtime-interface-client/README.md#local-testing),
which simulates the AWS Lambda environment and allows for testing of your native functions.

# Manual deployment and testing

Upload the [zipped package](#preparing-deployment-package) to the cloud using AWS Lambda Console.

Invoke the function.

See result:

```json
{
  "statusCode": 200,
  "body": "Hello world!",
  "isBase64Encoded": false
}
```

## Deploying

Extend the `template.yaml` according to your needs, add an `Events` section, and then use `sam deploy --guided`.
