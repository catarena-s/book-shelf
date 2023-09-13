
package dev.shvetsova.books.client.config;

import dev.shvetsova.books.client.soap.SoapClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class BookShelfConfiguration {
    @Value("${soap.server.uri}")
    private String soapUri;
    @Value(("${wsdl.context.path}"))
    private String wsdlContextPath;

    // автоматическая генерация классов в XML и обратно (маршалинг, демаршалинг)
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(wsdlContextPath); // где находятся сгенерированные Java классы
        return marshaller;
    }

    // клиент для вызова SOAP сервисов
    @Bean
    public SoapClient booksClient(Jaxb2Marshaller marshaller) {
        SoapClient client = new SoapClient();
        client.setDefaultUri(soapUri); // адрес веб сервиса
        client.setMarshaller(marshaller); // преобразователь XML-POJO и обратно
        client.setUnmarshaller(marshaller);
        return client;
    }

}
