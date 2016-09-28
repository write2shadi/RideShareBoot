<#-- @ftlvariable name="allBookings" type="java.util.List<mum.ea.domain.Booking>" -->

<#include "/_header.ftl">

   <h1>List of Booking</h1>	
   <br/>
	<table id="listOfBookings" border="1">
	<tr>
	    <td>ID</td>
	    <td>User ID</td>
	    <td>Ride Info ID</td>
	    <td>Number of Seats</td>   
	  </tr>
	  <#list allBookings as booking>	  	  
	  <tr>
	    <td>${booking.id}</td>
	    <td>${booking.user.id}</td>
	    <td>${booking.ride.id}</td>
	    <td>${booking.numberOfSeats}</td> 
	      
	  </tr>
	 </#list>
	</table>	
	

<#include "/_footer.ftl">
