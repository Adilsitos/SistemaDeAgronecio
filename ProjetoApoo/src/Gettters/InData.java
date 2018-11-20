package Gettters;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class InData{

	public String entDados(String rotulo){
		InputStreamReader teclado = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(teclado);
		String ret = "";

		System.out.println(rotulo);

		try{
			ret = buff.readLine();
		}

		catch(IOException ioe){
			System.out.println("\n Erro de sistema\n");
		}

		return ret;
	}

}

