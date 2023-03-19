package DynamicArray;

public class numberUtilities {
	  private int [] data;
	    private int size;
	    
	    public numberUtilities(){
	        data = new int[10];
	        size = 0;
	    }
	    
	    public int size(){
	        return size;
	    }
	    
	    private void grow(){
	        int [] temp = new int[data.length*2];
	        for(int i = 0; i < data.length; i++){
	            temp[i] = data[i];
	        }
	        data = temp;
	    }
	    
	    public boolean add(int value){
	        if(size < data.length){
	            data[size] = value;
	        }else{
	            grow();
	            data[size] = value;
	        }
	        size++;
	        return true;
	    }
	    
	    public boolean altAdd(int value){
	        if(size < data.length){
	            grow();
	        }
	        data[size] = value;
	        size++;
	        return true;
	    }
	    
	    public boolean contains(int value){
	        for(int i = 0; i < size; i++){
	            if(data[i] == value){
	                return true;
	            }
	        }
	        return false;
	    }
	    
		public boolean shiftInsert(int value, int pos) {
			boolean isTrue = false;
			if (pos > size || value == -1 || pos < 0) {
				throw new IndexOutOfBoundsException("Position is out of bounds");
			} else {
				int prev = value;
				for (int i = pos; i < size; i++) {
					int temp = data[i];
					data[i] = prev;
					prev = temp;
				}
				isTrue = true;
			}
			return isTrue;
		}
	
		public boolean add(int str, int pos) {
			if (pos > size || pos < 0) {
				throw new IndexOutOfBoundsException("Position is out of bounds");
			}
			if (size == data.length) {
				 grow();
			}
			shiftInsert(str, pos);
			size++;
			return true;
		}
		
	    
	    public int get(int index){
	        if(index < 0 || index >= size){
	            throw new IndexOutOfBoundsException("Illegal position supplied.");
	        }
	        return data[index];
	    }
	    
	    public int remove(int index){
	        if(index < 0 || index >= size){
	            throw new IndexOutOfBoundsException("Illegal position supplied.");
	        }
	        int removedElement = data[index];
	        for(int i = index; i < size-1; i++){
	            data[i] = data[i+1];
	        }
	        data[size-1] = 0;
	        size--;
	        return removedElement;
	    }
	}