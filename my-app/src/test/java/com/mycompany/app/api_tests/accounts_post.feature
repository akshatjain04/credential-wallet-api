# ********RoostGPT********

# Test generated by RoostGPT for test karate-nobel-prize-api-spec-test using AI Type Azure Open AI and AI Model roostgpt-4-32k
# 
# Feature file generated for /accounts_post for http method type POST 
# RoostTestHash=53e96f9805
# 
# 

# ********RoostGPT********
Feature: Create new Account API Test

Background:
  * url karate.properties['url.base'] || 'http://localhost:8080'

Scenario Outline: Validate new Account API - /accounts
  Given path '/accounts'
  And request <requestBody>
  And header commit-hash = <commitHash>
  When method post
  Then status <expectedStatus>
  And match responseHeaders contains { 'api-version': '#string', 'commit-hash': '#present'}
  And match response == <expectedResponse>

Examples:
  | requestBody                                                         | commitHash | expectedStatus | expectedResponse                                                                                       |
  | { "email": "validEmail@email.com" }                                 | 'a1b2c3d'  | 201           | {}                                                                                                     |
  | { "email": "invalidEmail" }                                         | 'a1b2c3d'  | 400           | {"error": "validation/email-pattern", "description": "#string", "value": "#notnull", "field": "email"} |
  | { "email": "missingAtSymbol@emailcom" }                             | 'a1b2c3d'  | 400           | {"error": "validation/email-pattern", "description": "#string"}                                        |
  | { "email": "missingDotAfterAtSymbol@emailcom" }                     | 'a1b2c3d'  | 400           | {"error": "validation/email-pattern", "description": "#string"}                                        |
  | { "email": "validEmailButInvalidCommitHash@email.com" }             | 'invalid'  | 400           | {"error": "validation/commit-hash-pattern", "description": "#string"}                                  |
  | { "email": "validEmailButMissingCommitHash@email.com" }             | null       | 400           | {"error": "validation/missing-commit-hash", "description": "#string"}                                  |
 