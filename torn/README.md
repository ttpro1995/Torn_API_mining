

# Quick start 


Build everything
```
mvn clean compile assembly:single
```

Put user id in watchlist/user.txt with one id per line <br>

https://www.torn.com/profiles.php?XID=xxxxxxx#/ <br>
where xxxxxxx is user id


Run in terminal 

``` 
## set torn api to environment 
## program will not run if you does not set torn api correctly
export TORN_API=your_tone_api_goes_here

## run the program
java -Dlog4j.configurationFile=conf/log4j.configurationFile  -jar target/torn-0.1-jar-with-dependencies.jar
```

And wait. Check logs/Torn.log for result

===========  <br>

Example of output log (with real data)
https://gist.github.com/ttpro1995/3cc8b8f2b528dc8b0ce53dd00d72c8f9

user data json

```
{
  "rank": "Reasonable Hitman",
  "level": 14,
  "gender": "Male",
  "property": "Mansion",
  "signup": "2018-03-06 03:53:26",
  "awards": 36,
  "friends": 2,
  "enemies": 1,
  "forum_posts": 2,
  "karma": 0,
  "age": 44,
  "role": "Civilian",
  "donator": 1,
  "player_id": 2106002,
  "name": "Stone_Head",
  "property_id": 1595497,
  "last_action": "3 hours ago",
  "life": {
    "current": 603,
    "maximum": 603,
    "increment": 30,
    "interval": 300,
    "ticktime": 272,
    "fulltime": 0
  },
  "status": [
    "Okay",
    ""
  ],
  "job": {
    "position": "Employee",
    "company_id": 44557,
    "company_name": "Strength gym, hiring"
  },
  "faction": {
    "position": "Member",
    "faction_id": 27902,
    "days_in_faction": 12,
    "faction_name": "Yakuza - Infinity"
  },
  "married": {
    "spouse_id": 0,
    "spouse_name": "None",
    "duration": 0
  },
  "icons": {
    "icon6": "Male",
    "icon3": "Donator",
    "icon4": "Subscriber",
    "icon27": "Company - Employee of Strength gym, hiring (Furniture Store)",
    "icon9": "Faction - Member of Yakuza - Infinity"
  }
}

```
