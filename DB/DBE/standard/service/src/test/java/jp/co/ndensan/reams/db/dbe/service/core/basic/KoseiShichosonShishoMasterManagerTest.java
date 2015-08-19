/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5052KoseiShichosonShishoMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5052KoseiShichosonShishoMasterDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {link KoseiShichosonShishoMasterManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonShishoMasterManagerTest {

    private static DbT5052KoseiShichosonShishoMasterDac dac;
    private static KoseiShichosonShishoMasterManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5052KoseiShichosonShishoMasterDac.class);
        sut = new KoseiShichosonShishoMasterManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get構成市町村支所マスタ extends DbeTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            ShishoCode 主キー2 = DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;
            sut.get構成市町村支所マスタ(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            LasdecCode 主キー1 = DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード;
            sut.get構成市町村支所マスタ(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(LasdecCode.class), any(ShishoCode.class))).thenReturn(null);

            LasdecCode 主キー1 = DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード;
            ShishoCode 主キー2 = DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;
            KoseiShichosonShishoMaster result = sut.get構成市町村支所マスタ(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5052KoseiShichosonShishoMasterEntity entity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();
            when(dac.selectByKey(any(LasdecCode.class), any(ShishoCode.class))).thenReturn(entity);

            LasdecCode 主キー1 = DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード;
            ShishoCode 主キー2 = DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;
            KoseiShichosonShishoMaster result = sut.get構成市町村支所マスタ(主キー1, 主キー2);

            assertThat(result.get市町村コード().value(), is(DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get構成市町村支所マスタ一覧 extends DbeTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KoseiShichosonShishoMaster> result = sut.get構成市町村支所マスタ一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5052KoseiShichosonShishoMasterEntity> entityList = Arrays.asList(DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KoseiShichosonShishoMaster> result = sut.get構成市町村支所マスタ一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get市町村コード().value(), is(DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    public static class save構成市町村支所マスタ extends DbeTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5052KoseiShichosonShishoMasterEntity.class))).thenReturn(1);

            DbT5052KoseiShichosonShishoMasterEntity entity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMaster 構成市町村支所マスタ = new KoseiShichosonShishoMaster(entity);

            assertThat(sut.save構成市町村支所マスタ(構成市町村支所マスタ), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5052KoseiShichosonShishoMasterEntity.class))).thenReturn(0);

            DbT5052KoseiShichosonShishoMasterEntity entity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMaster 構成市町村支所マスタ = new KoseiShichosonShishoMaster(entity);

            assertThat(sut.save構成市町村支所マスタ(構成市町村支所マスタ), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5052KoseiShichosonShishoMasterEntity.class))).thenReturn(1);

            DbT5052KoseiShichosonShishoMasterEntity entity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();
            entity.initializeMd5();
            KoseiShichosonShishoMaster 構成市町村支所マスタ = new KoseiShichosonShishoMaster(entity);
            構成市町村支所マスタ = 構成市町村支所マスタ.createBuilderForEdit().set市町村コード(new LasdecCode("市町村コードを変更")).build();

            assertThat(sut.save構成市町村支所マスタ(構成市町村支所マスタ), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5052KoseiShichosonShishoMasterEntity.class))).thenReturn(0);

            DbT5052KoseiShichosonShishoMasterEntity entity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();
            entity.initializeMd5();
            KoseiShichosonShishoMaster 構成市町村支所マスタ = new KoseiShichosonShishoMaster(entity);
            構成市町村支所マスタ = 構成市町村支所マスタ.createBuilderForEdit().set市町村コード(new LasdecCode("市町村コードを変更")).build();

            assertThat(sut.save構成市町村支所マスタ(構成市町村支所マスタ), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5052KoseiShichosonShishoMasterEntity.class))).thenReturn(1);

            DbT5052KoseiShichosonShishoMasterEntity entity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();
            entity.initializeMd5();
            KoseiShichosonShishoMaster 構成市町村支所マスタ = new KoseiShichosonShishoMaster(entity);
            構成市町村支所マスタ = 構成市町村支所マスタ.deleted();

            assertThat(sut.save構成市町村支所マスタ(構成市町村支所マスタ), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5052KoseiShichosonShishoMasterEntity.class))).thenReturn(0);

            DbT5052KoseiShichosonShishoMasterEntity entity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();
            entity.initializeMd5();
            KoseiShichosonShishoMaster 構成市町村支所マスタ = new KoseiShichosonShishoMaster(entity);
            構成市町村支所マスタ = 構成市町村支所マスタ.deleted();

            assertThat(sut.save構成市町村支所マスタ(構成市町村支所マスタ), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5052KoseiShichosonShishoMasterEntity entity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();
            entity.initializeMd5();
            KoseiShichosonShishoMaster 構成市町村支所マスタ = new KoseiShichosonShishoMaster(entity);

            assertThat(sut.save構成市町村支所マスタ(構成市町村支所マスタ), is(false));
        }
    }
}
