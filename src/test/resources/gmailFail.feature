Feature: Gmail Fail login

Scenario Outline: Loggin to Gmail

        Given user navigates to Google once more

        When I enter Login as <login> and wrong password as <password>

        Then The login should be unsuccesfull



        Examples:
        |         login        |password |
        |surfakeemail@gmail.com|1111     |