from socket import *
import ssl
import base64

# Message to send
msg = '\r\nI love computer networks!'
endmsg = '\r\n.\r\n'

# Choose a mail server (e.g. Google mail server) and call it mailserver
mailserver = 'smtp.gmail.com'

# Create socket called clientSocketSSL and establish a TCP connection with mailserver
clientSocket = socket(AF_INET, SOCK_STREAM)

# Wrap socket in SSL
clientSocketSSL = ssl.wrap_socket(clientSocket)

# Port number may change according to the mail server
clientSocketSSL.connect((mailserver, 465))
recv = clientSocketSSL.recv(1024)
print recv
if recv[:3] != '220':
	print '220 reply not received from server.'

# Send HELO command and print server response.
heloCommand = 'EHLO gmail.com\r\n'
clientSocketSSL.send(heloCommand)
recv1 = clientSocketSSL.recv(1024)
print recv1
if recv1[:3] != '250':
	print '250 reply not received from server.'
	
# Account name. Replace <username> with account username
username = "<username>"
# Account password. Replace <password> with account password
password = "<password>"
# Encode login info and send to server
base64_str = ("\x00"+username+"\x00"+password).encode()
base64_str = base64.b64encode(base64_str)
authMsg = "AUTH PLAIN ".encode()+base64_str+"\r\n".encode()
clientSocketSSL.send(authMsg)

# Send MAIL FROM command and print server response.
# Replace sender_email with sender's email address
mailfrom = 'MAIL FROM: <sender_email>\r\n'
# Your code here
clientSocketSSL.send(mailfrom.encode())
recv2 = clientSocketSSL.recv(1024)
recv2 = recv2.decode()

# Send RCPT TO command and print server response. 
# Replace receiver email with recipient's email address
rcptto = 'RCPT TO: <receiver_email>\r\n'
# Your code here
clientSocketSSL.send(rcptto.encode())
recv3 = clientSocketSSL.recv(1024)
recv3 = recv3.decode()

# Send DATA command and print server response. 
data = 'DATA\r\n'
# Your code here
clientSocketSSL.send(data.encode())
recv4 = clientSocketSSL.recv(1024)
recv4 = recv4.decode()

# Send message data.
# Your code here
clientSocketSSL.send(msg.encode())

# Message ends with a single period.
clientSocketSSL.send(endmsg)
# Your code here

# Send QUIT command and get server response.
quitcommand = 'QUIT\r\n'
# Your code here
clientSocketSSL.send(quitcommand.encode())
recv5 = clientSocketSSL.recv(1024)
recv5 = recv5.decode()

