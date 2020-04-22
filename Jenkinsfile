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
    stage('Test') {
		echo 'Testing At master branch'
		ecoh "sh './gradlew test'"
    }
    stage('Deploy') {
        echo 'Deploying....'
    }
}
