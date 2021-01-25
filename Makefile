build:
	ANDROID_SDK_ROOT=~/Library/Android/sdk ./gradlew assembleRelease
	mkdir -p dist && find app -type f -name "*.aar" -exec cp {} ./dist \;

clean:
	git clean -xdf

.PHONY: build
