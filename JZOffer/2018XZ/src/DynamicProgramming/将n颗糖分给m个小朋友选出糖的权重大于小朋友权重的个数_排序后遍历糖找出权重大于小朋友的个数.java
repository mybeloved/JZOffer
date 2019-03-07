package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Program: JZOffer
 * @Description: 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，
 * 当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。
 * 可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 * <p>
 * 输入描述:
 * 第一行：n，表示h数组元素个数
 * 第二行：n个h数组元素
 * 第三行：m，表示w数组元素个数
 * 第四行：m个w数组元素
 * <p>
 * 输出描述:
 * 上台表演学生人数
 * <p>
 * 示例1
 * 输入
 * 3
 * 2 2 3
 * 2
 * 3 1
 * 输出
 * 1
 * @Author: whx
 * @Create: 2019-03-03 21:02
 **/
public class 将n颗糖分给m个小朋友选出糖的权重大于小朋友权重的个数_排序后遍历糖找出权重大于小朋友的个数 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> h = ArrayToArrayList(br);
		ArrayList<Integer> w = ArrayToArrayList(br);
		h.sort((o1, o2) -> o1 - o2);
		w.sort((o1, o2) -> o1 - o2);
		int i, j = 0, res = 0;
		for (i = 0; i < w.size() && j < h.size(); i++) {
			if (w.get(i) >= h.get(j)) {
				res++;
				j++;
			}
		}
		System.out.println(res);
	}
	
	private static ArrayList<Integer> ArrayToArrayList(BufferedReader br) throws IOException {
		int n = Integer.parseInt(br.readLine());
		String[] h1 = br.readLine().split(" ");
		ArrayList<Integer> h = new ArrayList<>();
		for (String str : h1) {
			h.add(Integer.parseInt(str));
		}
		return h;
	}
}
