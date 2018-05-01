TORN city mining

The project is about https://www.torn.com <br>
It use torn api https://api.torn.com/ <br>


# Purpose 

You know, Torn have public api that allow use to access a lot of information easily. <br>
These info are public which you can access using browser while playing game (so, using API is no cheating, i think). For example, user profile page, bazaar list, ... 

Now, if I am continuously checking someone info, I can know something. For example, this guy usually online at 8 AM, 12 AM, and 4 PM (by looking at profile page, the Last Action). 


# Current state of project


### Find online time of user

If we keep refreshing profile page of a user, we can know their online habit.

- [X] (logger) Gather profile page (user api)
- [ ] (parser) Get last_action from user log ___DOING___
- [ ] (mining) Find online time of user
 