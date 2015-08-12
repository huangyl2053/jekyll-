/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RojinHokenJukyushaJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7005RojinHokenJukyushaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7005RojinHokenJukyushaJohoDac;
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
 * {link RojinHokenJukyushaJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RojinHokenJukyushaJohoManagerTest {

    private static DbT7005RojinHokenJukyushaJohoDac dac;
    private static RojinHokenJukyushaJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7005RojinHokenJukyushaJohoDac.class);
        sut = new RojinHokenJukyushaJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get老人保健受給者情報 extends FdaTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_主キー2;
            sut.get老人保健受給者情報(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_主キー1;
            sut.get老人保健受給者情報(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_主キー2;
            RojinHokenJukyushaJoho result = sut.get老人保健受給者情報(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7005RojinHokenJukyushaJohoEntity entity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_主キー2;
            RojinHokenJukyushaJoho result = sut.get老人保健受給者情報(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get老人保健受給者情報一覧 extends FdaTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<RojinHokenJukyushaJoho> result = sut.get老人保健受給者情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7005RojinHokenJukyushaJohoEntity> entityList = Arrays.asList(DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<RojinHokenJukyushaJoho> result = sut.get老人保健受給者情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save老人保健受給者情報 extends XxxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7005RojinHokenJukyushaJohoEntity.class))).thenReturn(1);

            DbT7005RojinHokenJukyushaJohoEntity entity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            RojinHokenJukyushaJoho 老人保健受給者情報 = new RojinHokenJukyushaJoho(entity);

            assertThat(sut.save老人保健受給者情報(老人保健受給者情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7005RojinHokenJukyushaJohoEntity.class))).thenReturn(0);

            DbT7005RojinHokenJukyushaJohoEntity entity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            RojinHokenJukyushaJoho 老人保健受給者情報 = new RojinHokenJukyushaJoho(entity);

            assertThat(sut.save老人保健受給者情報(老人保健受給者情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7005RojinHokenJukyushaJohoEntity.class))).thenReturn(1);

            DbT7005RojinHokenJukyushaJohoEntity entity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            entity.initializeMd5();
            RojinHokenJukyushaJoho 老人保健受給者情報 = new RojinHokenJukyushaJoho(entity);
            老人保健受給者情報 = 老人保健受給者情報.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save老人保健受給者情報(老人保健受給者情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7005RojinHokenJukyushaJohoEntity.class))).thenReturn(0);

            DbT7005RojinHokenJukyushaJohoEntity entity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            entity.initializeMd5();
            RojinHokenJukyushaJoho 老人保健受給者情報 = new RojinHokenJukyushaJoho(entity);
            老人保健受給者情報 = 老人保健受給者情報.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save老人保健受給者情報(老人保健受給者情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7005RojinHokenJukyushaJohoEntity.class))).thenReturn(1);

            DbT7005RojinHokenJukyushaJohoEntity entity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            entity.initializeMd5();
            RojinHokenJukyushaJoho 老人保健受給者情報 = new RojinHokenJukyushaJoho(entity);
            老人保健受給者情報 = 老人保健受給者情報.deleted();

            assertThat(sut.save老人保健受給者情報(老人保健受給者情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7005RojinHokenJukyushaJohoEntity.class))).thenReturn(0);

            DbT7005RojinHokenJukyushaJohoEntity entity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            entity.initializeMd5();
            RojinHokenJukyushaJoho 老人保健受給者情報 = new RojinHokenJukyushaJoho(entity);
            老人保健受給者情報 = 老人保健受給者情報.deleted();

            assertThat(sut.save老人保健受給者情報(老人保健受給者情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7005RojinHokenJukyushaJohoEntity entity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            entity.initializeMd5();
            RojinHokenJukyushaJoho 老人保健受給者情報 = new RojinHokenJukyushaJoho(entity);

            assertThat(sut.save老人保健受給者情報(老人保健受給者情報), is(false));
        }
    }
}
