import java.io.*;

public class YP_io {
	public static void main(String[] args) throws IOException {
		String[] str = new String[135];
		int num = 0;
		File file = new File("C:\\Users\\25719\\Desktop\\yq_in.txt");// ；链接文件
		BufferedReader br = new BufferedReader(new FileReader(file));// 用于读取文本
		while ((str[num] = br.readLine()) != null) {//从文本中按行读取文本，并用于循环的控制
			num++;//统计数据的总数
		}
		br.close();
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\25719\\Desktop\\out.txt"));//在桌面创建一个名为out.txt的文本文件，用于存放处理后的数据
		PrintStream ps = new PrintStream(fos);//用于写入文本
		String[] deal = new String[num];//给字符串用于存放处理过程中产生的字符串
		String area_temp = str[0].substring(0, str[0].indexOf("\t"));//截取第一组数据的省份信息
		ps.println(area_temp);//存入文本
		System.out.println(area_temp);
		for (int n = 0; n < num; n++) {
			deal[n] = str[n].substring(str[n].indexOf("\t") + 1);//截取数据除省份信息以外的其它信息
			if (area_temp.equals((str[n].substring(0, str[n].indexOf("\t"))))) {//判断前后两组数据身省份新信息是否一致
				if (!(deal[n].substring(deal[n].indexOf("\t") + 1)).equals("0")) {//截取  地区后的数字，并用于判断是否为待明确地区
					ps.println(deal[n]);//存入文本
					System.out.println(deal[n]);
				}
			} else {
				System.out.println();
				area_temp = str[n].substring(0, str[n].indexOf("\t"));//省份信息不同，覆盖掉之前的信息
				ps.println();//文本换行
				ps.println(area_temp);
				System.out.println(area_temp);
				System.out.println(deal[n]);
				ps.println(deal[n]);
			}
		}
		ps.close();
	}
}