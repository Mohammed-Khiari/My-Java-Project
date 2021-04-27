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
public class Employee implements mainData {
    private int EmpNO;
    private String EmpName;
    private String Address;
    private Double Salary;
    private String HiringDate;
    private String BirthDate;
    private int DeptNo;

    public int getEmpNO() {
        return EmpNO;
    }

    public void setEmpNO(int EmpNO) {
        this.EmpNO = EmpNO;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAdsress(String Address) {
        this.Address = Address;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        this.Salary = salary;
    }

    public String getHiringDate() {
        return HiringDate;
    }

    public void setHiringDate(String HiringDate) {
        this.HiringDate = HiringDate;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public int getDeptNo() {
        return DeptNo;
    }

    public void setDeptNo(int DeptNo) {
        this.DeptNo = DeptNo;
    }

    @Override
    public void add() {
   String strInsert="insert into employee values("
           + EmpNO +","
           +"'"+EmpName+"',"
           +"'"+Address+"',"
           +"'"+Salary+"',"
           +"'"+HiringDate+"',"
           +"'"+BirthDate+"',"
           +DeptNo+")";
   boolean isAdd =db.go.runNonQuery(strInsert);
   if(isAdd){
   Tools.MsgBox("Employee is Added");
   } 
    }

    @Override
    public void update() {
     String strUpdate="update employee set"
                     +" EmpName =' "+EmpName+ "',"
                     +" Address =' "+Address+"',"
                     +" Salary =' "+Salary+"',"
                     +" Hiringdate='"+HiringDate+"',"
                     +" Birthdate='"+BirthDate+"',"
                     +" DeptNo="+DeptNo
                     +" where EmpNo="+EmpNO;
     boolean isUpdate=db.go.runNonQuery(strUpdate);
     if(isUpdate){
     Tools.MsgBox("Employee is updated");
     }
    }

    @Override
    public void delete() {
    String strDelete="delete from employee "
            + "where EmpNo="+EmpNO;
    boolean isDelete=db.go.runNonQuery(strDelete);
    if(isDelete){
    Tools.MsgBox("Employee is deleted");
    }
    }

    @Override
    public String getAutoNumber() {
    return db.go.getAutoNumber("employee","EmpNo");
    }

    @Override
    public void getAllRows(JTable table) {
    db.go.fillToJTable("employee_data", table);
    }

    @Override
    public void getOneRow(JTable table) {
    String strSelect="select * from employee_data"
            +" where number="+EmpNO;
    db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
    db.go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name) {
   String strSelect="select EmpNo from employee"
           +" where EmpName='"+name+"'";
    String strVal =db.go.getDataTable(strSelect).Items[0][0].toString();
    return strVal;
    }

    @Override
    public String getNameByValue(String value) {
    String strSelect="select EmpName from employee"
            +" where EmpNo="+value;
    String strName=db.go.getDataTable(strSelect).Items[0][0].toString();
    return strName;
    }
       
    
    
    
    
           
    
    
    
    
}
