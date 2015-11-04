package spring;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LeaveList {

    private final Map<String, Leave> leaves = new TreeMap<>();

    public LeaveList() {
    }

    public LeaveList(List<Leave> leaves) {
        for (Leave leave : leaves) {
            this.leaves.put(leave.getId(), leave);
        }
    }

    public Collection<Leave> list() {
        return leaves.values();
    }

    public void replace(Leave user) {
    	leaves.put(user.getId(), user);
    }

    public Leave get(String id) {
        return leaves.get(id);
    }

    public void delete(String id) {
    	leaves.remove(id);
    }
}
