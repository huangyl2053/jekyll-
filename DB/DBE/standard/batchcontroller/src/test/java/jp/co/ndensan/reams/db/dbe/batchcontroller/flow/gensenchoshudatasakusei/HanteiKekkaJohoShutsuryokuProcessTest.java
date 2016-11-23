/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.gensenchoshudatasakusei;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbe.batchcontroller.flow.DBE491001_NichijiShinchoku;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE491001.DBE491001_NichijiShinchokuParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshutsuryoku.HanteiKekkaJohoShutsuryokuProcessParamter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.batch.config.BatchSettings;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author n8343
 */
@RunWith(Enclosed.class)
public class HanteiKekkaJohoShutsuryokuProcessTest extends DbeTestDacBase {

    private static DbTestHelper dbHelper;
    private static DBE491001_NichijiShinchokuParameter parameter;
    private static BatchExitStatus result;
    private static final RString batchID = new RString("DBE491001_NichijiShinchoku");
    private static final RString batchName = new RString("判定結果情報出力Test");

    @BeforeClass
    public static void setUpClass() {
        dbHelper = new DbTestHelper();

    }

    public static class 判定結果情報出力Test extends DbeTestDacBase {

        @Test
        public void testes() {
            BatchFlowTestHelper testhelper = new BatchFlowTestHelper();
            BatchSettings bs = new BatchSettings();
            //result  = flowHelper.executeFlow(DBE491001_NichijiShinchoku.class, ShinchokuDataOutputProcess(), sqlSession);
            result = testhelper.executeFlow(batchID, batchName, DBE491001_NichijiShinchoku.class, ShinchokuDataOutputProcess(), bs);
            //assertThat(result);
        }
    }

    @AfterClass
    public static void afterTearDownClass() {

        DbeTestDacBase.afterTearDownClass();
    }

    private static HanteiKekkaJohoShutsuryokuProcessParamter creataKaigoKekkaTaishouIchiranHeadItem() {
        ArrayList<RString> list = new ArrayList<>();
        list.add(new RString("15226400000001981"));
        return new HanteiKekkaJohoShutsuryokuProcessParamter(list, new RString("20151104"), new RString("20161117"));
    }

    private static DBE491001_NichijiShinchokuParameter ShinchokuDataOutputProcess() {
        ArrayList<RString> list = new ArrayList<>();
        list.add(new RString("15226400000001981"));

        return new DBE491001_NichijiShinchokuParameter(list, new RString("1"));
    }

}
