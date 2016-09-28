<#-- @ftlvariable name="allRideInfos" type="java.util.List<mum.ea.domain.RideInfo>" -->

<#include "/_header.ftl">



<h1 class="page-header">List of Rides</h1>

<div class="table-responsive">
    <table class="table table-bordered table-hover table-striped">
	<thead>
	<tr>
	    <th>ID</th>
	    <th>FirstName</th>
	    <th>pickUpStreet</th>
	    <th>pickUpCity</th>
	    <th>pickUpState</th>
	    <th>pickUpZip</th>
	    <th>dropOffStreet</th>
	    <th>dropOffCity</th>
	    <th>dropOffState</th>
	    <th>dropOffZip</th>
        <th>pickUpDate</th>
        <th>pickUpTime</th>
	  </tr>
	  </thead>
	  <tbody>
	  <#list allRideInfos as rideinfo>	  	  
      <tr>
	    <td>${rideinfo.rideId}</td>
	    <td>${rideinfo.user.firstName}</td>
	    <td>${rideinfo.pickUpStreet}</td>
	    <td>${rideinfo.pickUpCity}</td>
	    <td>${rideinfo.pickUpState}</td>
	    <td>${rideinfo.pickUpZip}</td>
	    <td>${rideinfo.dropOffStreet}</td>
	    <td>${rideinfo.dropOffCity}</td>
	    <td>${rideinfo.dropOffState}</td>
	    <td>${rideinfo.dropOffZip}</td>
        <td>${rideinfo.pickUpDate}</td>
        <td>${rideinfo.pickUpTime}</td>
	  </tr>
	 </#list>
	 </tbody>
	</table>

<#include "/_footer.ftl">
