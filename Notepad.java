import java.util.Scanner;

public class Notepad {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        int choice;
        boolean flag = false;

        System.out.println("=====================");
        System.out.println("ㅐ***9조대***메모장***ㅐ");
        System.out.println("=====================");

        while (true) {
            System.out.println("\n1. 입력 2. 목록 보기 3. 수정 4. 삭제 5. 종료");
            System.out.println("숫자를 입력해주세요.");

            choice = sc.nextInt();
            sc.nextLine(); // 없으면 아래 sc.nextLine() 입력이 이상하게 된다.

            switch (choice) {
                case 1:
                    System.out.println("이름을 입력해주세요.");
                    String name = sc.nextLine();
                    System.out.println("비밀번호를 입혁해주세요.");
                    String password = sc.nextLine();
                    System.out.println("메모를 입력해주세요.");
                    String text = sc.nextLine();
                    memoAdd(name, password, text);
                    break;
                case 2:
                    memoList();
                    break;
                case 3:
                    System.out.println("글 번호를 입력해주세요.");
                    int index = sc.nextInt();
                    memoEdit(index);
                    break;
                case 4:
                    System.out.println("글 번호를 입력해주세요.");
                    index = sc.nextInt();
                    memoDel(index);
                    break;
                case 5:
                    System.out.println("사용 종료");
                    flag = true;
                    break;
                default:
                    System.out.println("\n================================");
                    System.out.println("****1~5 사이 숫자를 입력해주세요****");
                    System.out.println("================================\n");
                    break;
            }
            if (flag == true) break;
        }
    }

    private static void memoDel(int index) {
        System.out.println(index + " 삭제");
    }

    private static void memoEdit(int index) {
        System.out.println(index + " 수정");
    }

    private static void memoList() {
        System.out.println("목록");
    }

    private static void memoAdd(String name, String password, String text) {
        System.out.println(name);
        System.out.println(password);
        System.out.println(text);
    }
}
