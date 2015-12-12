/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3048ShokanFukushiYoguHanbaihiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3048ShokanFukushiYoguHanbaihiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link ShokanFukushiYoguHanbaihiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanFukushiYoguHanbaihiManagerTest {

    private static DbT3048ShokanFukushiYoguHanbaihiDac dac;
    private static ShokanFukushiYoguHanbaihiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3048ShokanFukushiYoguHanbaihiDac.class);
        sut = new ShokanFukushiYoguHanbaihiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払請求福祉用具販売費 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_順次番号;
            Decimal 主キー7 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求福祉用具販売費(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_順次番号;
            Decimal 主キー7 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求福祉用具販売費(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー4 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_順次番号;
            Decimal 主キー7 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求福祉用具販売費(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号;
            RString 主キー5 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_順次番号;
            Decimal 主キー7 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求福祉用具販売費(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー6 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_順次番号;
            Decimal 主キー7 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求福祉用具販売費(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_様式番号;
            Decimal 主キー7 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求福祉用具販売費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型7にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_順次番号;
            sut.get償還払請求福祉用具販売費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class), any(JigyoshaNo.class),
                    any(RString.class), any(RString.class), any(Decimal.class))).thenReturn(null);
            HihokenshaNo 主キー1 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_順次番号;
            Decimal 主キー7 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_履歴番号;
            ShokanFukushiYoguHanbaihi result = sut.get償還払請求福祉用具販売費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3048ShokanFukushiYoguHanbaihiEntity entity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class), any(JigyoshaNo.class),
                    any(RString.class), any(RString.class), any(Decimal.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_順次番号;
            Decimal 主キー7 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_履歴番号;
            ShokanFukushiYoguHanbaihi result = sut.get償還払請求福祉用具販売費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);

            assertThat(result.get被保険者番号().value(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払請求福祉用具販売費一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShokanFukushiYoguHanbaihi> result = sut.get償還払請求福祉用具販売費一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3048ShokanFukushiYoguHanbaihiEntity> entityList = Arrays.asList(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShokanFukushiYoguHanbaihi> result = sut.get償還払請求福祉用具販売費一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save償還払請求福祉用具販売費 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3048ShokanFukushiYoguHanbaihiEntity.class))).thenReturn(1);

            DbT3048ShokanFukushiYoguHanbaihiEntity entity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
            ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 = new ShokanFukushiYoguHanbaihi(entity);

            assertThat(sut.save償還払請求福祉用具販売費(償還払請求福祉用具販売費), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3048ShokanFukushiYoguHanbaihiEntity.class))).thenReturn(0);

            DbT3048ShokanFukushiYoguHanbaihiEntity entity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
            ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 = new ShokanFukushiYoguHanbaihi(entity);

            assertThat(sut.save償還払請求福祉用具販売費(償還払請求福祉用具販売費), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3048ShokanFukushiYoguHanbaihiEntity.class))).thenReturn(1);

            DbT3048ShokanFukushiYoguHanbaihiEntity entity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
            entity.initializeMd5();
            ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 = new ShokanFukushiYoguHanbaihi(entity);
            償還払請求福祉用具販売費 = 償還払請求福祉用具販売費.createBuilderForEdit().set品目コード(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払請求福祉用具販売費(償還払請求福祉用具販売費), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3048ShokanFukushiYoguHanbaihiEntity.class))).thenReturn(0);

            DbT3048ShokanFukushiYoguHanbaihiEntity entity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
            entity.initializeMd5();
            ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 = new ShokanFukushiYoguHanbaihi(entity);
            償還払請求福祉用具販売費 = 償還払請求福祉用具販売費.createBuilderForEdit().set品目コード(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払請求福祉用具販売費(償還払請求福祉用具販売費), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3048ShokanFukushiYoguHanbaihiEntity.class))).thenReturn(1);

            DbT3048ShokanFukushiYoguHanbaihiEntity entity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
            entity.initializeMd5();
            ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 = new ShokanFukushiYoguHanbaihi(entity);
            償還払請求福祉用具販売費 = 償還払請求福祉用具販売費.deleted();

            assertThat(sut.save償還払請求福祉用具販売費(償還払請求福祉用具販売費), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3048ShokanFukushiYoguHanbaihiEntity.class))).thenReturn(0);

            DbT3048ShokanFukushiYoguHanbaihiEntity entity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
            entity.initializeMd5();
            ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 = new ShokanFukushiYoguHanbaihi(entity);
            償還払請求福祉用具販売費 = 償還払請求福祉用具販売費.deleted();

            assertThat(sut.save償還払請求福祉用具販売費(償還払請求福祉用具販売費), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3048ShokanFukushiYoguHanbaihiEntity entity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
            entity.initializeMd5();
            ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 = new ShokanFukushiYoguHanbaihi(entity);

            assertThat(sut.save償還払請求福祉用具販売費(償還払請求福祉用具販売費), is(false));
        }
    }
}
