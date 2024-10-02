package ma.enset.billingservice.web;

import ma.enset.billingservice.entites.Bill;
import ma.enset.billingservice.feign.CustomerRestClient;
import ma.enset.billingservice.feign.ProductItemRestClient;
import ma.enset.billingservice.model.Customer;
import ma.enset.billingservice.model.Product;
import ma.enset.billingservice.repositories.BillRepository;
import ma.enset.billingservice.repositories.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClient productItemRestClient;

    public BillingRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productItemRestClient = productItemRestClient;
    }



     @GetMapping(path="/fullBill/{id}")
    public Bill getBill(@PathVariable Long id) {
         Bill bill = billRepository.findById(id).get();
  bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerID()));
       bill.getProductItemCollection().forEach(pi->{
           Product product = productItemRestClient.getProductById(pi.getId());
           pi.setProduct(product);
       });
         return bill;


     }
}
