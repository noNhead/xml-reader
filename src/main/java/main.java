import entity.Categories;
import entity.Category;
import entity.Product;
import entity.Subcategory;
import service.Service;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Service service = new Service();

        /*Product product = new Product(
                "aa111",
                "manufacturer",
                LocalDate.now(),
                "#000000",
                10000,
                10);

        Product product1 = new Product(
                "ab111",
                "manufacturer",
                LocalDate.now(),
                "#000001",
                10000,
                10);

        Product product2 = new Product(
                "ac111",
                "manufacturer",
                LocalDate.now(),
                "#000000",
                10000,
                10);


        Subcategory subcategory = new Subcategory(new ArrayList<>(), "title1");
        Subcategory subcategory1 = new Subcategory(new ArrayList<>(), "title2");
        Subcategory subcategory2 = new Subcategory(new ArrayList<>(), "title3");

        subcategory.getProducts().add(product);
        subcategory.getProducts().add(product1);
        subcategory1.getProducts().add(product1);
        subcategory2.getProducts().add(product2);

        Category category = new Category(new ArrayList<>(), "title");
        category.getSubcategories().add(subcategory);
        category.getSubcategories().add(subcategory1);
        category.getSubcategories().add(subcategory2);

        Categories categories = new Categories(new ArrayList<>());
        categories.getCategories().add(category);
        categories.getCategories().add(category);

        try {
            service.documentCreator(categories);
        } catch (ParserConfigurationException | TransformerException | JAXBException e) {
            e.printStackTrace();
        }




        try {
            service.documentCreator(service.documentReaderWithStax());
        } catch (JAXBException e) {
            e.printStackTrace();
        }


        try {
            service.xmlToJsonConverterWithJackson();
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
*/
        try {
            service.jsonToXmlConverter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
