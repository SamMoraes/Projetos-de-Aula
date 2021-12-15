package inputs;

import java.util.Scanner;

public class ClienteInput {

	// método para ler o id do cliente
		public static Integer lerIdCliente() {

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			System.out.print("Informe o id do cliente......: ");
			return Integer.parseInt(scanner.nextLine());
		}

		// método para ler o nome do cliente
		public static String lerNome() {

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			System.out.print("Informe o nome do cliente....: ");
			return scanner.nextLine();
		}

		// método para ler o email do cliente
		public static String lerEmail() {

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			System.out.print("Informe o email do cliente...: ");
			return scanner.nextLine();
		}

		// método para ler o cpf do cliente
		public static String lerCpf() {

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			System.out.print("Informe o cpf do cliente.....: ");
			return scanner.nextLine();
		}

}
