<#-- @ftlvariable name="allRideInfos" type="java.util.List<mum.ea.domain.RideInfo>" -->

<#include "/_header.ftl">



<h1 class="page-header">My Rides</h1>

<div class="table-responsive">
    <table class="table table-bordered table-hover table-striped">
	<thead>
	<tr>	    
	    <th>Id</th>
	    <th>Source</th>
	    <th>Destination</th>	 
	    <th>Booked By</th>  
	  </tr>
	  </thead>
	  <tbody>
	  <#list allRideInfos as rideinfo>	  	  
      <tr>
	    <td>	 
	    <b>ID# ${rideinfo.rideId}</b> <br />
	    Pickup Date: ${rideinfo.pickUpDate} <br />
	    Time: ${rideinfo.pickUpTime}
	    </td>
	    <td>${rideinfo.pickUpStreet}<br />
	    ${rideinfo.pickUpCity}, ${rideinfo.pickUpZip}<br />
	    ${rideinfo.pickUpState}
	    </td>	    
	    <td>${rideinfo.dropOffStreet}<br />
	    ${rideinfo.dropOffCity}, ${rideinfo.dropOffZip}<br />
	    ${rideinfo.dropOffState}
	    </td>
	    <td>
	    <ul>
	     <#list rideinfo.bookings as booking>
	     	<li>${booking.user.firstName} (${booking.user.phone})</li>
	     </#list>
	     </ul>	  
	    </td>
	  </tr>
	 </#list>
	 </tbody>
	</table>


<#include "/_footer.ftl">
