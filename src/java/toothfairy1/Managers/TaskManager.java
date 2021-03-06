/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Managers;

import DAO.Factory;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import toothfairy1.Helpers;
import toothfairy1.Models.Task;
import toothfairy1.Models.TaskTable;
import toothfairy1.Models.Task;

/**
 *
 * @author Николай
 */
public class TaskManager {
    public static List<Task> GetAllActual() throws UnsupportedEncodingException, SQLException
    {
        List<Task> list = new ArrayList<Task>();
        
        Factory atata = new Factory();
        List<TaskTable> tasks = atata.getInstance().getTaskDAO().getAllTasks();
        for(int i = 0; i < tasks.size(); ++i) {
           
              Task t = new Task();
              t.id = tasks.get(i).getId();
              t.difficulty = Helpers.convert(tasks.get(i).getDifficulty());
              t.fairyId = tasks.get(i).getFairyId();
              t.probability = tasks.get(i).getProbability();
              t.toothId = tasks.get(i).getToothId();
              t.deadline = tasks.get(i).getDeadline();
              t.isCompleted = (tasks.get(i).getIsCompleted() != 0);
              t.isSucceed = (tasks.get(i).getIsSucceed() != 0);
              list.add(t);
        }
        List<Task> flist = new ArrayList<Task>();
        for (Task task : list) {
            if (task.deadline.after(new Date(new java.util.Date().getTime()))) {
                flist.add(task);
            }
        }
        
        return flist;
    }
    
    public static List<Task> GetAllUnassigned() throws UnsupportedEncodingException, SQLException
    {
        List<Task> list = new ArrayList<Task>();
        for (Task task : GetAllActual()) {
            if (task.fairyId <= 0 && task.isCompleted == false) {
                list.add(task);
            }
        }
        return list;
        
    }
    
    public static List<Task> GetTasksForFairy(long id) throws UnsupportedEncodingException, SQLException
    {
        List<Task> list = new ArrayList<Task>();
        for (Task task : GetAllActual()) {
            if (task.fairyId == id && task.isCompleted == false) {
                list.add(task);
            }
        }
        return list; 
    }
    
    public static Task GetTaskForTooth(long id) throws UnsupportedEncodingException, SQLException
    {
        List<Task> list = new ArrayList<Task>();
        for (Task task : GetAllActual()) {
            if (task.toothId == id) {
                return task;
            }
        }
        return null; 
    }
    
    public static Task GetTaskById(long id) throws SQLException, UnsupportedEncodingException
    {
       Task t = new Task();
        TaskTable task = Factory.getInstance().getTaskDAO().getTaskById(id);
        t.id = id;
        t.difficulty = Helpers.convert(task.getDifficulty());
        t.fairyId = task.getFairyId();
        t.probability = task.getProbability();
        t.toothId = task.getToothId();
        t.deadline = task.getDeadline();
        t.isCompleted = (task.getIsCompleted() != 0);
        t.isSucceed = (task.getIsSucceed() != 0);
        return t;
    }
    
}
