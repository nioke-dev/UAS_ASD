public class DLL {
    Node2p head;

    public DLL() {
        head = null;
    }

    // soal 1
    public int[] toArray() {
        int[] arr = new int[size()];
        Node2p tmp = head;
        for (int i = 0; i < arr.length && tmp != null; i++) {
            arr[i] = tmp.data;
            tmp = tmp.next;
        }
        return arr;
    }

    // soal 2
    public DLL sublist(int start, int end) {
        if (start < 0 || end >= size() || start > end) {
            System.out.println("Invalid range!");
            return null;
        }

        DLL sublist = new DLL();
        Node2p tmp = head;
        int count = 0;

        while (tmp != null) {
            if (count >= start && count <= end) {
                sublist.addLast(tmp.data);
            }
            tmp = tmp.next;
            count++;
        }

        return sublist;
    }

    // soal 3
    void addAll(DLL list) {
        Node2p tmp = list.head;
        while (tmp != null) {
            addLast(tmp.data);
            tmp = tmp.next;
        }
    }

    // soal 4
    boolean containsAll(DLL list) {
        Node2p tmp = list.head;
        while (tmp != null) {
            boolean found = false;
            Node2p current = head;
            while (current != null) {
                if (current.data == tmp.data) {
                    found = true;
                    break;
                }
                current = current.next;
            }
            if (!found) {
                return false;
            }
            tmp = tmp.next;
        }
        return true;
    }

    // soal 5
    void removeAll(DLL list) {
        Node2p tmp = list.head;
        while (tmp != null) {
            deleteByData(tmp.data);
            tmp = tmp.next;
        }
    }

    int get(int idx) {
        if (idx < 0 || idx >= size()) {
            System.out.println("Idx invalid!");
            return -1;
        } else {
            Node2p tmp = head;
            for (int i = 0; i < idx; i++) {
                tmp = tmp.next;
            }
            return tmp.data;
        }
    }

    void deleteByData(int data) {
        Node2p tmp = head;
        while (tmp != null) {
            if (tmp.data == data) {
                if (tmp.prev == null) {
                    deleteFirst();
                } else if (tmp.next == null) {
                    deleteLast();
                } else {
                    tmp.prev.next = tmp.next;
                    tmp.next.prev = tmp.prev;
                }
            }
            tmp = tmp.next;
        }
    }

    boolean isEmpty() {
        return head == null ? true : false;
    }

    int size() {
        int n = 0;
        Node2p tmp = head;
        while (tmp != null) {
            n++;
            tmp = tmp.next;
        }
        return n;
    }

    void addLast(int in) {
        Node2p newNode = new Node2p(in);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node2p tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
            newNode.prev = tmp;
        }
    }

    void deleteFirst() {
        if (isEmpty()) {
            System.out.println("Data kosong! operasi deleteFirst gagal!");
        } else if (size() == 1) {
            head = null;
        } else {
            Node2p del = head;
            head.next.prev = null;
            head = head.next;
            del = null;
        }
    }

    void deleteLast() {
        if (isEmpty()) {
            System.out.println("Data kosong! Operasi deleteLast gagal!");
        } else if (size() == 1) {
            head = null;
        } else {
            Node2p tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.prev.next = null;
            tmp.prev = null;
            tmp = null;
        }
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Data kosong! Operasi print gagal");
        } else {
            Node2p tmp = head;
            while (tmp != null) {
                System.out.print("" + tmp.data);
                if (tmp.next != null)
                    System.out.print("-");
                tmp = tmp.next;
            }
            System.out.println("");
        }
    }
}