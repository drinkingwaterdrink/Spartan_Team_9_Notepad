import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoList {
    List<Memo> arr = new ArrayList<>();
    public MemoList() {
        this.arr.add(new Memo( "1111", "여긴 내용입니다1"));
        this.arr.add(new Memo("2222", "여긴 내용이에요2"));
        this.arr.add(new Memo( "2222", "여긴 내용이에요2"));
        this.arr.add(new Memo( "2222", "여긴 내용이에요2"));
        this.arr.add(new Memo( "2222", "여긴 내용이에요2"));
        this.arr.add(new Memo( "2222", "여긴 내용이에요2"));

    }

    @Override
    public String toString() {
        return this.arr.toString();
    }

    public void memoEdit() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");
        String formatedNow = now.format(formatter);

        System.out.println("수정할 index 번호를 입력해주세요");                                      //해당되는 글 1건을 수정하는 메소드가 있다.
        Scanner indexInput = new Scanner(System.in);
        int index = indexInput.nextInt();
        int check = 0;
        if (this.arr.get(index).getText() != null) {
            System.out.println("index (" + index + ") 의 비밀번호를 입력하세요");
            Scanner passwordInput = new Scanner(System.in);
            String password = passwordInput.nextLine();
            check += 1;
            if (password.equals(this.arr.get(index).getPassword())) {
                System.out.println("메모내용 : " + this.idxGetText(index));
                System.out.println("수정할 내용을 입력하세요.");
                Scanner editMemoInput = new Scanner(System.in);
                String editedMemo = editMemoInput.nextLine();
                this.arr.get(index).setText(editedMemo);
                this.arr.get(index).setDate(formatedNow);
            } else if (password != this.arr.get(index).getPassword()) {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }

        if (check == 0) {
            System.out.println("삭제할 메모가 존재하지 않습니다.");
        }
    }

    public void memoDel() {

        System.out.println("삭제할 index 번호를 입력해주세요");                                      //해당되는 글 1건을 삭제하는 메소드가 있다.
        Scanner indexInput = new Scanner(System.in);
        int index = indexInput.nextInt();
        int check = 0;
        if (this.arr.get(index).getText() != null) {
            System.out.println("index (" + index + ") 의 비밀번호를 입력하세요");
            Scanner passwordInput = new Scanner(System.in);
            String password = passwordInput.nextLine();
            check += 1;

            if (password.equals(this.arr.get(index).getPassword())) {
                System.out.println("삭제한 메모내용 : " + this.idxGetText(index));
                this.arr.remove(index);
            } else if (password != this.arr.get(index).getPassword()) {
                System.out.println("비밀번호가 일치하지 않습니다.");

            }
        }

        if (check == 0) {
            System.out.println("수정할 메모가 존재하지 않습니다.");
        }
    }

    public String idxGetText(int index) {            //글의 수정 또는 삭제 시 글 번호를 넘겨 받고 리스트에서 글 번호에 해당하는  글 1건을 얻어와 리턴 시키는 메소드가 있다.
       return this.arr.get(index).text;
    }

    public void getList() {                           //작성 최신 순으로 메모를 출력한다.
        for (int i = (int)arr.size()-1; i>=0; i--) {
            System.out.println(arr.get(i)+"\n");
        }
    }
}
