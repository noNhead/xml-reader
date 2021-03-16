package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import config.LocalDateAdapter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@JsonPropertyOrder({"manufacturer", "model", "dateOfManufacture", "color", "price", "quantityInStock"})
@XmlRootElement(name = "product")
@XmlType(propOrder = {"manufacturer", "model", "dateOfManufacture", "color", "price", "quantityInStock"})
public class Product {
    @JsonProperty("model")
    private String model;
    @JsonProperty("manufacturer")
    private String manufacturer;
    @JsonProperty("dateOfManufacture")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfManufacture;
    @JsonProperty("color")
    private String color;
    @JsonProperty("price")
    private long price;
    @JsonProperty("quantityInStock")
    private long quantityInStock;

    public Product(String model, String manufacturer, LocalDate dateOfManufacture, String color, long price, long quantityInStock) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.dateOfManufacture = dateOfManufacture;
        this.color = color;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public Product() {
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(long quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
