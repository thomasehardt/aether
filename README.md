# Aether

**v0.1.0**

> **AI-generated software.** The overwhelming majority of this project's code, audio design, and documentation was written by Claude (Anthropic), directed and reviewed by a human. See git history for the full record — commits are marked with Claude's co-authorship.

A generative ambient soundscape player that runs entirely in the browser. Every sound — drones, a choir pad, sub bass, rain, ocean waves, wind, generative bell tones, a melodic arpeggiator, and high shimmer overtones — is synthesized live with the Web Audio API. No audio samples, no loops.

Open `aether-soundscape.html` in a browser to use it.

## Features

- Nine layered ambient sounds (Drone, Pad, Sub, Rain, Waves, Wind, Bells, Arp, Shimmer), each with an independent mixer level
- Five root keys (C, D, E, G, A) that retune the drone, pad, sub and shimmer layers, with Bells and Arp generated over a minor pentatonic scale
- Bells, Arp and the Pad chord orbit a shared, slowly-drifting tonal center so the melodic/harmonic layers feel like one voice rather than independent generators
- Five presets (Rainfall, Deep Ocean, Nebula, Rainforest, Sanctuary) that snapshot a key + layer mix
- Adjustable master volume and reverb ("Space") send
- "Reseed" button to vary the generative bell and arpeggiator patterns
- Reactive canvas visualizer driven by a live audio analyser
- No dependencies, no build step — a single self-contained HTML file
- Installable PWA (manifest + service worker) — works offline after the first load, gets a proper home-screen icon

## Usage

Just open `aether-soundscape.html` directly in a browser, or serve the directory with any static file server:

```
python3 -m http.server
```

Then visit the served URL and click the orb to start. On mobile, use the browser's "Add to Home screen" / "Install app" option to install it as a standalone app (requires serving over HTTP(S), not `file://` — service workers need a secure context).

## Android

There's also a native Android build (via [Capacitor](https://capacitorjs.com/), `mobile/`) — fully offline, no network permission, all fonts self-hosted. It's not on the Play Store. Two ways to get it:

- **Sideload the APK directly** — build it yourself (`cd mobile/android && ./gradlew assembleRelease`) or grab one from [Releases](https://github.com/thomasehardt/aether/releases), then install it manually (you'll need to allow installs from the source you download it from).
- **Add the self-hosted F-Droid repo** — in the F-Droid app, add this repo: `https://thomasehardt.github.io/aether/fdroid-repo/repo`. You'll get real F-Droid-style installs and update notifications without it being in the official F-Droid catalog.

## Development

See `CLAUDE.md` for architecture notes on the audio engine and UI structure.
