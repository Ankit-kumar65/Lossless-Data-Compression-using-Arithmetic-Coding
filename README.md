# Lossless-Data-Compression-using-Arithmetic-Coding

This application implementes lossless data compression using arithmetic coding rule ( Lower and upper bound method ). It encodes and decodes a given input by user using
arithmetic coding.
Input can be a number or a String.
The accuracy achieved for decoding is upto 12 characters and after 12, it
may or may not be decode correctly due to probabilities or precision of
double in JAVA.
The Probability of each letter is 0.04.

First View : 


![WhatsApp Image 2021-05-07 at 11 40 47 PM (2)](https://user-images.githubusercontent.com/77197538/117491434-d5f84800-af8d-11eb-887a-3a80aa3dab4c.jpeg)


Encoding part : 

Simply enter the message and click on
‘Encode’. 
For eg, here the user enters
‘Bhagalpur’ and receives the resulting encoded codeword.


![WhatsApp Image 2021-05-07 at 11 45 42 PM](https://user-images.githubusercontent.com/77197538/117491865-66cf2380-af8e-11eb-97cc-147fcd799356.jpeg)



Decoding Part: 

Enter the codeword and enter the
expected length of result.
Since here the codeword was for
Bhagalpur, enter ‘9’ because Assam
is 9 characters long.

Note: For decoding, Users must write no of
Digits. Users can type any numbers and see
result upto that digit. If type no is greater than
real String, it simply decodes the string and
after that print ‘m’.

![WhatsApp Image 2021-05-07 at 11 40 47 PM](https://user-images.githubusercontent.com/77197538/117491416-d1339400-af8d-11eb-84e5-38be5e5c366f.jpeg)



