
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
public class BlackAndWhiteSquares extends Canvas
{
   private boolean black = false;
   private boolean Up = false;
   private boolean Down = false;
   private boolean Left = false;
   private boolean Right = false;
   private Color col1;
   private int ArrayX;
   private int ArrayY;
   private int XPos = 0; 
   private int YPos = 0;
   private int StartXPos;
   KeyCode keys;
  
   
   GraphicsContext gc = getGraphicsContext2D();
   int[][]TwoDArray = new int [21][21];

   public BlackAndWhiteSquares() 
   {

      super(525,525);
      try
      {
      Scanner scan = new Scanner(new File("GameMap.txt"));
      

      for(int k=0;k<21;k++)
      {
         for(int i=0;i<21;i++)
         {
         TwoDArray[i][k]=scan.nextInt();
            if(TwoDArray[k][0]==0)
            {
            StartXPos = k*25;
            XPos = StartXPos;
            YPos=0;
            }
         }
      }
      }
      catch(Exception e)
      {
      System.out.println("Error");
      }
          
    draw(gc);
    player(keys);  
    }

    public void draw (GraphicsContext gc)
    {
    System.out.println(StartXPos/25);
      for(int i=0;i<21;i++)
      {
         for(int k=0;k<21;k++)
         {
            //black squares
            if(TwoDArray[i][k]==1)
            {
               gc.setFill(Color.BLACK);
               gc.fillRect(i*25, k*25, 25, 25);
            }

            //white squares
            else
            { 
               gc.setFill(Color.WHITE);
               gc.fillRect(i*25,k*25, 25, 25);
            }
         }
      }
   }
     public void player (KeyCode keys)      
     {      
         gc.setFill(Color.CYAN);
         gc.clearRect(XPos, YPos, 25, 25);
         gc.fillRect(XPos, YPos, 25, 25);
         this.keys = keys;
            
            if(keys == KeyCode.DOWN)
               {
                  
                  if(TwoDArray[XPos/25][(YPos/25)+1]==0)
                  {
                  gc.setFill(Color.CYAN);
                  gc.clearRect(XPos, YPos, 25,25);
                  YPos+=25;
                  gc.fillRect(XPos, YPos, 25, 25);

                  }
                  else
                  gc.setFill(Color.CYAN);
                  gc.fillRect(XPos, YPos, 25,25);
                                    
               } 
               
            if(keys == KeyCode.UP)
               {     
                
                  if(TwoDArray[XPos/25][(YPos/25)-1]==0)
                  {
                  gc.setFill(Color.CYAN);
                  gc.clearRect(XPos, YPos, 25,25);
                  YPos-=25;
                  gc.fillRect(XPos, YPos, 25, 25);
                  }
                  else
                  {
                  gc.setFill(Color.CYAN);
                  gc.fillRect(XPos, YPos, 25,25);
                 
                  }
               }  
               
            if(keys == KeyCode.LEFT)
               {
                  if(TwoDArray[(XPos/25)-1][YPos/25]==0)
                  {
                  gc.setFill(Color.CYAN);
                  gc.clearRect(XPos, YPos, 25,25);
                  XPos-=25;
                  gc.fillRect(XPos, YPos, 25, 25);
                  }
                  else
                  {
                  gc.setFill(Color.CYAN);
                  gc.fillRect(XPos, YPos, 25,25);
                   
                  }
               } 
                            
            if(keys == KeyCode.RIGHT)
               {     
      
                  if(TwoDArray[(XPos/25)+1][YPos/25]==0)
                  {
                 gc.setFill(Color.CYAN);
                 gc.clearRect(XPos, YPos, 25,25);
                 XPos+=25;
                 gc.fillRect(XPos, YPos, 25, 25); 
                  }
                  else
                  {

                 
                  gc.setFill(Color.CYAN);
                  gc.fillRect(XPos, YPos, 25,25);
                 }           
               } 
               }
               public void win()
               {
               if(YPos/25 ==20)
               {
               System.out.println("You Win!!!");
               }
               } 
         
         }  
          
      