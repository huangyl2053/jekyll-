/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.basic;

import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.persistence.basic.testhelper.FukaErrorListInserter;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 賦課エラー一覧の情報を取得するDacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class FukaErrorListDacTest {

    private static FukaErrorListDac sut;
    private static FukaErrorListInserter inserter;

    @BeforeClass
    public static void setUpBeforeClass() {
        sut = InstanceProvider.create(FukaErrorListDac.class);
        inserter = InstanceProvider.create(FukaErrorListInserter.class);
    }

    public static class select extends DbbTestDacBase {

        @Test
        public void データが4件存在する場合_4件の情報を取得できる() {
            inserter.insert(createEntity(RDateTime.of(1999, 12, 31, 12, 12, 12), "01"));
            inserter.insert(createEntity(RDateTime.of(1999, 12, 31, 12, 12, 12), "02"));
            inserter.insert(createEntity(RDateTime.of(2005, 7, 7, 11, 6, 45), "03"));
            inserter.insert(createEntity(RDateTime.of(2014, 2, 22, 22, 22, 22), "04"));

            assertThat(sut.select().size(), is(4));
        }

        @Test
        public void データが存在しない場合_データを1件も取得できない() {
            assertThat(sut.select().size(), is(0));
        }
    }

    public static class select_引数に内部帳票作成日時を渡した場合 extends DbbTestDacBase {

        private final RDateTime dateTime1999 = RDateTime.of(1999, 12, 31, 0, 0, 0);
        private final RDateTime dateTime2005 = RDateTime.of(2005, 7, 7, 0, 0, 0);
        private final RDateTime dateTime2014 = RDateTime.of(2014, 2, 22, 0, 0, 0);
        private final RDateTime dateTime4649 = RDateTime.of(4649, 12, 31, 23, 59, 59);

        @Test
        public void データが6件存在し_そのうち1999年の日付のデータが1件あるの場合_そのデータと同じ日付を条件に指定することで_1件のデータが取得できる() {
            createData();
            assertThat(sut.select(dateTime1999).size(), is(1));
        }

        @Test
        public void データが6件存在し_そのうち2005年の日付のデータが2件あるの場合_そのデータと同じ日付を条件に指定することで_2件のデータが取得できる() {
            createData();
            assertThat(sut.select(dateTime2005).size(), is(2));
        }

        @Test
        public void データが6件存在し_そのうち2014年の日付のデータが3件あるの場合_そのデータと同じ日付を条件に指定することで_3件のデータが取得できる() {
            createData();
            assertThat(sut.select(dateTime2014).size(), is(3));
        }

        @Test
        public void データに該当しない日付を指定した場合_データを1件も取得できない() {
            createData();
            assertThat(sut.select(dateTime4649).size(), is(0));
        }

        private void createData() {
            inserter.insert(createEntity(dateTime1999, "01"));
            inserter.insert(createEntity(dateTime2005, "02"));
            inserter.insert(createEntity(dateTime2014, "03"));
            inserter.insert(createEntity(dateTime2005, "04"));
            inserter.insert(createEntity(dateTime2014, "05"));
            inserter.insert(createEntity(dateTime2014, "06"));
        }
    }

    public static class select_引数に賦課年度と通知書番号を渡した場合 extends DbbTestDacBase {

        private final RDateTime dateTime1999 = RDateTime.of(1999, 12, 31, 0, 0, 0);
        private final FlexibleYear year1999 = new FlexibleYear("1999");
        private final String tsuchishoNoStr = "0123";
        private final TsuchishoNo tsuchishoNo = new TsuchishoNo(new RString(tsuchishoNoStr));

        @Test
        public void 対応するデータが存在し_指定した賦課年度が1999年である場合_賦課年度に1999年を持つデータが取得できる() {
            inserter.insert(createEntity(dateTime1999, tsuchishoNoStr, year1999));
            assertThat(sut.select(year1999, tsuchishoNo).getFukaNendo(), is(new FlexibleYear(year1999.toDateString())));
        }

        @Test
        public void 対応するデータが存在し_指定した通知書番号が0123である場合_通知書番号に0123を持つデータが取得できる() {
            inserter.insert(createEntity(dateTime1999, tsuchishoNoStr, year1999));
            assertThat(sut.select(year1999, tsuchishoNo).getTsuchishoNo(), is(tsuchishoNo));
        }

        @Test
        public void 対応するデータが存在しない場合_nullが返る() {
            assertThat(sut.select(year1999, tsuchishoNo), is(nullValue()));
        }

    }

    public static class update extends DbbTestDacBase {

        private final RDateTime dateTime = RDateTime.of(1999, 12, 31, 0, 0, 0);

        @Test
        public void 更新対象のデータが存在した場合_updateに成功し_1が返る() {
            inserter.insert(createEntity(dateTime, "01"));
            assertThat(sut.update(createEntity(dateTime, "01")), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void 更新対象のデータが存在しなかった場合_updateに失敗し_例外が発生する() {
            assertThat(sut.update(createEntity(dateTime, "02")), is(0));
            fail();
        }
    }

    public static class delete extends DbbTestDacBase {

        private final RDateTime dateTime = RDateTime.of(1999, 12, 31, 0, 0, 0);

        @Test
        public void 削除対象のデータが存在した場合_deleteに成功し_1が返る() {
            inserter.insert(createEntity(dateTime, "01"));
            assertThat(sut.delete(createEntity(dateTime, "01")), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void 削除対象のデータが存在しなかった場合_deleteに失敗し_例外が発生する() {
            assertThat(sut.delete(createEntity(dateTime, "01")), is(0));
            fail();
        }
    }

    private static DbT2010FukaErrorListEntity createEntity(RDateTime listCreatringDateTime, String tsuchishoNo) {
        DbT2010FukaErrorListEntity entity = new DbT2010FukaErrorListEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        entity.setInternalReportId(new RString("0123"));
        entity.setInternalReportCreationDateTime(listCreatringDateTime);
        entity.setBatchId(new RString("0001"));
        entity.setBatchStartingDateTime(RDateTime.of(2008, 1, 1, 12, 12, 12));
        entity.setFukaNendo(new FlexibleYear(listCreatringDateTime.getDate().getYear().toDateString()));
        entity.setTsuchishoNo(new TsuchishoNo(new RString(tsuchishoNo)));
        entity.setErrorCode(new Code("01"));
        entity.setHihokenshaNo(new KaigoHihokenshaNo(new RString("1234500001")));
        entity.setShikibetsuCode(new ShikibetsuCode("012345678900002"));
        entity.setShoriKubunCode(InternalReportShoriKubun.未処理.getCode());
        return entity;
    }

    private static DbT2010FukaErrorListEntity createEntity(RDateTime listCreatringDateTime, String tsuchishoNo, FlexibleYear fukaNendo) {
        DbT2010FukaErrorListEntity entity = createEntity(listCreatringDateTime, tsuchishoNo);
        entity.setFukaNendo(new FlexibleYear(
                fukaNendo.toDateString()));
        return entity;
    }

}
