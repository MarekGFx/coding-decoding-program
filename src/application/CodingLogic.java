package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CodingLogic {

	private String encode(String plainText) {

		char[] kod = plainText.toCharArray();
		int[] letterCount = new int[kod.length];
		int count = 1;
		String result = "";

		for (int i = 1; i < kod.length; i++) {

			if (kod[i] == kod[i - 1]) { // AAABBC
				count++; // 012345
			} else {
				letterCount[i - 1] = count;
				count = 1;
			}
		}
		letterCount[kod.length - 1] = count;

		for (int j = 0; j < kod.length; j++) {
			if (letterCount[j] > 0) {
				// System.out.print(kod[j]+""+ letterCount[j]+"'");
				result = result + kod[j] + "" + letterCount[j] + ",";
			}
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}

	public String encoding(String s) {
		return encode(s);

	}

	private String decode(String encodedText) {
		String[] s = encodedText.split(",");
		String result = "";

		for (String a : s) {

			try {
				int number = Integer.parseInt(a.substring(1, a.length()));

				for (int i = 0; i < number; i++) {
					result = result + a.charAt(0);
				}
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.WARNING, "Nieobsługiwany format poddany dekodowaniu");
				alert.show();
				return result = "BŁĄD!!! Podaj prawidłowy ciąg znaków do zdekodowania np.A4,B3,C2";

			}
		}
		return result;
	}

	public String decoding(String s) {
		return decode(s);
	}

}
