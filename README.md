# trituxws

I- Tools used

Ubuntu 14.04<br/>
Eclipse STS <br/>
maven 3.3.3<br/>
spring boot 1.2.7.RELEASE<br/>
mysql 5.5<br/>


II- Installation

Create a mysql database called tritux_ws, then execute the script "tritux_ws.sql" in the sql folder, this script will create tables with some data
#command
>$ mysql -u root<br/>
>$ create database tritux_ws<br/>
mysql>  exit<br/>
>$ cd sql<br/>
>$ mysql -u root tritux_ws < tritux_ws.sql<br/>

#command
Open Terminal:<br/>
>$ cd ~/Desktop<br/>
>$ mkdir TrituxWs<br/>
>$ cd TrituxWs<br/>
>$ git init<br/>
>$ git clone git@github.com:brahimmahjoub/trituxws.git<br/>
>$ cd trituxws<br/>
>$ mvn eclipse:eclispe<br/>
#run appllication<br/>
>$ mvn spring-boot:run<br/>


open browser and go to http://localhost:8080.
