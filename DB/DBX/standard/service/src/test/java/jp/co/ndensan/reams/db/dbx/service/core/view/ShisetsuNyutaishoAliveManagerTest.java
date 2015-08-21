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
import jp.co.ndensan.reams.db.dbx.business.core.view.ShisetsuNyutaishoAlive;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbV1004ShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1004ShisetsuNyutaishoAliveDac;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {link ShisetsuNyutaishoAliveManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoAliveManagerTest {

    private static DbV1004ShisetsuNyutaishoAliveDac dac;
    private static ShisetsuNyutaishoAliveManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbV1004ShisetsuNyutaishoAliveDac.class);
        sut = new ShisetsuNyutaishoAliveManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護保険施設入退所Alive extends DbxTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のShikibetsuCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            Decimal 主キー2 = DbV1004ShisetsuNyutaishoEntityGenerator.DEFAULT_履歴番号;
            sut.get介護保険施設入退所Alive(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のDecimalにnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 主キー1 = DbV1004ShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード;
            sut.get介護保険施設入退所Alive(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShikibetsuCode.class), any(Decimal.class))).thenReturn(null);

            ShikibetsuCode 主キー1 = DbV1004ShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード;
            Decimal 主キー2 = DbV1004ShisetsuNyutaishoEntityGenerator.DEFAULT_履歴番号;
            ShisetsuNyutaishoAlive result = sut.get介護保険施設入退所Alive(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbV1004ShisetsuNyutaishoEntity entity = DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity();
            when(dac.selectByKey(any(ShikibetsuCode.class), any(Decimal.class))).thenReturn(entity);

            ShikibetsuCode 主キー1 = DbV1004ShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード;
            Decimal 主キー2 = DbV1004ShisetsuNyutaishoEntityGenerator.DEFAULT_履歴番号;
            ShisetsuNyutaishoAlive result = sut.get介護保険施設入退所Alive(主キー1, 主キー2);

            assertThat(result.get識別コード().value(), is(DbV1004ShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護保険施設入退所Alive一覧 extends DbxTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShisetsuNyutaishoAlive> result = sut.get介護保険施設入退所Alive一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbV1004ShisetsuNyutaishoEntity> entityList = Arrays.asList(DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShisetsuNyutaishoAlive> result = sut.get介護保険施設入退所Alive一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get識別コード().value(), is(DbV1004ShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    public static class save介護保険施設入退所Alive extends DbxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbV1004ShisetsuNyutaishoEntity.class))).thenReturn(1);

            DbV1004ShisetsuNyutaishoEntity entity = DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoAlive 介護保険施設入退所Alive = new ShisetsuNyutaishoAlive(entity);

            assertThat(sut.save介護保険施設入退所Alive(介護保険施設入退所Alive), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbV1004ShisetsuNyutaishoEntity.class))).thenReturn(0);

            DbV1004ShisetsuNyutaishoEntity entity = DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoAlive 介護保険施設入退所Alive = new ShisetsuNyutaishoAlive(entity);

            assertThat(sut.save介護保険施設入退所Alive(介護保険施設入退所Alive), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbV1004ShisetsuNyutaishoEntity.class))).thenReturn(1);

            DbV1004ShisetsuNyutaishoEntity entity = DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity();
            entity.initializeMd5();
            ShisetsuNyutaishoAlive 介護保険施設入退所Alive = new ShisetsuNyutaishoAlive(entity);
            介護保険施設入退所Alive = 介護保険施設入退所Alive.createBuilderForEdit().set入所施設種類(new RString("1")).build();

            assertThat(sut.save介護保険施設入退所Alive(介護保険施設入退所Alive), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbV1004ShisetsuNyutaishoEntity.class))).thenReturn(0);

            DbV1004ShisetsuNyutaishoEntity entity = DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity();
            entity.initializeMd5();
            ShisetsuNyutaishoAlive 介護保険施設入退所Alive = new ShisetsuNyutaishoAlive(entity);
            介護保険施設入退所Alive = 介護保険施設入退所Alive.createBuilderForEdit().set入所施設種類(new RString("1")).build();

            assertThat(sut.save介護保険施設入退所Alive(介護保険施設入退所Alive), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbV1004ShisetsuNyutaishoEntity.class))).thenReturn(1);

            DbV1004ShisetsuNyutaishoEntity entity = DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity();
            entity.initializeMd5();
            ShisetsuNyutaishoAlive 介護保険施設入退所Alive = new ShisetsuNyutaishoAlive(entity);
            介護保険施設入退所Alive = 介護保険施設入退所Alive.deleted();

            assertThat(sut.save介護保険施設入退所Alive(介護保険施設入退所Alive), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbV1004ShisetsuNyutaishoEntity.class))).thenReturn(0);

            DbV1004ShisetsuNyutaishoEntity entity = DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity();
            entity.initializeMd5();
            ShisetsuNyutaishoAlive 介護保険施設入退所Alive = new ShisetsuNyutaishoAlive(entity);
            介護保険施設入退所Alive = 介護保険施設入退所Alive.deleted();

            assertThat(sut.save介護保険施設入退所Alive(介護保険施設入退所Alive), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbV1004ShisetsuNyutaishoEntity entity = DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity();
            entity.initializeMd5();
            ShisetsuNyutaishoAlive 介護保険施設入退所Alive = new ShisetsuNyutaishoAlive(entity);

            assertThat(sut.save介護保険施設入退所Alive(介護保険施設入退所Alive), is(false));
        }
    }
}
