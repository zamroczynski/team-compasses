# Team Compasses

Team Compasses is an addon for Better Than Wolves CE 3.0.0 that enhances the multiplayer experience. It introduces two new items: the **Team 1 Compass** and the **Team 2 Compass**. These function like the regular compass, but instead of pointing to the world spawn, they guide players to their team's designated rally point.

**This is the first mod I have ever created**, designed to solve a problem I encountered while playing with a larger group of friends.

### [Download Latest Realease](https://github.com/zamroczynski/team-compasses/releases/tag/1.0.0)

[View on GitHub](https://github.com/zamroczynski/team-compasses)

## Features

- **Two New Compasses**: One for each team.
- Simple Crafting Recipes: Easy to craft for all players.
- Admin Command: A simple command for server operators to set base locations.
- Vanilla Behavior: If a base isn't set, the compass defaults to pointing at the world spawn.

## Instalation
Place the `.jar` file in the `mods` folder on both the client and server.

## Usage

### For Player (Crafting)

The compasses can be crafted by any player

- Team 1 Compass: `Compass + Red Flower`
- Team 2 Compass: `Compass + Yellow Flower`

**Important:** To ensure the compass points in the correct direction, you must be holding it in your main hand.

### For Server Admins (Commands)

Server operators can set the base location for each team using the `/setbase` command.

**Syntax:**
`/setbase <team_number> <x> <y> <z>`

**Example:**
`/setbase 1 1234 64 -3421`

## Disclaimer
This mod only adds the compass items; it does not assign players to teams or manage team membership. Any player can craft and use both the Team 1 and Team 2 compasses. It is intended as a utility for organized gameplay.
