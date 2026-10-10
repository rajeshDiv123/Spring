package firstApp.demo.donner;

import org.springframework.stereotype.Component;


import jakarta.persistence.*;

@Entity
@Component
public class donner {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		private String d_name;
		private int d_group;
		
		private String d_contact;
		private String d_mandal;
		private String d_district;
		
		public String getD_district() {
			return d_district;
		}
		public void setD_district(String d_district) {
			this.d_district = d_district;
		}
		public String getD_name() {
			return d_name;
		}
		public void setD_name(String d_name) {
			this.d_name = d_name;
		}
		public int getD_group() {
			return d_group;
		}
		public void setD_group(int d_group) {
			this.d_group = d_group;
		}
		
		public String getD_contact() {
			return d_contact;
		}
		public void setD_contact(String d_contact) {
			this.d_contact = d_contact;
		}
		public String getD_mandal() {
			return d_mandal;
		}
		public void setD_mandal(String d_mandal) {
			this.d_mandal = d_mandal;
		}
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
}
