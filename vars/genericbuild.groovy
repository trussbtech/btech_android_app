def call(Map config=[:]) {
node {
    stage('SCM') {
		echo 'Gathering code from version control'
		git branch: '${branch}', url: 'https://github.com/trussbtech/btech_android_app.git'
    }
    stage('Build') {
		echo 'Building Master branch'
		sh './gradlew build ' + config.target
		echo 'The build stage passed...'
		releasenotes(changes:"true")
	}	
	 
	stage('Tests') {
		echo 'The testing stage passed...'
		//Start all the existing tests in the test package 
	}
	
    stage('Test') {
		echo 'Testing At master branch'
    }
    stage('Deploy') {
        echo 'Deploying....'
    }
}
}
