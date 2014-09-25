/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.FukaError;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorReport;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorReportItem;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportBatchInfo;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportInfo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.InternalReportShoriKubun;
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

/**
 * 賦課エラー一覧内部帳票の情報をマッピングするクラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class FukaErrorListMapperTest extends DbbTestBase {

    public static class toFukaErrorReportItem extends DbbTestBase {

        private FukaErrorReportItem result;

        private DbT2010FukaErrorListEntity entity;
        private RYear fukaNendo;
        private RString tsuchishoNo;
        private FukaError error;
        private KaigoHihokenshaNo hihokenshaNo;
        private ShikibetsuCode shikibetsuCode;

        @Before
        public void setUp() {
            fukaNendo = new RYear(1999);
            tsuchishoNo = new RString("00000123");
            error = new FukaError(new Code("0123"), RString.EMPTY, RString.EMPTY);
            hihokenshaNo = new KaigoHihokenshaNo(new RString("0123400001"));
            shikibetsuCode = new ShikibetsuCode("012345678900001");

            entity = createEntity(fukaNendo, tsuchishoNo, error, hihokenshaNo, shikibetsuCode);
            result = FukaErrorListMapper.toFukaErrorReportItem(entity);

        }

        @Test
        public void 引数にnullが渡された場合_nullが返る() {
            result = FukaErrorListMapper.toFukaErrorReportItem(null);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void マッピング元のEntityと_戻り値の賦課エラー一覧項目が持つ_賦課年度は同一になる() {
            assertThat(result.get賦課年度().toDateString(), is(entity.getFukaNendo().toDateString()));
        }

        @Test
        public void マッピング元のEntityと_戻り値の賦課エラー一覧項目が持つ_通知書番号は同一になる() {
            assertThat(result.get通知書番号(), is(entity.getTsuchishoNo()));
        }

        @Test
        public void マッピング元のEntityと_戻り値の賦課エラー一覧項目が持つ_エラー内容は同一になる() {
            assertThat(result.getエラー内容().getCode(), is(entity.getErrorCode()));
        }

        @Test
        public void マッピング元のEntityと_戻り値の賦課エラー一覧項目が持つ_被保険者番号は同一になる() {
            assertThat(result.get被保険者番号(), is(entity.getHihokenshaNo()));
        }

        @Test
        public void マッピング元のEntityと_戻り値の賦課エラー一覧項目が持つ_識別コードは同一になる() {
            assertThat(result.get識別コード(), is(entity.getShikibetsuCode()));
        }

    }

    public static class toFukaErrorListEntity extends DbbTestBase {

        private DbT2010FukaErrorListEntity result;

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

            reportItemList.add(createReportItem(fukaNendo, tsuchishoNo, error, hihokenshaNo, shikibetsuCode));
            report = createReport(subGyomuCode, reportInfo, batchInfo, reportItemList);

            reportItem = report.getItemList().get(0);
            result = FukaErrorListMapper.toFukaErrorListEntity(report, reportItem);
        }

        @Test
        public void reportにnullが渡された場合_nullが返る() {
            result = FukaErrorListMapper.toFukaErrorListEntity(null, reportItem);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void reportItemにnullが渡された場合_nullが返る() {
            result = FukaErrorListMapper.toFukaErrorListEntity(report, null);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void マッピング元のreportと_戻り値のEntityが持つ_サブ業務コードが一致する() {
            assertThat(result.getSubGyomuCode(), is(report.getSubGyomuCode()));
        }

        @Test
        public void マッピング元のreportと_戻り値のEntityが持つ_帳票IDが一致する() {
            assertThat(result.getInternalReportId(), is(report.getInfo().getInternalReportId()));
        }

        @Test
        public void マッピング元のreportと_戻り値のEntityが持つ_リスト作成日時が一致する() {
            assertThat(result.getListCreationDateTime(), is(report.getInfo().getReportCreatingDateTime()));
        }

        @Test
        public void マッピング元のreportと_戻り値のEntityが持つ_バッチIDが一致する() {
            assertThat(result.getBatchId(), is(report.getBatchInfo().getBatchId()));
        }

        @Test
        public void マッピング元のreportと_戻り値のEntityが持つ_バッチ起動日時が一致する() {
            assertThat(result.getBatchStartingDateTime(), is(report.getBatchInfo().getBatchStartingDateTime()));
        }

        @Test
        public void マッピング元のreportItemと_戻り値のEntityが持つ_賦課年度が一致する() {
            assertThat(result.getFukaNendo().toDateString(), is(reportItem.get賦課年度().toDateString()));
        }

        @Test
        public void マッピング元のreportItemと_戻り値のEntityが持つ_通知書番号が一致する() {
            assertThat(result.getTsuchishoNo(), is(reportItem.get通知書番号()));
        }

        @Test
        public void マッピング元のreportItemと_戻り値のEntityが持つ_エラー内容が一致する() {
            assertThat(result.getErrorCode(), is(reportItem.getエラー内容().getCode()));
        }

        @Test
        public void マッピング元のreportItemと_戻り値のEntityが持つ_被保険者番号が一致する() {
            assertThat(result.getHihokenshaNo(), is(reportItem.get被保険者番号()));
        }

        @Test
        public void マッピング元のreportItemと_戻り値のEntityが持つ_識別コードが一致する() {
            assertThat(result.getShikibetsuCode(), is(reportItem.get識別コード()));
        }

    }

    public static class toFukaErrorReport extends DbbTestBase {

        private FukaErrorReport result;
        private SubGyomuCode subGyomuCode;
        private InternalReportInfo reportInfo;
        private InternalReportBatchInfo batchInfo;
        private List<DbT2010FukaErrorListEntity> entityList;

        @Before
        public void setUp() {
            subGyomuCode = SubGyomuCode.DBB介護賦課;
            reportInfo = new InternalReportInfo(new RString("0001"), new RString("reportName"), RDateTime.of(1999, 12, 12, 3, 12, 34));
            batchInfo = new InternalReportBatchInfo(new RString("0002"), new RString("batchName"), RDateTime.of(1999, 12, 12, 3, 12, 34));
            entityList = createEntityList(10);

            result = FukaErrorListMapper.toFukaErrorReport(subGyomuCode, reportInfo, batchInfo, entityList);
        }

        @Test
        public void subGyomuCodeにnullが渡されたとき_nullが返る() {
            result = FukaErrorListMapper.toFukaErrorReport(null, reportInfo, batchInfo, entityList);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void reportInfoにnullが渡されたとき_nullが返る() {
            result = FukaErrorListMapper.toFukaErrorReport(subGyomuCode, null, batchInfo, entityList);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void batchInfoにnullが渡されたとき_nullが返る() {
            result = FukaErrorListMapper.toFukaErrorReport(subGyomuCode, reportInfo, null, entityList);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void entityListにnullが渡されたとき_nullが返る() {
            result = FukaErrorListMapper.toFukaErrorReport(subGyomuCode, reportInfo, batchInfo, null);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void sentityListに空のListが渡されたとき_nullが返る() {
            result = FukaErrorListMapper.toFukaErrorReport(subGyomuCode, reportInfo, batchInfo, Collections.EMPTY_LIST);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 引数に10件のEntityを持つListが渡されたとき_戻り値の賦課エラー一覧内部帳票は_10件の項目を持つ() {
            assertThat(result.getItemList().size(), is(10));
        }
    }

    public static class toFukaErrorListEntityList extends DbbTestBase {

        private List<DbT2010FukaErrorListEntity> result;

        private FukaErrorReport report;
        private SubGyomuCode subGyomuCode;
        private InternalReportInfo reportInfo;
        private InternalReportBatchInfo batchInfo;
        private List<FukaErrorReportItem> reportItemList;

        @Before
        public void setUp() {
            subGyomuCode = SubGyomuCode.DBB介護賦課;
            reportInfo = new InternalReportInfo(new RString("0001"), new RString("reportName"), RDateTime.of(1999, 12, 12, 3, 12, 34));
            batchInfo = new InternalReportBatchInfo(new RString("0002"), new RString("batchName"), RDateTime.of(1999, 12, 12, 3, 12, 34));
            reportItemList = createReportItemList(10);

            report = createReport(subGyomuCode, reportInfo, batchInfo, reportItemList);
            result = FukaErrorListMapper.toFukaErrorListEntityList(report);
        }

        @Test
        public void reportにnullが渡された場合_空のListが返る() {
            result = FukaErrorListMapper.toFukaErrorListEntityList(null);
            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void reportが持つreportItemが0件だった場合_空のListが返る() {
            report = createReport(subGyomuCode, reportInfo, batchInfo, Collections.EMPTY_LIST);
            result = FukaErrorListMapper.toFukaErrorListEntityList(report);
            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void マッピング元のreportと_戻り値のEntityが持つ_サブ業務コードが一致する() {
            assertThat(result.get(0).getSubGyomuCode(), is(report.getSubGyomuCode()));
        }

        @Test
        public void マッピング元のreportと_戻り値のEntityが持つ_帳票IDが一致する() {
            assertThat(result.get(0).getInternalReportId(), is(report.getInfo().getInternalReportId()));
        }

        @Test
        public void マッピング元のreportと_戻り値のEntityが持つ_リスト作成日時が一致する() {
            assertThat(result.get(0).getListCreationDateTime(), is(report.getInfo().getReportCreatingDateTime()));
        }

        @Test
        public void マッピング元のreportと_戻り値のEntityが持つ_バッチIDが一致する() {
            assertThat(result.get(0).getBatchId(), is(report.getBatchInfo().getBatchId()));
        }

        @Test
        public void マッピング元のreportと_戻り値のEntityが持つ_バッチ起動日時が一致する() {
            assertThat(result.get(0).getBatchStartingDateTime(), is(report.getBatchInfo().getBatchStartingDateTime()));
        }

        @Test
        public void マッピング元のreportがもつ項目数と_戻り値のEntityListの件数は_一致する() {
            assertThat(result.size(), is(report.getItemList().size()));
        }

    }

    private static FukaErrorReport createReport(SubGyomuCode subGyomuCode, InternalReportInfo reportInfo,
            InternalReportBatchInfo batchInfo, List<FukaErrorReportItem> list) {
        return new FukaErrorReport(subGyomuCode, reportInfo, batchInfo, list);
    }

    private static FukaErrorReportItem createReportItem(RYear fukaNendo, RString tsuchishoNo, FukaError error,
            KaigoHihokenshaNo hihokenshaNo, ShikibetsuCode shikibetsuCode) {
        return new FukaErrorReportItem(fukaNendo, tsuchishoNo, error, hihokenshaNo, shikibetsuCode, InternalReportShoriKubun.処理無し);
    }

    private static List<FukaErrorReportItem> createReportItemList(int num) {
        List<FukaErrorReportItem> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(createReportItem(RYear.MIN, RString.EMPTY, new FukaError(Code.EMPTY, RString.EMPTY, RString.EMPTY),
                    KaigoHihokenshaNo.NULL_VALUE, ShikibetsuCode.EMPTY));
        }
        return list;
    }

    private static List<DbT2010FukaErrorListEntity> createEntityList(int num) {
        return createEntityList(RYear.MIN, RString.EMPTY, new FukaError(Code.EMPTY, RString.EMPTY, RString.EMPTY),
                KaigoHihokenshaNo.NULL_VALUE, ShikibetsuCode.EMPTY, num);
    }

    private static List<DbT2010FukaErrorListEntity> createEntityList(RYear fukaNendo, RString tsuchishoNo, FukaError error,
            KaigoHihokenshaNo hihokenshaNo, ShikibetsuCode shikibetsuCode, int num) {
        List<DbT2010FukaErrorListEntity> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(createEntity(fukaNendo, tsuchishoNo, error, hihokenshaNo, shikibetsuCode));
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

}
