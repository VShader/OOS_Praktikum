cmake_minimum_required(VERSION 2.8)
project(OOS_Praktikum_2_CPP)

message(STATUS ${CMAKE_BUILD_TYPE})

include(UserManagement/CMakeLists.txt)

set(cpp ${cpp} "main.cpp")
add_executable(${PROJECT_NAME} ${hpp} ${cpp})
