import static org.junit.Assert.assertEquals;


import org.junit.Ignore;
import org.junit.Test;

import com.google.java.contract.PreconditionError;
import com.google.java.contract.PostconditionError;
import com.google.java.contract.InvariantError;

//@Ignore
//@Test(expected = PreconditionError.class)
//@Test(expected = PostconditionError.class)

public class ProgramTest {
   
	@Test (expected = PreconditionError.class)
    public void testMinLengthPrecondition() {
    	PasswordCriteria cr = new PasswordCriteria();
    	cr.setMinLength(3);
    }
    
    @Test (expected = PreconditionError.class)
    public void testMaxLengthPrecondition() {
    	PasswordCriteria cr = new PasswordCriteria();
    	cr.setMaxLength(3);
    }

	@Test (expected = PreconditionError.class)
	public void testHasLettersAndHasNumbersCannotBeFalseAtTheSameTime() {
		PasswordCriteria cr = new PasswordCriteria();
		cr.setHasLetters(false);
		cr.setHasNumbers(false);
	}

	@Test (expected = PreconditionError.class)
	public void testHasMixedCasedCanBeEnabledOnlyIfHasLettersIsTrue() {
		PasswordCriteria criteria = new PasswordCriteria();
		criteria.setHasNumbers(true);
		criteria.setHasLetters(false);
		criteria.setHasMixedCase(true);
	}

	@Test 
    public void testIsValid() {
    	PasswordCriteria cr = new PasswordCriteria();
    	cr.isValid("ValidPa$$word");
    }

	@Test (expected = PreconditionError.class)
    public void testIsValidNullValue() {
    	PasswordCriteria cr = new PasswordCriteria();
    	cr.isValid(null);
    }
}
