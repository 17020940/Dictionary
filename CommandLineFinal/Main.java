package CommandLine;



import java.util.Scanner;

public class Main {
	private Dictionary dictionary ;
	private DictionaryManagement Dm ;
	private DictionaryCommandline Dc ;
	public Main() {
		dictionary = new Dictionary();
		Dm= new DictionaryManagement();
		Dc = new DictionaryCommandline();
	}
	public void display() {
		Scanner cin = new Scanner(System.in);
		Dc.dictionaryAdvanced();
		System.out.println("Huong dan :");
		System.out.println("0 : Thoat chuong trinh");
		System.out.println("1 : Tim kiem tu");
		System.out.println("2 : Them tu");
		System.out.println("3 : Xoa tu");
		System.out.println("4 : Sua tu");
		System.out.println("5 : Goi y tu");
		System.out.println("6 : Luu ra file");
		System.out.println("Chu y khong nhap dau cach truoc cac tu!");
		while (true) {
			String s = cin.nextLine();
			if (!"0".equals(s)&&!"1".equals(s)&&!"2".equals(s)&&!"3".equals(s)&&!"4".equals(s)&&!"5".equals(s)&&!"6".equals(s)) {
				System.out.println("Gia tri khong hop le. Nhap lai gia tri !");
				continue ;
			}
			int i = Integer.parseInt(s);
			if (i==0) break;
			if (i==1) {
				System.out.print("Nhap tu can tim :");
				String str = cin.nextLine();
				int index = Dm.dictionaryLookUp(str);
				if (index > -1) {
					System.out.print("Nghia cua tu la :");
					System.out.println(dictionary.getDictionary().get(index).getWord_explain());
				}
				else System.out.println("Khong co tu nao trong danh sach!");
				
			}
			if (i==2) {
				System.out.print("Them tu :");
				String str = cin.nextLine();
				System.out.print("Them nghia :");
				String str2 =cin.nextLine();
				Word word = new Word(str,str2);
				if (Dm.dictionaryLookUp(str) <0) {
					Dm.addDictionary(word);
					System.out.println("Them thanh cong!");
				}
				else {
					System.out.println("Tu da co trong danh sach!");
				}
			}
			if (i==3) {
				System.out.print("Tu can xoa :");
				String str = cin.nextLine();
				if (Dm.dictionaryLookUp(str)<0) {
					System.out.println("Tu khong co trong danh sach!");
				}
				else {
					Dm.deleteWord(str);
					System.out.println("Xoa thanh cong!");
				}
			}
			if (i==4) {
				System.out.print("Tu can sua:");
				String str = cin.nextLine();
				if (Dm.dictionaryLookUp(str) >=0) {
					Dm.deleteWord(str);
					System.out.print("Tu moi :");
					String str1= cin.nextLine();
					System.out.print("Nghia moi:");
					String str2=cin.nextLine();
					Word word = new Word(str1,str2);
					Dm.addDictionary(word);
					System.out.println("Sua thanh cong!");
				}
				else {
					System.out.println("Tu khong co trong danh sach!");
				}
			}
			if (i==5) {
				System.out.print("Nhap tu: ");
				String str = cin.nextLine();
				Dc.resultSearch(str);
			}
			if (i==6) {
				Dm.dictionaryExportToFile();
				System.out.println("Luu thanh cong!");
			}
		}
		cin.close();
	}

}
