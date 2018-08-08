#! /bin/bash
git add .
if test -z $1
then
	echo 请输入理由
	echo [usage] ./push.sh '理由'
	exit 2
else
	git commit -m $1
fi
git push
