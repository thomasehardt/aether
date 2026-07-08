# Aether

**v0.1.0**

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

## Usage

Just open `aether-soundscape.html` directly in a browser, or serve the directory with any static file server:

```
python3 -m http.server
```

Then visit the served URL and click the orb to start.

## Development

See `CLAUDE.md` for architecture notes on the audio engine and UI structure.
