# lessonsdownloader

The problem : I wanted to download a lot of video from a lot of tutorials website but if I had to do it manually,
I should have to go to one page, click on the download link, go to the other page, click on the download link,...

The site was built like that :

One tutorial has between 10 and 100 pages. On the tutorial page, there is a link to each page. This page has one video

Fortunatelly each video had a link to download it with a tag "download".

I want to try Selenium so I used it.

First you need to be logged on the website to get access to the tutorials, so my software log in the site using Selenium
My software scan the tutorial page and get each pages who contains one video.
Then the software go through each page it get and search for the download tag.
It copy the download link to a text file, in case I would use them with a download manager because the site is very slow.
Then it download each video to my computer.

And That's it
