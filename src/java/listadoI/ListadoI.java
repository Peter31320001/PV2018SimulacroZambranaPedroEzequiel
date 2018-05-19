/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadoI;

import imagen.Imagen;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ezequiel
 */
public class ListadoI implements Serializable{
    private byte[] imagen;
    private int numI;
    private ArrayList<Imagen> listadoI;
    
   

    public ListadoI() {
        listadoI = new ArrayList();
    }

    public ListadoI(byte[] imagen, int numI, ArrayList<Imagen> listadoI) {
        this.imagen = imagen;
        this.numI = numI;
        this.listadoI = listadoI;
    }
    
     public void llenarLitado(byte[] imgGuardar){
        if(getListadoI().isEmpty()){
            setNumI(0);
        }
        else{
            setNumI(getListadoI().size());
        }
        getListadoI().add(new Imagen (getNumI(),imgGuardar));
    }

    
    /**
     * @return the imagen
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the numI
     */
    public int getNumI() {
        return numI;
    }

    /**
     * @param numI the numI to set
     */
    public void setNumI(int numI) {
        this.numI = numI;
    }

    /**
     * @return the listadoI
     */
    public ArrayList<Imagen> getListadoI() {
        return listadoI;
    }

    /**
     * @param listadoI the listadoI to set
     */
    public void setListadoI(ArrayList<Imagen> listadoI) {
        this.listadoI = listadoI;
    }
    
}
