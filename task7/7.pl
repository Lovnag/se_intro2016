a(X):-not(X=vitya), X=borya.
b(X):-X=vitya, not(X=alesha).
v(X, Y):-not(X=borya), Y=vitya.
blot(X):-a(X), b(X), not(v(X,Y)).
blot(X):-a(X), not(b(X)),  v(X,Y).
blot(X):-not(a(X)), b(X), v(X,Y).
lessons(Y):-v(X,Y).
