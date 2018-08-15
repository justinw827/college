from socket import *
serverName = 'localhost'
serverPort = 12006

clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect((serverName,serverPort)) # create TCP socket for server, remote port 12000

clientSocket2 = socket(AF_INET, SOCK_STREAM)
clientSocket2.connect((serverName, serverPort)) # create 2nd TCP socket for server, remote port 12000

sentence = raw_input("Client X: Alice")
sentence2 = raw_input("Client Y: Bob")

clientSocket.send(sentence) # Send Client X's message to server
clientSocket2.send(sentence2) # Send Client Y's message to server 

modifiedSentence = clientSocket.recv(1024)
modifiedSentence2 = clientSocket2.recv(1024)

print 'Client X Message:', sentence
print "Server response:", modifiedSentence

print "Client Y Message:", sentence2
print "Server response:", modifiedSentence2

clientSocket.close()
clientSocket2.close()
