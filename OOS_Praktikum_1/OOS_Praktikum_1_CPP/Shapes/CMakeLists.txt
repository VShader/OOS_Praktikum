set(dir Shapes)
set(${dir}_hpp "Shape.hpp"
		"Point.hpp" "KreisVererb.hpp" "KreisAgg.hpp" "Rechteck.hpp")


foreach(var ${${dir}_hpp})
set(sources ${sources} ${dir}/${var})
endforeach(var)
include_directories(Shapes)
