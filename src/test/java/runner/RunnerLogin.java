package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.LoginTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
})
public class RunnerLogin {
}
