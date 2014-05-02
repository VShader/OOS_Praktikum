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
#include <string.h>
//! A user class.
/*!
 * \brief Contains userID and password of a user.
 * \author Tobias Weitz
 */
class Benutzer {

public:
    //! Default constructor.
    /*!
     * \brief Creates an default user with name "NEW User".
     */
    Benutzer() : userID("NEW User"), passWord(new char[1]{' '})   {}
    //! Assignment constructor.
    /*!
     * \brief Creates an new user.
     * \param userID name for the user.
     * \param passWord password for user as C-String.
     */
    Benutzer(const std::string &userID, char *passWord)
        : userID(userID), passWord(passWord) {}
    //! Destructor
    /*!
     * \brief ~Benutzer deletes passWord;
     */
    virtual ~Benutzer()
    {
        delete passWord;
    }



    //! Compare this user with its argument.
    /*!
     * \brief Compare if userID and passWord is the
     *        same as in ben.
     * \param ben is a user.
     * \return true if they're equal, else false.
     */
    bool equals(const Benutzer &ben) const	{
        return userID == ben.userID &&
                strcmp(passWord, ben.passWord);
    }
    //! Return the userID as a string.
    /*!
     * \return userID
     */
    std::string toString()	{
        return userID;
    }


private:
    std::string userID;
    char *passWord;
};


#endif // BENUTZER_HPP
