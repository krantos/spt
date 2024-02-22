package petstore.userStories;

import net.serenitybdd.annotations.WithTag;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import petstore.Base;
import petstore.userStories.actions.PetApiActions;

import java.math.BigInteger;

@ExtendWith(SerenityJUnit5Extension.class)
@WithTag("Acceptance Test")
public class WhenAUserAddsANewPetTest extends Base {

  @BeforeEach
  public void setup() {
    super.setup();
  }

  Long newPetId = null;
  BigInteger sessionId = null;
  PetApiActions petApi;

  @Test
  public void createsANewPetSuccessfully() {
    sessionId = petApi.givenIamAuthenticated("theUser", "XXXXXXXXXXX");
    newPetId = petApi.givenIAddMyNewPetSun(sessionId);
    petApi.whenIAskForAPetWithId(newPetId);
    petApi.thenIGetSunAsResult();
  }
}
