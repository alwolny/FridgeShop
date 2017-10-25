package pl.awolny.model;

import java.math.BigDecimal;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_entity")
public class Product {
	
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

	
	public Product(){}

	public Product(String name, String brand, byte[] image, String description, String manufacturer, String category,
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

	public Product(long productId, String name, BigDecimal unitPrice, String description, String manufacturer,
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
	}
	
	public Product(String name, BigDecimal unitPrice) {
		this.name = name;
		this.unitPrice = unitPrice;
	}
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProd_condition() {
		return prod_condition;
	}

	public void setProd_condition(String prod_condition) {
		this.prod_condition = prod_condition;
	}
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return UnitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		UnitsInStock = unitsInStock;
	}

	public long getUnitsInOrder() {
		return UnitsInOrder;
	}

	public void setUnitsInOrder(long unitsInOrder) {
		UnitsInOrder = unitsInOrder;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (UnitsInOrder ^ (UnitsInOrder >>> 32));
		result = prime * result + (int) (UnitsInStock ^ (UnitsInStock >>> 32));
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((prod_condition == null) ? 0 : prod_condition.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (discontinued ? 1231 : 1237);
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (productId ^ (productId >>> 32));
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (UnitsInOrder != other.UnitsInOrder)
			return false;
		if (UnitsInStock != other.UnitsInStock)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (prod_condition == null) {
			if (other.prod_condition != null)
				return false;
		} else if (!prod_condition.equals(other.prod_condition))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discontinued != other.discontinued)
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (productId != other.productId)
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", unitPrice=" + unitPrice + ", description="
				+ description + ", manufacturer=" + manufacturer + ", category=" + category + ", UnitsInStock="
				+ UnitsInStock + ", UnitsInOrder=" + UnitsInOrder + ", discontinued=" + discontinued + ", prod_condition="
				+ prod_condition + "]";
	}
}