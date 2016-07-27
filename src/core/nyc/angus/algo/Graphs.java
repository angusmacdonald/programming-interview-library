package nyc.angus.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Graph algorithm utilities.
 */
public class Graphs {

	public static int[] dijkstraShortestPath(final int[][] edges, final int startPos) {

		final int[] distances = initializePathWeights(edges);

		final Queue<Node> nextToVisit = new LinkedList<>();

		nextToVisit.add(new Node(startPos, 0));

		while (!nextToVisit.isEmpty()) {
			final Node node = nextToVisit.poll();

			if (distances[node.pos] == -1) {
				distances[node.pos] = node.distance;
				visit(edges, nextToVisit, node);
			}

		}

		return distances;
	}

	private static void visit(final int[][] edges, final Queue<Node> nextToVisit, final Node node) {
		for (int i = 0; i < edges.length; i++) {
			if (i != node.pos && edges[node.pos][i] >= 0) {
				nextToVisit.add(new Node(i, node.distance + 6));
			}
		}
	}

	private static int[] initializePathWeights(final int[][] edges) {
		final int[] distances = new int[edges.length];

		for (int i = 0; i < distances.length; i++) {
			distances[i] = -1;
		}
		return distances;
	}

	private static class Node {
		public int pos;
		public int distance;

		public Node(final int pos, final int distance) {
			this.pos = pos;
			this.distance = distance;
		}
	}
}
