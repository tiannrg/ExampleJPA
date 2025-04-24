/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.test;


import co.edu.sena.examplejpa.controllers.EmployeeTypeControllers;
import co.edu.sena.examplejpa.controllers.IEmployeeTypeControllers;
import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.utils.MessageUtils;
import java.util.List;

/**
 * fecha: 21/04/2025
 * @author rojas
 * objetivo: probar el controlador de tipo de documento
 */
public class TestEmployeeType {
    public void insert()
    {
        try {
            EmployeeType employeeType = new EmployeeType();
            employeeType.setDescript("Nuevo Tipo");
            
            IEmployeeTypeControllers controllers = new EmployeeTypeControllers();
            controllers.insert(employeeType);
            MessageUtils.showInfoMessage("Tipo de empleado creado exitosamente");
        
        } catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
            
        }
    }
        
        public void update ()
        {
            try {
                EmployeeType employeeType = DAOFactory.getEmployeeTypeDAO().findById(10);
                employeeType.setDescript("Nuevo tipo actualizado");
                
                IEmployeeTypeControllers controllers = new EmployeeTypeControllers();
                controllers.update(employeeType);
                MessageUtils.showInfoMessage("Tipo de empleado modificado exitosamente");
            } catch (Exception e) {
                MessageUtils.showErrorMessage(e.getMessage());
            }
        }
        
        public void delete ()
        {
            try {
                    EmployeeType employeeType = DAOFactory.getEmployeeTypeDAO().findById(10);
                    IEmployeeTypeControllers controllers = new EmployeeTypeControllers();
                    controllers.delete(employeeType.getId());
                    MessageUtils.showInfoMessage("Tipo de empleado eliminado exitosamente");

            } catch (Exception e) {
                MessageUtils.showErrorMessage(e.getMessage());
            }
        }
        
        public void findALL()
        {
            try {
                IEmployeeTypeControllers controllers = new EmployeeTypeControllers();
                List<EmployeeType> types = controllers.findALL();
                String message = "";
                for (EmployeeType type: types)
                {
                    message += "Id: " + type.getId() + "Descripcion: " + type.getDescript() + "\n";
                 }
                  MessageUtils.showInfoMessage(message);
            } catch (Exception e) {
                MessageUtils.showErrorMessage(e.getMessage());
            }
        }
        
        
    
    public static void main(String[] args) {
        TestEmployeeType test = new TestEmployeeType();
          // test.insert();
           //test.update();
           //test.delete();
           test.findALL();
        
    }
    
}
