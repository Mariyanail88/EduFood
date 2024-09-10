<#import "../layout.ftlh" as layout>
<@layout.layout>
    <link rel="stylesheet" type="text/css" href="/static/css/restaurant.css">

    <div class="restaurant-page">

        <h2 class="restaurant-title">${restaurant.name}</h2>

        <div class="restaurant-content">
            <div class="restaurant-logo">
                <img src="/static/images/${restaurant.poster}" alt="${restaurant.name}">
            </div>

            <div class="menu-items">
                <h3 class="menu-title">Menu</h3>

                <#-- Calculate startIndex and endIndex -->
                <#assign startIndex = currentPage * size>
                <#if (startIndex + size) < restaurant.menuItems?size>
                    <#assign endIndex = startIndex + size>
                <#else>
                    <#assign endIndex = restaurant.menuItems?size>
                </#if>

                <#-- Loop through menu items -->
                <#list startIndex..(endIndex - 1) as i>
                    <div class="menu-item">
                        <h3>${restaurant.menuItems[i].name}</h3>
                        <p>${restaurant.menuItems[i].description}</p>
                        <p><strong>Price:</strong> ${restaurant.menuItems[i].price}</p>
                    </div>
                </#list>

                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <#if currentPage?? && (currentPage > 0)>
                            <li class="page-item">
                                <a class="page-link"
                                   href="/restaurant/${restaurant.id}?page=${currentPage - 1}&size=${size}">Previous</a>
                            </li>
                        </#if>

                        <#list 0..totalPages - 1 as page>
                            <li class="page-item <#if page == currentPage>active</#if>">
                                <a class="page-link"
                                   href="/restaurant/${restaurant.id}?page=${page}&size=${size}">${page + 1}</a>
                            </li>
                        </#list>

                        <#if currentPage?? && (currentPage < (totalPages - 1))>
                            <li class="page-item">
                                <a class="page-link"
                                   href="/restaurant/${restaurant.id}?page=${currentPage + 1}&size=${size}">Next</a>
                            </li>
                        </#if>
                    </ul>
                </nav>
            </div>
        </div>

        <div class="restaurant-info">
            <h2>Restaurant Information</h2>
            <p><strong>Address:</strong> ${restaurant.address}</p>
            <p><strong>Phone:</strong> ${restaurant.phoneNumber}</p>
            <p><strong>Email:</strong> ${restaurant.email}</p>
        </div>

    </div>

    <div class="home-button-container">
        <a href="/" class="home-button">Home</a>
    </div>

</@layout.layout>
