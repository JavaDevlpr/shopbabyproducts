

Project Title

# shopbabyproducts
Shopping for Baby Products by comparing prices at different stores.
This program that accepts a price file of baby products(format below) as CSV file, and a list of products that someone wants to buy, and outputs the shop they should go to, and the total price it will cost them. It is okay to purchase extra products, as long as the total cost is minimized.

Getting Started

This project require Eclipse, Tomcat8 and JDK7 installed on your machine to run.

Prerequisites

A csv file reuire which has data for shops, products they are selling and price. The project is created using JSP/Servlet so nothing else required.

Data File data.csv

1, 4.00, teddy_bear
1, 8.00, baby_powder
2, 5.00, teddy_bear
2, 6.50, baby_powder
3, 4.00, pampers_diapers
3, 8.00, johnson_wipes
4, 5.00, johnson_wipes
4, 2.50, cotton_buds
5, 4.00, bath_towel
5, 8.00, scissor
6, 5.00, scissor
6, 6.00, bath_towel, cotton_balls, powder_puff

Below are the inouts and it's result:

Example 1:

Enter below text on GUI and click button Search
teddy_bear,baby_powder

Output
2, 11.5


Example 2:

Enter below text on GUI and click button Search
pampers_diapers,baby_soap

Output
none


Example 3:
Enter below text on GUI and click button Search
scissor,bath_towel

Output
6, 11.0

Deployment
Import project in your Eclipse IDE, run with server. When everything works fine, make it's war file and deploy on Tomcat server.
