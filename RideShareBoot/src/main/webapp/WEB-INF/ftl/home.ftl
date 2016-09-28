<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="mum.ea.domain.CurrentUser" -->

<#include "/_header.ftl">



<h1 class="page-header">List of Rides</h1>

<div class="table-responsive">
    <table class="table table-bordered table-hover table-striped">
	<thead>
	<tr>	    
	    <th>Driver</th>
	    <th>Source</th>
	    <th>Destination</th>
	    <th>Book</th>
	  </tr>
	  </thead>
	  <tbody>
	  <#list allRideInfos as rideinfo>	  	  
      <tr>
	    <td>
	    <b>${rideinfo.ride.user.firstName}</b><br />
	    ID# ${rideinfo.ride.rideId} <br />
	    Pickup Date: ${rideinfo.ride.pickUpDate} <br />
	    Time: ${rideinfo.ride.pickUpTime}
	    </td>
	    <td>${rideinfo.ride.pickUpStreet}<br />
	    ${rideinfo.ride.pickUpCity}, ${rideinfo.ride.pickUpZip}<br />
	    ${rideinfo.ride.pickUpState}
	    </td>	    
	    <td>${rideinfo.ride.dropOffStreet}<br />
	    ${rideinfo.ride.dropOffCity}, ${rideinfo.ride.dropOffZip}<br />
	    ${rideinfo.ride.dropOffState}
	    </td>
		<td>
		<#if !rideinfo.booked>
			<a class="button" href="/bookings/book/${rideinfo.ride.rideId}">Book Now </a>
		</#if>
		<#if rideinfo.booked>
			<b>Already Booked!</b>
		</#if>
		</td>
	  </tr>
	 </#list>
	 </tbody>
	</table>


<#include "/_footer.ftl">
