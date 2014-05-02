set(dir AnwendungsFrame)
set(${dir}_hpp anwendungsFrame.hpp)
set(${dir}_cpp anwendungsFrame.cpp)

foreach(var ${${dir}_hpp} ${${dir}_cpp})
    set(sources ${sources} ${dir}/${var})
endforeach(var)
include_directories(${dir})
