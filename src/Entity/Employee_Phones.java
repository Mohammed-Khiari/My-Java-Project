/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import company.Tools;
import javax.swing.JTable;

/**
 *
 * @author toshiba
 */
public class Employee_Phones implements mainData {
    private int EmpNo;
    private String Phone;

    public int getEmpNo() {
        return EmpNo;
    }

    public void setEmpNo(int EmpNo) {
        this.EmpNo = EmpNo;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public void add() {
   String strInsert="insert into employee_phones values ("
                  +EmpNo+","
                  +"'"+Phone+"')";
   boolean isAdd=db.go.runNonQuery(strInsert);
   if(isAdd){
   //Tools.MsgBox("phone is Added");
   }
           
           }

    @Override
    public void update() {
    Tools.MsgBox("Update method in Employee_Phones class not working!");}

    @Override
    public void delete() {
    String strDelete="delete from employee_phones where "
            +"EmpNo= "+EmpNo
            +" and phone='"+Phone+"'";
    boolean isDelete = db.go.runNonQuery(strDelete);
    if(isDelete){
    //Tools.MsgBox("Phone is deleted");
    }
    }
public void deleteByEmp(){
String strDelete="delete from employee_phones"
        +" where empno="+EmpNo;
boolean isDelete=db.go.runNonQuery(strDelete);
if(isDelete){
//Tools.MsgBox("Phones are deleted");
}

}
    @Override
    public String getAutoNumber() {
    Tools.MsgBox("getAutoNumber method in Employee_Phones class not working!");
        return""; 
    }

    @Override
    public void getAllRows(JTable table) {
   String strSelect= "select phone from employee_phones"
           +" where EmpNo="+EmpNo;
   db.go.fillToJTable(strSelect, table);
    
    }

    @Override
    public void getOneRow(JTable table) {
    Tools.MsgBox("getOneRow method in Employee_Phones class not working!");
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        Tools.MsgBox("getCustomRow method in Employee_Phones class not working!");

    }

    @Override
    public String getValueByName(String name) {
     Tools.MsgBox("getValueByName method in Employee_Phones class not working!");
        return "";
    }

    @Override
    public String getNameByValue(String value) {
     Tools.MsgBox("getNameByValue method in Employee_Phones class not working!");
        return "";
    }
    public String getEmpNoByPhone(String requestPhone){
    String strSelect="select EmpNo from employee_phones"
            +" where phone='"+requestPhone+"'";
    Object row[][]=db.go.getDataTable(strSelect).Items;
    String strEmpNo;
    if(row.length >0){
        strEmpNo= (String)row[0][0];
    }
    else{
      strEmpNo="0";
    }
    
    return strEmpNo;
    }
    
    
    
    
    
}
