#ifndef BENUTZERVERWALTUNG_HPP
#define BENUTZERVERWALTUNG_HPP

#include <exception>

class BenutzerVerwaltung {
public:
    virtual void benutzerEintragen(Benutzer ben) = 0;
    virtual bool benutzerOK(Benutzer ben) = 0;
};

class BenutzerException : public std::exception
{
public:
    BenutzerException(string error)	{
        super(error);
    }
};

#endif // BENUTZERVERWALTUNG_HPP
