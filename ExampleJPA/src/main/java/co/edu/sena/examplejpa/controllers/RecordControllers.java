/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controllers;
import co.edu.sena.examplejpa.model.Record;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *fecha 25/3/3035
 * @author rojas
 * objetivo: Implementar la interface para controlar el model Record
 */
public class RecordControllers implements  IRecordControllers{

    @Override
    public void insert(Record record) throws Exception {
         if(record == null)
        {
        throw new Exception("El tipo de registro  es nulo");
        }
        
        if(record.getDateRecord() == null)
        {
        throw new Exception("La fecha es obligatorio");
        }
        
        if (record.getStartTime() == null)
        {
             throw new Exception("La hora de inicio es obligatoria");
        }
        
        if (record.getEndTime() == null)
        {
             throw new Exception("La hora de fin  es obligatoria");
        }
        
        if ("".equals(record.getStatus()))
        {
             throw new Exception("El estado es obligatoria");
        }
        
        //FK´s
        
        if (record.getEmployeeId() == null)
        {
               throw new Exception("El id del empleado es obligatorio");
        }
        
        if (record.getKeyId() == null)
        {
               throw new Exception("La llave es obligatoria");
        }
        
        //insertar 
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().insert(record);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
   
    }

    @Override
    public void update(Record record) throws Exception {
         if(record == null)
        {
        throw new Exception("El registro  es nulo");
        }

        if(record.getId() == 0)
        {
        throw new Exception("El Id es obligatorio");
        }
        
        if(record.getDateRecord() == null)
        {
        throw new Exception("El registro de fecha  es obligatoria");
        }
        
        if(record.getStartTime() == null)
        {
             throw new Exception("La hora de inicio  es obligatoria");
        }
        
        if(record.getEndTime() == null)
        {
            throw new Exception("La hora de fin  es obligatoria");
        }
         
        if ("".equals(record.getStatus()))
        {
            throw new Exception("El estado  es obligatorio");
        }
        
        //FK's
        
        if(record.getEmployeeId() == null)
        {
            throw new Exception("El id del empleado es obligatoria");
        }
        
        if(record.getKeyId() == null)
        {
             throw new Exception("El id de la llave es obligatoria");
        }
        
        //La FK no es autoincremental, se debe validar existencia del registro
        
        Record recordExist = DAOFactory.getRecordDAO().findById(record.getId());
        
        if (recordExist == null)
        {
            throw new Exception("No existe un registro con ese Id");
        }

        //actualizar      
        recordExist.setDateRecord(record.getDateRecord());
        recordExist.setEmployeeId(record.getEmployeeId());
        recordExist.setEndTime(record.getEndTime());
        recordExist.setKeyId(record.getKeyId());
        recordExist.setStatus(record.getStatus());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().update(record);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
    }

    @Override
    public void delete(int id) throws Exception {
            if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
            
        Record recordExist = DAOFactory.getRecordDAO().findById(id);
        if (recordExist == null)
        {
            throw new Exception("No existe un registro con ese id");
        }

        //eliminar
         EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().delete(recordExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Record> findALL() throws Exception {
        
        return DAOFactory.getRecordDAO().findALL();
        
    }

    @Override
    public Record findById(int id) throws Exception {
        Record recordExist = DAOFactory.getRecordDAO().findById(id);
        if (recordExist == null)
        {
            throw new Exception("No existe un registro con ese Id");
        }
        return  DAOFactory.getRecordDAO().findById(id);
    }

}