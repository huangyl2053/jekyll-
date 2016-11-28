/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7022ShoriDateKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {link ShoriDateKanriManager}のテストクラスです。
 */
@Ignore
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
    public static class get処理日付管理マスタ extends DbzTestBase {

        SubGyomuCode サブ業務コード = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_サブ業務コード;
        LasdecCode 市町村コード = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_市町村コード;
        RString 処理名 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理名;
        RString 処理枝番 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理枝番;
        FlexibleYear 年度 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度;
        RString 年度内連番 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度内連番;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のサブ業務コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get処理日付管理マスタ(null, 市町村コード, 処理名, 処理枝番, 年度, 年度内連番);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get処理日付管理マスタ(サブ業務コード, null, 処理名, 処理枝番, 年度, 年度内連番);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(SubGyomuCode.class), any(LasdecCode.class), any(RString.class), any(RString.class), any(FlexibleYear.class), any(RString.class))).thenReturn(null);

            ShoriDateKanri result = sut.get処理日付管理マスタ(サブ業務コード, 市町村コード, 処理名, 処理枝番, 年度, 年度内連番);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7022ShoriDateKanriEntity entity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            when(dac.selectByKey(any(SubGyomuCode.class), any(LasdecCode.class), any(RString.class), any(RString.class), any(FlexibleYear.class), any(RString.class))).thenReturn(entity);

            ShoriDateKanri result = sut.get処理日付管理マスタ(サブ業務コード, 市町村コード, 処理名, 処理枝番, 年度, 年度内連番);

            assertThat(result.getサブ業務コード().value(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_サブ業務コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get処理日付管理マスタ一覧 extends DbzTestBase {

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
            assertThat(result.get(0).getサブ業務コード().value(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_サブ業務コード.value()));
        }
    }

    public static class save処理日付管理マスタ extends DbzTestBase {

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
            処理日付管理マスタ = 処理日付管理マスタ.createBuilderForEdit().set処理名(new RString("処理名を変更")).build();

            assertThat(sut.save処理日付管理マスタ(処理日付管理マスタ), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7022ShoriDateKanriEntity.class))).thenReturn(0);

            DbT7022ShoriDateKanriEntity entity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            entity.initializeMd5();
            ShoriDateKanri 処理日付管理マスタ = new ShoriDateKanri(entity);
            処理日付管理マスタ = 処理日付管理マスタ.createBuilderForEdit().set処理名(new RString("処理名を変更")).build();

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
