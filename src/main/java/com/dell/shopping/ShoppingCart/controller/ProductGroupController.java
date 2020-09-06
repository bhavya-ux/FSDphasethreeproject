package com.dell.shopping.ShoppingCart.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dell.shopping.ShoppingCart.repository.ProductGroupRepository;
import com.dell.shopping.ShoppingCart.model.Admin;
import com.dell.shopping.ShoppingCart.model.productgroup;

@RestController
@RequestMapping("/shoppingcart/api")
public class ProductGroupController {
    @Autowired
	ProductGroupRepository prodRepo;
    
    @GetMapping("/productgroup")
    public List<productgroup> getAllproductgroup()
    {
		return prodRepo.findAll();
    	
    }
    @PostMapping("/productgroup")
    public productgroup addproductgroup(@RequestBody productgroup pg)
    {
   	 return prodRepo.save(pg);
		    	 
    }
    @PutMapping("/productgroup")
    public productgroup updateAdmin(@RequestBody productgroup pg)
    {
   	 //Find Operation
     Optional<productgroup> opProdGrp =prodRepo.findById(pg.getproductgroupId()); 
   	 //update operation
     productgroup 	fetchedProdGrp=opProdGrp.get();
     fetchedProdGrp.setproductgroupName(pg.getproductgroupName());
   	 return prodRepo.save(fetchedProdGrp);
   	 
    }
    
    @GetMapping("/productgroup/{id}")
    public productgroup getOneproductgroup(@PathVariable(value="id") Long adminId)
    {
   	 //Find Operation
   	 Optional<productgroup> opProdGrp =prodRepo.findById(adminId);  
		 return opProdGrp.get();
   	 
    }
    
    @DeleteMapping("/productgroup/{id}")
    public ResponseEntity<?> deleteOneproductgroup(@PathVariable(value="id") Long pgId)
    {
    	prodRepo.deleteById(pgId);
   	    return ResponseEntity.ok().build();
   	 
    }
}
