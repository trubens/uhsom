package no.truben.uhs.format;

public class Encryption {

	public static int[] getKey(String mainLabel) {
		int[] key = new int[mainLabel.length()];
		int[] k = { 'k', 'e', 'y' };
		for (int i = 0; i < mainLabel.length(); i++) {
			key[i] = (int) mainLabel.charAt(i) + (k[i % 3] ^ (i + 40));
			while (key[i] > 127) {
				key[i] -= 96;
			}
		}
		return key;
	}

	public static String decryptOld(String input) {
		StringBuffer tmp = new StringBuffer(input.length());

		for (int i = 0; i < input.length(); i++) {
			int mychar = (int) input.charAt(i);
			if (mychar < 32) {
			} else if (mychar < 80) {
				mychar = mychar * 2 - 32;
			} else {
				mychar = mychar * 2 - 127;
			}

			tmp.append((char) mychar);
		}

		return tmp.toString();
	}

	public static String decryptString(String input, int[] key) {
		StringBuffer tmp = new StringBuffer(input.length());
		int tmpChar = 0;

		for (int i = 0; i < input.length(); i++) {
			int codeoffset = i % key.length;
			tmpChar = input.charAt(i) - (key[codeoffset] ^ (i + 40));
			while (tmpChar < 32) {
				tmpChar += 96;
			}
			tmp.append((char) tmpChar);
		}

		return tmp.toString();
	}
}
