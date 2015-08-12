/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
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
 * {link KoseiShichosonMasterManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterManagerTest {

    private static DbT5051KoseiShichosonMasterDac dac;
    private static KoseiShichosonMasterManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5051KoseiShichosonMasterDac.class);
        sut = new KoseiShichosonMasterManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get構成市町村マスタ extends DbeTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー2;
            sut.get構成市町村マスタ(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー1;
            sut.get構成市町村マスタ(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー2;
            KoseiShichosonMaster result = sut.get構成市町村マスタ(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5051KoseiShichosonMasterEntity entity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー2;
            KoseiShichosonMaster result = sut.get構成市町村マスタ(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get構成市町村マスタ一覧 extends FdaTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KoseiShichosonMaster> result = sut.get構成市町村マスタ一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5051KoseiShichosonMasterEntity> entityList = Arrays.asList(DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KoseiShichosonMaster> result = sut.get構成市町村マスタ一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save構成市町村マスタ extends XxxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5051KoseiShichosonMasterEntity.class))).thenReturn(1);

            DbT5051KoseiShichosonMasterEntity entity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(entity);

            assertThat(sut.save構成市町村マスタ(構成市町村マスタ), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5051KoseiShichosonMasterEntity.class))).thenReturn(0);

            DbT5051KoseiShichosonMasterEntity entity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(entity);

            assertThat(sut.save構成市町村マスタ(構成市町村マスタ), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5051KoseiShichosonMasterEntity.class))).thenReturn(1);

            DbT5051KoseiShichosonMasterEntity entity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();
            entity.initializeMd5();
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(entity);
            構成市町村マスタ = 構成市町村マスタ.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save構成市町村マスタ(構成市町村マスタ), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5051KoseiShichosonMasterEntity.class))).thenReturn(0);

            DbT5051KoseiShichosonMasterEntity entity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();
            entity.initializeMd5();
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(entity);
            構成市町村マスタ = 構成市町村マスタ.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save構成市町村マスタ(構成市町村マスタ), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5051KoseiShichosonMasterEntity.class))).thenReturn(1);

            DbT5051KoseiShichosonMasterEntity entity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();
            entity.initializeMd5();
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(entity);
            構成市町村マスタ = 構成市町村マスタ.deleted();

            assertThat(sut.save構成市町村マスタ(構成市町村マスタ), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5051KoseiShichosonMasterEntity.class))).thenReturn(0);

            DbT5051KoseiShichosonMasterEntity entity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();
            entity.initializeMd5();
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(entity);
            構成市町村マスタ = 構成市町村マスタ.deleted();

            assertThat(sut.save構成市町村マスタ(構成市町村マスタ), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5051KoseiShichosonMasterEntity entity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();
            entity.initializeMd5();
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(entity);

            assertThat(sut.save構成市町村マスタ(構成市町村マスタ), is(false));
        }
    }
}
