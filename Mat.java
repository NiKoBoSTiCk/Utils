package poo.util;

public final class Mat { //classe di utilità
	private Mat() {};
	public static double EPSLON = 1.0E-10;
	public enum Soluzione{ITERATIVA, RISCORSIVA};
	
	public static double[][] minore(double[][] a, int i, int j) {
		if(i<0 || j<0 || i>a[0].length || j>a.length) 
			throw new IllegalArgumentException("indici non validi");
		double[][] ret = new double[a[0].length-1][a.length-1];		
		for(int riga=0; riga<a[0].length; riga++)
			for(int colonna=0; colonna<a.length; colonna++)
				if(riga!=i && colonna!=j)
					ret[riga][colonna] = a[riga][colonna];		
	    return ret;
	}//minore	
	
	public static double determinanteL(double[][] a) {
		if(a.length!=a[0].length) 
			throw new IllegalArgumentException("Matrice non quadrata");
		else return determinante(a);
	}//determinanteL
	
	private static double determinante(double[][] a) {
		if(a.length==2) return a[0][0]*a[1][1] - a[1][0]*a[0][1];
		else return a[0][0]*determinante(minore(a, 0, 0));
	}//determinante
	
	public static double[][] matriceInversa(double[][] a){
		double det = determinanteL(a);
		if(det==0) throw new RuntimeException("Matrice non invertibile");	
		double[][] tmp = new double[a[0].length][a.length];	
		for(int riga=0; riga<a[0].length; riga++)
			for(int colonna=0; colonna<a.length; colonna++)
				tmp[riga][colonna] = complementoAlgebrico(a, riga, colonna)*(1D/det);	
		return tmp;	
	}//matriceInversa
	
	private static double complementoAlgebrico(double[][] a, int i, int j) {
		return Math.pow(-1, i+j)*determinanteL(minore(a, i, j));
	}//complementoAlgebrico
	
	
	public static long fibo(int n) {
		if(n<=0) throw new IllegalArgumentException();
		if(n==1||n==2) return 1;
		long[][] A = calcoloPotenzaA(n-1);
		return A[0][0];
	}//fibo	
	
	private static long[][] calcoloPotenzaA(int k) {
		long[][] A = {{1,1},{1,0}};
		return calcoloPotenzaRic(A, k);
	}//fiboRic	
	
	private static long[][] calcoloPotenzaRic(long[][] A, int k) {
		if(k<2) return A;
		if(k%2==0) return prodottoPari(calcoloPotenzaRic(A, k/2));		
		else return prodottoDisp(calcoloPotenzaRic(A, k/2));		
	}//fiboRic	
	
	private static long[][] prodottoPari(long[][] A){
		long[][] ret = new long[A.length][A.length];
		for(int i=0; i<ret.length; i++)
			for(int j=0; j<A.length; j++) {
				long ps = 0;
				for(int k=0; k<ret.length; k++)
					ps += A[i][k]*A[k][j];
				ret[i][j] = ps;
			}
		return ret;					
	}//prodottoPari	
	
	private static long[][] prodottoDisp(long[][] A){
		long[][] AxA = prodottoPari(A);
		long[][] B = {{1,1},{1,0}};
		long[][] ret = new long[A.length][A.length];
		for(int i=0; i<ret.length; i++)
			for(int j=0; j<ret.length; j++) {
				long ps = 0;
				for(int k=0; k<ret.length; k++)
					ps += AxA[i][k]*B[k][j];
				ret[i][j] = ps;
			}
		return ret;	
	}//prodottoDispari
	
	public static int sommaDivisori(int x, Soluzione sol){
		if(x<0) throw new IllegalArgumentException();
		if(sol==Soluzione.ITERATIVA) return sommaDivisoriIte(x);
		else return sommaDivisoriRic(x);		
	}//sommaDivisori
	
	private static int sommaDivisoriIte(int x) {
		int ret = 0;
		for(int i=1; i<=x/2; i++) 
			if(x%i==0) ret+=i;
		return ret;
	}//sommaDivisoriIte
	
	private static int sommaDivisoriRic(int x) {
		int somma = 0;
		return sommaDivisoriRic(x, x/2, somma);
	}//sommaDivisoriRic	
	
	private static int sommaDivisoriRic(int x, int d, int somma) {
		if(d==1) return 1;
		if(x%d==0) {
			somma += d;
			return sommaDivisoriRic(x, d--, somma);
		}
		else return sommaDivisoriRic(x, d--, somma);
	}//sommaDivisoriRic	
	
	public static boolean amicabili(int x, int y){
		if(x<0 || y<0) throw new RuntimeException();
		if(sommaDivisori(x, Soluzione.ITERATIVA)==y && sommaDivisori(y, Soluzione.ITERATIVA)==x)
			return true;
		return false;
	}//amicabili
	
	public static int mcd(int x, int y) {
		if(x<=0 || y<=0)throw new IllegalArgumentException("Numeri Illegali");
		return mcd_Euclide(x,y);
	}//mcd

	private static int mcd_Euclide(int x, int y) {
		if(y==0) return x;
		return mcd_Euclide(y,x%y);
	}//mcd_Euclide
	
	public static int mcm(int x, int y) {
		if(x<=0 || y<=0)throw new IllegalArgumentException("Numeri Illegali");
		return (x*y)/mcd_Euclide(x,y);
	}//mcd
	
	public static boolean quasiUguali(double x, double y) {
		return Math.abs(x-y)<=EPSLON;
	}//quasiUguali
}//Mat
