package dao;

import entity.DanhMuc;

public class DanhMucDAO extends BaseDAO<DanhMuc>{

	@Override
	public String getBaseClass() {
		// TODO Auto-generated method stub
		return DanhMuc.class.getSimpleName();
	}

	@Override
	public Class<DanhMuc> getFullClass() {
		// TODO Auto-generated method stub
		return DanhMuc.class;
	}

}
