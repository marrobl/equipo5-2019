package es.uva.inf.tds.pr2;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
/**
 * Clase suite de todos los tests
 * 
 * @author silmont
 * @author marrobl
 *
 */
@RunWith(JUnitPlatform.class)
@SelectPackages({"es.uva.inf.tds.pr2"})
@IncludeTags({"TDD|BlackBox"})
@ExcludeTags({"Secuencia"})
public class TestSuiteAllTest {

}


