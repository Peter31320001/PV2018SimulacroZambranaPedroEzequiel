/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagenFormBean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import listadoI.ListadoI;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Ezequiel
 */
@ManagedBean
@SessionScoped
public class ImagenFormBean implements Serializable{
    private transient UploadedFile file = null;
    private byte[] imagen;
    private byte[] nuevaI;
    private ListadoI ListadoImagenes;

    /**
     * Creates a new instance of ImagenFormBean
     */
    public ImagenFormBean() {
        ListadoImagenes = new ListadoI();
    }

    public ImagenFormBean(byte[] imagen, byte[] nuevaI, ListadoI ListadoImagenes) {
        this.imagen = imagen;
        this.nuevaI = nuevaI;
        this.ListadoImagenes = ListadoImagenes;
    }
    
    public void agregarImagen() throws ParseException{
        setImagen(file.getContents());
        getListadoImagenes().llenarLitado(imagen);
        FacesMessage message= new FacesMessage("succesful",file.getFileName()+"is uploaded");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public StreamedContent getImagenSubida() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE){
            return new DefaultStreamedContent();
        }
        else{
            String nuevaImg = context.getExternalContext().getRequestParameterMap().get("numImg");
            int indice = Integer.parseInt(nuevaImg);
            setNuevaI(getListadoImagenes().getListadoI().get(indice).getImagen());
            if(getImagen()==null){
                return null;}
            else{
                return new DefaultStreamedContent(new ByteArrayInputStream(getImagen()));
            }
        }
    }
    public void reiniciarImagen(){
        ListadoImagenes = new ListadoI();
    }
    

    /**
     * @return the file
     */
    public UploadedFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(UploadedFile file) {
        this.file = file;
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
     * @return the nuevaI
     */
    public byte[] getNuevaI() {
        return nuevaI;
    }

    /**
     * @param nuevaI the nuevaI to set
     */
    public void setNuevaI(byte[] nuevaI) {
        this.nuevaI = nuevaI;
    }

    /**
     * @return the ListadoImagenes
     */
    public ListadoI getListadoImagenes() {
        return ListadoImagenes;
    }

    /**
     * @param ListadoImagenes the ListadoImagenes to set
     */
    public void setListadoImagenes(ListadoI ListadoImagenes) {
        this.ListadoImagenes = ListadoImagenes;
    }
    
}
