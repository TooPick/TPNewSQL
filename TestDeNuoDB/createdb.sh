#!/bin/bash
sudo ./db/nuodb/etc/nuoagent start
sudo ./db/nuodb/etc/nuorestsvc start
sudo ./db/nuodb/bin/nuodbmgr --broker localhost --password pass --file script/createDB.script 
