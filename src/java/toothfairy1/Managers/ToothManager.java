/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Managers;

import DAO.Factory;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import toothfairy1.Helpers;
import static toothfairy1.Managers.TaskManager.GetAllActual;
import toothfairy1.Models.Task;
import toothfairy1.Models.Tooth;
import toothfairy1.Models.ToothTable;

/**
 *
 * @author Николай
 */
public class ToothManager {
    public static List<Tooth> GetAll() throws SQLException, UnsupportedEncodingException
    {
        List<Tooth> list = new ArrayList<Tooth>();
        //вот тут из базы надо брать
      /*  Tooth t1 = new Tooth();
        t1.id = 1;
        t1.cost = 100;
        t1.childId=1;
        Tooth t2 = new Tooth();
        t2.id = 2;
        t2.cost = 200;
        t2.childId=2;
        list.add(t1);
        list.add(t2);*/
        
        Factory atata = new Factory();
        List<ToothTable> teeth = atata.getInstance().getToothDAO().getAllTeeth();
        for(int i = 0; i < teeth.size(); ++i) {
           // System.out.println("1: " + Helpers.convert(teeth.get(i).getName()));
              Tooth t = new Tooth();
              t.id = teeth.get(i).getId();
              t.defect = Helpers.convert(teeth.get(i).getDefect());
              t.description = Helpers.convert(teeth.get(i).getDescription());
              t.position = Helpers.convert(teeth.get(i).getPosition());
              t.shape = Helpers.convert(teeth.get(i).getShape());
              t.texture = Helpers.convert(teeth.get(i).getTexture());
              t.lossDate = teeth.get(i).getLossDate();
              t.cost = teeth.get(i).getCost();
              
              list.add(t);
        }
        
        return list;
    }
    
    public static void GetToothForChild(String childrId)
    {
        
    }
    
     public static Tooth GetToothById(long id) throws SQLException, UnsupportedEncodingException
    {
         Tooth t = new Tooth();
        ToothTable tooth = Factory.getInstance().getToothDAO().getToothById(id);
        t.id = tooth.getId();
        t.defect = Helpers.convert(tooth.getDefect());
        t.description = Helpers.convert(tooth.getDescription());
        t.position = Helpers.convert(tooth.getPosition());
        t.shape = Helpers.convert(tooth.getShape());
        t.texture = Helpers.convert(tooth.getTexture());
        t.lossDate = tooth.getLossDate();
        t.cost = tooth.getCost();
        t.size = tooth.getSize();
        t.childId = tooth.getChildId();
        return t;
    }
}
