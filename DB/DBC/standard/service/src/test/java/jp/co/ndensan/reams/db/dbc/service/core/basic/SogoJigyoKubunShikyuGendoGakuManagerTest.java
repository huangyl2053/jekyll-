/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoKubunShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7117SogoJigyoKubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7117SogoJigyoKubunShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link SogoJigyoKubunShikyuGendoGakuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class SogoJigyoKubunShikyuGendoGakuManagerTest {

    private static DbT7117SogoJigyoKubunShikyuGendoGakuDac dac;
    private static SogoJigyoKubunShikyuGendoGakuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7117SogoJigyoKubunShikyuGendoGakuDac.class);
        sut = new SogoJigyoKubunShikyuGendoGakuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護予防_日常生活支援総合事業区分支給限度額 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のRStringにnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_適用終了年月;
            int 主キー3 = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            sut.get介護予防_日常生活支援総合事業区分支給限度額(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のFlexibleYearMonthにnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
            int 主キー3 = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            sut.get介護予防_日常生活支援総合事業区分支給限度額(主キー1, null, 主キー3);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(RString.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(null);

            RString 主キー1 = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
            FlexibleYearMonth 主キー2 = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_適用終了年月;
            int 主キー3 = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            SogoJigyoKubunShikyuGendoGaku result = sut.get介護予防_日常生活支援総合事業区分支給限度額(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity();
            when(dac.selectByKey(any(RString.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(entity);

            RString 主キー1 = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
            FlexibleYearMonth 主キー2 = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_適用終了年月;
            int 主キー3 = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            SogoJigyoKubunShikyuGendoGaku result = sut.get介護予防_日常生活支援総合事業区分支給限度額(主キー1, 主キー2, 主キー3);

            assertThat(result.get要介護状態区分(), is(DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護予防_日常生活支援総合事業区分支給限度額一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<SogoJigyoKubunShikyuGendoGaku> result = sut.get介護予防_日常生活支援総合事業区分支給限度額一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7117SogoJigyoKubunShikyuGendoGakuEntity> entityList = Arrays.asList(DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<SogoJigyoKubunShikyuGendoGaku> result = sut.get介護予防_日常生活支援総合事業区分支給限度額一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get要介護状態区分(), is(DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分));
        }
    }

    public static class save介護予防_日常生活支援総合事業区分支給限度額 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7117SogoJigyoKubunShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity();
            SogoJigyoKubunShikyuGendoGaku 介護予防_日常生活支援総合事業区分支給限度額 = new SogoJigyoKubunShikyuGendoGaku(entity);

            assertThat(sut.save介護予防_日常生活支援総合事業区分支給限度額(介護予防_日常生活支援総合事業区分支給限度額), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7117SogoJigyoKubunShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity();
            SogoJigyoKubunShikyuGendoGaku 介護予防_日常生活支援総合事業区分支給限度額 = new SogoJigyoKubunShikyuGendoGaku(entity);

            assertThat(sut.save介護予防_日常生活支援総合事業区分支給限度額(介護予防_日常生活支援総合事業区分支給限度額), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7117SogoJigyoKubunShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            SogoJigyoKubunShikyuGendoGaku 介護予防_日常生活支援総合事業区分支給限度額 = new SogoJigyoKubunShikyuGendoGaku(entity);
            介護予防_日常生活支援総合事業区分支給限度額 = 介護予防_日常生活支援総合事業区分支給限度額.createBuilderForEdit().set要介護状態区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護予防_日常生活支援総合事業区分支給限度額(介護予防_日常生活支援総合事業区分支給限度額), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7117SogoJigyoKubunShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            SogoJigyoKubunShikyuGendoGaku 介護予防_日常生活支援総合事業区分支給限度額 = new SogoJigyoKubunShikyuGendoGaku(entity);
            介護予防_日常生活支援総合事業区分支給限度額 = 介護予防_日常生活支援総合事業区分支給限度額.createBuilderForEdit().set要介護状態区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護予防_日常生活支援総合事業区分支給限度額(介護予防_日常生活支援総合事業区分支給限度額), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7117SogoJigyoKubunShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            SogoJigyoKubunShikyuGendoGaku 介護予防_日常生活支援総合事業区分支給限度額 = new SogoJigyoKubunShikyuGendoGaku(entity);
            介護予防_日常生活支援総合事業区分支給限度額 = 介護予防_日常生活支援総合事業区分支給限度額.deleted();

            assertThat(sut.save介護予防_日常生活支援総合事業区分支給限度額(介護予防_日常生活支援総合事業区分支給限度額), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7117SogoJigyoKubunShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            SogoJigyoKubunShikyuGendoGaku 介護予防_日常生活支援総合事業区分支給限度額 = new SogoJigyoKubunShikyuGendoGaku(entity);
            介護予防_日常生活支援総合事業区分支給限度額 = 介護予防_日常生活支援総合事業区分支給限度額.deleted();

            assertThat(sut.save介護予防_日常生活支援総合事業区分支給限度額(介護予防_日常生活支援総合事業区分支給限度額), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            SogoJigyoKubunShikyuGendoGaku 介護予防_日常生活支援総合事業区分支給限度額 = new SogoJigyoKubunShikyuGendoGaku(entity);

            assertThat(sut.save介護予防_日常生活支援総合事業区分支給限度額(介護予防_日常生活支援総合事業区分支給限度額), is(false));
        }
    }
}
