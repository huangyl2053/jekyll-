/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.model.FukaErrorModel;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 賦課エラーModelのListを扱うクラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class FukaErrorInternalReportItemListTest extends DbbTestBase {

    private static FukaErrorInternalReportItemList sut;

    public static class constructor extends DbbTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new FukaErrorInternalReportItemList(null);
            fail();
        }
    }

    public static class get賦課エラー情報 extends DbbTestBase {

        private FlexibleYear fukaNendo_1999;
        private TsuchishoNo tsuchishoNo_0123;

        @Before
        public void setUp() {
            fukaNendo_1999 = new FlexibleYear("1999");
            tsuchishoNo_0123 = new TsuchishoNo(new RString("0123"));
            List<FukaErrorInternalReportItem> list = createList(3);
            list.add(createItem(fukaNendo_1999, tsuchishoNo_0123));
            sut = new FukaErrorInternalReportItemList(list);
        }

        @Test
        public void 引数に指定した賦課年度と通知書番号を持つ_賦課エラー情報が存在した場合_指定した賦課年度を持つModelを返す() {
            FukaErrorInternalReportItem result = sut.get賦課エラー情報(fukaNendo_1999, tsuchishoNo_0123);
            assertThat(result.get賦課年度(), is(fukaNendo_1999));
        }

        @Test
        public void 引数に指定した賦課年度と通知書番号を持つ_賦課エラー情報が存在した場合_指定した通知書番号を持つModelを返す() {
            FukaErrorInternalReportItem result = sut.get賦課エラー情報(fukaNendo_1999, tsuchishoNo_0123);
            assertThat(result.get通知書番号(), is(tsuchishoNo_0123));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 指定した賦課年度と一致する_賦課エラー情報が存在しない場合_IllegalArgumentExceptionが発生する() {
            FukaErrorInternalReportItem result = sut.get賦課エラー情報(fukaNendo_1999, null);
            fail();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 指定した通知書番号と一致する_賦課エラー情報が存在しない場合_IllegalArgumentExceptionが発生する() {
            FukaErrorInternalReportItem result = sut.get賦課エラー情報(null, tsuchishoNo_0123);
            fail();
        }

    }

    public static class size extends DbbTestBase {

        @Test
        public void size3のListをコンストラクタから受け取っていた場合_3を返す() {
            sut = new FukaErrorInternalReportItemList(createList(3));
            assertThat(sut.size(), is(3));
        }
    }

    public static class isEmpty extends DbbTestBase {

        @Test
        public void 空のListをコンストラクタから受け取っていた場合_trueを返す() {
            sut = new FukaErrorInternalReportItemList(createList(0));
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 空でないListをコンストラクタから受け取っていた場合_falseを返す() {
            sut = new FukaErrorInternalReportItemList(createList(3));
            assertThat(sut.isEmpty(), is(false));
        }

    }

    private static List<FukaErrorInternalReportItem> createList(int num) {
        List<FukaErrorInternalReportItem> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(createItem(new FlexibleYear("2014"), new TsuchishoNo(RString.EMPTY)));
        }
        return list;
    }

    private static FukaErrorInternalReportItem createItem(FlexibleYear fukaNendo, TsuchishoNo tsuchishoNo) {
        FukaErrorModel model = new FukaErrorModel();
        model.set賦課年度(fukaNendo);
        model.set通知書番号(tsuchishoNo);
        return new FukaErrorInternalReportItem(model);
    }
}
