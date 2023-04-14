import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    static Date date = new Date();
    static SimpleDateFormat simplDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String url = "E:\\Games";
        List<File> derictorys = Arrays.asList(
                new File(url, "src"),
                new File(url, "res"),
                new File(url, "saveGames"),
                new File(url, "tmp"),
                new File(url + "\\src\\main"),
                new File(url + "\\src\\test"),
                new File(url + "\\res\\drawables"),
                new File(url + "\\res\\vectors"),
                new File(url + "\\res\\icons")
        );
        derictorys.stream()
                .forEach(d -> {
                    if (d.mkdir()) {
                        sb.append(d.getName() + " Создан " + simplDate.format(date));
                        sb.append("\n");
                        System.out.println("Дериктория создана");
                    } else {
                        sb.append(d.getName() + "Ошибка инцилизации");
                        System.out.println("Дериктория не создана");
                    }
                });
        List<File> files = Arrays.asList(
                new File(url + "\\src\\main\\Main.java"),
                new File(url + "\\src\\main\\Utils.java"),
                new File(url, "\\tmp\\tmp.txt")

        );
        files.stream()
                .forEach(f -> {
                    try {
                        if (f.createNewFile()) {
                            sb.append(f.getName() + " Создан " + simplDate.format(date));
                            sb.append("\n");
                        } else {
                            sb.append(f.getName() + "Ошибка инцилизации");
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(url + "\\tmp\\tmp.txt"))) {
            writer.write(sb.toString());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}