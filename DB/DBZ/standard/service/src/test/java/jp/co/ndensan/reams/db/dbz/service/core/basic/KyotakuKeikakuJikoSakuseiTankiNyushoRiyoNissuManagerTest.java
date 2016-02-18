/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuDac;
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
 * {link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManagerTest {

    private static DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuDac dac;
    private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuDac.class);
        sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get居宅給付計画自己作成短期入所利用日数 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_対象年月;
            int 主キー3 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_履歴番号;
            sut.get居宅給付計画自己作成短期入所利用日数(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_被保険者番号;
            int 主キー3 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_履歴番号;
            sut.get居宅給付計画自己作成短期入所利用日数(主キー1, null, 主キー3);
        }

//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
//            HihokenshaNo 主キー1 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_被保険者番号;
//            FlexibleYearMonth 主キー2 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_対象年月;
//            sut.get居宅給付計画自己作成短期入所利用日数(主キー1, 主キー2, null);
//        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_対象年月;
            int 主キー3 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_履歴番号;
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu result = sut.get居宅給付計画自己作成短期入所利用日数(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_対象年月;
            int 主キー3 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_履歴番号;
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu result = sut.get居宅給付計画自己作成短期入所利用日数(主キー1, 主キー2, 主キー3);

            assertThat(result.get被保険者番号().value(), is(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get居宅給付計画自己作成短期入所利用日数一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu> result = sut.get居宅給付計画自己作成短期入所利用日数一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity> entityList = Arrays.asList(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu> result = sut.get居宅給付計画自己作成短期入所利用日数一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save居宅給付計画自己作成短期入所利用日数 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.class))).thenReturn(1);

            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅給付計画自己作成短期入所利用日数 = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(entity);

            assertThat(sut.save居宅給付計画自己作成短期入所利用日数(居宅給付計画自己作成短期入所利用日数), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.class))).thenReturn(0);

            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅給付計画自己作成短期入所利用日数 = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(entity);

            assertThat(sut.save居宅給付計画自己作成短期入所利用日数(居宅給付計画自己作成短期入所利用日数), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.class))).thenReturn(1);

            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            entity.initializeMd5();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅給付計画自己作成短期入所利用日数 = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(entity);
            居宅給付計画自己作成短期入所利用日数 = 居宅給付計画自己作成短期入所利用日数.createBuilderForEdit().set今回計画利用日数(new Decimal(5)).build();

            assertThat(sut.save居宅給付計画自己作成短期入所利用日数(居宅給付計画自己作成短期入所利用日数), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.class))).thenReturn(0);

            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            entity.initializeMd5();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅給付計画自己作成短期入所利用日数 = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(entity);
            居宅給付計画自己作成短期入所利用日数 = 居宅給付計画自己作成短期入所利用日数.createBuilderForEdit().set今回計画利用日数(new Decimal(5)).build();

            assertThat(sut.save居宅給付計画自己作成短期入所利用日数(居宅給付計画自己作成短期入所利用日数), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.class))).thenReturn(1);

            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            entity.initializeMd5();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅給付計画自己作成短期入所利用日数 = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(entity);
            居宅給付計画自己作成短期入所利用日数 = 居宅給付計画自己作成短期入所利用日数.deleted();

            assertThat(sut.save居宅給付計画自己作成短期入所利用日数(居宅給付計画自己作成短期入所利用日数), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.class))).thenReturn(0);

            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            entity.initializeMd5();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅給付計画自己作成短期入所利用日数 = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(entity);
            居宅給付計画自己作成短期入所利用日数 = 居宅給付計画自己作成短期入所利用日数.deleted();

            assertThat(sut.save居宅給付計画自己作成短期入所利用日数(居宅給付計画自己作成短期入所利用日数), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            entity.initializeMd5();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅給付計画自己作成短期入所利用日数 = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(entity);

            assertThat(sut.save居宅給付計画自己作成短期入所利用日数(居宅給付計画自己作成短期入所利用日数), is(false));
        }
    }
}
