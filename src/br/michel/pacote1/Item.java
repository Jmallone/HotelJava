package br.michel.pacote1;

public class Item{  
	  
	   public int id;
	   public String nome; 


	   
	   public Item(int id,String nome ){  
	       this.id = id;  
	       this.nome = nome;
	   }  
	   
	   public int getId(){
			
			return id;
			
		}
		
		public String getName(){
			
			return nome;
			
		}
	  
	   @Override  
	   public String toString(){  
	     return nome; 
	    }  
	}  
