package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Program.Immigration;

class IssueVisaUseCase {

	@Test
	void testIssueVisitVisa() throws Exception {
		Immigration obj = new Immigration();
		assertEquals("Passport3Name", obj.issueVisitVisa("Name", "Passport"));
	
	}

}




