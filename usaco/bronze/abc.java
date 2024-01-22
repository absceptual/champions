// http://www.usaco.org/index.php?page=viewproblem2&cpid=1059
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
				} catch (IOException e) {
					throw new RuntimeException(e);
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


    static InputReader r  = new InputReader(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
        
		ArrayList<Long> numbers = new ArrayList<Long>();
		for (int i = 0; i < 7; ++i)
			numbers.add(r.nextLong());

		Collections.sort(numbers);
		long a = 0, b = 0, c = 0;

		int size = numbers.size() - 1;
		long sum = numbers.get(size);
		numbers.remove(size--);

		a = numbers.get(0);
		numbers.remove(0);

		b = numbers.get(0);
		numbers.remove(0);

		c = sum - (a + b);
		
		pw.print(a + " " + b + " " + c);
		pw.close();
		
	}
}
