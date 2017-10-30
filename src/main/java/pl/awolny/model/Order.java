package pl.awolny.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity
@Table(name="orders")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private User user;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<CartItem> orderItems;
    @Version
    @Type(type = "dbtimestamp")
    private Timestamp purchaseTime;
	private BigDecimal total;
    
    public Timestamp getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(Timestamp purchaseTime) {
		this.purchaseTime = purchaseTime;
	}  
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<CartItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<CartItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Order(User user, List<CartItem> orderItems, BigDecimal total) {
		this.orderItems = new LinkedList<>();
		this.user = user;
		this.orderItems = orderItems;
		this.total = total;
	}    
    public Order(){
    	this.orderItems = new LinkedList<>();
    	this.total = new BigDecimal(0);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((orderItems == null) ? 0 : orderItems.hashCode());
		result = prime * result + ((purchaseTime == null) ? 0 : purchaseTime.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		if (orderItems == null) {
			if (other.orderItems != null)
				return false;
		} else if (!orderItems.equals(other.orderItems))
			return false;
		if (purchaseTime == null) {
			if (other.purchaseTime != null)
				return false;
		} else if (!purchaseTime.equals(other.purchaseTime))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", orderItems=" + orderItems + ", purchaseTime=" + purchaseTime
				+ ", total=" + total + "]";
	}
    
}