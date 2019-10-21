package �Ӽ��˳�;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashSet<String> hashSet = new HashSet<String>();
		GU(hashSet);
		printA(hashSet);

	}

	static void printA(HashSet<String> hashSet) throws IOException {		
		PrintWriter pw = new PrintWriter( new FileWriter( "D:\\gugu.txt" ) );
		PrintWriter pws = new PrintWriter(new FileWriter("D:\\result.txt"));
		int sum = 1;
		int sum1 = 1;
		for (Iterator it = hashSet.iterator(); it.hasNext();) {
			pw.println(it.next());		
			sum++;
		}
		pw.close();
		
		
		for(Iterator its = hashSet.iterator();its.hasNext();){
			String next = (String) its.next();
			String[] split = next.split("= ");
			pws.println(split[0] + "=");
			sum1++;
		}
		pws.close();
	}
	
	static void GU(HashSet<String> hashSet) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("��������Ŀ������");
		int s = scanner.nextInt();
		System.out.println("�������Ƿ�����˳�����0�ǣ�1��");
		int flag = scanner.nextInt();
		System.out.println("�������������Χ��");	
		int shu = scanner.nextInt();
		RANDOM(shu);
		int gu = 0;
		if (flag == 0) {
			gu = 4;
			
		}
		else if (flag == 1) {
			gu = 2;
			
		}
		SHI(shu,gu);
		SYMBOL(gu);
		for (int i = 0;; i++) {
			if (hashSet.size() == s) {
				break;
			}
			hashSet.add(gxw(shu,gu));

		}
	}
	
	static String SHI(int shu,int flag) {//ʮ���ڵļӼ��˳�
		int a = RANDOM(shu);
		char b = SYMBOL(flag);
		int c = RANDOM(shu);
		String str = a + " " + b + " " + c + " = " + SUAN(a, b, c);	
		return str;
	}
	
	static String gxw( int shu,int flag){
		String str = "";
		for (int i = 0;; i++) {
			str = SHI(shu,flag);
			String[] spilt = str.split("= ");
			System.out.print(spilt[1]);
			double p = Double.parseDouble(spilt[1]);
			if (p <= 100) {
				break;
			}
		}
		return str;
	}
	
	
	static int RANDOM(int a) { // ����һ�������
		return (int) (1 + Math.random() * (a - 1 + 1));
	}

	
	static char SYMBOL(int a) {// ����һ������
		char synbol[] = { '+','-', '*', '/'};
			return synbol[(int) (Math.random()*(a))];
	}

	
	static String SUAN(int a, char b, int c) {
		if (b == '+') {
			return (a + c) + "";

		}
		if (b == '-') {
			return (a - c) + "";

		}
		if (b == '*') {
			return (a * c) + "";
		}
		if (b == '/') {
			DecimalFormat df = new DecimalFormat("#.00");
			double sum = (double) a / c;

			String e = df.format(sum);
			if (a < c) {
				e = 0 + e;
			}
			return e;
		}
		return c + "";

	}

}
