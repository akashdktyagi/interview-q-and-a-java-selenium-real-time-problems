Feature: Test Feature

  @Sanity @ui
  Scenario: My Scenario1 - Sanity Only
    Given I am Scenario1 Sanity Only

  @Sanity @ui
  Scenario: My Scenario2 - Sanity Only
    Given I am Scenario2 Sanity Only

  @Regression @ui
  Scenario: My Scenario3 - Regression Only
    Given I am Scenario3 Regression Only

  @Regression @api @ui
  Scenario: My Scenario4 - Regression Only
    Given I am Scenario4 Regression Only

  @Sanity @Regression @ui
  Scenario: My Scenario5 - Sanity and Regression both
    Given I am Scenario5 Sanity and Regression both

  @Sanity @Regression @api
  Scenario: My Scenario6 - Sanity and Regression both
    Given I am Scenario6 Sanity and Regression both

  @Sanity @Regression @ui
  Scenario: My Scenario7 - Sanity and Regression both
    Given I am Scenario7 Sanity and Regression both

  @Sanity @Regression @api
  Scenario: My Scenario8 - Sanity and Regression both
    Given I am Scenario8 Sanity and Regression both