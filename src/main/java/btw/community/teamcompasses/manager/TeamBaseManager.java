package btw.community.teamcompasses.manager;

import net.minecraft.src.ChunkCoordinates;
import java.util.HashMap;
import java.util.Map;

public class TeamBaseManager {

    private static final TeamBaseManager instance = new TeamBaseManager();

    private TeamBaseManager() {}

    public static TeamBaseManager getInstance() {
        return instance;
    }

    private final Map<Integer, ChunkCoordinates> teamBases = new HashMap<>();

    public void setTeamBaseLocation(int teamId, int x, int y, int z) {
        ChunkCoordinates coords = new ChunkCoordinates(x, y, z);
        teamBases.put(teamId, coords);
        System.out.println("[TeamCompasses] Ustawiono bazę dla drużyny " + teamId + " na: " + x + ", " + y + ", " + z);
    }

    public ChunkCoordinates getTeamBaseLocation(int teamId) {
        return teamBases.get(teamId);
    }

    public boolean hasBaseLocation(int teamId) {
        return teamBases.containsKey(teamId);
    }
}