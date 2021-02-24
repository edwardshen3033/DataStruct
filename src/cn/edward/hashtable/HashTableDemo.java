package cn.edward.hashtable;

//哈希表
public class HashTableDemo {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "EDWARD");
        Employee employee2 = new Employee(8, "EDWARD2");
        HashTable hashTable = new HashTable(7);
        hashTable.add(employee);
        hashTable.add(employee2);
//        hashTable.list();
        hashTable.findById(15);
    }
}

class HashTable {

    private EmployeeLinkedList[] employeeLinkedListArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        //初始化链表
        this.employeeLinkedListArray = new EmployeeLinkedList[size];
        //不要忘了初始化每个链表
        for (int i = 0; i < size; i++) {
            this.employeeLinkedListArray[i] = new EmployeeLinkedList();
        }
    }

    //添加雇员
    public void add(Employee employee) {
        //根据员工的id得到应该添加到哪条链表
        int hash = hash(employee.id);
        //将employ添加到对应的链表
        employeeLinkedListArray[hash].add(employee);
    }

    //遍历所有链表,遍历哈希表
    public void list() {
        for (int i = 0; i < size; i++) {
            System.out.println("当前链表为" + i + "   ");
            employeeLinkedListArray[i].list();
        }
    }

    //根据输入的id查找雇员
    public void findById(int id) {
        int hash = hash(id);
        Employee employee = employeeLinkedListArray[hash].find(id);
        if (employee!=null){
            System.out.println("找到该雇员："+ employee);
        }else {
            System.out.println("没有找到该雇员");
        }
    }

    //编写散列函数
    private int hash(int id) {
        return id % size;
    }
}

class Employee {
    public int id;
    public String name;
    public Employee next;//next为空

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmployeeLinkedList {
    //头指针指向第一个元素，因此链表的head直接指向第一个Employee
    private Employee head = null;

    //添加到链表
    //假定添加雇员时 id是自增的 id分配从小到大 因此将该元素直接添加到本链表尾部
    public void add(Employee employee) {
        if (head == null) {
            head = employee;
            return;
        } else {
            //如果不是第一个雇员 定义一个辅助指针帮助定位到最后
            Employee current = head;
            while (true) {
                if (current.next != null) {
                    current = current.next;
                } else {
                    break;
                }
            }
            current.next = employee;
        }
    }

    //遍历查找
    public void list() {
        if (head == null) {
            return;
        }
        Employee temp = head;
        while (true) {
            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }

    //根据雇员查找
    public Employee find(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        if (head.id == id) {
            return head;
        }
        Employee temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.id == id) {
                return temp.next;
            } else {
                temp = temp.next;
            }
        }
        return null;
    }
}
