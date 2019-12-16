package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.ConsultaPessoaTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ConsultaPessoaTest.class,
})
public class RunnerConsultaPessoa {
}
