package ua.org.oa.dao;

import ua.org.oa.model.Disc;
import ua.org.oa.model.Genre;

import java.util.List;
import java.util.Map;

public interface DAO {


    <T> T save(final T o);

    <T> boolean delete(final Class<T> type, final Integer id);
   
    <T> T get(final Class<T> type, final Integer id);

    <T> void saveOrUpdate(final T o);

    <T> List<T> getAll(final Class<T> type);

    List<Disc> findByNameDisc(String name);
   
    List<Disc> search(String name ,String typeID, String genreID );
   
    List<Genre> findByTypeID(String typeID);
    
    Disc getLastDisc(Integer genreid) ;  	
    
}

