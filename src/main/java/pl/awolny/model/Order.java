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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="orders")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@OneToOne
	@NonNull
	private User user;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @NonNull
	private List<OrderItem> orderItems;
    @Version
    @Type(type = "dbtimestamp")
    private Timestamp purchaseTime;
    @NonNull
	private BigDecimal total;
       
    public Order(){
    	this.orderItems = new LinkedList<>();
    	this.total = new BigDecimal(0);
    }
}