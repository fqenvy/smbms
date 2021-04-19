package cn.fq.service.role;

import cn.fq.dao.BaseDao;
import cn.fq.dao.role.RoleDao;
import cn.fq.dao.role.RoleDaoImpl;
import cn.fq.pojo.Role;

import java.sql.Connection;
import java.util.List;

public class RoleServiceImpl implements RoleService {
	
	private RoleDao roleDao;
	
	public RoleServiceImpl(){
		roleDao = new RoleDaoImpl();
	}
	
	@Override
	public List<Role> getRoleList() {
		Connection connection = null;
		List<Role> roleList = null;
		try {
			connection = BaseDao.getConnection();
			roleList = roleDao.getRoleList(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return roleList;
	}
	
}
