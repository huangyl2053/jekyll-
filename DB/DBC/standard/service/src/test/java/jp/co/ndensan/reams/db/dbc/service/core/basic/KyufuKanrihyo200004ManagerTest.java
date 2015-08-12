/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuKanrihyo200004;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3014KyufuKanrihyo200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3014KyufuKanrihyo200004EntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3014KyufuKanrihyo200004Dac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link KyufuKanrihyo200004Manager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuKanrihyo200004ManagerTest {

    private static DbT3014KyufuKanrihyo200004Dac dac;
    private static KyufuKanrihyo200004Manager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3014KyufuKanrihyo200004Dac.class);
        sut = new KyufuKanrihyo200004Manager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付管理票200004 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス提供年月;
            HokenshaNo 主キー3 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_証記載保険者番号;
            JigyoshaNo 主キー4 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅支援事業所番号;
            RString 主キー5 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票情報作成区分コード;
            FlexibleDate 主キー6 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票作成年月日;
            RString 主キー7 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票種別区分コード;
            RString 主キー8 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票明細行番号;
            sut.get給付管理票200004(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月;
            HokenshaNo 主キー3 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_証記載保険者番号;
            JigyoshaNo 主キー4 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅支援事業所番号;
            RString 主キー5 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票情報作成区分コード;
            FlexibleDate 主キー6 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票作成年月日;
            RString 主キー7 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票種別区分コード;
            RString 主キー8 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票明細行番号;
            sut.get給付管理票200004(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月;
            FlexibleYearMonth 主キー2 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー4 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅支援事業所番号;
            RString 主キー5 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票情報作成区分コード;
            FlexibleDate 主キー6 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票作成年月日;
            RString 主キー7 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票種別区分コード;
            RString 主キー8 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票明細行番号;
            sut.get給付管理票200004(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月;
            FlexibleYearMonth 主キー2 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス提供年月;
            HokenshaNo 主キー3 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー5 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票情報作成区分コード;
            FlexibleDate 主キー6 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票作成年月日;
            RString 主キー7 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票種別区分コード;
            RString 主キー8 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票明細行番号;
            sut.get給付管理票200004(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6, 主キー7, 主キー8);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月;
            FlexibleYearMonth 主キー2 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス提供年月;
            HokenshaNo 主キー3 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_証記載保険者番号;
            JigyoshaNo 主キー4 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅支援事業所番号;
            FlexibleDate 主キー6 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票作成年月日;
            RString 主キー7 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票種別区分コード;
            RString 主キー8 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票明細行番号;
            sut.get給付管理票200004(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6, 主キー7, 主キー8);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月;
            FlexibleYearMonth 主キー2 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス提供年月;
            HokenshaNo 主キー3 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_証記載保険者番号;
            JigyoshaNo 主キー4 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅支援事業所番号;
            RString 主キー5 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票情報作成区分コード;
            RString 主キー7 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票種別区分コード;
            RString 主キー8 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票明細行番号;
            sut.get給付管理票200004(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null, 主キー7, 主キー8);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型7にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月;
            FlexibleYearMonth 主キー2 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス提供年月;
            HokenshaNo 主キー3 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_証記載保険者番号;
            JigyoshaNo 主キー4 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅支援事業所番号;
            RString 主キー5 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票情報作成区分コード;
            FlexibleDate 主キー6 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票作成年月日;
            RString 主キー8 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票明細行番号;
            sut.get給付管理票200004(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, null, 主キー8);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型8にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月;
            FlexibleYearMonth 主キー2 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス提供年月;
            HokenshaNo 主キー3 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_証記載保険者番号;
            JigyoshaNo 主キー4 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅支援事業所番号;
            RString 主キー5 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票情報作成区分コード;
            FlexibleDate 主キー6 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票作成年月日;
            RString 主キー7 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票種別区分コード;
            sut.get給付管理票200004(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYearMonth.class), any(FlexibleYearMonth.class), any(HokenshaNo.class),
                    any(JigyoshaNo.class), any(RString.class), any(FlexibleDate.class),
                    any(RString.class), any(RString.class))).thenReturn(null);

            FlexibleYearMonth 主キー1 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月;
            FlexibleYearMonth 主キー2 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス提供年月;
            HokenshaNo 主キー3 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_証記載保険者番号;
            JigyoshaNo 主キー4 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅支援事業所番号;
            RString 主キー5 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票情報作成区分コード;
            FlexibleDate 主キー6 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票作成年月日;
            RString 主キー7 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票種別区分コード;
            RString 主キー8 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票明細行番号;
            KyufuKanrihyo200004 result = sut.get給付管理票200004(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3014KyufuKanrihyo200004Entity entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            when(dac.selectByKey(any(FlexibleYearMonth.class), any(FlexibleYearMonth.class), any(HokenshaNo.class),
                    any(JigyoshaNo.class), any(RString.class), any(FlexibleDate.class),
                    any(RString.class), any(RString.class))).thenReturn(entity);

            FlexibleYearMonth 主キー1 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月;
            FlexibleYearMonth 主キー2 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス提供年月;
            HokenshaNo 主キー3 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_証記載保険者番号;
            JigyoshaNo 主キー4 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅支援事業所番号;
            RString 主キー5 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票情報作成区分コード;
            FlexibleDate 主キー6 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票作成年月日;
            RString 主キー7 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票種別区分コード;
            RString 主キー8 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票明細行番号;
            KyufuKanrihyo200004 result = sut.get給付管理票200004(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8);

            assertThat(result.get主キー1().toDateString(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月.toDateString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付管理票200004一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KyufuKanrihyo200004> result = sut.get給付管理票200004一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3014KyufuKanrihyo200004Entity> entityList = Arrays.asList(DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KyufuKanrihyo200004> result = sut.get給付管理票200004一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().toDateString(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月.toDateString()));
        }
    }

    public static class save給付管理票200004 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3014KyufuKanrihyo200004Entity.class))).thenReturn(1);

            DbT3014KyufuKanrihyo200004Entity entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            KyufuKanrihyo200004 給付管理票200004 = new KyufuKanrihyo200004(entity);

            assertThat(sut.save給付管理票200004(給付管理票200004), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3014KyufuKanrihyo200004Entity.class))).thenReturn(0);

            DbT3014KyufuKanrihyo200004Entity entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            KyufuKanrihyo200004 給付管理票200004 = new KyufuKanrihyo200004(entity);

            assertThat(sut.save給付管理票200004(給付管理票200004), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3014KyufuKanrihyo200004Entity.class))).thenReturn(1);

            DbT3014KyufuKanrihyo200004Entity entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            entity.initializeMd5();
            KyufuKanrihyo200004 給付管理票200004 = new KyufuKanrihyo200004(entity);
            給付管理票200004 = 給付管理票200004.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save給付管理票200004(給付管理票200004), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3014KyufuKanrihyo200004Entity.class))).thenReturn(0);

            DbT3014KyufuKanrihyo200004Entity entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            entity.initializeMd5();
            KyufuKanrihyo200004 給付管理票200004 = new KyufuKanrihyo200004(entity);
            給付管理票200004 = 給付管理票200004.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save給付管理票200004(給付管理票200004), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3014KyufuKanrihyo200004Entity.class))).thenReturn(1);

            DbT3014KyufuKanrihyo200004Entity entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            entity.initializeMd5();
            KyufuKanrihyo200004 給付管理票200004 = new KyufuKanrihyo200004(entity);
            給付管理票200004 = 給付管理票200004.deleted();

            assertThat(sut.save給付管理票200004(給付管理票200004), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3014KyufuKanrihyo200004Entity.class))).thenReturn(0);

            DbT3014KyufuKanrihyo200004Entity entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            entity.initializeMd5();
            KyufuKanrihyo200004 給付管理票200004 = new KyufuKanrihyo200004(entity);
            給付管理票200004 = 給付管理票200004.deleted();

            assertThat(sut.save給付管理票200004(給付管理票200004), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3014KyufuKanrihyo200004Entity entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            entity.initializeMd5();
            KyufuKanrihyo200004 給付管理票200004 = new KyufuKanrihyo200004(entity);

            assertThat(sut.save給付管理票200004(給付管理票200004), is(false));
        }
    }
}
