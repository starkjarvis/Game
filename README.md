# Game

Features of the ESP Game:
1. Multiple players can log in through different browser with their account credentials or sign up.
2. System tracks the primary image and set of secondary images chosen by opponents.
3. Player is able to logout or end game anytime from navigation bar.
4. As soon as player select primary or secondary images, options are stored in database keeping information intact in case of server failure.
5. Each task has one primary image and 5 secondary images.
6. Player can start new game with another player after completion of current game.
7. If player logout, the game_id is discarded along with the responses.
8. If both players chose same secondary image, 1 point each is granted.
9. *consensus feature: Same set of primary and secondary images are provided to opponents, 
   ex: First player creates game first (system decides opponent based on status-offline/online or playing/not playing), so suppose from 1 to 15 
   images, primary image randomly comes out to be 3, and secondary images comes randomly (5,8,11,1,3). So the second player will also receive 
   (5,8,11,1,3) as their secondary image.
10. Highest Score feature is also introduced which tells logged in player's highest score.
