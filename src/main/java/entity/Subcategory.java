package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "subcategory")
public class Subcategory {
    @JsonValue
    private List<Product> products;
    @JsonProperty("title")
    private String title;

    public Subcategory(List<Product> products, String title) {
        this.products = products;
        this.title = title;
    }

    public Subcategory() {
    }

    public List<Product> getProducts() {
        return products;
    }

    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getTitle() {
        return title;
    }

    @XmlAttribute
    public void setTitle(String title) {
        this.title = title;
    }
}
