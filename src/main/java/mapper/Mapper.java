package mapper;

import java.io.*;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

public class Mapper {
    private Map<String, String> map;

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Map<String, String> getMap(){
        return this.map;
    }

    public static Map<String, String> getYaml() {
        String path = "src/main/java/mappings/Sinhala.yml";
        File mapFile = new File(path);
        Yaml yaml = new Yaml();
        Map<String, String> map = null;

        try {
            InputStream inputStream = new FileInputStream(mapFile);
            map = yaml.load(inputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void mapFile(Map<String, String> map, String lang) throws IOException {
        String path = "src/main/java/simply/code/testSn.simply";
        File codeFile = new File(path);
        File targetFile = new File("src/main/java/simply/code/output.simply");

        BufferedReader reader = new BufferedReader(new FileReader(codeFile));
        FileWriter writer = new FileWriter(targetFile);
        String content = "";
        String line = reader.readLine();

        while (line != null)
        {
            content += line + "\n";
            line = reader.readLine();
        }

        System.out.println(content);

        for(Map.Entry<String, String> entry : map.entrySet()){
            if(lang != "eng"){
                content = content.replaceAll(entry.getKey(), entry.getValue());
            }
            else if(lang == "eng"){
                content = content.replaceAll(entry.getValue(), entry.getKey());
            }

        }

        System.out.println(content);
        writer.write(content);

        reader.close();
        writer.close();

    }

    public static void main(String[] args) {
        Mapper mapper = new Mapper();
        String lang = "eng";

        //Retrieve Sinhala.yaml file from mappings
        Map<String, String> map = mapper.getYaml();
        mapper.setMap(map);

        try {
            mapper.mapFile(map, lang);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
