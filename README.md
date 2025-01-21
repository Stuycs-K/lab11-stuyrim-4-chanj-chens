[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

Working Features

:white_check_mark: attack, special, support for all classes and targeting!

:white_check_mark: constructors for classes, including empty constructor 

:white_check_mark: Able to run the game to the victory/defeat screen

:white_check_mark: Asks for a second prompt if you fail to submit a working input

:white_check_mark: program ends when the user choosed to quit, or all enemies is defeated, or the entire party is defeated. 

:white_check_mark: Win/lose screen.


Extra features that work

:ballot_box_with_check: Allows user to pick number of enemies

:ballot_box_with_check: Randomly generates user's team 

:ballot_box_with_check: buffs and debuffs turn on/off depending on whether or not adventurers receive a buff, can be given by Anger/Anxiety respectively

:ballot_box_with_check: new Anxiety class

:ballot_box_with_check: name generator for bosses

:ballot_box_with_check: Anger has a secondary special that consumes his own health to deal damage

:beetle: More like a disclaimer: on the enemy team's last move, the action message doesn't seem to appear. If you scroll up to the previous screen, it actually does show, but the transition to the next turn clears the screen.

## Adventurer Subclasses

### <ins>Joy</ins>                                                                       <br/>
- HP: 22 <br/>
- Optimism (resource): max 10, starts at 5, gains 1 optimism every time an enemy is attacked <br/>
- Serotonin Overload: 2-4 damage <br/>
- Pep Talk (special): increases other's special by 5, reduces Optimism by 2 when targeting a LIVE target <br/>
- Support other: can heal others at a rate of 5 hp <br/>
- Support herself: can restore optimism by 3 and heal herself by 3 hp<br/>
<br/>

### <ins>Anger</ins>                                                                                                               <br/>
- HP: 35 <br/>
- Punch:  4-10 damage <br/>
- Explode (Special):Does 3 damage per anger consumed, consumes all anger meter (at least 5), consumes 5 HP per missing anger meter + 0-5 damage <br/>
- Resource : Anger Meter, max 10, charges 1 per attack, starts at 0 <br/>
- Support : Can buff allies to deal extra damage , or himself<br/>
<br/>

###<ins>***Anxiety***                                                                                                              <br/>
- HP: 21 <br/>
- Demotivate (Special) :reduces opponent’s attack ability by 3 damage, consumes 2 negative energy <br/>
- Panic Attack: 2-5 damage <br/>
- Resource : negative energy, starts at 5,  gain 1 per turn passively <br/>
- Support: heals other by 1 hp, or self<br/>
<br/>
