package ch9;
import java.util.Scanner;
import java.util.Comparator;
//���� ���� ���� ����Ʈ Ŭ���� DoubleLinkedList<E>�� ��� ��

public class DblLinkedTester {

	static Scanner sc = new Scanner(System.in);

    //--- ������(ȸ����ȣ���̸�) ---//
    static class Data {
        static final int NO   = 1;        // ��ȣ�� �о� ���ϱ��?
        static final int NAME = 2;        // �̸��� �о� ���ϱ��?

        private Integer no;              // ȸ����ȣ
        private String  name;            // �̸�

        //--- ���ڿ� ǥ���� ��ȯ ---//
        public String toString() {
            return "(" + no + ") " + name;
        }

        //--- �����͸� �о� ���� ---//
        void scanData(String guide, int sw) {
            System.out.println(guide + "�� �����͸� �Է��ϼ���.");

            if ((sw & NO) == NO) {
                System.out.print("��ȣ: ");
                no = sc.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.print("�̸�: ");
                name = sc.next();
            }
        }

        //--- ȸ�� ��ȣ�� ������ �ű�� comparator  ---//
        public static final Comparator<Data> NO_ORDER =
                              new NoOrderComparator();

        private static class NoOrderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2) {
                return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
            }
        }

        //--- �̸����� ������ �ű�� comparator  ---//
        public static final Comparator<Data> NAME_ORDER =
                              new NameOrderComparator();

        private static class NameOrderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2) {
                return d1.name.compareTo(d2.name);
            }
        }
    }

    //--- �޴� ������ ---//
    enum Menu {
        ADD_FIRST(  "�Ӹ� ��� ����"),
        ADD_LAST(   "���� ��� ����"),
        ADD(        "���� ��� �ٷ� �ڿ� ����"),
        RMV_FIRST(  "�Ӹ� ��� ����"),
        RMV_LAST(   "���� ��� ����"),
        RMV_CRNT(   "���� ��� ����"),
        CLEAR(      "��ü ��� ����"),
        SEARCH_NO(  "��ȣ �˻�"),
        SEARCH_NAME("�̸� �˻�"),
        NEXT(       "���� ��带 ��������"),
        PREV(       "���� ��带 ��������"),
        PRINT_CRNT( "���� ��� ǥ��"),
        DUMP(       "��ü ��� ǥ��"),
        TERMINATE(  "����");

        private final String message;        // ǥ���� ���ڿ�

        static Menu MenuAt(int idx) {        // ������ idx��°�� ���Ÿ� ��ȯ
            for (Menu m : Menu.values())
                if (m.ordinal() == idx)
                    return m;
            return null;
        }

        Menu(String string) {                        // ������(constructor)
            message = string;
        }

        String getMessage() {                        // ǥ���� ���ڿ��� ��ȯ
            return message;
        }
    }

    //--- �޴� ���� ---//
    static Menu SelectMenu() {
        int key;
        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
                if ((m.ordinal() % 3) == 2 &&
                      m.ordinal() != Menu.TERMINATE.ordinal())
                    System.out.println();
            }
            System.out.print(" : ");
            key = sc.nextInt();
        } while (key < Menu.ADD_FIRST.ordinal() || 
                                            key > Menu.TERMINATE.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;                                // �޴� 
        Data data;                                // �߰��� ������ ����
        Data ptr;                                 // �˻��� ������ ����
        Data temp = new Data();                   // �о� ���� ������

        DblLinkedList<Data> list = new DblLinkedList<Data>(); // ����Ʈ�� ����

        do {
            switch (menu = SelectMenu()) {

             case ADD_FIRST :                           // �Ӹ� ��� ����
                    data = new Data();
                     data.scanData("�Ӹ��� ����", Data.NO | Data.NAME);
                    list.addFirst(data);
                     break;

             case ADD_LAST :                           // ���� ��� ����
                    data = new Data();
                     data.scanData("������ ����", Data.NO | Data.NAME);
                     list.addLast(data);
                     break;

             case ADD :                                 // ���� ��� �ٷ� �ڿ� ��� ����
                    data = new Data();
                     data.scanData("���� ��� �ٷ� �ڿ� ����", Data.NO | Data.NAME);
                     list.add(data);
                     break;

             case RMV_FIRST :                           // �Ӹ� ��� ����
                    list.removeFirst();
                    break;

             case RMV_LAST :                           // ���� ��� ����
                    list.removeLast();
                    break;

             case RMV_CRNT :                           // ���� ��� ����
                    list.removeCunnrentNode();
                    break;

             case SEARCH_NO :                          // ȸ�� ��ȣ �˻�
                     temp.scanData("�˻�", Data.NO);
                    ptr = list.search(temp, Data.NO_ORDER);
                    if (ptr == null)
                        System.out.println("�� ��ȣ�� �����Ͱ� �����ϴ�.");
                    else
                        System.out.println("�˻� ����: " + ptr);
                     break;

             case SEARCH_NAME :                       // �̸� �˻�
                     temp.scanData("�˻�", Data.NAME);
                    ptr = list.search(temp, Data.NAME_ORDER);
                    if (ptr == null)
                        System.out.println("�� �̸��� �����Ͱ� �����ϴ�.");
                    else
                        System.out.println("�˻� ����: " + ptr);
                     break;

             case NEXT :                                 // ���� ��带 �������� ����
                    list.next();
                     break;

             case PREV :                                 // ���� ��带 �������� ����
                    list.prev();
                     break;

             case PRINT_CRNT :                           // ���� ����� �����͸� ǥ��
                    list.printCurrentNode();
                     break;

             case DUMP :                                 // ��� �����͸� ����Ʈ ������ ǥ��
                    list.dump();
                     break;

             case CLEAR :                                // ��ü ��� ����
                    list.clear();
                     break;
            }
        } while (menu != Menu.TERMINATE);
    }

}