/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.swing.JTable;

/**
 *
 * @author toshiba
 */
public interface mainData {
    public void add();
    public void update();
    public void delete();
    public String getAutoNumber();
    public void getAllRows(JTable table);
    public void getOneRow(JTable table);
    public void getCustomRows(String statement,JTable table);
    public String getValueByName(String name);
    public String getNameByValue(String value);
    
    
    
    
    
    
    
    
    
    
}
