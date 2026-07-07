# Aether

A generative ambient soundscape player that runs entirely in the browser. Every sound — drones, sub bass, rain, ocean waves, wind, and generative bell tones — is synthesized live with the Web Audio API. No audio samples, no loops.

Open `aether-soundscape.html` in a browser to use it.

## Features

- Six layered ambient sounds (Drone, Sub, Rain, Waves, Wind, Bells), each with an independent mixer level
- Five root keys (C, D, E, G, A) that retune the drone and sub layers, with bells generated over a minor pentatonic scale
- Five presets (Rainfall, Deep Ocean, Nebula, Rainforest, Sanctuary) that snapshot a key + layer mix
- Adjustable master volume and reverb ("Space") send
- "Reseed" button to vary the generative bell pattern
- Reactive canvas visualizer driven by a live audio analyser
- No dependencies, no build step — a single self-contained HTML file

## Usage

Just open `aether-soundscape.html` directly in a browser, or serve the directory with any static file server:

```
python3 -m http.server
```

Then visit the served URL and click the orb to start.

## Development

See `CLAUDE.md` for architecture notes on the audio engine and UI structure.
