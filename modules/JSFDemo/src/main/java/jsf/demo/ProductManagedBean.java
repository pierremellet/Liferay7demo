package jsf.demo;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import org.primefaces.PrimeFaces;
import servicebuilderdemo.model.Product;
import servicebuilderdemo.service.ProductLocalServiceUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "productManagedBean")
@SessionScoped
public class ProductManagedBean {

    private String productName;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public List<Product> getProducts(){
        return ProductLocalServiceUtil.getProducts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    public void saveProduct(){
        final Product product = ProductLocalServiceUtil.createProduct(CounterLocalServiceUtil.increment(Product.class.getName()));
        product.setProductName(this.getProductName());
        ProductLocalServiceUtil.addProduct(product);
        final PrimeFaces current = PrimeFaces.current();
        current.executeScript("PF('editView').hide();");
    }

    public void deleteProduct(Product p){
        ProductLocalServiceUtil.deleteProduct(p);
    }
}
