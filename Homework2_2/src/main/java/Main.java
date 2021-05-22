import ru.pflb.mq.dummy.implementation.ConnectionImpl;
import ru.pflb.mq.dummy.implementation.DestinationImpl;
import ru.pflb.mq.dummy.implementation.ProducerImpl;
import ru.pflb.mq.dummy.implementation.SessionImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {



    public static void main(String[] args) throws IOException {

        ConnectionImpl connection = new ConnectionImpl();
        SessionImpl session = new SessionImpl();
        DestinationImpl destination = new DestinationImpl("Васян");
        ProducerImpl producer = new ProducerImpl(destination);

        List<String> msg = Files.readAllLines(Paths.get(args[0]), UTF_8);

        try {
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                //System.out.println("Отправляю сообщение: ");
                producer.send(iterator.next());
                Thread.sleep(2000);
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Молодец, что закрыл сессию! \n" +
                "Молодец, что закрыл соединение!");

    }
}
