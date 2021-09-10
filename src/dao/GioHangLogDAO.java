package dao;

import entity.GioHangLog;

public class GioHangLogDAO extends BaseDAO<GioHangLog> {

	@Override
	public String getBaseClass() {
		// TODO Auto-generated method stub
		return GioHangLog.class.getSimpleName();
	}

	@Override
	public Class<GioHangLog> getFullClass() {
		// TODO Auto-generated method stub
		return GioHangLog.class;
	}
	
}
