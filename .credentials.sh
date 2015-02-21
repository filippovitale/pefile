#!/bin/bash -e

mkdir -p ~/.bintray

cat > ~/.bintray/.credentials <<EOF
realm = Bintray API Realm
host = api.bintray.com
user = $BINTRAY_USER
password = $BINTRAY_API_KEY
EOF
