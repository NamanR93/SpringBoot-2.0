package in.sb.myapp3.service;

import in.sb.myapp3.models.Product;
import in.sb.myapp3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

//    List<Product> products = new ArrayList<>(Arrays.asList(new Product(101,"Iphone",50),
//                                            new Product(102,"canon cam", 10)));

      // READ ALL
//    public List<Product> getProducts(){
//            return products;
//    }
    public List<Product> getProducts(){
                return productRepository.findAll();
        }

      // READ ONE
//    public Product getProductById(int prodId) {
//
//        return products.stream()
//                .filter(p -> p.getProdId() == prodId)
//                .findFirst().orElse(new Product(100,"No Item", 0));
//    }
    public Product getProductById(int prodId) {

        return productRepository.findById(prodId).orElse(new Product());
    }

     // CREATE
//    public void addProduct(Product prod) {
//
//         products.add(prod);
//    }
    public void addProduct(Product prod) {

        productRepository.save(prod);
    }

    // UPDATE
//    public void updateProduct(Product prod) {
//
//        int index = 0;
//        for(int i =0;i<products.size();i++){
//            if(products.get(i).getProdId()== prod.getProdId()){
//                index = i;
//                products.set(index,prod);
//            }
//        }
//    }
    public void updateProduct(Product prod) {

        productRepository.save(prod);
    }

    // DELETE
//    public void deleteProduct(int prodId) {
//
//        int index = 0;
//        for(int i =0;i<products.size();i++){
//            if(products.get(i).getProdId()== prodId){
//                index = i;
//                products.remove(index);
//            }
//        }
//    }

    public void deleteProduct(int prodId) {
        productRepository.deleteById(prodId);
    }
}
