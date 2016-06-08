/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakuseiGokei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3009KyotakuKeikakuJikoSakuseiGokeiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KyotakuKeikakuJikoSakuseiGokeiManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiGokeiManagerTest {

    private static DbT3009KyotakuKeikakuJikoSakuseiGokeiDac dac;
    private static KyotakuKeikakuJikoSakuseiGokeiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3009KyotakuKeikakuJikoSakuseiGokeiDac.class);
        sut = new KyotakuKeikakuJikoSakuseiGokeiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get居宅給付計画自己作成合計 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月;
            int 主キー3 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_履歴番号;
            RString 主キー4 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分;
            JigyoshaNo 主キー5 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号;
            ServiceShuruiCode 主キー6 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード;
            sut.get居宅給付計画自己作成合計(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月;
            int 主キー3 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_履歴番号;
            RString 主キー4 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分;
            JigyoshaNo 主キー5 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号;
            ServiceShuruiCode 主キー6 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード;
            sut.get居宅給付計画自己作成合計(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6);
        }

//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
//            HihokenshaNo 主キー1 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号;
//            FlexibleYearMonth 主キー2 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月;
//            RString 主キー4 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分;
//            JigyoshaNo 主キー5 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号;
//            ServiceShuruiCode 主キー6 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード;
//            sut.get居宅給付計画自己作成合計(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6);
//        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月;
            int 主キー3 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_履歴番号;
            JigyoshaNo 主キー5 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号;
            ServiceShuruiCode 主キー6 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード;
            sut.get居宅給付計画自己作成合計(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月;
            int 主キー3 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_履歴番号;
            RString 主キー4 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分;
            ServiceShuruiCode 主キー6 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード;
            sut.get居宅給付計画自己作成合計(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月;
            int 主キー3 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_履歴番号;
            RString 主キー4 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分;
            JigyoshaNo 主キー5 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号;
            sut.get居宅給付計画自己作成合計(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(int.class),
                    any(RString.class), any(JigyoshaNo.class), any(ServiceShuruiCode.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月;
            int 主キー3 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_履歴番号;
            RString 主キー4 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分;
            JigyoshaNo 主キー5 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号;
            ServiceShuruiCode 主キー6 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード;
            KyotakuKeikakuJikoSakuseiGokei result = sut.get居宅給付計画自己作成合計(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(int.class),
                    any(RString.class), any(JigyoshaNo.class), any(ServiceShuruiCode.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月;
            int 主キー3 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_履歴番号;
            RString 主キー4 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分;
            JigyoshaNo 主キー5 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号;
            ServiceShuruiCode 主キー6 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード;
            KyotakuKeikakuJikoSakuseiGokei result = sut.get居宅給付計画自己作成合計(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);

            assertThat(result.get被保険者番号().value(), is(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get居宅給付計画自己作成合計一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KyotakuKeikakuJikoSakuseiGokei> result = sut.get居宅給付計画自己作成合計一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity> entityList = Arrays.asList(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KyotakuKeikakuJikoSakuseiGokei> result = sut.get居宅給付計画自己作成合計一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save居宅給付計画自己作成合計 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity.class))).thenReturn(1);

            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            KyotakuKeikakuJikoSakuseiGokei 居宅給付計画自己作成合計 = new KyotakuKeikakuJikoSakuseiGokei(entity);

            assertThat(sut.save居宅給付計画自己作成合計(居宅給付計画自己作成合計), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity.class))).thenReturn(0);

            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            KyotakuKeikakuJikoSakuseiGokei 居宅給付計画自己作成合計 = new KyotakuKeikakuJikoSakuseiGokei(entity);

            assertThat(sut.save居宅給付計画自己作成合計(居宅給付計画自己作成合計), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity.class))).thenReturn(1);

            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            entity.initializeMd5();
            KyotakuKeikakuJikoSakuseiGokei 居宅給付計画自己作成合計 = new KyotakuKeikakuJikoSakuseiGokei(entity);
            居宅給付計画自己作成合計 = 居宅給付計画自己作成合計.createBuilderForEdit().set履歴番号(3).build();

            assertThat(sut.save居宅給付計画自己作成合計(居宅給付計画自己作成合計), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity.class))).thenReturn(0);

            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            entity.initializeMd5();
            KyotakuKeikakuJikoSakuseiGokei 居宅給付計画自己作成合計 = new KyotakuKeikakuJikoSakuseiGokei(entity);
            居宅給付計画自己作成合計 = 居宅給付計画自己作成合計.createBuilderForEdit().set履歴番号(3).build();

            assertThat(sut.save居宅給付計画自己作成合計(居宅給付計画自己作成合計), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity.class))).thenReturn(1);

            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            entity.initializeMd5();
            KyotakuKeikakuJikoSakuseiGokei 居宅給付計画自己作成合計 = new KyotakuKeikakuJikoSakuseiGokei(entity);
            居宅給付計画自己作成合計 = 居宅給付計画自己作成合計.deleted();

            assertThat(sut.save居宅給付計画自己作成合計(居宅給付計画自己作成合計), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity.class))).thenReturn(0);

            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            entity.initializeMd5();
            KyotakuKeikakuJikoSakuseiGokei 居宅給付計画自己作成合計 = new KyotakuKeikakuJikoSakuseiGokei(entity);
            居宅給付計画自己作成合計 = 居宅給付計画自己作成合計.deleted();

            assertThat(sut.save居宅給付計画自己作成合計(居宅給付計画自己作成合計), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            entity.initializeMd5();
            KyotakuKeikakuJikoSakuseiGokei 居宅給付計画自己作成合計 = new KyotakuKeikakuJikoSakuseiGokei(entity);

            assertThat(sut.save居宅給付計画自己作成合計(居宅給付計画自己作成合計), is(false));
        }
    }
}
