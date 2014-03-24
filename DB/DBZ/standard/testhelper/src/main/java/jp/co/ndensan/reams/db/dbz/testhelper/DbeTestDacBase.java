package jp.co.ndensan.reams.db.dbz.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase3;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * {@link TestDacBase}のラッパークラスです。
 *
 * @author N1013 松本直樹
 */
public class DbeTestDacBase extends TestDacBase3 {

    @Override
    public RString getSubGyomuCD() {
        return new RString("DBE");
    }

    @BeforeClass
    public static void beforeSetUpClass() {
        setDummyControlData(new RString("DB"));
        openMainSession();
    }

    @After
    public void afterTearDown() {
        rollback();
    }

    @AfterClass
    public static void afterTearDownClass() {
        closeSession();
    }
}
