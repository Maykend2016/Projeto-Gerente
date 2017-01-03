/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author mayke
 */
public class UserStoryControl {
    
      private static UserStoryControl controladorUserStory;
    
    public static UserStoryControl getInstance(){
        if(controladorUserStory == null){
            controladorUserStory = new UserStoryControl();
            return controladorUserStory;
        }
        return controladorUserStory;
    }
    
    public void cadastrarUserStory(){
    
    }
    
    public void deletarUserStory(){
    
    }
    
    public void editarUserStory(){
    
    }
    
    public void listaruserStory(){
    
    }
    
}
