/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaLibro;

import Libro.Libros;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ezequiel
 */
public class ListaLibro implements Serializable{
    private ArrayList <Libros> listaLibro;

    /**
     * @return the listaLibro
     */
    
    public ListaLibro() {
        listaLibro=new ArrayList();
    }

    public ListaLibro(ArrayList<Libros> listaLibro) {
        this.listaLibro = listaLibro;
    }
    

    public ArrayList <Libros> getListaLibro() {
        return listaLibro;
    }

    /**
     * @param listaLibro the listaLibro to set
     */
    public void setListaLibro(ArrayList <Libros> listaLibro) {
        this.listaLibro = listaLibro;
    }
    
}
