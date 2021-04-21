from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import urllib.request
import os

a = "shiba inu"
b = 10000
driver = webdriver.Chrome("c:chromedriver.exe")
driver.get('http://www.google.co.kr/imghp?hl=ko')
elem = driver.find_element_by_name("q")
elem.send_keys(a)
elem.send_keys(Keys.RETURN)
images = driver.find_elements_by_css_selector(".rg_i.Q4LuWd")
count = 0
for image in images:
    print(image)
    try:
        image.click()
        time.sleep(1)
        imgUrl = driver.find_element_by_xpath(
            "/html/body/div[2]/c-wiz/div[3]/div[2]/div[3]/div/div/div[3]/div[2]/c-wiz/div/div[1]/div[1]/div/div[2]/a/img").get_attribute(
            "src")
        urllib.request.urlretrieve(imgUrl, "D:\Pycham\Crawling\shibaPicture\shiba" + str(count) + ".jpg")
        count += 1
        if count == b:
            break
    except Exception:
        print(Exception)

driver.close()
