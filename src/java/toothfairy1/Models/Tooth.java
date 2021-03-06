/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Models;

import DAO.Factory;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.http.Part;
import static toothfairy1.Helpers.convertToDB;
import toothfairy1.Managers.ChildrenManager;
import toothfairy1.Managers.TaskManager;
import toothfairy1.Managers.ToothManager;


/**
 *
 * @author Николай
 */
public class Tooth {
        public long id;
        public String shape;
        public String texture;
        public String defect;

        public String position;       
        public double size;
        public Date lossDate;
        public String description;    
        public String photoContent;
        
        public double cost;
        public Boolean isValid;
        
        public long childId;
        
                
        public Tooth()
        {
 
        }
               
        public String getPhotoContent(){
             return photoContent;
        }
        
        public String getEncodedPhotoContent() {
            if (photoContent != null)
                return Base64.encode(photoContent.getBytes());
            else return "";
        }
        public Child getChild() throws SQLException, UnsupportedEncodingException{
            return ChildrenManager.GetChildById(childId);
        }
        
         public String getChildName() throws SQLException, UnsupportedEncodingException{
             try    
             {
                Child child =  ChildrenManager.GetChildById(childId);
                if (child != null) return child.name; else return "Unknown";
             }
             catch (Exception ex)
            {
                return "unknown";
            }
         }
        
        public String getDefect() {
            return defect;
        }

        public long getId(){
            return id;
        }
    
        public void setId(long id){
           this.id = id;
        }
        
        public double getCost(){
            return cost;
        }
        
        public String getPosition(){
            return position;
        }
        
        public Date getLossDate(){
            return lossDate;
        }
                 
        public void SaveInDb() throws SQLException, UnsupportedEncodingException
        {
           
            ToothTable tooth = new ToothTable();
            tooth.setCost(cost);
            tooth.setDefect(convertToDB(defect));
            tooth.setDescription(convertToDB(description));
            tooth.setLossDate(lossDate);
            tooth.setPosition(convertToDB(position));
            tooth.setShape(convertToDB(shape));
            tooth.setSize(size);
            tooth.setTexture(convertToDB(texture));
            tooth.setChildId(childId);
            if (photoContent != null)
            tooth.setPhotoContent(photoContent.getBytes());
          
            //Сохраним их в бд, id будут сгенерированы автоматически
            Factory.getInstance().getToothDAO().addTooth(tooth);
            id = tooth.getId();
            System.out.println("alala");
        }
        
        public void DeleteFromDb() throws SQLException, UnsupportedEncodingException
        {
             Task taskForTooth = TaskManager.GetTaskForTooth(id);
             if (taskForTooth != null) taskForTooth.deleteFromDb();
            
             ToothTable tooth = Factory.getInstance().getToothDAO().getToothById(id);
             Factory.getInstance().getToothDAO().deleteTooth(tooth);
        }
        
        public void Validate()
        {
            isValid = (size>0 && size < 2);
            if (isValid)
            {
                cost = size * 10;
            }
        }
       
}
