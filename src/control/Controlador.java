package control;

import control.busqueda.AlgoritmoA;
import control.busqueda.AlgoritmoDijkstra;
import control.busqueda.Busqueda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Arista;
import modelo.Grafo;
import modelo.Nodo;
import vista.interfaz.Mapa_colombia;
import vista.interfaz.SelectorMunicipio;

public class Controlador implements ActionListener {
    private Busqueda busqueda;
    private final Grafo grafo;
    private final Mapa_colombia mapa;
    private final SelectorMunicipio selector;

    public Controlador(Grafo grafo, Mapa_colombia mapa, SelectorMunicipio selector) {
        this.mapa = mapa;
        this.selector = selector;
        this.grafo = new Grafo();
        this.grafo.generarNodos();
        this.grafo.generarAristas();
        selector.btnIniciar.addActionListener(this);
    }

    public void iniciar() throws IOException {

        DefaultComboBoxModel<String> modelo1 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> modelo2 = new DefaultComboBoxModel<>();
        for (int i = 0; i < grafo.getNodos().size(); i++) {
            modelo1.addElement(Integer.toString(grafo.getNodos().get(i).getId()));
            modelo2.addElement(Integer.toString(grafo.getNodos().get(i).getId()));
        }
        selector.cbMunicipio1.setModel(modelo1);
        selector.cbMunicipio2.setModel(modelo2);

        selector.setVisible(true);
    }

    private void buscar(Grafo grafo, Nodo nodo_A, Nodo nodo_B) throws IOException {
        ArrayList<Arista> caminoSolucion;

        caminoSolucion = busqueda.obtenerRuta(grafo, nodo_A, nodo_B);
        if (caminoSolucion != null) {
            mapa.cargarGrafo(grafo);
            mapa.cargarSolucion(caminoSolucion);
            mapa.pintar();
            mapa.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selector.btnIniciar) {
            int indiceNodo1 = selector.cbMunicipio1.getSelectedIndex();
            int indiceNodo2 = selector.cbMunicipio2.getSelectedIndex();
            String algoritmoSeleccionado = (String) selector.cbAlgoritmo.getSelectedItem();

            if ("A*".equals(algoritmoSeleccionado)) {
                setBusqueda(new AlgoritmoA());
            } else if ("Dijkstra".equals(algoritmoSeleccionado)) {
                setBusqueda(new AlgoritmoDijkstra());
            }

            if (indiceNodo1 == indiceNodo2 || algoritmoSeleccionado.equals("")) {
                JOptionPane.showMessageDialog(null, "Verifique la información ingresada.");
            } else {
                selector.dispose();
                try {
                    buscar(
                            grafo,
                            grafo.getNodos().get(indiceNodo1),
                            grafo.getNodos().get(indiceNodo2));
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    public void setBusqueda(Busqueda busqueda) {
        this.busqueda = busqueda;
    }

}
