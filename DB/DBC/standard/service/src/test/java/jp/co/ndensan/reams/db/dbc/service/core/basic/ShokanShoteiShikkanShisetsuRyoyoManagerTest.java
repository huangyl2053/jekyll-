/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3052ShokanShoteiShikkanShisetsuRyoyoDac;
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
 * {link ShokanShoteiShikkanShisetsuRyoyoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanShoteiShikkanShisetsuRyoyoManagerTest {

    private static DbT3052ShokanShoteiShikkanShisetsuRyoyoDac dac;
    private static ShokanShoteiShikkanShisetsuRyoyoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3052ShokanShoteiShikkanShisetsuRyoyoDac.class);
        sut = new ShokanShoteiShikkanShisetsuRyoyoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払請求所定疾患施設療養費等 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_順次番号;
            Decimal 主キー7 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求所定疾患施設療養費等(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_順次番号;
            Decimal 主キー7 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求所定疾患施設療養費等(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー4 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_順次番号;
            Decimal 主キー7 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求所定疾患施設療養費等(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_整理番号;
            RString 主キー5 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_順次番号;
            Decimal 主キー7 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求所定疾患施設療養費等(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_事業者番号;
            RString 主キー6 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_順次番号;
            Decimal 主キー7 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求所定疾患施設療養費等(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_様式番号;
            Decimal 主キー7 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求所定疾患施設療養費等(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型7にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_順次番号;
            sut.get償還払請求所定疾患施設療養費等(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class), any(JigyoshaNo.class),
                    any(RString.class), any(RString.class), any(Decimal.class))).thenReturn(null);
            HihokenshaNo 主キー1 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_順次番号;
            Decimal 主キー7 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_履歴番号;
            ShokanShoteiShikkanShisetsuRyoyo result = sut.get償還払請求所定疾患施設療養費等(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class), any(JigyoshaNo.class),
                    any(RString.class), any(RString.class), any(Decimal.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_順次番号;
            Decimal 主キー7 = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_履歴番号;
            ShokanShoteiShikkanShisetsuRyoyo result = sut.get償還払請求所定疾患施設療養費等(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);

            assertThat(result.get被保険者番号().value(), is(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払請求所定疾患施設療養費等一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShokanShoteiShikkanShisetsuRyoyo> result = sut.get償還払請求所定疾患施設療養費等一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> entityList = Arrays.asList(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3052ShokanShoteiShikkanShisetsuRyoyoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShokanShoteiShikkanShisetsuRyoyo> result = sut.get償還払請求所定疾患施設療養費等一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save償還払請求所定疾患施設療養費等 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity.class))).thenReturn(1);

            DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
            ShokanShoteiShikkanShisetsuRyoyo 償還払請求所定疾患施設療養費等 = new ShokanShoteiShikkanShisetsuRyoyo(entity);

            assertThat(sut.save償還払請求所定疾患施設療養費等(償還払請求所定疾患施設療養費等), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity.class))).thenReturn(0);

            DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
            ShokanShoteiShikkanShisetsuRyoyo 償還払請求所定疾患施設療養費等 = new ShokanShoteiShikkanShisetsuRyoyo(entity);

            assertThat(sut.save償還払請求所定疾患施設療養費等(償還払請求所定疾患施設療養費等), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity.class))).thenReturn(1);

            DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
            entity.initializeMd5();
            ShokanShoteiShikkanShisetsuRyoyo 償還払請求所定疾患施設療養費等 = new ShokanShoteiShikkanShisetsuRyoyo(entity);
            償還払請求所定疾患施設療養費等 = 償還払請求所定疾患施設療養費等.createBuilderForEdit().set往診医療機関名(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払請求所定疾患施設療養費等(償還払請求所定疾患施設療養費等), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity.class))).thenReturn(0);

            DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
            entity.initializeMd5();
            ShokanShoteiShikkanShisetsuRyoyo 償還払請求所定疾患施設療養費等 = new ShokanShoteiShikkanShisetsuRyoyo(entity);
            償還払請求所定疾患施設療養費等 = 償還払請求所定疾患施設療養費等.createBuilderForEdit().set往診医療機関名(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払請求所定疾患施設療養費等(償還払請求所定疾患施設療養費等), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity.class))).thenReturn(1);

            DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
            entity.initializeMd5();
            ShokanShoteiShikkanShisetsuRyoyo 償還払請求所定疾患施設療養費等 = new ShokanShoteiShikkanShisetsuRyoyo(entity);
            償還払請求所定疾患施設療養費等 = 償還払請求所定疾患施設療養費等.deleted();

            assertThat(sut.save償還払請求所定疾患施設療養費等(償還払請求所定疾患施設療養費等), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity.class))).thenReturn(0);

            DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
            entity.initializeMd5();
            ShokanShoteiShikkanShisetsuRyoyo 償還払請求所定疾患施設療養費等 = new ShokanShoteiShikkanShisetsuRyoyo(entity);
            償還払請求所定疾患施設療養費等 = 償還払請求所定疾患施設療養費等.deleted();

            assertThat(sut.save償還払請求所定疾患施設療養費等(償還払請求所定疾患施設療養費等), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity = DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
            entity.initializeMd5();
            ShokanShoteiShikkanShisetsuRyoyo 償還払請求所定疾患施設療養費等 = new ShokanShoteiShikkanShisetsuRyoyo(entity);

            assertThat(sut.save償還払請求所定疾患施設療養費等(償還払請求所定疾患施設療養費等), is(false));
        }
    }
}
