set(Shapes_hpp "Shape.hpp"
		"Point.hpp" "KreisVererb.hpp" "KreisAgg.hpp" "Rechteck.hpp")
#set(Shapes_cpp "Point.cpp" "KreisVererb.cpp" "KreisAgg.cpp" "Rechteck.cpp")

foreach(var ${Shapes_hpp})
set(hpp ${hpp} ./Shapes/${var})
endforeach(var)

foreach(var ${Shapes_cpp})
set(cpp ${cpp} ./Shapes/${var})
endforeach(var)

include_directories(Shapes)
