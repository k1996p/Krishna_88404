package productorm01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.assignment.ecomapp.dao.ProductDao;
import com.assignment.ecomapp.modal.Product;


public class ProductDaoTest {


	private Product product;
	private ProductDao productDao;
	@BeforeEach()
	public void beforeEach() {
		product=new Product(2,"nike-Shoe",200.00);
		productDao=new ProductDao();
	}
	
	@Test
	public void testCreateBook() {
		Assertions.assertTrue(productDao.createNew(product));
	}
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(productDao.findAll());
	}
	
	@Test
	public void testFindOneNotNull() {
		product=productDao.findOne(4);
		Assertions.assertNotNull(product);
		System.out.println("id=4 |"+product);
	}
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(productDao.findOneandDelete(6));
	}
	
	@Test
	public void testFindOneAndUpdate() {
		product.setpName("wrong-shoe");
		Assertions.assertTrue(productDao.findOneandUpdate(7, product));
	}
}
