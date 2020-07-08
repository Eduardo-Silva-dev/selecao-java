package com.indra.apirest.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.indra.apirest.domain.Arquivo;
import com.indra.apirest.domain.Coleta;
import com.indra.apirest.domain.Endereco;
import com.indra.apirest.domain.Preco;
import com.indra.apirest.domain.Produto;
import com.indra.apirest.domain.Revendedor;
import com.indra.apirest.domain.Usuario;
import com.indra.apirest.repository.ArquivoRepository;

@Service
public class ArquivoService {

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ArquivoRepository arquivoRepository;

	@Autowired
	private ColetaService coletaService ;

	@Autowired
	private RevendedorService revendedorService ;

	@Autowired
	private UsuarioService usuarioService;
	
	public void insertFile(Usuario user,MultipartFile file,String nome) {

		String linha = "";
		
		BufferedReader conteudoCsv = null;
		
		List<Revendedor> revendedores = new ArrayList<>();
		
		List<Produto> produtos = new ArrayList<>();
		
		List<Preco> precos = new ArrayList<>();
		
		List<Coleta> coletas = new ArrayList<>();
		
		List<Endereco> enderecos = new ArrayList<>();
		
		String caminho = insertCSV(file, nome);
		
		Arquivo arquivo = new Arquivo(caminho, nome);
		arquivo.setUsuario(user);
		arquivoRepository.save(arquivo);
		
		user.getArquivos().add(arquivo);
		
		usuarioService.update(user, user.getId());
		
		try {

			conteudoCsv = new BufferedReader(new FileReader(caminho));
			
			while ((linha = conteudoCsv.readLine())!=null) {	
				
					String[] dado = linha.split("\t");
	
					Revendedor rev = new Revendedor(removoCaracter(dado[4]));
					
					Endereco end = new Endereco(
							removoCaracter(dado[0]),
							removoCaracter(dado[2]),
							removoCaracter(dado[1]));
					end.setRevendedor(rev);
					
					Produto prod = new Produto(
							removoCaracter(dado[3]),
							removoCaracter(dado[5]),
							removoCaracter(dado[9]),
							removoCaracter(dado[10]));
					prod.setRevendedor(rev);
					
					Preco prec = new Preco(
							removoCaracter(dado[8]),
							removoCaracter(dado[7]));
					prec.setProduto(prod);
					
					Coleta col = new Coleta(removoCaracter(dado[6]));
					col.setProduto(prod);
					
					linha = conteudoCsv.readLine();
					
					enderecos.add(end);
					revendedores.add(rev);
					produtos.add(prod);
					precos.add(prec);
					coletas.add(col);
					
			}
			
			removoCabecalho(enderecos);
			removoCabecalho(revendedores);
			removoCabecalho(produtos);
			removoCabecalho(precos);
			removoCabecalho(coletas);
			
			enderecoService.saveAllEnderecos(enderecos);
			revendedorService.saveAllRevendedores(revendedores);
			coletaService.saveAllColetas(coletas);
			produtoService.saveAllPrecos(precos);
			produtoService.saveAllProdutos(produtos);

			conteudoCsv.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void removoCabecalho(List<?> lista) {
		lista.remove(0);
	}
	
	private String removoCaracter(String dado) {
		dado = dado.replace("\0", "");
		dado = dado.replace("��", "");
		dado = dado.replace(",", ".");
		return dado;
	}
	
	private String insertCSV (MultipartFile file,String nome) {
		
		File diretorio = new File("arquivos"); 
		
		if (!diretorio.exists()) { 
			diretorio.mkdirs(); 
		}

		Path path = Paths.get(diretorio.getAbsolutePath().toString()+"/"  + nome +".csv");
		
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String nomeArquivo = path.toString();
		
		return nomeArquivo;	
	}	
}
