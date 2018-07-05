package modelo;


import java.io.File;
import java.io.InputStream;
import javax.persistence.Entity;


public class Arquivo extends GenericId {

	private String nome;
	private String caminho;
	private InputStream stream;
	private File file;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public InputStream getStream() {
		return stream;
	}
	public void setStream(InputStream stream) {
		this.stream = stream;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	
	
	
	
}
