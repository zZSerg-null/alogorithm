package TEST;


import java.util.*;

class Candy {
    // название
    final String name;
    // цена
    final double price;
    //проданное количество
    final int amount;
    // другие варианты названия
    final Set<String> alternativeNames;

    public Candy(String name, double price, int amount, Collection<String> alternativeNames) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.alternativeNames = Set.copyOf(alternativeNames);
    }

    public Candy(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.alternativeNames = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", alternativeNames=" + alternativeNames +
                '}';
    }
}

//содержимое этого класса не нужно менять
class SRM {
    private final Map<String, List<Candy>> suppliersProducts = new HashMap<>();

    public SRM() {
        suppliersProducts.put("Первая кондитерская фабрика", List.of(
                new Candy("Мишка на севере", 34.4, 100, Set.of("Мишка косолапый", "Мишка")),
                new Candy("Победа", 56, 35, Set.of("Победа вкуса")),
                new Candy("Два верблюда", 20, 47, Set.of("Каракум", "Африка")),
                new Candy("Красная шапочка", 35, 3, Set.of("КРАСНАЯ ШАПОЧКА"))
        ));

        suppliersProducts.put("Триумф", List.of(
                new Candy("Мишка в лесу", 34.2, 63, Set.of("Мишка косолапый")),
                new Candy("Трюфель", 21, 25, Set.of("Трюфель классический", "Трюфель шоколадный"))
        ));

        suppliersProducts.put("Сладости Везде", List.of(
                new Candy("Шоколадный восторг", 33.98, 257, Collections.emptySet()),
                new Candy("Африка", 25, 114, Set.of("Каракум", "два.верблюда"))
        ));
        suppliersProducts.put("ООО Дом Шоколада", List.of(
                new Candy("ШокоБомб", 20, 1, Set.of("Шоко_бомб")),
                new Candy("Трюфель классический", 35, 94, Set.of("Трюфель шоколадный"))
        ));

    }

    // Возвращает название всех поставщиков
    public Set<String> listSuppliers() {
        // Создаём новую коллекцию на основе множества имеющихся поставщиков
        // Создание новой коллекции необходимо, чтобы клиентский код не смог
        // повлиять на содержимое, хранящееся в Map
        return new HashSet<>(suppliersProducts.keySet());
    }

    // Возвращает информацию о товаре на складе поставщика
    // Если поставщик или товар не найден, возвращает null
    public Candy getProduct(String supplierName, String candyName) {
        List<Candy> candies = suppliersProducts.get(supplierName);
        if (candies != null) {
            for (Candy candy : candies) {
                if (candy.name.equals(candyName)
                        || candy.alternativeNames.contains(candyName)) {
                    return candy;
                }
            }
        }
        return null;
    }
}

class Warehouse {
    private final List<Candy> candies;

    public Warehouse() {
        this.candies = List.of(
                new Candy("Мишка в лесу", 32, 2, Set.of("Мишка косолапый")),
                new Candy("Трюфель", 44, 5, Set.of("Трюфель классический", "Трюфель шоколадный")));
    }

    // Ищет конфеты на складе по их названию
    // Возвращает пустой Optional, если конфеты отсутствуют
    // или в обратном случае Optional, содержащий соответствующие конфеты
    public Optional<Candy> search(String name) {
        return candies.stream()
                .filter(candy -> candy.name.equals(name) || candy.alternativeNames.contains(name))
                .findFirst();
    }
}

class SearchService {
    // Создаём объект класса, отвечающий за склад магазина
    private final Warehouse warehouse = new Warehouse();

    // Создаём объект класса, отвечающий за работу с поставщиками
    public final SRM srm = new SRM();

    // Основной метод поиска
    // Проверяет наличие товара с указанным именем на складе магазина
    // Если товар отсутствует, то проверяются склады поставщиков,
    // предпочтение отдаётся тому поставщику, у которого наименьшая цена товара.
    // Для поиска товара на складе поставщиков используется метод supplierSearch
    // Если товар нигде не найден, то возвращается пустой Optional
    public Optional<Candy> search(String candyName) {
        Optional<Candy> candy = warehouse.search(candyName);
        if( candy.isEmpty() ){
            return supplierSearch(candyName);
        } else
            return candy;

    }

    // Ищет товар с указанным именем на складах поставщиков
    // Возвращает Optional с самым дешевым вариантом товара среди всех
    // поставщиков или пустой Optional, если товар не найден
    private Optional<Candy> supplierSearch(String candyName) {
        return  srm.listSuppliers().stream()
                .map(s -> Optional.ofNullable(srm.getProduct(s, candyName)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .min(Comparator.comparing(candy -> candy.price))
                .stream().findFirst();
    }
}
/*
class Practicum {

    public static void main(String[] args) {
        SearchService searchService = new SearchService();
        searchService.search("Африка").
                ifPresentOrElse(
                        (candy) -> System.out.println("Товар \"" + candy.name + "\" доступен в количестве \"" + candy.amount +
                                "\" кг по цене \"" + candy.price + "\" руб за кг"),
                        () -> System.out.println("Данный товар не найден")
                );
    }
}*/


public class streams {

/*
    static List<Integer> integers =  List.of(1,1,1,1,1,1,2,3,4,5,6,7,8);

    public static void main(String[] args) {
        System.out.println(
            integers.stream()
                    .min(Integer::compare).get()
        );
    }
*/

}


