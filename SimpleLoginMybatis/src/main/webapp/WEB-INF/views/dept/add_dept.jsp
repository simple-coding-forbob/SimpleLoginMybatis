<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="부서 추가 페이지입니다.">
    <!-- 	tailwind cdn  -->
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    <!-- 	개발자 css -->
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/validation-error.css">

</head>
<body>

<jsp:include page="/common/header.jsp"/>
<div class="container mx-auto mt-8 px-3">
    <h1 class="text-2xl font-bold mb-6">부서 추가</h1>
    <form id="addForm" name="addForm" method="post">

        <div class="mb-4">
            <label for="dname" class="block mb-1">dname</label>
            <input type="text"
                   class="w-full border border-gray-300 rounded p-2 focus:outline-none focus:ring focus:ring-blue-500"
                   id="dname"
                   name="dname"
                   placeholder="부서명">
        </div>
        <div class="mb-4">
            <label for="loc" class="block mb-1">loc</label>
            <input type="text"
                   class="w-full border border-gray-300 rounded p-2 focus:outline-none focus:ring focus:ring-blue-500"
                   id="loc"
                   name="loc"
                   placeholder="부서위치">
        </div>
        <div class="mb-4">
            <button type="button"
                    class="w-full bg-blue-700 text-white p-2 rounded hover:bg-blue-800"
                    onclick="fn_save()"
            >저장
            </button>
        </div>
    </form>
</div>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 유효성체크 플러그인 -->
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.21.0/dist/jquery.validate.min.js"></script>
<script src="/js/dept/dept-validation-config.js"></script>

<script type="text/javascript" defer="defer">
    function fn_save() {
        /* 저장 함수: 저장 URL(/dept/add) */
        $("#addForm").attr("action","/dept/add")
            .submit();
    }
</script>
</body>
</html>
