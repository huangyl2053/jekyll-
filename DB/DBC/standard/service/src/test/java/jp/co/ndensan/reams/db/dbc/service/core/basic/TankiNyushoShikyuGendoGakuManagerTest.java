/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TankiNyushoShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7110TankiNyushoShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7110TankiNyushoShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7110TankiNyushoShikyuGendoGakuDac;
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
 * {link TankiNyushoShikyuGendoGakuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class TankiNyushoShikyuGendoGakuManagerTest {

    private static DbT7110TankiNyushoShikyuGendoGakuDac dac;
    private static TankiNyushoShikyuGendoGakuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7110TankiNyushoShikyuGendoGakuDac.class);
        sut = new TankiNyushoShikyuGendoGakuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get短期入所系支給限度額 extends DbcTestBase {
        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。

        @Test(expected = NullPointerException.class)
        public void 引数のRStringにnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
            int 主キー3 = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            sut.get短期入所系支給限度額(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のFlexibleYearMonthにnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
            int 主キー3 = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            sut.get短期入所系支給限度額(主キー1, null, 主キー3);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(RString.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(null);

            RString 主キー1 = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
            FlexibleYearMonth 主キー2 = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
            int 主キー3 = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            TankiNyushoShikyuGendoGaku result = sut.get短期入所系支給限度額(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7110TankiNyushoShikyuGendoGakuEntity entity = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity();
            when(dac.selectByKey(any(RString.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(entity);

            RString 主キー1 = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
            FlexibleYearMonth 主キー2 = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
            int 主キー3 = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            TankiNyushoShikyuGendoGaku result = sut.get短期入所系支給限度額(主キー1, 主キー2, 主キー3);

            assertThat(result.get要介護状態区分(), is(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get短期入所系支給限度額一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<TankiNyushoShikyuGendoGaku> result = sut.get短期入所系支給限度額一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7110TankiNyushoShikyuGendoGakuEntity> entityList = Arrays.asList(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<TankiNyushoShikyuGendoGaku> result = sut.get短期入所系支給限度額一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get要介護状態区分(), is(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分));
        }
    }

    public static class save短期入所系支給限度額 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7110TankiNyushoShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7110TankiNyushoShikyuGendoGakuEntity entity = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity();
            TankiNyushoShikyuGendoGaku 短期入所系支給限度額 = new TankiNyushoShikyuGendoGaku(entity);

            assertThat(sut.save短期入所系支給限度額(短期入所系支給限度額), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7110TankiNyushoShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7110TankiNyushoShikyuGendoGakuEntity entity = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity();
            TankiNyushoShikyuGendoGaku 短期入所系支給限度額 = new TankiNyushoShikyuGendoGaku(entity);

            assertThat(sut.save短期入所系支給限度額(短期入所系支給限度額), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7110TankiNyushoShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7110TankiNyushoShikyuGendoGakuEntity entity = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity();
            entity.initializeMd5();
            TankiNyushoShikyuGendoGaku 短期入所系支給限度額 = new TankiNyushoShikyuGendoGaku(entity);
            短期入所系支給限度額 = 短期入所系支給限度額.createBuilderForEdit().set要介護状態区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save短期入所系支給限度額(短期入所系支給限度額), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7110TankiNyushoShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7110TankiNyushoShikyuGendoGakuEntity entity = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity();
            entity.initializeMd5();
            TankiNyushoShikyuGendoGaku 短期入所系支給限度額 = new TankiNyushoShikyuGendoGaku(entity);
            短期入所系支給限度額 = 短期入所系支給限度額.createBuilderForEdit().set要介護状態区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save短期入所系支給限度額(短期入所系支給限度額), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7110TankiNyushoShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7110TankiNyushoShikyuGendoGakuEntity entity = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity();
            entity.initializeMd5();
            TankiNyushoShikyuGendoGaku 短期入所系支給限度額 = new TankiNyushoShikyuGendoGaku(entity);
            短期入所系支給限度額 = 短期入所系支給限度額.deleted();

            assertThat(sut.save短期入所系支給限度額(短期入所系支給限度額), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7110TankiNyushoShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7110TankiNyushoShikyuGendoGakuEntity entity = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity();
            entity.initializeMd5();
            TankiNyushoShikyuGendoGaku 短期入所系支給限度額 = new TankiNyushoShikyuGendoGaku(entity);
            短期入所系支給限度額 = 短期入所系支給限度額.deleted();

            assertThat(sut.save短期入所系支給限度額(短期入所系支給限度額), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7110TankiNyushoShikyuGendoGakuEntity entity = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity();
            entity.initializeMd5();
            TankiNyushoShikyuGendoGaku 短期入所系支給限度額 = new TankiNyushoShikyuGendoGaku(entity);

            assertThat(sut.save短期入所系支給限度額(短期入所系支給限度額), is(false));
        }
    }
}
