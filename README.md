This application was developed in order to study web development technologies, and  it does not have any practical value. 

Used technologies: 
MySQL, JAVA, JSP, Hibernate, SpringMVC, Spring Security, JavaScript, AJAX, CSS, HTML. 


To run the application: 
1) import the file (Dump.sql) to the database; 
2) in the fileservlet-context.xml set up your login and password for the database; 
3) The application contains jetty plugin. In order to run it please type mvn jetty:run;

The application will be available at http://localhost:8080/CDStore 

Application description: 
This application models the operation of CD selling site
The shop works without reloading the page and all pages are loaded via ajax. 

 Pages: 

MAIN: Contains the description of the store and uploads 5 most recent additions to the genre (only action, horror, drama  and comedy. Others are not implemented); 
CATALOG: Implements  the incremental search in the database by type, genre, title (like Google).JS paginator is also implemented. Selected items are stored in the session ShopingCart. 
CART: Implements the shopping cart, where we can change the number of selected items, and also see the final sum. 


Admin console is peresent. It was implemented using Spring Security. It is not finished.

There is also a function of language change.

----------------Русский---------------------------------------------------------

Данное приложение разрабатывалась для изучения технологий web разработки, и никакой практической ценности не несет.

Используемые технологии:
MySQL,JAVA, JSP, Hibernate, SpringMVC, Spring Security, JavaScript, AJAX, CSS, HTML.


Для запуска приложения:
   1)импортировать(файл Dump.sql) в базу данных;
   2)в файле servlet-context.xml установить свой логин, пароль для базы данных;
   3)В приложении присутствует jetty plugin.Для запуска в комндной строке набрать mvn jetty:run;
    Приложение будет доступно по адресу http://localhost:8080/CDStore
 
Описание приложения:
 Данное приложение моделирует работу сайта по продаже cd дисков.
 Работа магазина происходит без перезагрузки страницы, а все страницы подгружаются с помощью ajax.
 
 Страницы:
 
 MAIN: Описание магазина и подгрузка из базы данных 5 последних добавлений в жанры(только action,melodrama,scare,drama,comedy другие не реализованы);
 CATALOG: Реализован инкрементный поиск из базы данных по типу, жанру, названию(like Google). Также реализован js paginator. Выбранные позиции сохраняются в
  объекте сессии ShopingCart.
 CART: Реализована корзина покупателя, где мы можем изменять количество выбранных позиций, а также видеть конечную сумму.


Присутствует admin console. Реализована с помощью Spring Security. Не закончена.

Также присутствует функция смена языка.
