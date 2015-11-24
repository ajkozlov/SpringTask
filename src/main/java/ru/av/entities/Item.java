package ru.av.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Items")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String article;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    private String title;
    private String description;
    private Integer quantity;
    private Double price;

    public Item() {
    }

    public Item(String article, Category category, String title, String description, Integer quantity, Double price) {
        this.article = article;
        this.category = category;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "aaa";
    }
}
