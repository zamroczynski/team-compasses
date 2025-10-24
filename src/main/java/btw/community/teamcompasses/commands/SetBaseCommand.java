package btw.community.teamcompasses.commands;

import btw.community.teamcompasses.manager.TeamBaseManager;
import net.minecraft.src.*;

public class SetBaseCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "setbase";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName() + " <team> <x> <y> <z>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length != 4) {
            throw new WrongUsageException(getCommandUsage(sender));
        }

        try {
            int teamId = parseIntWithMin(sender, args[0], 1);
            int x = parseInt(sender, args[1]);
            int y = parseInt(sender, args[2]);
            int z = parseInt(sender, args[3]);

            TeamBaseManager.getInstance().setTeamBaseLocation(teamId, x, y, z);

            sender.sendChatToPlayer(new ChatMessageComponent().addText("Set base for team " + teamId + " on X:" + x + " Y:" + y + " Z:" + z));

        } catch (NumberFormatException e) {
            throw new NumberFormatException("The coordinates and team number must be integers.");
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return sender.canCommandSenderUseCommand(2, this.getCommandName());
    }
}