package br.michel.modelo;

public class ModelCombo {

	public int id;
	   public String nome; 
	   public ModelCombo(int id,String nome){  
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
