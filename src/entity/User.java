package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private boolean admin;

	private String email;

	private String fullname;

	private String password;

	private String username;

	//bi-directional many-to-one association to GioHangLog
	@OneToMany(mappedBy="user")
	private List<GioHangLog> gioHangLogs;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<GioHangLog> getGioHangLogs() {
		return this.gioHangLogs;
	}

	public void setGioHangLogs(List<GioHangLog> gioHangLogs) {
		this.gioHangLogs = gioHangLogs;
	}

	public GioHangLog addGioHangLog(GioHangLog gioHangLog) {
		getGioHangLogs().add(gioHangLog);
		gioHangLog.setUser(this);

		return gioHangLog;
	}

	public GioHangLog removeGioHangLog(GioHangLog gioHangLog) {
		getGioHangLogs().remove(gioHangLog);
		gioHangLog.setUser(null);

		return gioHangLog;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", admin=" + admin + ", email=" + email + ", fullname=" + fullname + ", password="
				+ password + ", username=" + username + ", gioHangLogs=" + gioHangLogs + "]";
	}

	
}