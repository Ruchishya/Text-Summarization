#!/usr/bin/env python
import re, csv, sys

def removeURL(tweetText):
    return re.sub('((www\.[^\s]+)|(https?://[^\s]+))','',tweetText)
def removeUserMentions(tweetText):
    return re.sub('@[^\s]+','',tweetText)
def convertMultipleWhiteSpacesToSingleWhiteSpace(tweetText):
    return re.sub('[\s]+', ' ', tweetText)
def removeRT(tweetText):
    return re.sub("RT","",tweetText)
def removeextras(tweetText):
    return re.sub("\'s","",tweetText)
