Feature: testing parallel

@chrome @testng
Scenario: test parallel flipkart
Given launch url "https://www.flipkart.com"

@chrome @testng
Scenario: test parallel amazon
Given launch url "https://www.amazon.com"

@chrome @testng
Scenario: test parallel google
Given launch url "https://www.google.com"

@chrome @testng
Scenario: test parallel yahoo
Given launch url "https://www.yahoo.com"