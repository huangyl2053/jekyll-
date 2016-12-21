/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE592001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.itakusakichosainichiran.ItakusakiChosainIchiranQueryProcessParemeter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchProcessTestHelper;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link ItakusakiChosainIchiranQueryProcess}のテストクラスです。
 *
 */
@Ignore
@RunWith(Enclosed.class)
public class ItakusakiChosainIchiranQueryProcessTest extends DbeTestDacBase {

    private static DbAccessorNormalType dbAccessor;
    private static DbTestHelper dbHelper;

    @BeforeClass
    public static void setUp() {
        dbHelper = new DbTestHelper();
    }

    @AfterClass
    public static void tearDown() {
    }

    @Override
    public void afterTearDown() {
        super.afterTearDown();
    }

    public static class processTest {

        @Test
        public void BatchExitStatusTest() {
            ItakusakiChosainIchiranQueryProcessParemeter paramter
                    = new ItakusakiChosainIchiranQueryProcessParemeter(
                            new RString("206024"),
                            new RString("市町村名称"),
                            new RString(""),
                            new RString(""),
                            RString.EMPTY,//new RString("99999990"),
                            new RString("99999999"),
                            new RString("3"),
                            new RString("1"),
                            new RString("1")
                    );

            BatchProcessTestHelper.execute(
                    ItakusakiChosainIchiranQueryProcess.class,
                    paramter,
                    sqlSession);
        }
    }
}
