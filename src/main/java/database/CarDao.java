package database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;

public class CarDao  extends CommonDao {

    public CarDao() {
        super();
    }

    public void deleteByColumnName(String columnName,int id) throws SQLException {
        Dao<Car,Object>dao=getDao(Car.class);
        DeleteBuilder<Car,Object>deleteBuilder=dao.deleteBuilder();
        deleteBuilder.where().eq(columnName,id );
        dao.delete(deleteBuilder.prepare());

    }
}
