// http://www.usaco.org/index.php?page=viewproblem2&cpid=807
// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.StringTokenizer;


class Solution {
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

	// static 
    //static InputReader r  = new InputReader("teleport.in");
	//static PrintWriter pw = new PrintWriter("teleport.out");

	public static void main(String[] args) throws IOException {
        
        InputReader r  = new InputReader("teleport.in");
	    PrintWriter pw = new PrintWriter("teleport.out");

        int x = r.nextInt();
        int y = r.nextInt();
        int a = r.nextInt();
        int b = r.nextInt();

        int teleport_start = Math.min(a, b);
        int teleport_end   = Math.max(a, b);

        int tractor_start = Math.min(x, y);
        int tractor_end   = Math.max(x, y);

        int tractor_distance = tractor_end - tractor_start;
        
        int distance_with_teleportation = Math.abs(tractor_start - teleport_start) + Math.abs(tractor_end - teleport_end);
        pw.print(Math.min(distance_with_teleportation, tractor_distance));

        pw.close();

	}


}
