package dlp.snippets.regional;

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.cloud.dlp.v2.DlpServiceSettings;
import com.google.privacy.dlp.v2.ContentItem;
import com.google.privacy.dlp.v2.DeidentifyConfig;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InfoTypeTransformations;
import com.google.privacy.dlp.v2.InfoTypeTransformations.InfoTypeTransformation;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.LocationName;
import com.google.privacy.dlp.v2.PrimitiveTransformation;
import com.google.privacy.dlp.v2.RedactConfig;
import com.google.privacy.dlp.v2.ReplaceValueConfig;
import com.google.privacy.dlp.v2.ReplaceWithInfoTypeConfig;
import com.google.privacy.dlp.v2.Value;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Run with:
 *
 * <pre>{@code
 * mvn package exec:java -Dmaven.test.skip=true -Dexec.mainClass="dlp.snippets.regional.RegionalDeIdentifyContent" -Dproject_id=my-project-id -Dlocation_id=us-west2
 * }</pre>
 */
public class RegionalDeIdentifyContent {

  public static void main(String[] args) throws Exception {
    try (DlpServiceClient dlp = DlpServiceClient.create(DlpServiceSettings.newBuilder()
        .setCredentialsProvider(new AppCredentialProvider()).build())) {
      new RegionalDeIdentifyContent(dlp).run();
    }
  }

  private final DlpServiceClient dlp;
  private final String projectId;
  private final String locationId;
  private final String textToRedact;

  public RegionalDeIdentifyContent(DlpServiceClient dlp) {
    this.dlp = dlp;
    projectId = System.getProperty("project_id", "");
    locationId = System.getProperty("location_id", "us");
    textToRedact = System.getProperty("text_to_redact",
        "My name is Alicia Abernathy, and my email address is aabernathy@example.com.");
  }

  private void run() {
    // https://cloud.google.com/dlp/docs/infotypes-reference
    InfoType infoType = InfoType.newBuilder().setName("EMAIL_ADDRESS").build();
    InspectConfig inspectConfig = InspectConfig.newBuilder().addInfoTypes(infoType).build();
    // Construct the configuration for the Redact request and list all desired transformations.
    DeidentifyConfig redactConfig =
        DeidentifyConfig.newBuilder()
            .setInfoTypeTransformations(
                InfoTypeTransformations.newBuilder()
                    .addTransformations(InfoTypeTransformation.newBuilder()
                        .addInfoTypes(infoType)
                        .setPrimitiveTransformation(PrimitiveTransformation.newBuilder()
                            .setRedactConfig(RedactConfig.getDefaultInstance()))))
            .build();

    DeidentifyContentRequest request =
        DeidentifyContentRequest.newBuilder()
            .setParent(LocationName.of(projectId, locationId).toString())
            .setItem(ContentItem.newBuilder().setValue(textToRedact))
            .setDeidentifyConfig(redactConfig)
            .setInspectConfig(inspectConfig)
            .build();

    System.out.println("Request:");
    System.out.println(request);
    DeidentifyContentResponse response = dlp.deidentifyContent(request);
    System.out.println("Response:");
    System.out.println(response);

    System.out.println("Text after redaction: " + response.getItem().getValue());

    /*

While executing next line, I get an error:

Error while extracting response for type [class
com.google.privacy.dlp.v2.DeidentifyContentResponse] and content type
[application/json;charset=UTF-8]


Cannot find field: sensitivityScore in message
google.privacy.dlp.v2.InfoType

*/
    request = buildDeIdentifyContentRequest(textToRedact, Arrays.asList("FIRST_NAME", "US_STATE"));
    System.out.println("Request:");
    System.out.println(request);
    response = dlp.deidentifyContent(request);
    System.out.println("Response:");
    System.out.println(response);
    System.out.println("Text after redaction: " + response.getItem().getValue());
  }

  public static DeidentifyContentRequest buildDeIdentifyContentRequest(String
      textToRedact, List<String> infoTypesList) {

    ContentItem contentItem =
        ContentItem.newBuilder().setValue(textToRedact).build();

    List<InfoType> infoTypes = new ArrayList<>();

    infoTypesList.stream().filter(Objects::nonNull).forEach(it -> {
          infoTypes.add(InfoType.newBuilder().setName(it).build()); //FIRST_NAME, US_STATE, etc.
        }
    );

    InspectConfig inspectConfig =
        InspectConfig.newBuilder().addAllInfoTypes(infoTypes).build();

// Specify replacement string to be used for the finding.

    ReplaceValueConfig replaceValueConfig =
        ReplaceValueConfig.newBuilder()
            .setNewValue(Value.newBuilder().setStringValue("******").build()).build();

    PrimitiveTransformation primitiveTransformation =

        PrimitiveTransformation.newBuilder()

            .setReplaceWithInfoTypeConfig(ReplaceWithInfoTypeConfig.getDefaultInstance())

            .setReplaceConfig(replaceValueConfig)

            .build();

    InfoTypeTransformations.InfoTypeTransformation infoTypeTransformation =

        InfoTypeTransformations.InfoTypeTransformation.newBuilder()

            .setPrimitiveTransformation(primitiveTransformation)

            .build();

    InfoTypeTransformations transformations =

        InfoTypeTransformations.newBuilder().addTransformations(infoTypeTransformation).build();

    DeidentifyConfig deidentifyConfig =

        DeidentifyConfig.newBuilder().setInfoTypeTransformations(transformations).build();

// Combine configurations into a request for the service.

    DeidentifyContentRequest request =

        DeidentifyContentRequest.newBuilder()

            .setItem(contentItem)

            .setInspectConfig(inspectConfig)

            .setDeidentifyConfig(deidentifyConfig)

            .build();

    return request;

  }
}
