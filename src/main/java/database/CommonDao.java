package database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.support.ConnectionSource;
import utils.exceptions.FxmlUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public abstract class CommonDao  {

    private static final Logger LOGGER= LoggerFactory.getLogger(CommonDao.class);
    protected final ConnectionSource connectionSource;

    public CommonDao() {
        this.connectionSource = DbManager.getConnectionSource();
    }

    public<T extends Car,I> void createOrUpdate(Car car)  {
        Dao<T,I> dao = getDao((Class<T>) Car.class);
        try {
            dao.createOrUpdate((T) car);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        }finally {
            this.closeDbConnection();
        }
    }


       public <T extends Car, I> void refresh(Car car){
           try {
               Dao<T,I>dao=getDao((Class<T>) car.getClass());
               dao.refresh((T) car);
           } catch (SQLException e) {
               LOGGER.warn(e.getCause().getMessage());
           }finally {
               this.closeDbConnection();
           }
       }



    public <T extends Car, I> void delete(Car car) {
        try {
            Dao<T,I>dao=getDao((Class<T>) car.getClass());
            dao.delete((T) car);
        } catch (SQLException e) {
               LOGGER.warn(e.getCause().getMessage());
        }finally {
            this.closeDbConnection();
        }
    }

    public <T extends Car, I> void deleteById(Class<T> cls, Integer id) {
        try {
            Dao<T,I>dao=getDao(cls);
            dao.deleteById((I) id);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        }finally {
            this.closeDbConnection();
        }
    }

    public <T extends Car, I> T findById(Class<T> cls, Integer id){
        try {
            Dao<T,I>dao=getDao(cls);
            return dao.queryForId((I) id);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        }finally {
            this.closeDbConnection();
        }
        return null;
    }

    public <T extends Car,I>List<T> queryForAll(Class<T> cls){
        try {
            Dao<T,I> dao=getDao(cls);
            return dao.queryForAll();
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        }finally {
            this.closeDbConnection();
        }
        return null;
    }

    public  <T extends Car, I> Dao<T,I> getDao(Class<T> cls){
        try {
            return DaoManager.createDao(connectionSource,cls );
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        }finally {
            this.closeDbConnection();
        }
        return null;
    }

    private void closeDbConnection() {
        try {
            this.connectionSource.close();
        } catch (IOException e) {
            LOGGER.warn(e.getMessage());
        }
    }

}
