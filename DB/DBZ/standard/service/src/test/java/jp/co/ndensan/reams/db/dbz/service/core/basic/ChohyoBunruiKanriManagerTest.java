/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7068ChohyoBunruiKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7068ChohyoBunruiKanriDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * {link ChohyoBunruiKanriManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChohyoBunruiKanriManagerTest {

    private static DbT7068ChohyoBunruiKanriDac dac;
    private static ChohyoBunruiKanriManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7068ChohyoBunruiKanriDac.class);
        sut = new ChohyoBunruiKanriManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get帳票分類管理 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            ReportId 主キー2 = DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_帳票ID;
            sut.get帳票分類管理(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            SubGyomuCode 主キー1 = DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_サブ業務コード;
            sut.get帳票分類管理(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(SubGyomuCode.class), any(ReportId.class))).thenReturn(null);
            SubGyomuCode 主キー1 = DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_帳票ID;
            ChohyoBunruiKanri result = sut.get帳票分類管理(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7068ChohyoBunruiKanriEntity entity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            when(dac.selectByKey(any(SubGyomuCode.class), any(ReportId.class))).thenReturn(entity);
            SubGyomuCode 主キー1 = DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_帳票ID;
            ChohyoBunruiKanri result = sut.get帳票分類管理(主キー1, 主キー2);

            assertThat(result.getサブ業務コード().value(), is(DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_サブ業務コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get帳票分類管理一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ChohyoBunruiKanri> result = sut.get帳票分類管理一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7068ChohyoBunruiKanriEntity> entityList = Arrays.asList(DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ChohyoBunruiKanri> result = sut.get帳票分類管理一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getサブ業務コード().value(), is(DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_サブ業務コード.value()));
        }
    }

    public static class save帳票分類管理 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7068ChohyoBunruiKanriEntity.class))).thenReturn(1);

            DbT7068ChohyoBunruiKanriEntity entity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            ChohyoBunruiKanri 帳票分類管理 = new ChohyoBunruiKanri(entity);

            assertThat(sut.save帳票分類管理(帳票分類管理), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7068ChohyoBunruiKanriEntity.class))).thenReturn(0);

            DbT7068ChohyoBunruiKanriEntity entity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            ChohyoBunruiKanri 帳票分類管理 = new ChohyoBunruiKanri(entity);

            assertThat(sut.save帳票分類管理(帳票分類管理), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7068ChohyoBunruiKanriEntity.class))).thenReturn(1);

            DbT7068ChohyoBunruiKanriEntity entity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            entity.initializeMd5();
            ChohyoBunruiKanri 帳票分類管理 = new ChohyoBunruiKanri(entity);
            帳票分類管理 = 帳票分類管理.createBuilderForEdit().set帳票分類ID(new ReportId("12")).build();

            assertThat(sut.save帳票分類管理(帳票分類管理), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7068ChohyoBunruiKanriEntity.class))).thenReturn(0);

            DbT7068ChohyoBunruiKanriEntity entity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            entity.initializeMd5();
            ChohyoBunruiKanri 帳票分類管理 = new ChohyoBunruiKanri(entity);
            帳票分類管理 = 帳票分類管理.createBuilderForEdit().set帳票分類ID(new ReportId("12")).build();

            assertThat(sut.save帳票分類管理(帳票分類管理), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7068ChohyoBunruiKanriEntity.class))).thenReturn(1);

            DbT7068ChohyoBunruiKanriEntity entity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            entity.initializeMd5();
            ChohyoBunruiKanri 帳票分類管理 = new ChohyoBunruiKanri(entity);
            帳票分類管理 = 帳票分類管理.deleted();

            assertThat(sut.save帳票分類管理(帳票分類管理), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7068ChohyoBunruiKanriEntity.class))).thenReturn(0);

            DbT7068ChohyoBunruiKanriEntity entity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            entity.initializeMd5();
            ChohyoBunruiKanri 帳票分類管理 = new ChohyoBunruiKanri(entity);
            帳票分類管理 = 帳票分類管理.deleted();

            assertThat(sut.save帳票分類管理(帳票分類管理), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7068ChohyoBunruiKanriEntity entity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            entity.initializeMd5();
            ChohyoBunruiKanri 帳票分類管理 = new ChohyoBunruiKanri(entity);

            assertThat(sut.save帳票分類管理(帳票分類管理), is(false));
        }
    }
}
