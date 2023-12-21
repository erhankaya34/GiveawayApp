# GiveawayApp
 An application I made for our school club, where you can make a raffle with as many winners and reserve winners as you want, by reading the names one by one in a text file on your computer.

First, I designed a simple interface, and thanks to this interface, you can search and select the source file path directly on your computer, without having to manually write it, and point it as a path. It reads the .txt file you provide line by line and treats each line as a name that will participate in the raffle. Then, you manually enter how many main and how many reserve winners you want to choose, and a draw is made according to your wishes and the names are listed in the panel below.

I tried to use exceptions for possible errors that may be encountered (for example, trying to do a draw without any source file, entering letters instead of the number of reserve winners, choosing the same name many times or selecting both the main and the reserve).