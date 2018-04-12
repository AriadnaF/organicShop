package lv.tsi.javacourses.boundary;

import lv.tsi.javacourses.entity.Category;
import lv.tsi.javacourses.entity.Item;
import lv.tsi.javacourses.entity.Producer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
    private Long categoryId;

    @Transactional
    public void prepareCategories() {
        categorySearch = em.createQuery("select c from Category c").getResultList();
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
        TypedQuery<Item> q = em.createQuery("SELECT i FROM Item i WHERE " +
        "i.category.id = :categoryId", Item.class);
        q.setParameter("categoryId",categoryId);
        List<Item> resultList = q.getResultList();
        setSearchResult(resultList);
        if (resultList.isEmpty()) {
            System.out.println("Nothing is found");
        }

    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
