package com.example.demo;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.example.demo") // Runs tests from all subpackages
public class AllTestsSuite {
}
