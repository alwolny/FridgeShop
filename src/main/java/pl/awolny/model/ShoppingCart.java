package pl.awolny.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="shopping_carts")
public class ShoppingCart implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private long id;
	
	@OneToMany(cascade = {CascadeType.ALL})
	//@JoinColumn(name = "id_cart", referencedColumnName="cart_id")
	private List<CartItem> items;


	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", items=" + items + "]";
	}


	public ShoppingCart() {
		this.items = new LinkedList<>();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}