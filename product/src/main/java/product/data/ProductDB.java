package product.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import product.modal.Product;


@Repository
public class ProductDB {
	JdbcTemplate jdbc;
	@Autowired
	public ProductDB(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public Iterable<Product> findAll(){
		String sql = "select * from products";
		return jdbc.query(sql, this::mapRowToProduct);
	}
	
	public Product findByCode(String code) {
		String sql = "select * from products where code = " + code;
		try {
			return jdbc.queryForObject(sql, this::mapRowToProduct);
		} catch (Exception e) {
			return null;
		}
	}
	public Product save(Product product) {
		String sql = "insert into products (code, description, price) values (?,?,?)"; 
		jdbc.update(sql,product.getCode(), product.getDescription(), product.getPrice());
		return product;
	}
	
	public Product update(Product product) {
		String sql = "update products set description = ?, price = ? where code = ?";
		jdbc.update(sql, product.getDescription(), product.getPrice(), product.getCode());
		return product;
	}
	
	public void delete(String code) {
		String sql = "delete from products where code= ?";
		jdbc.update(sql, code);
	}
	
	private Product mapRowToProduct(ResultSet rs, int row) throws SQLException{
		return new Product(rs.getString("code"), rs.getString("description"), rs.getDouble("price"));
	}
}
