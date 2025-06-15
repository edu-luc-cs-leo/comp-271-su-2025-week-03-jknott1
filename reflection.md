# Assigment 03: Reflection - `heapifyUp()`

Last week's assignment caused me just a bit more trouble than the couple of week's assignments before 
then. However, while our codes are different, they still function the same way.

To start, there were quite a few differences in the solution vs. the code provided. I took after the `heapifyDown()` method in my solution. In my solution, I
added a few different variables (boolean loop control, new element index variable, parent index variable, 
and a variable for the value of the new element) and used them to control the while loop. However, 
in the provided solution, the variables were controlled directly using boolean operations between 
the indexed values. This is a much simpler and more compact to carry this method out; no variables are stored
other than the index of the child. All other values and indices are called using that one index - including the
boolean operations. Thus, leading to a more compact code.

However, as mentioned earlier, I do thing that I added enough comments/documentation to explain my code. I think
my ideas were clear, and my code compiled the way I needed it to. I think I took my revisions from the last
assignment a little too seriously in initializing my variables. so, on top of trying making sure my code is compiling correctly and  I think for this week I will try to find the
sweet spot between using not initializing well enough and using too many variables.