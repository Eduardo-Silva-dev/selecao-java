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

import com.indra.apirest.domain.Coleta;
import com.indra.apirest.domain.Endereco;
import com.indra.apirest.domain.Preco;
import com.indra.apirest.domain.Produto;
import com.indra.apirest.domain.Revendedor;
import com.indra.apirest.domain.Usuario;
import com.indra.apirest.repository.ColetaRepository;
import com.indra.apirest.repository.EnderecoRepository;
import com.indra.apirest.repository.PrecoRepository;
import com.indra.apirest.repository.ProdutoRepository;
import com.indra.apirest.repository.RevendedorRepository;

@Service
public class ArquivoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PrecoRepository precoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ColetaRepository coletaRepository ;

	@Autowired
	private RevendedorRepository revendedorRepository ;

	@Autowired
	private UsuarioService usuarioService;
	
	
	public void insertFile(Usuario user,MultipartFile file,String nome) {
		
		String linha = "";
		
		String csvSeparadorCampo = "	";
		
		BufferedReader conteudoCsv = null;

		List<Revendedor> revendedores = new ArrayList<>();
		
		List<Produto> produtos = new ArrayList<>();
		
		List<Preco> precos = new ArrayList<>();
		
		List<Coleta> coletas = new ArrayList<>();
		
		List<Endereco> enderecos = new ArrayList<>();
		
		String caminho = insertCSV(file, nome);
		
		user.setCaminho(caminho);
		
		usuarioService.update(user, user.getId());
		
		try {

			conteudoCsv = new BufferedReader(new FileReader(caminho));
			
			while ((linha = conteudoCsv.readLine())!=null) {	
				
					String[] dado = linha.split(csvSeparadorCampo);
	
					Revendedor rev = new Revendedor(dado[4]);
					Endereco end = new Endereco(dado[0], dado[2],dado[1]);
					end.setRevendedor(rev);
					Produto prod = new Produto(dado[3], dado[5],dado[9],dado[10]);
					prod.setRevendedor(rev);
					Preco prec = new Preco(dado[8],dado[7]);
					prec.setProduto(prod);
					Coleta col = new Coleta(dado[6]);
					col.setProduto(prod);
					linha = conteudoCsv.readLine();
					enderecos.add(end);
					revendedores.add(rev);
					produtos.add(prod);
					precos.add(prec);
					coletas.add(col);
					
			}
			saveAllEnderecos(enderecos);
			saveAllRevendedores(revendedores);
			saveAllColetas(coletas);
			saveAllPrecos(precos);
			saveAllProdutos(produtos);

		} catch (Exception e) {

		}
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
	
	public void saveAllEnderecos(List<Endereco> enderecos) {
		enderecoRepository.saveAll(enderecos);
	}
	
	public void saveAllRevendedores(List<Revendedor> revendedores) {
		revendedorRepository.saveAll(revendedores);
	}
	
	public void  saveAllProdutos(List<Produto> produtos) {
		produtoRepository.saveAll(produtos);
	}
	
	public void  saveAllPrecos(List<Preco> precos) {
		precoRepository.saveAll(precos);
	}
	
	public void saveAllColetas(List<Coleta> coletas) {
		coletaRepository.saveAll(coletas);
	}
	
}
