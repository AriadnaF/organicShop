package lv.tsi.javacourses.boundary;

import lv.tsi.javacourses.entity.Category;
import lv.tsi.javacourses.entity.Item;
import lv.tsi.javacourses.entity.Producer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named
public class ItemSearchForm implements Serializable{
    @PersistenceContext
    private EntityManager em;

    private String categoryItem;
    private String producerItem;

    private List<Item> searchResult;
    private List<Category> categorySearch;

    private Category category;

    @Transactional
    public void prepareCategories() {
        categorySearch = em.createQuery("select c.name from Category c").getResultList();
    }

    @Transactional
    public void doSearch() {
        /*
        Query q = em.createQuery("SELECT i FROM Item i WHERE " +
                "UPPER(i.categoryDescription) LIKE :categoryItem " +
                "AND UPPER(i.producerName) LIKE :producerItem");

        String categoryItem = "%" + getCategoryItem().toUpperCase() + "%";
        String producerItem = "%" + getProducerItem().toUpperCase() + "%";
        q.setParameter("categoryItem", categoryItem);

        q.setParameter("producerItem", producerItem);
        setSearchResult(q.getResultList());
        */
        Query q = em.createQuery("SELECT i FROM Item i WHERE " +
                "UPPER(i.category.name) LIKE :category " +
                "AND UPPER(i.producerName) LIKE :producerItem");

      //  String categoryItem = "%" + getCategoryItem().toUpperCase() + "%";
      //  String producerItem = "%" + getProducerItem().toUpperCase() + "%";
        q.setParameter("category", category);

        q.setParameter("producerItem", producerItem);
        setSearchResult(q.getResultList());
    }


    public String getCategoryItem() {
        return categoryItem;
    }

    public void setCategoryItem(String categoryItem) {
        this.categoryItem = categoryItem;
    }

    public String getProducerItem() {
        return producerItem;
    }

    public void setProducerItem(String producerItem) {
        this.producerItem = producerItem;
    }

    public List<Item> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<Item> searchResult) {
        this.searchResult = searchResult;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getCategorySearch() {
        return categorySearch;
    }

    public void setCategorySearch(List<Category> categorySearch) {
        this.categorySearch = categorySearch;
    }
}
