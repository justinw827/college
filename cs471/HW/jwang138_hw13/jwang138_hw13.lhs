> module Jwang138_hw13
>    where

Part A Answers:

1. (\x -> x) :: t -> t
2.  (a) 3
	(b) 8
	(c) Error
	(d) All occurrences of x are replaced by the addition of 5 and 3
3.  (a) 6
	(b) x+x
4.  (a) 3
	(b) A function that always returns 3

Part B Answers:

> hLen :: (Num u, Eq t) => ([t] -> u) -> [t] -> u
> hLen = (\f x -> if x == [] then 0 else 1 + (f (tail x)))
> myLength ls = if ls == [] then 0 else 1 + myLength (tail ls)

1.
	1. It's recursive because it's calling the lamba function in the else statement.
	2. It is not a HOF because it's not taking a function as a parameter, nor is it returning a function.
	3. 
		a. 12
		b. 6

	hLen is affected by whether sum or head is an argument.

2. 3

3. hLen is a more generalized form of myLength.

Part C Answers:

> factorial :: Integral a => a -> a
> factorial n = if n ==0 then 1 else n * (factorial (n - 1))

1. 

> hFact :: t -> t
> hFact = (\x -> x)

2. 16 

3. The value is 120 and it is the same value as factorial 5.

Part D Answers:

> factorial' = hFact factorial'

1. factorial' :: t

> fix f = f(fix f) 

2. 
	a. fix :: (t -> t) -> t
	b. The order of which f(fix f) and f fix f is evaluated is different between the two.

3. 
	a. 720
	b. 720
	c. 720
	d. 720

> triangular 0 = 0
> triangular n = n + triangular (n-1)

> mys8 c (v:vs)
> 	| [ ] == vs = c  v
> 	| otherwise = mys8 (\x -> c (2*x)) vs

> mysB :: a -> b -> a
> mysB a b = a

> fp g = g (fp g)

> reverse1 bs = foldr (\b g x -> g (b : x)) id bs []