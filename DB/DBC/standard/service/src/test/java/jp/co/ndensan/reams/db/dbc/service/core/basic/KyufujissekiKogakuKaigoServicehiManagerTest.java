/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
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
 * {link KyufujissekiKogakuKaigoServicehiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiKogakuKaigoServicehiManagerTest {

    private static DbT3028KyufujissekiKogakuKaigoServicehiDac dac;
    private static KyufujissekiKogakuKaigoServicehiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3028KyufujissekiKogakuKaigoServicehiDac.class);
        sut = new KyufujissekiKogakuKaigoServicehiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付実績高額介護サービス費 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            NyuryokuShikibetsuNo 主キー2 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー7 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号;
            RString 主キー8 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード;
            RString 主キー9 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード;
            sut.get給付実績高額介護サービス費(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号;
            RString 主キー3 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー7 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号;
            RString 主キー8 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード;
            RString 主キー9 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード;
            sut.get給付実績高額介護サービス費(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号;
            HokenshaNo 主キー4 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー7 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号;
            RString 主キー8 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード;
            RString 主キー9 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード;
            sut.get給付実績高額介護サービス費(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード;
            HihokenshaNo 主キー5 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー7 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号;
            RString 主キー8 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード;
            RString 主キー9 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード;
            sut.get給付実績高額介護サービス費(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号;
            FlexibleYearMonth 主キー6 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー7 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号;
            RString 主キー8 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード;
            RString 主キー9 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード;
            sut.get給付実績高額介護サービス費(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6, 主キー7, 主キー8, 主キー9);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー7 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号;
            RString 主キー8 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード;
            RString 主キー9 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード;
            sut.get給付実績高額介護サービス費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null, 主キー7, 主キー8, 主キー9);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型7にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー8 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード;
            RString 主キー9 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード;
            sut.get給付実績高額介護サービス費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, null, 主キー8, 主キー9);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型8にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー7 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号;
            RString 主キー9 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード;
            sut.get給付実績高額介護サービス費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, null, 主キー9);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型9にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー7 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号;
            RString 主キー8 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード;
            sut.get給付実績高額介護サービス費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(KokanShikibetsuNo.class), any(NyuryokuShikibetsuNo.class), any(RString.class),
                    any(HokenshaNo.class), any(HihokenshaNo.class), any(FlexibleYearMonth.class),
                    any(RString.class), any(RString.class), any(RString.class))).thenReturn(null);
            KokanShikibetsuNo 主キー1 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー7 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号;
            RString 主キー8 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード;
            RString 主キー9 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード;
            KyufujissekiKogakuKaigoServicehi result = sut.get給付実績高額介護サービス費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3028KyufujissekiKogakuKaigoServicehiEntity entity = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity();
            when(dac.selectByKey(any(KokanShikibetsuNo.class), any(NyuryokuShikibetsuNo.class), any(RString.class),
                    any(HokenshaNo.class), any(HihokenshaNo.class), any(FlexibleYearMonth.class),
                    any(RString.class), any(RString.class), any(RString.class))).thenReturn(entity);
            KokanShikibetsuNo 主キー1 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー7 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号;
            RString 主キー8 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード;
            RString 主キー9 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード;
            KyufujissekiKogakuKaigoServicehi result = sut.get給付実績高額介護サービス費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9);

            assertThat(result.get主キー1().value(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付実績高額介護サービス費一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KyufujissekiKogakuKaigoServicehi> result = sut.get給付実績高額介護サービス費一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3028KyufujissekiKogakuKaigoServicehiEntity> entityList = Arrays.asList(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KyufujissekiKogakuKaigoServicehi> result = sut.get給付実績高額介護サービス費一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号.value()));
        }
    }

    public static class save給付実績高額介護サービス費 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3028KyufujissekiKogakuKaigoServicehiEntity.class))).thenReturn(1);

            DbT3028KyufujissekiKogakuKaigoServicehiEntity entity = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity();
            KyufujissekiKogakuKaigoServicehi 給付実績高額介護サービス費 = new KyufujissekiKogakuKaigoServicehi(entity);

            assertThat(sut.save給付実績高額介護サービス費(給付実績高額介護サービス費), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3028KyufujissekiKogakuKaigoServicehiEntity.class))).thenReturn(0);

            DbT3028KyufujissekiKogakuKaigoServicehiEntity entity = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity();
            KyufujissekiKogakuKaigoServicehi 給付実績高額介護サービス費 = new KyufujissekiKogakuKaigoServicehi(entity);

            assertThat(sut.save給付実績高額介護サービス費(給付実績高額介護サービス費), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3028KyufujissekiKogakuKaigoServicehiEntity.class))).thenReturn(1);

            DbT3028KyufujissekiKogakuKaigoServicehiEntity entity = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity();
            entity.initializeMd5();
            KyufujissekiKogakuKaigoServicehi 給付実績高額介護サービス費 = new KyufujissekiKogakuKaigoServicehi(entity);
            給付実績高額介護サービス費 = 給付実績高額介護サービス費.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save給付実績高額介護サービス費(給付実績高額介護サービス費), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3028KyufujissekiKogakuKaigoServicehiEntity.class))).thenReturn(0);

            DbT3028KyufujissekiKogakuKaigoServicehiEntity entity = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity();
            entity.initializeMd5();
            KyufujissekiKogakuKaigoServicehi 給付実績高額介護サービス費 = new KyufujissekiKogakuKaigoServicehi(entity);
            給付実績高額介護サービス費 = 給付実績高額介護サービス費.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save給付実績高額介護サービス費(給付実績高額介護サービス費), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3028KyufujissekiKogakuKaigoServicehiEntity.class))).thenReturn(1);

            DbT3028KyufujissekiKogakuKaigoServicehiEntity entity = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity();
            entity.initializeMd5();
            KyufujissekiKogakuKaigoServicehi 給付実績高額介護サービス費 = new KyufujissekiKogakuKaigoServicehi(entity);
            給付実績高額介護サービス費 = 給付実績高額介護サービス費.deleted();

            assertThat(sut.save給付実績高額介護サービス費(給付実績高額介護サービス費), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3028KyufujissekiKogakuKaigoServicehiEntity.class))).thenReturn(0);

            DbT3028KyufujissekiKogakuKaigoServicehiEntity entity = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity();
            entity.initializeMd5();
            KyufujissekiKogakuKaigoServicehi 給付実績高額介護サービス費 = new KyufujissekiKogakuKaigoServicehi(entity);
            給付実績高額介護サービス費 = 給付実績高額介護サービス費.deleted();

            assertThat(sut.save給付実績高額介護サービス費(給付実績高額介護サービス費), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3028KyufujissekiKogakuKaigoServicehiEntity entity = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity();
            entity.initializeMd5();
            KyufujissekiKogakuKaigoServicehi 給付実績高額介護サービス費 = new KyufujissekiKogakuKaigoServicehi(entity);

            assertThat(sut.save給付実績高額介護サービス費(給付実績高額介護サービス費), is(false));
        }
    }
}
