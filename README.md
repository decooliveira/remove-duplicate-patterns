# The approach to remove duplicate patterns in a string


Remove duplicate patterns in a string

1. Break the original string into substrings.
2. Maximum length of a substring it's the half size of original string. No larger substring than half size of original could match another in the same string.
3. Enque all the substrings. This way I can make sure that the larger ones would be processed first in the next steps
4. Remove repeated substrings that are adjacent in the original string


Method removeRepeatedSequences(String sequence, String substring)

This method receives two arguments. The first one is the original string and the second one is the substring to be removed if is repeated.
There is a HashMap that holds the substrings. If the substring is not in the map, it is added. Otherwise, there is one step in order to verify if the substring is adjacent to another equal substring.

The verification step is very simple. Original string is divided into sections. The first one is the first half starting in position 0 and ending in the index of first occurrence of substring. The second half starts in the index of the second occurence of the substring, if it exists. 
If both halves contain the substring and if first half end with substring while second half starts with it, then they are adjacent.

Then the substring is removed from the second half. Now, both halves are combined into a string builder. This resulting string is returned to 
calling method and the process repeats until the end.

THe result is printed in the terminal.
