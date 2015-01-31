/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toothfairy1.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import toothfairy1.Managers.UserManager;
import toothfairy1.Models.User;
import toothfairy1.UserAuth;
/**
 *
 * @author valya
 */
public class UserAuthController {
    String curLogin;
    String curPassword;
    public static User currentUser;
    
    public String getCurLogin(){
        return curLogin;
    }

    public void setCurLogin(String user_login){
	curLogin = user_login;
    }

    public String getCurPassword(){
        return curPassword;
    }

    public void setCurPassword(String user_pass){
	curPassword = user_pass;
    }
    
      public User getCurrentUser(){
        return currentUser;
    }
    
      public String unAuthorize() {
          currentUser = null;
          return "main.jsp";
      }

   
    public String check_user() {
        currentUser = UserManager.GetUser(curLogin, curPassword);
        if (currentUser == null)
        {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Логин или пароль введены неверно"));
               return null;
        }
        
        if (currentUser.roleId==1)
        {
            return "TaskToFairy.jsp";
        }
        
        if (currentUser.roleId==2)
        {
            return "StealMoney.jsp";
        }
         
          if (currentUser.roleId==4)
        {
            return "AddTooth.jsp";
        }
        
        return null;
    }
    
    
    
    
    
    
    public String big_image = "Qk2GVQAAAAAAADYAAAAoAAAAXQAAAE4AAAABABgAAAAAAFBVAAAAAAAAAAAAAAAAAAAAAAAA////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////AP//////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////////////////////////////////////////////////////wD/////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////////////////////////////////////////////////8A////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////AP//////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////////////////////////////////wD/////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////////////////////////////8A////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////AP//////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////////////wD/////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////////8A////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////h4eHAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"WFhY9/f3////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////AP//////////////////////////////////////////////////////////////////////\n" +
"/////////////////////////8/Pz3BwcCAgIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAADg4OAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAFhYWPf39///////////////////////////////////////////////////////////\n" +
"/////////////////////////////////////////////////////////////////////////wD/\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"///////Pz89wcHAgICAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAABYWFj39/f/////////////////////////////////////////\n" +
"//////////////////////////////////////////////////////////////////8A////////\n" +
"////////////////////////////////////////////////////////////////////r6+vMDAw\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"ICAgeHh4ICAgAAAAAAAAAAAAICAgn5+f////////////////////n5+fICAgAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAICAgn5+f////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////AP//////////////\n" +
"//////////////////////////////////////////////////////f391BQUAAAAAAAAAAAAAAA\n" +
"AAAAABgYGGhoaL+/v///////////////////////////////////////////////////////////\n" +
"/////////////////////////////////////////////////////////////5+fnyAgIAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACAgIJ+fn///////////////////////////////////\n" +
"/////////////////////////////////////////////////////wD/////////////////////\n" +
"//////////////////////////////////////9wcHAAAAAAAAAAAAAAAAAAAAAICAhoaGi/v7//\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//+fn58gICAAAAAAAAAAAAAAAAAAAAAAAAAgICCfn5//////////////////////////////////\n" +
"//////////////////////////////////////////////8A////////////////////////////\n" +
"////////////////////////////n5+fAAAAAAAAAAAAAAAAAAAAaGho5+fn////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////7+/vf39/EBAQAAAAAAAAAAAAAAAASEhI9/f3////////////////////////////////\n" +
"////////////////////////////////////////AP//////////////////////////////////\n" +
"/////////////////+fn5xAQEAAAAAAAAAAAACAgIJeXl///////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////+/v739/fxAQEAAAAAAAAAAAADg4ONfX1///////////////////////////////////\n" +
"/////////////////////////////////wD/////////////////////////////////////////\n" +
"//////+Hh4cAAAAAAAAAAAAgICD39/f/////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"///////////v7+9wcHAAAAAAAAAAAAAICAiHh4f/////////////////////////////////////\n" +
"//////////////////////////8A////////////////////////////////////////////9/f3\n" +
"CAgIAAAAAAAAAAAAv7+/////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////j4+PCAgIAAAAAAAAAAAAICAgn5+f////////////////////////////////////\n" +
"////////////////////AP///////////////////////////////////////////3BwcAAAAAAA\n" +
"AAgICKenp///////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////9fX1zg4OAAAAAAAAAAAAAAAABgYGGhoaL+/v///////////////////////////////\n" +
"/////////////wD////////////////////////////////////////39/cICAgAAAAAAACHh4f/\n" +
"//////////////////////////////////////////////////+Hh4cAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAgICCfn5//////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////////+fn58QEBAAAAAAAAAAAAAAAAAAAABISEj39/f/////////////////////////////\n" +
"//////8A////////////////////////////////////////YGBgAAAAAAAACAgI////////////\n" +
"////////////////////////////////////////////ICAgAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAODg419fX////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////7+/vf39/ICAgAAAAAAAAAAAAAAAAAAAAAAAAaGho////////////////////////////\n" +
"AP///////////////////////////////////8/PzwAAAAAAAAAAAIeHh///////////////////\n" +
"/////////////////////////////////////7e3tyAgIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAgICIeHh///////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////////8/Pz2BgYAAAAAAAAAAAAAAAAAAAAP///////////////////////////wD/////\n" +
"//////////////////////////////9YWFgAAAAAAABQUFD/////////////////////////////\n" +
"///////////////////////////////////////////////////////////////////////////v\n" +
"7+9/f38QEBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABYWFj39/f/////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////////////+fn58gICAAAAAAAAAAAACvr6////////////////////////8A////////////\n" +
"////////////////////////CAgIAAAAAAAAz8/P////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"39/fODg4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASEhI9/f3////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////cHBwAAAAAAAAMDAw9/f3////////////////////AP//////////////////\n" +
"/////////////////wAAAAAAAAAAAP//////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/4eHhyAgIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGhoaP//////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////+fn5wgICAAAAAAAAFhYWP///////////////////wD/////////////////////////\n" +
"//////////8AAAAAAAAAAAD/////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////////////////////9/f38AAAAAAAAAAAAAAAAAAAAAAAAICAj/////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////+Xl5cAAAAAAAAAAAD///////////////////8A////////////////////////////////\n" +
"9/f3AAAAAAAAAAAA////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////n5+fICAgAAAAAAAAAAAAICAgn5+f////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////AAAAAAAAAAAA////////////////////AP///////////////////////////////3BwcAAA\n" +
"AAAAAAgICP//////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////////////////////////////////////////////////////////////////////wAA\n" +
"AAAAAAAAAP///////////////////wD///////////////////////////////8ICAgAAAAAAACH\n" +
"h4f/////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////////////////////////////////////////////////////////////////8AAAAAAAAA\n" +
"AAD///////////////////8A////////////////////////////////AAAAAAAAAAAA////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////AAAAAAAAAAAA////\n" +
"////////////////AP///////////////////////////////wAAAAAAAAAAAP//////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////////////////////////////////////////////////wAAAAAAAAAAAP//////////\n" +
"/////////wD///////////////////////////////8AAAAAAAAAAAD/////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////////////////////////////////////////////8AAAAAAAAAAAD/////////////////\n" +
"//8A////////////////////////////////AAAAAAAAAAAA////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////AAAAAAAAAAAA////////////////////AP//\n" +
"/////////////////////////////wAAAAAAAAAAAP//////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////////////////////////////wAAAAAAAAAAAP///////////////////wD/////////\n" +
"//////////////////////8AAAAAAAAAAAD/////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////////////////////////8AAAAAAAAAAAD///////////////////8A////////////////\n" +
"////////////////AAAAAAAAAAAA////////////////////////////////aGhoAAAAAAAAAAAA\n" +
"AAAAaGho////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////AAAAAAAAAAAA////////////////////AP//////////////////////\n" +
"/////////wAAAAAAAAAAAP///////////////////////////8/PzwAAAAAAAAAAAAAAAAAAAAgI\n" +
"CP//////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////////wAAAAAAAAAAAP///////////////////wD/////////////////////////////\n" +
"//8AAAAAAAAAAAD////////////////////////39/dAQEAAAAAAAAAAAAAAAAAgICCfn5//////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////////////////////////////////////////////////////////////////+Hh4cAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABoaGj/////////////////////////////////\n" +
"//////8AAAAAAAAAAAD///////////////////8A////////////////////////////////AAAA\n" +
"AAAAAAAA////////////////////////cHBwAAAAAAAAAAAAz8/P////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////CAgIAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA////////////////////////////////////////\n" +
"AAAAAAAAAAAA////////////////////AP///////////////////////////////wAAAAAAAAAA\n" +
"AP///////////////////////wgICAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGhoaP//\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////////////////////////////////////////////////wAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAP///////////////////////////////////////wAAAAAA\n" +
"AAAAAP///////////////////wD///////////////////////////////8AAAAAAAAAAAD/////\n" +
"//////////////////8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD/////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////////////////////////////////////////////8AAAAAAAAAAAD/////////////////\n" +
"//////////8AAAAAAAAAAAD///////////////////////////////////////8AAAAAAAAAAAD/\n" +
"//////////////////8A////////////////////////////////AAAAAAAAAAAA////////////\n" +
"////////////AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////AAAAAAAAAAAA////////////////////////\n" +
"////AAAAAAAAAAAA////////////////////////////////////////AAAAAAAAAAAA////////\n" +
"////////////AP///////////////////////////////wAAAAAAAAAAAP//////////////////\n" +
"/////wAAAAAAAAAAAAgICP///////////////////wAAAAAAAAAAAP//////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////////////////////////////wAAAAAAAAAAAP///////////////////////////wAA\n" +
"AAAAAAAAAP///////////////////////////////////////wAAAAAAAAAAAP//////////////\n" +
"/////wD///////////////////////////////8AAAAAAAAAAAD///////////////////////8A\n" +
"AAAAAAAAAACfn5////////////////////8AAAAAAAAAAAD/////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////////////////////////8AAAAAAAAAAAD///////////////////////////8AAAAAAAAA\n" +
"AAD///////////////////////////////////////8AAAAAAAAAAAD///////////////////8A\n" +
"////////////////////////////////AAAAAAAAAAAA////////////////////////AAAAAAAA\n" +
"AAAA////////////////////9/f3AAAAAAAAAAAA////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////AAAAAAAAAAAAAAAAaGho////////////////////AAAAAAAAAAAA////\n" +
"////////////////////////////////9/f3AAAAAAAAAAAA////////////////////AP//////\n" +
"/////////////////////////wAAAAAAAAAAAP///////////////////////xgYGAAAAAgICP//\n" +
"/////////////////3BwcAAAAAAAAAgICP//////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////////wAAAAAAAAAAAAAAAAAAAP////////////////f39wAAAAAAAAAAAP//////////\n" +
"/////////////////////////3BwcAAAAAAAAAgICP///////////////////wD/////////////\n" +
"//////////////////8AAAAAAAAAAAD///////////////////////+3t7dAQECfn5//////////\n" +
"//////////8ICAgAAAAAAACHh4f/////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////8YGBgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAICAj/////////////////\n" +
"///////////////39/cICAgAAAAAAACHh4f///////////////////8A////////////////////\n" +
"////////////AAAAAAAAAAAA////////////////////////////////h4eHAAAAaGho////////\n" +
"////AAAAAAAAAAAA////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"t7e3QEBAEBAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAh4eH////////////////////////\n" +
"////////YGBgAAAAAAAACAgI////////////////////////AP//////////////////////////\n" +
"/////wAAAAAAAAAAAP///////////////////////////////wgICAAAAAAAAP///////////wAA\n" +
"AAAAAAAAAP//////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/7e3tyAgIAAAAAAAAAAAAAAAAAAAAAAAACAgIJeXl////////////////////////////////8/P\n" +
"zwAAAAAAAAAAAIeHh////////////////////////wD///////////////////////////////8A\n" +
"AAAAAAAAAAD///////////////////////////////8AAAAAAAAAAAD///////+Hh4cAAAAAAAAA\n" +
"AAD/////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"///////////////////////////////////////////////////////////////39/dAQEAAAAAA\n" +
"AABQUFD///////////////////////////8A////////////////////////////////AAAAAAAA\n" +
"AAAA////////////////////////////////AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACAgI////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////9/f3SEhIAAAAAAAAAAAAz8/P\n" +
"////////////////////////////AP///////////////////////////////wAAAAAAAAAAAPf3\n" +
"9////////////////////////////xgYGAAAAAAAAAAAAAAAAAAAAAAAAAgICJ+fn///////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////////////////////////////////////////3BwcAAAAAAAAAAAAH9/f///////////\n" +
"/////////////////////wD///////////////////////////////8YGBgAAAAAAABISEj39/f/\n" +
"//////////////////////+3t7cgICAAAAAAAAAAAAAAAAAgICCfn5//////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////////////////////////////////////8ICAgAAAAAAAB/f3//////////////////////\n" +
"//////////////8A////////////////////////////////l5eXAAAAAAAAAAAAWFhY////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////9/f3YGBgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaGho////////////////////\n" +
"////////////////////////////z8/PAAAAAAAAAAAA////////////////////////////////\n" +
"////////AP///////////////////////////////////39/fwAAAAAAAAAAAP//////////////\n" +
"/////////////////////////////////////////////////////////////////////8/Pz3Bw\n" +
"cCAgIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFhYWPf39///////////////\n" +
"/////////////////////1BQUAAAAAAAAFBQUP//////////////////////////////////////\n" +
"/wD///////////////////////////////////////8AAAAAAAAAAAD39/f/////////////////\n" +
"//////////////////////////////////////////////////////////+Hh4cAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABYWFj/////////////////////\n" +
"///////////Pz88AAAAAAAAAAADPz8////////////////////////////////////////8A////\n" +
"////////////////////////////////////GBgYAAAAAAAASEhI////////////////////////\n" +
"////////////////////////////////////////////////////QEBAAAAAAAAAAAAAGBgYj4+P\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////t7e3ICAgAAAAAAAAAAAAAAAA////////////////////////////\n" +
"////WFhYAAAAAAAAUFBQ////////////////////////////////////////////AP//////////\n" +
"/////////////////////////////5eXlwAAAAAAAAAAAK+vr///////////////////////////\n" +
"/////////////////////////////////////////////2hoaAAAABgYGL+/v///////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////////////////////////wAAAAAAAAAAAP///////////////////////////+fn5wgI\n" +
"CAAAAAAAAM/Pz////////////////////////////////////////////wD/////////////////\n" +
"//////////////////////////9oaGgAAAAAAAAwMDD/////////////////////////////////\n" +
"//////////////////////////////////////8ICAgAAAAAAAD/////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////////////////////8AAAAAAAAAAAD///////////////////////+fn58QEBAAAAAAAAAY\n" +
"GBj///////////////////////////////////////////////8A////////////////////////\n" +
"////////////////////5+fnCAgIAAAAAAAAx8fH////////////////////////////////////\n" +
"////////////////////////////////AAAAAAAAAAAA////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////AAAAAAAAAAAA////////////////////cHBwAAAAAAAAAAAAAAAAn5+f////\n" +
"////////////////////////////////////////////AP//////////////////////////////\n" +
"/////////////////2hoaAAAAAAAAHh4eP//////////////////////////////////////////\n" +
"/////////////////////////wAAAAAAAAAAAP///////////////////////4eHhwAAAAAAAAAA\n" +
"AAAAACAgIJ+fn///////////////////////////////////////////////////////////////\n" +
"/////////wAAAAAAAAAAAP///////////////+/v7wgICAAAAAAAACgoKMfHx///////////////\n" +
"/////////////////////////////////////wD/////////////////////////////////////\n" +
"//////////+/v78AAAAAAAAAAAAAAABoaGj/////////////////////////////////////////\n" +
"//////////////////8AAAAAAAAAAAD///////////////////////8ICAgAAAAAAAAAAAAAAAAA\n" +
"AAAAAABISEj39/f/////////////////////////////////////////////////////////////\n" +
"//8AAAAAAAAAAAD///////////////+fn58AAAAAAAA4ODj39/f/////////////////////////\n" +
"//////////////////////////////8A////////////////////////////////////////////\n" +
"////////GBgYAAAAAAAAAAAAAAAA////////////////////////////////////////////////\n" +
"////////////AAAAAAAAAAAA////////////////////9/f3AAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAICAgn5+f////////////////////////////////////////////////////////////AAAA\n" +
"AAAAAAAA////////////9/f3ODg4AAAAAAAAl5eX////////////////////////////////////\n" +
"////////////////////////AP//////////////////////////////////////////////////\n" +
"/6+vryAgIAAAAAAAAAAAAP//////////////////////////////////////////////////////\n" +
"/////wAAAAAAAAAAAP////////////////f390hISAAAAAAAAAgICP///+/v73BwcAAAAAAAAAAA\n" +
"AAAAAEhISPf39////////////////////////////4eHhwAAAAAAACAgIJ+fn/f39wAAAAAAAAAA\n" +
"AP///////////2BgYAAAAAAAAAAAAOfn5///////////////////////////////////////////\n" +
"/////////////////wD/////////////////////////////////////////////////////////\n" +
"//8AAAAAAAAAAAD39/f///////////////////////////////////////////////////////8A\n" +
"AAAAAAAAAAD39/f////////39/dISEgAAAAAAAAAAACHh4f///////////+Xl5cQEBAAAAAAAAAA\n" +
"AAA4ODjX19f///////////////////////8ICAgAAAAAAAAAAAAAAAAAAAAAAAAAAAAICAj/////\n" +
"///Pz88AAAAAAAAAAACHh4f/////////////////////////////////////////////////////\n" +
"//////////8A////////////////////////////////////////////////////////////GBgY\n" +
"AAAAAAAASEhI9/f3////////////////////////////////////////////////////GBgYAAAA\n" +
"AAAAWFhY////////cHBwAAAAAAAAAAAAf39/////////////////////7+/vcHBwAAAAAAAAAAAA\n" +
"CAgIh4eH////////////////z8/PAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAh4eH////////UFBQ\n" +
"AAAAAAAAUFBQ////////////////////////////////////////////////////////////////\n" +
"////AP///////////////////////////////////////////////////////////5eXlwAAAAAA\n" +
"AAAAAEhISPf39////////////////////////////////////////////////5eXlwAAAAAAAAAA\n" +
"AP///////wgICAAAAAAAAH9/f////////////////////////////////4+PjwgICAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAEhISFhYWAAAAAAAAEhISH9/fyAgIAAAACAgIJeXl////////8/PzwAAAAAAAAAA\n" +
"AM/Pz////////////////////////////////////////////////////////////////////wD/\n" +
"//////////////////////////////////////////////////////////////9/f38AAAAAAAAA\n" +
"AABYWFj///////////////////////////////////////////////////8AAAAAAAAAAAD/////\n" +
"//8AAAAAAAAAAAD////////////////////////////////////////X19c4ODgAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAADPz8/////////////////////////39/dAQEAAAAAAAABQUFD/////\n" +
"//////////////////////////////////////////////////////////////////8A////////\n" +
"////////////////////////////////////////////////////////////f39/AAAAAAAAAAAA\n" +
"9/f3////////////////////////////////////////////////AAAAAAAAAAAA////////AAAA\n" +
"AAAAAAAA////////////////////////////////////////////////h4eHICAgAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAA////////////////////////9/f3SEhIAAAAAAAAAAAAz8/P////////////\n" +
"////////////////////////////////////////////////////////////AP//////////////\n" +
"/////////////////////////////////////////////////////////xgYGAAAAAAAAAAAAAAA\n" +
"AFhYWPf39////////////////////////////////////wAAAAAAAAAAAP///////wAAAAAAAAAA\n" +
"AP///////////////////////////////////////////////////////////+fn5wgICAAAAAAA\n" +
"AAAAAAgICP////////////////////f390hISAAAAAAAAAAAAH9/f///////////////////////\n" +
"/////////////////////////////////////////////////////wD/////////////////////\n" +
"//////////////////////////////////////////////////+Xl5cAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAYGBhoaGi/v7////////////////////8AAAAAAAAAAAD///+vr68AAAAAAAAAAAD/////\n" +
"//////////////////////////////////////////////////////////+vr68gICAAAAAgICCf\n" +
"n5////////////////////9wcHAAAAAAAAAAAAB/f3//////////////////////////////////\n" +
"//////////////////////////////////////////////8A////////////////////////////\n" +
"////////////////////////////////////////////////n5+fICAgAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAf39/////////////////////////////////////////////\n" +
"////////////////////////////////////////AP//////////////////////////////////\n" +
"/////////////////////////////////////////////////////5+fnyAgIAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAgICP//////////////////////////////////////////////////////\n" +
"/////////////////////////////////wD/////////////////////////////////////////\n" +
"///////////////////////////////////////////////////////////////Pz89wcHAgICAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
"AAAAAAAgICCfn5//////////////////////////////////////////////////////////////\n" +
"//////////////////////////8A////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////AP//////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"/////////////wD/////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"////////////////////////////////////////////////////////////////////////////\n" +
"//////8A";
    
    
    
    public String getImg() {
        return big_image;
    }
}