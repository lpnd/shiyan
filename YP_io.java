import java.io.*;

public class YP_io {
	public static void main(String[] args) throws IOException {
		String[] str = new String[135];
		int num = 0;
		File file = new File("C:\\Users\\25719\\Desktop\\yq_in.txt");// �������ļ�
		BufferedReader br = new BufferedReader(new FileReader(file));// ���ڶ�ȡ�ı�
		while ((str[num] = br.readLine()) != null) {//���ı��а��ж�ȡ�ı���������ѭ���Ŀ���
			num++;//ͳ�����ݵ�����
		}
		br.close();
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\25719\\Desktop\\out.txt"));//�����洴��һ����Ϊout.txt���ı��ļ������ڴ�Ŵ���������
		PrintStream ps = new PrintStream(fos);//����д���ı�
		String[] deal = new String[num];//���ַ������ڴ�Ŵ�������в������ַ���
		String area_temp = str[0].substring(0, str[0].indexOf("\t"));//��ȡ��һ�����ݵ�ʡ����Ϣ
		ps.println(area_temp);//�����ı�
		System.out.println(area_temp);
		for (int n = 0; n < num; n++) {
			deal[n] = str[n].substring(str[n].indexOf("\t") + 1);//��ȡ���ݳ�ʡ����Ϣ�����������Ϣ
			if (area_temp.equals((str[n].substring(0, str[n].indexOf("\t"))))) {//�ж�ǰ������������ʡ������Ϣ�Ƿ�һ��
				if (!(deal[n].substring(deal[n].indexOf("\t") + 1)).equals("0")) {//��ȡ  ����������֣��������ж��Ƿ�Ϊ����ȷ����
					ps.println(deal[n]);//�����ı�
					System.out.println(deal[n]);
				}
			} else {
				System.out.println();
				area_temp = str[n].substring(0, str[n].indexOf("\t"));//ʡ����Ϣ��ͬ�����ǵ�֮ǰ����Ϣ
				ps.println();//�ı�����
				ps.println(area_temp);
				System.out.println(area_temp);
				System.out.println(deal[n]);
				ps.println(deal[n]);
			}
		}
		ps.close();
	}
}