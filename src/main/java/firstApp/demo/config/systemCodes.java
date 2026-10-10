package firstApp.demo.config;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name="SYSTEM_CODES")
public class systemCodes {
	@Id
	private int code_id;
	private Integer code_val;
	private String code_Desc;
	
	private Date date;
	
	public int getCode_id() {
		return code_id;
	}
	public void setCode_id(int code_id) {
		this.code_id = code_id;
	}
	public Integer getCode_val() {
		return code_val;
	}
	public void setCode_val(Integer code_val) {
		this.code_val = code_val;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCode_Desc() {
		return code_Desc;
	}
	public void setCodeDesc(String code_Desc) {
		this.code_Desc = code_Desc;
	}
	
}
