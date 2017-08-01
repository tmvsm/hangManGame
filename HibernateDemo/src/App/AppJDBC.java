package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AppJDBC {
	
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		try {
			
			/*
			 * Start the connection to the database
			 */
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_hibernate", "root", "root");
			
			System.out.println("Bem vindo ao jogo da forca \n");
			
			System.out.println("Escolha o modo de jogo ");
			System.out.println("1: Personalizado: ");
			System.out.println("2: Aleatorio: \n");
			String modoJogo = input.nextLine();

			/*
			 * Codigo para escolher o modo de jogo
			 */
			
			if(modoJogo.equals("1")) {
				System.out.println("Escolha uma dificuldade: (facil, medio, dificil) : ");
				String dificuldade = input.nextLine();
				
				System.out.println("Escolha uma categoria (clubes, empresas, veiculos)");
				String categoria = input.nextLine();
				
				Statement stmt = conn.createStatement();
				
				/*
				 * Query para os parametros introduzidos
				 */
				ResultSet resultQuery = stmt.executeQuery("select * from palavra p, dificuldade d, categoria c, palavra_categoria pc where d.DIFICULDADE_DESCRICAO ="
						+ " '" + dificuldade + "' and p.dificuldade_DIFICULDADE_ID = d.DIFICULDADE_ID and c.CATEGORIA_DESCRICAO='" + categoria + "' "
								+ "and pc.CATEGORIA_ID = c.CATEGORIA_ID and pc.PALAVRA_ID = p.PALAVRA_ID;");
				ArrayList<String> resultados = new ArrayList<String>();
				
				while(resultQuery.next()) {
					String nome = resultQuery.getString("palavra_descricao");
					resultados.add(nome);
				}
				
				/*
				 * Palavra selecionada aleatoriamente
				 */
				Random r = new Random();
				String palavraFinal = resultados.get(r.nextInt(resultados.size()));
				
				System.out.println("A palavra para adivinhar é: " + palavraFinal);
				
				char[] palavraChar = palavraFinal.toCharArray();
				jogoForca(palavraChar);
				
			} else if(modoJogo.equals("2")) {
				
				Statement stmt = conn.createStatement();
				ResultSet resultQuery = stmt.executeQuery("select * from palavra");
				
				ArrayList<String> resultados = new ArrayList<String>();
				
				while(resultQuery.next()) {
					String nome = resultQuery.getString("palavra_descricao");
					resultados.add(nome);
				}
				
				Random r = new Random();
				String palavraFinal = resultados.get(r.nextInt(resultados.size()));
				
				System.out.println("A palavra para adivinhar é: " + palavraFinal );
				
				char[] palavraChar = palavraFinal.toCharArray();
				jogoForca(palavraChar);
				
			}
				
				

			
 		} catch (Exception e) {
			
		}
		
	}

	private static void jogoForca(char[] palavraChar) {
		
		/*
		 * Palavra em *
		 */
		char[] asteriscos = new char[palavraChar.length];
		Arrays.fill(asteriscos, '*');
		
		int falhas = 0;
		boolean fim = false;
		
		while(!fim) {
			System.out.print("Adivinhe um caracter " + String.valueOf(asteriscos) + ": ");
			if(!adivinharCaracter(input.next().charAt(0), asteriscos, palavraChar)) {
				falhas++;
			}
			if(verificaEstado(asteriscos)) {
				fim = true;
				System.out.println("A palavra é: " + String.valueOf(palavraChar) + " e falhas-te: " + falhas + " vezes ");
			}
		}
		
	}

	/*
	 * Verifica se a palavra já está decifrada
	 */

	private static boolean verificaEstado(char[] asteriscos) {
		
		for(int i = 0; i<asteriscos.length; i++)
			if(asteriscos[i] == '*') 
				return false;
		return true;
	}

	/*
	 * Metodo para as tentativas 
	 */
	private static boolean adivinharCaracter(char charTentativa, char[] asteriscos, char[] palavraChar) {
				
		boolean encontrouCaracter = false;
		int tentativas = 0;
		
		for(int i = 0; i<palavraChar.length; i++) {
			if(palavraChar[i] == charTentativa) {
				if(asteriscos[i] == charTentativa && tentativas == 0) {
					System.out.println("Já adivinhou esse caracter");
					tentativas++;
				} else {
					asteriscos[i] = charTentativa;
				    encontrouCaracter = true;
					}
			};
		}
		return encontrouCaracter;
	}

}
