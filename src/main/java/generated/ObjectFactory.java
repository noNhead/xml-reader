//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.03.17 at 11:41:38 AM GMT+04:00 
//


package generated;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Categories }
     * 
     */
    public Categories createCategories() {
        return new Categories();
    }

    /**
     * Create an instance of {@link Categories.Category }
     * 
     */
    public Categories.Category createCategoriesCategory() {
        return new Categories.Category();
    }

    /**
     * Create an instance of {@link Categories.Category.Subcategory }
     * 
     */
    public Categories.Category.Subcategory createCategoriesCategorySubcategory() {
        return new Categories.Category.Subcategory();
    }

    /**
     * Create an instance of {@link Categories.Category.Subcategory.Product }
     * 
     */
    public Categories.Category.Subcategory.Product createCategoriesCategorySubcategoryProduct() {
        return new Categories.Category.Subcategory.Product();
    }

}