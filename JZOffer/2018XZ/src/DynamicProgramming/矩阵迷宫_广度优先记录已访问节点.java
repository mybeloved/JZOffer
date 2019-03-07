package DynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Program: JZOffer
 * @Description: 假设一个探险家被困在了地底的迷宫之中，要从当前位置开始找到一条通往迷宫出口的路径。
 * 迷宫可以用一个二维矩阵组成，有的部分是墙，有的部分是路。迷宫之中有的路上还有门，每扇门都在迷宫的某个地方有与之匹配的钥匙，
 * 只有先拿到钥匙才能打开门。请设计一个算法，帮助探险家找到脱困的最短路径。如前所述，迷宫是通过一个二维矩阵表示的，
 * 每个元素的值的含义如下 0-墙，1-路，2-探险家的起始位置，3-迷宫的出口，大写字母-门，小写字母-对应大写字母所代表的门的钥匙
 * <p>
 * 输入描述:
 * 迷宫的地图，用二维矩阵表示。第一行是表示矩阵的行数和列数M和N 后面的M行是矩阵的数据，每一行对应与矩阵的一行（中间没有空格）。
 * M和N都不超过100, 门不超过10扇。
 * <p>
 * 输出描述:
 * 路径的长度，是一个整数
 * <p>
 * 示例1
 * 输入
 * 5 5
 * 02111
 * 01a0A
 * 01003
 * 01001
 * 01111
 * 输出
 * 7
 * @Author: whx
 * @Create: 2019-03-07 16:51
 **/
public class 矩阵迷宫_广度优先记录已访问节点 {
	private static final char START_SYMBOL = '2';
	private static final char END_SYMBOL = '3';
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		scanner.nextLine();
		char[][] c = new char[m][n];
		for (int i = 0; i < m; i++) {
			c[i] = scanner.nextLine().toCharArray();
		}
		int[] s = getStart(m, n, c);
		System.out.println(bfs(s, m, n, c));
	}
	
	private static int[] getStart(int m, int n, char[][] c) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (c[i][j] == START_SYMBOL) {
					return new int[]{i, j};
				}
			}
		}
		return null;
	}
	
	private static int bfs(int[] s, int m, int n, char[][] c) {
		final int[][] next = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		final int nextStep = 4;
		boolean[][][] visited = new boolean[m][n][1024];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(s[0], s[1], 0, 0));
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i = 0; i < nextStep; i++) {
				int x = node.getX() + next[i][0];
				int y = node.getY() + next[i][1];
				int keys = node.getKeys();
				if (x < 0 || y < 0 || x >= m || y >= n || c[x][y] == '0') {
					continue;
				} else if (c[x][y] == END_SYMBOL) {
					return node.getStep() + 1;
				} else if ('a' <= c[x][y] && c[x][y] <= 'z') {
					keys |= (1 << (c[x][y] - 'a'));
				} else if ('A' <= c[x][y] && c[x][y] <= 'Z' && ((1 << (c[x][y] - 'A')) & keys) == 0) {
					continue;
				}
				if (!visited[x][y][keys]) {
					visited[x][y][keys] = true;
					queue.offer(new Node(x, y, keys, node.getStep() + 1));
				}
			}
		}
		return -1;
	}
	
}


class Node {
	private int x;
	private int y;
	private int keys;
	private int step;
	
	Node(int x, int y, int keys, int step) {
		super();
		this.x = x;
		this.y = y;
		this.keys = keys;
		this.step = step;
	}
	
	int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	int getKeys() {
		return keys;
	}
	
	public void setKeys(int keys) {
		this.keys = keys;
	}
	
	int getStep() {
		return step;
	}
	
	public void setStep(int step) {
		this.step = step;
	}
	
	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + ", keys=" + keys + ", step=" + step + "]";
	}
}

