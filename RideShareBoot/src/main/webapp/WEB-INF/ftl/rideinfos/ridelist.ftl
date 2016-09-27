<#-- @ftlvariable name="allRideInfos" type="java.util.List<mum.ea.domain.RideInfo>" -->

<#include "/_header.ftl">



   <h1>List of RideInfos</h1>		
	<br/>
	<table id="listOfRideInfos" border="1">
	<tr>
	    <td>ID</td>
	    <td>pickUpStreet</td>
	    <td>pickUpCity</td>
	    <td>pickUpState</td>
	    <td>pickUpZip</td>
	    <td>dropOffStreet</td>
	    <td>dropOffCity</td>
	    <td>dropOffState</td>
	    <td>dropOffZip</td>
        <td>pickUpDate</td>
	  </tr>
	  <#list allRideInfos as rideinfo>	  	  
      <tr>
	    <td>${rideinfo.rideId}</td>
	    <td>${rideinfo.pickUpStreet}</td>
	    <td>${rideinfo.pickUpCity}</td>
	    <td>${rideinfo.pickUpState}</td>
	    <td>${rideinfo.pickUpZip}</td>
	    <td>${rideinfo.dropOffStreet}</td>
	    <td>${rideinfo.dropOffCity}</td>
	    <td>${rideinfo.dropOffState}</td>
	    <td>${rideinfo.dropOffZip}</td>
        <td>${rideinfo.pickUpDate}</td>
	  </tr>
	 </#list>
	</table>

<#include "/_footer.ftl">
