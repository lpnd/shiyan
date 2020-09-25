import java.io.*;
import java.util.Scanner;

public class YP_io_1 {
	public static void main(String[] args) throws IOException {// C:\\Users\\25719\\Desktop\\yq_in.txt
		Scanner sr = new Scanner(System.in);
		System.out.print(">yq ");
		String get = sr.nextLine();
		String[] deal = get.split(" ");
		if (deal.length == 2) {
			String file_path_in = deal[0];
			String file_path_out = deal[1];
			yq_re(file_path_in, file_path_out);
		}
		if (deal.length == 3) {
			String file_path_in = deal[0];
			String file_path_out = deal[1];
			String temp = deal[2];
			yq_re(file_path_in, file_path_out, temp);
		}
		sr.close();
	}

	static void yq_re(String file_path_in, String file_path_out) throws IOException {
		String[] str = new String[10000];
		int num = 0;
		File file = new File(file_path_in);// ；链接文件
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\25719\\Desktop\\" + file));// 用于读取文本
		while ((str[num] = br.readLine()) != null) {// 从文本中按行读取文本，并用于循环的控制
			num++;// 统计数据的总数
		}
		br.close();
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\25719\\Desktop\\" + file_path_out));// 在桌面创建一个名为out.txt的文本文件，用于存放处理后的数据
		PrintStream ps = new PrintStream(fos);// 用于写入文本
		String[] deal = new String[num];// 给字符串用于存放处理过程中产生的字符串
		String area_temp = str[0].substring(0, str[0].indexOf("\t"));// 截取第一组数据的省份信息
		ps.println(area_temp);// 存入文本
		System.out.println(area_temp);
		for (int n = 0; n < num; n++) {
			deal[n] = str[n].substring(str[n].indexOf("\t") + 1);// 截取数据除省份信息以外的其它信息
			if (area_temp.equals((str[n].substring(0, str[n].indexOf("\t"))))) {// 判断前后两组数据身省份新信息是否一致
				if (!(deal[n].substring(deal[n].indexOf("\t") + 1)).equals("0")) {// 截取 地区后的数字，并用于判断是否为待明确地区
					ps.println(deal[n]);// 存入文本
					System.out.println(deal[n]);
				}
			} else {
				area_temp = str[n].substring(0, str[n].indexOf("\t"));// 省份信息不同，覆盖掉之前的信息
				ps.println();// 文本换行
				ps.println(area_temp);
				System.out.println(area_temp);
				System.out.println(deal[n]);
				ps.println(deal[n]);
			}
		}
		System.out.print("文件已经输出");
		ps.close();
	}

	static void yq_re(String file_path_in, String file_path_out, String temp) throws IOException {
		String[] str = new String[10000];
		int num = 0;
		File file = new File(file_path_in);// ；链接文件
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\25719\\Desktop\\" + file));// 用于读取文本
		while ((str[num] = br.readLine()) != null) {// 从文本中按行读取文本，并用于循环的控制
			num++;// 统计数据的总数
		}
		br.close();
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\25719\\Desktop\\" + file_path_out));// 在桌面创建一个名为out.txt的文本文件，用于存放处理后的数据
		PrintStream ps = new PrintStream(fos);// 用于写入文本
		String[] deal = new String[num];// 给字符串用于存放处理过程中产生的字符串
		String area_temp = str[0].substring(0, str[0].indexOf("\t"));// 截取第一组数据的省份信息
		if (area_temp.equals(temp)) {//限定省份与指定一致
			ps.println(area_temp);// 存入文本
			System.out.println(area_temp);
		}
		for (int n = 0; n < num; n++) {
			deal[n] = str[n].substring(str[n].indexOf("\t") + 1);// 截取数据除省份信息以外的其它信息
			if (area_temp.equals((str[n].substring(0, str[n].indexOf("\t")))) && area_temp.equals(temp)) {// 判断前后两组数据身省份新信息是否一致
				if (!(deal[n].substring(deal[n].indexOf("\t") + 1)).equals("0")) {// 截取 地区后的数字，并用于判断是否为待明确地区
					ps.println(deal[n]);// 存入文本
					System.out.println(deal[n]);
				}
			} else {
				//System.out.println();
				area_temp = str[n].substring(0, str[n].indexOf("\t"));// 省份信息不同，覆盖掉之前的信息
				if (area_temp.equals(temp)) {//限定省份与指定一致
					ps.println(area_temp);
					System.out.println(area_temp);
					System.out.println(deal[n]);
					ps.println(deal[n]);
				}
			}
		}
		System.out.print("文件已经输出");
		ps.close();
	}
}
