# ObjectOrientedDesign
The following are a set of object oriented desing exercises that I like to do in my spare time to sharpen my software development skills. Writing code is a craftsmenship, the more you practice the better you will get at writing code. 

# 1. Design a blackjack game with the following system requirements:

Blackjack is played with one or more standard 52-card decks. The standard deck has 13 ranks in 4 suits.

Background

To start with, the players and the dealer are dealt separate hands. Each hand has two cards in it.
The dealer has one card exposed (the up card) and one card concealed (the hole card), leaving the player with incomplete information about the state of the game.
The player’s objective is to make a hand that has more points than the dealer, but less than or equal to 21 points.
The player is responsible for placing bets when they are offered, and taking additional cards to complete their hand.
The dealer will draw additional cards according to a simple rule: when the dealer’s hand is 16 or less, they will draw cards (called a hit), when it is 17 or more, they will not draw additional cards (or stand pat).
Points calculation

Blackjack has different point values for each of the cards:

The number cards (2-10) have the expected point values.
The face cards (Jack, Queen, and King) all have a value of 10 points.
The Ace can count as one point or eleven points. Because of this, an Ace and a 10 or face card totals 21. This two-card winner is called “blackjack”.
When the points include an ace counting as 11, the total is called soft-total; when the ace counts as 1, the total is called hard-total. For example, A+5 can be considered a soft 16 or a hard 6.
Gameplay

1. The player places an initial bet.
2. The player and dealer are each dealt a pair of cards.
3. Both of the player’s cards are face up, the dealer has one card up and one card down.
4. If the dealer’s card is an ace, the player is offered insurance.

Initially, the player has a number of choices:

- If the two cards are the same rank, the player can elect to split into two hands.
- The player can double their bet and take just one more card.
- The more typical scenario is for the player to take additional cards (a hit ) until either their hand totals more than 21 (they bust ), or their hand totals exactly 21, or they elect to stand.
- If the player’s hand is over 21, their bet is resolved immediately as a loss. If the player’s hand is 21 or less, it will be compared to the dealer’s hand for resolution.

Dealer has an Ace. If the dealer’s up card is an ace, the player is offered an insurance bet. This is an additional proposition that pays 2:1 if the dealer’s hand is exactly 21. If this insurance bet wins, it will, in effect, cancel the loss of the initial bet. After offering insurance to the player, the dealer will check their hole card and resolve the insurance bets. If the hole card is a 10-point card, the dealer has blackjack, the card is revealed, and insurance bets are paid. If the hole card is not a 10-point card, the insurance bets are lost, but the card is not revealed.

Split Hands. When dealt two cards of the same rank, the player can split the cards to create two hands. This requires an additional bet on the new hand. The dealer will deal an additional card to each new hand, and the hands are played independently. Generally, the typical scenario described above applies to each of these hands.

Bets

- Ante: This is the initial bet and is mandatory to play.
- Insurance: This bet is offered only when the dealer shows an ace. The amount must be half the ante.
- Split: This can be thought of as a bet that is offered only when the player’s hand has two cards of equal rank. The amount of the bet must match the original ante.
- Double: This can be thought of as a bet that is offered instead of taking an ordinary hit. The amount of the bet must match the original ante.

# 2. Design an ATM
# Requirements and Goals of the System:
The main components of the ATM that will affect interactions between the ATM and its users are:
1. Card reader: to read the users’ ATM cards.
2. Keypad: to enter information into the ATM e.g. PIN. cards.
3. Screen: to display messages to the users.
4. Cash dispenser: for dispensing cash.
5. Deposit slot: For users to deposit cash or checks.
6. Printer: for printing receipts.
7. Communication/Network Infrastructure: it is assumed that the ATM has a communication infrastructure to communicate with the bank upon any transaction or activity.

The user can have two types of accounts: 1) Checking, and 2) Savings, and should be able to perform the following five transactions on the ATM:
1. Balance inquiry: To see the amount of funds in each account.
2. Deposit cash: To deposit cash.
3. Deposit check: To deposit checks.
4. Withdraw cash To withdraw money from their checking account.
5. Transfer funds: To transfer funds to another account.

How ATM works? 

The ATM will be managed by an operator, who operates the ATM and refills it with cash and receipts. The ATM will serve one customer at a time and should not shut down while serving. To begin a transaction in the ATM, the user should insert their ATM card, which will contain their account information. Then, the user should enter their Personal Identification Number (PIN) for authentication. The ATM will send the user’s information to the bank for authentication; without authentication, the user cannot perform any transaction/service.

The user’s ATM card will be kept in the ATM until the user ends a session. For example, the user can end a session at any time by pressing the cancel button, and the ATM Card will be ejected. The ATM will maintain an internal log of transactions that contains information about hardware failures; this log will be used by the ATM operator to resolve any issues.

1. Identify the system user through their PIN.
2. In the case of depositing checks, the amount of the check will not be added instantly to the user account; it is subject to manual verification and bank approval.
3. It is assumed that the bank manager will have access to the ATM’s system information stored in the bank database.
4. It is assumed that user deposits will not be added to their account immediately because it will be subject to verification by the bank.
5. It is assumed the ATM card is the main player when it comes to security; users will authenticate themselves with their debit card and security pin.
