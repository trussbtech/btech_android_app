node {
    stage('SCM') {
		echo 'Gathering code from version control'
		git branch: '${branch}', url: 'https://github.com/trussbtech/sample_android_app-java.git'
    }
    stage('Build') {
		echo 'Building. Development branch'
		sh 'gradle --version'
		sh 'chmod a+x ./gradlew'
		sh './gradlew clean'
		sh './gradlew build'
	}	
    stage('Test') {
		echo 'Testing At master branch'
		sh '.gradlew connectAndriodTesr'
    }
    stage('Deploy') {
        echo 'Deploying....'
    }
}
