
package Entity;

import company.Tools;
import javax.swing.JTable;


public class Department implements mainData {
 private int DeptNo;
 private String DeptName;
 private String Location;

    public int getDeptNo() {
        return DeptNo;
    }

    public void setDeptNo(int DeptNo) {
        this.DeptNo = DeptNo;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String DeptName) {
        this.DeptName = DeptName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    @Override
    public void add() {
        String strInsert ="insert into department values("
                +DeptNo+","
                +"'"+DeptName+"',"
                +"'"+Location+"')";
    boolean isAdd =db.go.runNonQuery(strInsert);
    if(isAdd){
    Tools.MsgBox("Department in Added");
    }
    }

    @Override
    public void update() {
        String strUpdate = "update department set "
                + "DEPTNAME='" + DeptName + "'," 
                + "LOCATION='" + Location+ "' " 
                + "where DEPTNO=" + DeptNo ;
        boolean isUpdate =db.go.runNonQuery(strUpdate);
        if(isUpdate){
        Tools.MsgBox("Department is updated");
        }
         }

    @Override
    public void delete() {
    String strDelete = "delete from department"+" where DEPTNO="+DeptNo; 
    boolean isDelete=db.go.runNonQuery(strDelete);
    if(isDelete){
    Tools.MsgBox("Department is Deleted");
    }
    }

    @Override
    public String getAutoNumber() {
  return db.go.getAutoNumber("department", "DEPTNO");
    }

    @Override
    public void getAllRows(JTable table) {
   db.go.fillToJTable("department_data", table);
    }

    @Override
    public void getOneRow(JTable table) {
   String strSelect="select * from department_data where department_no ="+DeptNo;
   db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
   db.go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name) {
    String strSelect="select DEPTNO from department"+" where DEPTNAME='"+name+"'";
    String strVal =(String)db.go.getDataTable(strSelect).Items[0][0];
    return strVal;
    }

    @Override
    public String getNameByValue(String value) {
    String strSelect="select DEPTNAME from department"+" where DEPTNO="+ value;
    String strName =(String)db.go.getDataTable(strSelect).Items[0][0];
    return strName;
    }
    
    
    
    
    
    
}
 