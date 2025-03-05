import java.util.concurrent.PriorityBlockingQueue;

class Ticket {
    private int seats;

    public Ticket(int seats) {
        this.seats = seats;
    }

    public synchronized boolean book(String user, int n) {
        if (n <= seats) {
            System.out.println(user + " booked " + n + " seat(s).");
            seats -= n;
            return true;
        }
        System.out.println(user + " booking failed! Not enough seats.");
        return false;
    }
}

class Request implements Comparable<Request> {
    String user;
    int seats, priority;

    public Request(String user, int seats, int priority) {
        this.user = user;
        this.seats = seats;
        this.priority = priority;
    }

    @Override
    public int compareTo(Request r) {
        return Integer.compare(r.priority, this.priority);
    }
}

public class TicketSystem {
    public static void main(String[] args) {
        Ticket t = new Ticket(5);
        PriorityBlockingQueue<Request> q = new PriorityBlockingQueue<>();

        q.add(new Request("VIP User 1", 2, 3));
        q.add(new Request("VIP User 2", 2, 3));
        q.add(new Request("Regular User 1", 1, 2));
        q.add(new Request("Regular User 2", 2, 1));

        while (!q.isEmpty()) {
            Request r = q.poll();
            t.book(r.user, r.seats);
        }
    }
}
