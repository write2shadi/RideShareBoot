<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>RideShare App</title>
</head>
<body>

<h1>Welcome to RideShare Application!</h1>

<nav role="navigation">
<ul>
<li><a href="/">Home</a></li>
<li><a href="/login">Login</a></li>
<li><a href="/users">Users Management</a>
	<ul>
	<li><a href="/users/add">Add User</a></li>
	</ul>
</li>
<li><a href="/cars">Cars Management</a>
	<ul>
	<li><a href="/cars/add">Add Car</a></li>
	</ul>
</li>
</ul>
    <ul>
    <#if !currentUser??>
        <li><a href="/login">Log in</a></li>
    </#if>
    <#if currentUser??>
        <li>
            <form action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Log out</button>
            </form>
        </li>
        <li><a href="/user/${currentUser.id}">View myself</a></li>
    </#if>
    <#if currentUser?? && currentUser.role == "ADMIN">
        <li><a href="/user/create">Create a new user</a></li>
        <li><a href="/users">View all users</a></li>
    </#if>
    </ul>

</nav>
<hr />
<br />
