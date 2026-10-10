package firstApp.demo.donner;

import org.springframework.stereotype.Component;

@Component
public class districtsDto {
		private String State_name;
		private Integer id;
		
		String [] mandals;
		
		public String getState_name() {
			return State_name;
		}
		public void setState_name(String state_name) {
			State_name = state_name;
		}
		public String[] getMandals() {
			return mandals;
		}
		public void setMandals(String[] mandals) {
			this.mandals = mandals;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
}
