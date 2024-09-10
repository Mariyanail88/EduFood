<#import "layout.ftlh" as layout>
<@layout.layout>
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <div class="main-content">
        <div class="welcome-container">
            <div class="welcome-header">
                <h1>ORDER FOOD FROM DIFFERENT RESTAURANTS</h1>
            </div>
            <div class="welcome-image">
                <img src="/static/images/edu_food_logo.png" alt="No Image Available">
            </div>
            <div class="welcome-links">
                <#--                <a href="/vacancies" class="btn btn-primary">View Vacancies</a>-->
                <#--                <a href="/resumes" class="btn btn-primary">View Resumes</a>-->
                <#--                <a href="/vacancies/vacancies-with-responses" class="btn btn-primary">View Vacancies with responses</a>-->
            </div>
        </div>
        <div class="restaurants-container">
            <#list restaurants.content as restaurant>
                <div class="restaurant-card">
                    <a href="/restaurant/${restaurant.id}">
                        <img src="/static/images/${restaurant.poster}" alt="${restaurant.name}">
                    </a>
                    <div class="restaurant-info">
                        <h2>${restaurant.name}</h2>
                        <p>${restaurant.address}</p>
<#--                        <p>${restaurant.phoneNumber}</p>-->
<#--                        <p>${restaurant.email}</p>-->
                    </div>
                </div>
            </#list>
        </div>

        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <#if currentPage?is_number && (currentPage > 0)>
                    <li class="page-item">
                        <a class="page-link" href="/?page=${currentPage - 1}&size=5">Previous</a>
                    </li>
                </#if>
                <#if totalPages?is_number>
                    <#list 0..totalPages - 1 as page>
                        <li class="page-item <#if page == currentPage>active</#if>">
                            <a class="page-link" href="/?page=${page}&size=5">${page + 1}</a>
                        </li>
                    </#list>
                </#if>
                <#if currentPage?is_number && (currentPage < (totalPages - 1))>
                    <li class="page-item">
                        <a class="page-link" href="/?page=${currentPage + 1}&size=5">Next</a>
                    </li>
                </#if>
            </ul>
        </nav>

    </div>
</@layout.layout>