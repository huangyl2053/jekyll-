/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7022ShoriDateKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
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
 * {link ShoriDateKanriManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShoriDateKanriManagerTest {

    private static DbT7022ShoriDateKanriDac dac;
    private static ShoriDateKanriManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7022ShoriDateKanriDac.class);
        sut = new ShoriDateKanriManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get処理日付管理マスタ extends FdaTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_主キー2;
            sut.get処理日付管理マスタ(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_主キー1;
            sut.get処理日付管理マスタ(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_主キー2;
            ShoriDateKanri result = sut.get処理日付管理マスタ(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7022ShoriDateKanriEntity entity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_主キー2;
            ShoriDateKanri result = sut.get処理日付管理マスタ(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get処理日付管理マスタ一覧 extends FdaTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShoriDateKanri> result = sut.get処理日付管理マスタ一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7022ShoriDateKanriEntity> entityList = Arrays.asList(DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShoriDateKanri> result = sut.get処理日付管理マスタ一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save処理日付管理マスタ extends XxxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7022ShoriDateKanriEntity.class))).thenReturn(1);

            DbT7022ShoriDateKanriEntity entity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            ShoriDateKanri 処理日付管理マスタ = new ShoriDateKanri(entity);

            assertThat(sut.save処理日付管理マスタ(処理日付管理マスタ), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7022ShoriDateKanriEntity.class))).thenReturn(0);

            DbT7022ShoriDateKanriEntity entity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            ShoriDateKanri 処理日付管理マスタ = new ShoriDateKanri(entity);

            assertThat(sut.save処理日付管理マスタ(処理日付管理マスタ), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7022ShoriDateKanriEntity.class))).thenReturn(1);

            DbT7022ShoriDateKanriEntity entity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            entity.initializeMd5();
            ShoriDateKanri 処理日付管理マスタ = new ShoriDateKanri(entity);
            処理日付管理マスタ = 処理日付管理マスタ.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save処理日付管理マスタ(処理日付管理マスタ), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7022ShoriDateKanriEntity.class))).thenReturn(0);

            DbT7022ShoriDateKanriEntity entity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            entity.initializeMd5();
            ShoriDateKanri 処理日付管理マスタ = new ShoriDateKanri(entity);
            処理日付管理マスタ = 処理日付管理マスタ.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save処理日付管理マスタ(処理日付管理マスタ), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7022ShoriDateKanriEntity.class))).thenReturn(1);

            DbT7022ShoriDateKanriEntity entity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            entity.initializeMd5();
            ShoriDateKanri 処理日付管理マスタ = new ShoriDateKanri(entity);
            処理日付管理マスタ = 処理日付管理マスタ.deleted();

            assertThat(sut.save処理日付管理マスタ(処理日付管理マスタ), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7022ShoriDateKanriEntity.class))).thenReturn(0);

            DbT7022ShoriDateKanriEntity entity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            entity.initializeMd5();
            ShoriDateKanri 処理日付管理マスタ = new ShoriDateKanri(entity);
            処理日付管理マスタ = 処理日付管理マスタ.deleted();

            assertThat(sut.save処理日付管理マスタ(処理日付管理マスタ), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7022ShoriDateKanriEntity entity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            entity.initializeMd5();
            ShoriDateKanri 処理日付管理マスタ = new ShoriDateKanri(entity);

            assertThat(sut.save処理日付管理マスタ(処理日付管理マスタ), is(false));
        }
    }
}
