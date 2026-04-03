package com.project.code.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.code.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
    public Customer findByEmail(String email);

//    - **findById**:
//      - This method will allow you to find a customer by their ID.
//      - Return type: Customer
//      - Parameter: Long id
      
    public Customer findById(Long id);

// 3. Add any additional methods you may need for custom queries:
//    - You can create other query methods as needed, like finding customers by name or phone number, etc.

// Example: public List<Customer> findByName(String name);
    public List<Customer> findByName(String name);

// 4. Add @Repository annotation:
//    - Mark the interface with @Repository to indicate that it's a Spring Data JPA repository.
//    - This annotation is optional if you extend JpaRepository, as Spring Data automatically registers the repository, but it's good practice to add it for clarity.


    
}


