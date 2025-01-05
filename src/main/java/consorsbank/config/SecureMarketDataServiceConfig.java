package consorsbank.config;

import consorsbank.services.SecureMarketDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecureMarketDataServiceConfig {

    @Bean
    public SecureMarketDataConfig secureMarketDataConfig() {
        return new SecureMarketDataConfig(
                "localhost", // Beispielhost
                40443, // Beispielport
                "-----BEGIN CERTIFICATE-----\n"
                        + "MIIDHDCCAgSgAwIBAgIJAJl/VY/LhDO7MA0GCSqGSIb3DQEBCwUAMDUxCzAJBgNV\n"
                        + "BAYTAkRFMRIwEAYDVQQHEwlOdWVybmJlcmcxEjAQBgNVBAMTCWxvY2FsaG9zdDAe\n"
                        + "Fw0yNTAxMDUwMzI3NTFaFw0yNzAxMDUwMzI3NTFaMDUxCzAJBgNVBAYTAkRFMRIw\n"
                        + "EAYDVQQHEwlOdWVybmJlcmcxEjAQBgNVBAMTCWxvY2FsaG9zdDCCASIwDQYJKoZI\n"
                        + "hvcNAQEBBQADggEPADCCAQoCggEBAKxMakA7wRuU+g+80Ja+iW9RVMRFX3E+vY4O\n"
                        + "Cm8ot2jXI+llyzNjbU6RaDmUhMIcepmdwfRDPlFhLKM/cznPFGsKfaJtBLhyGQT1\n"
                        + "Vo75wN4xEfs+egB5qXpDxqO/cZu0CeMajE5A//szZ4jNqtgXOmRxI76bSMpBhhyt\n"
                        + "1jNgycx45GEd5eikHscqv44pFAdpCjlmtJeLpXrZCvQrE/8vzkAH6PMucnSBG9Pm\n"
                        + "izig2YN1JO1F3PW1xU8KlJEFGrHT0wH7iVbLxnyO+825hvGOYfP6Ga7DHPiWZT+R\n"
                        + "ypCi8vwhIhKyCwI8RRvZUfX47igMrD4bXBO2K7tpjvSjwEbDOJUCAwEAAaMvMC0w\n"
                        + "DAYDVR0TBAUwAwEB/zAdBgNVHQ4EFgQUrsnaPFzvEdo3YvEV3BKHMpfkb+IwDQYJ\n"
                        + "KoZIhvcNAQELBQADggEBADzRA6DdLgemJoTjgAKuzTppkRVHSYSVGjBy7gjOcmA+\n"
                        + "Bgm6ulj+oiYc7kGFMdAp+ycObvgkCrfWWoZ3cwMhUsQ49eZg4LtO13Q0zTESOIud\n"
                        + "MDqbajoze70H0Y6lprTBYQuD5AWgrbROjw+FI0eqQ5haD+VxM9KS/PK8yhDdw5mZ\n"
                        + "Kn3FWP6tnjZHDms+6cNjqJC4vg5DM+9VZIG2UZxt4ZHbH3zwywtDpSCeiTj4gy4F\n"
                        + "U+qYsyZQuM0R4uSWhzEgrjbH67AVmMzagIdvVSQmgYuQoO9qGjrx8ZrQ+uh1/gd+\n"
                        + "tRTBL9gYd5XfXXagZ9DXPrsRUWtRifwpOTm4LusncgQ=\n"
                        + "-----END CERTIFICATE-----"
        );
    }
}
