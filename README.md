#Instructions

1. (recommended) Add java docstrings to each method. ASK if it seems unclear.
2. (required) Implement the methods that are incomplete (have TODO comments)
3. (assumed) Test your code before submitting it (always do that!)    

#Submission
1.  Create a personal account on bitbucket *with your @ asu.edu email*
2.  Fork this repo (click the 'Fork' button at the top, it _may_ look like a '...' button).  Make it PRIVATE.
3.  Invite @ser222-grader and @jfemiani to your PRIVATE repo. Give us ADMIN access (so we can add other graders)
4.  Make sure you have a GIT client
5.  Clone your repo `git clone https://<username>@bitbucket.org/<username>/exercises-chaining.git`
6.  Type `git remote add main https://bitbucket.org/ser222/exercises-chaining.git`
7.  Type `git pull main`
8.  Change some files
9.  Type `git add <filename>`
10. Type `git commit -m "<a message>"`
11. Type `git push origin`
12.  Go to 7

#Help
Use the IRC channel [irc://irc.freenode.net/ser222](irc://irc.freenode.net/ser222) to ask questions to your peers and myself.
You can use [irccloud](https://www.irccloud.com/) to keep persistent logs of the discussion (It should continue to keep track of the converstation on your behalf for about 2 hours after you lose connection, 
and you can recconect from multiple devices without losing track of the ocnversation). 
You can also use the web based client [http://webchat.freenode.net/][(http://webchat.freenode.net/) or
your favorite tool. You may need to modify the port (6666 vs 6665 perhaps) in order to avoid it getting blocked by ASU.


#Testing

Use this to test your code.

## Linux/ osx
```
$  java Chaining < test.in >test.out
$  diff test.out test.expected
```

## Windows 
```
> java Chaining < test.in > test.out
> FC test.out test.expected
```


#Grading

We will set checkpoints; you will lose points each time a checkpoint passes and your code is not satisfactory. 
The penalties are:

 -9%:  Your code does not appear to have been modified since the last checkpoint

 -5%:  You fail to produce the expected output for any test case

 -5%.  We find an major issue in your sourcecode 

After the last checkpoint, if your code does not pass, you will receive a zero.  
I will not tell you which checkpoint is last; there may be only one checkpoint (the due date). 


In general misunderstanding the assignment is not an excuse; misunderstanding the test harness is not an excuse.  
You are expected to understand the concepts well enough to spot inconsistancies and **ask** about them before
submitting. 

***
I cannot allow students who cannot produce code to move forward. 
It is a disservice to you and to the the computing program.
You will receive a 0 on your exams if you have not submitted the previous programming assignments
*** 