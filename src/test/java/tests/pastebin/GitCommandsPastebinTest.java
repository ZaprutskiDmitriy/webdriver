package tests.pastebin;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class GitCommandsPastebinTest extends BaseTest {

    @Test
    public void pastebinTest() {

        mainPage.openPage()
                .pasteCode("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force")
                .selectSyntaxHighlighting()
                .selectExpiration()
                .pasteTitle("how to gain dominance among developers")
                .submitForm()
                .isPageOpened();

//        assertTrue(pastePage.getPasteTitle().contains("how to gain dominance among developers"), "Titles don't match");
        assertThat(pastePage.getPasteTitle(), is(containsString("how to gain dominance among developers")));

        assertEquals(pastePage.getCodeHighlightedTag(), "Bash", "Highlighted code tags don't match");
        assertEquals(pastePage.getCode(), "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force", "Codes don't match");
    }
}
