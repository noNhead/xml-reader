package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "category")
public class Category {
    @JsonValue
    private List<Subcategory> subcategories;
    @JsonProperty("title")
    private String title;

    public Category(List<Subcategory> subcategories, String title) {
        this.subcategories = subcategories;
        this.title = title;
    }

    public Category() {
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    @XmlElementWrapper(name = "subcategories")
    @XmlElement(name = "subcategory")
    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    public String getTitle() {
        return title;
    }

    @XmlAttribute
    public void setTitle(String title) {
        this.title = title;
    }
}
