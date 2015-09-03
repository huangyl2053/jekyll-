/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KakushuCodeHenkan;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7027KakushuCodeHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7027KakushuCodeHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7027KakushuCodeHenkanDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.poi.ss.formula.functions.Code;
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
 * {link KakushuCodeHenkanManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KakushuCodeHenkanManagerTest {

    private static DbT7027KakushuCodeHenkanDac dac;
    private static KakushuCodeHenkanManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7027KakushuCodeHenkanDac.class);
        sut = new KakushuCodeHenkanManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get各種コード変換テーブル extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_コード区分;
            RString 主キー3 = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード;
            sut.get各種コード変換テーブル(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            LasdecCode 主キー1 = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード;
            RString 主キー3 = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード;
            sut.get各種コード変換テーブル(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            LasdecCode 主キー1 = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード;
            RString 主キー2 = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_コード区分;
            sut.get各種コード変換テーブル(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(LasdecCode.class), any(RString.class), any(RString.class))).thenReturn(null);
            LasdecCode 主キー1 = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード;
            RString 主キー2 = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_コード区分;
            RString 主キー3 = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード;
            KakushuCodeHenkan result = sut.get各種コード変換テーブル(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7027KakushuCodeHenkanEntity entity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            when(dac.selectByKey(any(LasdecCode.class), any(RString.class), any(RString.class))).thenReturn(entity);
            LasdecCode 主キー1 = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード;
            RString 主キー2 = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_コード区分;
            RString 主キー3 = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード;
            KakushuCodeHenkan result = sut.get各種コード変換テーブル(主キー1, 主キー2, 主キー3);

            assertThat(result.get市町村コード().value(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get各種コード変換テーブル一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KakushuCodeHenkan> result = sut.get各種コード変換テーブル一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7027KakushuCodeHenkanEntity> entityList = Arrays.asList(DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KakushuCodeHenkan> result = sut.get各種コード変換テーブル一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get市町村コード().value(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    public static class save各種コード変換テーブル extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7027KakushuCodeHenkanEntity.class))).thenReturn(1);

            DbT7027KakushuCodeHenkanEntity entity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            KakushuCodeHenkan 各種コード変換テーブル = new KakushuCodeHenkan(entity);

            assertThat(sut.save各種コード変換テーブル(各種コード変換テーブル), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7027KakushuCodeHenkanEntity.class))).thenReturn(0);

            DbT7027KakushuCodeHenkanEntity entity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            KakushuCodeHenkan 各種コード変換テーブル = new KakushuCodeHenkan(entity);

            assertThat(sut.save各種コード変換テーブル(各種コード変換テーブル), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7027KakushuCodeHenkanEntity.class))).thenReturn(1);

            DbT7027KakushuCodeHenkanEntity entity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            entity.initializeMd5();
            KakushuCodeHenkan 各種コード変換テーブル = new KakushuCodeHenkan(entity);
            各種コード変換テーブル = 各種コード変換テーブル.createBuilderForEdit().set内部番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save各種コード変換テーブル(各種コード変換テーブル), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7027KakushuCodeHenkanEntity.class))).thenReturn(0);

            DbT7027KakushuCodeHenkanEntity entity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            entity.initializeMd5();
            KakushuCodeHenkan 各種コード変換テーブル = new KakushuCodeHenkan(entity);
            各種コード変換テーブル = 各種コード変換テーブル.createBuilderForEdit().set内部番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save各種コード変換テーブル(各種コード変換テーブル), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7027KakushuCodeHenkanEntity.class))).thenReturn(1);

            DbT7027KakushuCodeHenkanEntity entity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            entity.initializeMd5();
            KakushuCodeHenkan 各種コード変換テーブル = new KakushuCodeHenkan(entity);
            各種コード変換テーブル = 各種コード変換テーブル.deleted();

            assertThat(sut.save各種コード変換テーブル(各種コード変換テーブル), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7027KakushuCodeHenkanEntity.class))).thenReturn(0);

            DbT7027KakushuCodeHenkanEntity entity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            entity.initializeMd5();
            KakushuCodeHenkan 各種コード変換テーブル = new KakushuCodeHenkan(entity);
            各種コード変換テーブル = 各種コード変換テーブル.deleted();

            assertThat(sut.save各種コード変換テーブル(各種コード変換テーブル), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7027KakushuCodeHenkanEntity entity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            entity.initializeMd5();
            KakushuCodeHenkan 各種コード変換テーブル = new KakushuCodeHenkan(entity);

            assertThat(sut.save各種コード変換テーブル(各種コード変換テーブル), is(false));
        }
    }
}
