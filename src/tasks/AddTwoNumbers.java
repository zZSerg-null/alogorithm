package tasks;

import java.util.LinkedList;
import java.util.List;

public class AddTwoNumbers {

    public class ListNode{
        int val;
        ListNode next;
        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode nodeL1, ListNode nodeL2) {

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        int carry = 0; // Для отслеживания переноса при сложении цифр

        // Пока любой из списков не закончился
        while (nodeL1 != null || nodeL2 != null) {
            // Получаем значения текущих узлов, или 0, если список уже закончился
            int x = (nodeL1 != null) ? nodeL1.val : 0;
            int y = (nodeL2 != null) ? nodeL2.val : 0;

            // Вычисляем сумму значений узлов и переноса с предыдущего шага
            int sum = carry + x + y;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10); // Добавляем новый узел в итоговый список
            curr = curr.next; // Перемещаем указатель на следующий узел в итоговом списке

            // Перемещаем указатели в исходных списках, если возможно
            if (nodeL1 != null) nodeL1 = nodeL1.next;
            if (nodeL2 != null) nodeL2 = nodeL2.next;
        }

        // Если после обработки всех узлов остался перенос, добавляем его в итоговый список
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next; // Исключая заголовочный узел из ответа
    }

    private void init(){
        ListNode listNode = new ListNode(7);
        ListNode listNode1 = new ListNode(4, listNode);
        ListNode listNode2 = new ListNode(3, listNode1);

        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(6, listNode3);
        ListNode listNode5 = new ListNode(9, listNode4);

        addTwoNumbers(listNode2, listNode5);
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.init();
    }
}
