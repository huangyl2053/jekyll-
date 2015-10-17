/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {link KoseiShichosonMasterManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterManagerTest {

    private static DbT7051KoseiShichosonMasterDac dac;
    private static KoseiShichosonMasterManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7051KoseiShichosonMasterDac.class);
        sut = new KoseiShichosonMasterManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get構成市町村マスタ extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のRStringにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get構成市町村マスタ(null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(RString.class))).thenReturn(null);

            RString 主キー1 = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
            KoseiShichosonMaster result = sut.get構成市町村マスタ(主キー1);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            when(dac.selectByKey(any(RString.class))).thenReturn(entity);

            RString 主キー1 = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
            KoseiShichosonMaster result = sut.get構成市町村マスタ(主キー1);

            assertThat(result.get市町村識別ID(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get構成市町村マスタ一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KoseiShichosonMaster> result = sut.get構成市町村マスタ一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7051KoseiShichosonMasterEntity> entityList = Arrays.asList(DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KoseiShichosonMaster> result = sut.get構成市町村マスタ一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get市町村識別ID(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID));
        }
    }

    public static class save構成市町村マスタ extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7051KoseiShichosonMasterEntity.class))).thenReturn(1);

            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(entity);

            assertThat(sut.save構成市町村マスタ(構成市町村マスタ), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7051KoseiShichosonMasterEntity.class))).thenReturn(0);

            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(entity);

            assertThat(sut.save構成市町村マスタ(構成市町村マスタ), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7051KoseiShichosonMasterEntity.class))).thenReturn(1);

            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.initializeMd5();
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(entity);
            構成市町村マスタ = 構成市町村マスタ.createBuilderForEdit().set帳票用方書表示有無(new RString("1")).build();

            assertThat(sut.save構成市町村マスタ(構成市町村マスタ), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7051KoseiShichosonMasterEntity.class))).thenReturn(0);

            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.initializeMd5();
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(entity);
            構成市町村マスタ = 構成市町村マスタ.createBuilderForEdit().set帳票用方書表示有無(new RString("1")).build();

            assertThat(sut.save構成市町村マスタ(構成市町村マスタ), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7051KoseiShichosonMasterEntity.class))).thenReturn(1);

            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.initializeMd5();
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(entity);
            構成市町村マスタ = 構成市町村マスタ.deleted();

            assertThat(sut.save構成市町村マスタ(構成市町村マスタ), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7051KoseiShichosonMasterEntity.class))).thenReturn(0);

            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.initializeMd5();
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(entity);
            構成市町村マスタ = 構成市町村マスタ.deleted();

            assertThat(sut.save構成市町村マスタ(構成市町村マスタ), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.initializeMd5();
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(entity);

            assertThat(sut.save構成市町村マスタ(構成市町村マスタ), is(false));
        }
    }
}
