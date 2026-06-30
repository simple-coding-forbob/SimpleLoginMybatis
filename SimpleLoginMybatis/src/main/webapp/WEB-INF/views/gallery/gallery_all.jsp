<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="kr">
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="galley 조회 페이지입니다.">
    <!-- 	tailwind cdn  -->
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    <!-- 	개발자 css -->
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/pagination.css">

</head>
<body>
<jsp:include page="/common/header.jsp"/>
<form class="container mx-auto mt-8 px-3" id="listForm" name="listForm" method="get">

    <!-- 수정페이지 열기때문에 필요 -->
    <input type="hidden" id="uuid" name="uuid">
    <!-- TODO: 컨트롤러로 보낼 페이지번호 -->
    <input type="hidden" id="page" name="page" value="0">
    <h1 class="text-2xl font-bold mb-6">galley 조회</h1>

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
    <!-- 카드 디자인: 반복문 -->
    <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
        <c:forEach var="data" items="${gallerys}">
            <div class="border rounded shadow hover:shadow-md overflow-hidden">
                <img src="<c:out value='${data.galleryFileUrl}' />" loading="lazy" alt='이미지'
                     class="w-full h-48 object-cover">
                <div class="p-4">
                    <p class="text-gray-600"><c:out value='${data.galleryTitle}'/></p>
                    <button class="px-2 py-1 bg-red-500 rounded text-white"
                            onclick="fn_delete('${data.uuid}')"
                    >삭제
                    </button>
                </div>
            </div>
        </c:forEach>
    </div>
    <c:if test="${empty gallerys}">
        데이터가 없습니다.
    </c:if>
    <!-- 여기: 페이지번호 -->
    <div class="flex justify-center mt-4">
        <ul class="pagination" id="pagination"></ul>
    </div>
</form>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
    /* 전체조회 */
    function fn_egov_link_page(page) {
        $("#page").val(page);    // 현재페이지: 벡엔드로 보낼때 첫페이지는 0입니다.
        $("#listForm").attr("action", '/gallery')
            .submit();
    }

    /* 삭제: /fileDb/delete */
    function fn_delete(uuid) {
        /* 전체조회: method="get" -> "post" 변경해서 전달 */
        $("#uuid").val(uuid);
        $("#listForm").attr("action", '/gallery/delete')
            .attr("method", "post")
            .submit();
    }
</script>

<!-- 페이징 라이브러리 -->
<script src="/js/jquery.twbsPagination.js" type="text/javascript"></script>

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
