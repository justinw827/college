def gcdI(i, j)
	while i != j
		if i > j
			i = i -j
	  	else
	    	j = j - i
	  	end
	end
	i
end

def gcdF(i, j)
	if j == 0
		i
	else
		gcdF(j, i % j)
	end
end

if ARGV.length != 2 
  puts "gcd_full.rb usage: [m] [n]" 
  exit
end

puts "gcdI #{gcdI(ARGV[0].to_i, ARGV[1].to_i)}"
puts "gcdF #{gcdF(ARGV[0].to_i, ARGV[1].to_i)}"