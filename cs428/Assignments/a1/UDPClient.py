# UDP Client

from socket import *
import time

serverName = 'localhost' # Name of server
serverPort = 12001 # Server port number

clientSocket = socket(AF_INET, SOCK_DGRAM) # Create UDP socket for server
clientSocket.settimeout(1) # Set a server timeout to 1 second

for x in range(0, 10): # Execute 10 times
	message = 'hello' # Create message to be sent to server
	message.encode() # Encode message so it can be sent
	start = time.time() # Start a timer
	clientSocket.sendto(message, (serverName, serverPort)) # Send message to server 
	try:
		modifiedMessage, serverAddress = clientSocket.recvfrom(1024) # Wait for response from server
		end = time.time() # End timer
		elapsedTime = end - start # Calculate elapsed time
		print "RTT", x, ':', elapsedTime, "seconds" # Print RTT
	except timeout: # Server timeout
		print "Packet", x, "lost. Server timeout."

clientSocket.close() # Close socket