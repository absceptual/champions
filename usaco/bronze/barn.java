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


    

	public static void main(String[] args) throws IOException {
        InputReader r  = new InputReader("file.in");
        PrintWriter pw = new PrintWriter(System.out);

        int n = r.nextInt();

        List<Integer> rooms = new LinkedList<Integer>();
        //int[] rooms = new int[n];
        for (int i = 0; i < n; ++i) 
            rooms.add(r.nextInt());

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            ListIterator<Integer> it = rooms.listIterator(i + (n - 1) % n);
            int cur = 0;
            for (int j = 0; j < n; ++j) {
                if (!it.hasNext())
                    it = rooms.listIterator();

                int count = it.next();
                pw.print(count + " ");
                cur += j * count;
            }
            min = Math.min(min, cur);
            pw.println();
        }

        
		pw.close();
	}
}
