package lv.tsi.javacourses.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false,unique = true)
    private String code;
    @Column(nullable = false,length = 1000)
    private String description;

    @OneToOne
    private Category category;
    @Column
    private BigDecimal price;
    @Column
    private Long producer_ID;
    @Column
    private  String producerName;



    public String getProducerName() {
        return producerName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getProducer_ID() {
        return producer_ID;
    }

    public void setProducer_ID(Long producer_ID) {
        this.producer_ID = producer_ID;
    }
}
