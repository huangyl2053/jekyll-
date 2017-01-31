/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.DBE220010_IraishoIkkatuParameter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.GridParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import static org.hamcrest.CoreMatchers.is;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author n9943
 */
public class DBE240001_NinteichosaIraishoTest {

    private static DBE220010_IraishoIkkatuParameter batchParameter;
    private static BatchFlowTestHelper batchFlowTestHelper;

    @BeforeClass
    public static void setUpClass() {
        DbeTestDacBase.beforeSetUpClass();
        batchFlowTestHelper = new BatchFlowTestHelper();
        batchParameter = setBatchParameter();
    }

    private static DBE220010_IraishoIkkatuParameter setBatchParameter() {
        DBE220010_IraishoIkkatuParameter param = new DBE220010_IraishoIkkatuParameter();
        List<GridParameter> ninteiChosaIraiList = new ArrayList<>();
        GridParameter gridParameter = new GridParameter();
        gridParameter.setNinteichosaItakusakiCode(new RString("0000000001"));
        gridParameter.setNinteiChosainCode(new RString("00000001"));
        gridParameter.setShoKisaiHokenshaNo(new RString("152264"));
        ninteiChosaIraiList.add(gridParameter);

        gridParameter = new GridParameter();
        gridParameter.setNinteichosaItakusakiCode(new RString("0000000002"));
        gridParameter.setNinteiChosainCode(new RString("00000002"));
        gridParameter.setShoKisaiHokenshaNo(new RString("209006"));
        ninteiChosaIraiList.add(gridParameter);

        gridParameter = new GridParameter();
        gridParameter.setNinteichosaItakusakiCode(new RString("0257844560"));
        gridParameter.setNinteiChosainCode(new RString("00000001"));
        gridParameter.setShoKisaiHokenshaNo(new RString("152264"));
        ninteiChosaIraiList.add(gridParameter);

        gridParameter = new GridParameter();
        gridParameter.setNinteichosaItakusakiCode(new RString("1234567890"));
        gridParameter.setNinteiChosainCode(new RString("0221002"));
        gridParameter.setShoKisaiHokenshaNo(new RString("209007"));
        ninteiChosaIraiList.add(gridParameter);

        gridParameter = new GridParameter();
        gridParameter.setNinteichosaItakusakiCode(new RString("1234567891"));
        gridParameter.setNinteiChosainCode(new RString("0221001"));
        gridParameter.setShoKisaiHokenshaNo(new RString("152264"));
        ninteiChosaIraiList.add(gridParameter);

        gridParameter = new GridParameter();
        gridParameter.setNinteichosaItakusakiCode(new RString("9999999999"));
        gridParameter.setNinteiChosainCode(new RString("88888888"));
        gridParameter.setShoKisaiHokenshaNo(new RString("209006"));
        param.setNinteiChosaIraiList(ninteiChosaIraiList);
        ninteiChosaIraiList.add(gridParameter);

        param.setIraiFromYMD(new RString("20160101"));
        param.setIraiToYMD(new RString("20161231"));

        param.set認定調査依頼一覧(true);

        param.set認定調査依頼書(true);
        param.set認定調査票_概況調査(true);
        param.set認定調査票_基本調査(true);
        param.set認定調査票_概況基本(true);
        param.set認定調査票_特記事項(true);
        param.set認定調査票_概況特記(true);
        param.set認定調査差異チェック票(true);
        param.set特記事項_調査群(true);
        param.set特記事項_フリータイプ(true);
        param.set認定調査依頼発行一覧(true);
        param.set認定調査依頼履歴一覧(true);

        param.setTeishutsuKigen(new RString("1"));
        param.setHakkobi(new RString("20170107"));
        return param;
    }

    @Test
    public void BatchExitStatusTest() {
        BatchExitStatus.Status status = batchFlowTestHelper.executeFlow(new RString("DBE240001_NinteichosaIraisho"),
                new RString("依頼書一括発行"), DBE240001_NinteichosaIraisho.class, batchParameter).getStatus();
        assertThat(status, is(BatchExitStatus.Status.SUCCESS));
    }

}
