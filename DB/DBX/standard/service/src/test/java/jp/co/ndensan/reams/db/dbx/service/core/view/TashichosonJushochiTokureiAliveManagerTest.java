/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.view;

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
import jp.co.ndensan.reams.db.dbx.business.core.view.TashichosonJushochiTokureiAlive;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokureiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1003TashichosonJushochiTokureiAliveDac;

/**
 * {link TashichosonJushochiTokureiAliveManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TashichosonJushochiTokureiAliveManagerTest {

    private static DbV1003TashichosonJushochiTokureiAliveDac dac;
    private static TashichosonJushochiTokureiAliveManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbV1003TashichosonJushochiTokureiAliveDac.class);
        sut = new TashichosonJushochiTokureiAliveManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get他市町村住所地特例者台帳管理Alive extends DbxTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のShikibetsuCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー2 = DbV1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_異動日;
            sut.get他市町村住所地特例者台帳管理Alive(null, 主キー2, RString.EMPTY);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のFlexibleDateにnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 主キー1 = DbV1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_識別コード;
            sut.get他市町村住所地特例者台帳管理Alive(主キー1, null, RString.EMPTY);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShikibetsuCode.class), any(FlexibleDate.class), any(RString.class))).thenReturn(null);

            ShikibetsuCode 主キー1 = DbV1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_識別コード;
            FlexibleDate 主キー2 = DbV1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_異動日;
            TashichosonJushochiTokureiAlive result = sut.get他市町村住所地特例者台帳管理Alive(主キー1, 主キー2, RString.EMPTY);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbV1003TashichosonJushochiTokureiEntity entity = DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity();
            when(dac.selectByKey(any(ShikibetsuCode.class), any(FlexibleDate.class), any(RString.class))).thenReturn(entity);

            ShikibetsuCode 主キー1 = DbV1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_識別コード;
            FlexibleDate 主キー2 = DbV1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_異動日;
            TashichosonJushochiTokureiAlive result = sut.get他市町村住所地特例者台帳管理Alive(主キー1, 主キー2, RString.EMPTY);

            assertThat(result.get識別コード().value(), is(DbV1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get他市町村住所地特例者台帳管理Alive一覧 extends DbxTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<TashichosonJushochiTokureiAlive> result = sut.get他市町村住所地特例者台帳管理Alive一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbV1003TashichosonJushochiTokureiEntity> entityList = Arrays.asList(DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<TashichosonJushochiTokureiAlive> result = sut.get他市町村住所地特例者台帳管理Alive一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get識別コード().value(), is(DbV1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    public static class save他市町村住所地特例者台帳管理Alive extends DbxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbV1003TashichosonJushochiTokureiEntity.class))).thenReturn(1);

            DbV1003TashichosonJushochiTokureiEntity entity = DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity();
            TashichosonJushochiTokureiAlive 他市町村住所地特例者台帳管理Alive = new TashichosonJushochiTokureiAlive(entity);

            assertThat(sut.save他市町村住所地特例者台帳管理Alive(他市町村住所地特例者台帳管理Alive), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbV1003TashichosonJushochiTokureiEntity.class))).thenReturn(0);

            DbV1003TashichosonJushochiTokureiEntity entity = DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity();
            TashichosonJushochiTokureiAlive 他市町村住所地特例者台帳管理Alive = new TashichosonJushochiTokureiAlive(entity);

            assertThat(sut.save他市町村住所地特例者台帳管理Alive(他市町村住所地特例者台帳管理Alive), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbV1003TashichosonJushochiTokureiEntity.class))).thenReturn(1);

            DbV1003TashichosonJushochiTokureiEntity entity = DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity();
            entity.initializeMd5();
            TashichosonJushochiTokureiAlive 他市町村住所地特例者台帳管理Alive = new TashichosonJushochiTokureiAlive(entity);
            他市町村住所地特例者台帳管理Alive = 他市町村住所地特例者台帳管理Alive.createBuilderForEdit().set異動事由コード(new RString("1")).build();

            assertThat(sut.save他市町村住所地特例者台帳管理Alive(他市町村住所地特例者台帳管理Alive), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbV1003TashichosonJushochiTokureiEntity.class))).thenReturn(0);

            DbV1003TashichosonJushochiTokureiEntity entity = DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity();
            entity.initializeMd5();
            TashichosonJushochiTokureiAlive 他市町村住所地特例者台帳管理Alive = new TashichosonJushochiTokureiAlive(entity);
            他市町村住所地特例者台帳管理Alive = 他市町村住所地特例者台帳管理Alive.createBuilderForEdit().set異動事由コード(new RString("1")).build();

            assertThat(sut.save他市町村住所地特例者台帳管理Alive(他市町村住所地特例者台帳管理Alive), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbV1003TashichosonJushochiTokureiEntity.class))).thenReturn(1);

            DbV1003TashichosonJushochiTokureiEntity entity = DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity();
            entity.initializeMd5();
            TashichosonJushochiTokureiAlive 他市町村住所地特例者台帳管理Alive = new TashichosonJushochiTokureiAlive(entity);
            他市町村住所地特例者台帳管理Alive = 他市町村住所地特例者台帳管理Alive.deleted();

            assertThat(sut.save他市町村住所地特例者台帳管理Alive(他市町村住所地特例者台帳管理Alive), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbV1003TashichosonJushochiTokureiEntity.class))).thenReturn(0);

            DbV1003TashichosonJushochiTokureiEntity entity = DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity();
            entity.initializeMd5();
            TashichosonJushochiTokureiAlive 他市町村住所地特例者台帳管理Alive = new TashichosonJushochiTokureiAlive(entity);
            他市町村住所地特例者台帳管理Alive = 他市町村住所地特例者台帳管理Alive.deleted();

            assertThat(sut.save他市町村住所地特例者台帳管理Alive(他市町村住所地特例者台帳管理Alive), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbV1003TashichosonJushochiTokureiEntity entity = DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity();
            entity.initializeMd5();
            TashichosonJushochiTokureiAlive 他市町村住所地特例者台帳管理Alive = new TashichosonJushochiTokureiAlive(entity);

            assertThat(sut.save他市町村住所地特例者台帳管理Alive(他市町村住所地特例者台帳管理Alive), is(false));
        }
    }
}
