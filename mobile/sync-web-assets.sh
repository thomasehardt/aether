#!/usr/bin/env bash
# Regenerates mobile/www/ from the root web app. www/ is gitignored since
# it's just a derived copy — run this before `npx cap sync android` whenever
# the root aether-soundscape.html / manifest.json / service-worker.js / fonts
# / icons change.
set -euo pipefail
cd "$(dirname "$0")"

mkdir -p www
cp ../aether-soundscape.html www/index.html
cp ../guide.html www/guide.html
cp ../service-worker.js www/service-worker.js
cp -r ../fonts www/
cp -r ../icons www/

# the root files reference the standalone filename/manifest; the mobile
# build uses index.html as the entry point, so patch those two references
sed -i 's#\./aether-soundscape\.html#./index.html#' www/service-worker.js
sed 's#"start_url": "\./aether-soundscape\.html"#"start_url": "./index.html"#' ../manifest.json > www/manifest.json

echo "synced mobile/www/ from root sources"
