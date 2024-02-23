import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

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
 
    static InputReader r  = new InputReader("mowing.in");
	static PrintWriter pw;

	public static void main(String[] args) throws IOException {
        pw = new PrintWriter("mowing.out");
        int N = r.nextInt();

        HashMap<String, Integer> field = new HashMap<String, Integer>();
        
        int i = 0, j = 0, t = 0, x = Integer.MAX_VALUE;
        while (N > 0) {
            char direction = r.next().charAt(0);
            int number = Integer.parseInt(r.next());

            for (int k = 0; k < number; ++k) {
                String query = i + "" + j;
                
                if (field.containsKey(query))
                    x = Math.min(x, t - field.get(query));

                field.put(query, t++);
                switch (direction)
                {
                    case 'N':
                        ++i;
                        break;
                    case 'E':
                        ++j;
                        break;
                    case 'S':
                        --i;
                        break;
                    case 'W':
                        --j;
                        break;

                }
            }
            
            
            --N;
        }

        if (x == Integer.MAX_VALUE)
            x = -1;
        pw.print(x);
        pw.close();
	}


}
