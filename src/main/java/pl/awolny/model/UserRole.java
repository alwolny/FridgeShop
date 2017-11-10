package pl.awolny.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserRole implements Serializable{
     
	private static final long serialVersionUID = -3044252923631059066L;
	@Id
    @GeneratedValue
    private Long id;
    private String role;
    private String description;
    
	@Override
	public String toString() {
		return description;
	}
}