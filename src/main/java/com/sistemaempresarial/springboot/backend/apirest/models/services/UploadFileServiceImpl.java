package com.sistemaempresarial.springboot.backend.apirest.models.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements IUploadFileService {
	
	private final Logger log= LoggerFactory.getLogger(UploadFileServiceImpl.class); 
	private final static String DIRECTORIO_UPLOAD = "uploads";

	@Override
	public Resource carregar(String nomeFoto) throws MalformedURLException {
		Path rotaArquivo = getPath(nomeFoto);
		log.info(rotaArquivo.toString());

		Resource recurso = new UrlResource(rotaArquivo.toUri());

		if(!recurso.exists() && !recurso.isReadable()) {
			rotaArquivo = Paths.get("src/main/resources/static/images").resolve("no-usuario.png").toAbsolutePath();	
			
				recurso = new UrlResource(rotaArquivo.toUri());
			
			log.error("Erro: Não se pode carregar a imagem " + nomeFoto);
		}
		return recurso;
	}

	@Override
	public String guardar(MultipartFile arquivo) throws IOException {
		String nomeArquivo = UUID.randomUUID().toString() + "_" + arquivo.getOriginalFilename().replace(" ", "");
		
		Path rotaArquivo = getPath(nomeArquivo);
		log.info(rotaArquivo.toString());

			Files.copy(arquivo.getInputStream(), rotaArquivo);
		
		return nomeArquivo;
	}

	@Override
	public boolean eliminar(String nomeFoto) {
		if(nomeFoto!=null && nomeFoto.length()>0) {
			Path rotaFotoAnterior = Paths.get("uploads").resolve(nomeFoto).toAbsolutePath();
			File arquivoFotoAnterior = rotaFotoAnterior.toFile();
			if(arquivoFotoAnterior.exists() && arquivoFotoAnterior.canRead()) {
				arquivoFotoAnterior.delete();
				return true;
			}
		}
		return false;
	}

	@Override
	public Path getPath(String nomeFoto) {
		return Paths.get(DIRECTORIO_UPLOAD).resolve(nomeFoto).toAbsolutePath();
	}

}
