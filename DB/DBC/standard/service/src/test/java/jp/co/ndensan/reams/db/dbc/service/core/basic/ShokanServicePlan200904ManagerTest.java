/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200904;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3047ShokanServicePlan200904EntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3047ShokanServicePlan200904Dac;
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
 * {link ShokanServicePlan200904Manager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanServicePlan200904ManagerTest {

    private static DbT3047ShokanServicePlan200904Dac dac;
    private static ShokanServicePlan200904Manager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3047ShokanServicePlan200904Dac.class);
        sut = new ShokanServicePlan200904Manager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払請求サービス計画200904 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_明細番号;
            RString 主キー7 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_連番;
            sut.get償還払請求サービス計画200904(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_明細番号;
            RString 主キー7 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_連番;
            sut.get償還払請求サービス計画200904(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー4 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_明細番号;
            RString 主キー7 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_連番;
            sut.get償還払請求サービス計画200904(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_整理番号;
            RString 主キー5 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_明細番号;
            RString 主キー7 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_連番;
            sut.get償還払請求サービス計画200904(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_事業者番号;
            RString 主キー6 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_明細番号;
            RString 主キー7 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_連番;
            sut.get償還払請求サービス計画200904(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_様式番号;
            RString 主キー7 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_連番;
            sut.get償還払請求サービス計画200904(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型7にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_明細番号;
            sut.get償還払請求サービス計画200904(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class),
                    any(JigyoshaNo.class), any(RString.class),
                    any(RString.class), any(RString.class))).thenReturn(null);
            HihokenshaNo 主キー1 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_明細番号;
            RString 主キー7 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_連番;
            ShokanServicePlan200904 result = sut.get償還払請求サービス計画200904(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3047ShokanServicePlan200904Entity entity = DbT3047ShokanServicePlan200904EntityGenerator.createDbT3047ShokanServicePlan200904Entity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class),
                    any(JigyoshaNo.class), any(RString.class),
                    any(RString.class), any(RString.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_整理番号;
            JigyoshaNo 主キー4 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_事業者番号;
            RString 主キー5 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_様式番号;
            RString 主キー6 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_明細番号;
            RString 主キー7 = DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_連番;
            ShokanServicePlan200904 result = sut.get償還払請求サービス計画200904(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);

            assertThat(result.get被保険者番号().value(), is(DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払請求サービス計画200904一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShokanServicePlan200904> result = sut.get償還払請求サービス計画200904一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3047ShokanServicePlan200904Entity> entityList = Arrays.asList(DbT3047ShokanServicePlan200904EntityGenerator.createDbT3047ShokanServicePlan200904Entity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShokanServicePlan200904> result = sut.get償還払請求サービス計画200904一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3047ShokanServicePlan200904EntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save償還払請求サービス計画200904 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3047ShokanServicePlan200904Entity.class))).thenReturn(1);

            DbT3047ShokanServicePlan200904Entity entity = DbT3047ShokanServicePlan200904EntityGenerator.createDbT3047ShokanServicePlan200904Entity();
            ShokanServicePlan200904 償還払請求サービス計画200904 = new ShokanServicePlan200904(entity);

            assertThat(sut.save償還払請求サービス計画200904(償還払請求サービス計画200904), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3047ShokanServicePlan200904Entity.class))).thenReturn(0);

            DbT3047ShokanServicePlan200904Entity entity = DbT3047ShokanServicePlan200904EntityGenerator.createDbT3047ShokanServicePlan200904Entity();
            ShokanServicePlan200904 償還払請求サービス計画200904 = new ShokanServicePlan200904(entity);

            assertThat(sut.save償還払請求サービス計画200904(償還払請求サービス計画200904), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3047ShokanServicePlan200904Entity.class))).thenReturn(1);

            DbT3047ShokanServicePlan200904Entity entity = DbT3047ShokanServicePlan200904EntityGenerator.createDbT3047ShokanServicePlan200904Entity();
            entity.initializeMd5();
            ShokanServicePlan200904 償還払請求サービス計画200904 = new ShokanServicePlan200904(entity);
            償還払請求サービス計画200904 = 償還払請求サービス計画200904.createBuilderForEdit().set増減理由等(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払請求サービス計画200904(償還払請求サービス計画200904), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3047ShokanServicePlan200904Entity.class))).thenReturn(0);

            DbT3047ShokanServicePlan200904Entity entity = DbT3047ShokanServicePlan200904EntityGenerator.createDbT3047ShokanServicePlan200904Entity();
            entity.initializeMd5();
            ShokanServicePlan200904 償還払請求サービス計画200904 = new ShokanServicePlan200904(entity);
            償還払請求サービス計画200904 = 償還払請求サービス計画200904.createBuilderForEdit().set増減理由等(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払請求サービス計画200904(償還払請求サービス計画200904), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3047ShokanServicePlan200904Entity.class))).thenReturn(1);

            DbT3047ShokanServicePlan200904Entity entity = DbT3047ShokanServicePlan200904EntityGenerator.createDbT3047ShokanServicePlan200904Entity();
            entity.initializeMd5();
            ShokanServicePlan200904 償還払請求サービス計画200904 = new ShokanServicePlan200904(entity);
            償還払請求サービス計画200904 = 償還払請求サービス計画200904.deleted();

            assertThat(sut.save償還払請求サービス計画200904(償還払請求サービス計画200904), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3047ShokanServicePlan200904Entity.class))).thenReturn(0);

            DbT3047ShokanServicePlan200904Entity entity = DbT3047ShokanServicePlan200904EntityGenerator.createDbT3047ShokanServicePlan200904Entity();
            entity.initializeMd5();
            ShokanServicePlan200904 償還払請求サービス計画200904 = new ShokanServicePlan200904(entity);
            償還払請求サービス計画200904 = 償還払請求サービス計画200904.deleted();

            assertThat(sut.save償還払請求サービス計画200904(償還払請求サービス計画200904), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3047ShokanServicePlan200904Entity entity = DbT3047ShokanServicePlan200904EntityGenerator.createDbT3047ShokanServicePlan200904Entity();
            entity.initializeMd5();
            ShokanServicePlan200904 償還払請求サービス計画200904 = new ShokanServicePlan200904(entity);

            assertThat(sut.save償還払請求サービス計画200904(償還払請求サービス計画200904), is(false));
        }
    }
}
