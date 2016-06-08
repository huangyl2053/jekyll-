/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinKyuHihokenshaNoHenkan;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7026ShinKyuHihokenshaNoHenkanDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {link ShinKyuHihokenshaNoHenkanManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ShinKyuHihokenshaNoHenkanManagerTest {

    private static DbT7026ShinKyuHihokenshaNoHenkanDac dac;
    private static ShinKyuHihokenshaNoHenkanManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7026ShinKyuHihokenshaNoHenkanDac.class);
        sut = new ShinKyuHihokenshaNoHenkanManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get新旧被保険者番号変換テーブル extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のLasdecCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            RString 旧番号 = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧番号;
            sut.get新旧被保険者番号変換テーブル(null, 旧番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の旧番号にnullを指定した場合_NullPointerExceptionが発生する() {
            LasdecCode 市町村コード = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_市町村コード;
            sut.get新旧被保険者番号変換テーブル(市町村コード, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(LasdecCode.class), any(RString.class))).thenReturn(null);

            LasdecCode 市町村コード = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_市町村コード;
            RString 旧番号 = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧番号;
            ShinKyuHihokenshaNoHenkan result = sut.get新旧被保険者番号変換テーブル(市町村コード, 旧番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7026ShinKyuHihokenshaNoHenkanEntity entity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            when(dac.selectByKey(any(LasdecCode.class), any(RString.class))).thenReturn(entity);

            LasdecCode 市町村コード = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_市町村コード;
            RString 旧番号 = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧番号;
            ShinKyuHihokenshaNoHenkan result = sut.get新旧被保険者番号変換テーブル(市町村コード, 旧番号);

            assertThat(result.get市町村コード().value(), is(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get新旧被保険者番号変換テーブル一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShinKyuHihokenshaNoHenkan> result = sut.get新旧被保険者番号変換テーブル一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7026ShinKyuHihokenshaNoHenkanEntity> entityList = Arrays.asList(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShinKyuHihokenshaNoHenkan> result = sut.get新旧被保険者番号変換テーブル一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get市町村コード().value(), is(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    public static class save新旧被保険者番号変換テーブル extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7026ShinKyuHihokenshaNoHenkanEntity.class))).thenReturn(1);

            DbT7026ShinKyuHihokenshaNoHenkanEntity entity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            ShinKyuHihokenshaNoHenkan 新旧被保険者番号変換テーブル = new ShinKyuHihokenshaNoHenkan(entity);

            assertThat(sut.save新旧被保険者番号変換テーブル(新旧被保険者番号変換テーブル), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7026ShinKyuHihokenshaNoHenkanEntity.class))).thenReturn(0);

            DbT7026ShinKyuHihokenshaNoHenkanEntity entity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            ShinKyuHihokenshaNoHenkan 新旧被保険者番号変換テーブル = new ShinKyuHihokenshaNoHenkan(entity);

            assertThat(sut.save新旧被保険者番号変換テーブル(新旧被保険者番号変換テーブル), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7026ShinKyuHihokenshaNoHenkanEntity.class))).thenReturn(1);

            DbT7026ShinKyuHihokenshaNoHenkanEntity entity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            entity.initializeMd5();
            ShinKyuHihokenshaNoHenkan 新旧被保険者番号変換テーブル = new ShinKyuHihokenshaNoHenkan(entity);
            新旧被保険者番号変換テーブル = 新旧被保険者番号変換テーブル.createBuilderForEdit().set旧番号(new RString("旧番号を変更")).build();

            assertThat(sut.save新旧被保険者番号変換テーブル(新旧被保険者番号変換テーブル), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7026ShinKyuHihokenshaNoHenkanEntity.class))).thenReturn(0);

            DbT7026ShinKyuHihokenshaNoHenkanEntity entity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            entity.initializeMd5();
            ShinKyuHihokenshaNoHenkan 新旧被保険者番号変換テーブル = new ShinKyuHihokenshaNoHenkan(entity);
            新旧被保険者番号変換テーブル = 新旧被保険者番号変換テーブル.createBuilderForEdit().set旧番号(new RString("旧番号を変更")).build();

            assertThat(sut.save新旧被保険者番号変換テーブル(新旧被保険者番号変換テーブル), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7026ShinKyuHihokenshaNoHenkanEntity.class))).thenReturn(1);

            DbT7026ShinKyuHihokenshaNoHenkanEntity entity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            entity.initializeMd5();
            ShinKyuHihokenshaNoHenkan 新旧被保険者番号変換テーブル = new ShinKyuHihokenshaNoHenkan(entity);
            新旧被保険者番号変換テーブル = 新旧被保険者番号変換テーブル.deleted();

            assertThat(sut.save新旧被保険者番号変換テーブル(新旧被保険者番号変換テーブル), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7026ShinKyuHihokenshaNoHenkanEntity.class))).thenReturn(0);

            DbT7026ShinKyuHihokenshaNoHenkanEntity entity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            entity.initializeMd5();
            ShinKyuHihokenshaNoHenkan 新旧被保険者番号変換テーブル = new ShinKyuHihokenshaNoHenkan(entity);
            新旧被保険者番号変換テーブル = 新旧被保険者番号変換テーブル.deleted();

            assertThat(sut.save新旧被保険者番号変換テーブル(新旧被保険者番号変換テーブル), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7026ShinKyuHihokenshaNoHenkanEntity entity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            entity.initializeMd5();
            ShinKyuHihokenshaNoHenkan 新旧被保険者番号変換テーブル = new ShinKyuHihokenshaNoHenkan(entity);

            assertThat(sut.save新旧被保険者番号変換テーブル(新旧被保険者番号変換テーブル), is(false));
        }
    }
}
