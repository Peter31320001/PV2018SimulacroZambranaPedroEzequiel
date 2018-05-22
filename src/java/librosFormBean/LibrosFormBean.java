/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librosFormBean;

import Libro.Libros;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import listaLibro.ListaLibro;

/**
 *
 * @author Ezequiel
 */
@ManagedBean
@ViewScoped
public class LibrosFormBean implements Serializable{
    private String isbn;
    private String titulo;
    private String autor;
    private double precio;
    private ListaLibro listadoLibros;
    private ListaLibro listadoLibrosAuxiliar;
    private String auxiliarTitulo;
    

    /**
     * Creates a new instance of LibrosFormBean
     */
    public LibrosFormBean() {
        listadoLibros = new ListaLibro();
        listadoLibrosAuxiliar = new ListaLibro();
    }

    public LibrosFormBean(String isbn, String titulo, String autor, double precio, ListaLibro listadoLibros, ListaLibro listadoLibrosAuxiliar, String auxiliarTitulo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.listadoLibros = listadoLibros;
        this.listadoLibrosAuxiliar = listadoLibrosAuxiliar;
        this.auxiliarTitulo = auxiliarTitulo;
    }
    public void guardarLibros() {
        getListadoLibros().getListaLibro().add(new Libros(getIsbn(),getTitulo(),getAutor(),getPrecio()));
    }
    public void buscarLibros() {
        for (int i = 0; i < getListadoLibros().getListaLibro().size(); i++) {
            if (getListadoLibros().getListaLibro().get(i).getTitulo().equals(getAuxiliarTitulo())) {
                getListadoLibrosAuxiliar().getListaLibro().add(getListadoLibros().getListaLibro().get(i));
            }
        }
    }
    public void reinciarLibros() {
        listadoLibros = new ListaLibro();
        listadoLibrosAuxiliar = new ListaLibro();
    }
    
    

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the listadoLibros
     */
    public ListaLibro getListadoLibros() {
        return listadoLibros;
    }

    /**
     * @param listadoLibros the listadoLibros to set
     */
    public void setListadoLibros(ListaLibro listadoLibros) {
        this.listadoLibros = listadoLibros;
    }

    /**
     * @return the listadoLibrosAuxiliar
     */
    public ListaLibro getListadoLibrosAuxiliar() {
        return listadoLibrosAuxiliar;
    }

    /**
     * @param listadoLibrosAuxiliar the listadoLibrosAuxiliar to set
     */
    public void setListadoLibrosAuxiliar(ListaLibro listadoLibrosAuxiliar) {
        this.listadoLibrosAuxiliar = listadoLibrosAuxiliar;
    }

    /**
     * @return the auxiliarTitulo
     */
    public String getAuxiliarTitulo() {
        return auxiliarTitulo;
    }

    /**
     * @param auxiliarTitulo the auxiliarTitulo to set
     */
    public void setAuxiliarTitulo(String auxiliarTitulo) {
        this.auxiliarTitulo = auxiliarTitulo;
    }
    
}
