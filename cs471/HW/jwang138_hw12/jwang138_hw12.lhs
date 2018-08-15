> module Jwang138_hw12
>    where

Due Wed. April 25,2018 @ midnight

In Lab problems a-c:

Problem a:
Consider the following definition:

> mm f g = (.) (map f) (map g) 

What is the type of
   mm ((-) 20) ((+) 9) ?
What are the values of 
   mm ((-) 20) ((+) 9) [3,-2, -9, 50]
   mm ((-) 20) ((+) 9) [-3,2, -9, 50]

Describe in word what mm does.

Define mm2 to be equivalent to mm but
only using only one 'map' application, compose, (.).

> mm2 f g = map ((.) f(g))

Problem b:
Consider the following definition:

> lc f p  = \lst -> [f x | x<-lst, p x]

What is the type of 
   	lc (\n -> n -1) odd ?

	lc (\n -> n -1) odd :: Integral a => [a] -> [a]

What are the values of :
      lc (\n -> n -1) odd [2,33,50,11,23,4]
      [32,10,22]

      lc (\n -> n -1) ((.) not odd) [2,33,50,11,23,4]
      [1,49,3]

Define hf to be equivalent to lc but use map and filter instead of list
comprehension.

> hf f p = \lst -> filter p (map f lst)

Problem c:
'sumPRL nums', defined below, produces a list of partial sum 
  of the numbers in nums. The first value in the resulting list 
  will be the sum of all the items, the second will be the sum 
  of all the items except the first, etc.  For example:
   
   ...> sumPRL [3,-2,10]
   [11,8,10]

> sumPRL (l:ls) = sums [l] ls
>   where
>    sums (a:as) (n:ns) = sums ((a+n):a:as) ns
>    sums as []  = as


Define sumPRLHOF to be equivalent to sumPRL but using a fold.  
I have started the sumPRLHOF definition, you only need to
complete the definition for f.

    > sumPRLHOF :: (Num t1, Foldable t) => t t1 -> [t1]
    > sumPRLHOF  = foldr f [] 
    >    where
    >     f  y [] = 
    >     f  y (x:xs) = 

Remember foldr can be defined as follows:

   > foldr :: (a -> b -> b) -> b -> [a] -> b
   > foldr f acc [] = acc
   > foldr f acc (x:xs) = f x  (foldr f acc xs) 


----------------------  HW ----------------------
Problem 1: (Thompson 11.11)
Find operators (that can be partially applied), sec1 and sec2, so that
  map sec1 . filter sec2
has the same effect as
  filter (>0) . map (+1)

Problem 1 Answer:

map (+1) . filter (> (-1))
 

Problem 2:
Remember in the first Haskell assignment problem 6 you used primitive recursion
to define a function composeList.   composeList took a list of functions 
and composed them.  e.g.

   ... > composeList [ (-) 3 , (*) 2, (+)5 ] 7
       -21


One possible solution is 

> composeList [] = id
> composeList (h:t) = (.) h  composeList t

Define composeHOF to be equivalent to composeList but use a 'fold?'

> composeHOF :: Foldable t => t (b -> b) -> b -> b

Problem 2 Answer:

id is the identity for composition (used as the initial value for the accumulator)

> composeHOF f x = foldl (.) id f x


Problem 3:  (Thompson 17.24/30 )
Define the list of numbers whose only prime factors are 2, 3, and 5, the
so-called Hamming numbers:

   ...> hamming
   1,2,3,4,5,6,8,9,10,12,15,16,18,20,24 ...


 You may consider using any combinition of the following techiques
       to express your solution  list comprehension notation, 
       and/or explicit recursion, and/or local definitions .  
       You may 'merge' defined in the last homework useful.

(Hint: Apply the circular list idea demostrated in fibSeq
  (http://bingweb.binghamton.edu/%7Ehead/CS471/NOTES/HASKELL/4hF02.html)) 

Problem 3 Answer:

> merge (x:xs) ys
>   | ys == [] = xs
>   | xs == [] = ys
>   | x <= head ys && x /= head ys = x : (merge xs ys)
>   | otherwise = head ys : (merge (x:xs) (tail ys))

> hamming :: [Integer]
> hamming = 1 : [f | f <- merge (map (2*) hamming) (merge (map (3*) hamming) (map (5*) hamming))]

Problem 4:
Define sumHarmonic using a simple recursive style:

The harmonic series is the following infinite series:
                            1   1   1   1               1
                      1 +   - + - + - + - + ...   + ... - ..
                            2   3   4   5               i
(http://en.wikipedia.org/wiki/Harmonic_series_(mathematics))
Write a function sumHarmonic such that sumHarmonic i is the sum of the first i
terms of this series. For example, sumHarmonic 4 ~> 1 + 1 + 1 + 1 ~> 2.08333...
                                                        2   3   4

> sumHarmonic :: (Eq a, Fractional a) => a -> a

Problem 4 Answer:

> sumHarmonic 1 = 1
> sumHarmonic i = 1/i + sumHarmonic (i-1)


Problem 5:
Rewrite the above definition using either foldr or foldl. (i.e. figure out what ???
should be)
  sumH n = foldr ??? 0 [1..n]
or 
  sumH n = foldl ??? 0 [1..n]
  
   ...> sumHarmonic 20
   3.59773965714368
   ...> sumH n
   3.59773965714368


Problem 5 Answer:

> sumH :: (Fractional a, Enum a) => a -> a
> sumH n = foldr (\x y -> y + (1/x)) 0 [1..n]

Problem 6:
 Using a fold in your solution:
  Define  "allTrue" to evaluate a list of expression of Bools to True if all 
   the expression in a list are true.  Provide two test cases.  Do not have an
   explicit parameters.  (i.e. allTrue = ???)
   eg:
    ...> allTrue [True, 3==3, 5>3]
         True
    ...> allTrue [True, 3>3, 5>3]
    False


> allTrue :: Foldable t => t Bool -> Bool

Problem 6 Answer:

> allTrue = foldr (&&) True

Test Cases:
...> allTrue [True, 3>3, 5==3]
False
...> allTrue [True, 3>2, 5>3, 4<6]
True

Problem 7.
Using an HOF (map, fold and/or filter ) define flattenT that returns a list of
value in each tuple. flattenT :: Foldable t => t (a, a) -> [a]
  

 7a) The output should be in the same order as the values appear in the 
     original list.
e.g.

   ...> flattenT  [(1,2), (3,4), (11,21),(-5,45)] 
   [1,2,3,4,11,21,-5,45]

 

 7b) flattenR is the same as 7a, however, the values appear in the reverse order
   from the original list. Do not use the builtin reverse. 
   flattenR :: Foldable t => t (a, a) -> [a]
e.g.
   ...> flattenR  [(1,2), (3,4), (11,21),(-5,45)] 
   [45,-5,21,11,4,3,2,1]

Problem 7 Answer:

 > flattenT :: Foldable t => t (a, a) -> [a]
 > flattenT = foldr1 (++) $ map (\(x,y) -> [x,y])

 > flattenR :: Foldable t => t (a, a) -> [a]
 > flattenR = foldl1 (++) $ map (\(x,y) -> [y,x])




Problem 8:  http://en.wikipedia.org/wiki/Happy_number 
You will need to define 'sumSqr n' --  First read through this problem


A happy number is defined by the following process. Starting with any positive integer, replace 
the number by the sum of the squares of its digits, and repeat the process until the number 
equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 

Those numbers for which this process ends in 1 are happy numbers, If n is not happy (or sad), 
then its sequence does not go to 1. Instead, it ends in the cycle:
         4, 16, 37, 58, 89, 145, 42, 20, 4, ...

'happySeq' defined below creates a sequence of 'happy numbers'.
 
 > happySeq = filter isHappy [1..]

  ...>  take 10 happySeq
  [1,7,10,13,19,23,28,31,32,44]

sqrSeq returns a sequence of the sum of the square of the digits of a number
ex. sqrSeq 5 = [5,25,29,85,89,145,42,20,4] <- Unhappy number
ex. sqrSeq 7 = [7,49,97,130,10,1]          <- Happy number

	> sqrSeq n
	>  | n == 1 || n == 4 = [n]
	>  | otherwise        = n : sqrSeq (sumSqr n)

Below is an alternative definition for sqrSeq

(need takeWhile will not work because we need to include 1 or 4)  

> takeWhileInclusive :: (a -> Bool) -> [a] -> [a]
> takeWhileInclusive _ [] = []
> takeWhileInclusive p (x:xs) = x : if p x then takeWhileInclusive p xs
>                                          else []

	> sqrSeq2 n = takeWhileInclusive (\x -> x/=1 && x/=4) (iterate sumSqr n)

'isHappy' returns True if number is happy and False otherwise.  
'isHappy' requires you to define sumSqr.

	> isHappy n
	>  | n == 1    = True
	>  | n == 4    = False
	>  | otherwise = isHappy (sumSqr n)

Returns a list of the digits of a number

> digits n
>  | n < 10    = [n]
>  | otherwise = (mod n 10) : digits (div n 10)

  
You should define sumSqr using HOF fold, map.  You may use digit, (+) or sum, 
and lambda expression.

 > sumSqr :: Integral a => a -> a

I don't see anywhere in the question what sumSqr is supposed to do
 


