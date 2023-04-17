import java.io.*;

public class TextFileReaderWriter {

    private String fileName;

    public TextFileReaderWriter(String fileName) {
        this.fileName = fileName;
    }

    public String readFile() throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }
        reader.close();
        return content.toString();
    }
    public  String readScoreLine() throws IOException {
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            line = br.readLine();
        }
        return line;
    }

    public void writeFile(String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(content);
        writer.close();
    }
}
