package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DanhMuc database table.
 * 
 */
@Entity
@NamedQuery(name="DanhMuc.findAll", query="SELECT d FROM DanhMuc d")
public class DanhMuc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String tenDanhMuc;

	//bi-directional many-to-one association to SanPham
	@OneToMany(mappedBy="danhMuc")
	private List<SanPham> sanPhams;

	public DanhMuc() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenDanhMuc() {
		return this.tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public List<SanPham> getSanPhams() {
		return this.sanPhams;
	}

	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

	public SanPham addSanPham(SanPham sanPham) {
		getSanPhams().add(sanPham);
		sanPham.setDanhMuc(this);

		return sanPham;
	}

	public SanPham removeSanPham(SanPham sanPham) {
		getSanPhams().remove(sanPham);
		sanPham.setDanhMuc(null);

		return sanPham;
	}

	
}