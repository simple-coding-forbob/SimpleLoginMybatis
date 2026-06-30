<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>로그인 페이지</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 📌 테일윈드 CSS CDN 추가 -->
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body class="bg-gray-50 text-gray-900">
<jsp:include page="/common/header.jsp" />

<!-- 기존 .page 구조 반영: 화면 중앙 정렬 및 여백 -->
<div class="container mx-auto px-4 py-8 max-w-4xl">
    <!-- 기존 .card: 그림자 및 둥근 모서리, mt5 반영 -->
    <div class="bg-white rounded-lg shadow-md mt-20 overflow-hidden">
        <!-- 기존 .card-body -->
        <div class="p-6">
            <!-- 기존 .flex-vcenter: 모바일은 세로, 데스크톱은 가로(Flex) 배치 및 세로 중앙 정렬 -->
            <div class="flex flex-col md:flex-row items-center gap-6">

                <!-- 왼쪽 이미지 영역 (기존 .col2) -->
                <div class="w-full md:w-1/2">
                    <!-- 인라인 스타일 100%, auto 반영 -->
                    <img src="/images/puppy-1920_1280_2.jpg" alt="Puppy" class="w-full h-auto rounded-lg object-cover">
                </div>

                <!-- 오른쪽 폼 영역 (기존 .col2) -->
                <div class="w-full md:w-1/2">
                    <!-- 기존 패딩 설정(pt5, pl5 등)을 p-8로 통일 -->
                    <div class="p-6 md:p-8">
                        <!-- 기존 .tcenter -->
                        <div class="text-center">
                            <!-- 기존 h3, mb4 반영 -->
                            <h3 class="text-2xl font-bold text-gray-800 mb-6">Welcome Back!</h3>
                        </div>

                        <form id="addForm" name="addForm" action="/loginProcess" method="post" class="space-y-4">
                            <!-- 이메일 입력란 -->
                            <div>
                                <input type="text"
                                       class="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-all"
                                       placeholder="이메일을 넣기" id="email" name="email"  />
                            </div>

                            <!-- 패스워드 입력란 -->
                            <div>
                                <input type="password"
                                       class="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-all"
                                       placeholder="패스워드 넣기" id="password" name="password" />
                            </div>

                            <!-- 로그인 버튼 (기존 btn-primary, w100, mb3) -->
                            <button class="w-full bg-blue-600 hover:bg-blue-700 text-white font-medium py-2.5 px-4 rounded-md transition-colors shadow-sm mt-2">
                                Login
                            </button>
                        </form>

                        <!-- 구분선 -->
                        <hr class="my-6 border-gray-200" />

                        <!-- 회원가입 링크 -->
                        <div class="text-center">
                            <a href="/register" class="text-sm text-blue-600 hover:text-blue-800 hover:underline transition-all font-medium">
                                Create an Account!
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
<script src="/js/auth/login-validation-config.js"></script>
</body>
</html>
