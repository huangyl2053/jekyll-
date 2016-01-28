/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.view.ShikakuSearchAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7901ShikakuSearchEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV7901ShikakuSearchEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV7901ShikakuSearchAliveDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {link ShikakuSearchAliveManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ShikakuSearchAliveManagerTest {

    private static DbV7901ShikakuSearchAliveDac dac;
    private static ShikakuSearchAliveManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbV7901ShikakuSearchAliveDac.class);
        sut = new ShikakuSearchAliveManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get資格検索Alive extends DbzTestBase {

        HihokenshaNo 被保険者番号 = DbV7901ShikakuSearchEntityGenerator.DEFAULT_被保険者番号;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get資格検索Alive(null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class))).thenReturn(null);

            ShikakuSearchAlive result = sut.get資格検索Alive(被保険者番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbV7901ShikakuSearchEntity entity = DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity();
            when(dac.selectByKey(any(HihokenshaNo.class))).thenReturn(entity);

            ShikakuSearchAlive result = sut.get資格検索Alive(被保険者番号);

            assertThat(result.get被保険者番号().value(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get資格検索Alive一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShikakuSearchAlive> result = sut.get資格検索Alive一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbV7901ShikakuSearchEntity> entityList = Arrays.asList(DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShikakuSearchAlive> result = sut.get資格検索Alive一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save資格検索Alive extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbV7901ShikakuSearchEntity.class))).thenReturn(1);

            DbV7901ShikakuSearchEntity entity = DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity();
            ShikakuSearchAlive 資格検索Alive = new ShikakuSearchAlive(entity);

            assertThat(sut.save資格検索Alive(資格検索Alive), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbV7901ShikakuSearchEntity.class))).thenReturn(0);

            DbV7901ShikakuSearchEntity entity = DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity();
            ShikakuSearchAlive 資格検索Alive = new ShikakuSearchAlive(entity);

            assertThat(sut.save資格検索Alive(資格検索Alive), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbV7901ShikakuSearchEntity.class))).thenReturn(1);

            DbV7901ShikakuSearchEntity entity = DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity();
            entity.initializeMd5();
            ShikakuSearchAlive 資格検索Alive = new ShikakuSearchAlive(entity);
            資格検索Alive = 資格検索Alive.createBuilderForEdit().set被保険者番号(new HihokenshaNo("被保険者番号を変更")).build();

            assertThat(sut.save資格検索Alive(資格検索Alive), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbV7901ShikakuSearchEntity.class))).thenReturn(0);

            DbV7901ShikakuSearchEntity entity = DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity();
            entity.initializeMd5();
            ShikakuSearchAlive 資格検索Alive = new ShikakuSearchAlive(entity);
            資格検索Alive = 資格検索Alive.createBuilderForEdit().set被保険者番号(new HihokenshaNo("被保険者番号を変更")).build();

            assertThat(sut.save資格検索Alive(資格検索Alive), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbV7901ShikakuSearchEntity.class))).thenReturn(1);

            DbV7901ShikakuSearchEntity entity = DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity();
            entity.initializeMd5();
            ShikakuSearchAlive 資格検索Alive = new ShikakuSearchAlive(entity);
            資格検索Alive = 資格検索Alive.deleted();

            assertThat(sut.save資格検索Alive(資格検索Alive), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbV7901ShikakuSearchEntity.class))).thenReturn(0);

            DbV7901ShikakuSearchEntity entity = DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity();
            entity.initializeMd5();
            ShikakuSearchAlive 資格検索Alive = new ShikakuSearchAlive(entity);
            資格検索Alive = 資格検索Alive.deleted();

            assertThat(sut.save資格検索Alive(資格検索Alive), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbV7901ShikakuSearchEntity entity = DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity();
            entity.initializeMd5();
            ShikakuSearchAlive 資格検索Alive = new ShikakuSearchAlive(entity);

            assertThat(sut.save資格検索Alive(資格検索Alive), is(false));
        }
    }
}
