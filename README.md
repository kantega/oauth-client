# Les meg først
Innholdet i dette prosjektet er i utgangspunktet spesifisert for en intern workshop i Kantega, for det formålet å demonstrere implementasjonen av Vipps pålogging.
For informasjon om Vipps pålogginsløsning, se [Vipps Login API](https://github.com/vippsas/vipps-login-api/blob/master/vipps-login-api.md).

Løsningen presenterer en minimalistisk Spring Boot-applikasjon, der all OAuth2-logikk blir håndtert av Spring Security,
og der konfigurasjonsdata i 'application.yaml' står sentralt i implementeringen av en generisk OAuth2-klient.
Applikasjonen utnytter dessuten Vipps implementasjon av OpenID Connect via Spring Securitys automatiserte kall til Vipps UserInfo-endepunkt,
ved spesifiseringen av relaterte nøkkelord i OAuth2s 'scope'-parameter.   

# Kom i gang

For å kunne benytte applikasjonen, må du ha tilgang til Vipps API, hvor to sentrale miljøvariable må spesifiseres:

* VIPPS_CLIENT_ID
* VIPPS_CLIENT_SECRET

Du kan aktivere Vipps login ved å følge [denne dokumentasjonen](https://github.com/vippsas/vipps-login-api/blob/master/vipps-login-api-faq.md#how-can-i-activate-and-set-up-vipps-login).

For Kantegas spesifikke workshop har vi allerede laget tilgang til produksjonsendepunktene, og du vil få utlevert detaljer der. 

## Callback/Redirect URI

Dersom ingenting er spesifisert, vil oauth-klienten spesifisere en adresse som Vipps kan kalle tilbake til etter følgende mønster:
{baseUrl}/login/oauth2/code/{registrationID}, hvor 'baseUrl' inkluderer applikasjonens lokasjon og portnummer, og {registrationId} er oauth-tilbyderens unike konfigurasjonsverdi (i dette tilfellet vipps-login).
Vipps krever at man forhåndsregistrerer (hvitelister) gyldige tilbakekallingsadresser. Pass på at du enten spefisiserer en adresse etter dette mønsteret,
eller at du overstyrer denne mekanismen i applikasjonen (både i konfigurasjonsfilen og i konfigurasjonsklassen). 

# Andre referanser

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.0/reference/htmlsingle/#boot-features-developing-web-applications)
* [OAuth2 Client](https://docs.spring.io/spring-boot/docs/2.4.0/reference/htmlsingle/#boot-features-security-oauth2-client)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

