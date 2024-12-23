# Automation Testing For Pay Active

How to run the test:

1. Set up Java and Maven on your machine
2. Add environment variables on the system in environment.properties file
   - `app.env = local`
   - `app.browser = chrome`
   - `headless = false`
   - `login.url = Need to provide the login URL`
   - `data.test = Need to provide the data test`
   
3. Add environment.properties path in the maven command
   - `mvn clean test -Denvironment.config=src/test/resources/environment.properties`
4. Run command maven command in the terminal
