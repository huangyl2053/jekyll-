/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.util.Arrays;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE224001.DBE224001_NinteichosaDataOutputParameter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE517000.DBE517000_ShinsakaiShiryoParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * {@link DBE224001_NinteichosaDataOutput}のテストクラスです。
 */
@Ignore
public class DBE224001_NinteichosaDataOutputTest {

    private static DBE517000_ShinsakaiShiryoParameter batchParameter;
    private static BatchFlowTestHelper batchFlowTestHelper;

    @BeforeClass
    public static void setUpClass() {
        DbeTestDacBase.beforeSetUpClass();
        batchFlowTestHelper = new BatchFlowTestHelper();
        batchParameter = setBatchParameter();
    }

    private static DBE517000_ShinsakaiShiryoParameter setBatchParameter() {
        DBE517000_ShinsakaiShiryoParameter param = new DBE517000_ShinsakaiShiryoParameter();

        param.setChoyoJimu_sonotaSiryoFalg(new RString("1"));
        param.setChoyoJimu_itiziHanteiFalg(new RString("0"));
        param.setChoyoJimu_ikenshoFalg(new RString("0"));
        param.setChoyoJimu_hanteiFalg(new RString("0"));
        param.setChoyoJimu_taishoushaFalg(new RString("1"));
        param.setChoyoJimu_gaikyouTokkiFalg(new RString("0"));
        param.setChoyoJimu_gaikyouTokkiIranFalg(new RString("0"));
        param.setChoyoJimu_tokkiJikouHanteiFalg(new RString("0"));
        param.setChoyoJimu_tokkiJikouFalg(new RString("0"));
        param.setShinsakaiKaisaiYoteiYMD(new FlexibleDate("20161227"));
        param.setShinsakaiKaisaiNo(new RString("00000118"));
        param.setShinsakaiKaishiYoteiTime(new RString("10:00:00.000"));
        param.setSakuseiJoken(new RString("範囲指定"));
        param.setShuturyokuSutairu(new RString("1"));
        param.setShuturyokuJun(new RString("審査順"));
        param.setPrintHou(new RString("1"));
        param.setGogitaiName(new RString("第０１合議体"));
        param.setGogitaiNo(1);
        param.setChohyoIin_sonotaSiryoFalg(new RString("0"));
        param.setChohyoIin_itiziHanteiFalg(new RString("0"));
        param.setChohyoIin_ikenshoFalg(new RString("0"));
        param.setChohyoIin_hanteiFalg(new RString("0"));
        param.setChohyoIin_taishoushaFalg(new RString("1"));
        param.setChohyoIin_tuutishoFalg(new RString("0"));
        param.setChohyoIin_tokkiJikouHanteiFalg(new RString("0"));
        param.setChohyoIin_tokkiJikouFalg(new RString("0"));
        param.setBangoStart(1);
        param.setBangoEnd(99999);

        return param;
    }

    @Test
    public void BatchExitStatusTest() {
        BatchExitStatus.Status status = batchFlowTestHelper.executeFlow(new RString("DBE517000_ShinsakaiShiryo"),
                new RString("審査会資料一括作成"), DBE517000_ShinsakaiShiryo.class, batchParameter).getStatus();
        assertThat(status, is(BatchExitStatus.Status.SUCCESS));
    }
}
