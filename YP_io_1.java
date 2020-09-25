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
		File file = new File(file_path_in);// �������ļ�
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\25719\\Desktop\\" + file));// ���ڶ�ȡ�ı�
		while ((str[num] = br.readLine()) != null) {// ���ı��а��ж�ȡ�ı���������ѭ���Ŀ���
			num++;// ͳ�����ݵ�����
		}
		br.close();
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\25719\\Desktop\\" + file_path_out));// �����洴��һ����Ϊout.txt���ı��ļ������ڴ�Ŵ���������
		PrintStream ps = new PrintStream(fos);// ����д���ı�
		String[] deal = new String[num];// ���ַ������ڴ�Ŵ�������в������ַ���
		String area_temp = str[0].substring(0, str[0].indexOf("\t"));// ��ȡ��һ�����ݵ�ʡ����Ϣ
		ps.println(area_temp);// �����ı�
		System.out.println(area_temp);
		for (int n = 0; n < num; n++) {
			deal[n] = str[n].substring(str[n].indexOf("\t") + 1);// ��ȡ���ݳ�ʡ����Ϣ�����������Ϣ
			if (area_temp.equals((str[n].substring(0, str[n].indexOf("\t"))))) {// �ж�ǰ������������ʡ������Ϣ�Ƿ�һ��
				if (!(deal[n].substring(deal[n].indexOf("\t") + 1)).equals("0")) {// ��ȡ ����������֣��������ж��Ƿ�Ϊ����ȷ����
					ps.println(deal[n]);// �����ı�
					System.out.println(deal[n]);
				}
			} else {
				area_temp = str[n].substring(0, str[n].indexOf("\t"));// ʡ����Ϣ��ͬ�����ǵ�֮ǰ����Ϣ
				ps.println();// �ı�����
				ps.println(area_temp);
				System.out.println(area_temp);
				System.out.println(deal[n]);
				ps.println(deal[n]);
			}
		}
		System.out.print("�ļ��Ѿ����");
		ps.close();
	}

	static void yq_re(String file_path_in, String file_path_out, String temp) throws IOException {
		String[] str = new String[10000];
		int num = 0;
		File file = new File(file_path_in);// �������ļ�
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\25719\\Desktop\\" + file));// ���ڶ�ȡ�ı�
		while ((str[num] = br.readLine()) != null) {// ���ı��а��ж�ȡ�ı���������ѭ���Ŀ���
			num++;// ͳ�����ݵ�����
		}
		br.close();
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\25719\\Desktop\\" + file_path_out));// �����洴��һ����Ϊout.txt���ı��ļ������ڴ�Ŵ���������
		PrintStream ps = new PrintStream(fos);// ����д���ı�
		String[] deal = new String[num];// ���ַ������ڴ�Ŵ�������в������ַ���
		String area_temp = str[0].substring(0, str[0].indexOf("\t"));// ��ȡ��һ�����ݵ�ʡ����Ϣ
		if (area_temp.equals(temp)) {//�޶�ʡ����ָ��һ��
			ps.println(area_temp);// �����ı�
			System.out.println(area_temp);
		}
		for (int n = 0; n < num; n++) {
			deal[n] = str[n].substring(str[n].indexOf("\t") + 1);// ��ȡ���ݳ�ʡ����Ϣ�����������Ϣ
			if (area_temp.equals((str[n].substring(0, str[n].indexOf("\t")))) && area_temp.equals(temp)) {// �ж�ǰ������������ʡ������Ϣ�Ƿ�һ��
				if (!(deal[n].substring(deal[n].indexOf("\t") + 1)).equals("0")) {// ��ȡ ����������֣��������ж��Ƿ�Ϊ����ȷ����
					ps.println(deal[n]);// �����ı�
					System.out.println(deal[n]);
				}
			} else {
				//System.out.println();
				area_temp = str[n].substring(0, str[n].indexOf("\t"));// ʡ����Ϣ��ͬ�����ǵ�֮ǰ����Ϣ
				if (area_temp.equals(temp)) {//�޶�ʡ����ָ��һ��
					ps.println(area_temp);
					System.out.println(area_temp);
					System.out.println(deal[n]);
					ps.println(deal[n]);
				}
			}
		}
		System.out.print("�ļ��Ѿ����");
		ps.close();
	}
}
