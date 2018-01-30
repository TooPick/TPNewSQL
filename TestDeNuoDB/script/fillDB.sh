#!/bin/bash
curl "localhost:8090/team?action=add&name=OL"
curl "localhost:8090/team?action=add&name=OM"
curl "localhost:8090/team?action=add&name=PSG"

curl "localhost:8090/player?action=add&FirstName=Zinedine&LastName=Zidane&id=1"
curl "localhost:8090/player?action=add&FirstName=Michel&LastName=Perrot&id=1"
curl "localhost:8090/player?action=add&FirstName=Jean&LastName=Lacoste&id=1"
curl "localhost:8090/player?action=add&FirstName=Pierre&LastName=Curry&id=1"

curl "localhost:8090/player?action=add&FirstName=Alexandre&LastName=Sanigou&id=2"
curl "localhost:8090/player?action=add&FirstName=Yenni&LastName=Chermack&id=2"
curl "localhost:8090/player?action=add&FirstName=Lucas&LastName=Guerrot&id=2"
curl "localhost:8090/player?action=add&FirstName=Marie&LastName=Curry&id=2"

curl "localhost:8090/player?action=add&FirstName=Jean&LastName=ValJean&id=3"
curl "localhost:8090/player?action=add&FirstName=Jimi&LastName=Hendrix&id=3"
curl "localhost:8090/player?action=add&FirstName=Bob&LastName=Marley&id=3"
curl "localhost:8090/player?action=add&FirstName=Emmanuel&LastName=Macron&id=3"
