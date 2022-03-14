def calculator(setting, *num):
    result =0
    if setting == "add":
        for i in num:
            result = result +i
        print('%s한 값: %d'%(setting,result))
    elif setting == "mul":
        for i in num:
            result = 1
            result = result * i
        print('%s한 값: %d'%(setting,result))
    else:
        print("add와 mul 중에 입력해 주세요.")

            
    
