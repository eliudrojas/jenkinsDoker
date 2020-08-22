package jenkinsDocker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class ThemeParkRide {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@NotEmpty
	String name;
	
	@NotEmpty
	String description;
	
	private int thrillFactor;
	 private int vomitFactor;
	 
	public ThemeParkRide(@NotEmpty String name, @NotEmpty String description, int thrillFactor,
			int vomitFactor) {
		super();
		this.name = name;
		this.description = description;
		this.thrillFactor = thrillFactor;
		this.vomitFactor = vomitFactor;
	}
	 
	 
	 
}
