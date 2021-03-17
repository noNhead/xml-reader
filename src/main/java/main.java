import service.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        Service service = new Service();

        generated.Categories gCategories = new generated.Categories();

        try {
            gCategories = service.unmarshall();
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            service.marshall(gCategories);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            service.CategoriesToJson(gCategories);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            service.marshall(service.JsonToCategories());
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
