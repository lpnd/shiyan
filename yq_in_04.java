
import java.io.*;
import java.text.Collator;
import java.util.Locale;

public class yq_in_04 {
	public static void main(String[] args) throws IOException {
		String[] str = new String[135];
		String area = new String();//存放处理过程数据
		String temp = new String();//省名
		sheng[] T = new sheng[50];//省类
		int num = 0, num_temp = 0, num_t = 0;// 统计数据的总数,省类数组下标,统计各省总数
		sheng t = new sheng(temp, num_t);//用于排序临时存放数据
		File file = new File("C:\\Users\\25719\\Desktop\\yq_in.txt");// 链接文件
		BufferedReader br = new BufferedReader(new FileReader(file));// 用于读取文本

		while ((str[num] = br.readLine()) != null) {// 从文本中按行读取文本，并用于循环的控制
			num++;
		}
		br.close();

		temp = str[0].substring(0, str[0].indexOf("\t"));
		for (int n = 0; n < num; n++) {//统计省名以及各省总数
			if (temp.equals((str[n].substring(0, str[n].indexOf("\t"))))) {
				area = (str[n].substring(str[n].indexOf("\t") + 1));
				num_t += Integer.parseInt(area.substring(area.indexOf("\t") + 1));// 累加总数
			} else {
				T[num_temp] = new sheng(temp,num_t);//建类
				num_t = 0;//总数清零
				num_temp++;//下标位移
				temp = str[n].substring(0, str[n].indexOf("\t"));//重新截取省名
				area = str[n].substring(str[n].indexOf("\t") + 1);
				num_t += Integer.parseInt(area.substring(area.indexOf("\t") + 1));// 累加总数
			}
		}
		T[num_temp] = new sheng(temp,num_t);//存放最后一个省
		
		num_temp = 0;
		for(int n = 0;n < num;n++) {//将市分别存入对应省
			if (str[n].substring(0, str[n].indexOf("\t")).equals(T[num_temp].temp)) {
				T[num_temp].set_area(str[n].substring(str[n].indexOf("\t") + 1));
			}else {
				num_temp++;
				n--;
			}
		}
		
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\25719\\Desktop\\out.txt"));// 在桌面创建一个名为out.txt的文本文件，用于存放处理后的数据
		PrintStream ps = new PrintStream(fos);// 用于写入文本
		
		sort(T, num_temp, t);//排序函数（冒泡排序）
		for (int n = 0; n <= num_temp; n++) {
			if (n!=0) {
				System.out.println();
				ps.println();//文本换行
			}	
			T[n].show(ps);
		}

		ps.close();
	}

	static void sort(sheng[] T, int num_temp, sheng t) {
		for (int n = 0; n < num_temp - 1; n++) {//省名排序（冒泡排序）
			for (int i = 0; i < num_temp - n - 1; i++) {
				if (T[i].num < T[i + 1].num) {
					t = T[i];
					T[i] = T[i + 1];
					T[i + 1] = t;
				} else if (T[i].num == T[i + 1].num) {
					int compare = compare(T[i].temp, T[i + 1].temp);//比较首字母
					if (compare < 0) {
						t = T[i];
						T[i] = T[i + 1];
						T[i + 1] = t;
					}
				}
			}
		}
		for (int m = 0; m < num_temp; m++) {//控制省循环
			for (int n = 0; n < T[m].num_area - 1; n++) {//控制省内循环
				for (int i = 0; i < T[m].num_area - n - 1; i++) {
					int a = Integer.parseInt(T[m].area[i].substring(T[m].area[i].indexOf("\t") + 1));//获取各市数据
					int b = Integer.parseInt(T[m].area[i + 1].substring(T[m].area[i + 1].indexOf("\t") + 1));
					if (a < b) {
						t.area[0] = T[m].area[i];
						T[m].area[i] = T[m].area[i + 1];
						T[m].area[i + 1] = t.area[0];
					} else if (a == b) {
						String s1 = T[m].area[i].substring(T[m].area[i].indexOf("\t") + 1);
						String s2 = T[m].area[i + 1].substring(T[m].area[i + 1].indexOf("\t") + 1);
						int compare = compare(s1, s2);//比较首字母
						if (compare < 0) {
							t.area[0] = T[m].area[i];
							T[m].area[i] = T[m].area[i + 1];
							T[m].area[i + 1] = t.area[0];
						}
					}
				}
			}
		}
	}

	static int compare(String s1, String s2) {//比较首字母
		Collator c = Collator.getInstance(Locale.CHINA);
		int n = c.compare(s1, s2);
		return n;
	}
}

class sheng {
	String temp;
	String[] area = new String[40];// 各市信息
	int num = 0;// 各市总人数
	int num_area = 0;// 市总数
	sheng(String temp,int num) {//构造函数
		this.temp = temp;
		this.num = num;
	}
	void set_area(String a) {//输入市的信息
			this.area[num_area] = a;
			num_area++;
	}
	void show(PrintStream ps) {//输出
		System.out.println(this.temp + "\t" + num);
		ps.println(this.temp+ "\t" + num);
		for (int n = 0; n < num_area; n++) {
			System.out.println(area[n]);
			ps.println(area[n]);
		}
	}
}
