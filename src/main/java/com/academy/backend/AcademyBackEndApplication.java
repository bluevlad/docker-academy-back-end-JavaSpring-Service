package com.academy.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AcademyBackEndApplication {

	@org.springframework.beans.factory.annotation.Value("${server.port:8080}")
	private String serverPort;

	public static void main(String[] args) {
		SpringApplication.run(AcademyBackEndApplication.class, args);
	}

	@org.springframework.context.event.EventListener(org.springframework.boot.context.event.ApplicationReadyEvent.class)
	public void openBrowser() {
		String url = "http://localhost:" + serverPort;
		String os = System.getProperty("os.name").toLowerCase();

		try {
			if (os.contains("win")) {
				Runtime.getRuntime().exec(new String[] { "cmd", "/c", "start", "chrome", url });
			} else if (os.contains("mac")) {
				Runtime.getRuntime().exec(new String[] { "open", "-a", "Google Chrome", url });
			} else if (os.contains("nix") || os.contains("nux")) {
				Runtime.getRuntime().exec(new String[] { "google-chrome", url });
			} else {
				if (java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				}
			}
		} catch (java.io.IOException e) {
			System.out.println("브라우저 실행 실패: " + e.getMessage());
			try {
				if (java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				}
			} catch (java.io.IOException ex) {
				System.out.println("기본 브라우저 실행 실패: " + ex.getMessage());
			}
		}
	}
}
