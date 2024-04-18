@Grab('org.yaml:snakeyaml:1.29') // Import SnakeYAML library for YAML parsing

import org.yaml.snakeyaml.Yaml

// Define the path to your YAML file
def yamlFilePath = './example.yaml'

// Read the YAML file
def yaml = new Yaml()
def yamlData = new File(yamlFilePath).text

// Parse the YAML data
def parsedYaml = yaml.load(yamlData)

// Print all properties
printYamlProperties(parsedYaml)


def printYamlProperties(data) {
    data.each { key, value ->
        println "${key}: ${value}"
    }
}
