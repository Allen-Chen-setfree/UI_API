# UI
Require Chrome v71-73 or Firefox v0.24.0 <br />
Execute with browser type and selected tests:<br />
mvn clean test -Dtest=testRunner -Dcucumber.options="--tags @FunctionTest,@EndtoEndTest"  -DbrowserName=chrome

# API
mvn clean test -Dtest=PostageCalculationTest
