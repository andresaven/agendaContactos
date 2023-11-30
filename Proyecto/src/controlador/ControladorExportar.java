package controlador;

import java.io.FileWriter;
import java.io.IOException;

import modelo.Contacto;
import modelo.ListaContactos;

public class ControladorExportar {

    private ListaContactos listaContactos;

    public ControladorExportar(ListaContactos listaContactos) {
        this.listaContactos = listaContactos;
    }

    public void exportarCSV(String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
        	writer.append("--NOMBRE--TELEFONO--FAVORITO--\n");
            for (Contacto contacto : listaContactos.getListaC()) {
                writer.append(contacto.toString());
                writer.append("\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
