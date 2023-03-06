package br.com.erudio.converts;

public class NumberConverter {

	public static Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		// BR 10,25 - USD 10.25
		//conversão da virgula para ponto.
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	public static boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
