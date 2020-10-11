# UI

Execute with browser type and tag:
mvn clean test -Dtest=testRunner -Dcucumber.options="--tags @FunctionTest,@EndtoEndTest"  -DbrowserName=chrome

# API
mvn clean test -Dtest=PostageCalculationTest
