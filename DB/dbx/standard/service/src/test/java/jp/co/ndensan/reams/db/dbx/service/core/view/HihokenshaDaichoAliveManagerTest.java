/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.view;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaDaichoAlive;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbV1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;

/**
 * {link HihokenshaDaichoAliveManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoAliveManagerTest {

    private static DbV1001HihokenshaDaichoAliveDac dac;
    private static HihokenshaDaichoAliveManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbV1001HihokenshaDaichoAliveDac.class);
        sut = new HihokenshaDaichoAliveManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get被保険者台帳管理Alive extends DbxTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のHihokenshaNoにnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー2 = DbV1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日;
            sut.get被保険者台帳管理Alive(null, 主キー2, RString.EMPTY);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のFlexibleDateにnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbV1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
            sut.get被保険者台帳管理Alive(主キー1, null, RString.EMPTY);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleDate.class), any(RString.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbV1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbV1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日;
            HihokenshaDaichoAlive result = sut.get被保険者台帳管理Alive(主キー1, 主キー2, RString.EMPTY);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbV1001HihokenshaDaichoEntity entity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleDate.class), any(RString.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbV1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbV1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日;
            HihokenshaDaichoAlive result = sut.get被保険者台帳管理Alive(主キー1, 主キー2, RString.EMPTY);

            assertThat(result.get被保険者番号().value(), is(DbV1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get被保険者台帳管理Alive一覧 extends DbxTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<HihokenshaDaichoAlive> result = sut.get被保険者台帳管理Alive一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbV1001HihokenshaDaichoEntity> entityList = Arrays.asList(DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<HihokenshaDaichoAlive> result = sut.get被保険者台帳管理Alive一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbV1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save被保険者台帳管理Alive extends DbxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbV1001HihokenshaDaichoEntity.class))).thenReturn(1);

            DbV1001HihokenshaDaichoEntity entity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            HihokenshaDaichoAlive 被保険者台帳管理Alive = new HihokenshaDaichoAlive(entity);

            assertThat(sut.save被保険者台帳管理Alive(被保険者台帳管理Alive), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbV1001HihokenshaDaichoEntity.class))).thenReturn(0);

            DbV1001HihokenshaDaichoEntity entity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            HihokenshaDaichoAlive 被保険者台帳管理Alive = new HihokenshaDaichoAlive(entity);

            assertThat(sut.save被保険者台帳管理Alive(被保険者台帳管理Alive), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbV1001HihokenshaDaichoEntity.class))).thenReturn(1);

            DbV1001HihokenshaDaichoEntity entity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            entity.initializeMd5();
            HihokenshaDaichoAlive 被保険者台帳管理Alive = new HihokenshaDaichoAlive(entity);
            被保険者台帳管理Alive = 被保険者台帳管理Alive.createBuilderForEdit().set枝番(new RString("2")).build();

            assertThat(sut.save被保険者台帳管理Alive(被保険者台帳管理Alive), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbV1001HihokenshaDaichoEntity.class))).thenReturn(0);

            DbV1001HihokenshaDaichoEntity entity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            entity.initializeMd5();
            HihokenshaDaichoAlive 被保険者台帳管理Alive = new HihokenshaDaichoAlive(entity);
            被保険者台帳管理Alive = 被保険者台帳管理Alive.createBuilderForEdit().set枝番(new RString("2")).build();

            assertThat(sut.save被保険者台帳管理Alive(被保険者台帳管理Alive), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbV1001HihokenshaDaichoEntity.class))).thenReturn(1);

            DbV1001HihokenshaDaichoEntity entity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            entity.initializeMd5();
            HihokenshaDaichoAlive 被保険者台帳管理Alive = new HihokenshaDaichoAlive(entity);
            被保険者台帳管理Alive = 被保険者台帳管理Alive.deleted();

            assertThat(sut.save被保険者台帳管理Alive(被保険者台帳管理Alive), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbV1001HihokenshaDaichoEntity.class))).thenReturn(0);

            DbV1001HihokenshaDaichoEntity entity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            entity.initializeMd5();
            HihokenshaDaichoAlive 被保険者台帳管理Alive = new HihokenshaDaichoAlive(entity);
            被保険者台帳管理Alive = 被保険者台帳管理Alive.deleted();

            assertThat(sut.save被保険者台帳管理Alive(被保険者台帳管理Alive), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbV1001HihokenshaDaichoEntity entity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            entity.initializeMd5();
            HihokenshaDaichoAlive 被保険者台帳管理Alive = new HihokenshaDaichoAlive(entity);

            assertThat(sut.save被保険者台帳管理Alive(被保険者台帳管理Alive), is(false));
        }
    }
}
