package dao;

import entity.SanPham;

public class SanPhamDAO extends BaseDAO<SanPham>{

	@Override
	public String getBaseClass() {
		// TODO Auto-generated method stub
		return SanPham.class.getSimpleName();
	}

	@Override
	public Class<SanPham> getFullClass() {
		// TODO Auto-generated method stub
		return SanPham.class;
	}

}
