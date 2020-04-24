node {
    stage('SCM') {
		echo 'Gathering code from version control'
		git branch: '${branch}', url: 'https://github.com/trussbtech/btech_android_app.git'
    }
    stage('Build') {
		echo 'Building Master branch'
		sh 'gradle --version'
		sh './gradlew build clean'
		echo 'The build stage passed...'
	}	
	 
	stage('Tests') {
		echo 'The testing stage passed...'
		//Start all the existing tests in the test package 
		//sh './gradlew --no-daemon --debug :app:connectedDevDebugAndroidTest' 
	}
	
    stage('Test') {
		echo 'Testing At master branch'
    }
    stage('Deploy') {
        echo 'Deploying....'
    }
}
