package company;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Tools{

public static void MsgBox (String message){
JOptionPane.showMessageDialog(null, message);
}
public static boolean confirmMsg(String Message){
int msgc=JOptionPane.showConfirmDialog(null, Message);
if(msgc==JOptionPane.YES_OPTION){
return true;
}
else{
return false;
}
        }

public static void CreateEmptyFolder(String FolderName,String path){
File f = new File(path + "/" +FolderName);
f.mkdir();
}
public static void CreateEmptyFile(String FileName){
    try {
        File f = new File(FileName );
        f.createNewFile();
    } catch (IOException ex) {
        Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public static void CreateEmptyFiles(String filesNames[]){
for( String obj : filesNames){
 CreateEmptyFile(obj);
}
}

public static void openForm(JFrame form){
        
    try {
        form.setLocationRelativeTo(null);
        Image img = ImageIO.read(Tools.class.getResource("emp.png"));
        form.setIconImage(img);
        form.setDefaultCloseOperation(2);
        form.getContentPane().setBackground(Color.white);
        form.setVisible(true);
    } catch (IOException ex) {
        Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public static void ClearText(Container form){
for (Component c : form.getComponents()){
if (c instanceof JTextField){
JTextField txt = (JTextField)c;
txt.setText(" ");}
else if(c instanceof Container ){
        ClearText((Container)c);
        }
}
}

public static void CreatDataFile(String FileName, Object Data[]){ 
    try {
        PrintWriter p = new PrintWriter(FileName + ".txt");
        for (Object Obj : Data){
        p.println(Obj);
        }
        p.close();       
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public static void CreateDataFiles(String FileNames[], Object Data[][]){
for(int x=0;x<FileNames.length ;x++){
CreatDataFile(FileNames[x],Data[x]);

}
}




public static  Object InputBox(String title){
Object obj = JOptionPane.showInputDialog(title);
return obj;
}
public static String getNumbers (String text){
String val = "";
for(char c : text.toCharArray()){
if (c == '1' || c == '2'|| c == '3'|| c == '4'|| c == '5'|| c == '6'|| c == '7'|| c == '8'|| c == '9'){
val += c;
}
}
return val;
}
public static int getNumberToInteger (String text){
String val = "";
for(char c : text.toCharArray()){
if (c == '1' || c == '2'|| c == '3'|| c == '4'|| c == '5'|| c == '6'|| c == '7'|| c == '8'|| c == '9'){
val += c;
}
}
return Integer.parseInt(val);
}
 public static String RemoveNumbers(String text){
 String val = "";
 for(char c : text.toCharArray()){
 if (c != '1' & c != '2'& c != '3'& c != '4'& c != '5'& c != '6'& c != '7'& c != '8'& c != '9')
     //!(c == '1' || c == '2'|| c == '3'|| c == '4'|| c == '5'|| c == '6'|| c == '7'|| c == '8'|| c == '9')
 {
 val += c;
 }
 }
 return val;
 }
 
public static void PrintScreen(String ImageName){

    try {
        Robot r = new Robot();
        Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage img = r.createScreenCapture(rec);
        ImageIO.write(img,"jpg", new File(ImageName +".jpg"));
        
    } catch (Exception ex) {
        Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
    }

}
public static void PrintScreen(String ImageName, JFrame Form){
    try {
        Form.setState(1);
        Robot r = new Robot();
        Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage img = r.createScreenCapture(rec);
        ImageIO.write(img,"jpg", new File(ImageName +".jpg"));
        Form.setState(0);
    } catch (Exception ex) {
        Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public static class StringTools {
private static String inverseText;

public static void PrintCharByChar(String text){
for (char c :text.toCharArray()){
System.out.println(c);
}}
public static void PrintCharByCharInverse(String text){
StringBuilder sb = new StringBuilder(text);
inverseText = sb.reverse().toString();
for(char c :inverseText.toCharArray()){
System.out.println(c);
}}
}

public class Table{

    public int Columns;
    public Object [][] Items ;
    
    public Table(int Columns){
    this.Columns =Columns;
    Items = new Object[0][Columns];
    }

public void AddNewRow(Object Row[]){
   Object TempItems [][]=Items; 
Items = new Object [Items.length+1][Columns];
for(int x=0;x<TempItems.length;x++){
Items[x]=TempItems[x];
}
    Items[Items.length-1]=Row; 
    }

public void PrintItems(){
for(Object Objs []: Items){
for(Object obj : Objs){
System.out.print(obj +";");
}
System.out.println();
}
}

public void EditRow(int RowIndex, int ColumnIndex , Object NewData){
Items[RowIndex][ColumnIndex]= NewData;
}
public void DeleteRow(int RowIndex ){
Object TempItems[][]= Items;
Items = new Object[Items.length-1][Columns];
int y = 0;
for(int x=0;x<TempItems.length;x++){
if(x != RowIndex){
Items[y]= TempItems[x]; 
y++;
}
}
}}
public class MergeArray{
    private Object[] Array1;
    private Object[] Array2;
public MergeArray(Object[] Array1,Object[] Array2){
this.Array1= Array1;
this.Array2= Array2;
}
public Object[] MergeTwoArrays(){
int a1 =Array1.length;
int a2 =Array2.length;
Object[] ArrayR = new Object[a1+a2];
System.arraycopy(Array1, 0, ArrayR, 0, a1);
System.arraycopy(Array2, 0, ArrayR, a1, a2);
return ArrayR;
}}





















}

























