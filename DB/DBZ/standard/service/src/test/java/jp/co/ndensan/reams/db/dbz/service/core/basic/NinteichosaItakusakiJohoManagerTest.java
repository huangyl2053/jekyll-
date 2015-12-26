/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {link NinteichosaItakusakiJohoManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class NinteichosaItakusakiJohoManagerTest {

    private static DbT5910NinteichosaItakusakiJohoDac dac;
    private static NinteichosaItakusakiJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5910NinteichosaItakusakiJohoDac.class);
        sut = new NinteichosaItakusakiJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査委託先情報 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            ChosaItakusakiCode 認定調査委託先コード = DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_認定調査委託先コード;
            sut.get認定調査委託先情報(null, 認定調査委託先コード);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の認定調査委託先コードにnullを指定した場合_NullPointerExceptionが発生する() {
            LasdecCode 市町村コード = DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード;
            sut.get認定調査委託先情報(市町村コード, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(LasdecCode.class), any(ChosaItakusakiCode.class))).thenReturn(null);

            LasdecCode 市町村コード = DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード;
            ChosaItakusakiCode 認定調査委託先コード = DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_認定調査委託先コード;
            NinteichosaItakusakiJoho result = sut.get認定調査委託先情報(市町村コード, 認定調査委託先コード);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5910NinteichosaItakusakiJohoEntity entity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
            when(dac.selectByKey(any(LasdecCode.class), any(ChosaItakusakiCode.class))).thenReturn(entity);

            LasdecCode 市町村コード = DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード;
            ChosaItakusakiCode 認定調査委託先コード = DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_認定調査委託先コード;
            NinteichosaItakusakiJoho result = sut.get認定調査委託先情報(市町村コード, 認定調査委託先コード);

            assertThat(result.get市町村コード().value(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査委託先情報一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NinteichosaItakusakiJoho> result = sut.get認定調査委託先情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5910NinteichosaItakusakiJohoEntity> entityList = Arrays.asList(DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NinteichosaItakusakiJoho> result = sut.get認定調査委託先情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get市町村コード().value(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード.value()));
        }
    }

    public static class save認定調査委託先情報 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5910NinteichosaItakusakiJohoEntity.class))).thenReturn(1);

            DbT5910NinteichosaItakusakiJohoEntity entity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
            NinteichosaItakusakiJoho 認定調査委託先情報 = new NinteichosaItakusakiJoho(entity);

            assertThat(sut.save認定調査委託先情報(認定調査委託先情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5910NinteichosaItakusakiJohoEntity.class))).thenReturn(0);

            DbT5910NinteichosaItakusakiJohoEntity entity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
            NinteichosaItakusakiJoho 認定調査委託先情報 = new NinteichosaItakusakiJoho(entity);

            assertThat(sut.save認定調査委託先情報(認定調査委託先情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5910NinteichosaItakusakiJohoEntity.class))).thenReturn(1);

            DbT5910NinteichosaItakusakiJohoEntity entity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
            entity.initializeMd5();
            NinteichosaItakusakiJoho 認定調査委託先情報 = new NinteichosaItakusakiJoho(entity);
            認定調査委託先情報 = 認定調査委託先情報.createBuilderForEdit().set市町村コード(new LasdecCode("市町村コードを変更")).build();

            assertThat(sut.save認定調査委託先情報(認定調査委託先情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5910NinteichosaItakusakiJohoEntity.class))).thenReturn(0);

            DbT5910NinteichosaItakusakiJohoEntity entity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
            entity.initializeMd5();
            NinteichosaItakusakiJoho 認定調査委託先情報 = new NinteichosaItakusakiJoho(entity);
            認定調査委託先情報 = 認定調査委託先情報.createBuilderForEdit().set市町村コード(new LasdecCode("市町村コードを変更")).build();

            assertThat(sut.save認定調査委託先情報(認定調査委託先情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5910NinteichosaItakusakiJohoEntity.class))).thenReturn(1);

            DbT5910NinteichosaItakusakiJohoEntity entity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
            entity.initializeMd5();
            NinteichosaItakusakiJoho 認定調査委託先情報 = new NinteichosaItakusakiJoho(entity);
            認定調査委託先情報 = 認定調査委託先情報.deleted();

            assertThat(sut.save認定調査委託先情報(認定調査委託先情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5910NinteichosaItakusakiJohoEntity.class))).thenReturn(0);

            DbT5910NinteichosaItakusakiJohoEntity entity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
            entity.initializeMd5();
            NinteichosaItakusakiJoho 認定調査委託先情報 = new NinteichosaItakusakiJoho(entity);
            認定調査委託先情報 = 認定調査委託先情報.deleted();

            assertThat(sut.save認定調査委託先情報(認定調査委託先情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5910NinteichosaItakusakiJohoEntity entity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
            entity.initializeMd5();
            NinteichosaItakusakiJoho 認定調査委託先情報 = new NinteichosaItakusakiJoho(entity);

            assertThat(sut.save認定調査委託先情報(認定調査委託先情報), is(false));
        }
    }
}
