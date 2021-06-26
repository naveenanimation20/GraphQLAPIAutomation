package demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@JsonProperty
	private String id;
	
	@JsonProperty
	private String name;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	

}
