package firstApp.demo.donner;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class districts {
	
	@Id
	private int district_id;
	private String district_name;
	@Column(columnDefinition="TEXT")
	private String mandals;
	
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int state_id) {
		this.district_id = state_id;
	}
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String state_name) {
		this.district_name = state_name;
	}
	public String getMandals() {
		return mandals;
	}
	public void setMandals(String strings) {
		this.mandals = strings;
	}
}
