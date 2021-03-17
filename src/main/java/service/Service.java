package service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLStreamException;
import java.io.*;

public class Service {
    StaxReader staxReader = new StaxReader();

    public void marshall(generated.Categories categories) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(generated.Categories.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(categories, new File("src/main/resources/generated/xml/categories.xml"));
    }

    public generated.Categories unmarshall() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(generated.Categories.class);
        return (generated.Categories) context.createUnmarshaller().unmarshal(new FileReader("src/main/resources/categories.xml"));
    }

    public generated.Categories documentReaderWithStax() {
        try {
            return staxReader.staxReader();
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void CategoriesToJson(generated.Categories categories) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.writeValue(new File("src/main/resources/generated/json/categories.json"), categories);

    }

    public generated.Categories JsonToCategories() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(new File("src/main/resources/generated/json/categories.json"), generated.Categories.class);
    }

}
