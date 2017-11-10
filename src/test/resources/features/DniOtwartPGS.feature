Feature: Open days in PGS Software
  As an pgs Eployee
  I want to present how tests are automated in our company using automated test
  So that I will not have to explain everything on my own

  @DniOtwartePgs @t
  Scenario Outline: DniOtwartePgs
    Given WikiPageIsOpened '<repeat>'

    Examples:
      | repeat |
      | true   |
