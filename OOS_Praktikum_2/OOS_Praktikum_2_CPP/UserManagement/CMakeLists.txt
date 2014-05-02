set(dir "UserManagement")
set(${dir}_hpp benutzer.hpp benutzerVerwaltung.hpp benutzerVerwaltungAdmin.hpp)

foreach(var ${${dir}_hpp})
	set(sources ${sources} ${dir}/${var})
endforeach(var)
include_directories(${dir})
