# Healthy Stray Varrock Dogs

Healthy Stray Varrock Dogs is a cosmetic RuneLite plugin that makes the stray dogs in Varrock, including Duke (Charlie the Tramp's dog), appear healthy.

The change is local to your RuneLite client. It does not alter the game world, interact with other players, or provide gameplay assistance.

## Configuration

After installing the plugin, open the RuneLite Configuration panel and find **Healthy Stray Varrock Dogs**.

- **Heal Varrock Dogs** — turns the cosmetic healthy-dog appearance on or off.
- **Random favorite breeds** — optionally replaces the unnamed strays with randomly selected pet appearances. Disabled by default. Duke always keeps his healed appearance and original coat.
- Expand a breed section and check the exact **Puppy/Adult + color** combinations you want. There are 72 choices across 12 breeds. For example, choose **Corgi → Puppy: Fawn** and **Labrador → Adult: Chocolate** to draw only from those two appearances.

Each checked combination has an equal chance. A dog keeps its choice while it remains loaded, then receives a fresh random choice when it respawns (for example, after leaving and returning to Varrock). Changing settings or re-enabling the plugin also rerolls the visible strays. A new roll can select the same appearance again. With no favorites checked, the plugin falls back to normal healing, preserving brown and grey coats.

These are visual replacements only: the strays do not become owned pets and do not gain pet actions. The original names, interactions, and server behavior remain unchanged. [Variant data and verification](docs/dog-variants.md).

## Installation

Once the plugin has been accepted into the RuneLite Plugin Hub:

1. Open RuneLite.
2. Open the **Plugin Hub**.
3. Search for **Healthy Stray Varrock Dogs**.
4. Select **Install**, then enable it from the RuneLite Configuration panel.

## Development

To run the plugin from source, use the Gradle wrapper from the project root:

```powershell
.\gradlew.bat run
```

Test the appearance in Varrock, including both stray dogs and Duke, and verify that toggling **Heal Varrock Dogs** turns the cosmetic change on and off.

For Jagex Accounts, follow RuneLite's [development login instructions](https://github.com/runelite/runelite/wiki/Using-Jagex-Accounts). Never share or commit the credentials file mentioned in that guide.

Before submission, also test enabling the plugin beside an already visible dog, leaving and returning to Varrock, world hopping, logging out and back in, and disabling the whole plugin. Confirm the original appearance returns and other NPCs are unaffected. A successful build alone does not verify the in-game appearance.
