/*
 * Copyright (c) <2014> <Tobias Weitz>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
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
