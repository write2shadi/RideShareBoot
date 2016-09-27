<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="mum.ea.domain.RideInfo" -->
<#import "/spring.ftl" as spring>

<#include "/_header.ftl">


<h2>Add New Ride</h2>
	<br/>
		<form role="form" name="form" action="" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<table>
			<tr>
				<td>Pick Up Street</td>
				<td> <input type="text" name="pickUpStreet" id="pickUpStreet" value="${form.pickUpStreet}" required autofocus /></td>				
			</tr>
			<tr>
				<td>Pick Up City</td>
				<td> <input type="text" name="pickUpCity" id="pickUpCity" value="${form.pickUpCity}" required  /></td>				
			</tr>

			<tr>
				<td>Pick Up State</td>
				<td> <input type="text" name="pickUpState" id="pickUpState" value="${form.pickUpState}" required /></td>				
			</tr>

			<tr>
				<td>Pick Up Zip</td>
				<td> <input type="text" name="pickUpZip" id="pickUpZip" value="${form.pickUpZip}"/></td>				
			</tr>

			<tr>
				<td>Drop Off Street</td>
				<td> <input type="text" name="dropOffStreet" id="dropOffStreet" value="${form.dropOffStreet}" required  /></td>				
			</tr>
			
			<tr>
				<td>Drop Off City</td>
				<td> <input type="text" name="dropOffCity" id="dropOffCity" value="${form.dropOffCity}" required  /></td>				
			</tr>
			<tr>
				<td>Drop Off State</td>
				<td> <input type="text" name="dropOffState" id="dropOffState" value="${form.dropOffState}" required  /></td>				
			</tr>
			<tr>
				<td>Drop Off Zip</td>
				<td> <input type="text" name="dropOffZip" id="dropOffZip" value="${form.dropOffZip}" /></td>				
			</tr>
			<tr>
				<td>Pick Up Date</td>
				<td> <input type="date" name="pickUpDate" id="pickUpDate" value="${form.pickUpDate?date}" /></td>				
			</tr>
			
			<tr>
				<td>Pick Up Time</td>
				<td> <input type="time" name="pickUpTime" id="pickUpTime" value="${form.pickUpTime?time}" /></td>				
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Add Ride"/></td>
			</tr>
		</table>
	</form>
	
<@spring.bind "form" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>
	
<#include "/_footer.ftl">
