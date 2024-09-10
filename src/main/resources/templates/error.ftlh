<#import "layout.ftlh" as layout>

<@layout.layout>
    <link rel="stylesheet" type="text/css" href="/static/css/error.css">

    <div class="error-page">
        <div class="error-container">
            <img src="/static/images/error-icon.svg" alt="Error Icon" class="error-svg">
            <h1>Error</h1>
            <div>
                <p><span class="status-code">Status Code:</span> <span class="status-code-value">${statusCode!500}</span></p>
                <p><span class="error-message">Error Message:</span> <span class="error-message-value">${errorMessage!"An unexpected error occurred"}</span></p>
                <#if reasons??>
                    <#list reasons?keys as key>
                        <p>${key}: ${reasons[key]?join(", ")}</p>
                    </#list>
                </#if>
            </div>
            <div>
                <a href="/" class="btn">Home</a>
            </div>
        </div>
    </div>

    <script src="/static/js/error.js"></script>
</@layout.layout>