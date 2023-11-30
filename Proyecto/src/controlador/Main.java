package controlador;

import modelo.ListaContactos;
import vista.Add;
import vista.Buscar;
import vista.Favoritos;
import vista.Update;
import vista.VistaPrincipal;

public class Main {

	public static void main(String[] args) {
		ListaContactos lCG = new ListaContactos();
		VistaPrincipal vistaPrincipal = new VistaPrincipal(lCG);
		Favoritos favoritos = new Favoritos(lCG, vistaPrincipal);
		Add add = new Add(vistaPrincipal);
		Update upd = new Update(vistaPrincipal);
		Buscar b = new Buscar(vistaPrincipal);
		
		
		Controlador controlador = new Controlador(lCG, vistaPrincipal, favoritos, add, upd, b);
		ControladorFav controladorFav = new ControladorFav(lCG, favoritos);
		ControladorAdd controladorAdd = new ControladorAdd(lCG, add, vistaPrincipal, favoritos);
		ControladorUpdate controladorUpdate = new ControladorUpdate(lCG, upd, vistaPrincipal, favoritos);
		ControladorBuscar controladorBuscar = new ControladorBuscar(lCG, vistaPrincipal, b);

		
		controladorFav.cargarTablas();
		
		vistaPrincipal.establecerListeners(controlador);
		favoritos.establecerListeners(controladorFav);
		add.establecerListeners(controladorAdd);
		upd.establecerListeners(controladorUpdate);
		b.establecerListeners(controladorBuscar);

	}

}
