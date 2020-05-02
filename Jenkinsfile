node{
    Class.forName("com.mysql.jdbc.Driver")
    def sql = Sql.newInstance("jdbc:mysql://mysql:3306/test_db", "newuser","27Ballybrit", "com.mysql.jdbc.Driver")
    stage('SCM Checkout'){
        git 'https://github.com/Neil-Morrison/Software-Engeering-and-Test-project.git'
    }
    stage('Compile-Package'){
        sh 'mvn package'
    }
}