/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GappeiNaiJutokushaShinKyuNoHenkan;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link GappeiNaiJutokushaShinKyuNoHenkanManager}のテストクラスです。
 */
@Ignore
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
    public static class get合併内住特者新旧番号変換テーブル extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の識別コードにnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 識別コード = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード;
            RString 履歴番号 = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_履歴番号;
            sut.get合併内住特者新旧番号変換テーブル(null, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の履歴番号にnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 識別コード = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード;
            RString 履歴番号 = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_履歴番号;
            sut.get合併内住特者新旧番号変換テーブル(識別コード, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShikibetsuCode.class), any(RString.class))).thenReturn(null);
            ShikibetsuCode 識別コード = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード;
            RString 履歴番号 = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_履歴番号;
            GappeiNaiJutokushaShinKyuNoHenkan result = sut.get合併内住特者新旧番号変換テーブル(識別コード, 履歴番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            when(dac.selectByKey(any(ShikibetsuCode.class), any(RString.class))).thenReturn(entity);
            ShikibetsuCode 識別コード = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード;
            RString 履歴番号 = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_履歴番号;
            GappeiNaiJutokushaShinKyuNoHenkan result = sut.get合併内住特者新旧番号変換テーブル(識別コード, 履歴番号);

            assertThat(result.get識別コード().value(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get合併内住特者新旧番号変換テーブル一覧 extends DbzTestBase {

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
            assertThat(result.get(0).get識別コード().value(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    public static class save合併内住特者新旧番号変換テーブル extends DbzTestBase {

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
            合併内住特者新旧番号変換テーブル = 合併内住特者新旧番号変換テーブル.createBuilderForEdit().set履歴番号(new RString("履歴番号を変更")).build();

            assertThat(sut.save合併内住特者新旧番号変換テーブル(合併内住特者新旧番号変換テーブル), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity.class))).thenReturn(0);

            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            entity.initializeMd5();
            GappeiNaiJutokushaShinKyuNoHenkan 合併内住特者新旧番号変換テーブル = new GappeiNaiJutokushaShinKyuNoHenkan(entity);
            合併内住特者新旧番号変換テーブル = 合併内住特者新旧番号変換テーブル.createBuilderForEdit().set履歴番号(new RString("履歴番号を変更")).build();

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
