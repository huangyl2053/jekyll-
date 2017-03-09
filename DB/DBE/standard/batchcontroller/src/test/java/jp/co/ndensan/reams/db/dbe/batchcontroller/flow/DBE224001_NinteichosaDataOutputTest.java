/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE224001.DBE224001_NinteichosaDataOutputParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;

/**
 * {@link DBE224001_NinteichosaDataOutput}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DBE224001_NinteichosaDataOutputTest extends DbeTestDacBase {

    private static DBE224001_NinteichosaDataOutputParameter batchParameter;
    private static BatchFlowTestHelper batchFlowTestHelper;

    @BeforeClass
    public static void setUpClass() {
        DbeTestDacBase.beforeSetUpClass();
        batchFlowTestHelper = new BatchFlowTestHelper();
        batchParameter = setBatchParameter();
    }

    @PrepareForTest({DBE224001_NinteichosaDataOutput.class})
    public static class バッチフローテスト extends DbeTestDacBase {


    @Test
    public void BatchExitStatusTest() {
        BatchExitStatus.Status status = batchFlowTestHelper.executeFlow(new RString("DBE224001_NinteichosaDataOutput"),
                new RString("審査会資料一括作成"), DBE224001_NinteichosaDataOutput.class, batchParameter).getStatus();
        assertThat(status, is(BatchExitStatus.Status.SUCCESS));
        }
    }

    private static DBE224001_NinteichosaDataOutputParameter setBatchParameter() {
        DBE224001_NinteichosaDataOutputParameter param = new DBE224001_NinteichosaDataOutputParameter();

        param.setAddedFileName(new RString("0000000001"));
        param.setTempFilePath(new RString("/home/D209007/tmp/~TMP_c811db7a-97d0-4e40-8979-8a801b8ae1ad"));

        param.setShichosonCode(new RString("202118"));

        List<RString> shinseishoKanriNoList = new ArrayList<>();
        shinseishoKanriNoList.add(new RString("20211920150400041"));
        shinseishoKanriNoList.add(new RString("20211920150500384"));
        shinseishoKanriNoList.add(new RString("20211920150200059"));
        shinseishoKanriNoList.add(new RString("20211920150400076"));
        shinseishoKanriNoList.add(new RString("20211920150100029"));
        shinseishoKanriNoList.add(new RString("20211920131200484"));
        param.setShinseishoKanriNoList(shinseishoKanriNoList);

        List<RString> hihokenshaNoList = new ArrayList<>();
        hihokenshaNoList.add(new RString("0000329576"));
        hihokenshaNoList.add(new RString("0002149541"));
        hihokenshaNoList.add(new RString("0002139936"));
        hihokenshaNoList.add(new RString("0000023621"));
        hihokenshaNoList.add(new RString("0000141500"));
        hihokenshaNoList.add(new RString("0000106267"));
        param.setHihokenshaNoList(hihokenshaNoList);
        param.setNinteiChosainCode(null);
        param.setNinteichosaItakusakiCode(new RString("0000000001"));

        return param;
    }
}
