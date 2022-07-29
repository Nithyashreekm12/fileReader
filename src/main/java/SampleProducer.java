import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;

public class SampleProducer {
    public SampleProducer() throws FileNotFoundException {



        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> produce = new KafkaProducer<String, String>(properties);

        //reading file
        File read = new File("C:\\Users\\nithyashree.muddared\\reader\\fileReader\\.idea\\DemoFile.txt");
        Scanner scan = new Scanner(read);
        while(scan.hasNextLine()){

            String data = scan.nextLine();
            System.out.println(data);

            //create the producer record
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("topic2",data);

            //send data
            produce.send(record);
        }

        //flush and close
        produce.flush();
        produce.close();

    }
}
