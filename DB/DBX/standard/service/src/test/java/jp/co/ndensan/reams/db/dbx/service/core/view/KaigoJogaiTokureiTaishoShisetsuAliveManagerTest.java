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
import jp.co.ndensan.reams.db.dbx.business.core.view.KaigoJogaiTokureiTaishoShisetsuAlive;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1005KaigoJogaiTokureiTaishoShisetsuAliveDac;

/**
 * {link KaigoJogaiTokureiTaishoShisetsuAliveManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJogaiTokureiTaishoShisetsuAliveManagerTest {

    private static DbV1005KaigoJogaiTokureiTaishoShisetsuAliveDac dac;
    private static KaigoJogaiTokureiTaishoShisetsuAliveManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbV1005KaigoJogaiTokureiTaishoShisetsuAliveDac.class);
        sut = new KaigoJogaiTokureiTaishoShisetsuAliveManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get他市町村住所地特例者台帳管理Alive extends DbxTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の事業者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号;
            sut.get他市町村住所地特例者台帳管理Alive(null, 主キー2, FlexibleDate.MIN);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の事業者種別にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別;
            sut.get他市町村住所地特例者台帳管理Alive(主キー1, null, FlexibleDate.MIN);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(RString.class), any(RString.class), any(FlexibleDate.class))).thenReturn(null);

            RString 主キー1 = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別;
            RString 主キー2 = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号;
            KaigoJogaiTokureiTaishoShisetsuAlive result = sut.get他市町村住所地特例者台帳管理Alive(主キー1, 主キー2, FlexibleDate.MAX);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            when(dac.selectByKey(any(RString.class), any(RString.class), any(FlexibleDate.class))).thenReturn(entity);

            RString 主キー1 = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別;
            RString 主キー2 = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号;
            KaigoJogaiTokureiTaishoShisetsuAlive result = sut.get他市町村住所地特例者台帳管理Alive(主キー1, 主キー2, FlexibleDate.MAX);

            assertThat(result.get事業者種別(), is(DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get他市町村住所地特例者台帳管理Alive一覧 extends DbxTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KaigoJogaiTokureiTaishoShisetsuAlive> result = sut.get他市町村住所地特例者台帳管理Alive一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbV1005KaigoJogaiTokureiTaishoShisetsuEntity> entityList = Arrays.asList(DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KaigoJogaiTokureiTaishoShisetsuAlive> result = sut.get他市町村住所地特例者台帳管理Alive一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get事業者種別(), is(DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別));
        }
    }

    public static class save他市町村住所地特例者台帳管理Alive extends DbxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbV1005KaigoJogaiTokureiTaishoShisetsuEntity.class))).thenReturn(1);

            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuAlive 他市町村住所地特例者台帳管理Alive = new KaigoJogaiTokureiTaishoShisetsuAlive(entity);

            assertThat(sut.save他市町村住所地特例者台帳管理Alive(他市町村住所地特例者台帳管理Alive), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbV1005KaigoJogaiTokureiTaishoShisetsuEntity.class))).thenReturn(0);

            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuAlive 他市町村住所地特例者台帳管理Alive = new KaigoJogaiTokureiTaishoShisetsuAlive(entity);

            assertThat(sut.save他市町村住所地特例者台帳管理Alive(他市町村住所地特例者台帳管理Alive), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbV1005KaigoJogaiTokureiTaishoShisetsuEntity.class))).thenReturn(1);

            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            entity.initializeMd5();
            KaigoJogaiTokureiTaishoShisetsuAlive 他市町村住所地特例者台帳管理Alive = new KaigoJogaiTokureiTaishoShisetsuAlive(entity);
            他市町村住所地特例者台帳管理Alive = 他市町村住所地特例者台帳管理Alive.createBuilderForEdit().set備考(new RString("任意項目1を変更")).build();

            assertThat(sut.save他市町村住所地特例者台帳管理Alive(他市町村住所地特例者台帳管理Alive), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbV1005KaigoJogaiTokureiTaishoShisetsuEntity.class))).thenReturn(0);

            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            entity.initializeMd5();
            KaigoJogaiTokureiTaishoShisetsuAlive 他市町村住所地特例者台帳管理Alive = new KaigoJogaiTokureiTaishoShisetsuAlive(entity);
            他市町村住所地特例者台帳管理Alive = 他市町村住所地特例者台帳管理Alive.createBuilderForEdit().set備考(new RString("任意項目1を変更")).build();

            assertThat(sut.save他市町村住所地特例者台帳管理Alive(他市町村住所地特例者台帳管理Alive), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbV1005KaigoJogaiTokureiTaishoShisetsuEntity.class))).thenReturn(1);

            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            entity.initializeMd5();
            KaigoJogaiTokureiTaishoShisetsuAlive 他市町村住所地特例者台帳管理Alive = new KaigoJogaiTokureiTaishoShisetsuAlive(entity);
            他市町村住所地特例者台帳管理Alive = 他市町村住所地特例者台帳管理Alive.deleted();

            assertThat(sut.save他市町村住所地特例者台帳管理Alive(他市町村住所地特例者台帳管理Alive), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbV1005KaigoJogaiTokureiTaishoShisetsuEntity.class))).thenReturn(0);

            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            entity.initializeMd5();
            KaigoJogaiTokureiTaishoShisetsuAlive 他市町村住所地特例者台帳管理Alive = new KaigoJogaiTokureiTaishoShisetsuAlive(entity);
            他市町村住所地特例者台帳管理Alive = 他市町村住所地特例者台帳管理Alive.deleted();

            assertThat(sut.save他市町村住所地特例者台帳管理Alive(他市町村住所地特例者台帳管理Alive), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            entity.initializeMd5();
            KaigoJogaiTokureiTaishoShisetsuAlive 他市町村住所地特例者台帳管理Alive = new KaigoJogaiTokureiTaishoShisetsuAlive(entity);

            assertThat(sut.save他市町村住所地特例者台帳管理Alive(他市町村住所地特例者台帳管理Alive), is(false));
        }
    }
}
