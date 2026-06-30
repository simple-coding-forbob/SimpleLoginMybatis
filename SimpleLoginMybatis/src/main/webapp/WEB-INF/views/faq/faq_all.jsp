<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>부서 목록</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="faq 조회 페이지입니다.">
    <!-- 	tailwind cdn  -->
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    <!-- 	개발자 css -->
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/pagination.css">
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
<div class="container mx-auto mt-8 px-3" >
    <form id="listForm" name="listForm" method="get">
        <!-- 수정페이지 열기때문에 필요 -->
        <input type="hidden" id="fno" name="fno">
        <!-- TODO: 컨트롤러로 보낼 페이지번호 -->
        <input type="hidden" id="page" name="page" value="0">
        <h1 class="text-2xl font-bold mb-6">faq 조회</h1>

        <!-- jsp -> 컨트롤러(검색어): input 태그의 name 속성을 이용 -->
        <div class="flex justify-center mb-4">
            <input type="text"
                   class="w-full border border-gray-300 rounded-l p-2 focus:outline-none focus:ring focus:ring-blue-500"
                   id="searchKeyword"
                   name="searchKeyword"
                   placeholder="제목입력"
                   value="${param.searchKeyword}"
            >
            <button type="button"
                    class="bg-blue-700 text-white hover:bg-blue-800 px-4 py-2 rounded-r min-w-[5rem]"
                    onclick="fn_egov_link_page(0)"
            >
                검색
            </button>
        </div>
        <table class="w-[100%] border border-gray-200">
            <thead class="bg-blue-700 text-white">
            <tr>
                <th scope="col" class="px-4 py-2 border-b">fno</th>
                <th scope="col" class="px-4 py-2 border-b">title</th>
                <th scope="col" class="px-4 py-2 border-b">content</th>
            </tr>
            </thead>
            <tbody>
            <!-- 반복문 -->
            <c:forEach var="data" items="${faqs}">
                <tr class="hover:bg-gray-50">
                    <td class="px-4 py-2 border-b text-center">
                        <a href="/faq/edition?fno=<c:out value='${data.fno}'/>">
                            <c:out value="${data.fno}"></c:out>
                        </a>

                    </td>
                    <td class="px-4 py-2 border-b"><c:out value="${data.title}"></c:out></td>
                    <td class="px-4 py-2 border-b"><c:out value="${data.content}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:if test="${empty faqs}">
            데이터가 없습니다.
        </c:if>
        <!-- 여기: 페이지번호 -->
        <div class="flex justify-center mt-4">
            <ul class="pagination" id="pagination"></ul>
        </div>

    </form>
</div>
<!-- 꼬리말 -->
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
    function fn_egov_link_page(page) {
        $("#page").val(page);
        $("#listForm").attr("action", "/faq")
            .submit();
    }
</script>

<!-- TODO: 페이징 라이브러리(CDN 사용) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js"></script>
<script type="text/javascript">
    /* 페이징 처리 */
    $('#pagination').twbsPagination({
        totalPages: ${criteria.totalPages},
        startPage:${criteria.page},
        visiblePages: ${criteria.size},
        initiateStartPageClick: false,
        onPageClick: function (event, page) {
            fn_egov_link_page(page)
        }
    });
</script>

</body>
</html>