import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 2) Пусть дан список сотрудников:Иван Иванов и т.д.
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

public class SortingNamesInList {
    public static void main(String[] args) {
        Map<String, Integer> usermap = new HashMap<>();
        List<String> workersList = Arrays
                .asList("Иванов Иван", "Максимов Максим", "Петров Петр", "Иванов1 Иван", "Максимов1 Максим",
                        "Петров1 Петр", "Иванов2 Иван", "Максимов2 Максим", "Иванов3 Иван", "Ленин Леонид",
                        "Ленин1 Леонид", "Дональд Дак");

        usermap = convertArrayToMap(clearSecondName(workersList));
        System.out.println(sortingByValueHash(usermap));
    }

    public static List<String> clearSecondName(List<String> incomingList) {
        List<String> changedList = new ArrayList<>();
        List<String> outcomingList = new ArrayList<>();
        String convertToLine = new String();
        for (String el : incomingList) {
            convertToLine += el.replace(" ", ",") + ",";
        }
        changedList = (Arrays.asList(convertToLine.split(",")));
        for (int i = 1; i < changedList.size(); i += 2) {
            outcomingList.add(changedList.get(i));
        }
        return outcomingList;
    }

    public static Map<String, Integer> convertArrayToMap(List<String> list) {
        Map<String, Integer> newmap = new HashMap<>();
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        int count = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).equals(list.get(i))) {
                count++;
            } else {
                if (count == 1)
                    continue;
                else {
                    newmap.put(list.get(i - 1), count);
                    count = 1;
                }
            }
        }
        if (count > 1)
            newmap.put(list.get(list.size() - 1), count);
        return newmap;
    }

    public static Map<String, Integer> sortingByValueHash(Map<String, Integer> userhashmap) {
        userhashmap = userhashmap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
        return userhashmap;
    }
}
