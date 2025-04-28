import java.util.*;

public class Main {
    public static void main(String[] args) {
        showMenu();
    }

    public static void setMap(HashMap<Address, Integer> map) {
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
        HashMap<Address, Integer> costPerAddress = new HashMap<Address, Integer>();
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
                Map<Address, Integer> countryMap = new HashMap<>();
                boolean serchAddress = false;
                for (Map.Entry<Address, Integer> countryEntry : costPerAddress.entrySet()) {
                    if (country.equals(countryEntry.getKey().getCountry())) {
                        serchAddress = true;
                        countryMap.put(countryEntry.getKey(), countryEntry.getValue());
                        countContry.add(countryEntry.getKey().getCountry());
                    }
                }
                boolean cityFound = false;
                if (serchAddress) {
                    System.out.println("Введите город:");
                    String city = sc.nextLine();
                    for (Map.Entry<Address, Integer> cityEntry : countryMap.entrySet()) {
                        if (city.equals(cityEntry.getKey().getCity())) {
                            System.out.println("Введите вес (кг):");
                            int weight = Integer.parseInt(sc.nextLine());
                            int coast = weight * cityEntry.getValue();
                            count += coast;
                            System.out.printf("Стоимость доставки составит: %d\n", coast);
                            System.out.printf("Общая стоимость всех доставок: %d\n", count);
                            cityFound = true;
                            System.out.printf("Количество уникальных стран в которые были оформлены доставки %d\n",countContry.size());
                        }
                    }
                }
                if (!serchAddress || !cityFound) {
                    System.out.println("Такой адрес не обслуживается");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Не верный формат ввода");
            }
        }
    }
}



