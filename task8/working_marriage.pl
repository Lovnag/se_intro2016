remove(_,[],[]).
remove(X,[X|T],T).
remove(X,[H|T],[H|S]):-X\=H, remove(X,T,S).
set_equal([],[]).
set_equal([H|T],L):- member(H,L),remove(H,L,R),set_equal(T,R).
r1(Ivan_waifu):-not(Ivan_waifu=ann),!,Ivan_waifu=july.
r1(Ivan_waifu).
r2(Peter_waifu,Ivan_waifu):-Peter_waifu=ann,!,not(Ivan_waifu=july).
r2(Peter_waifu,Ivan_waifu).
r3(Vasiliy_waifu,Andrew_waifu):-not(Vasiliy_waifu=mary),!,Andrew_waifu=july.
r3(Vasiliy_waifu,Andrew_waifu).
r4(Peter_waifu,Ivan_waifu):-Peter_waifu=july,!,Ivan_waifu=tatyana.
r4(Peter_waifu,Ivan_waifu).
r5(Peter_waifu,Ivan_waifu):-not(Peter_waifu=mary),!,not(Ivan_waifu=tatyana).
r5(Peter_waifu,Ivan_waifu).
r6(Andrew_waifu,Ivan_waifu):-Andrew_waifu=july,!,Ivan_waifu=mary.
r6(Andrew_waifu,Ivan_waifu).
waifu_for_laifu(K):-
K=[[ivan,Ivan_waifu],[peter,Peter_waifu],[vasiliy,Vasiliy_waifu],[andrew,Andrew_waifu]],
set_equal([Andrew_waifu,Ivan_waifu,Vasiliy_waifu,Peter_waifu],[mary,july,ann,tatyana]),
r1(Ivan_waifu),
r2(Peter_waifu,Ivan_waifu),
r3(Vasiliy_waifu,Andrew_waifu),
r4(Peter_waifu,Ivan_waifu),
r5(Peter_waifu,Ivan_waifu),
r6(Andrew_waifu,Ivan_waifu).
