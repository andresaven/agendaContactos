package modelo;

import java.util.ArrayList;

public class ListaContactos {


	private ArrayList<Contacto> listaC, listaCFav;
	private int contador;
	private int contadorFav;

	public ListaContactos() {
		
	}
	
	{
	listaC = new ArrayList<Contacto>();
	contador = 0;
	listaC.add(new Contacto(contador++,"Andrés Avendaño", "611222333", true));
	listaC.add(new Contacto(contador++,"Ana Martínez", "622333444", true));
	listaC.add(new Contacto(contador++,"Luis Gómez", "633444555", true));
	listaC.add(new Contacto(contador++,"Sofía López", "644555666", true));
	listaC.add(new Contacto(contador++,"María Fernández", "655666777", false));
	listaC.add(new Contacto(contador++,"Jorge García", "666777888", false));
	listaC.add(new Contacto(contador++,"Elena Rodríguez", "677888999", false));
	listaC.add(new Contacto(contador++,"David Sánchez", "688999000", false));
	listaC.add(new Contacto(contador++,"Lucía Pérez", "699000111", false));
	listaC.add(new Contacto(contador++,"Miguel Álvarez", "600111222", false));
	
	contadorFav = 0;
	listaCFav = new ArrayList<Contacto>();
	listaCFav.add(new Contacto(contadorFav++, "Andrés Avendaño", "611222333", true));
	listaCFav.add(new Contacto(contadorFav++, "Ana Martínez", "622333444", true));
	listaCFav.add(new Contacto(contadorFav++, "Luis Gómez", "633444555", true));
	listaCFav.add(new Contacto(contadorFav++, "Sofía López", "644555666", true));
	}
	
	
	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getContadorFav() {
		return contadorFav;
	}

	public void setContadorFav(int contadorFav) {
		this.contadorFav = contadorFav;
	}

	public ArrayList<Contacto> getListaC() {
		return listaC;
	}

	public void setListaC(ArrayList<Contacto> listaC) {
		this.listaC = listaC;
	}

	public ArrayList<Contacto> getListaCFav() {
		return listaCFav;
	}

	public void setListaCFav(ArrayList<Contacto> listaCFav) {
		this.listaCFav = listaCFav;
	}
	
	@Override
	public String toString() {
		return "ListaContactos [listaC=" + listaC + ", listaCFav=" + listaCFav + "]";
	}
	
    public Contacto buscarPorID(ArrayList<Contacto> lista, int id) {
        for (Contacto contacto : lista) {
            if (contacto.getId() == id) {
                return contacto;
            }
        }
        return null; 
    }
}
