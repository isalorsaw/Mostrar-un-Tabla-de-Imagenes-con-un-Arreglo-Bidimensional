import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; 

public class EjemploTablero 
{
    public static void main(String[] args) 
    {
        int filas = 5, columnas = 5;
        int m[][]=new int[filas][columnas];
        llenarAleatorio(m,1,9);
        imprimir(m);
        
        ImageIcon[][] imgs=new ImageIcon[filas][columnas];
        cargarImagenes(imgs,m);
        mostrarTablero(imgs,filas,columnas);
        // Arreglo bidimensional de ImageIcon (aquí está el tema de la clase)
        //ImageIcon[][] imagenes = new ImageIcon[filas][columnas];
        
        // Función/método para cargar imágenes (tema de la clase)
        //cargarImagenes(imagenes, filas, columnas);
        
        // Función/método para mostrar el tablero (tema de la clase)
        //mostrarTablero(imagenes, filas, columnas);
    }
    public static void cargarImagenes(ImageIcon imgs[][],int m[][])
    {
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[i].length;j++)
            {
                imgs[i][j]=new ImageIcon("imagenes/"+m[i][j]+".jpg");
            }
        }
    }
    public static void imprimir(int m[][])
    {
        String salida="";
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[i].length;j++)
            {
                salida+=m[i][j];
            }
            salida+="\n";
        }
        mostrar(salida);
    }
    public static void mostrar(String msg)
    {
        JOptionPane.showMessageDialog(null,msg);
    }
    public static void llenarAleatorio(int m[][], int d, int h)
    {
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[i].length;j++)
            {
                m[i][j]=generaAleatorio(1,9);
            }
        }
    }
    // Función que llena el arreglo con imágenes
    /*static void cargarImagenes(ImageIcon[][] arr, int f, int c) 
    {
        for (int i = 0; i < f; i++) 
        {
            for (int j = 0; j < c; j++) 
            {
                //arr[i][j] = new ImageIcon("imagenes/img_" + i + "_" + j + ".png");
                int alea=generaAleatorio(1,9);
                arr[i][j] = new ImageIcon("imagenes/"+alea+ ".jpg");
            }
        }
    }*/
    public static int generaAleatorio(int d, int h)
    {
        return (int)(Math.random()*(h-d+1)+d);
    }
    
    // Función que muestra el arreglo en JOptionPane
    /*static void mostrarTablero(ImageIcon[][] arr, int f, int c) 
    {
        JPanel panel = new JPanel(new GridLayout(f, c));
        
        for (int i = 0; i < f; i++) 
        {
            for (int j = 0; j < c; j++) 
            {
                JLabel label = new JLabel(arr[i][j]);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.add(label);
            }
        }
        
        JOptionPane.showMessageDialog(null, panel, "Mi Tablero", JOptionPane.PLAIN_MESSAGE);
    }*/
    static void mostrarTablero(ImageIcon[][] arr, int f, int c) 
    {
        JPanel panel = new JPanel(new GridLayout(f, c));
        
        for (int i = 0; i < f; i++) 
        {
            for (int j = 0; j < c; j++) 
            {
                // 1. Usamos JButton en lugar de JLabel para comportamiento de botón
                JButton boton = new JButton(arr[i][j]);
                boton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                // Opcional: Quitar el fondo gris del botón para que solo se vea la imagen
                boton.setContentAreaFilled(false); 
                boton.setFocusPainted(false);

                // 2. Creamos variables FINALES para capturar la fila y columna actual del ciclo.
                // Esto es necesario porque el listener se ejecuta después, y debe "recordar" estos valores.
                final int fila = i;
                final int columna = j;
                
                // 3. Agregamos el escuchador de clics (ActionListener)
                boton.addActionListener((ActionEvent e) -> {
                    // Aquí va la lógica que quieres ejecutar al hacer clic
                    String mensaje = "Hiciste click en:\nFila: " + fila + "\nColumna: " + columna;
                    
                    JOptionPane.showMessageDialog(null, mensaje, "Click Detectado", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Ejemplo de otra acción: cambiar la imagen al hacer clic
                    // boton.setIcon(new ImageIcon("imagenes/otra_imagen.jpg"));
                });
                
                panel.add(boton);
            }
        }
        
        JOptionPane.showMessageDialog(null, panel, "Mi Tablero", JOptionPane.PLAIN_MESSAGE);
    }
}