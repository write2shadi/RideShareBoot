<#-- @ftlvariable name="allCars" type="java.util.List<mum.ea.domain.Car>" -->

<#include "/_header.ftl">



   <h1 class="page-header">List of Cars</h1>		
	<br/>
	<div class="table-responsive">
    <table class="table table-bordered table-hover table-striped">
	<thead>
	<tr>
	    <th>ID</th>
	    <th>Car Make</th>
	    <th>Car Model</th>
	    <th>Car Year</th>
	    <th>Car Color</th>
	    <th>Car Type</th>	   
	  </tr>
	  </thead>
	  <tbody>
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
	 </tbody>
	</table>
   </div>
   
<#include "/_footer.ftl">
