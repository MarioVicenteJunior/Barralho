/**
 * 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Msc. Godinho Quissico
 * 06 - Mar�o - 2023
 * USTM - PII 
 * LASIR
 */
abstract class Ler {
	/*
	 * Classe desenhada para permitir
	 * a leitura de dados do teclado para o programa.
	 * classe alternativa a classe Scanner.
	 */
	//canal de leitura de strings do teclado.
	private static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	
	public static String umString(){
		try{
			return buffer.readLine();
		}catch(Exception e){
			return umString();
		}
	}
	
	public static char umChar(){
		try{
			return buffer.readLine().charAt(0);
		}catch(Exception e){
			return umChar();
		}
	}
	public static int umInt(){
		try{
			return Integer.parseInt(buffer.readLine());
		}catch(Exception e){
			return umInt();
		}
	}
	
	public static short umShort(){
		try{
			return Short.parseShort(buffer.readLine());
		}catch(Exception e){
			return umShort();
		}
	}
	
	public static long umLong(){
		try{
			return Long.parseLong(buffer.readLine());
		}catch(Exception e){
			return umLong();
		}
	}
	
	public static byte umByte(){
		try{
			return Byte.parseByte(buffer.readLine());
		}catch(IOException e){
			return umByte();
		}
	}
	
	public static boolean umBoolean(){
		try{
			return Boolean.parseBoolean(buffer.readLine());
		}catch(IOException e){
			return umBoolean();
		}
	}
	
	public static float umFloat(){
		try{
			return Float.parseFloat(buffer.readLine());
		}catch(IOException e){
			return umFloat();
		}
	}
	
	public static double umDouble(){
		try{
			return Double.parseDouble(buffer.readLine());
		}catch(IOException e){
			return umDouble();
		}
	}

}// final da classe Ler.
