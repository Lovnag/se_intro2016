neighbors(X,X,[X]).
neighbors(X,Y,L) :-
	append(_, [X,Y|_], L);
	append(_, [Y,X|_], L).
to_the_right(X,X,[X]).
to_the_right(X,Y,L):-
	append(_,[X,Y|_], L).
remove(_,[],[]).
remove(X,[X|T],T).
remove(X,[H|T],[H|S]):-X\=H, remove(X,T,S).
set_equal([],[]).
set_equal([H|T],L):- member(H,L),remove(H,L,R),set_equal(T,R).
member(X,[X|_]).
member(X,[H|T]):- member(X,T).
einstein(Solution):-
Solution=[[first_house,First_house_owner,First_house_drink,First_house_cigarette,First_house_pet,First_house_color],
	[second_house,Second_house_owner,Second_house_drink,Second_house_cigarette,Second_house_pet,Second_house_color],
	[third_house,Third_house_owner,Third_house_drink,Third_house_cigarette,Third_house_pet,Third_house_color],
	[fourth_house,Fourth_house_owner,Fourth_house_drink,Fourth_house_cigarette,Fourth_house_pet,Fourth_house_color],
	[fifth_house,Fifth_house_owner,Fifth_house_drink,Fifth_house_cigarette,Fifth_house_pet,Fifth_house_color]],
member([_,englishman,_,_,_,red],Solution),
member([_,spainish,_,_,dog,_],Solution),
member([_,_,coffee,_,_,green],Solution),
member([_,ukrainian,tea,_,_,_],Solution),
member([_,_,_,_,_,white],Solution),
to_the_right([_,_,_,_,_,green],[_,_,_,_,_,white],Solution),
member([_,_,_,old_gold,snails,_],Solution),
member([_,_,_,kool,_,yellow],Solution),
member([third_house,_,milk,_,_,_],Solution),
member([first_house,norwegian,_,_,_,_],Solution),
member([_,_,_,chesterfield,_,_],Solution),
member([_,_,_,_,fox,_],Solution),
neighbors([_,_,_,chesterfield,_,_],[_,_,_,_,fox,_],Solution),
member([_,_,_,_,horse,_],Solution),
neighbors([_,_,_,kool,_,_],[_,_,_,_,horse,_],Solution),
member([_,_,orange_juice,lucky_strike,_,_],Solution),
member([_,japanese,_,parliament,_,_],Solution),
member([_,_,_,_,_,blue],Solution),
neighbors([_,norwegian,_,_,_,_],[_,_,_,_,_,blue],Solution),
member([_,_,water,_,_,_],Solution),
member([_,_,_,_,zebra,_],Solution),
set_equal([First_house_owner,Second_house_owner,Third_house_owner,Fourth_house_owner,Fifth_house_owner],
	  [englishman,spainish,ukrainian,norwegian,japanese]),
set_equal([First_house_drink,Second_house_drink,Third_house_drink,Fourth_house_drink,Fifth_house_drink],
	  [coffee,tea,milk,orange_juice,water]),
set_equal([First_house_cigarette,Second_house_cigarette,Third_house_cigarette,Fourth_house_cigarette,Fifth_house_cigarette],
	  [old_gold,kool,chesterfield,lucky_strike,parliament]),
set_equal([First_house_pet,Second_house_pet,Third_house_pet,Fourth_house_pet,Fifth_house_pet],[dog,snails,fox,horse,zebra]),
set_equal([First_house_color,Second_house_color,Third_house_color,Fourth_house_color,Fifth_house_color],
	  [red,green,white,yellow,blue]).
