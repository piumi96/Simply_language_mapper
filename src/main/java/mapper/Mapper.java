package mapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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

    public static void getYaml() {
        String path = "src/main/java/mappings/Sinhala.yml";
        File mapFile = new File(path);
        Yaml yaml = new Yaml();
        try {
            InputStream inputStream = new FileInputStream(mapFile);
            Map<String, String> map = yaml.load(inputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        /*InputStream inputStream;

        try {
            inputStream = new FileInputStream(mapFile);
            Map<String, String> map = yaml.load(inputStream);
            System.out.println(map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
*/


    }

    public static void main(String[] args) {
        Mapper mapper = new Mapper();
        mapper.getYaml();
    }
}
