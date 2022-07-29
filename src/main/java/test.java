import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;


public class test
{
    public static void main(String[] args) throws IOException
    {
//        String connectStr="DefaultEndpointsProtocol=https;AccountName=nptkafkastorageaccount;AccountKey=xhn8LKpFrorHR6bjafehjcVMDTDNQTGLNTFTDzb3HL9keHk0Pll3dA04Tn9OXwvhNMHy5iobMkC2+ASt34o3ww==;EndpointSuffix=core.windows.net";
//        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr).buildClient();

        int l=0,w=0,c=0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\nithyashree.muddared\\quickstartd13da568-307f-4ce0-afd1-1cec86298b43.txt"));
               String currLine = br.readLine();
        Path fileName = Path.of("C:\\Users\\nithyashree.muddared\\quickstartd13da568-307f-4ce0-afd1-1cec86298b43.txt");
        String str = Files.readString(fileName);
        printFileSizeNIO(fileName);
        
        while( currLine != null )
        {
            l++;
            String words[] = currLine.split(" ");
            w =w+ words.length;

            for( String word : words)
             c = c + word.length();
            c = c + (words.length-1);

            currLine = br.readLine();

        }

        System.out.println("No of lines:"+ l);
        System.out.println("No of words:"+ w);
        System.out.println("No of characters:"+c);
        System.out.println(str);
    }

    private static   void printFileSizeNIO(Path fileName) throws FileNotFoundException {
        Path path = Paths.get(String.valueOf(fileName));

        try {

            // size of a file (in bytes)
            long bytes = Files.size(path);
            System.out.println(String.format("%,d bytes", bytes));


        } catch (IOException e) {
            e.printStackTrace();
        }
          try
          {
              PrintStream ps = new PrintStream(new File("C:\\details\\DemoFile.txt"));
              System.setOut(ps);
              ps.print(fileName);
          }
          catch(FileNotFoundException ft)
          {
              System.out.println(ft);
          }

        SampleProducer sampleProducer=new SampleProducer();




    }
}
