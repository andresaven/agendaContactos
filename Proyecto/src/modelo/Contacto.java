package modelo;

import java.util.Objects;

public class Contacto {
	
	private int id;
	private String nombre, telefono;
	private boolean favorito;
	
	public Contacto() {
	
	}
	
	public Contacto(int id, String nombre, String telefono, boolean favorito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.favorito = favorito;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean isFavorito() {
		return favorito;
	}
	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	@Override
	public int hashCode() {
		return Objects.hash(favorito, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return favorito == other.favorito && Objects.equals(nombre, other.nombre)
				&& Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return nombre + ","  + telefono + "," + favorito;
	}
	
	
	
}
