package Intuit;

import java.util.LinkedList;
import java.util.Queue;

// ─────────────────────────────────────────────
// Domain model
// ─────────────────────────────────────────────
enum CustomerTier { VIP, REGULAR }

class Customer {
    private static int vipCounter     = 1;
    private static int regularCounter = 1;

    final String ticketId;
    final String name;
    final CustomerTier tier;

    Customer(String name, CustomerTier tier) {
        this.name     = name;
        this.tier     = tier;
        this.ticketId = (tier == CustomerTier.VIP)
                ? String.format("V-%03d", vipCounter++)
                : String.format("R-%03d", regularCounter++);
    }

    @Override
    public String toString() {
        return ticketId + " [" + tier + "] " + name;
    }
}

// ─────────────────────────────────────────────
// Scheduler
// ─────────────────────────────────────────────
class HelpCenterScheduler {

    // Two separate FIFO queues — O(1) enqueue & dequeue via LinkedList
    private final Queue<Customer> vipQueue     = new LinkedList<>();
    private final Queue<Customer> regularQueue = new LinkedList<>();

    // Tracks how many consecutive VIP customers have been served
    // Once it reaches VIP_RATIO, we must serve a Regular next (if any)
    private static final int VIP_RATIO = 2;
    private int vipCallsInRow = 0;

    /** Check in a customer — O(1) */
    public void checkIn(Customer customer) {
        if (customer.tier == CustomerTier.VIP) {
            vipQueue.offer(customer);
        } else {
            regularQueue.offer(customer);
        }
        System.out.println("Checked in: " + customer);
    }

    /**
     * Call the next customer according to the 2:1 schedule.
     *
     * Rules (in priority order):
     *  1. If vipCallsInRow < VIP_RATIO AND a VIP is waiting → serve VIP.
     *  2. Else if a Regular is waiting → serve Regular and reset counter.
     *  3. Else if a VIP is waiting (no Regular to interleave) → serve VIP.
     *  4. Both queues empty → no one to serve.
     *
     * Time complexity: O(1)
     */
    public Customer callNext() {
        Customer served = null;

        if (vipCallsInRow < VIP_RATIO && !vipQueue.isEmpty()) {
            // Normal VIP turn
            served = vipQueue.poll();
            vipCallsInRow++;
        } else if (!regularQueue.isEmpty()) {
            // Regular turn (either scheduled slot OR no VIPs waiting)
            served = regularQueue.poll();
            vipCallsInRow = 0;          // reset after serving a Regular
        } else if (!vipQueue.isEmpty()) {
            // No Regular available; serve VIP even in the Regular slot
            served = vipQueue.poll();
            vipCallsInRow++;
        }

        if (served != null) {
            System.out.println("Now serving: " + served
                    + "  (VIP streak: " + vipCallsInRow + ")");
        } else {
            System.out.println("No customers waiting.");
        }
        return served;
    }

    public boolean isEmpty() {
        return vipQueue.isEmpty() && regularQueue.isEmpty();
    }

    public int vipWaiting()     { return vipQueue.size(); }
    public int regularWaiting() { return regularQueue.size(); }
}

// ─────────────────────────────────────────────
// Demo
// ─────────────────────────────────────────────
public class ServiceCenterApp {

    public static void main(String[] args) {
        HelpCenterScheduler scheduler = new HelpCenterScheduler();

        // --- Check-ins ---
        System.out.println("=== Check-ins ===");
        scheduler.checkIn(new Customer("Alice",   CustomerTier.VIP));
        scheduler.checkIn(new Customer("Bob",     CustomerTier.VIP));
        scheduler.checkIn(new Customer("Carol",   CustomerTier.VIP));
        scheduler.checkIn(new Customer("Dan",     CustomerTier.REGULAR));
        scheduler.checkIn(new Customer("Eve",     CustomerTier.REGULAR));
        scheduler.checkIn(new Customer("Frank",   CustomerTier.VIP));
        scheduler.checkIn(new Customer("Grace",   CustomerTier.REGULAR));

        // --- Call customers ---
        System.out.println("\n=== Serving ===");
        while (!scheduler.isEmpty()) {
            scheduler.callNext();
        }
    }
}

