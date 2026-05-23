class MinStack:

    def __init__(self):
        self.stack = []
        self.minimum = None


    def push(self, val: int) -> None:
        if self.minimum == None or val < self.minimum:
            self.minimum = val
        self.stack.append((val, self.minimum))
        
            

    def pop(self) -> None:
        self.stack.pop()
        if len(self.stack) > 0:
            self.minimum = self.stack[-1][1]
        else:
            self.minimum = None

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.minimum
        
