# Java Config Library

A versatile Java library for managing application configurations. This library supports hierarchical configuration loading from multiple sources, dynamic reloading of configuration files, encryption of sensitive configuration values, and validation of configuration values against a schema.

## Features

- **Hierarchical Configuration**: Manage configurations from multiple sources including JSON, YAML, and Properties files.
- **Dynamic Reloading**: Automatically reload configurations when files change, without restarting the application.
- **Encryption**: Secure sensitive configuration values with AES encryption and decryption.
- **Profiles**: Switch between different configuration profiles for various environments.
- **Validation**: Validate configuration values against a schema to ensure correctness.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
  - [ConfigManager](#configmanager)
  - [ConfigEncryptor](#configencryptor)
  - [FileWatcher](#filewatcher)
  - [ProfileManager](#profilemanager)
  - [ConfigValidator](#configvalidator)
- [License](#license)
- [Contributing](#contributing)
- [Author](#author)

## Installation

1. Clone the repository:
   `git clone https://github.com/hmRemi/java-config-library.git`

2. Navigate to the project directory:
   `cd java-config-library`

3. Build the project with Maven:
   `mvn clean install`

## Usage

### ConfigManager

`ConfigManager` handles loading configurations from multiple sources and retrieving values.

#### Example

```java
import dev.revere.configmanager.ConfigManager;
import dev.revere.configmanager.format.JsonConfigSource;

import java.io.File;

public class Example {
    public static void main(String[] args) throws Exception {
        ConfigManager configManager = new ConfigManager();
        configManager.addSource(new JsonConfigSource(new File("config.json")));
        configManager.loadConfig();

        String value = configManager.getValue("someKey");
        System.out.println(value);
    }
}
```

### ConfigEncryptor

`ConfigEncryptor` provides methods to encrypt and decrypt sensitive configuration values.

#### Example

```java
import dev.revere.configmanager.encryption.ConfigEncryptor;

public class Example {
    public static void main(String[] args) throws Exception {
        String secretKey = "YourBase64EncodedSecretKey";
        ConfigEncryptor encryptor = new ConfigEncryptor(secretKey);

        String encryptedValue = encryptor.encryptConfigValue("mySensitivePassword");
        System.out.println("Encrypted Value: " + encryptedValue);

        String decryptedValue = encryptor.decryptConfigValue(encryptedValue);
        System.out.println("Decrypted Value: " + decryptedValue);
    }
}
```

### ProfileManager

`ProfileManager` allows switching between different configuration profiles.

#### Example

```java
import dev.revere.configmanager.profile.ProfileManager;
import dev.revere.configmanager.format.JsonConfigSource;

import java.io.File;

public class Example {
    public static void main(String[] args) throws Exception {
        ProfileManager profileManager = new ProfileManager();
        profileManager.addProfile("dev", new JsonConfigSource(new File("dev-config.json")));
        profileManager.addProfile("prod", new JsonConfigSource(new File("prod-config.json")));

        profileManager.activateProfile("prod");
        String value = profileManager.getProfileValue("someKey");
        System.out.println(value);
    }
}
```

### ConfigValidator

`ConfigValidator` validates configuration values against a schema.

#### Example

```java
import com.revere.configmanager.validation.ConfigValidator;

import java.util.Map;

public class Example {
    public static void main(String[] args) {
        Map<String, String> schema = Map.of("someKey", "integer");
        ConfigValidator validator = new ConfigValidator(schema);

        Map<String, String> configMap = Map.of("someKey", "123");
        boolean isValid = validator.validate(configMap);
        System.out.println(isValid ? "Valid Config" : "Invalid Config");
    }
}
```

## License

For an open-source license that requires attribution to Revere Development, the [MIT License](https://opensource.org/licenses/MIT) is a suitable choice. Here is the license text with the necessary attribution:

```text
MIT License

Copyright (c) 2024 Revere Development

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

## Contributing

We welcome contributions from the community! If you'd like to contribute to the project, please follow these steps:

1. **Fork the Project:** Start by forking the project to your own GitHub account using the "Fork" button at the top right of this repository.
2. **Create a New Branch:** Create a new branch in your forked repository. This branch will be dedicated to your feature, enhancement, or bug fix.
3. **Make Changes:** Implement your desired changes, whether it's a new feature, improvement, or fixing a bug. Please ensure your code adheres to the project's coding standards.
4. **Commit Your Changes:** Commit your changes with clear and concise commit messages that describe the purpose of each change.
5. **Push to Your Fork:** Push your changes to your forked repository on GitHub.
6. **Create a Pull Request:** Once you've pushed your changes to your fork, go to the original repository and create a pull request. Provide a detailed description of your changes and why they are valuable.

## Author

The Java Config Library is developed and maintained by Revere Development. For any inquiries or to get in touch with the team, you can reach us at:

- **Website**: [revere.dev](https://www.revere.dev)
- **Email**: [support@revere.dev](mailto:support@revere.dev)

Thank you for using and contributing to the Java Config Library!
