package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    /**
     * El panel donde se editan los detalles del restaurante
     */
    private PanelEditarRestaurante panelDetalles;

    /**
     * El panel con los botones para agregar un restaurante o cerrar la ventana
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * El panel para marcar la ubicación del restaurante
     */
    private PanelMapaAgregar panelMapa;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante( VentanaPrincipal principal )
    {
        this.ventanaPrincipal = principal;
        setLayout( new BorderLayout( ) );

        JPanel panelSur = new JPanel();
        panelSur.setLayout((LayoutManager) new BoxLayout(panelSur, BoxLayout.Y_AXIS));
        
        // Agrega el panel donde va a estar el mapa
        panelMapa = new PanelMapaAgregar();
        add(panelMapa, BorderLayout.CENTER);

        
        // Agrega en el sur un panel para los detalles del restaurante y para los botones
        panelBotones = new PanelBotonesAgregar(this);
        panelDetalles = new PanelEditarRestaurante();
        panelSur.add(panelDetalles);
        panelSur.add(panelBotones);
        
        add(panelSur, BorderLayout.SOUTH);

        // Termina de configurar la ventana
        pack( );
        setTitle("Agregar restaurante");
        setSize( 400, 600 );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setResizable( false );
        
    }

    /**
     * Le pide al panelDetalles los datos del nuevo restaurante y se los envía a la ventana principal para que cree el nuevo restaurante, y luego cierra la ventana.
     */
    public void agregarRestaurante( )
    {
        // TODO completar
    	String nombre = panelDetalles.getNombre();
    	int calificacion = panelDetalles.getCalificacion();
    	int[] coordenadas = panelMapa.getCoordenadas();
    	int coordX = coordenadas[0];
    	int coordY = coordenadas[1];
    	boolean visitado = panelDetalles.getVisitado();
    	ventanaPrincipal.agregarRestaurante(nombre, calificacion, coordX, coordY, visitado);
    }

    /**
     * Cierra la ventana sin crear un nuevo restaurante
     */
    public void cerrarVentana( )
    {
        dispose( );
    }

}
