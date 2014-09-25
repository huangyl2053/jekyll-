/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.FukaError;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorReport;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorReportItem;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.persistence.basic.FukaErrorListDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportBatchInfo;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportInfo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.InternalReportShoriKubun;
import jp.co.ndensan.reams.ur.urz.realservice.internalreport.IInternalReportBatchInfoService;
import jp.co.ndensan.reams.ur.urz.realservice.internalreport.IInternalReportInfoService;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
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
public class FukaErrorReportServiceTest extends DbbTestBase {

    private static FukaErrorReportService sut;

    public static class getFukaErrorReport extends DbbTestBase {

        private final int entityNum = 10;

        @Before
        public void setUpBeforeClass() {
            sut = new FukaErrorReportService(createMockSelectListDac(entityNum), createMockReportInfoService(), createMockBatchInfoService());
        }

        @Test
        public void dacから10件のFukaErrorListEntityが取得できた場合_戻り値のFukaErrorReportは10件の賦課エラー一覧項目を持つ() {
            FukaErrorReport result = sut.getFukaErrorReport(RDateTime.of(1999, 12, 12, 8, 45));
            assertThat(result.getItemList().size(), is(entityNum));

        }
    }

    public static class canErrorShusei extends DbbTestBase {

        private final RYear fukaNendo = new RYear(1999);
        private final RString tsuchishoNo = new RString("0123");

        @Before
        public void setUpBeforeClass() {
        }

        @Test
        public void 処理区分に未処理が設定されている情報を_dacから取得できた場合_trueを返す() {
            sut = new FukaErrorReportService(createMockSelectDac(InternalReportShoriKubun.未処理), createMockReportInfoService(), createMockBatchInfoService());
            assertThat(sut.canErrorShusei(fukaNendo, tsuchishoNo), is(true));
        }

        @Test
        public void 処理区分に未処理以外が設定されている情報を_dacから取得できた場合_falseを返す() {
            sut = new FukaErrorReportService(createMockSelectDac(InternalReportShoriKubun.処理中), createMockReportInfoService(), createMockBatchInfoService());
            assertThat(sut.canErrorShusei(fukaNendo, tsuchishoNo), is(false));
        }
    }

    public static class remove extends DbbTestBase {

        private FukaErrorReport report;
        private SubGyomuCode subGyomuCode;
        private InternalReportInfo reportInfo;
        private InternalReportBatchInfo batchInfo;
        private List<FukaErrorReportItem> reportItemList;

        private FukaErrorReportItem reportItem;
        private RYear fukaNendo;
        private RString tsuchishoNo;
        private FukaError error;
        private KaigoHihokenshaNo hihokenshaNo;
        private ShikibetsuCode shikibetsuCode;
        private InternalReportShoriKubun shoriKubun;

        @Before
        public void setUp() {
            subGyomuCode = SubGyomuCode.DBB介護賦課;
            reportInfo = new InternalReportInfo(new RString("0001"), new RString("reportName"), RDateTime.of(1999, 12, 12, 3, 12, 34));
            batchInfo = new InternalReportBatchInfo(new RString("0002"), new RString("batchName"), RDateTime.of(1999, 12, 12, 3, 12, 34));
            reportItemList = new ArrayList<>();

            fukaNendo = new RYear(1999);
            tsuchishoNo = new RString("00000123");
            error = new FukaError(new Code("0123"), RString.EMPTY, RString.EMPTY);
            hihokenshaNo = new KaigoHihokenshaNo(new RString("0123400001"));
            shikibetsuCode = new ShikibetsuCode("012345678900001");
            shoriKubun = InternalReportShoriKubun.処理無し;

            reportItem = new FukaErrorReportItem(fukaNendo, tsuchishoNo, error, hihokenshaNo, shikibetsuCode, shoriKubun);
            reportItemList.add(reportItem);
            report = new FukaErrorReport(subGyomuCode, reportInfo, batchInfo, reportItemList);
        }

        @Test
        public void entityのdeleteに成功して_dacから1が戻ってきた場合_removeはtrueを返す() {
            sut = new FukaErrorReportService(createMockDeleteDac(1), null, null);
            assertThat(sut.remove(report, report.getItemList().get(0)), is(true));
        }

        @Test
        public void entityのdeleteに失敗し_dacから1以外の値が戻ってきた場合_removeはfalseを返す() {
            sut = new FukaErrorReportService(createMockDeleteDac(0), null, null);
            assertThat(sut.remove(report, report.getItemList().get(0)), is(false));
        }

    }

    private static FukaErrorListDac createMockSelectListDac(int num) {
        FukaErrorListDac dac = mock(FukaErrorListDac.class);
        when(dac.select(any(RDateTime.class))).thenReturn(createEntityList(num));
        return dac;
    }

    private static FukaErrorListDac createMockSelectDac(InternalReportShoriKubun shoriKubun) {
        FukaErrorListDac dac = mock(FukaErrorListDac.class);
        when(dac.select(any(RYear.class), any(RString.class)))
                .thenReturn(createEntity(shoriKubun));
        return dac;
    }

    private static List<DbT2010FukaErrorListEntity> createEntityList(int num) {
        List<DbT2010FukaErrorListEntity> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(createEntity(new RYear(2014), new RString("01111"), new FukaError(Code.EMPTY, RString.EMPTY, RString.EMPTY),
                    new KaigoHihokenshaNo(new RString("1234500001")), new ShikibetsuCode("012345678900001")));
        }
        return list;
    }

    private static DbT2010FukaErrorListEntity createEntity(RYear fukaNendo, RString tsuchishoNo, FukaError error,
            KaigoHihokenshaNo hihokenshaNo, ShikibetsuCode shikibetsuCode) {
        DbT2010FukaErrorListEntity entity = new DbT2010FukaErrorListEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        entity.setInternalReportId(new RString("0123"));
        entity.setListCreationDateTime(RDateTime.of(1999, 12, 12, 12, 12));
        entity.setBatchId(new RString("0001"));
        entity.setBatchStartingDateTime(RDateTime.MAX);
        entity.setFukaNendo(new FlexibleYear(fukaNendo.toDateString()));
        entity.setTsuchishoNo(tsuchishoNo);
        entity.setErrorCode(error.getCode());
        entity.setHihokenshaNo(hihokenshaNo);
        entity.setShikibetsuCode(shikibetsuCode);
        entity.setShoriKubunCode(new Code("0"));
        return entity;
    }

    private static DbT2010FukaErrorListEntity createEntity(InternalReportShoriKubun shoriKubun) {
        DbT2010FukaErrorListEntity entity = createEntity(RYear.MIN, RString.EMPTY,
                new FukaError(Code.EMPTY, RString.EMPTY, RString.EMPTY), KaigoHihokenshaNo.NULL_VALUE, ShikibetsuCode.EMPTY);
        entity.setShoriKubunCode(shoriKubun.getCode());
        return entity;
    }

    private static IInternalReportInfoService createMockReportInfoService() {
        IInternalReportInfoService service = mock(IInternalReportInfoService.class);
        when(service.getInternalReportInfo(any(SubGyomuCode.class), any(RString.class), any(RDateTime.class)))
                .thenReturn(new InternalReportInfo(RString.EMPTY, RString.EMPTY, RDateTime.MAX));
        return service;
    }

    private static IInternalReportBatchInfoService createMockBatchInfoService() {
        IInternalReportBatchInfoService service = mock(IInternalReportBatchInfoService.class);
        when(service.getInternalReportBatchInfo(any(SubGyomuCode.class), any(RString.class), any(RDateTime.class)))
                .thenReturn(new InternalReportBatchInfo(RString.EMPTY, RString.EMPTY, RDateTime.MAX));
        return service;
    }

    private static FukaErrorListDac createMockDeleteDac(int result) {
        FukaErrorListDac dac = mock(FukaErrorListDac.class);
        when(dac.delete(any(DbT2010FukaErrorListEntity.class))).thenReturn(result);
        return dac;
    }
}
