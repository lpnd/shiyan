
import java.io.*;
import java.text.Collator;
import java.util.Locale;

public class yq_in_04 {
	public static void main(String[] args) throws IOException {
		String[] str = new String[135];
		String area = new String();//��Ŵ����������
		String temp = new String();//ʡ��
		sheng[] T = new sheng[50];//ʡ��
		int num = 0, num_temp = 0, num_t = 0;// ͳ�����ݵ�����,ʡ�������±�,ͳ�Ƹ�ʡ����
		sheng t = new sheng(temp, num_t);//����������ʱ�������
		File file = new File("C:\\Users\\25719\\Desktop\\yq_in.txt");// �����ļ�
		BufferedReader br = new BufferedReader(new FileReader(file));// ���ڶ�ȡ�ı�

		while ((str[num] = br.readLine()) != null) {// ���ı��а��ж�ȡ�ı���������ѭ���Ŀ���
			num++;
		}
		br.close();

		temp = str[0].substring(0, str[0].indexOf("\t"));
		for (int n = 0; n < num; n++) {//ͳ��ʡ���Լ���ʡ����
			if (temp.equals((str[n].substring(0, str[n].indexOf("\t"))))) {
				area = (str[n].substring(str[n].indexOf("\t") + 1));
				num_t += Integer.parseInt(area.substring(area.indexOf("\t") + 1));// �ۼ�����
			} else {
				T[num_temp] = new sheng(temp,num_t);//����
				num_t = 0;//��������
				num_temp++;//�±�λ��
				temp = str[n].substring(0, str[n].indexOf("\t"));//���½�ȡʡ��
				area = str[n].substring(str[n].indexOf("\t") + 1);
				num_t += Integer.parseInt(area.substring(area.indexOf("\t") + 1));// �ۼ�����
			}
		}
		T[num_temp] = new sheng(temp,num_t);//������һ��ʡ
		
		num_temp = 0;
		for(int n = 0;n < num;n++) {//���зֱ�����Ӧʡ
			if (str[n].substring(0, str[n].indexOf("\t")).equals(T[num_temp].temp)) {
				T[num_temp].set_area(str[n].substring(str[n].indexOf("\t") + 1));
			}else {
				num_temp++;
				n--;
			}
		}
		
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\25719\\Desktop\\out.txt"));// �����洴��һ����Ϊout.txt���ı��ļ������ڴ�Ŵ���������
		PrintStream ps = new PrintStream(fos);// ����д���ı�
		
		sort(T, num_temp, t);//��������ð������
		for (int n = 0; n <= num_temp; n++) {
			if (n!=0) {
				System.out.println();
				ps.println();//�ı�����
			}	
			T[n].show(ps);
		}

		ps.close();
	}

	static void sort(sheng[] T, int num_temp, sheng t) {
		for (int n = 0; n < num_temp - 1; n++) {//ʡ������ð������
			for (int i = 0; i < num_temp - n - 1; i++) {
				if (T[i].num < T[i + 1].num) {
					t = T[i];
					T[i] = T[i + 1];
					T[i + 1] = t;
				} else if (T[i].num == T[i + 1].num) {
					int compare = compare(T[i].temp, T[i + 1].temp);//�Ƚ�����ĸ
					if (compare < 0) {
						t = T[i];
						T[i] = T[i + 1];
						T[i + 1] = t;
					}
				}
			}
		}
		for (int m = 0; m < num_temp; m++) {//����ʡѭ��
			for (int n = 0; n < T[m].num_area - 1; n++) {//����ʡ��ѭ��
				for (int i = 0; i < T[m].num_area - n - 1; i++) {
					int a = Integer.parseInt(T[m].area[i].substring(T[m].area[i].indexOf("\t") + 1));//��ȡ��������
					int b = Integer.parseInt(T[m].area[i + 1].substring(T[m].area[i + 1].indexOf("\t") + 1));
					if (a < b) {
						t.area[0] = T[m].area[i];
						T[m].area[i] = T[m].area[i + 1];
						T[m].area[i + 1] = t.area[0];
					} else if (a == b) {
						String s1 = T[m].area[i].substring(T[m].area[i].indexOf("\t") + 1);
						String s2 = T[m].area[i + 1].substring(T[m].area[i + 1].indexOf("\t") + 1);
						int compare = compare(s1, s2);//�Ƚ�����ĸ
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

	static int compare(String s1, String s2) {//�Ƚ�����ĸ
		Collator c = Collator.getInstance(Locale.CHINA);
		int n = c.compare(s1, s2);
		return n;
	}
}

class sheng {
	String temp;
	String[] area = new String[40];// ������Ϣ
	int num = 0;// ����������
	int num_area = 0;// ������
	sheng(String temp,int num) {//���캯��
		this.temp = temp;
		this.num = num;
	}
	void set_area(String a) {//�����е���Ϣ
			this.area[num_area] = a;
			num_area++;
	}
	void show(PrintStream ps) {//���
		System.out.println(this.temp + "\t" + num);
		ps.println(this.temp+ "\t" + num);
		for (int n = 0; n < num_area; n++) {
			System.out.println(area[n]);
			ps.println(area[n]);
		}
	}
}
