Feature: Gmail login

Scenario Outline: Loggin to Gmail

        Given user navigates to Google

        When I enter Login as <login> and password as <password>

        Then The login should be succesfull

        Then Send letter and delete it

        Examples:
        |         login        |password |
        |surfakeemail@gmail.com|Fake123456|