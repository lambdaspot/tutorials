## Example AWS Lambda Application in Scala

This example illustrates creating a simple AWS Lambda function in Scala.

## Building deployable artifact

To build a deployment package using [Scala-CLI](https://scala-cli.virtuslab.org/), run the following command:

```bash
scala-cli --power package MyApp.scala --assembly --preamble=false
```

Discover more about Scala-CLI in this comprehensive article: [One and Done: Embrace single-file JVM apps for speedy development](https://blog.lambdaspot.dev/one-and-done-embrace-single-file-jvm-apps-for-speedy-development).

## Testing locally

Run the function locally
using [AWS SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/install-sam-cli.html) (make sure you have v1.82.0+):

Invoke the function `echo '{"name": "John Doe", "age": 44}' | sam local invoke --event - "HelloScalaFunction"`.

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
