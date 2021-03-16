package service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import config.LocalDateAdapterForGson;
import entity.Categories;
import entity.Category;
import entity.Product;
import entity.Subcategory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Service {
    StaxReader staxReader = new StaxReader();

    public void documentCreator(Categories categories) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Categories.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(categories, new File("src/main/resources/categories.xml"));
    }

    public Categories documentReaderWithStax() {
        try {
            return staxReader.staxReader();
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void jsonToXmlConverter() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Categories categories = jsonMapper.readValue(new String(Files.readAllBytes(Paths.get("src/main/resources/categories.json"))), Categories.class);
        System.out.println(categories.getCategories().size());
    }

    public void jsonToXmlConverterWithGson() throws IOException {
        Gson gson = new Gson();
        System.out.println(new String(Files.readAllBytes(Paths.get("src/main/resources/categories.json"))));
        Type categoryType = new TypeToken<Collection<Category>>(){}.getType();
        Type subcategoryType = new TypeToken<Collection<Subcategory>>(){}.getType();
        Type productType = new TypeToken<Collection<Product>>(){}.getType();
        //gson.adapter

        Categories categories = gson.fromJson(new String(Files.readAllBytes(Paths.get("src/main/resources/categories.json"))), Categories.class);
        System.out.println(categories.getCategories().size());
    }

    public void xmlToJsonConverterWithJackson() throws IOException, XMLStreamException {
        Categories categories = staxReader.staxReader();
        System.out.println(categories.getCategories().size());
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.writeValue(new File("src/main/resources/categories.json"), categories);

    }
}
