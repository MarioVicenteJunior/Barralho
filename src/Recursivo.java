
public class Recursivo {
	
	public static void main(String[] args) {
		primo(10);
	}
	public static void primo(int val){
		if(val == 1) {
			System.out.println(true);
			return;
		}
		System.out.println(primoAux(val, 2));
		
	}
	
	public static boolean primoAux(int val, int cont) {
		if(val%cont == 0)
			return false;
		if(val == cont)
			return true;
		
		return primoAux(val, cont+1);
	}
	
	

}
