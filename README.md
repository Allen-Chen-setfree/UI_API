# UI

Execute with browser type and selected tests:<br />
mvn clean test -Dtest=testRunner -Dcucumber.options="--tags @FunctionTest,@EndtoEndTest"  -DbrowserName=chrome

# API
mvn clean test -Dtest=PostageCalculationTest
