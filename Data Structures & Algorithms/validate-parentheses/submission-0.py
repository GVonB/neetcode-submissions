class Solution:
    def isValid(self, s: str) -> bool:
        """
        Approach:
        - The string I'm given can have 3 effective types of braces
        - (), [], and {}
        - Sample Strings: s = '([{}])'   valid
                          s = '[(])'     invalid
        - To check if these parenthesis are valid, we can use a stack:
        - We can add as many braces to the stack as we want
        - The only rule is that if we reach a closing brace and the top
          of the stack is not the matching open brace, we return false.
        - If the stack isn't empty by the end we should also return false
          to account for extra open braces.
        """

        stack = []
        closedBraces = {"]", ")", "}"}

        for i in range(len(s)):
            currChar = s[i]
            popChar = ""
            if currChar in closedBraces:
                if not stack:
                    return False
                popChar = stack.pop()
                if currChar == "]":
                    if not popChar == "[": return False
                elif currChar == ")":
                    if not popChar == "(": return False
                elif currChar == "}":
                    if not popChar == "{": return False
            else:
                stack.append(currChar)
        return not stack
            

