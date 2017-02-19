/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE581001.DBE581001_EnkitsuchiParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DBE581001_Enkitsuchi}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DBE581001_EnkitsuchiTest extends DbeTestBase {

    private static BatchFlowTestHelper flowHelper;

    public static class バッチフローテスト extends DbeTestBase {

        @Before
        public void setUp() {
            flowHelper = new BatchFlowTestHelper();
        }

        @Test
        public void パラメーターが正しく設定されている場合_バッチフロー実施結果は_Successで返すこと() throws Exception {
            BatchExitStatus result = flowHelper.executeFlow(
                    new RString("DBE581001_Enkitsuchi"),
                    new RString("認定延期通知書"),
                    DBE581001_Enkitsuchi.class,
                    setBatchParameter());
            assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
        }

    }

    private static DBE581001_EnkitsuchiParameter setBatchParameter() {
        DBE581001_EnkitsuchiParameter param = new DBE581001_EnkitsuchiParameter();

        param.set処理見込み日From(FlexibleDate.MAX);
        param.set処理見込み日To(FlexibleDate.EMPTY);
        param.set文書番号(new RString("第         １号"));

        List<RString> shinseishoKanriNoList = new ArrayList<>();
        shinseishoKanriNoList.add(new RString("20973220150300181"));
        param.set申請書管理番号リスト(shinseishoKanriNoList);
        param.set画面モード(new RString("2"));

        List<FlexibleDate> tsuchishoHakkoYMD = new ArrayList<>();
        tsuchishoHakkoYMD.add(new FlexibleDate("20170216"));
        param.set通知書発行日(tsuchishoHakkoYMD);

        return param;
    }

}
