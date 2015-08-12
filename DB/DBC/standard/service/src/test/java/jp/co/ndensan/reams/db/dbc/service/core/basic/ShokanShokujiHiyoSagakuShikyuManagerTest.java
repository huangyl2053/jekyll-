/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyoSagakuShikyu;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3044ShokanShokujiHiyoSagakuShikyuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3044ShokanShokujiHiyoSagakuShikyuDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link ShokanShokujiHiyoSagakuShikyuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanShokujiHiyoSagakuShikyuManagerTest {

    private static DbT3044ShokanShokujiHiyoSagakuShikyuDac dac;
    private static ShokanShokujiHiyoSagakuShikyuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3044ShokanShokujiHiyoSagakuShikyuDac.class);
        sut = new ShokanShokujiHiyoSagakuShikyuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払請求食事費用差額支給 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_様式番号;
            Decimal 主キー6 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求食事費用差額支給(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_様式番号;
            Decimal 主キー6 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求食事費用差額支給(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_サービス提供年月;

            JigyoshaNo 主キー4 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_様式番号;
            Decimal 主キー6 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求食事費用差額支給(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_整理番号;
            RString 主キー5 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_様式番号;
            Decimal 主キー6 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求食事費用差額支給(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_事業者番号;
            Decimal 主キー6 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払請求食事費用差額支給(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_様式番号;
            sut.get償還払請求食事費用差額支給(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class), any(JigyoshaNo.class),
                    any(RString.class), any(Decimal.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_様式番号;
            Decimal 主キー6 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_履歴番号;
            ShokanShokujiHiyoSagakuShikyu result = sut.get償還払請求食事費用差額支給(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class), any(JigyoshaNo.class),
                    any(RString.class), any(Decimal.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_様式番号;
            Decimal 主キー6 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_履歴番号;
            ShokanShokujiHiyoSagakuShikyu result = sut.get償還払請求食事費用差額支給(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);

            assertThat(result.get主キー1().value(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払請求食事費用差額支給一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShokanShokujiHiyoSagakuShikyu> result = sut.get償還払請求食事費用差額支給一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3044ShokanShokujiHiyoSagakuShikyuEntity> entityList = Arrays.asList(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShokanShokujiHiyoSagakuShikyu> result = sut.get償還払請求食事費用差額支給一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save償還払請求食事費用差額支給 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3044ShokanShokujiHiyoSagakuShikyuEntity.class))).thenReturn(1);

            DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            ShokanShokujiHiyoSagakuShikyu 償還払請求食事費用差額支給 = new ShokanShokujiHiyoSagakuShikyu(entity);

            assertThat(sut.save償還払請求食事費用差額支給(償還払請求食事費用差額支給), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3044ShokanShokujiHiyoSagakuShikyuEntity.class))).thenReturn(0);

            DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            ShokanShokujiHiyoSagakuShikyu 償還払請求食事費用差額支給 = new ShokanShokujiHiyoSagakuShikyu(entity);

            assertThat(sut.save償還払請求食事費用差額支給(償還払請求食事費用差額支給), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3044ShokanShokujiHiyoSagakuShikyuEntity.class))).thenReturn(1);

            DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            entity.initializeMd5();
            ShokanShokujiHiyoSagakuShikyu 償還払請求食事費用差額支給 = new ShokanShokujiHiyoSagakuShikyu(entity);
            償還払請求食事費用差額支給 = 償還払請求食事費用差額支給.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払請求食事費用差額支給(償還払請求食事費用差額支給), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3044ShokanShokujiHiyoSagakuShikyuEntity.class))).thenReturn(0);

            DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            entity.initializeMd5();
            ShokanShokujiHiyoSagakuShikyu 償還払請求食事費用差額支給 = new ShokanShokujiHiyoSagakuShikyu(entity);
            償還払請求食事費用差額支給 = 償還払請求食事費用差額支給.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払請求食事費用差額支給(償還払請求食事費用差額支給), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3044ShokanShokujiHiyoSagakuShikyuEntity.class))).thenReturn(1);

            DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            entity.initializeMd5();
            ShokanShokujiHiyoSagakuShikyu 償還払請求食事費用差額支給 = new ShokanShokujiHiyoSagakuShikyu(entity);
            償還払請求食事費用差額支給 = 償還払請求食事費用差額支給.deleted();

            assertThat(sut.save償還払請求食事費用差額支給(償還払請求食事費用差額支給), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3044ShokanShokujiHiyoSagakuShikyuEntity.class))).thenReturn(0);

            DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            entity.initializeMd5();
            ShokanShokujiHiyoSagakuShikyu 償還払請求食事費用差額支給 = new ShokanShokujiHiyoSagakuShikyu(entity);
            償還払請求食事費用差額支給 = 償還払請求食事費用差額支給.deleted();

            assertThat(sut.save償還払請求食事費用差額支給(償還払請求食事費用差額支給), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            entity.initializeMd5();
            ShokanShokujiHiyoSagakuShikyu 償還払請求食事費用差額支給 = new ShokanShokujiHiyoSagakuShikyu(entity);

            assertThat(sut.save償還払請求食事費用差額支給(償還払請求食事費用差額支給), is(false));
        }
    }
}
