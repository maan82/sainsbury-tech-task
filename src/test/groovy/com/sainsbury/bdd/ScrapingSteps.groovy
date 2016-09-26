package com.sainsbury.bdd

import com.sainsbury.AppRunner
import cucumber.api.DataTable

import static org.hamcrest.core.StringContains.containsString
import static org.junit.Assert.assertThat

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

class CustomWorld {
    def ByteArrayOutputStream result
}

World {
    new CustomWorld()
}

When(~/I run application/) { ->
    result = captureOutput()
    AppRunner.main([] as String[])
}


Then(~/console contains json with/) { DataTable table ->
    table.asMaps(String, String).eachWithIndex { row, index ->
        assertThat(result.toString(), containsString(row."TITLE"))
        assertThat(result.toString(), containsString(row."SIZE"))
        assertThat(result.toString(), containsString(row."UNIT_PRICE"))
        assertThat(result.toString(), containsString(row."DESCRIPTION"))
    }
}

Then(~/console contains total '([^"]*)'/) { String total ->
    assertThat(result.toString(), containsString("\"total\" : "+total))
}

private ByteArrayOutputStream captureOutput() {
    final ByteArrayOutputStream output = new ByteArrayOutputStream()
    System.setOut(new PrintStream(output))
    return output
}
