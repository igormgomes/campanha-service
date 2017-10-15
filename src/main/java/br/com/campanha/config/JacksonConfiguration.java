package br.com.campanha.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfiguration {

    @Autowired
    private Jackson2ObjectMapperBuilder builder;

    @PostConstruct
    public void postConstruct () {
        this.builder
                .serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .deserializers(new LocalDateDeserializer(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .serializationInclusion(JsonInclude.Include.NON_EMPTY);
    }
}
