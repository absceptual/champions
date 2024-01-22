// http://www.usaco.org/index.php?page=viewproblem2&cpid=987
// Source: https://usaco.guide/general/io

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.StringTokenizer;


public class Main {
	static class InputReader {
		BufferedReader reader;
		StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}


		public InputReader(String filename) {
            try {
			reader = new BufferedReader(new FileReader(filename));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
			tokenizer = null;
		}

		String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (Exception e) {
					return null;
				}
			}

			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}


   // static InputReader r  = new InputReader("word.in");
	//static PrintWriter pw = new PrintWriter("word.out");

	public static void main(String[] args) throws IOException {
		InputReader r  = new InputReader("word.in");
		PrintWriter pw = new PrintWriter("word.out");

		int n = r.nextInt();
		int k = r.nextInt();

		int l = 0;
		String str = "";
		while (true) {
			String word = r.next();
			if (word == null) {
				pw.println(str.strip());
				break;
			}

			l += word.length();
			if (l > k) {
				l = word.length();
				pw.println(str.strip());
				str = "";
			}
			
			str += word + " ";
		}
		pw.close();
		
	}
}
