/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controllers;
import co.edu.sena.examplejpa.model.KeyRoom;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *fecha 25/3/3035
 * @author rojas
 * objetivo: Implementar la interface para controlar el model Key
 */
public class KeyRoomControllers  implements  IKeyRoomControllers{
   
    @Override
    public void insert(KeyRoom keyRoom) throws Exception {
          if (keyRoom == null)
        {
        throw new Exception("El tipo de llave es nulo");
        }
        
        if ("".equals(keyRoom.getName()))
        {
        throw new Exception("El nombre es obligatorio");
        }
        
        if ("".equals(keyRoom.getRoom()))
        {
            throw new Exception("El ambiente es obligatorioR");
        }
        
        if (keyRoom.getCount() <1)
        {
             throw new Exception("La cantidad de llaves es obligatoria");
        }
        
        //insertar 
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().insert(keyRoom);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
   
        
    }

    @Override
    public void update(KeyRoom keyRoom) throws Exception {
         if (keyRoom == null)
        {
            throw new Exception("El tipo de llave es nulo");
        }
         
         if ("".equals(keyRoom.getName()))
             
         {
             throw new Exception("El nombre es obligatorio"); 
         }
         
         if (keyRoom.getCount() == 0)
         {
             throw new Exception("El cantidad llaves es obligatoria"); 
         }
         
         //consultar si el key existe en la bd
         
            KeyRoom keyExist = DAOFactory.getKeyRoomDAO().findById(keyRoom.getId());
             if (keyExist  == null )
            {
                throw  new Exception("La llave no existe");
            }

        //actualizar
        keyExist.setCount(keyRoom.getCount());
        keyExist.setName(keyRoom.getName());
        keyExist.setObservation(keyRoom.getObservation());
        keyExist.setRoom(keyRoom.getRoom());
        
         EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().update(keyRoom);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
    }

    @Override
    public void delete(Integer id) throws Exception {
           if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        //consultar si el key existe en la bd
        KeyRoom keyExist = DAOFactory.getKeyRoomDAO().findById(id);
        if( keyExist == null)
        {
            throw new Exception("El tipo de llave no existe");
        }
        
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().delete(keyExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();

    }


    @Override
    public List<KeyRoom> findALL() throws Exception {
        return  DAOFactory.getKeyRoomDAO().findALL();
    }

    @Override
    public KeyRoom findById(Integer id) throws Exception {
        if(id==0)
        {
            throw  new Exception("El id es obligatorio");
        }
        return DAOFactory.getKeyRoomDAO().findById(id);
    }

    @Override
    public List<KeyRoom> getAllKeyRoom() {
        return null;
    }

}


