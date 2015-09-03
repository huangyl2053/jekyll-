/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7052KoseiShichosonShishoMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7052KoseiShichosonShishoMasterDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KoseiShichosonShishoMasterManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonShishoMasterManagerTest {

    private static DbT7052KoseiShichosonShishoMasterDac dac;
    private static KoseiShichosonShishoMasterManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7052KoseiShichosonShishoMasterDac.class);
        sut = new KoseiShichosonShishoMasterManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get構成市町村支所マスタ extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のLasdecCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            ShishoCode 主キー2 = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;
            sut.get構成市町村支所マスタ(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のShishoCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            LasdecCode 主キー1 = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード;
            sut.get構成市町村支所マスタ(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(LasdecCode.class), any(ShishoCode.class))).thenReturn(null);

            LasdecCode 主キー1 = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード;
            ShishoCode 主キー2 = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;
            KoseiShichosonShishoMaster result = sut.get構成市町村支所マスタ(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7052KoseiShichosonShishoMasterEntity entity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            when(dac.selectByKey(any(LasdecCode.class), any(ShishoCode.class))).thenReturn(entity);

            LasdecCode 主キー1 = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード;
            ShishoCode 主キー2 = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;
            KoseiShichosonShishoMaster result = sut.get構成市町村支所マスタ(主キー1, 主キー2);

            assertThat(result.get市町村コード().value(), is(DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get構成市町村支所マスタ一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KoseiShichosonShishoMaster> result = sut.get構成市町村支所マスタ一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7052KoseiShichosonShishoMasterEntity> entityList = Arrays.asList(DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KoseiShichosonShishoMaster> result = sut.get構成市町村支所マスタ一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get市町村コード().value(), is(DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    public static class save構成市町村支所マスタ extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7052KoseiShichosonShishoMasterEntity.class))).thenReturn(1);

            DbT7052KoseiShichosonShishoMasterEntity entity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMaster 構成市町村支所マスタ = new KoseiShichosonShishoMaster(entity);

            assertThat(sut.save構成市町村支所マスタ(構成市町村支所マスタ), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7052KoseiShichosonShishoMasterEntity.class))).thenReturn(0);

            DbT7052KoseiShichosonShishoMasterEntity entity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMaster 構成市町村支所マスタ = new KoseiShichosonShishoMaster(entity);

            assertThat(sut.save構成市町村支所マスタ(構成市町村支所マスタ), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7052KoseiShichosonShishoMasterEntity.class))).thenReturn(1);

            DbT7052KoseiShichosonShishoMasterEntity entity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            entity.initializeMd5();
            KoseiShichosonShishoMaster 構成市町村支所マスタ = new KoseiShichosonShishoMaster(entity);
            構成市町村支所マスタ = 構成市町村支所マスタ.createBuilderForEdit().set支所名(new RString("任意項目を変更")).build();

            assertThat(sut.save構成市町村支所マスタ(構成市町村支所マスタ), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7052KoseiShichosonShishoMasterEntity.class))).thenReturn(0);

            DbT7052KoseiShichosonShishoMasterEntity entity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            entity.initializeMd5();
            KoseiShichosonShishoMaster 構成市町村支所マスタ = new KoseiShichosonShishoMaster(entity);
            構成市町村支所マスタ = 構成市町村支所マスタ.createBuilderForEdit().set支所名(new RString("任意項目を変更")).build();

            assertThat(sut.save構成市町村支所マスタ(構成市町村支所マスタ), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7052KoseiShichosonShishoMasterEntity.class))).thenReturn(1);

            DbT7052KoseiShichosonShishoMasterEntity entity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            entity.initializeMd5();
            KoseiShichosonShishoMaster 構成市町村支所マスタ = new KoseiShichosonShishoMaster(entity);
            構成市町村支所マスタ = 構成市町村支所マスタ.deleted();

            assertThat(sut.save構成市町村支所マスタ(構成市町村支所マスタ), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7052KoseiShichosonShishoMasterEntity.class))).thenReturn(0);

            DbT7052KoseiShichosonShishoMasterEntity entity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            entity.initializeMd5();
            KoseiShichosonShishoMaster 構成市町村支所マスタ = new KoseiShichosonShishoMaster(entity);
            構成市町村支所マスタ = 構成市町村支所マスタ.deleted();

            assertThat(sut.save構成市町村支所マスタ(構成市町村支所マスタ), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7052KoseiShichosonShishoMasterEntity entity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            entity.initializeMd5();
            KoseiShichosonShishoMaster 構成市町村支所マスタ = new KoseiShichosonShishoMaster(entity);

            assertThat(sut.save構成市町村支所マスタ(構成市町村支所マスタ), is(false));
        }
    }
}
