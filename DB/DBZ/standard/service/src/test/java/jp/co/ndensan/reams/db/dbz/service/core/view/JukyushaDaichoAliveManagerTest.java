/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.view.JukyushaDaichoAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV4001JukyushaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV4001JukyushaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {link JukyushaDaichoAliveManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class JukyushaDaichoAliveManagerTest {

    private static DbV4001JukyushaDaichoAliveDac dac;
    private static JukyushaDaichoAliveManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbV4001JukyushaDaichoAliveDac.class);
        sut = new JukyushaDaichoAliveManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get受給者台帳Alive extends DbzTestBase {

        LasdecCode 市町村コード = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード;
        HihokenshaNo 被保険者番号 = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号;
        RString 履歴番号 = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_履歴番号;
        RString 枝番 = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_枝番;
        Code 受給申請事由 = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請事由;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get受給者台帳Alive(null, 被保険者番号, 履歴番号, 枝番, 受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get受給者台帳Alive(市町村コード, null, 履歴番号, 枝番, 受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get受給者台帳Alive(市町村コード, 被保険者番号, null, 枝番, 受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get受給者台帳Alive(市町村コード, 被保険者番号, 履歴番号, null, 受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get受給者台帳Alive(市町村コード, 被保険者番号, 履歴番号, 枝番, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(LasdecCode.class), any(HihokenshaNo.class), any(RString.class), any(RString.class), any(Code.class))).thenReturn(null);

            JukyushaDaichoAlive result = sut.get受給者台帳Alive(市町村コード, 被保険者番号, 履歴番号, 枝番, 受給申請事由);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbV4001JukyushaDaichoEntity entity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();
            when(dac.selectByKey(any(LasdecCode.class), any(HihokenshaNo.class), any(RString.class), any(RString.class), any(Code.class))).thenReturn(entity);

            JukyushaDaichoAlive result = sut.get受給者台帳Alive(市町村コード, 被保険者番号, 履歴番号, 枝番, 受給申請事由);

            assertThat(result.get市町村コード().value(), is(DbV4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get受給者台帳Alive一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<JukyushaDaichoAlive> result = sut.get受給者台帳Alive一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbV4001JukyushaDaichoEntity> entityList = Arrays.asList(DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<JukyushaDaichoAlive> result = sut.get受給者台帳Alive一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get市町村コード().value(), is(DbV4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    public static class save受給者台帳Alive extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbV4001JukyushaDaichoEntity.class))).thenReturn(1);

            DbV4001JukyushaDaichoEntity entity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();
            JukyushaDaichoAlive 受給者台帳Alive = new JukyushaDaichoAlive(entity);

            assertThat(sut.save受給者台帳Alive(受給者台帳Alive), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbV4001JukyushaDaichoEntity.class))).thenReturn(0);

            DbV4001JukyushaDaichoEntity entity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();
            JukyushaDaichoAlive 受給者台帳Alive = new JukyushaDaichoAlive(entity);

            assertThat(sut.save受給者台帳Alive(受給者台帳Alive), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbV4001JukyushaDaichoEntity.class))).thenReturn(1);

            DbV4001JukyushaDaichoEntity entity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();
            entity.initializeMd5();
            JukyushaDaichoAlive 受給者台帳Alive = new JukyushaDaichoAlive(entity);
            受給者台帳Alive = 受給者台帳Alive.createBuilderForEdit().set履歴番号(new RString("履歴番号を変更")).build();

            assertThat(sut.save受給者台帳Alive(受給者台帳Alive), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbV4001JukyushaDaichoEntity.class))).thenReturn(0);

            DbV4001JukyushaDaichoEntity entity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();
            entity.initializeMd5();
            JukyushaDaichoAlive 受給者台帳Alive = new JukyushaDaichoAlive(entity);
            受給者台帳Alive = 受給者台帳Alive.createBuilderForEdit().set履歴番号(new RString("履歴番号を変更")).build();

            assertThat(sut.save受給者台帳Alive(受給者台帳Alive), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbV4001JukyushaDaichoEntity.class))).thenReturn(1);

            DbV4001JukyushaDaichoEntity entity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();
            entity.initializeMd5();
            JukyushaDaichoAlive 受給者台帳Alive = new JukyushaDaichoAlive(entity);
            受給者台帳Alive = 受給者台帳Alive.deleted();

            assertThat(sut.save受給者台帳Alive(受給者台帳Alive), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbV4001JukyushaDaichoEntity.class))).thenReturn(0);

            DbV4001JukyushaDaichoEntity entity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();
            entity.initializeMd5();
            JukyushaDaichoAlive 受給者台帳Alive = new JukyushaDaichoAlive(entity);
            受給者台帳Alive = 受給者台帳Alive.deleted();

            assertThat(sut.save受給者台帳Alive(受給者台帳Alive), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbV4001JukyushaDaichoEntity entity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();
            entity.initializeMd5();
            JukyushaDaichoAlive 受給者台帳Alive = new JukyushaDaichoAlive(entity);

            assertThat(sut.save受給者台帳Alive(受給者台帳Alive), is(false));
        }
    }
}
