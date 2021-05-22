import ru.pflb.mq.dummy.implementation.ConnectionImpl;
import ru.pflb.mq.dummy.implementation.DestinationImpl;
import ru.pflb.mq.dummy.implementation.ProducerImpl;
import ru.pflb.mq.dummy.implementation.SessionImpl;

import java.util.Arrays;
import java.util.Iterator;

public class Main {



    public static void main(String[] args) {

        ConnectionImpl connection = new ConnectionImpl();
        SessionImpl session = new SessionImpl();
        DestinationImpl destination = new DestinationImpl("Васян");
        ProducerImpl producer = new ProducerImpl(destination);

        String msg [] = new String[3];
        msg[0] = "Раз";
        msg[1] = "Два";
        msg[2] = "Три";


        try {
            Iterator<String> iterator = Arrays.stream(msg).iterator();
            while (iterator.hasNext()) {
                System.out.println("Отправляю сообщение: ");
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
