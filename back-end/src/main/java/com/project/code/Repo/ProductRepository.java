package com.project.code.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.code.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

// 2. Add custom query methods:
//    - **findAll**:
//      - This method will retrieve all products.
//      - Return type: List<Product>

    public List<Product> findAll();

//    - **findByCategory**:
//      - This method will retrieve products by their category.
//      - Return type: List<Product>
//      - Parameter: String category

    public List<Product> findByCategory(String category);

//    - **findByPriceBetween**:
//      - This method will retrieve products within a price range.
//      - Return type: List<Product>
//      - Parameters: Double minPrice, Double maxPrice

    public List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

//    - **findBySku**:
//      - This method will retrieve a product by its SKU.
//      - Return type: Product
//      - Parameter: String sku

    public Product findBySku(String sku);

//    - **findByName**:
//      - This method will retrieve a product by its name.
//      - Return type: Product
//      - Parameter: String name

    public Product findByName(String name);

//    - **findByNameLike**:
//      - This method will retrieve products by a name pattern for a specific store.
//      - Return type: List<Product>
//      - Parameters: Long storeId, String pname
//      - Use @Query annotation to write a custom query.
    @Query("SELECT i.product FROM Inventory i WHERE i.store.id = :storeId AND i.product.category = :category")
    public Product findByNameLike(Long storeID, String pname);
    
    @Query("SELECT i.product FROM Inventory i WHERE i.store.id = :storeId AND i.product.category =:category")
    public List<Product> findByCategoryAndStoreID(Long storeId,String category);

    @Query("SELECT i FROM Product i WHERE LOWER(i.name) LIKE LOWER(CONCAT('%', :pname, '%'))")
    public List<Product> findProductBySubName(String pname);

    @Query("SELECT i.product FROM Inventory i WHERE i.store.id = :storeId")
    public List<Product> findProductsByStoreId(Long storeId);

    @Query("SELECT i.product FROM Inventory i WHERE i.product.category = :category and i.store.id= :storeId")
    public List<Product> findProductByCategory(String category, Long storeId);

    @Query("SELECT i FROM Product i WHERE LOWER(i.name) LIKE LOWER(CONCAT('%', :pname, '%')) ANDi.category = :category")
    public List<Product> findProductBySubNameAndCategory(String pname, String category);
}
