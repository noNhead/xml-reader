package service;

import entity.Categories;
import entity.Category;
import entity.Product;
import entity.Subcategory;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class StaxReader {
    private final String PATH = "categories.xml";
    public Categories staxReader() throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(PATH));

        Categories categories = new Categories();
        Category category = new Category();
        Subcategory subcategory = new Subcategory();
        Product product = new Product();

        while (reader.hasNext()){
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case "categories":
                        categories.setCategories(new ArrayList<>());
                        break;
                    case "category":
                        category.setTitle(startElement.getAttributeByName(QName.valueOf("title")).getValue());
                        break;
                    case "subcategories":
                        category.setSubcategories(new ArrayList<>());
                        break;
                    case "subcategory":
                        subcategory.setTitle(startElement.getAttributeByName(QName.valueOf("title")).getValue());
                        break;
                    case "products":
                        subcategory = new Subcategory();
                        subcategory.setProducts(new ArrayList<>());
                        break;
                    case "product":
                        product = new Product();
                        break;
                    case "manufacturer":
                        nextEvent = reader.nextEvent();
                        product.setManufacturer(nextEvent.asCharacters().getData());
                        break;
                    case "model":
                        nextEvent = reader.nextEvent();
                        product.setModel(nextEvent.asCharacters().getData());
                        break;
                    case "dateOfManufacture":
                        nextEvent = reader.nextEvent();
                        product.setDateOfManufacture(
                                LocalDate.parse(nextEvent.asCharacters().getData(),
                                        DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                        break;
                    case "color":
                        nextEvent = reader.nextEvent();
                        product.setColor(nextEvent.asCharacters().getData());
                        break;
                    case "price":
                        nextEvent = reader.nextEvent();
                        product.setPrice(Long.parseLong(nextEvent.asCharacters().getData()));
                        break;
                    case "quantityInStock":
                        nextEvent = reader.nextEvent();
                        product.setQuantityInStock(Long.parseLong(nextEvent.asCharacters().getData()));
                        break;
                }
            }
            if(nextEvent.isEndElement()){
                EndElement endElement = nextEvent.asEndElement();
                switch (endElement.getName().getLocalPart()) {
                    case "product":
                        subcategory.getProducts().add(product);
                        break;
                    case "products":
                        category.getSubcategories().add(subcategory);
                        break;
                    case "subcategories":
                        categories.getCategories().add(category);
                        break;
                }
            }
        }
    return categories;
    }
}
