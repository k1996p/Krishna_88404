package com.assignment.ecomapp.test.modal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.assignment.ecomapp.dao.ProductDao;
import com.assignment.ecomapp.modal.Product;

public class ProductDaoTest {

	public static ProductDao productDao;
	public Product product;
	public List<Product> products;

	@BeforeAll
	public static void beforeAll() {
		productDao = new ProductDao();
	}

	@BeforeEach
	public void beforeEach() {
		product = new Product(1, 3, "nike-shoe", 700);
		products = new ArrayList<>();
		products.add(new Product(1, 3, "nike-shoe", 700));
		products.add(new Product(2, 3, "adidas-shoe", 700));
		products.add(new Product(3, 3, "bata-shoe", 700));
	}

	@Disabled
	@Test
	public void testBookDaoNotNull() {
		Assertions.assertNotNull(productDao);
	}

	@Test
	public void testFindOne() {
		try {
			Assertions.assertEquals(productDao.findOne(1), product, "Expected Product(1,3,'nike-shoe',700)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Disabled
	@Test
	public void testFindAll() {
		try {
			Assertions.assertEquals(productDao.findAll(), products, "Expected " + products);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Disabled
	@Test
	public void testFindOneAndDeleteReturnsTrue() {
		try {
			Assertions.assertTrue(productDao.findOneAndDelete(3), "Expeted product of id 4 must be deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Disabled
	@Test
	public void testFindOneAndDeleteReturnsFalse() {
		try {
			Assertions.assertFalse(productDao.findOneAndDelete(4),
					"Expeted product of id 4 not exist hence returns false");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Disabled
	@Test
	public void testFindOneAndUpdateTrue() {
		final Product updateProduct = new Product(2, 7, "adidas-shoe", 700);
		try {
			Assertions.assertTrue(productDao.findOneAndUpdate(2, updateProduct), "Product 2 is updated ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Disabled
	@Test
	public void testFindOneAndUpdateFalse() {
		final Product updateProduct = new Product(8, 7, "adidas-shoe", 700);
		try {
			Assertions.assertFalse(productDao.findOneAndUpdate(4, updateProduct),
					"Should return false as Product 8 doesn't exist ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Disabled
	@Test
	public void testCreateNewTrue() {
		final Product updateProduct = new Product(8, 7, "adidas-shoe", 700);
		try {
			Assertions.assertTrue(productDao.createNew(updateProduct));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Disabled
	@Test
	public void testCreateNewThrowsNullPointerException() {
		final Product newProduct = null;

		NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
			productDao.createNew(newProduct);
		}, "NullpointerException was expected");

		Assertions.assertEquals("For input string: \"One\"", thrown.getMessage());

	}

	@AfterEach
	public void afterEach() {
		product = null;
	}

	@AfterAll
	public static void afterAll() {
		productDao = null;
	}

}
