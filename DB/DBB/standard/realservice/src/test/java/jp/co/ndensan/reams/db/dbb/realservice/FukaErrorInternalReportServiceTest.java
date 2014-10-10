/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.FukaError;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorInternalReport;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorInternalReportItem;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.model.FukaErrorModel;
import jp.co.ndensan.reams.db.dbb.persistence.basic.FukaErrorListDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.ur.urz.business.internalreport.IInternalReportCommon;
import jp.co.ndensan.reams.ur.urz.model.IInternalReportCommonModel;
import jp.co.ndensan.reams.ur.urz.realservice.internalreport.IInternalReportService;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * 賦課エラー一覧内部帳票の情報を取得するサービスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class FukaErrorInternalReportServiceTest extends DbbTestBase {

    private static FukaErrorInternalReportService sut;

    public static class getFukaErrorInternalReport extends DbbTestBase {

        private final int entityNum = 10;

        @Before
        public void setUpBeforeClass() {
            sut = new FukaErrorInternalReportService(createMockSelectListDac(entityNum), createMockService());
        }

        @Test
        public void dacから10件のFukaErrorListEntityが取得できた場合_戻り値のFukaErrorReportは10件の賦課エラー一覧項目を持つ() {
            FukaErrorInternalReport result = sut.getFukaErrorInternalReport(RDateTime.of(1999, 12, 12, 8, 45));
            assertThat(result.getInternalReportItemList().size(), is(entityNum));

        }
    }

    public static class getFukaErrorInternalReportItem extends DbbTestBase {

        private final FlexibleYear fukaNendo_1999 = new FlexibleYear("1999");
        private final TsuchishoNo tsuchishoNo_0123 = new TsuchishoNo(new RString("0123"));

        @Before
        public void setUpBeforeClass() {
        }

        @Test
        public void 賦課年度に1999を指定した場合_dacから取得した賦課エラー一覧情報は_賦課年度に1999を持つ() {
            sut = new FukaErrorInternalReportService(createMockSelectDac(fukaNendo_1999, tsuchishoNo_0123), createMockService());
            assertThat(sut.getFukaErrorInternalReportItem(fukaNendo_1999, tsuchishoNo_0123).get賦課年度(), is(fukaNendo_1999));
        }

        @Test
        public void 処理区分に未処理以外が設定されている情報を_dacから取得できた場合_falseを返す() {
            sut = new FukaErrorInternalReportService(createMockSelectDac(fukaNendo_1999, tsuchishoNo_0123), createMockService());
            assertThat(sut.getFukaErrorInternalReportItem(fukaNendo_1999, tsuchishoNo_0123).get通知書番号(), is(tsuchishoNo_0123));
        }
    }

    public static class save extends DbbTestBase {

        private FukaErrorInternalReport report;
        private SubGyomuCode subGyomuCode;
        private FukaErrorModel model;
        private FukaErrorInternalReportItem reportItem;

        @Before
        public void setUp() {
            subGyomuCode = SubGyomuCode.DBB介護賦課;
            reportItem = new FukaErrorInternalReportItem(new FukaErrorModel());
        }

        @Test
        public void entityのupdateに成功して_dacから1が戻ってきた場合_saveはtrueを返す() {
            sut = new FukaErrorInternalReportService(createMockDeleteDac(1), null);
            assertThat(sut.remove(reportItem), is(true));
        }

        @Test
        public void entityのupdateに失敗し_dacから1以外の値が戻ってきた場合_saveはfalseを返す() {
            sut = new FukaErrorInternalReportService(createMockDeleteDac(0), null);
            assertThat(sut.remove(reportItem), is(false));
        }

    }

    public static class remove extends DbbTestBase {

        private FukaErrorInternalReport report;
        private SubGyomuCode subGyomuCode;
        private FukaErrorModel model;
        private FukaErrorInternalReportItem reportItem;

        @Before
        public void setUp() {
            subGyomuCode = SubGyomuCode.DBB介護賦課;
            reportItem = new FukaErrorInternalReportItem(new FukaErrorModel());
        }

        @Test
        public void entityのdeleteに成功して_dacから1が戻ってきた場合_removeはtrueを返す() {
            sut = new FukaErrorInternalReportService(createMockDeleteDac(1), null);
            assertThat(sut.remove(reportItem), is(true));
        }

        @Test
        public void entityのdeleteに失敗し_dacから1以外の値が戻ってきた場合_removeはfalseを返す() {
            sut = new FukaErrorInternalReportService(createMockDeleteDac(0), null);
            assertThat(sut.remove(reportItem), is(false));
        }

    }

    private static FukaErrorListDac createMockSelectListDac(int num) {
        FukaErrorListDac dac = mock(FukaErrorListDac.class);
        when(dac.select(any(RDateTime.class))).thenReturn(createEntityList(num));
        return dac;
    }

    private static FukaErrorListDac createMockSelectDac(FlexibleYear fukaNendo, TsuchishoNo tsuchishoNo) {
        FukaErrorListDac dac = mock(FukaErrorListDac.class);
        when(dac.select(fukaNendo, tsuchishoNo))
                .thenReturn(createEntity(fukaNendo, tsuchishoNo));
        return dac;
    }

    private static List<DbT2010FukaErrorListEntity> createEntityList(int num) {
        List<DbT2010FukaErrorListEntity> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(createEntity(new FlexibleYear("2014"), new TsuchishoNo(new RString("01111")),
                    new FukaError(Code.EMPTY, RString.EMPTY, RString.EMPTY),
                    new KaigoHihokenshaNo(new RString("1234500001")), new ShikibetsuCode("012345678900001")));
        }
        return list;
    }

    private static DbT2010FukaErrorListEntity createEntity(FlexibleYear fukaNendo, TsuchishoNo tsuchishoNo, FukaError error,
            KaigoHihokenshaNo hihokenshaNo, ShikibetsuCode shikibetsuCode) {
        DbT2010FukaErrorListEntity entity = new DbT2010FukaErrorListEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        entity.setInternalReportId(new RString("0123"));
        entity.setInternalReportCreationDateTime(RDateTime.of(1999, 12, 12, 12, 12));
        entity.setBatchId(new RString("0001"));
        entity.setBatchStartingDateTime(RDateTime.MAX);
        entity.setFukaNendo(fukaNendo);
        entity.setTsuchishoNo(tsuchishoNo);
        entity.setErrorCode(error.getCode());
        entity.setHihokenshaNo(hihokenshaNo);
        entity.setShikibetsuCode(shikibetsuCode);
        entity.setShoriKubunCode(new Code("0"));
        return entity;
    }

    private static DbT2010FukaErrorListEntity createEntity(FlexibleYear fukaNendo, TsuchishoNo tsuchishoNo) {
        DbT2010FukaErrorListEntity entity = createEntity(fukaNendo, tsuchishoNo,
                new FukaError(Code.EMPTY, RString.EMPTY, RString.EMPTY), KaigoHihokenshaNo.NULL_VALUE, ShikibetsuCode.EMPTY);
        return entity;
    }

    private static IInternalReportService createMockService() {
        IInternalReportCommon commonInfo = mock(IInternalReportCommon.class);

        IInternalReportService service = mock(IInternalReportService.class);
        when(service.createInternalReportCommonForReport(any(IInternalReportCommonModel.class))).thenReturn(commonInfo);
        return service;
    }

    private static FukaErrorListDac createMockDeleteDac(int result) {
        FukaErrorListDac dac = mock(FukaErrorListDac.class);
        when(dac.delete(any(DbT2010FukaErrorListEntity.class))).thenReturn(result);
        return dac;
    }
}
