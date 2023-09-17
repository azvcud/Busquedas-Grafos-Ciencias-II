/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.interfaz;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import modelo.Arista;
import modelo.Grafo;

public class Mapa_colombia extends JFrame{
    private JLabel mapa;
    
    private Grafo grafo2D;
    private ArrayList<Arista> caminoSolucion;
    
    private static final int RADIO_NODO = 20;
    private static final int AJUSTE_X = 11;
    private static final int AJUSTE_Y = 12;

    private boolean[] esAristaSolucion;
    
    
    public Mapa_colombia() throws IOException {
        setTitle("Mapa de Colombia");
        setSize(626, 980);
        setResizable(false);
        getContentPane().setBackground(Color.cyan);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    
    public void pintar() throws IOException {
        BufferedImage archivoMapa;
        archivoMapa = ImageIO.read(this.getClass().getResource("/vista/imagenes/Mapa_colombia.png"));
        
        construirGrafo(archivoMapa);
    }
    
    
    private void construirGrafo(BufferedImage archivoPNG) {
        esAristaSolucion = new boolean[grafo2D.getAristas().size()];
        float grosor = 2.0f;
        
        mapa = new JLabel(new ImageIcon(archivoPNG)) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2D = (Graphics2D) g;

                for(int i = 0; i < caminoSolucion.size(); i++) {
                    g2D.setStroke(new BasicStroke(grosor));
                    g2D.setColor(Color.CYAN);
                    g2D.draw(pintarArista(caminoSolucion.get(i)));
                    
                    esAristaSolucion[caminoSolucion.get(i).getId()] = true;
                }
                
                for(int i = 0; i < grafo2D.getAristas().size(); i++) {
                    if(!esAristaSolucion[i]) {
                        g2D.setStroke(new BasicStroke(grosor));
                        g2D.setColor(Color.BLUE);
                        g2D.draw(pintarArista(grafo2D.getAristas().get(i)));
                    }
                }
                
                for(int i = 0; i < grafo2D.getNodos().size(); i++) {
                    GradientPaint grafoGradiente = new GradientPaint(
                        grafo2D.getNodos().get(i).getX(),
                        grafo2D.getNodos().get(i).getY(),
                        Color.BLUE, 
                        grafo2D.getNodos().get(i).getX() + RADIO_NODO, 
                        grafo2D.getNodos().get(i).getY() + RADIO_NODO, 
                        Color.BLACK
                    );
                    g2D.setPaint(grafoGradiente);
                    g2D.fill(new Ellipse2D.Double(
                        grafo2D.getNodos().get(i).getX(),
                        grafo2D.getNodos().get(i).getY(),
                        RADIO_NODO,
                        RADIO_NODO
                    ));
                }
            }
        };
        getContentPane().add(mapa);
    }
    
    
    public void cargarSolucion(ArrayList<Arista> caminoSolucion) {
        this.caminoSolucion = caminoSolucion;
    }
    
    
    public void cargarGrafo(Grafo grafo2D) {
        this.grafo2D = grafo2D;
    }
    
    
    private Line2D pintarArista(Arista arista) {
        return new Line2D.Double(
            arista.getNodei().getX() + AJUSTE_X,
            arista.getNodei().getY() + AJUSTE_Y,
            arista.getNodef().getX() + AJUSTE_X,
            arista.getNodef().getY() + AJUSTE_Y
        );
    }
}