
  package com.mycompany.app.api_tests;

  import com.intuit.karate.Results;
  import com.intuit.karate.Runner;
  // import com.intuit.karate.http.HttpServer;
  // import com.intuit.karate.http.ServerConfig;
  import org.junit.jupiter.api.Test;

  import static org.junit.jupiter.api.Assertions.assertEquals;

  class ApiCredentialregisterWallet100ResolvedTest {

      @Test
      void testAll() {
          String apiHostServer = System.getenv().getOrDefault("CREDENTIAL_WALLET_URL_BASE", "https://dev.roost.ai/api/");
          Results results = Runner.path("src/test/java/com/mycompany/app/api_tests/ApiCredentialregisterWallet100Resolved")
                  .systemProperty("CREDENTIAL_WALLET_URL_BASE", apiHostServer)
                  .reportDir("testReport").parallel(1);
          assertEquals(0, results.getFailCount(), results.getErrorMessages());
      }

  }
