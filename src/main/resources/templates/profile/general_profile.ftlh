<#import "../layout.ftlh" as layout>

<@layout.layout>
    <h1>Profile</h1>
    <div>
        <img src="${user.avatarUrl}" alt="Avatar" class="rounded-circle" width="100" height="100">
    </div>
    <div>
        <p>Name: ${user.name}</p>
        <p>Email: ${user.email}</p>
        <p>Phone Number: ${user.phoneNumber}</p>
    </div>
    <div>
        <a href="/profile/edit" class="btn btn-outline-info">Edit Profile</a>
    </div>
    <div>
        <a href="/profile/change-password" class="btn btn-outline-info">Change Password</a>
    </div>
</@layout.layout>