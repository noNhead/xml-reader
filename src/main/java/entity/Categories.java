package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@JsonTypeName("Category")
@XmlRootElement(name = "categories")
public class Categories {

    @JsonProperty("categories")
    private List<Category> categories;

    public Categories(List<Category> categories) {
        this.categories = categories;
    }

    public Categories() {
    }

    public List<Category> getCategories() {
        return categories;
    }


    @XmlElement(name = "category")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
