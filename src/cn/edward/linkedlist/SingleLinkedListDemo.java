package cn.edward.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        PersonNode personNode = new PersonNode(1, "sss");
        PersonNode personNode3 = new PersonNode(3, "dehua");
        PersonNode personNode2 = new PersonNode(2, "zwd");
        PersonNode personNode4 = new PersonNode(4, "BCLE");
        linkedList.addByOrder(personNode);
        linkedList.addByOrder(personNode3);
        linkedList.addByOrder(personNode4);
        linkedList.addByOrder(personNode2);
        linkedList.list();
//        int effectiveNumber = linkedList.getEffectiveNumber();
//        System.out.println(effectiveNumber);
//        linkedList.update(new PersonNode(2, "edward"));
//        linkedList.list();
//        linkedList.delete(3);
//        linkedList.list();
//        System.out.println(linkedList.getEffectiveNumber());
//        System.out.println(linkedList.getReverseKValue(2));
//        System.out.println(linkedList.getReverseKValue(linkedList.getHead(), 2));
        linkedList.reversePrint();
    }

}

//定义链表

class SingleLinkedList {
    private PersonNode head = new PersonNode();

    //不考虑顺序,首先找到链表的最后 最后一个元素的next域指向要添加的节点
    public void add(PersonNode personNode) {
        //因为头节点不能动所以要借助辅助节点
        PersonNode temp = head;
        //遍历链表,当退出循环时temp指向末尾节点
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            } else {
                //如果没有找到最后就把temp后移
                temp = temp.next;
            }
        }
        temp.next = personNode;
    }

    //显示链表
    public void list() {
        if (head.next == null) {
            return;
        }
        //头节点不动 需要辅助节点
        PersonNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            } else {
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    public PersonNode getHead() {
        return head;
    }

    //按照顺序添加
    public void addByOrder(PersonNode personNode) {
        PersonNode temp = head;
        //标识 添加的号是否存在
        boolean isExist = false;

        //因为单链表 所以要找的temp是添加位置的前一个节点，否则无法插入
        while (true) {
            //说明链表已经在最后
            if (temp.next == null) {
                break;
            } else if (temp.next.number > personNode.number) {//说明要插在temp的下一个和temp之间
                break;
            } else if (temp.next.number == personNode.number) {
                isExist = true;
                break;
            }
            temp = temp.next;
        }
        if (isExist) {
            System.out.println("该值已存在,不能添加");
        } else {
            //插入到temp后面
            //temp的next是person的next
            personNode.next = temp.next;
            temp.next = personNode;
        }
    }

    public void update(PersonNode personNode) {
        if (head.next == null) {
            throw new RuntimeException("链表为空");
        }

        PersonNode temp = head.next;

        while (true) {
            if (personNode.number == temp.number) {
                temp.name = personNode.name;
                break;
            }
            temp = temp.next;
        }
    }

    public void delete(int number) {
        PersonNode temp = head;
        if (temp.next == null) {
            System.out.println("链表为空 无法删除");
            return;
        }

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (number == temp.next.number) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    public int getEffectiveNumber() {
        PersonNode temp = head;
        int count = 0;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                count++;
                temp = temp.next;
            }
        }
        return count;
    }

    //获取倒数第K个值
    public String getReverseKValue(int k) {
        PersonNode temp = head;
        int effectiveNumber = getEffectiveNumber();
        if (temp.next == null) {
            return "空链表";
        }
        while (true) {
            if (temp.number == effectiveNumber + 1 - k) {
                return temp.name;
            }
            temp = temp.next;
        }
    }

    //获取倒数第K个值另一种思路
    public String getReverseKValue(PersonNode head, int k) {
        if (head.next == null) {
            return "空链表";
        }
        if (k < 0) {
            return "k不能小于0";
        }

        int effectiveNumber = getEffectiveNumber();
        PersonNode current = head.next;
        for (int i = 0; i < effectiveNumber - k; i++) {
            current = current.next;
        }
        return current.getName();
    }

    //单链表反转
    public void reverse() {
        PersonNode temp = head.next;
        if (temp.next == null || temp.next.next == null) {
            return;
        }
        PersonNode current = head.next;
        PersonNode next = null;//指向当前节点(current)的下一个节点
        PersonNode reversedHead = new PersonNode();

        //便利原链表 每遍历一个节点将其取出 放在当前链表最前端
        while (current != null) {
            next = current.next;//先暂时保存当前节点的下一个节点
            current.next = reversedHead.next;//将current节点的下一个节点指向新链表的头部
            reversedHead.next = current;
            current = next;
        }
        head.next = reversedHead.next;
    }

    //逆序打印
    public void reversePrint() {
        if (head.next == null) {
            System.out.println("空链表");
            return;
        }

        Stack<PersonNode> personNodeStack = new Stack<>();

        PersonNode temp = head.next;

        while (temp != null) {
            personNodeStack.add(temp);
            temp = temp.next;
        }

        while (!personNodeStack.isEmpty()) {
            PersonNode pop = personNodeStack.pop();
            System.out.println(pop);
        }
    }

    public void merge(PersonNode list1, PersonNode list2) {
        if (list1.next == null) {
            System.out.println(list2);
            return;
        }

        if (list2.next == null) {
            System.out.println(list1);
            return;
        }

        PersonNode newListHead = new PersonNode();

        if (list1.number >= list2.number) {
            newListHead.next = list2;
            merge(list1, list2.next);
        } else {
            head.next = list1;
            merge(list1.next, list2);
        }

    }
}

class PersonNode {
    int number;
    String name;
    PersonNode next;    //指向下一个节点

    public PersonNode(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonNode() {
    }

    @Override
    public String toString() {
        return "PersonNode{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}

class SinaReviewQuestion {
    //获取单链表倒数第k个节点的值

    private PersonNode head = new PersonNode();

    private int getEffectiveNumber() {
        PersonNode temp = head;
        int count = 0;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                count++;
                temp = temp.next;
            }
        }
        return count;
    }
}