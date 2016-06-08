/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KubunShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7109KubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7109KubunShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7109KubunShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KubunShikyuGendoGakuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KubunShikyuGendoGakuManagerTest {

    private static DbT7109KubunShikyuGendoGakuDac dac;
    private static KubunShikyuGendoGakuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7109KubunShikyuGendoGakuDac.class);
        sut = new KubunShikyuGendoGakuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get居宅サービス区分支給限度額 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
            int 主キー3 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            sut.get居宅サービス区分支給限度額(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
            int 主キー3 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            sut.get居宅サービス区分支給限度額(主キー1, null, 主キー3);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(RString.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(null);
            RString 主キー1 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
            FlexibleYearMonth 主キー2 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
            int 主キー3 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            KubunShikyuGendoGaku result = sut.get居宅サービス区分支給限度額(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7109KubunShikyuGendoGakuEntity entity = DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity();
            when(dac.selectByKey(any(RString.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(entity);
            RString 主キー1 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
            FlexibleYearMonth 主キー2 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
            int 主キー3 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            KubunShikyuGendoGaku result = sut.get居宅サービス区分支給限度額(主キー1, 主キー2, 主キー3);

            assertThat(result.get要介護状態区分(), is(DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get居宅サービス区分支給限度額一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KubunShikyuGendoGaku> result = sut.get居宅サービス区分支給限度額一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7109KubunShikyuGendoGakuEntity> entityList = Arrays.asList(DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KubunShikyuGendoGaku> result = sut.get居宅サービス区分支給限度額一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get要介護状態区分(), is(DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分));
        }
    }

    public static class save居宅サービス区分支給限度額 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7109KubunShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7109KubunShikyuGendoGakuEntity entity = DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity();
            KubunShikyuGendoGaku 居宅サービス区分支給限度額 = new KubunShikyuGendoGaku(entity);

            assertThat(sut.save居宅サービス区分支給限度額(居宅サービス区分支給限度額), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7109KubunShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7109KubunShikyuGendoGakuEntity entity = DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity();
            KubunShikyuGendoGaku 居宅サービス区分支給限度額 = new KubunShikyuGendoGaku(entity);

            assertThat(sut.save居宅サービス区分支給限度額(居宅サービス区分支給限度額), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7109KubunShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7109KubunShikyuGendoGakuEntity entity = DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            KubunShikyuGendoGaku 居宅サービス区分支給限度額 = new KubunShikyuGendoGaku(entity);
            居宅サービス区分支給限度額 = 居宅サービス区分支給限度額.createBuilderForEdit().set要介護状態区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save居宅サービス区分支給限度額(居宅サービス区分支給限度額), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7109KubunShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7109KubunShikyuGendoGakuEntity entity = DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            KubunShikyuGendoGaku 居宅サービス区分支給限度額 = new KubunShikyuGendoGaku(entity);
            居宅サービス区分支給限度額 = 居宅サービス区分支給限度額.createBuilderForEdit().set要介護状態区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save居宅サービス区分支給限度額(居宅サービス区分支給限度額), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7109KubunShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7109KubunShikyuGendoGakuEntity entity = DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            KubunShikyuGendoGaku 居宅サービス区分支給限度額 = new KubunShikyuGendoGaku(entity);
            居宅サービス区分支給限度額 = 居宅サービス区分支給限度額.deleted();

            assertThat(sut.save居宅サービス区分支給限度額(居宅サービス区分支給限度額), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7109KubunShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7109KubunShikyuGendoGakuEntity entity = DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            KubunShikyuGendoGaku 居宅サービス区分支給限度額 = new KubunShikyuGendoGaku(entity);
            居宅サービス区分支給限度額 = 居宅サービス区分支給限度額.deleted();

            assertThat(sut.save居宅サービス区分支給限度額(居宅サービス区分支給限度額), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7109KubunShikyuGendoGakuEntity entity = DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            KubunShikyuGendoGaku 居宅サービス区分支給限度額 = new KubunShikyuGendoGaku(entity);

            assertThat(sut.save居宅サービス区分支給限度額(居宅サービス区分支給限度額), is(false));
        }
    }
}
