# -*- coding: utf-8 -*-
"""
Created on Mon Apr 25 17:09:24 2016

@author: Raquel
"""

from PIL import Image

image1 = Image.open("info.png")

pic = image1.load()
size = image1.size

x = 93 #91 pixel = <25  
    
r = 300
    
while (pic[91,r] > (18,18,18)):
    r = r + 1    

y = r

print x
print y
    
while (pic[x,y] > (18,18,18)):
    x = x + 1
        
while (pic[90,y+5] > (18,18,18)):
    y = y + 1

print x
print y

crop = image1.crop((91, r+1, x, y+5))

crop.save("crop.png")