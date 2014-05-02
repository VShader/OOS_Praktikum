cmake_minimum_required(VERSION 2.8.12)
project(OOS_Praktikum_3_CPP)
message(STATUS ${CMAKE_BUILD_TYPE})

if(MINGW OR CMAKE_COMPILER_IS_GNUCXX)
    set(CMAKE_CXX_FLAGS "${CMAKE_C_FLAGS} -std=c++11")
endif(MINGW OR CMAKE_COMPILER_IS_GNUCXX)


find_package(Qt5Widgets REQUIRED)
set(CMAKE_AUTOMOC ON)
set(CMAKE_INCLUDE_CURRENT_DIR ON)

include(AnwendungsFrame/CMakeLists.txt)
include(LoginFrame/CMakeLists.txt)

qt5_wrap_ui(ui_h ${ui})

add_executable(${PROJECT_NAME} main.cpp ${sources})
target_link_libraries(${PROJECT_NAME} Qt5::Widgets)
