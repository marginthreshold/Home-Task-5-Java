import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

public class PhoneBookStructure {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        addContact(phoneBook);
        printPB(phoneBook);
    }

    public static void addContact(Map<String, List<String>> incomingPB) {
        Scanner sc = new Scanner(System.in, "Cp866");
        String userName, phoneNumber;
        String outAddingContacts = "";
        do {
            System.out.println("Давайте добавим данные в телефонную книгу: ");
            System.out.println("Введите Фамилию и Имя контакта: ");
            userName = sc.next();
            if (incomingPB.containsKey(userName)) {
                System.out.println("Такой контакт уже существует. Текущие номера: ");
                System.out.println(
                        String.join(", ", incomingPB.get(userName)) + "\n Добавтье еще номер к текущему контакту");
                phoneNumber = sc.next();
                incomingPB.get(userName).add(phoneNumber);
            } else {
                System.out.println("Добавьте номер телефона: ");
                phoneNumber = sc.next();
                List<String> list = new ArrayList<>();
                list.add(phoneNumber);
                incomingPB.put(userName, list);
            }
            System.out.println("Если больше не нужно добавлять контакты, введите exit");
            outAddingContacts = sc.next();
        } while (!outAddingContacts.equals("exit"));
        sc.close();
    }

    public static void printPB(Map<String, List<String>> incomingPB) {
        for (var el : incomingPB.entrySet()) {
            System.out.println("Контакт: " + el.getKey() + " ; Номера телефона: " + String.join(", ", el.getValue()));
        }
    }

}
