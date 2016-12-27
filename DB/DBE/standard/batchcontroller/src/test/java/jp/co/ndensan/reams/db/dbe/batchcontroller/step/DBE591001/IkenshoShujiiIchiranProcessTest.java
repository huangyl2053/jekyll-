/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE591001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.ikenshoshujiiichiran.IkenshoShujiiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchProcessTestHelper;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link IkenshoShujiiIchiranProcess}のテストクラスです。
 *
 */
@Ignore
@RunWith(Enclosed.class)
public class IkenshoShujiiIchiranProcessTest extends DbeTestDacBase {

    private static DbAccessorNormalType dbAccessor;
    private static DbTestHelper dbHelper;

    @BeforeClass
    public static void setUp() {
        dbHelper = new DbTestHelper();
    }

    @Override
    public void afterTearDown() {
        super.afterTearDown();
    }

    public static class processTest {

        @Test
        public void BatchExitStatusTest() {
            IkenshoShujiiIchiranProcessParameter paramter
                    = IkenshoShujiiIchiranProcessParameter.to主治医一覧表作成ProcessParameter(
                            new RString("999999"),
                            new RString("電算市"),
                            RString.EMPTY,
                            RString.EMPTY,
                            RString.EMPTY,//new RString("206024"),
                            RString.EMPTY,
                            new RString("3"),
                            new RString("1"),
                            new RString("1")
                    );

            BatchProcessTestHelper.execute(
                    IkenshoShujiiIchiranProcess.class,
                    paramter,
                    sqlSession);
        }
    }
}
