#!/bin/bash
wget -P db/ http://download.nuohub.org/nuodb-ce-3.1.0.1.linux.x86_64.tar.gz 
cd db
tar zxvf nuodb-ce-3.1.0.1.linux.x86_64.tar.gz
mv nuodb-ce-3.1.0.1.linux.x86_64 nuodb
cd ..
cp db/default.properties db/nuodb/etc/default.properties
