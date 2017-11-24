# https://leetcode.com/problems/ones-and-zeroes/description/
$hash = {}

def find_max_form(strs, m, n)
  return find_max_temp(strs, 0, m, n)
end

def find_max_temp(strs, i, m, n)
  return 0  if (i >= strs.length)

  str = strs[i]
  count0 = 0
  count1 = 0
  str.each_char do |c|
    count0 += 1  if(c == "0")
    count1 += 1  if(c == "1")
  end

  if (count0 > m || count1 > n)
    $hash[[i,m,n]] = find_max_temp(strs, i+1, m, n)  if (!$hash[[i,m,n]])
    return $hash[[i,m,n]]
  end

  $hash[[i,m,n]] = [find_max_temp(strs, i+1, m, n), 1+find_max_temp(strs, i+1, m-count0, n-count1)].max  if ($hash[[i,m,n]] == nil)
  return $hash[[i,m,n]]
end


puts find_max_form(["101100","10","0","1","01001","0110","1","0","1","000"], 62, 42)