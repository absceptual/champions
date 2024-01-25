// Source: https://usaco.guide/general/io
// http://www.usaco.org/index.php?page=viewproblem2&cpid=783

import java.io.*;
import java.util.*;
import java.awt.*;
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
			}
			catch (IOException e) {
				throw new RuntimeException(e);
			}
			tokenizer = null;
		}

		String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				}
				catch (Exception e) {
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

	// static InputReader r = new InputReader("word.in");
	// static PrintWriter pw = new PrintWriter("word.out");

	public static int get_corners(Rectangle rect, Rectangle intersection) {
		int intersections = 0;
		// System.out.println(rect);
		if (rect.x >= intersection.x && rect.x <= intersection.x + intersection.width) {
			if (rect.y >= intersection.y && rect.y <= intersection.y + intersection.height)  {
				//System.out.println("!!!");
				++intersections;
			}
		}

		if (rect.x + rect.width >= intersection.x && rect.x + rect.width <= intersection.x + intersection.width) {
			if (rect.y >= intersection.y && rect.y <= intersection.y + intersection.height)  {
				++intersections;
				//System.out.println("!!!!");
			}
		}

		if (rect.x >= intersection.x && rect.x <= intersection.x + intersection.width) {
			if (rect.y + rect.height >= intersection.y && rect.y + rect.height <= intersection.y + intersection.height) {
				//System.out.println("!!!!!!");
				++intersections;

			}
		}

		if (rect.x + rect.width >= intersection.x && rect.x + rect.width <= intersection.x + intersection.width) {
			if (rect.y + rect.height >= intersection.y && rect.y + rect.height <= intersection.y + intersection.height) {
				++intersections;
				//System.out.println("!!");
			}
		}


		// System.out.println(intersection);
		return intersections;
	}

	public static void main(String[] args) throws IOException {
		InputReader r  = new InputReader("billboard.in");
		PrintWriter pw = new PrintWriter("billboard.out");

		int x = r.nextInt(), y = r.nextInt(), x2 = r.nextInt(), y2 = r.nextInt();
		Rectangle lawnmover = new Rectangle(
			x,
			y,
			Math.abs(x2 - x),
			Math.abs(y2 - y)
		);

		x = r.nextInt(); y = r.nextInt(); x2 = r.nextInt(); y2 = r.nextInt();
		Rectangle billboard = new Rectangle(
			x,
			y,
			Math.abs(x2 - x),
			Math.abs(y2 - y)
		);

		Rectangle intersection = lawnmover.intersection(billboard);
		//pw.println(intersection);
		int corners = get_corners(lawnmover, intersection);
		//pw.println(corners);
		if (corners < 2) {
			pw.println(lawnmover.width * lawnmover.height);
		}
		else if (corners == 4) {
			pw.println(0);
		}
		else {
			//pw.println(lawnmover.width + " " + intersection.width);
			int xl = Math.max(lawnmover.x, intersection.x );
			int xr = Math.min(lawnmover.x + lawnmover.width, intersection.x + intersection.width);
			int yl = Math.max(lawnmover.y, intersection.y);
			int yr = Math.min(lawnmover.y + lawnmover.height, intersection.y + intersection.height);

			pw.println((lawnmover.width * lawnmover.height) - (xr - xl) * (yr - yl));
		}
		
		pw.close();
	}
}
