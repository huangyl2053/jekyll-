
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.ikenshoshujiiichiran;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.ikenshoshujiiichiran.IkenshoShujiiIchiranParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5911ShujiiIryoKikanJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5912ShujiiJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.ur.urz.definition.core.iryokikan.IryoKikanCode;
import jp.co.ndensan.reams.ur.urz.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * 調査委託先・調査員一覧表のバッチ処理のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IkenshoShujiiIchiranFlowTest extends DbeTestDacBase {

    private static BatchFlowTestHelper flowHelper;
    private static DbT5912ShujiiJohoDac dbT5912Dac;
    private static DbT5911ShujiiIryoKikanJohoDac dbT5911Dac;

    public static final RString 市町村コード = new RString("034002");
    public static final RString 市町村名 = new RString("01");
    public static final RString 主治医医療機関コードFrom = new RString("0340000001");
    public static final RString 主治医医療機関コードTo = new RString("0340000003");
    public static final RString 主治医コードFrom = new RString("11");
    public static final RString 主治医コードTo = new RString("13");
    public static final RString 状況 = new RString("1");
    public static final RString 並び順 = new RString("1");
    public static final RString 改頁 = new RString("1");

    @BeforeClass
    public static void setUpClass() {
    }

    public static class バッチフローテスト extends DbeTestDacBase {

        @Before
        public void setUp() {

//            flowHelper = new BatchFlowTestHelper();
//            dbT5912Dac = InstanceProvider.create(DbT5912ShujiiJohoDac.class);
//            dbT5911Dac = InstanceProvider.create(DbT5911ShujiiIryoKikanJohoDac.class);
        }

        @Test
        public void バッチデータPrint() throws Exception {
//            TestSupport.clearTable();
//            TestSupport.insert_DbT5911();
//            TestSupport.insert_DbT5912();
            setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBE認定支援);
            BatchExitStatus result = flowHelper.executeFlow(new RString("DBE591001_ShujiiIryokikanShujiiIchiranhyo"),
                    new RString("xx"),
                    IkenshoShujiiIchiranFlow.class, createParamter());
            assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
        }
    }

    private static IkenshoShujiiIchiranParameter createParamter() {
        IkenshoShujiiIchiranParameter param = new IkenshoShujiiIchiranParameter();
        param.setIryoKikanCodeFrom(主治医医療機関コードFrom);
        param.setIryoKikanCodeTo(主治医医療機関コードTo);
        param.setJyokyo(状況);
        param.setNextpage(改頁);
        param.setOutputSort(並び順);
        param.setShichosonCode(市町村コード);
        param.setShichosonName(市町村名);
        param.setShujiiCodeFrom(主治医コードFrom);
        param.setShujiiCodeTo(主治医コードTo);
        return param;
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBE認定支援.toString(), "test",
                new ReamsDonyuDantaiCode("209007"));
        FlowContext flowContext = createFlowContext("testFlowInstanceId", "testFlowId");
        when(flowContext.getExecutionSubGyomuCode()).thenReturn(executionSubGyomuCode);
        controlData.setFlowContext(flowContext);
        _ControlDataHolder.setControlData(controlData);

    }

    private static FlowContext createFlowContext(String flowInstanceId, String flowId) {
        FlowContext flowContext = Mockito.mock(FlowContext.class);
        Mockito.when(flowContext.getFlowInstanceId()).thenReturn(new FlowInstanceId(flowInstanceId));
        Mockito.when(flowContext.getFlowId()).thenReturn(new FlowId(flowId));
        return flowContext;

    }

    public static class TestSupport {

        public static void insert_DbT5911() {

            DbT5911ShujiiIryoKikanJohoEntity entity = new DbT5911ShujiiIryoKikanJohoEntity();
            entity.setShichosonCode(new LasdecCode(市町村コード));
            entity.setIryokikanCode(new IryoKikanCode(主治医医療機関コードFrom));
            entity.setShujiiIryokikanCode(主治医医療機関コードFrom);
            entity.setIryoKikanMeisho(new RString("主治医医療機関名称"));
            entity.setIryoKikanMeishoKana(new RString("主治医医療機関カナ"));
            entity.setFaxNo(new TelNo(new RString("123456")));
            entity.setDaihyoshaName(new RString("代表者名称"));
            entity.setDaihyoshaNameKana(new RString("代表者カナ"));
            entity.setYubinNo(new YubinNo(new RString("999-9999")));
            entity.setJokyoFlag(true);
            dbT5911Dac.save(entity);
        }

        public static void insert_DbT5912() {

            DbT5912ShujiiJohoEntity entity = new DbT5912ShujiiJohoEntity();
            entity.setShujiiCode(主治医コードFrom);
            entity.setShujiiIryokikanCode(主治医医療機関コードFrom);
            entity.setShichosonCode(new LasdecCode(市町村コード));
            entity.setShujiiCode(主治医コードFrom);
            entity.setShujiiKana(new AtenaKanaMeisho(new RString("主治医名称カナ")));
            //  entity.setShujiiName(new AtenaMeisho(new RString("主治医名称")));
            entity.setSeibetsu(new Code(new RString("1")));
            entity.setShinryokaName(new RString("所属名"));
            entity.setJokyoFlag(true);
            dbT5912Dac.save(entity);
        }

        public static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, "DbT5912ShujiiJoho");
            csvDataUtil.clearTable(sqlSession, "DbT5911ShujiiIryoKikanJoho");
        }
    }
}
