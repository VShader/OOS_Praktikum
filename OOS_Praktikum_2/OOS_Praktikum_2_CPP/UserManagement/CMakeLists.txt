set(dir "UserManagement")
include_directories(${dir})
set(${dir}_hpp benutzer.hpp benutzerVerwaltung.hpp benutzerVerwaltungAdmin.hpp)

foreach(i ${${dir}_hpp})
	set(hpp ${hpp} ${dir}/${i})
endforeach(i)
