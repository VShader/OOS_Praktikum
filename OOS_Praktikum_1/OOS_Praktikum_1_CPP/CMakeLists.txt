cmake_minimum_required(VERSION 2.8)
project(OOS_Praktikum_1_CPP)

message(STATUS ${CMAKE_BUILD_TYPE})

include(Shapes/CMakeLists.txt)

set(sources ${sources} "main.cpp")
add_executable(${PROJECT_NAME} ${sources})
