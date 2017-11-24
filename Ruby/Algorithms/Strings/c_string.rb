#!/home/anirudh/.rbenv/shims/ruby

def reverse(string)
  str_array = string.split("")
  len = str_array.length  # simpler variable name
  temp = []
  for i in 0...(len - 1)
    temp[len-i-1] = str_array[i]
  end

  temp.shift
  temp[len-1] = str_array[len-1]
  return temp.join("")
end

str = gets.strip + "\0"
puts reverse(str)