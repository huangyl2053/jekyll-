/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.view.FukaSearchAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7902FukaSearchEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV7902FukaSearchEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV7902FukaSearchAliveDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link FukaSearchAliveManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class FukaSearchAliveManagerTest {

    private static DbV7902FukaSearchAliveDac dac;
    private static FukaSearchAliveManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbV7902FukaSearchAliveDac.class);
        sut = new FukaSearchAliveManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get賦課検索Alive extends DbzTestBase {

        FlexibleYear 調定年度 = DbV7902FukaSearchEntityGenerator.DEFAULT_調定年度;
        FlexibleYear 賦課年度 = DbV7902FukaSearchEntityGenerator.DEFAULT_賦課年度;
        TsuchishoNo 通知書番号 = DbV7902FukaSearchEntityGenerator.DEFAULT_通知書番号;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の調定年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get賦課検索Alive(null, 賦課年度, 通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get賦課検索Alive(調定年度, null, 通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の通知書番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get賦課検索Alive(調定年度, 賦課年度, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYear.class), any(FlexibleYear.class), any(TsuchishoNo.class))).thenReturn(null);

            FukaSearchAlive result = sut.get賦課検索Alive(調定年度, 賦課年度, 通知書番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbV7902FukaSearchEntity entity = DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity();
            when(dac.selectByKey(any(FlexibleYear.class), any(FlexibleYear.class), any(TsuchishoNo.class))).thenReturn(entity);

            FukaSearchAlive result = sut.get賦課検索Alive(調定年度, 賦課年度, 通知書番号);

            assertThat(result.get調定年度().toString(), is(DbV7902FukaSearchEntityGenerator.DEFAULT_調定年度.toString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get賦課検索Alive一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<FukaSearchAlive> result = sut.get賦課検索Alive一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbV7902FukaSearchEntity> entityList = Arrays.asList(DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<FukaSearchAlive> result = sut.get賦課検索Alive一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get調定年度().toString(), is(DbV7902FukaSearchEntityGenerator.DEFAULT_調定年度.toString()));
        }
    }

    public static class save賦課検索Alive extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbV7902FukaSearchEntity.class))).thenReturn(1);

            DbV7902FukaSearchEntity entity = DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity();
            FukaSearchAlive 賦課検索Alive = new FukaSearchAlive(entity);

            assertThat(sut.save賦課検索Alive(賦課検索Alive), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbV7902FukaSearchEntity.class))).thenReturn(0);

            DbV7902FukaSearchEntity entity = DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity();
            FukaSearchAlive 賦課検索Alive = new FukaSearchAlive(entity);

            assertThat(sut.save賦課検索Alive(賦課検索Alive), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbV7902FukaSearchEntity.class))).thenReturn(1);

            DbV7902FukaSearchEntity entity = DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity();
            entity.initializeMd5();
            FukaSearchAlive 賦課検索Alive = new FukaSearchAlive(entity);
            賦課検索Alive = 賦課検索Alive.createBuilderForEdit().set通知書番号(new TsuchishoNo("通知書番号を変更")).build();

            assertThat(sut.save賦課検索Alive(賦課検索Alive), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbV7902FukaSearchEntity.class))).thenReturn(0);

            DbV7902FukaSearchEntity entity = DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity();
            entity.initializeMd5();
            FukaSearchAlive 賦課検索Alive = new FukaSearchAlive(entity);
            賦課検索Alive = 賦課検索Alive.createBuilderForEdit().set通知書番号(new TsuchishoNo("通知書番号を変更")).build();

            assertThat(sut.save賦課検索Alive(賦課検索Alive), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbV7902FukaSearchEntity.class))).thenReturn(1);

            DbV7902FukaSearchEntity entity = DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity();
            entity.initializeMd5();
            FukaSearchAlive 賦課検索Alive = new FukaSearchAlive(entity);
            賦課検索Alive = 賦課検索Alive.deleted();

            assertThat(sut.save賦課検索Alive(賦課検索Alive), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbV7902FukaSearchEntity.class))).thenReturn(0);

            DbV7902FukaSearchEntity entity = DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity();
            entity.initializeMd5();
            FukaSearchAlive 賦課検索Alive = new FukaSearchAlive(entity);
            賦課検索Alive = 賦課検索Alive.deleted();

            assertThat(sut.save賦課検索Alive(賦課検索Alive), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbV7902FukaSearchEntity entity = DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity();
            entity.initializeMd5();
            FukaSearchAlive 賦課検索Alive = new FukaSearchAlive(entity);

            assertThat(sut.save賦課検索Alive(賦課検索Alive), is(false));
        }
    }
}
