/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controllers;
import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *fecha 25/3/3035
 * @author rojas
 * objetivo: Implementar la interface para controlar el model EmployeeType
 */
public class EmployeeTypeControllers implements IEmployeeTypeControllers{
    
    @Override
    public void insert(EmployeeType employeeType) throws Exception {
        if(employeeType == null)
        {
        throw new Exception("El tipo de empleado es nulo");
        }
        
        if("".equals(employeeType.getDescript()))
        {
        throw new Exception("La descripción es obligatoria");
        }


        
        //insertar 
         EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().insert(employeeType);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(EmployeeType employeeType) throws Exception {
        if(employeeType == null)
        {
        throw new Exception("El tipo de empleado es nulo");
        }

        if(employeeType.getId() == 0)
        {
        throw new Exception("El Id es obligatorio");
        }
        
        if("".equals(employeeType.getDescript()))
        {
        throw new Exception("La descripción es obligatoria");
        }
        
        //consultar si el employeeType existe en la bd
        EmployeeType employeeTypeExist = DAOFactory.getEmployeeTypeDAO().findById(employeeType.getId());
        if(employeeTypeExist == null)
        {
            throw new Exception("El tipo de empleado no existe");
        }
        
        //merge: todos los campos menos la FK
        
        employeeTypeExist.setDescript(employeeType.getDescript());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().update(employeeTypeExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Integer id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El Id es obligatorio");
        }
        
        //consultar si el employeeType existe en la bd
        EmployeeType employeeTypeExist = DAOFactory.getEmployeeTypeDAO().findById(id);
        if(employeeTypeExist == null)
        {
            throw new Exception("El tipo de empleado no existe");
        }
        
        //eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().delete(employeeTypeExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
 
    }

    @Override
    public EmployeeType findById(Integer id) throws Exception {
        if(id == 0)
        {
            throw new Exception ("El id es obligatorio");
        }
        
        return DAOFactory.getEmployeeTypeDAO().findById(id);

   
    }

    @Override
    public List<EmployeeType> findALL() throws Exception {
        return DAOFactory.getEmployeeTypeDAO().findALL();

    }
}
