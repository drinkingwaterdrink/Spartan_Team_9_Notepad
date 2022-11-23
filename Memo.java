import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memo {
    //
    private String name;
     private String password;
    String text;
    String date;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");
    String formatedNow = now.format(formatter);

    public Memo( String password, String text) {
        this.name = "이름";
        this.password = password;
        this.text = text;
        this.date = this.formatedNow;
    }


    public String getPassword() {
        return password;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return  "파일이름 : " + name +
                "\n작성일 : " + date +
                "\ntext : " + text
                ;
    }
}
