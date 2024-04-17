import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification
import com.anacondong.pipeline.Git

class BuildJavaAppSpec extends JenkinsPipelineSpecification {
    def buildJavaApp = null

    def setup() {
        buildJavaApp = loadPipelineScriptForTest("vars/buildJavaApp.groovy")
    }

    def "Test run BuildJavaApp pipeline"() {
        setup:
            def body = Mock(Closure)
            def git = GroovyMock(Git.class, global: true)
            new Git(buildJavaApp) >> git
        when:
            buildJavaApp repo: "http://github.com/pipeline/examplerepo.git", body
        then:
            1 * git.checkout("http://github.com/pipeline/examplerepo.git")
            1 * getPipelineMock("sh")("./mvnw clean compile")
            1 * getPipelineMock("sh")("./mvnw test")
            1 * getPipelineMock("sh")("./mvnw verify")
            1 * getPipelineMock("sh")("./mvnw package -DskipTests=true")
            1 * body()
    }
}
