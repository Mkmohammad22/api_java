package com.api.entity;
import jakarta.persistence.*;
//import jakarta.xml.bind.annotation.XmlAttribute;


/**
 * ProductCategory
 */

@Entity
@Table(name = "Book")
public class Book {

	
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  @Column
  private String name;
  @Column
  private int price;
  
  @Column(unique=true)
  
  private String description;
  

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  
  public String getDescription() {
	    return description;
	  }
	  public void setDescription(String description) {
	    this.description = description;
	  }
  
}


