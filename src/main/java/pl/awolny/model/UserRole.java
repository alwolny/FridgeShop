package pl.awolny.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class UserRole implements Serializable{
     
    /**
	 * 
	 */
	private static final long serialVersionUID = -3044252923631059066L;
	@Id
    @GeneratedValue
    private Long id;
    private String role;
    private String description;
     
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return description;
    }
}