not_lessons(_):-true.
a(X):-not(X=vitya), X=borya.
b(X):-X=vitya, not(X=alesha).
v(X):-not(X=borya), not_lessons(vitya).
blot(X):- a(X), b(X), not(v(X)).
blot(X):- a(X), not(b(X)), v(X).
blot(X):- not(a(X)), b(X), v(X).



