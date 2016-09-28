<#-- @ftlvariable name="user" type="mum.ea.example.domain.User" -->

<#include "/_header.ftl">

<h1>User details</h1>

<p>E-mail: ${user.email}</p>

<p>Role: ${user.role}</p>

<p>First Name:  ${user.firstName}</p>
<p>Last Name:  ${user.lastName}</p>
<#if user.addressLine1??>
	<p>Address Line1:  ${user.addressLine1}</p>
	<p>Address Line2:  ${user.addressLine2}</p>
	<p>City:  ${user.city}</p>
	<p>State:  ${user.state}</p>
	<p>Zip:  ${user.zipCode}</p>
</#if>


<#include "/_footer.ftl">
