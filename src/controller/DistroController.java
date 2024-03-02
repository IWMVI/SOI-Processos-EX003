package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {

	public DistroController() {
		super();
	}

	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void exibeDistro() {
		if (os().contains("Linux")) {
			String cmd = "cat /etc/os-release";

			try {
				Process p = Runtime.getRuntime().exec(cmd);
				InputStream dados = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(dados);
				BufferedReader reader = new BufferedReader(leitor);
				String linha = reader.readLine();
				System.out.println(linha);
				reader.close();
				leitor.close();
				dados.close();
			} catch (IOException e) {
				System.err.println("O sistema não é Linux");
			}
		}
	}
}
