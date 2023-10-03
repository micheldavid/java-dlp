package dlp.snippets.regional;

import static java.util.Collections.singletonList;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.services.iamcredentials.v1.IAMCredentials;
import com.google.api.services.iamcredentials.v1.IAMCredentialsScopes;
import com.google.api.services.iamcredentials.v1.model.GenerateAccessTokenRequest;
import com.google.api.services.iamcredentials.v1.model.GenerateAccessTokenResponse;
import com.google.auth.Credentials;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import javax.annotation.Nullable;

public class AppCredentialProvider implements CredentialsProvider {

  private final GoogleCredentials defaultCreds;
  private final String serviceAccount;
  @Nullable
  private final IAMCredentials iamCredsService;

  public AppCredentialProvider() throws Exception {
    try {
      defaultCreds =
          GoogleCredentials.getApplicationDefault().createScoped(
              Collections.singleton(IAMCredentialsScopes.CLOUD_PLATFORM));
    } catch (IOException ex) {
      throw new Exception("Run this first: gcloud auth application-default login", ex);
    }
    serviceAccount = System.getProperty("service_account", "");
    if (serviceAccount.isEmpty()) {
      iamCredsService = null;
    } else {
      iamCredsService =
          new IAMCredentials.Builder(
              GoogleNetHttpTransport.newTrustedTransport(),
              JacksonFactory.getDefaultInstance(),
              new HttpCredentialsAdapter(defaultCreds))
              .setApplicationName("dlp-test")
              .build();
    }
  }

  @Override
  public Credentials getCredentials() throws IOException {
    if (iamCredsService == null) {
      return defaultCreds;
    }
    // https://cloud.google.com/iam/docs/reference/credentials/rest/v1/projects.serviceAccounts/generateAccessToken
    GenerateAccessTokenResponse response = iamCredsService.projects().serviceAccounts()
        .generateAccessToken(
            "projects/-/serviceAccounts/" + serviceAccount,
            new GenerateAccessTokenRequest().setScope(
                singletonList(IAMCredentialsScopes.CLOUD_PLATFORM)).setLifetime("600s")).execute();
    String accessToken = response.getAccessToken();
    String expireTime = response.getExpireTime();
    System.out.println("Got a token for service account " + serviceAccount);
    return GoogleCredentials.create(
        new AccessToken(accessToken, Date.from(Instant.parse(expireTime))));
  }
}
