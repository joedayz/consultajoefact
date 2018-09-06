package pe.joedayz.cofaco.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@NamedQuery(name="ResetRegistry.findAll", query="SELECT r FROM ResetRegistry r")
@Table(name="reset_registry")
public class ResetRegistry extends AuditingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reset_id")
	private long resetId;

	@Column(name="token")
	private String token;

	@Column(name="user_name")
	private String userName;

	@Column(name="status")
	private String status;



	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getResetId() {
		return resetId;
	}

	public void setResetId(long resetId) {
		this.resetId = resetId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}