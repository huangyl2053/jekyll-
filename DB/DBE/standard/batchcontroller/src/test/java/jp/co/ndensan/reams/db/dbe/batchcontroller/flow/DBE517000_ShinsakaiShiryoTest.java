/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.util.Arrays;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE224001.DBE224001_NinteichosaDataOutputParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author N3010
 */
public class DBE517000_ShinsakaiShiryoTest {

    private static DBE224001_NinteichosaDataOutputParameter batchParameter;
    private static BatchFlowTestHelper batchFlowTestHelper;

    @BeforeClass
    public static void setUpClass() {
        DbeTestDacBase.beforeSetUpClass();
        batchFlowTestHelper = new BatchFlowTestHelper();
        batchParameter = setBatchParameter();
    }

    private static DBE224001_NinteichosaDataOutputParameter setBatchParameter() {
        DBE224001_NinteichosaDataOutputParameter param = new DBE224001_NinteichosaDataOutputParameter();

        param.setShichosonCode(RString.EMPTY);
        param.setShinseishoKanriNoList(Arrays.asList(new RString("00000000000001940"), new RString("15461720160100219"), new RString("000082")));
        param.setNinteiChosainCode(RString.EMPTY);
        param.setNinteichosaItakusakiCode(RString.EMPTY);
        return param;
    }

    @Test
    public void BatchExitStatusTest() {
        BatchExitStatus.Status status = batchFlowTestHelper.executeFlow(new RString("DBE224001_NinteichosaDataOutput"),
                new RString("認定調査データ出力（モバイル）"), DBE224001_NinteichosaDataOutput.class, batchParameter).getStatus();
        assertThat(status, is(BatchExitStatus.Status.SUCCESS));
    }
    
}
