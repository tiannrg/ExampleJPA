/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.controllers;


import co.edu.sena.examplejpa.model.EmployeeType;
import java.util.List;

/**
 *fecha:25/3/2025
 * @author rojas
 * objetivo: 
 */
public interface IEmployeeTypeControllers {
    public void insert(EmployeeType employeeType) throws Exception;
    public void update(EmployeeType employeeType) throws Exception;
    public void delete(Integer id)throws Exception;
    public List<EmployeeType> findALL() throws Exception;
    public EmployeeType findById(Integer id) throws Exception;
}
