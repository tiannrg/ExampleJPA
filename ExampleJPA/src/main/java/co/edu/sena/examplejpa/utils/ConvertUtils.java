/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localTime;
import java.util.Date;

/**
 *fecha : 3/4/2025
 * Objetivo clase para utilizarla para conversiones de datos.
 * @author rojas
 */
public class ConvertUtils {
    
    
    /**
     * convierte una fecha en string
     * @param date
     * @return 
     */
    public static String dateToString (Date date)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String result = dateFormat.format(date);
        return result;
                
    }
    
    /**
     * convierte un string en fecha
     * @param text
     * @return
     * @throws ParseException 
     */
    
    public static Date stringToDate (String text) throws ParseException
    {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(text);
        return date;
    }
    
    /**
     * convierte una hora a string
     * @param date
     * @return 
     */
    
    public static String timeToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String result = dateFormat.format(date);
        return result;
    }
    
    
    /**
     * convierte un string en una hora
     * @param text
     * @return
     * @throws ParseExecption
     */
    
    public static Date stringToTime(String text) throws ParseException
    {
        Date date = new SimpleDateFormat("HH:mm").parse(text);
        return date;
    }
    
    
    /**
     * convertir de LocalDate a Date
     * @param localDate
     * @return 
     */
    
    
    public static Date LocalDatetoDate (LocalDate localDate)
    {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    
    /**
     * convertir un LocalTime a Date
     * @param localTime
     * @return 
     */
    public static Date LocalTimeToDate(LocalTime localTime)
    {
        return Date.from(LocalDate.now().atTime(localTime).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    
    public static LocalDate dateToLocalDate(Date date)
    {
        return date.toInstant()
                   .atZone(ZoneId.systemDefault())
                   .toLocalDate();
    }
    
}