/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinKyuIryoKikanShujiiNoHenkan;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkanDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {link ShinKyuIryoKikanShujiiNoHenkanManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinKyuIryoKikanShujiiNoHenkanManagerTest {

    private static DbT7030ShinKyuIryoKikanShujiiNoHenkanDac dac;
    private static ShinKyuIryoKikanShujiiNoHenkanManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7030ShinKyuIryoKikanShujiiNoHenkanDac.class);
        sut = new ShinKyuIryoKikanShujiiNoHenkanManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get新旧医療機関主治医番号変換テーブル extends DbzTestBase {

        LasdecCode 市町村コード = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_市町村コード;
        RString 旧医療機関番号 = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧医療機関番号;
        RString 旧主治医番号 = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧主治医番号;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get新旧医療機関主治医番号変換テーブル(null, 旧医療機関番号, 旧主治医番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の旧医療機関番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get新旧医療機関主治医番号変換テーブル(市町村コード, null, 旧主治医番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の旧主治医番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get新旧医療機関主治医番号変換テーブル(市町村コード, 旧医療機関番号, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(LasdecCode.class), any(RString.class), any(RString.class))).thenReturn(null);

            ShinKyuIryoKikanShujiiNoHenkan result = sut.get新旧医療機関主治医番号変換テーブル(市町村コード, 旧医療機関番号, 旧主治医番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            when(dac.selectByKey(any(LasdecCode.class), any(RString.class), any(RString.class))).thenReturn(entity);

            ShinKyuIryoKikanShujiiNoHenkan result = sut.get新旧医療機関主治医番号変換テーブル(市町村コード, 旧医療機関番号, 旧主治医番号);

            assertThat(result.get市町村コード().value(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get新旧医療機関主治医番号変換テーブル一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShinKyuIryoKikanShujiiNoHenkan> result = sut.get新旧医療機関主治医番号変換テーブル一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity> entityList = Arrays.asList(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShinKyuIryoKikanShujiiNoHenkan> result = sut.get新旧医療機関主治医番号変換テーブル一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get市町村コード().value(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    public static class save新旧医療機関主治医番号変換テーブル extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity.class))).thenReturn(1);

            DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            ShinKyuIryoKikanShujiiNoHenkan 新旧医療機関主治医番号変換テーブル = new ShinKyuIryoKikanShujiiNoHenkan(entity);

            assertThat(sut.save新旧医療機関主治医番号変換テーブル(新旧医療機関主治医番号変換テーブル), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity.class))).thenReturn(0);

            DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            ShinKyuIryoKikanShujiiNoHenkan 新旧医療機関主治医番号変換テーブル = new ShinKyuIryoKikanShujiiNoHenkan(entity);

            assertThat(sut.save新旧医療機関主治医番号変換テーブル(新旧医療機関主治医番号変換テーブル), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity.class))).thenReturn(1);

            DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            entity.initializeMd5();
            ShinKyuIryoKikanShujiiNoHenkan 新旧医療機関主治医番号変換テーブル = new ShinKyuIryoKikanShujiiNoHenkan(entity);
            新旧医療機関主治医番号変換テーブル = 新旧医療機関主治医番号変換テーブル.createBuilderForEdit().set旧医療機関番号(new RString("旧医療機関番号を変更")).build();

            assertThat(sut.save新旧医療機関主治医番号変換テーブル(新旧医療機関主治医番号変換テーブル), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity.class))).thenReturn(0);

            DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            entity.initializeMd5();
            ShinKyuIryoKikanShujiiNoHenkan 新旧医療機関主治医番号変換テーブル = new ShinKyuIryoKikanShujiiNoHenkan(entity);
            新旧医療機関主治医番号変換テーブル = 新旧医療機関主治医番号変換テーブル.createBuilderForEdit().set旧医療機関番号(new RString("旧医療機関番号を変更")).build();

            assertThat(sut.save新旧医療機関主治医番号変換テーブル(新旧医療機関主治医番号変換テーブル), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity.class))).thenReturn(1);

            DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            entity.initializeMd5();
            ShinKyuIryoKikanShujiiNoHenkan 新旧医療機関主治医番号変換テーブル = new ShinKyuIryoKikanShujiiNoHenkan(entity);
            新旧医療機関主治医番号変換テーブル = 新旧医療機関主治医番号変換テーブル.deleted();

            assertThat(sut.save新旧医療機関主治医番号変換テーブル(新旧医療機関主治医番号変換テーブル), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity.class))).thenReturn(0);

            DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            entity.initializeMd5();
            ShinKyuIryoKikanShujiiNoHenkan 新旧医療機関主治医番号変換テーブル = new ShinKyuIryoKikanShujiiNoHenkan(entity);
            新旧医療機関主治医番号変換テーブル = 新旧医療機関主治医番号変換テーブル.deleted();

            assertThat(sut.save新旧医療機関主治医番号変換テーブル(新旧医療機関主治医番号変換テーブル), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            entity.initializeMd5();
            ShinKyuIryoKikanShujiiNoHenkan 新旧医療機関主治医番号変換テーブル = new ShinKyuIryoKikanShujiiNoHenkan(entity);

            assertThat(sut.save新旧医療機関主治医番号変換テーブル(新旧医療機関主治医番号変換テーブル), is(false));
        }
    }
}
