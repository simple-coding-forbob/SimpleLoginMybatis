<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="부서 수정 페이지입니다.">
    <!-- 	tailwind cdn  -->
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    <!-- 	개발자가 만든 css -->
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/validation-error.css">

</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div class="container mx-auto mt-8 px-3">
    <h1 class="text-2xl font-bold mb-6">부서 상세조회</h1>
    <form id="addForm" name="addForm" method="post">

        <input type="hidden" id="dno" name="dno" value="<c:out value="${deptVO.dno}"/>" />
        <div class="mb-4">
            <label for="dname" class="block mb-1">dname</label>
            <input type="text"
                   class="w-full border border-gray-300 rounded p-2 focus:outline-none focus:ring focus:ring-blue-500"
                   id="dname"
                   name="dname"
                   value="<c:out value="${deptVO.dname}"/>"
                   placeholder="부서명">
        </div>
        <div class="mb-4">
            <label for="loc" class="block mb-1">loc</label>
            <input type="text"
                   class="w-full border border-gray-300 rounded p-2 focus:outline-none focus:ring focus:ring-blue-500"
                   id="loc"
                   name="loc"
                   value="<c:out value="${deptVO.loc}"/>"
                   placeholder="부서위치">
        </div>
        <div class="mb-4 flex gap-2">
            <button type="button"
                    class="flex-1 bg-green-700 text-white p-2 rounded hover:bg-green-800"
                    onclick="fn_save()"
            >
                수정
            </button>
            <button type="button"
                    class="flex-1 bg-red-600 text-white p-2 rounded hover:bg-red-700"
                    onclick="fn_delete()"
            >
                삭제
            </button>
        </div>
    </form>
</div>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 유효성체크 플러그인 -->
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.21.0/dist/jquery.validate.min.js"></script>
<script src="/js/dept/dept-validation-config.js"></script>

<script type="text/javascript">
    function fn_save() {
        $("#addForm").attr("action",'/dept/edit')
            .submit();
    }

    function fn_delete() {
        $("#addForm").attr("action",'/dept/delete')
            .submit();
    }
</script>

</body>
</html>
