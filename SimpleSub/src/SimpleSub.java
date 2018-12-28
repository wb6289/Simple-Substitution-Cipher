import java.util.ArrayList;
import java.io.*;
public class SimpleSub {

	public static ArrayList<Letter> freq (String cipher){
		ArrayList<Letter> letters = new ArrayList<Letter>();
		boolean e;
		int m = 0;
		for (int i = 0; i < cipher.length(); i++) {
			e = true;
			Letter l = new Letter(cipher.charAt(i), 0);
			for(int n = 0; n < letters.size(); n++) {
				if(letters.get(n).value == l.value) {
					letters.get(n).freq++;
					e = false;
					break;
				}
			}
			if(e) {
				letters.add(m++, l);
				l.freq++;
			}
		}
		return (letters);
	}
	
	public static String shift (String cipher, int n) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String c;
		String m = "";
		int x;
		for (int i = 0; i < cipher.length(); i++) {
			c = cipher.substring(i, i+1);
			x = alphabet.indexOf(c);
			if(x+n+1 > alphabet.length()) {
				int f = (x+n - alphabet.length());
				m = m + alphabet.substring(f, f+1);
			}
			else {
			m = m + alphabet.substring(x+n, x+n+1);
			}
		}
		return m;
	}
	public static void main(String[] args) throws IOException {
		ArrayList<Letter> input = freq(args[0]);
		for(int i = 0; i < input.size(); i++) {
			System.out.println(input.get(i).value + ", " + input.get(i).freq);
		}
		while(true) {
			if(!System.in.equals(null)) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				int i = Integer.parseInt(reader.readLine()); 
				System.out.println(shift(args[0], i));
			}
		}
		
   }
}
