/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.view.FukaAlive;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbV2002FukaAliveDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {link FukaAliveManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class FukaAliveManagerTest {

    private static DbV2002FukaAliveDac dac;
    private static FukaAliveManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbV2002FukaAliveDac.class);
        sut = new FukaAliveManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get賦課Alive extends DbzTestBase {

        FlexibleYear 調定年度 = DbV2002FukaEntityGenerator.DEFAULT_調定年度;
        FlexibleYear 賦課年度 = DbV2002FukaEntityGenerator.DEFAULT_賦課年度;
        TsuchishoNo 通知書番号 = DbV2002FukaEntityGenerator.DEFAULT_通知書番号;
        int 履歴番号 = DbV2002FukaEntityGenerator.DEFAULT_履歴番号;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の調定年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get賦課Alive(null, 賦課年度, 通知書番号, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get賦課Alive(調定年度, null, 通知書番号, 履歴番号);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYear.class), any(FlexibleYear.class), any(TsuchishoNo.class), any(int.class))).thenReturn(null);

            FukaAlive result = sut.get賦課Alive(調定年度, 賦課年度, 通知書番号, 履歴番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbV2002FukaEntity entity = DbV2002FukaEntityGenerator.createDbV2002FukaEntity();
            when(dac.selectByKey(any(FlexibleYear.class), any(FlexibleYear.class), any(TsuchishoNo.class), any(int.class))).thenReturn(entity);

            FukaAlive result = sut.get賦課Alive(調定年度, 賦課年度, 通知書番号, 履歴番号);

            assertThat(result.get調定年度().toString(), is(DbV2002FukaEntityGenerator.DEFAULT_調定年度.toString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get賦課Alive一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<FukaAlive> result = sut.get賦課Alive一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbV2002FukaEntity> entityList = Arrays.asList(DbV2002FukaEntityGenerator.createDbV2002FukaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<FukaAlive> result = sut.get賦課Alive一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get調定年度().toString(), is(DbV2002FukaEntityGenerator.DEFAULT_調定年度.toString()));
        }
    }

    public static class save賦課Alive extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbV2002FukaEntity.class))).thenReturn(1);

            DbV2002FukaEntity entity = DbV2002FukaEntityGenerator.createDbV2002FukaEntity();
            FukaAlive 賦課Alive = new FukaAlive(entity);

            assertThat(sut.save賦課Alive(賦課Alive), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbV2002FukaEntity.class))).thenReturn(0);

            DbV2002FukaEntity entity = DbV2002FukaEntityGenerator.createDbV2002FukaEntity();
            FukaAlive 賦課Alive = new FukaAlive(entity);

            assertThat(sut.save賦課Alive(賦課Alive), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbV2002FukaEntity.class))).thenReturn(1);

            DbV2002FukaEntity entity = DbV2002FukaEntityGenerator.createDbV2002FukaEntity();
            entity.initializeMd5();
            FukaAlive 賦課Alive = new FukaAlive(entity);
            賦課Alive = 賦課Alive.createBuilderForEdit().set資格喪失事由(new RString("資格喪失事由を変更")).build();

            assertThat(sut.save賦課Alive(賦課Alive), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbV2002FukaEntity.class))).thenReturn(0);

            DbV2002FukaEntity entity = DbV2002FukaEntityGenerator.createDbV2002FukaEntity();
            entity.initializeMd5();
            FukaAlive 賦課Alive = new FukaAlive(entity);
            賦課Alive = 賦課Alive.createBuilderForEdit().set資格喪失事由(new RString("資格喪失事由を変更")).build();

            assertThat(sut.save賦課Alive(賦課Alive), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbV2002FukaEntity.class))).thenReturn(1);

            DbV2002FukaEntity entity = DbV2002FukaEntityGenerator.createDbV2002FukaEntity();
            entity.initializeMd5();
            FukaAlive 賦課Alive = new FukaAlive(entity);
            賦課Alive = 賦課Alive.deleted();

            assertThat(sut.save賦課Alive(賦課Alive), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbV2002FukaEntity.class))).thenReturn(0);

            DbV2002FukaEntity entity = DbV2002FukaEntityGenerator.createDbV2002FukaEntity();
            entity.initializeMd5();
            FukaAlive 賦課Alive = new FukaAlive(entity);
            賦課Alive = 賦課Alive.deleted();

            assertThat(sut.save賦課Alive(賦課Alive), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbV2002FukaEntity entity = DbV2002FukaEntityGenerator.createDbV2002FukaEntity();
            entity.initializeMd5();
            FukaAlive 賦課Alive = new FukaAlive(entity);

            assertThat(sut.save賦課Alive(賦課Alive), is(false));
        }
    }
}
