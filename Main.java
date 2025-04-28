import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Address, Integer> costPerAddress = new HashMap<Address, Integer>();
        setMap(costPerAddress);
        String s = "Россия";
        String ss = "Москва";
        System.out.println(costPerAddress.containsKey(new Address(s, ss)));
        showMenu();

    }

    public static void setMap(Map<Address, Integer> map) {
        Address[] addresses = {
                new Address("Россия", "Москва", 30),
                new Address("Россия", "Казань", 50),
                new Address("Казахстан", "Астана", 100),
                new Address("Россия", "Екатеринбург", 80),
                new Address("Казахстан", "Алматы", 120),
                new Address("Польша", "Варшава", 150),
                new Address("Эстония", "Таллин", 160),
                new Address("Германия", "Берлин", 200)};

        for (Address item : addresses) {
            map.put(item, item.getPrice());
        }
    }

    public static void showMenu() {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        Map<Address, Integer> costPerAddress = new HashMap<Address, Integer>();
        setMap(costPerAddress);
        Set<String> countContry = new HashSet<>();
        while (true) {
            try {
                System.out.println("Заполнение нового заказа.");
                System.out.println("Введите страну или 'end' для завершения:");
                String country = sc.nextLine();
                if (country.toLowerCase().equals("end")) {
                    break;
                }
                System.out.println("Введите город:");
                String city = sc.nextLine();
                boolean serchAddress = false;
                if (costPerAddress.containsKey(new Address(country, city))) {
                    serchAddress = true;
                    if(!countContry.contains(country)){
                        countContry.add(country);
                    }
                }
                Address serchKey = new Address(country,city,0);
                if (serchAddress) {
                    System.out.println("Введите вес (кг):");
                    int weight = Integer.parseInt(sc.nextLine());
                    int coast = weight * costPerAddress.get(serchKey);
                    count += coast;
                    System.out.printf("Стоимость доставки составит: %d\n",coast);
                    System.out.printf("Общая стоимость всех доставок: %d\n",count);
                    System.out.printf("Количество уникальных стран в которые были оформлены доставки %d\n", countContry.size());
                }
                else {
                    System.out.println("Такой адрес не обслуживается");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Не верный формат ввода");
            }
        }
    }
}



