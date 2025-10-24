package btw.community.teamcompasses;

import btw.AddonHandler;
import btw.BTWAddon;
import btw.community.teamcompasses.items.ItemTeam1Compass;
import btw.community.teamcompasses.items.ItemTeam2Compass;
import net.minecraft.src.Item;
import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.ItemStack;

public class TeamCompassesAddon extends BTWAddon {
    private static TeamCompassesAddon instance;

    private static final int TEAM_COMPASS_1_ID = 20001;
    private static final int TEAM_COMPASS_2_ID = 20002;

    public static Item teamCompass1;
    public static Item teamCompass2;

    public TeamCompassesAddon() {
        super();
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
        teamCompass1 = new ItemTeam1Compass(TEAM_COMPASS_1_ID);
        teamCompass2 = new ItemTeam2Compass(TEAM_COMPASS_2_ID);

        CraftingManager.getInstance().addShapelessRecipe(
                new ItemStack(teamCompass1),
                new ItemStack(Item.compass),
                new ItemStack(Block.plantRed)
        );

        CraftingManager.getInstance().addShapelessRecipe(
                new ItemStack(teamCompass2),
                new ItemStack(Item.compass),
                new ItemStack(Block.plantYellow)
        );
    }
}