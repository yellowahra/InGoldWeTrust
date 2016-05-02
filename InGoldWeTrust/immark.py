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
y = 406 #404 pixel = <25    
    
while (pic[x,403] > (25,25,25)):
    x = x + 1
        
while (pic[90,y] > (25,25,25)):
    y = y + 1

print x
print y

crop = image1.crop((91, 404, x, y))

crop.save("crop.png")