require "./node"

class Queue
	def initialize
		@front = nil
		@end = nil
	end
	attr_accessor :front, :end

	def enqueue(val)
		newNode = Node.new(val)
		if (front == nil)
			@front = newNode
			@end = newNode
		else
			@end.next = newNode
			@end = newNode
		end

		return self
	end

	def dequeue
		if (@front == nil)
			return nil
		end

		temp = @front
		@front = @front.next
		return temp
	end

	def display
		if (@front == nil)
			return nil
		end

		temp = @front
		until (temp == nil)
			print temp.data, ", "
			temp = temp.next
		end

		puts 
	end
end

q = Queue.new
q.enqueue(2).enqueue(5).enqueue(13).enqueue(14)
puts q.front.data, " ", q.end.data
q.display
q.dequeue
q.dequeue
q.display