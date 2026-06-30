<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="kr">
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="fileDb 추가 페이지입니다.">
    <!-- 	tailwind cdn  -->
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    <!-- 	개발자 css -->
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/validation-error.css">


</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div class="container mx-auto mt-8 px-3">
    <!-- 업로드 시 추가(첨부파일이라는 요청): enctype="multipart/form-data" -->
    <!-- 스프링 업로드 파일 제한(기본): 1M -> 10M -->
    <h1 class="text-2xl font-bold mb-6">fileDb 추가</h1>
    <form id="addForm"
          name="addForm"
          method="post"
          enctype="multipart/form-data"
    >
        <div class="mb-4">
            <label for="fileTitle" class="block mb-1">fileTitle</label>
            <input
                    class="w-full border border-gray-300 rounded p-2 focus:outline-none focus:ring focus:ring-blue-500"
                    id="fileTitle"
                    name="fileTitle"
                    placeholder="제목" />
        </div>
        <div class="mb-4">
            <label for="fileContent" class="block mb-1">fileContent</label>
            <input type="text"
                   class="w-full border border-gray-300 rounded p-2 focus:outline-none focus:ring focus:ring-blue-500"
                   id="fileContent"
                   name="fileContent"
                   placeholder="내용" />
        </div>
        <div class="mb-4 flex">
            <!-- type="file": 파일대화상자가 화면에 보입니다. -->
            <input type="file"
                   class="w-full border border-gray-300 rounded-l p-2 focus:outline-none focus:ring focus:ring-blue-500"
                   id="fileData"
                   name="fileData"
            >
            <button class="bg-blue-700 text-white hover:bg-blue-800 px-4 py-2 rounded-r min-w-[5rem]"
                    type="button"
                    onclick="fn_save()"
            >저장</button>
        </div>
    </form>
</div>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 유효성체크 플러그인 -->
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.21.0/dist/jquery.validate.min.js"></script>
<script src="/js/fileDb/fileDb-validation-config.js"></script>

<script type="text/javascript">
    function fn_save() {
        /* 저장 함수: 저장 URL(/emp/add) */
        $("#addForm").attr("action","/fileDb/add")
            .submit();
    }
</script>

</body>
</html>
