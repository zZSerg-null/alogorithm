package recursion;

import java.util.LinkedList;

public class KhanoiTower {

    LinkedList<Integer> stick1 = new LinkedList<>();
    LinkedList<Integer> stick2 = new LinkedList<>();
    LinkedList<Integer> stick3 = new LinkedList<>();

    long step = 0;

    public static void main(String[] args) {
        KhanoiTower tower = new KhanoiTower();
        tower.init(10);
    }

    private void init(int n){
        for (int i = n; i > 0; i--) {
            stick1.push(i);
        }

        System.out.println("Содержимое stick1 : " + stick1);
        System.out.println("Содержимое stick2 : " + stick2);
        System.out.println("Содержимое stick3 : " + stick3);

        System.out.println("------------------------------");
        moveDisks(n, stick1, stick2, stick3);
        System.out.println("------------------------------");

        System.out.println("Содержимое stick1 : " + stick1);
        System.out.println("Содержимое stick2 : " + stick2);
        System.out.println("Содержимое stick3 : " + stick3);
        System.out.println("Шагов: "+ step);
    }

    private void moveDisks(int n, LinkedList<Integer> source, LinkedList<Integer> auxiliary, LinkedList<Integer> target) {
        if (n > 0) {
            step++;
            // Перемещаем n-1 дисков с source на auxiliary, используя target в качестве вспомогательного стека
            moveDisks(n - 1, source, target, auxiliary);


            // Перемещаем верхний диск с source на target
            int disk = source.peek();
            System.out.println("Переместить диск " + disk + " с " + source + " на " + target);
            target.push(source.pop());
            step++;

            // Перемещаем n-1 дисков с auxiliary на target, используя source в качестве вспомогательного стека
            moveDisks(n - 1, auxiliary, source, target);
        }
    }

}
