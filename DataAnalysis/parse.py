import glob
import re
global_string = ""
for filename in glob.glob('*.html'):
	filename_no_extension = filename.split('.')[0]
	fin = open(filename,'r')
	string = ""
	while True:
		flag = False
		line = fin.readline()
		if line == '':
			break
		if '<div class="post-text">' in line:
			while True:
				mod_line = line.replace('<div class="post-text">','').replace('</div>','')
				mod_line = re.sub(r"<[a-zA-Z0-9/]*>","",mod_line)
				string = string + mod_line
				if('</div>' in line):
					flag = True
					break
				line = fin.readline()
		if flag == True:
			break
	fin.close()
	print string
	fout = open('txts/'+filename_no_extension+'.txt','w')
	fout.write(string)
	global_string = global_string + string
	fout.close()
fout = open('questions.txt','w')
fout.write(global_string)
fout.close()