/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT4001JukyushaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.business.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.realservice.JukyushaDaichoManager;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
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
 * {link JukyushaDaichoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JukyushaDaichoManagerTest {

    private static DbT4001JukyushaDaichoDac dac;
    private static JukyushaDaichoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT4001JukyushaDaichoDac.class);
        sut = new JukyushaDaichoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get受給者台帳 extends DbdTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_主キー2;
            sut.get受給者台帳(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_主キー1;
            sut.get受給者台帳(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_主キー2;
            JukyushaDaicho result = sut.get受給者台帳(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT4001JukyushaDaichoEntity entity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_主キー2;
            JukyushaDaicho result = sut.get受給者台帳(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get受給者台帳一覧 extends DbdTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<JukyushaDaicho> result = sut.get受給者台帳一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT4001JukyushaDaichoEntity> entityList = Arrays.asList(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<JukyushaDaicho> result = sut.get受給者台帳一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save受給者台帳 extends XxxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT4001JukyushaDaichoEntity.class))).thenReturn(1);

            DbT4001JukyushaDaichoEntity entity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            JukyushaDaicho 受給者台帳 = new JukyushaDaicho(entity);

            assertThat(sut.save受給者台帳(受給者台帳), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT4001JukyushaDaichoEntity.class))).thenReturn(0);

            DbT4001JukyushaDaichoEntity entity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            JukyushaDaicho 受給者台帳 = new JukyushaDaicho(entity);

            assertThat(sut.save受給者台帳(受給者台帳), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT4001JukyushaDaichoEntity.class))).thenReturn(1);

            DbT4001JukyushaDaichoEntity entity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            entity.initializeMd5();
            JukyushaDaicho 受給者台帳 = new JukyushaDaicho(entity);
            受給者台帳 = 受給者台帳.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save受給者台帳(受給者台帳), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT4001JukyushaDaichoEntity.class))).thenReturn(0);

            DbT4001JukyushaDaichoEntity entity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            entity.initializeMd5();
            JukyushaDaicho 受給者台帳 = new JukyushaDaicho(entity);
            受給者台帳 = 受給者台帳.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save受給者台帳(受給者台帳), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT4001JukyushaDaichoEntity.class))).thenReturn(1);

            DbT4001JukyushaDaichoEntity entity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            entity.initializeMd5();
            JukyushaDaicho 受給者台帳 = new JukyushaDaicho(entity);
            受給者台帳 = 受給者台帳.deleted();

            assertThat(sut.save受給者台帳(受給者台帳), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT4001JukyushaDaichoEntity.class))).thenReturn(0);

            DbT4001JukyushaDaichoEntity entity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            entity.initializeMd5();
            JukyushaDaicho 受給者台帳 = new JukyushaDaicho(entity);
            受給者台帳 = 受給者台帳.deleted();

            assertThat(sut.save受給者台帳(受給者台帳), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT4001JukyushaDaichoEntity entity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            entity.initializeMd5();
            JukyushaDaicho 受給者台帳 = new JukyushaDaicho(entity);

            assertThat(sut.save受給者台帳(受給者台帳), is(false));
        }
    }
}
