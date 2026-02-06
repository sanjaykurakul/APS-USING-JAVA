public class insertfront {
    int f, r;
    int maxsize;
    int[] q;

    insertfront(int size) {
        f = r = -1;
        maxsize = size;
        q = new int[maxsize];
    }

    void insertFront(int x) {
        if ((f == 0 && r == maxsize - 1) || (f == r + 1)) {
            System.out.println("Overflow");
            return;
        }

        if (f == -1) {
            f = r = 0;
        } else if (f == 0) {
            f = maxsize - 1;
        } else {
            f = f - 1;
        }

        q[f] = x;
    }

    void display() {
        if (f == -1) {
            System.out.println("Queue is empty");
            return;
        }

        int i = f;
        while (true) {
            System.out.print(q[i] + " ");
            if (i == r)
                break;
            i = (i + 1) % maxsize;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insertfront dq = new insertfront(5);

        dq.insertFront(10);
        dq.insertFront(20);
        dq.insertFront(30);
        dq.display();
    }
}
