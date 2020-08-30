package works.hop.db.access.entity;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("employees")
public class Employee {

	@Id
	private Long employeeId;
	private String categoryName;
	private String lastName;
	private String firstName;
	private String title;
	private String titleOfCourtesy;
	private LocalDate birthDate;
	private LocalDate hireDate;
	private String address;
	private String city;
	private String region;
	private String postalCode;
	private String country;
	private String homePhone;
	private String extension;
	private String notes;
	private String reportsTo;
	private byte[] photo;
	private String photoPath;
	private Set<EmployeeTerritory> employeeTerritories;
}
