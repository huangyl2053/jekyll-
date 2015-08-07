/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link GappeiNaiJutokushaShinKyuNoHenkanManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GappeiNaiJutokushaShinKyuNoHenkanManagerTest {

    private static DbT7033GappeiNaiJutokushaShinKyuNoHenkanDac dac;
    private static GappeiNaiJutokushaShinKyuNoHenkanManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7033GappeiNaiJutokushaShinKyuNoHenkanDac.class);
        sut = new GappeiNaiJutokushaShinKyuNoHenkanManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get合併内住特者新旧番号変換テーブル extends FdaTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_主キー2;
            sut.get合併内住特者新旧番号変換テーブル(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_主キー1;
            sut.get合併内住特者新旧番号変換テーブル(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_主キー2;
            GappeiNaiJutokushaShinKyuNoHenkan result = sut.get合併内住特者新旧番号変換テーブル(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_主キー2;
            GappeiNaiJutokushaShinKyuNoHenkan result = sut.get合併内住特者新旧番号変換テーブル(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get合併内住特者新旧番号変換テーブル一覧 extends FdaTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<GappeiNaiJutokushaShinKyuNoHenkan> result = sut.get合併内住特者新旧番号変換テーブル一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity> entityList = Arrays.asList(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<GappeiNaiJutokushaShinKyuNoHenkan> result = sut.get合併内住特者新旧番号変換テーブル一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save合併内住特者新旧番号変換テーブル extends XxxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity.class))).thenReturn(1);

            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            GappeiNaiJutokushaShinKyuNoHenkan 合併内住特者新旧番号変換テーブル = new GappeiNaiJutokushaShinKyuNoHenkan(entity);

            assertThat(sut.save合併内住特者新旧番号変換テーブル(合併内住特者新旧番号変換テーブル), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity.class))).thenReturn(0);

            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            GappeiNaiJutokushaShinKyuNoHenkan 合併内住特者新旧番号変換テーブル = new GappeiNaiJutokushaShinKyuNoHenkan(entity);

            assertThat(sut.save合併内住特者新旧番号変換テーブル(合併内住特者新旧番号変換テーブル), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity.class))).thenReturn(1);

            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            entity.initializeMd5();
            GappeiNaiJutokushaShinKyuNoHenkan 合併内住特者新旧番号変換テーブル = new GappeiNaiJutokushaShinKyuNoHenkan(entity);
            合併内住特者新旧番号変換テーブル = 合併内住特者新旧番号変換テーブル.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save合併内住特者新旧番号変換テーブル(合併内住特者新旧番号変換テーブル), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity.class))).thenReturn(0);

            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            entity.initializeMd5();
            GappeiNaiJutokushaShinKyuNoHenkan 合併内住特者新旧番号変換テーブル = new GappeiNaiJutokushaShinKyuNoHenkan(entity);
            合併内住特者新旧番号変換テーブル = 合併内住特者新旧番号変換テーブル.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save合併内住特者新旧番号変換テーブル(合併内住特者新旧番号変換テーブル), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity.class))).thenReturn(1);

            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            entity.initializeMd5();
            GappeiNaiJutokushaShinKyuNoHenkan 合併内住特者新旧番号変換テーブル = new GappeiNaiJutokushaShinKyuNoHenkan(entity);
            合併内住特者新旧番号変換テーブル = 合併内住特者新旧番号変換テーブル.deleted();

            assertThat(sut.save合併内住特者新旧番号変換テーブル(合併内住特者新旧番号変換テーブル), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity.class))).thenReturn(0);

            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            entity.initializeMd5();
            GappeiNaiJutokushaShinKyuNoHenkan 合併内住特者新旧番号変換テーブル = new GappeiNaiJutokushaShinKyuNoHenkan(entity);
            合併内住特者新旧番号変換テーブル = 合併内住特者新旧番号変換テーブル.deleted();

            assertThat(sut.save合併内住特者新旧番号変換テーブル(合併内住特者新旧番号変換テーブル), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            entity.initializeMd5();
            GappeiNaiJutokushaShinKyuNoHenkan 合併内住特者新旧番号変換テーブル = new GappeiNaiJutokushaShinKyuNoHenkan(entity);

            assertThat(sut.save合併内住特者新旧番号変換テーブル(合併内住特者新旧番号変換テーブル), is(false));
        }
    }
}
