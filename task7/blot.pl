not_lessons(Y):-true.
a1(X):-not(X=vitya).
a2(X):- X=borya.
b1(X):-X=vitya.
b2(X):-not(X=alesha).
v1(X):-not(X=borya).
v2(Y):- not_lessons(vitya).
blot(X):- a1(X), a2(X), b1(X), b2(X), (not(v1(X); not(v2(Y))). 	
blot(X):- a1(X), a2(X), (not(b1(X)); not(b2(X))), v1(X), v2(Y).
blot(X):- (not(a1(X));not(a2(X))), b1(X), b2(X), v1(X), v2(Y).
