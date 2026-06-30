<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="bg-gray-100 text-gray-800">
    <div class="bg-blue-700 text-white flex justify-between border-b items-center py-1 px-5">
        <div class="text font-bold">simple-coding</div>
        <div class="flex items-center gap-4">
            <button
                    aria-label="햄버거 메뉴 열기/닫기"
            >
                ☰
            </button>
        </div>
    </div>
    <div class="flex flex-col gap-4 transition-all duration-700 md:flex-row md:justify-between md:items-center
        max-h-1000">
        <ul class="flex flex-col gap-4 pl-5 py-2 md:flex-row">
            <li>
                <a class="hover:underline" href="/">홈</a>
            </li>
            <li class="group md:relative">
                <a class="hover:underline" href="#">
                    부서
                </a>
                <ul class="md:absolute md:top-full md:left-0 md:opacity-0 md:invisible md:group-hover:opacity-100
            md:group-hover:visible md:transition-all md:bg-white md:text-black md:w-42 md:p-2 md:rounded">
                    <li class="m-2"><a class="hover:underline" href="/dept">부서조회</a></li>
                    <li class="m-2"><a class="hover:underline" href="/dept/addition">부서추가</a></li>
                </ul>
            </li>
            <li class="group md:relative">
                <a class="hover:underline" href="#">
                    사원
                </a>
                <ul class="md:absolute md:top-full md:left-0 md:opacity-0 md:invisible md:group-hover:opacity-100
            md:group-hover:visible md:transition-all md:bg-white md:text-black md:w-42 md:p-2 md:rounded">
                    <li class="m-2"><a class="hover:underline" href="/emp">사원조회(퀴즈)</a></li>
                    <li class="m-2"><a class="hover:underline" href="/emp/addition">사원추가(퀴즈)</a></li>
                </ul>
            </li>
            <li class="group md:relative">
                <a class="hover:underline" href="#">
                    faq
                </a>
                <ul class="md:absolute md:top-full md:left-0 md:opacity-0 md:invisible md:group-hover:opacity-100
            md:group-hover:visible md:transition-all md:bg-white md:text-black md:w-42 md:p-2 md:rounded">
                    <li class="m-2"><a class="hover:underline" href="/faq">faq조회(마무리퀴즈)</a></li>
                    <li class="m-2"><a class="hover:underline" href="/faq/addition">faq추가(마무리퀴즈)</a></li>
                </ul>
            </li>
            <li class="group md:relative">
                <a class="hover:underline" href="#">
                    fileDb
                </a>
                <ul class="md:absolute md:top-full md:left-0 md:opacity-0 md:invisible md:group-hover:opacity-100
            md:group-hover:visible md:transition-all md:bg-white md:text-black md:w-42 md:p-2 md:rounded">
                    <li class="m-2"><a class="hover:underline" href="/fileDb">fileDb</a></li>
                    <li class="m-2"><a class="hover:underline" href="/fileDb/addition">fileDb추가</a></li>
                </ul>
            </li>
            <li class="group md:relative">
                <a class="hover:underline" href="#">
                    gallery
                </a>
                <ul class="md:absolute md:top-full md:left-0 md:opacity-0 md:invisible md:group-hover:opacity-100
            md:group-hover:visible md:transition-all md:bg-white md:text-black md:w-42 md:p-2 md:rounded">
                    <li class="m-2"><a class="hover:underline" href="/gallery">gallery</a></li>
                    <li class="m-2"><a class="hover:underline" href="/gallery/addition">gallery추가</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
