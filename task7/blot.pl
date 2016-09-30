and(T, P):-T , P.
lessons(X):-lessons(X).
a1(X):-not(X=vitya).
a2(X):- X=borya.
b1(X):-X=vitya.
b2(X):-not(X=alesha).
v1(X):-not(X=borya).
v2:- not(lessons(vitya)).
blot(X):- a1(X), a2(X), b1(X), b2(X), not(v1(X)). 	
blot(X):- a1(X), a2(X), not(and(b1(X), b2(X))), v1(X).
blot(X):- not(and(a1(X),a2(X))), b1(X), b2(X), v1(X).


