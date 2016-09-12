/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic;

import jp.co.ndensan.reams.db.dbd.service.core.basic.ShokanShukeiManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3053ShokanShukeiEntityGenerator;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link ShokanShukeiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanShukeiManagerTest {

    private static DbT3053ShokanShukeiDac dac;
    private static ShokanShukeiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3053ShokanShukeiDac.class);
        sut = new ShokanShukeiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払請求集計 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_明細番号;
            RString 主キー7 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_連番;
            sut.get償還払請求集計(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_明細番号;
            RString 主キー7 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_連番;
            sut.get償還払請求集計(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー4 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_明細番号;
            RString 主キー7 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_連番;
            sut.get償還払請求集計(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_整理番号;
            RString 主キー5 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_明細番号;
            RString 主キー7 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_連番;
            sut.get償還払請求集計(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー6 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_明細番号;
            RString 主キー7 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_連番;
            sut.get償還払請求集計(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_様式番号;
            RString 主キー7 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_連番;
            sut.get償還払請求集計(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型7にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_明細番号;
            sut.get償還払請求集計(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class), any(JigyoshaNo.class),
                    any(RString.class), any(RString.class), any(RString.class))).thenReturn(null);
            HihokenshaNo 主キー1 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_明細番号;
            RString 主キー7 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_連番;
            ShokanShukei result = sut.get償還払請求集計(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3053ShokanShukeiEntity entity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class), any(JigyoshaNo.class),
                    any(RString.class), any(RString.class), any(RString.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_明細番号;
            RString 主キー7 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_連番;
            ShokanShukei result = sut.get償還払請求集計(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);

            assertThat(result.get被保険者番号().value(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払請求集計一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShokanShukei> result = sut.get償還払請求集計一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3053ShokanShukeiEntity> entityList = Arrays.asList(DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShokanShukei> result = sut.get償還払請求集計一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save償還払請求集計 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3053ShokanShukeiEntity.class))).thenReturn(1);

            DbT3053ShokanShukeiEntity entity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
            ShokanShukei 償還払請求集計 = new ShokanShukei(entity);

            assertThat(sut.save償還払請求集計(償還払請求集計), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3053ShokanShukeiEntity.class))).thenReturn(0);

            DbT3053ShokanShukeiEntity entity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
            ShokanShukei 償還払請求集計 = new ShokanShukei(entity);

            assertThat(sut.save償還払請求集計(償還払請求集計), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3053ShokanShukeiEntity.class))).thenReturn(1);

            DbT3053ShokanShukeiEntity entity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
            entity.initializeMd5();
            ShokanShukei 償還払請求集計 = new ShokanShukei(entity);
            償還払請求集計 = 償還払請求集計.createBuilderForEdit().set不支給理由等(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払請求集計(償還払請求集計), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3053ShokanShukeiEntity.class))).thenReturn(0);

            DbT3053ShokanShukeiEntity entity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
            entity.initializeMd5();
            ShokanShukei 償還払請求集計 = new ShokanShukei(entity);
            償還払請求集計 = 償還払請求集計.createBuilderForEdit().set不支給理由等(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払請求集計(償還払請求集計), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3053ShokanShukeiEntity.class))).thenReturn(1);

            DbT3053ShokanShukeiEntity entity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
            entity.initializeMd5();
            ShokanShukei 償還払請求集計 = new ShokanShukei(entity);
            償還払請求集計 = 償還払請求集計.deleted();

            assertThat(sut.save償還払請求集計(償還払請求集計), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3053ShokanShukeiEntity.class))).thenReturn(0);

            DbT3053ShokanShukeiEntity entity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
            entity.initializeMd5();
            ShokanShukei 償還払請求集計 = new ShokanShukei(entity);
            償還払請求集計 = 償還払請求集計.deleted();

            assertThat(sut.save償還払請求集計(償還払請求集計), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3053ShokanShukeiEntity entity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
            entity.initializeMd5();
            ShokanShukei 償還払請求集計 = new ShokanShukei(entity);

            assertThat(sut.save償還払請求集計(償還払請求集計), is(false));
        }
    }
}
