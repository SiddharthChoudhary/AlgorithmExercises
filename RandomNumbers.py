from math import log,ceil,pow
def binaryToDecimal(n): 
    return int(n,2) 


# Driver code
if __name__ == '__main__':
    fileObject  =   open("file.bin","r")
    inputarray  =   fileObject.read()
    lower_end_range =12
    higher_end_range=20
    amount      =   3
    range_input=higher_end_range-lower_end_range+1 
    log_of_range=log(range_input,2)
    log_of_range=int(ceil(log_of_range)) 
    higher_end_range_represented_by_bits     =   0
    lower_end_range_represented_by_bits      =   0    
    lst                            =   []
    FinalRandomArray               =   []
    for i in range(0,(log_of_range)):
            higher_end_range_represented_by_bits+=pow(2,i)
    while True:
        i=range_input%2
        range_input=range_input/2
        lst.append(i)
        if range_input==0:
            break
    length    =   len(lst) 
    for file in range(0,len(inputarray),length):
        number=binaryToDecimal((inputarray[file]+inputarray[file+1]+inputarray[file+2]))+lower_end_range
        if(number>=lower_end_range and number<=higher_end_range):
                if(amount!=0):
                    FinalRandomArray.append(number)
                    amount-=1
    print(FinalRandomArray) 