<#-- @ftlvariable name="users" type="java.util.List<mum.ea.domain.User>" -->

<#include "/_header.ftl">


<h1 class="page-header">List of Users</h1>

<div class="table-responsive">
    <table class="table table-bordered table-hover table-striped">
	<thead>
	<tr>
    <thead>
    <tr>
    	<th>First Name</th>
    	<th>Last Name</th>
    	<th>City</th>
        <th>E-mail</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td><a href="/user/${user.id}">${user.firstName}</a></td>
        <td>${user.lastName}</td>
        <td>${user.city}</td>
        <td>${user.email}</td>
        <td>${user.role}</td>        
    </tr>
    </#list>
    </tbody>
</table>

<#include "/_footer.ftl">
