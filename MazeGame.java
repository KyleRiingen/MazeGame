import java.util.*; 
import java.text.*; 
import java.io.*; 
import java.lang.*; 
import javafx.application.*; 
import javafx.event.*; 
import javafx.stage.*; 
import javafx.scene.canvas.*; 
import javafx.scene.paint.*; 
import javafx.scene.*; 
import javafx.scene.input.*; 
import javafx.scene.layout.*; 
import javafx.animation.*; 
import javafx.scene.control.*; 
import javafx.scene.image.*; 
import java.net.*; 
import javafx.geometry.*; 
public class MazeGame extends Application 
{
   FlowPane root = new FlowPane();
   boolean Up, Down, Left, Right;

   
   KeyCode keys;
   BlackAndWhiteSquares canvas = new BlackAndWhiteSquares();

   public void start(Stage stage)
   {
      root.getChildren().add(canvas);
      root.setOnKeyPressed(new KeyListenerDown());

      Scene scene1 = new Scene(root, 525, 525);
      stage.setScene(scene1);
      stage.setTitle("Maze Game");
      stage.show();
         
      root.requestFocus();
      }
      
      public static void main(String[] args)
      {
         launch(args);
      }
   
   public class KeyListenerDown implements EventHandler<KeyEvent>
   {  

      public void handle(KeyEvent event)     
         {  
            keys = event.getCode();
            if(keys == KeyCode.RIGHT)
               {
               canvas.player(keys);
               }
               
            if(keys == KeyCode.LEFT)
               {
               canvas.player(keys);
               }
               
            if(keys == KeyCode.UP)
               {
               canvas.player(keys);
               } 
               
            if(keys == KeyCode.DOWN)
               {
               canvas.player(keys);
               }
               
            canvas.win(); 
         }
    }  
}