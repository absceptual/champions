// http://www.usaco.org/index.php?page=viewproblem2&cpid=891
// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;


public class Solution {
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
		InputReader r  = new InputReader("shell.in");
		PrintWriter pw = new PrintWriter("shell.out");

		int n = r.nextInt();

		ArrayList<int[]> shells = new ArrayList<int[]>(3);
		shells.add(new int[]{1, 0, 0});
		shells.add(new int[]{0, 1, 0});
		shells.add(new int[]{0, 0, 1});

		ArrayList<Integer> count = new ArrayList<Integer>(3);
		count.add(0);
		count.add(0);
		count.add(0);

		for (int i = 0; i < n; ++i) {
			int a = r.nextInt() - 1, b = r.nextInt() - 1, g = r.nextInt() - 1;

			for (int j = 0; j < 3; ++j) {
				int[] shell = shells.get(j);

				int tmp = shell[a];
				shell[a] = shell[b];
				shell[b] = tmp;

				if (shell[g] == 1) 
					count.set(j, count.get(j) + 1);
			}
		}

		int max = -1;
		for (int c : count)
			max = Math.max(c, max);

		pw.print(max);
		pw.close();
 		
	}
}
