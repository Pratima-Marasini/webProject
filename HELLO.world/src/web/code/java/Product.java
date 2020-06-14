package web.code.java;

public class Product {
	
 
	    private int id;
	    private String name;
	    private float price;
	    
	    public Product() {
	    }
	 
	    public Product(int id) {
	        this.id = id;
	    }
	 
	    
	 
	    public Product(int id, String name, float price) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
	    }
	 
	        
	 
	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + id;
	        return result;
	    }
	 
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Product other = (Product) obj;
	        if (id != other.id)
	            return false;
	        return true;
	    }

		public void setId(int newId) {
			 
			
		}  
	}



