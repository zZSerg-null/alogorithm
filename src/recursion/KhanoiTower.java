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

        System.out.println("���������� stick1 : " + stick1);
        System.out.println("���������� stick2 : " + stick2);
        System.out.println("���������� stick3 : " + stick3);

        System.out.println("------------------------------");
        moveDisks(n, stick1, stick2, stick3);
        System.out.println("------------------------------");

        System.out.println("���������� stick1 : " + stick1);
        System.out.println("���������� stick2 : " + stick2);
        System.out.println("���������� stick3 : " + stick3);
        System.out.println("�����: "+ step);
    }

    private void moveDisks(int n, LinkedList<Integer> source, LinkedList<Integer> auxiliary, LinkedList<Integer> target) {
        if (n > 0) {
            step++;
            // ���������� n-1 ������ � source �� auxiliary, ��������� target � �������� ���������������� �����
            moveDisks(n - 1, source, target, auxiliary);


            // ���������� ������� ���� � source �� target
            int disk = source.peek();
            System.out.println("����������� ���� " + disk + " � " + source + " �� " + target);
            target.push(source.pop());
            step++;

            // ���������� n-1 ������ � auxiliary �� target, ��������� source � �������� ���������������� �����
            moveDisks(n - 1, auxiliary, source, target);
        }
    }

}
