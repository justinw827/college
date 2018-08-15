from socket import *
serverPort = 12006
serverSocket = socket(AF_INET,SOCK_STREAM)
serverSocket.bind(('localhost',serverPort))
serverSocket.listen(1)
print "The server is ready to receive"
while 1:
     connectionSocket, addr = serverSocket.accept()
     connectionSocket2, addr2 = serverSocket.accept()
     
     sentence = connectionSocket.recv(1024)
     sentence2 = connectionSocket2.recv(1024)

     print "Server message 1: ", sentence
     print "Server message 2: ", sentence2
     #capitalizedSentence = sentence.upper()
     fullSentence = sentence + " received before " + sentence2

     connectionSocket.send(fullSentence)
     connectionSocket2.send(fullSentence)

     print "Sent acknowledgement to X and Y."

     connectionSocket.close()
     connectionSocket2.close()