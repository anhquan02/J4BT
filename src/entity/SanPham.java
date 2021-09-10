package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SanPham database table.
 * 
 */
@Entity
@NamedQuery(name="SanPham.findAll", query="SELECT s FROM SanPham s")
public class SanPham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private BigDecimal giaBan;

	private BigDecimal giaMua;

	private boolean isActived;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ngayNhap;

	private String seri;

	private String tenSanPham;

	//bi-directional many-to-one association to GioHangLog
	@OneToMany(mappedBy="sanPham")
	private List<GioHangLog> gioHangLogs;

	//bi-directional many-to-one association to DanhMuc
	@ManyToOne
	@JoinColumn(name="danhMucId")
	private DanhMuc danhMuc;

	public SanPham() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getGiaBan() {
		return this.giaBan;
	}

	public void setGiaBan(BigDecimal giaBan) {
		this.giaBan = giaBan;
	}

	public BigDecimal getGiaMua() {
		return this.giaMua;
	}

	public void setGiaMua(BigDecimal giaMua) {
		this.giaMua = giaMua;
	}

	public boolean getIsActived() {
		return this.isActived;
	}

	public void setIsActived(boolean isActived) {
		this.isActived = isActived;
	}

	public Date getNgayNhap() {
		return this.ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getSeri() {
		return this.seri;
	}

	public void setSeri(String seri) {
		this.seri = seri;
	}

	public String getTenSanPham() {
		return this.tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public List<GioHangLog> getGioHangLogs() {
		return this.gioHangLogs;
	}

	public void setGioHangLogs(List<GioHangLog> gioHangLogs) {
		this.gioHangLogs = gioHangLogs;
	}

	public GioHangLog addGioHangLog(GioHangLog gioHangLog) {
		getGioHangLogs().add(gioHangLog);
		gioHangLog.setSanPham(this);

		return gioHangLog;
	}

	public GioHangLog removeGioHangLog(GioHangLog gioHangLog) {
		getGioHangLogs().remove(gioHangLog);
		gioHangLog.setSanPham(null);

		return gioHangLog;
	}

	public DanhMuc getDanhMuc() {
		return this.danhMuc;
	}

	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}

	@Override
	public String toString() {
		return "SanPham [id=" + id + ", giaBan=" + giaBan + ", giaMua=" + giaMua + ", isActived=" + isActived
				+ ", ngayNhap=" + ngayNhap + ", seri=" + seri + ", tenSanPham=" + tenSanPham + ", gioHangLogs="
				+ gioHangLogs + ", danhMuc=" + danhMuc + "]";
	}

}