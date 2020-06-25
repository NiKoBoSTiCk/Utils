package poo.util;

public final class Array{
	private Array(){} //classe di utilita'
	
	public static int ricercaLineare(int[] v, int x){
		for(int i=0; i<v.length; i++)
			if(v[i]==x) return i;
		return -1;
	}//ricercaLineare
	
	public static int ricercaLineareOttimizzata(int[] v, int x){
		//v ordinato per valori crescenti
		for( int i=0; i<v.length; i++ ){
			if(v[i]==x) return i;
			if(v[i]>x) return -1;
		}
		return -1;
	}//ricercaLineareOttimizzata
	
	public static <T extends Comparable<? super T>> int ricercaLineare(T[] v, T x){
		for(int i=0; i<v.length; i++)
			if(v[i].compareTo(x)==0) return i;
		return -1;
	}//ricercaLineare

	public static <T extends Comparable<? super T>> int ricercaLineareOttimizzata(T[] v, T x){
		//v ordinato per valori crescenti
		for(int i=0; i<v.length; i++){
			if(v[i].compareTo(x)==0) return i;
			if(v[i].compareTo(x)>0) return -1;
		}
		return -1;
	}//ricercaLineareOttimizzata
	
	public static <T extends Comparable<? super T>> int ricercaLineare(T[] v, T x, int size) {
		if(size<0 || size>v.length) throw new IllegalArgumentException();
		for(int i=0; i<size; i++)
			if(v[i].compareTo(x)==0) return i;
		return -1;
	}//ricercaLineare

	public static <T extends Comparable<? super T>> int ricercaLineareOttimizzata(T[] v, T x, int size) {
		if(size<0 || size>v.length) throw new IllegalArgumentException();
		//v ordinato per valori crescenti
		for(int i=0; i<size; i++) {
			if(v[i].compareTo(x)==0) return i;
			if(v[i].compareTo(x)>0) return -1;
		}
		return -1;
	}//ricercaLineareOttimizzata

	public static int ricercaBinaria(int[] v, int x) {
		//v ordinato per valori crescenti
	    int inf = 0, sup = v.length-1;
	    while(inf <= sup) {
			int med = (inf+sup)/2;
			if(v[med]==x) return med;
			if(v[med]>x) sup = med-1;
			else inf = med+1;
		}
		return -1;
	}//ricercaBinaria

	public static <T extends Comparable<? super T>> int ricercaBinaria(T[] v, T x) {
		//v ordinato per valori crescenti
		int inf = 0, sup = v.length-1;
		while(inf <= sup) {
			int med = (inf+sup)/2;
			int esito = v[med].compareTo(x);
			if(esito==0) return med;
			if(esito>0) sup = med-1;
			else inf = med+1;
		}
		return -1;
	}//ricercaBinaria


    public static void bubbleSort(int []v) {
		int ius = 0; 
		for(int j=v.length-1; j>0; j=ius) {
			int scambi = 0;
			for(int i=0; i<j; i++)
			    if(v[i]>v[i+1]) {
			       int tmp = v[i];
			       v[i] = v[i+1];
			       v[i+1] = tmp; 
			       scambi++; 
			       ius = i;
				}
			if(scambi==0) break;
		}
	}//bubbleSort
    
    public static void bubbleSort(int[] v, int size) {
		if(size<0 || size>v.length) throw new IllegalArgumentException();
		int limite = 0; 
		for(int j=size-1; j>0; j=limite) {
			int scambi = 0;
			for(int i=0; i<j; i++)
			    if(v[i] > v[i+1]) {
			       int tmp = v[i]; 
			       v[i] = v[i+1];
			       v[i+1] = tmp; 
			       scambi++; 
			       limite = i;
				}
				if(scambi==0) break;
			}
	}//bubbleSort
    
    public static <T extends Comparable<? super T>> void bubbleSort(Vector<T> v) {
    	boolean scambi = true;
    	int limite = 0, ius = v.size()-1;
    	while(scambi) {
    		limite = ius; scambi = false;
    		for(int i=1; i<=limite; ++i)
    			if(v.get(i-1).compareTo(v.get(i))>0) { 	    
    				T park = v.get(i); 
    				v.set(i, v.get(i-1));
    				v.set(i-1, park); 
    				scambi = true;
    				ius = i-1;
    			}
    	}
    }//bubbleSort

	public static <T extends Comparable<? super T>> void bubbleSort(T[] v) {
		int ius = 0;
		for(int j=v.length-1; j>0; j=ius) {
			int scambi = 0;
			for(int i=0; i<j; i++)
			    if(v[i].compareTo(v[i+1])>0) {
			       T tmp = v[i];
			       v[i] = v[i+1];
			       v[i+1] = tmp; 
			       scambi++;
			       ius = i;
				}
			if(scambi==0) break;
		}
	}//bubbleSort
	
	public static <T extends Comparable<? super T>> void bubbleSort(T[] v, int size) {
		if(size<0 || size>v.length) throw new IllegalArgumentException();
		int ius = 0; 
		for(int j=size-1; j>0; j=ius) {
			int scambi = 0;
			for(int i=0; i<j; i++)
			    if(v[i].compareTo(v[i+1])>0) {
			       T tmp = v[i]; 
			       v[i] = v[i+1];
			       v[i+1] = tmp;
			       scambi++; 
			       ius = i;
				}
				if(scambi==0) break;
			}
	}//bubbleSort

	public static void selectionSort(int[] v) {
		for(int j=v.length-1; j>0; j--) {
			int indMax = 0;
			for(int i=1; i<=j; i++)
			     if(v[i]>v[indMax]) 
			    	 indMax = i;
			int park = v[j];
			v[j] = v[indMax];
			v[indMax] = park;
		}
	}//selectionSort


	public static <T extends Comparable<? super T>> void selectionSort(T[] v) {
		for(int j=v.length-1; j>0; j--){
			int indMax=0;
			for(int i=1; i<=j; i++)
			     if(v[i].compareTo(v[indMax])>0)
			    	 indMax = i;
			T park = v[j];
			v[j] = v[indMax];
			v[indMax] = park;
		}
	}//selectionSort
	
	public static void selectionSort(int[] v, int size) {
		if(size<0 || size>v.length) throw new IllegalArgumentException();
		for(int j=size-1; j>0; j--) {
			int indMax=0;
			for( int i=1; i<=j; i++)
			     if( v[i]>v[indMax]) 
			    	 indMax = i;
			int park = v[j]; 
			v[j] = v[indMax];
			v[indMax] = park;
		}
	}//selectionSort

	public static <T extends Comparable<? super T>> void selectionSort(T []v, int size) {
		if(size<0 || size>v.length) throw new IllegalArgumentException();
		for(int j=size-1; j>0; j--) {
			int indMax = 0;
			for(int i=1; i<=j; i++)
			    if(v[i].compareTo(v[indMax])>0) 
			    	indMax = i;
			T park = v[j];
			v[j] = v[indMax];
			v[indMax] = park;
		}
	}//selectionSort

	public static void insertionSort(int[] v) {
		for( int i=1; i<v.length; i++ ) {
			int x = v[i]; 
			int j = i;
			while(j>0 && v[j-1]>x) {
				v[j] = v[j-1];
				j--;
			}
			v[j] = x;
		}
	}//insertionSort

	public static <T extends Comparable<? super T>> void insertionSort(T[] v) {
		for(int i=1; i<v.length; i++){
			T x = v[i]; 
			int j = i;
			while(j>0 && v[j-1].compareTo(x)>0) {
				v[j] = v[j-1];
				j--;
			}
			v[j] = x;
		}
	}//insertionSort

	public static void insertionSort(int[] v, int size) {
		if(size<0 || size>v.length) throw new IllegalArgumentException();
		for(int i=1; i<size; i++) {
			int x = v[i];
			int j = i;
			while(j>0 && v[j-1]>x) {
				v[j] = v[j-1];
				j--;
			}
			v[j] = x;
		}
	}//insertionSort

	public static <T extends Comparable<? super T>> void insertionSort(T[] v, int size) {
		if(size<0 || size>v.length) throw new IllegalArgumentException();
		for(int i=1; i<v.length; i++){
			T x = v[i]; 
			int j = i;
			while(j>0 && v[j-1].compareTo(x)>0){
				v[j] = v[j-1];
				j--;
			}
			v[j] = x;
		}
	}//insertionSort

	public static <T extends Comparable<? super T>> T max(T[] v) {
		T max = null;
		for(T x: v)
			if(max==null || x.compareTo(max)>0)
				max = x;		
		return max;
	}//max

	public static <T extends Comparable<? super T>> void mergeSort(T[] v) {
		mergeSort(v, 0, v.length-1);
	}//mergeSort

	private static <T extends Comparable<? super T>> void mergeSort(T[] v, int inf, int sup) {
		if(inf < sup){
			int med = (inf+sup)/2;
			mergeSort(v, inf, med);
			mergeSort(v, med+1, sup);
			merge(v, inf, med, sup);
		}
	}//mergeSort

	@SuppressWarnings("unchecked")
	private static <T extends Comparable<? super T>> void merge(T[] v, int inf, int med, int sup) {
		T[] aux = (T[]) new Comparable[sup-inf+1];
		int i = inf, j = med+1, k = 0;
		while(i<=med && j<=sup) {
			if(v[i].compareTo(v[j])<0) {
				aux[k] = v[i];
				i++; 
			}
			else {
				aux[k] = v[j];
				j++;
			}
			k++;
		}
		while(i <= med) {
			aux[k] = v[i]; 
			i++; k++;
		}
		while(j <= sup) {
			aux[k] = v[j]; 
			j++; k++; 
		}
		for(k=0; k<aux.length; k++) 
			v[k+inf] = aux[k];
	}//merge

	

	public static void mergeSort(int[] v) {
		mergeSort(v, 0, v.length-1);
	}//mergeSort

	private static void mergeSort(int[] v, int inf, int sup) {
		if(inf < sup) {
			int med = (inf+sup)/2;
			mergeSort(v, inf, med);
			mergeSort(v, med+1, sup);
			merge(v, inf, med, sup);
		}
	}//mergeSort

	private static void merge(int[] v, int inf, int med, int sup) {
		int[] aux = new int[sup-inf+1];
		int i = inf, j = med+1, k = 0;
		while(i<=med && j<=sup) {
			if(v[i]<v[j] ) {
				aux[k] = v[i];
				i++; 
			}
			else { 
				aux[k] = v[j];
				j++; 
			}
			k++;
		}
		while(i<=med) {
			aux[k] = v[i]; 
			i++; k++;
		}
		while(j<=sup) {
			aux[k] = v[j];
			j++; k++;
		}
		for(k=0; k<aux.length; k++) 
			v[k+inf] = aux[k];
	}//merge

	public static void quickSort(int[] v){
		quickSort(v, 0, v.length-1);
	}//quickSort

	public static void quickSort(int[] v, int size) {
		if(size<0 || size>v.length)
			throw new IllegalArgumentException();
		quickSort(v, 0, size-1);
	}//quickSort

	private static void quickSort(int[] v, int inf, int sup){
		if(inf < sup) {
			int x = v[(inf+sup)/2]; //perno
			int i = inf, j = sup;
			do {
				while(v[i] < x) i++;
				while(v[j] > x) j--;
				if(i <= j) {
					//scambia
					int park = v[i]; v[i] = v[j]; v[j] = park;
					i++; j--;
				}
			} while(i <= j);
			quickSort(v, inf, j);
			quickSort(v, i, sup);
		}
	}//quicksort


	public static <T extends Comparable<? super T>> void quickSort(T[] v) {
		quickSort( v, 0, v.length-1 );
	}//quickSort

	public static <T extends Comparable<? super T>> void quickSort(T[] v, int size) {
		if(size<0 || size>v.length)
			throw new IllegalArgumentException();
		quickSort(v, 0, size-1);
	}//quickSort

	private static <T extends Comparable<? super T>> void quickSort(T[] v, int inf, int sup) {
		if(inf < sup) {
			T x = v[(inf+sup)/2]; //perno
			int i = inf, j = sup;
			do {
				while(v[i].compareTo(x)<0) i++;
				while(v[j].compareTo(x)>0) j--;
				if(i <= j){
					//scambia
					T park = v[i]; v[i] = v[j]; v[j] = park;
					i++; j--;
				}
			} while(i <= j);
			quickSort(v, inf, j);
			quickSort(v, i, sup);
		}
	}//quicksort

	public static <T extends Comparable<? super T>> void quickSort(Vector<T> v) {
		quickSort( v, 0, v.size()-1 );
	}//quickSort

	private static <T extends Comparable<? super T>> void quickSort(Vector<T> v, int inf, int sup) {
		if(inf < sup) {
			T x = v.get((inf+sup)/2); //perno
			int i = inf, j = sup;
			do {
				while(v.get(i).compareTo(x)<0) i++;
				while(v.get(j).compareTo(x)>0) j--;
				if(i <= j){
					T park = v.get(i); v.set(i, v.get(j));
					v.set(j, park);
					i++; j--;
				}
			} while(i <= j);
			quickSort(v, inf, j);
			quickSort(v, i, sup);
		}
	}//quicksort

	public static <T extends Comparable<? super T>> void quickSort(java.util.List<T> v) {
		quickSort(v, 0, v.size()-1);
	}//quickSort

	private static <T extends Comparable<? super T>> void quickSort(java.util.List<T> v, int inf, int sup) {
		if(inf < sup) {
			T x = v.get((inf+sup)/2); //perno
			int i = inf, j = sup;
			do {
				while(v.get(i).compareTo(x)<0) i++;
				while(v.get(j).compareTo(x)>0) j--;
				if(i <= j){
					T park = v.get(i); v.set(i, v.get(j));
					v.set(j, park);
					i++; j--;
				}
			} while(i <= j);
			quickSort(v, inf, j);
			quickSort(v, i, sup);
		}
	}//quicksort
}//Array