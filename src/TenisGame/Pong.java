package TenisGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
 
public class Pong extends JFrame implements KeyListener {
  
    private int windowWidth = 800;
    private int windowHeight = 600;
    private Pelota pelota;
    private Paleta paleta;
    private Paleta paleta2;
    
    //Puntos puntos;
    //Tabla tabla;
    Puntos puntos = new Puntos();
    Tabla tabla = new Tabla(puntos);
    
    
    
    
   
    
    private int key=0;
    private long goal;
    private long tiempoDemora=8;
    
    private int Buenas;
    private int Malas;
      
   
   public static void main(String[] args){
       new Pong();
   }
   
    public Pong () {
        //this.puntos = puntos;
        tabla.setVisible(true);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(windowWidth, windowHeight);
        this.setResizable(false);
        this.setLocation(100, 100);
        this.setVisible(true);
       
        this.createBufferStrategy(2);
        
        this.addKeyListener(this);
       
        inicializoObjetos();
       
        while(true) {
            pelota();
            sleep();
        }
              
    }
       
    private void inicializoObjetos() {
        
        pelota = new Pelota(windowWidth/2, windowHeight/2, 0, 0);
        paleta = new Paleta(windowHeight/2, 80);
        paleta2 = new Paleta(windowHeight/2, 80);
    }
   
    private void pelota() {
     
        pelota.x = pelota.x + pelota.veloX;
        pelota.y = pelota.y + pelota.veloY;
        chequearColision();
        
        if(pelota.x <= 0 || pelota.x >= windowWidth-40){
            pelota.veloX = -pelota.veloX;
            Malas++;
            if (pelota.veloX >0)
                    setPuntosP2();
            else if (pelota.veloX <0)
                    setPuntosP1();
        }
        
        if(pelota.y <= 20 || pelota.y >= (windowHeight - 40)) // 20 y 40 son valores de compensacion
            pelota.veloY = -pelota.veloY;

        dibujoPantalla();
    }   
    
    private void chequearColision(){
        if ( (pelota.x <= 75 && pelota.x >= 60) && pelota.y > paleta.y && pelota.y < paleta.y + paleta.alto)
        {
            if (pelota.veloX < 0)
                Buenas++;
            
            pelota.veloX = -pelota.veloX;
        }
        
        if ( (pelota.x >= 695 && pelota.x <= 710) && pelota.y > paleta2.y && pelota.y < paleta2.y + paleta2.alto)
        {
            if (pelota.veloX > 0)
                Buenas++;
            
            pelota.veloX = -pelota.veloX;
        }
    }
   
    private void dibujoPantalla() {
        
        BufferStrategy bf = this.getBufferStrategy();
        Graphics g = null;
       
        try {
            g = bf.getDrawGraphics();
                
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, windowWidth, windowHeight);
            
            dibujoPelota(g);
            dibujoPaletas(g);
            Graphics g2d = (Graphics) g;
            g2d.fillRect(400, 0, 2, 600);
            
            
        } finally {
            g.dispose();
        }
        bf.show();
             
        Toolkit.getDefaultToolkit().sync();
    }
    private void dibujoPelota(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(pelota.x, pelota.y, 35, 35);
      
    }
    private void dibujoPaletas(Graphics g) {
    switch (key){
        case KeyEvent.VK_W:
            if(pelota.veloX==0){
            pelota.veloX=3;
            pelota.veloY=-3;}
            break;
        case KeyEvent.VK_Q:
            if(pelota.veloX==3||pelota.veloY==-3){
            pelota.veloX=0;
            pelota.veloY=0;}
            break;
        case KeyEvent.VK_A:
            if (paleta.y>23)
            paleta.y=paleta.y-2;
            break;
        case KeyEvent.VK_Z:
            if (paleta.y<windowHeight-78)
            paleta.y=paleta.y+2;
            break;
        case KeyEvent.VK_UP:
            if (paleta2.y>23)
            paleta2.y=paleta2.y-2;
            break;
            case KeyEvent.VK_DOWN:
            if (paleta2.y<windowHeight-78)
            paleta2.y=paleta2.y+2;
            break;
        case KeyEvent.VK_E:
            System.exit(0);
    }    
    g.setColor(Color.orange);
    g.fillRect(15, paleta.y, 15, paleta.alto);
    g.fillRect(770, paleta2.y, 15, paleta2.alto);
    }
    private void sleep(){
        goal = ( System.currentTimeMillis() + tiempoDemora );
        while(System.currentTimeMillis() < goal) {
        }
    }
    public void setPuntosP1(){
        puntos.puntoP1();
        tabla.jLabel1.setText(puntos.score());
        System.out.println(puntos.score());
        ///Tabla
        tabla.imprimirTabla(puntos.ScoreP1, puntos.ScoreP2, puntos.score());
    } 
    public void setPuntosP2(){
        puntos.puntoP2();
        tabla.jLabel1.setText(puntos.score());
        System.out.println(puntos.score());
        ///Tabla
        tabla.imprimirTabla(puntos.ScoreP1, puntos.ScoreP2, puntos.score());
    } 
    @Override
    public void keyPressed(KeyEvent e){
        key=e.getKeyCode();
    }
    @Override
    public void keyReleased(KeyEvent e){    
    }
    @Override
    public void keyTyped(KeyEvent e){  
    }
    
    
    @Override
    public void update(Graphics g) {
        if (puntos.ganador()==true)
            pelota.veloX=0;
            pelota.veloY=0;  
     }
}