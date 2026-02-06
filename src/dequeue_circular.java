public class dequeue_circular {
        int f, r;
        int maxsize;
        int[] q;

        dequeue_circular(int size) {
            f = r = -1;
            maxsize = size;
            q = new int[maxsize];
        }

        void enqueue(int x) {
            if ((r + 1) % maxsize == f) {
                System.out.println("Overflow");
                return;
            }

            if (f == -1) {
                f = 0;
                r = 0;
            } else {
                r = (r + 1) % maxsize;
            }
            q[r] = x;
        }

        int dequeue() {
            if (f == -1) {
                System.out.println("Underflow");
                return -1;
            }

            int x = q[f];

            if (f == r) {
                f = r = -1;
            } else {
                f = (f + 1) % maxsize;
            }

            return x;
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
            dequeue_circular dq = new dequeue_circular(5);

            dq.enqueue(10);
            dq.enqueue(20);
            dq.enqueue(30);
            dq.display();

            dq.dequeue();
            dq.display();

            dq.enqueue(40);
            dq.enqueue(50);
            dq.display();
        }


}
