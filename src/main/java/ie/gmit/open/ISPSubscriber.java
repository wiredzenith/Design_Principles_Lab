package ie.gmit.open;

import java.util.List;

public class ISPSubscriber extends Subscriber {
    public ISPSubscriber(Long subscriberId, String address, Long phoneNumber, int baseRate, long freeUsage) {
        super(subscriberId, address, phoneNumber, baseRate);
        this.freeUsage = freeUsage;
    }

    private long freeUsage;

    public double calculateBill() {
        List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions(getSubscriberId());
        long totalData = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
        long chargeableData = totalData - freeUsage;
        return chargeableData*getBaseRate()/100;
    }

    /**
     * @return the freeUsage
     */
    public long getFreeUsage() {
        return freeUsage;
    }

    /**
     * @param freeUsage the freeUsage to set
     */
    public void setFreeUsage(long freeUsage) {
        this.freeUsage = freeUsage;
    }

    
}