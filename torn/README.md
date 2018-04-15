

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
java -Dlog4j.configurationFile=conf/log4j.configurationFile  -jar target/torn-0.1-jar-with-dependencies.jar
```

And wait. Check logs/Torn.log for result

===========  <br>


