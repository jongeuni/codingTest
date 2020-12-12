def is_palindrome(word):
    check = True
    for i in range(int(len(word)/2)):
        if word[i]!=word[-1-i]:
            check = False
            return check
            break
    return check
