def check_subarray_sum(nums, k)
  return false  if (nums.length < 2)
  
  arr = []
  arr[0] = [nums[0]]
  for i in 0...nums.length
    arr[i] = []  if (arr[i] == nil)
    for j in i...nums.length
      if (i == j)
        arr[i][j] = nums[i]
        next
      end

      arr[i][j] = arr[i][j-1] + nums[j]
      if ((k != 0 && arr[i][j] % k == 0) || (k == 0 && arr[i][j] == 0))
        return true
      end
    end
  end

  return false
end

puts "[0,1,0], 0"
puts check_subarray_sum([0,1,0], 0)