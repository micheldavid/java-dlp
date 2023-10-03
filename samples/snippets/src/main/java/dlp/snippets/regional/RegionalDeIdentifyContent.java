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
import java.io.IOException;

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
  }
}
