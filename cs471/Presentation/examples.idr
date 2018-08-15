-- Example 1: Types are first class; compute/manipulate types

-- If singleton is a boolean, return a singleton natural number. If it's false, return a list of natural numbers

ListType : (singleton : Bool) -> Type

-- Same as:
-- ListType False = List Nat
-- ListType True = Nat

-- Example 2: Types of one thing can influence types of another

sumList : (singleton : Bool) -> ListType singleton -> Nat

-- sumList False x = ?sumList_rhs_1 // Where x must be a List Nat because x is false
-- sumList True x = ?sumList_rhs_2 // x is a just a Nat when x is True
-- Similar to inferences made in Prolog in a knowledge base

-- Example 3: Formatted output (Type safe printf)

