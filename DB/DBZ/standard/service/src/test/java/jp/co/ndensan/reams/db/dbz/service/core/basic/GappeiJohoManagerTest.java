/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GappeiJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7055GappeiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7055GappeiJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {link GappeiJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GappeiJohoManagerTest {

    private static DbT7055GappeiJohoDac dac;
    private static GappeiJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7055GappeiJohoDac.class);
        sut = new GappeiJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get合併情報 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT7055GappeiJohoEntityGenerator.DEFAULT_地域番号;
            sut.get合併情報(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー1 = DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日;
            sut.get合併情報(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleDate.class), any(RString.class))).thenReturn(null);

            FlexibleDate 主キー1 = DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日;
            RString 主キー2 = DbT7055GappeiJohoEntityGenerator.DEFAULT_地域番号;
            GappeiJoho result = sut.get合併情報(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            when(dac.selectByKey(any(FlexibleDate.class), any(RString.class))).thenReturn(entity);
            FlexibleDate 主キー1 = DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日;
            RString 主キー2 = DbT7055GappeiJohoEntityGenerator.DEFAULT_地域番号;
            GappeiJoho result = sut.get合併情報(主キー1, 主キー2);

            assertThat(result.get合併年月日().toString(), is(DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日.toString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get合併情報一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<GappeiJoho> result = sut.get合併情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7055GappeiJohoEntity> entityList = Arrays.asList(DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<GappeiJoho> result = sut.get合併情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get合併年月日().toString(), is(DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日.toString()));
        }
    }

    public static class save合併情報 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7055GappeiJohoEntity.class))).thenReturn(1);

            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            GappeiJoho 合併情報 = new GappeiJoho(entity);

            assertThat(sut.save合併情報(合併情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7055GappeiJohoEntity.class))).thenReturn(0);

            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            GappeiJoho 合併情報 = new GappeiJoho(entity);

            assertThat(sut.save合併情報(合併情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7055GappeiJohoEntity.class))).thenReturn(1);

            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            entity.initializeMd5();
            GappeiJoho 合併情報 = new GappeiJoho(entity);
            合併情報 = 合併情報.createBuilderForEdit().set合併種類(new RString("任意項目1を変更")).build();

            assertThat(sut.save合併情報(合併情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7055GappeiJohoEntity.class))).thenReturn(0);

            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            entity.initializeMd5();
            GappeiJoho 合併情報 = new GappeiJoho(entity);
            合併情報 = 合併情報.createBuilderForEdit().set合併種類(new RString("任意項目1を変更")).build();

            assertThat(sut.save合併情報(合併情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7055GappeiJohoEntity.class))).thenReturn(1);

            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            entity.initializeMd5();
            GappeiJoho 合併情報 = new GappeiJoho(entity);
            合併情報 = 合併情報.deleted();

            assertThat(sut.save合併情報(合併情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7055GappeiJohoEntity.class))).thenReturn(0);

            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            entity.initializeMd5();
            GappeiJoho 合併情報 = new GappeiJoho(entity);
            合併情報 = 合併情報.deleted();

            assertThat(sut.save合併情報(合併情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            entity.initializeMd5();
            GappeiJoho 合併情報 = new GappeiJoho(entity);

            assertThat(sut.save合併情報(合併情報), is(false));
        }
    }
}
