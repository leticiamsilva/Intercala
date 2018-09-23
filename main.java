package Intercala;


import java.io.RandomAccessFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class main {
	
	public static void main(String[] args) throws Exception 
	{
		//Intercala();
		
		RandomAccessFile f1 = new RandomAccessFile("arquivo1.txt", "r");
		RandomAccessFile f2 = new RandomAccessFile("arquivo2.txt", "r");	
		
		Endereco2 e = new Endereco2();		
		
		String cep1 = "";
		String cep2 = "";
		String conteudo = "";
		String nomeArquivo = "arquivoOrdenado.txt";
		
		File fEscreve = new File(nomeArquivo);
		BufferedWriter  bw;
		
		long tamanho = f2.length();		
		if(f1.length() < f2.length())
			tamanho = f1.length();
		
		 try 
		 {
			 f1.seek(0);
			 f2.seek(0);
			 
			 for(int i=0; i< tamanho; i++)
			 {
				 
				 e.leEndereco(f1);
				 cep1 = e.getCep();
				 
				 e.leEndereco(f2);
				 cep2 = e.getCep();
			
				 if(cep1.compareTo(cep2) < 0)
					 e.leEndereco(f1);
				 
				 
				conteudo = "";
				conteudo += e.getLogradouro();
				conteudo += e.getBairro();
				conteudo += e.getCidade();
				conteudo += e.getEstado();
				conteudo += e.getSigla();
				conteudo += e.getCep();
				
				bw = new BufferedWriter(new FileWriter(fEscreve, true));
				bw.write(conteudo);
				bw.close();		
				
			 }
			 
			 RandomAccessFile auxF;
			 //comparacao para saber se tamanho == tamanho de f1 é porque f1 é menor e precisa terminar de ler f2 
			 if(tamanho == f1.length())
				 auxF = f2;	
			 else
				 auxF = f1;		
			 
			 
			 while(tamanho < auxF.length())
			 {
				 	 e.leEndereco(auxF);
			 		 conteudo = "";
					 conteudo += e.getLogradouro();
					 conteudo += e.getBairro();
					 conteudo += e.getCidade();
					 conteudo += e.getEstado();
					 conteudo += e.getSigla();
					 conteudo += e.getCep();
							
						bw = new BufferedWriter(new FileWriter(fEscreve, true));
						bw.write(conteudo);
						bw.close();
				
						tamanho++;	
			 }
		 }
		 catch(Exception ex){}
	}
	
	public static void Intercala() throws FileNotFoundException
	{
		RandomAccessFile f = new RandomAccessFile("cep_ordenado.dat", "r");
		
		Endereco2 e = new Endereco2();
		
		String nomeArquivo1 = "arquivo1.txt";
		String nomeArquivo2 = "arquivo2.txt";
		
		File fEscreve1 = new File(nomeArquivo1);
		File fEscreve2 = new File(nomeArquivo1);
		
		BufferedWriter  bw;
			
	    try {	  
	    	
	    	fEscreve1 = new File(nomeArquivo1);
	    	fEscreve2 = new File(nomeArquivo2);
	    	
	    	f.seek(0);	
	    	
	    	for(int i=0; i < f.length(); i++)
	    	{	    			    		
	    		    		
	    		e.leEndereco(f);
	    		
	    		double numero = Math.random() * 100;
	    		double valorAleatorio = Math.round(numero);
	    		
	    		String conteudo = "";
				conteudo += e.getLogradouro();
				conteudo += e.getBairro();
				conteudo += e.getCidade();
				conteudo += e.getEstado();
				conteudo += e.getSigla();
				conteudo += e.getCep();
				
	    		if(valorAleatorio % 2 < 1)
	    			bw = new BufferedWriter(new FileWriter(fEscreve1, true));
	    		else
	    			bw = new BufferedWriter(new FileWriter(fEscreve2, true));
	    		    			    		
				bw.write(conteudo);
				bw.close();	    			
		    		    	
	    	}
	    	
	    	f.close();
	    		    	
	    }
	    				
	    catch(Exception ex){}
	}

}
