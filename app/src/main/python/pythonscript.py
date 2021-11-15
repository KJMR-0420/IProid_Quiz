#Import the Libraries
import sys
from os.path import dirname, join
from com.chaquo.python import Python

def main(CodeAreaData):
	#give directory path for txt file 		
	file_dir = str(Python.getPlatform().getApplication().getFilesDir())
	#give file name
	filename = join(dirname(file_dir), 'file.txt')
	#execute our code we will used stdout concept here
	try:
		# first save a reference to the original stdout	
		original_stdout = sys.stdout
		#now open new file (file.txt)with the intention to write data and change stdout to our file
		sys.stdout = open(filename, 'w', encoding = 'utf8', errors = "ignore")
		#now execute our new code using exec() method
		exec (CodeAreaData) # it will execute our code and save output in file
		#sample exec(""""print("hello")""") output => hello -- will we write in the file
		sys.stdout.close()
		#reset the stdout to its original values	 
		sys.stdout = original_stdout	 
		#open file and read output and save in variable
		output = open(filename, 'r').read()	
	except Exception as e:
		#handle errors if any errors occur in the code like syntax error then take that error message
		#output variable to show on screen	
		sys.stdout = original_stdout
		# take exception in output
		output = e
	
	#return output 

	return str(output)