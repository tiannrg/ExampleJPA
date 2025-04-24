/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.persistence;
import co.edu.sena.examplejpa.model.Record;
import co.edu.sena.examplejpa.persistence.RecordDAO;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author rojas
 */
public class RecordDAO  implements  IERecordDAO{

    @Override
    public void insert(Record record) throws Exception {
         try {
            EntityManagerHelper.getEntityManager().persist(record);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Record record) throws Exception {
         try {
            EntityManagerHelper.getEntityManager().merge (record);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Record record) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove( record);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Record findById(Integer id) throws Exception {
        try {
             return EntityManagerHelper.getEntityManager().find(Record.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
       
    }

    @Override
    public List<Record> findALL() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Record.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw  e;
        }
    }
    
}
