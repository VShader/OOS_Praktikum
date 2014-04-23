#ifndef BENUTZER_HPP
#define BENUTZER_HPP

#include <string>

class Benutzer {

public:
    Benutzer()	{
        userID="NEW User";
        passWord = new char[1];
    }
    Benutzer(std::string userID, char passWord[])	{
        this.userID=userID;
        this.passWord = passWord.clone();
    }
    Benutzer(Benutzer ben)	{
        userID=ben.userID;
        passWord=ben.passWord;
    }

    std::string getID()	{
        return userID;
    }

    bool equals(Benutzer ben)	{
        return userID.equals(ben.userID) &&
                String.copyValueOf(passWord).equals(String.copyValueOf(ben.passWord));
    }
    std::string toString()	{
        return userID.toString()+String.copyValueOf(passWord).toString();
    }


private:
    string userID;
    char passWord[];
};


#endif // BENUTZER_HPP
