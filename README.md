# Refield

<div align="center">

<a href='https://fabricmc.net'><img alt="fabric" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/fabric_vector.svg"></a>
<a href='https://neoforged.net/'><img alt="neoforge" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/neoforge_vector.svg"></a>

</div>

Refield is a 1.21 multiloader rewrite/port of Team Collections' [Field](https://modrinth.com/mod/collections-field).
Field is a mod that breathes some new wind into the Banner system, adding new patterns, features, and removing limits.
Let your creativity fly!

---

<img src="https://raw.githubusercontent.com/Team-Collections/.github/refs/heads/main/assets/showcase/Banners.png" alt="A collage of different banners in different environments. The first showcases the LGBTQ flag, Trans flag, and Nonbinary flag in a bedroom. The second showcases red and yellow banners on a desert house. The third showcases blue banners with a yellow shield hanging above a medieval tavern. The last showcases a wide variety of random banners in a medieval textile mill." align="center"/>

---

**Refield** aims to largely keep parity with the 1.21.4 Fabric version of Field. Some things that were changed for the
1.21 port:

- Refield uses YACL for in-game configuration instead of MidnightLib
- The star banner pattern's item texture was changed to match the older 1.21 style (the original is still present in the
  mod resources if desired)

---

## Features (from the original page)

### New Banner Patterns

Field adds many, many new banner patterns, allowing for even greater customizability. All of them attempt to be in-line
with heraldry - the system banner patterns are based off of, so they should fit well with the rest of the banner
patterns.

<img src="https://raw.githubusercontent.com/Team-Collections/.github/refs/heads/main/assets/showcase/Textile%20Mill.png" alt="A medieval textile mill with one large loom and a smaller loom off to the side. The wall and large loom has a large variety of random banners, showing off the banner patterns added." align="center"/>

---

### Retextured Banners and Patterns

The banner has been retextured to be a little less noisy and clean. Along with this, many of the vanilla banner patterns
have also been retextured, smoothing them out. There should hopefully be little difference to your existing designs.

---

### Renamed Banner Patterns

Some of the vanilla banner patterns didn't fit into the naming scheme of heraldry (read above), so they have been
updated to fit in. None of the designs have been significantly changed, only the names.

---

### More Banner Layers

Having a limit of only 6 banner layers is both arbitrary and incredibly limiting. Now, there's a default limit of 32
layers, which is configurable.

To avoid having a mile-long tooltip, the tooltip will only display, by default, the most recent 8 layers, with the rest
being trimmed. The limit for this is also configurable.

<img src="https://raw.githubusercontent.com/Team-Collections/.github/refs/heads/main/assets/showcase/More%20Banner%20Layers.png" alt="A banner being hovered over, showing a tooltip describing it. The banner has the patterns: Blue Grady Base, Blue Grady Chief, Blue Bordure, Blue Per Fess Base, Blue Per Pale Sinister, Blue Per Fess Chief, Blue Per Pale Dexter, Blue Fusil, and with 24 more being trimmed." align="center"/>

---

### Hanging Banners

Banners can now be placed on either the bottom of a block or the side of a block, similar to hanging signs. They can
also connect with hanging signs, allowing for creative decorations.

<img src="https://raw.githubusercontent.com/Team-Collections/.github/refs/heads/main/assets/showcase/Hanging%20Banners%20Tavern.png" alt="Two banners hanging above the entrance to a medieval tavern. They're both identical blue banners with a thin, yellow outline, and have a shield shape in the middle." align="center"/>

---

### Wearable Banners

Even in vanilla, banners have functionality for rendering on the player's head. Now, banners are able to simply be
placed into your helmet slot.

<img src="https://raw.githubusercontent.com/Team-Collections/.github/refs/heads/main/assets/showcase/Trigam%20Captain.png" alt="A Minecraft player wearing an Ominous Banner on their head." align="center"/>

---

### Stackable Banners

As a simple quality of life change, banners now have a default stack size of 64. Once again, this is configurable.

<img src="https://raw.githubusercontent.com/Team-Collections/.github/refs/heads/main/assets/showcase/Stackable%20Banners.png" alt="An image of a stack of 64 banners, showing that they're now stackable to 64." align="center"/>

---

### Loom Tooltips

When hovering over a banner pattern in the loom, there is now a tooltip, containing the name and ID of the pattern. This
can be disabled in the config in order to restore the vanilla behavior.

<img src="https://raw.githubusercontent.com/Team-Collections/.github/refs/heads/main/assets/showcase/Loom%20Tooltip.png" alt="An image of the loom screen. The banner pattern 'Pall Chief' is being hovered over, showing a tooltip." align="center"/>

---

### Updated Banner Tooltip

Banners, rather than the tooltip being an unlabeled list of banner patterns, now has a tooltip more in-line with the
modern style of tooltip. The list now is titled "Patterns", and indented, similar to the tooltip of Smithing Templates.

As a bonus, this fixes [MC-217525](https://bugs.mojang.com/browse/MC-217525).

#### Notice

Banner Pattern tooltips have also been changed to have more simplified translations. Since this changes the translation
key, this will break a lot of other custom banner patterns' translations. **Reach out on the Discord to request custom
translations be added for a datapack/mod!**

<img src="https://raw.githubusercontent.com/Team-Collections/.github/refs/heads/main/assets/showcase/Reworked%20Tooltip.png" alt="A Shield being hovered over, with a reworked tooltip describing it. The Shield has a Pink Banner, with the patterns: Light Blue Pale Sinister, Light Blue Pale Dexter, and White Pale. The Shield is enchanted with: Unbreaking 3 and Mending." align="center"/>

---

# Compatibilities

Refield has explicit compatibility with:

- [Supplementaries](https://modrinth.com/mod/supplementaries),
  by [MehVahdJukaar](https://modrinth.com/user/MehVahdJukaar)
    - Adds compatibility for flags to work with Refield's features like custom stack sizes, extended layer limits, and
      tooltips
- [Banner Text](https://modrinth.com/datapack/banner-text), by [Snuzzle](https://modrinth.com/user/Snuzzle)
- [Muki's Extra Banners](https://modrinth.com/datapack/mukis-extra-banners),
  by [MukiTanuku](https://modrinth.com/user/MukiTanuki)
- [Many More Banners](https://modrinth.com/datapack/many-more-banners),
  by [moxvallix](https://modrinth.com/user/moxvallix)

# Incompatabilities

Refield isn't compatible with:

- ["Limitless" Banners](https://modrinth.com/mod/%22limitless%22-banners), by [Mike](https://modrinth.com/user/Mike)

# Credits

- [BannersEverywhere](https://modrinth.com/mod/banners-everywhere), by [anweisen](https://modrinth.com/user/anweisen)
- [TipOfTheLoom](https://modrinth.com/mod/tip-of-the-loom), by [Darkhax](https://modrinth.com/user/Darkhax)

## License

[![Code license (MIT)](https://img.shields.io/badge/code%20license-MIT-green.svg?style=flat-square)](https://github.com/evanbones/Refield/blob/1.21.1/LICENSE)

---

[![discord-plural](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/social/discord-plural_vector.svg)](https://discord.com/invite/JcGRdT6Pbx) [![github-plural](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/social/github-plural_vector.svg)](https://github.com/evanbones/Refield)
