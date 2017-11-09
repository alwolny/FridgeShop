package pl.awolny.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="products")
public class Product implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	private String name;
	private String brand;
	private byte[] image;
	private String description;
	private String manufacturer;
	private String category;
	private long UnitsInStock;
	private long UnitsInOrder;
	private boolean discontinued;
	private String prod_condition;
	private BigDecimal unitPrice;

	

/*	public Product(String name, String brand, byte[] image, String description, String manufacturer, String category,
			long unitsInStock, long unitsInOrder, boolean discontinued, String prod_condition, BigDecimal unitPrice) {
		this.name = name;
		this.brand = brand;
		this.image = image;
		this.description = description;
		this.manufacturer = manufacturer;
		this.category = category;
		UnitsInStock = unitsInStock;
		UnitsInOrder = unitsInOrder;
		this.discontinued = discontinued;
		this.prod_condition = prod_condition;
		this.unitPrice = unitPrice;
	}
*/
/*	public Product(long productId, String name, BigDecimal unitPrice, String description, String manufacturer,
			String category, long unitsInStock, long unitsInOrder, boolean discontinued, String prod_condition) {
		this.productId = productId;
		this.name = name;
		this.unitPrice = unitPrice;
		this.description = description;
		this.manufacturer = manufacturer;
		this.category = category;
		UnitsInStock = unitsInStock;
		UnitsInOrder = unitsInOrder;
		this.discontinued = discontinued;
		this.prod_condition = prod_condition;
	}*/
	
/*	public Product(String name, BigDecimal unitPrice) {
		this.name = name;
		this.unitPrice = unitPrice;
	}*/
}