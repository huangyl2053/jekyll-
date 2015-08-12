/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoHokensha;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7050KaigoHokenshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7050KaigoHokenshaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7050KaigoHokenshaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {link KaigoHokenshaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoHokenshaManagerTest {

    private static DbT7050KaigoHokenshaDac dac;
    private static KaigoHokenshaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7050KaigoHokenshaDac.class);
        sut = new KaigoHokenshaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護保険者 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護保険者(null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(LasdecCode.class))).thenReturn(null);

            LasdecCode 主キー1 = DbT7050KaigoHokenshaEntityGenerator.DEFAULT_広域保険者市町村コード;
            KaigoHokensha result = sut.get介護保険者(主キー1);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7050KaigoHokenshaEntity entity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            when(dac.selectByKey(any(LasdecCode.class))).thenReturn(entity);
            LasdecCode 主キー1 = DbT7050KaigoHokenshaEntityGenerator.DEFAULT_広域保険者市町村コード;
            KaigoHokensha result = sut.get介護保険者(主キー1);

            assertThat(result.get広域保険者市町村コード().value(), is(DbT7050KaigoHokenshaEntityGenerator.DEFAULT_広域保険者市町村コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護保険者一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KaigoHokensha> result = sut.get介護保険者一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7050KaigoHokenshaEntity> entityList = Arrays.asList(DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KaigoHokensha> result = sut.get介護保険者一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get広域保険者市町村コード().value(), is(DbT7050KaigoHokenshaEntityGenerator.DEFAULT_広域保険者市町村コード.value()));
        }
    }

    public static class save介護保険者 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7050KaigoHokenshaEntity.class))).thenReturn(1);

            DbT7050KaigoHokenshaEntity entity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            KaigoHokensha 介護保険者 = new KaigoHokensha(entity);

            assertThat(sut.save介護保険者(介護保険者), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7050KaigoHokenshaEntity.class))).thenReturn(0);

            DbT7050KaigoHokenshaEntity entity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            KaigoHokensha 介護保険者 = new KaigoHokensha(entity);

            assertThat(sut.save介護保険者(介護保険者), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7050KaigoHokenshaEntity.class))).thenReturn(1);

            DbT7050KaigoHokenshaEntity entity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            entity.initializeMd5();
            KaigoHokensha 介護保険者 = new KaigoHokensha(entity);
            介護保険者 = 介護保険者.createBuilderForEdit().set広域保険者番号(new ShoKisaiHokenshaNo("123113613")).build();

            assertThat(sut.save介護保険者(介護保険者), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7050KaigoHokenshaEntity.class))).thenReturn(0);

            DbT7050KaigoHokenshaEntity entity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            entity.initializeMd5();
            KaigoHokensha 介護保険者 = new KaigoHokensha(entity);
            介護保険者 = 介護保険者.createBuilderForEdit().set広域保険者番号(new ShoKisaiHokenshaNo("123113613")).build();

            assertThat(sut.save介護保険者(介護保険者), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7050KaigoHokenshaEntity.class))).thenReturn(1);

            DbT7050KaigoHokenshaEntity entity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            entity.initializeMd5();
            KaigoHokensha 介護保険者 = new KaigoHokensha(entity);
            介護保険者 = 介護保険者.deleted();

            assertThat(sut.save介護保険者(介護保険者), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7050KaigoHokenshaEntity.class))).thenReturn(0);

            DbT7050KaigoHokenshaEntity entity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            entity.initializeMd5();
            KaigoHokensha 介護保険者 = new KaigoHokensha(entity);
            介護保険者 = 介護保険者.deleted();

            assertThat(sut.save介護保険者(介護保険者), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7050KaigoHokenshaEntity entity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            entity.initializeMd5();
            KaigoHokensha 介護保険者 = new KaigoHokensha(entity);

            assertThat(sut.save介護保険者(介護保険者), is(false));
        }
    }
}
