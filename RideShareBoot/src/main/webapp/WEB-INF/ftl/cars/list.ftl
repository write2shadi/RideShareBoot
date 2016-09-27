<#-- @ftlvariable name="allCars" type="java.util.List<mum.ea.domain.Car>" -->

<#include "/_header.ftl">



   <h1>List of Cars</h1>		
	<br/>
	<table id="listOfCars" border="1">
	<tr>
	    <td>ID</td>
	    <td>Car Make</td>
	    <td>Car Model</td>
	    <td>Car Year</td>
	    <td>Car Color</td>
	    <td>Car Type</td>	   
	  </tr>
	  <#list allCars as car>	  	  
	  <tr>
	    <td>${car.id}</td>
	    <td>${car.carMake}</td>
	    <td>${car.carModel}</td>
	    <td>${car.carYear}</td>
	    <td>${car.carColor}</td>
	    <td>${car.carType}</td>	    
	  </tr>
	 </#list>
	</table>

<#include "/_footer.ftl">
