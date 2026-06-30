<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>회원 가입</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 📌 테일윈드 CSS CDN 추가 -->
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body class="bg-gray-50 text-gray-900">
<jsp:include page="/common/header.jsp" />

<!-- 화면 중앙 정렬 및 전체 레이아웃 (기존 .page) -->
<div class="container mx-auto px-4 py-8 max-w-4xl">

    <!-- 성공 메시지 알림창 (기존 alert-success 대체) -->
    <c:if test="${not empty msg}">
        <div class="mb-6 p-4 bg-green-50 border border-green-200 text-green-700 text-center rounded-md font-medium shadow-sm animate-fade-in" role="alert">
                ${msg}
        </div>
    </c:if>

    <!-- 카드 구조 (기존 .card, mt5 반영) -->
    <div class="bg-white rounded-lg shadow-md mt-20 overflow-hidden">
        <!-- 기존 .card-body -->
        <div class="p-6">
            <!-- 모바일 세로, 데스크톱 가로 배치를 위한 Flex 레이아웃 (기존 .flex-vcenter) -->
            <div class="flex flex-col md:flex-row items-center gap-6">

                <!-- 왼쪽 이미지 영역 (기존 .col2) -->
                <div class="w-full md:w-1/2">
                    <img src="/images/puppy-1920_1280.jpg" alt="Puppy" class="w-full h-auto rounded-lg object-cover">
                </div>

                <!-- 오른쪽 폼 영역 (기존 .col2) -->
                <div class="w-full md:w-1/2">
                    <!-- 내부 패딩 설정 -->
                    <div class="p-6 md:p-8">
                        <!-- 제목 영역 (기존 .tcenter, mb4) -->
                        <div class="text-center">
                            <h3 class="text-2xl font-bold text-gray-800 mb-6">회원 가입</h3>
                        </div>

                        <form id="addForm" name="addForm" action="/register/addition" method="post" class="space-y-4">
                            <!-- 이메일 입력 -->
                            <div>
                                <input type="email"
                                       class="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-all"
                                       placeholder="이메일을 넣기" id="email" name="email"  />
                            </div>

                            <!-- 패스워드 입력 -->
                            <div>
                                <input type="password"
                                       class="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-all"
                                       placeholder="패스워드 넣기" id="password" name="password" />
                            </div>

                            <!-- 패스워드 확인 입력 -->
                            <div>
                                <input type="password"
                                       class="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-all"
                                       id="repassword" placeholder="패스워드 다시 넣기" name="repassword" />
                            </div>

                            <!-- 이름 입력 -->
                            <div>
                                <input type="text"
                                       class="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-all"
                                       id="name" placeholder="이름 입력" name="name" />
                            </div>

                            <!-- 사번 입력 -->
                            <div>
                                <input type="number"
                                       class="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-all"
                                       id="name" placeholder="사번 입력" name="eno" />
                            </div>

                            <!-- 가입 버튼 (기존 btn-primary, w100, mb3) -->
                            <button type="submit"
                                    class="w-full bg-blue-600 hover:bg-blue-700 text-white font-medium py-2.5 px-4 rounded-md transition-colors shadow-sm mt-2">
                                Register Account
                            </button>
                        </form>

                        <!-- 구분선 -->
                        <hr class="my-6 border-gray-200" />

                        <!-- 로그인 이동 링크 -->
                        <div class="text-center">
                            <a href="/login" class="text-sm text-blue-600 hover:text-blue-800 hover:underline transition-all font-medium">
                                Already have an account? Login!
                            </a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 유효성체크 라이브러리 -->
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.21.0/dist/jquery.validate.min.js"></script>
<script src="/js/auth/register-validation-config.js"></script>
</body>
</html>
