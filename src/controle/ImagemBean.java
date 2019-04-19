package controle;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@RequestScoped
@ManagedBean
public class ImagemBean {
	
	@ManagedProperty("#{param.caminho}")
	
	
	
	private String caminho;
	private String local = "C:/java/ImagensRevisapp/";
	private StreamedContent foto;
	
		
	
		public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	public StreamedContent getFoto() throws IOException {
		if (caminho == null || caminho.isEmpty()) {
			 
			Path path = Paths.get(local + "branco.png");
			InputStream stream = Files.newInputStream(path);
			foto = new  DefaultStreamedContent(stream);
			System.out.println(caminho);
		}else {
			
			Path path = Paths.get(local + caminho);
			InputStream stream = Files.newInputStream(path);
			foto = new  DefaultStreamedContent(stream, "image/jpg", caminho);
			System.out.println(caminho);
		}
		return foto;
	}
	public void setFoto(StreamedContent foto) {
		this.foto = foto;
	}
	
	public void testarCaminho() {
		
		System.out.println(caminho);
	}
	
	
	
	
	
	

}
