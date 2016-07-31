/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import jp.co.ndensan.reams.db.dbb.business.core.FukaRireki;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 賦課履歴を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
@Ignore
public class FukaRirekiTest {

    private static FukaRireki sut;

    public static class コンストラクタ extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 賦課履歴明細がnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new FukaRireki(null);
        }
    }

    public static class getグループ化賦課履歴 extends DbzTestBase {

        @Test
        public void 賦課履歴明細がある時_getグループ化賦課履歴は_賦課年度_調定年度_通知書番号でグループ化する() {
            sut = new FukaRireki(createFukaModelList());
            assertThat(sut.getグループ化賦課履歴().size(), is(4));
//            assertThat(sut.getグループ化賦課履歴().toList().get(0).get処理日時(), is(RDateTime.MIN.plusHours(2)));
//            assertThat(sut.getグループ化賦課履歴().toList().get(3).get処理日時(), is(RDateTime.MIN.plusHours(2)));
        }

        @Test
        public void 賦課履歴明細がある時_getグループ化賦課履歴は_賦課年度の降順_調定年度の降順_通知書番号の降順でソートする() {
            sut = new FukaRireki(createFukaModelList());
            assertThat(sut.getグループ化賦課履歴().toList().get(0).get賦課年度(), is(new FlexibleYear("2001")));
            assertThat(sut.getグループ化賦課履歴().toList().get(0).get調定年度(), is(new FlexibleYear("2002")));
            assertThat(sut.getグループ化賦課履歴().toList().get(0).get通知書番号(), is(new TsuchishoNo("0000000003")));
            assertThat(sut.getグループ化賦課履歴().toList().get(3).get賦課年度(), is(new FlexibleYear("2000")));
            assertThat(sut.getグループ化賦課履歴().toList().get(3).get調定年度(), is(new FlexibleYear("2000")));
            assertThat(sut.getグループ化賦課履歴().toList().get(3).get通知書番号(), is(new TsuchishoNo("0000000000")));
        }
    }

    public static class get賦課履歴All extends DbzTestBase {

        @Test
        public void 賦課履歴明細がある時_get賦課履歴Allは_全賦課履歴明細を返す() {
            sut = new FukaRireki(createFukaModelList());
            assertThat(sut.get賦課履歴All().size(), is(8));
        }
    }

    public static class get賦課履歴 extends DbzTestBase {

        @Test
        public void 条件に該当する賦課履歴明細がある時_get賦課履歴は_該当の賦課履歴明細を返す() {
            sut = new FukaRireki(createFukaModelList());
            assertThat(sut.get賦課履歴(new FukaNendo("2001"), new ChoteiNendo("2002"), new TsuchishoNo("0000000003")).size(), is(2));
        }

        @Test
        public void 条件に該当する賦課履歴明細がない時_get賦課履歴は_emptyを返す() {
            sut = new FukaRireki(createFukaModelList());
            assertThat(sut.get賦課履歴(FukaNendo.EMPTY, ChoteiNendo.EMPTY, TsuchishoNo.EMPTY).isEmpty(), is(true));
        }
    }

    private static List<Fuka> createFukaModelList() {
        List<Fuka> list = new ArrayList<>();
        list.add(createFukaModel("2000", "2000", "0000000000", 1));
        list.add(createFukaModel("2000", "2000", "0000000000", 2));
        list.add(createFukaModel("2001", "2001", "0000000001", 1));
        list.add(createFukaModel("2001", "2001", "0000000001", 2));
        list.add(createFukaModel("2001", "2002", "0000000002", 1));
        list.add(createFukaModel("2001", "2002", "0000000002", 2));
        list.add(createFukaModel("2001", "2002", "0000000003", 1));
        list.add(createFukaModel("2001", "2002", "0000000003", 2));
        return list;
    }

    private static Fuka createFukaModel(String 賦課年度, String 調定年度, String 通知書番号, int 処理日時差分) {
        Fuka mock = mock(Fuka.class);
        when(mock.get賦課年度()).thenReturn(new FlexibleYear(賦課年度));
        when(mock.get調定年度()).thenReturn(new FlexibleYear(調定年度));
        when(mock.get通知書番号()).thenReturn(new TsuchishoNo(通知書番号));
//        when(mock.get処理日時()).thenReturn(RDateTime.MIN.plusHours(処理日時差分));
        return mock;
    }
}
