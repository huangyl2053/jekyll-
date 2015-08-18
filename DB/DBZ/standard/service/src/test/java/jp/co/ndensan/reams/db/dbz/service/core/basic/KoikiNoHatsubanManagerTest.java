/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KoikiNoHatsuban;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7025KoikiNoHatsubanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7025KoikiNoHatsubanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7025KoikiNoHatsubanDac;
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
 * {link KoikiNoHatsubanManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoikiNoHatsubanManagerTest {

    private static DbT7025KoikiNoHatsubanDac dac;
    private static KoikiNoHatsubanManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7025KoikiNoHatsubanDac.class);
        sut = new KoikiNoHatsubanManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get広域番号発番テーブル extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            RString コード区分 = DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_コード区分;
            sut.get広域番号発番テーブル(null, コード区分);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のコード区分にnullを指定した場合_NullPointerExceptionが発生する() {
            LasdecCode 市町村コード = DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_市町村コード;
            sut.get広域番号発番テーブル(市町村コード, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(LasdecCode.class), any(RString.class))).thenReturn(null);
            LasdecCode 市町村コード = DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_市町村コード;
            RString コード区分 = DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_コード区分;
            KoikiNoHatsuban result = sut.get広域番号発番テーブル(市町村コード, コード区分);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7025KoikiNoHatsubanEntity entity = DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity();
            when(dac.selectByKey(any(LasdecCode.class), any(RString.class))).thenReturn(entity);
            LasdecCode 市町村コード = DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_市町村コード;
            RString コード区分 = DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_コード区分;
            KoikiNoHatsuban result = sut.get広域番号発番テーブル(市町村コード, コード区分);

            assertThat(result.get市町村コード().value(), is(DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get広域番号発番テーブル一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KoikiNoHatsuban> result = sut.get広域番号発番テーブル一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7025KoikiNoHatsubanEntity> entityList = Arrays.asList(DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KoikiNoHatsuban> result = sut.get広域番号発番テーブル一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get市町村コード().value(), is(DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    public static class save広域番号発番テーブル extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7025KoikiNoHatsubanEntity.class))).thenReturn(1);

            DbT7025KoikiNoHatsubanEntity entity = DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity();
            KoikiNoHatsuban 広域番号発番テーブル = new KoikiNoHatsuban(entity);

            assertThat(sut.save広域番号発番テーブル(広域番号発番テーブル), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7025KoikiNoHatsubanEntity.class))).thenReturn(0);

            DbT7025KoikiNoHatsubanEntity entity = DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity();
            KoikiNoHatsuban 広域番号発番テーブル = new KoikiNoHatsuban(entity);

            assertThat(sut.save広域番号発番テーブル(広域番号発番テーブル), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7025KoikiNoHatsubanEntity.class))).thenReturn(1);

            DbT7025KoikiNoHatsubanEntity entity = DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity();
            entity.initializeMd5();
            KoikiNoHatsuban 広域番号発番テーブル = new KoikiNoHatsuban(entity);
            広域番号発番テーブル = 広域番号発番テーブル.createBuilderForEdit().setコード区分(new RString("コード区分を変更")).build();

            assertThat(sut.save広域番号発番テーブル(広域番号発番テーブル), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7025KoikiNoHatsubanEntity.class))).thenReturn(0);

            DbT7025KoikiNoHatsubanEntity entity = DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity();
            entity.initializeMd5();
            KoikiNoHatsuban 広域番号発番テーブル = new KoikiNoHatsuban(entity);
            広域番号発番テーブル = 広域番号発番テーブル.createBuilderForEdit().setコード区分(new RString("コード区分を変更")).build();

            assertThat(sut.save広域番号発番テーブル(広域番号発番テーブル), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7025KoikiNoHatsubanEntity.class))).thenReturn(1);

            DbT7025KoikiNoHatsubanEntity entity = DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity();
            entity.initializeMd5();
            KoikiNoHatsuban 広域番号発番テーブル = new KoikiNoHatsuban(entity);
            広域番号発番テーブル = 広域番号発番テーブル.deleted();

            assertThat(sut.save広域番号発番テーブル(広域番号発番テーブル), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7025KoikiNoHatsubanEntity.class))).thenReturn(0);

            DbT7025KoikiNoHatsubanEntity entity = DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity();
            entity.initializeMd5();
            KoikiNoHatsuban 広域番号発番テーブル = new KoikiNoHatsuban(entity);
            広域番号発番テーブル = 広域番号発番テーブル.deleted();

            assertThat(sut.save広域番号発番テーブル(広域番号発番テーブル), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7025KoikiNoHatsubanEntity entity = DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity();
            entity.initializeMd5();
            KoikiNoHatsuban 広域番号発番テーブル = new KoikiNoHatsuban(entity);

            assertThat(sut.save広域番号発番テーブル(広域番号発番テーブル), is(false));
        }
    }
}
