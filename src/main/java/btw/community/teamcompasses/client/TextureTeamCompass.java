package btw.community.teamcompasses.client;

import net.minecraft.src.TextureCompass;
import com.prupe.mcpatcher.hd.FancyDial;

public class TextureTeamCompass extends TextureCompass {

    public final int teamId;

    public TextureTeamCompass(String iconName, int teamId) {
        super(iconName);
        this.teamId = teamId;
        FancyDial.setup(this);
    }

    @Override
    public boolean isProcedurallyAnimated() {
        return true;
    }
}