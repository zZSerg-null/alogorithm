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

        int carry = 0; // ��� ������������ �������� ��� �������� ����

        // ���� ����� �� ������� �� ����������
        while (nodeL1 != null || nodeL2 != null) {
            // �������� �������� ������� �����, ��� 0, ���� ������ ��� ����������
            int x = (nodeL1 != null) ? nodeL1.val : 0;
            int y = (nodeL2 != null) ? nodeL2.val : 0;

            // ��������� ����� �������� ����� � �������� � ����������� ����
            int sum = carry + x + y;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10); // ��������� ����� ���� � �������� ������
            curr = curr.next; // ���������� ��������� �� ��������� ���� � �������� ������

            // ���������� ��������� � �������� �������, ���� ��������
            if (nodeL1 != null) nodeL1 = nodeL1.next;
            if (nodeL2 != null) nodeL2 = nodeL2.next;
        }

        // ���� ����� ��������� ���� ����� ������� �������, ��������� ��� � �������� ������
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next; // �������� ������������ ���� �� ������
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
