/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.controladores;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.ModeloComboGrupos;
import grupos.modelos.Rol;
import idiomas.modelos.Idioma;
import idiomas.modelos.ModeloComboIdiomas;
import interfaces.IControladorAMPublicacion;
import interfaces.IControladorPrincipal;
import interfaces.IGestorGrupos;
import interfaces.IGestorPalabrasClaves;
import interfaces.IGestorPublicaciones;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import lugares.modelos.Lugar;
import lugares.modelos.ModeloComboLugares;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.ModeloTablaPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.Publicacion;
import publicaciones.vistas.VentanaAMPublicacion;
import publicaciones.vistas.VentanaPublicaciones;
import tipos.modelos.ModeloComboTipos;
import tipos.modelos.Tipo;

/**
 *
 * @author Windows 10
 */
public class ControladorAMPublicacion implements IControladorAMPublicacion{
    private VentanaAMPublicacion ventana;
    private VentanaPublicaciones ventanaPublicaciones;
    
    private Publicacion pub;

    public ControladorAMPublicacion() {
        this.ventana = new VentanaAMPublicacion(this, ventanaPublicaciones, true);
        this.ventana.setTitle(TITULO_NUEVA);
        this.ventana.getComboIdiomas().setModel(new ModeloComboIdiomas());
        this.ventana.getComboLugares().setModel(new ModeloComboLugares());
        this.ventana.getComboTipos().setModel(new ModeloComboTipos());
        this.ventana.getComboGrupos().setModel(new ModeloComboGrupos());
        this.ventana.setLocationRelativeTo(null);
        this.ventana.getTablaPalabrasClaves().setModel(new ModeloTablaPalabrasClaves());
        this.ventana.setVisible(true);
    }
    
    public ControladorAMPublicacion(String titulo) {
        IGestorPublicaciones gp = GestorPublicaciones.crear();
        pub = gp.verPublicacion(titulo);
        this.ventana = new VentanaAMPublicacion(this, ventanaPublicaciones, true);
        this.ventana.setTitle(TITULO_MODIFICAR);
        this.ventana.getComboIdiomas().setModel(new ModeloComboIdiomas());
        this.ventana.getComboLugares().setModel(new ModeloComboLugares());
        this.ventana.getComboTipos().setModel(new ModeloComboTipos());
        this.ventana.getComboGrupos().setModel(new ModeloComboGrupos());
        this.ventana.getTxtTitulo().setEditable(false);
        this.ventana.getTxtTitulo().setText(gp.verPublicacion(titulo).verTitulo());
        this.ventana.getComboIdiomas().setSelectedItem(gp.verPublicacion(titulo).verIdioma());
        this.ventana.getComboLugares().setSelectedItem(gp.verPublicacion(titulo).verLugar());
        this.ventana.getComboTipos().setSelectedItem(gp.verPublicacion(titulo).verTipo());
        this.ventana.getComboGrupos().setSelectedItem(gp.verPublicacion(titulo).verMiembro().verGrupos());
        Date date = Date.from(gp.verPublicacion(titulo).verFechaPublicacion().atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.ventana.getDateChooserFecha().setDate(date);
        this.ventana.getTxtEnlace().setText(gp.verPublicacion(titulo).verEnlace());
        this.ventana.getTablaPalabrasClaves().setModel(new ModeloTablaPalabrasClaves());
        this.ventana.getTablaPalabrasClaves().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.ventana.getTxtResumen().setText(gp.verPublicacion(titulo).verResumen());
        this.ventana.setLocationRelativeTo(null);
        this.hayPalabrasClaves();
        this.ventana.setVisible(true); 
    }
    
    

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        IGestorPublicaciones gp = GestorPublicaciones.crear();
        String titulo = this.ventana.getTxtTitulo().getText().trim();
        String resumen = this.ventana.getTxtResumen().getText().trim();
        String enlace = this.ventana.getTxtEnlace().getText().trim();
        Lugar lugar = ((ModeloComboLugares)this.ventana.getComboLugares().getModel()).obtenerLugar();
        Idioma idioma = ((ModeloComboIdiomas)this.ventana.getComboIdiomas().getModel()).obtenerIdioma();
        Tipo tipo = ((ModeloComboTipos)this.ventana.getComboTipos().getModel()).obtenerTipo();
        String grupo = ((ModeloComboGrupos)this.ventana.getComboGrupos().getModel()).obtenerGrupo();
        Date date = this.ventana.getDateChooserFecha().getCalendar().getTime();
        LocalDate fecha = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        IGestorGrupos gg = GestorGrupos.crear();
        MiembroEnGrupo miembro = new MiembroEnGrupo(gg.verGrupo(grupo).verMiembros().get(0).verAutores(), gg.verGrupo(grupo), gg.verGrupo(grupo).verMiembros().get(0).verRol());
        if((!titulo.isBlank() && titulo!= null) && (!resumen.isBlank() && resumen != null) && (!enlace.isBlank() && enlace != null) && (lugar != null) && (idioma != null) && (tipo != null) && (!grupo.isBlank() && grupo!= null) && (fecha != null)){
            if(this.ventana.getTxtTitulo().isEditable()){
                List<PalabraClave> palabrasClave = new ArrayList<>();
                ListSelectionModel modeloSeleccion = this.ventana.getTablaPalabrasClaves().getSelectionModel();
                ModeloTablaPalabrasClaves mt = (ModeloTablaPalabrasClaves)this.ventana.getTablaPalabrasClaves().getModel();
                    for(int fila = 0; fila < mt.getRowCount(); fila++) {
                        if(modeloSeleccion.isSelectedIndex(fila)){
                            PalabraClave p = mt.verPalabraClave(fila);
                            palabrasClave.add(p);
                        }
                        if(!modeloSeleccion.isSelectedIndex(fila)){
                            PalabraClave p = mt.verPalabraClave(fila);
                            palabrasClave.remove(p);
                        }
                        if(modeloSeleccion.isSelectionEmpty()){
                            palabrasClave.clear();
                            PalabraClave p = new PalabraClave("Sin Palabras Clave");
                            palabrasClave.add(p);
                        }
                    }
                    gp.nuevaPublicacion(titulo, miembro, fecha, tipo, idioma, lugar, palabrasClave, enlace, resumen);
                    this.ventana.dispose();    
            }
            else{
                if(!this.ventana.getTxtTitulo().isEditable()){
                    List<PalabraClave> palabrasClave = new ArrayList<>();
                    ListSelectionModel modeloSeleccion = this.ventana.getTablaPalabrasClaves().getSelectionModel();
                    ModeloTablaPalabrasClaves mt = (ModeloTablaPalabrasClaves)this.ventana.getTablaPalabrasClaves().getModel();
                    for(int fila = 0; fila < mt.getRowCount(); fila++) {
                        if(modeloSeleccion.isSelectedIndex(fila)){
                            PalabraClave p = mt.verPalabraClave(fila);
                            palabrasClave.add(p);
                        }
                        if(!modeloSeleccion.isSelectedIndex(fila)){
                            PalabraClave p = mt.verPalabraClave(fila);
                            palabrasClave.remove(p);
                        }
                        if(modeloSeleccion.isSelectionEmpty()){
                            palabrasClave.clear();
                            PalabraClave p = new PalabraClave("Sin Palabras Clave");
                            palabrasClave.add(p);
                        }
                    }
                    gp.modificarPublicacion(gp.verPublicacion(titulo), miembro, fecha, tipo, idioma, lugar, palabrasClave, enlace, resumen);
                    JOptionPane.showMessageDialog(ventana, "Publicación Modificada con Éxito!");
                    this.ventana.dispose();
                }
            }
            
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void txtTituloPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!Character.isLetter(c) && !Character.isWhitespace(c))
            evt.consume();
    }

    @Override
    public void btnTodasLasPalabrasClavesClic(ActionEvent evt) {
        ModeloTablaPalabrasClaves mtpc = (ModeloTablaPalabrasClaves)this.ventana.getTablaPalabrasClaves().getModel();
        ListSelectionModel modeloSeleccion = this.ventana.getTablaPalabrasClaves().getSelectionModel();
        modeloSeleccion.addSelectionInterval(0, mtpc.getRowCount() - 1);
    }

    @Override
    public void btnNingunaPalabraClaveClic(ActionEvent evt) {
        ListSelectionModel modeloSeleccion = this.ventana.getTablaPalabrasClaves().getSelectionModel();
        modeloSeleccion.clearSelection();
    }

    @Override
    public void btnAbrirClic(ActionEvent evt) {
        //Se ponen en español los nombres de los botones de la ventana de diálogo
        UIManager.put("FileChooser.openButtonText","Abrir");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText","Cancelar");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
        UIManager.put("FileChooser.lookInLabelText", "Buscar en:");
        UIManager.put("FileChooser.fileNameLabelText", "Archivo:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Archivos del tipo:");
        UIManager.put("FileChooser.upFolderToolTipText", "Subir un nivel");
        UIManager.put("FileChooser.homeFolderToolTipText", "Inicio");
        UIManager.put("FileChooser.newFolderToolTipText", "Carpeta nueva");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalles");
        
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new File(System.getProperty("user.home")));
        //se establece la carpeta personal del usuario para empezar la búsqueda
        selector.setDialogTitle(IControladorPrincipal.TITULO);
        selector.setAcceptAllFileFilterUsed(false); //no se muestra el filtro de todos los archivos
        
        int resultado = selector.showOpenDialog(null);
        
        if (resultado == JFileChooser.APPROVE_OPTION) { //se selecciona un archivo
            File selectedFile = selector.getSelectedFile();
            this.ventana.getTxtEnlace().setText(selectedFile.getAbsolutePath());
        }
    }
    
    public void hayPalabrasClaves(){
        ListSelectionModel modeloSeleccion = this.ventana.getTablaPalabrasClaves().getSelectionModel();
        ModeloTablaPalabrasClaves mt = (ModeloTablaPalabrasClaves)this.ventana.getTablaPalabrasClaves().getModel();
        for(PalabraClave palabraClave : pub.verPalabrasClaves()) {
            for(int fila = 0; fila < mt.getRowCount(); fila++) {
                PalabraClave pc = mt.verPalabraClave(fila);
                if (palabraClave.equals(pc)) {
                    modeloSeleccion.addSelectionInterval(fila, fila);
                    break;
                }
            }
        }
    }
    
}
