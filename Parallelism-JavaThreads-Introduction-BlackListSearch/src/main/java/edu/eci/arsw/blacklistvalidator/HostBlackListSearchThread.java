package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import java.util.LinkedList;
import java.util.List;

public class HostBlackListSearchThread extends Thread {

    private final HostBlacklistsDataSourceFacade skds;
    private final String ipaddress;
    private final int startRange;
    private final int endRange;
    private int occurrencesCount;
    private final List<Integer> blackListOccurrences;

    public HostBlackListSearchThread(String ipaddress, int startRange, int endRange) {
        this.skds = HostBlacklistsDataSourceFacade.getInstance();
        this.ipaddress = ipaddress;
        this.startRange = startRange;
        this.endRange = endRange;
        this.occurrencesCount = 0;
        this.blackListOccurrences = new LinkedList<>();
    }

    @Override
    public void run() {
        for (int i = startRange; i <= endRange; i++) {
            if (skds.isInBlackListServer(i, ipaddress)) {
                blackListOccurrences.add(i);
                occurrencesCount++;
            }
        }
    }

    public int getOccurrencesCount() {
        return occurrencesCount;
    }

    public List<Integer> getBlackListOccurrences() {
        return blackListOccurrences;
    }
}
