def binaryToDecimal(n): 
    return int(n,2) 


# Driver code
if __name__ == '__main__':
    fileObject  =   open("file.bin","r")
    inputarray  =   fileObject.read()
    for file in range(0,len(inputarray),3):
        print(binaryToDecimal(inputarray[file]+inputarray[file+1]+inputarray[file+2]))
        