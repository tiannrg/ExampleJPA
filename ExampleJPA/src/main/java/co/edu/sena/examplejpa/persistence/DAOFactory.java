/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.persistence;

/**
 *fecha: 08/04/2025
 * @author rojas
 * objetivo: instanciar los DAO'S creados en la persistencia
 */
public class DAOFactory {
    private static IEmployeeTypeDAO employeeTypeDAO = new EmployeeTypeDAO();
    private static  IEmployeeDAO employeeDAO = new EmployeeDAO();
    private static IEKeyRoomDAO keyRoomDAO = new KeyRoomDAO();
    private static  IERecordDAO recordDAO = new RecordDAO();

    public static IEmployeeTypeDAO getEmployeeTypeDAO() {
        return employeeTypeDAO;
    }

    public static IEmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public static IEKeyRoomDAO getKeyRoomDAO() {
        return keyRoomDAO;
    }

    public static IERecordDAO getRecordDAO() {
        return recordDAO;
    }
    
    
    
}
