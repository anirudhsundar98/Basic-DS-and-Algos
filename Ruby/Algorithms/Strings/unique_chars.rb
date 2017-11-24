string = gets.strip

# Using additional data structures
letters = "qwertyuiopasdfghjklzxcvbnm".split("")

def check1(string, letters)
	until (letters == [])
		count = string.scan(letters[0]).length
		return false 	if count > 1
		letters.shift
	end

	return true
end

puts check1(string, letters)

# Without Additional Data structures
def check2(string)
	until (string == "")
		len_old = string.length
		string.gsub!(string[0], "")
		return false 	if (len_old - string.length > 1)
	end

	return true
end

puts check2(string)
