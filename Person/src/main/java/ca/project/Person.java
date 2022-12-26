package ca.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Min(8)
	private Integer id;
	@NotNull
	@NotBlank
	@Size(min = 4, max = 50)
	private String name;
	@NotNull
	@NotBlank
	@Size(min = 4, max = 20)
	private String gender;
	@NotNull
	@Email
	@NotBlank
	@Size(min = 8, max = 50)
	private String email;
}
