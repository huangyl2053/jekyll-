/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5201NinteichosaIraiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5201NinteichosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {link NinteichosaIraiJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiJohoManagerTest {

    private static DbT5201NinteichosaIraiJohoDac dac;
    private static NinteichosaIraiJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5201NinteichosaIraiJohoDac.class);
        sut = new NinteichosaIraiJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査依頼情報 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の申請書管理番号にnullを指定した場合_NullPointerExceptionが発生する() {
            int 認定調査依頼履歴番号 = DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査依頼履歴番号;
            sut.get認定調査依頼情報(null, 認定調査依頼履歴番号);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class))).thenReturn(null);

            ShinseishoKanriNo 申請書管理番号 = DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_申請書管理番号;
            int 認定調査依頼履歴番号 = DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査依頼履歴番号;
            NinteichosaIraiJoho result = sut.get認定調査依頼情報(申請書管理番号, 認定調査依頼履歴番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5201NinteichosaIraiJohoEntity entity = DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class))).thenReturn(entity);

            ShinseishoKanriNo 申請書管理番号 = DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_申請書管理番号;
            int 認定調査依頼履歴番号 = DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査依頼履歴番号;
            NinteichosaIraiJoho result = sut.get認定調査依頼情報(申請書管理番号, 認定調査依頼履歴番号);

            assertThat(result.get申請書管理番号().value(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査依頼情報一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NinteichosaIraiJoho> result = sut.get認定調査依頼情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5201NinteichosaIraiJohoEntity> entityList = Arrays.asList(DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NinteichosaIraiJoho> result = sut.get認定調査依頼情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save認定調査依頼情報 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5201NinteichosaIraiJohoEntity.class))).thenReturn(1);

            DbT5201NinteichosaIraiJohoEntity entity = DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity();
            NinteichosaIraiJoho 認定調査依頼情報 = new NinteichosaIraiJoho(entity);

            assertThat(sut.save認定調査依頼情報(認定調査依頼情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5201NinteichosaIraiJohoEntity.class))).thenReturn(0);

            DbT5201NinteichosaIraiJohoEntity entity = DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity();
            NinteichosaIraiJoho 認定調査依頼情報 = new NinteichosaIraiJoho(entity);

            assertThat(sut.save認定調査依頼情報(認定調査依頼情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5201NinteichosaIraiJohoEntity.class))).thenReturn(1);

            DbT5201NinteichosaIraiJohoEntity entity = DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity();
            entity.initializeMd5();
            NinteichosaIraiJoho 認定調査依頼情報 = new NinteichosaIraiJoho(entity);
            認定調査依頼情報 = 認定調査依頼情報.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save認定調査依頼情報(認定調査依頼情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5201NinteichosaIraiJohoEntity.class))).thenReturn(0);

            DbT5201NinteichosaIraiJohoEntity entity = DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity();
            entity.initializeMd5();
            NinteichosaIraiJoho 認定調査依頼情報 = new NinteichosaIraiJoho(entity);
            認定調査依頼情報 = 認定調査依頼情報.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save認定調査依頼情報(認定調査依頼情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5201NinteichosaIraiJohoEntity.class))).thenReturn(1);

            DbT5201NinteichosaIraiJohoEntity entity = DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity();
            entity.initializeMd5();
            NinteichosaIraiJoho 認定調査依頼情報 = new NinteichosaIraiJoho(entity);
            認定調査依頼情報 = 認定調査依頼情報.deleted();

            assertThat(sut.save認定調査依頼情報(認定調査依頼情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5201NinteichosaIraiJohoEntity.class))).thenReturn(0);

            DbT5201NinteichosaIraiJohoEntity entity = DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity();
            entity.initializeMd5();
            NinteichosaIraiJoho 認定調査依頼情報 = new NinteichosaIraiJoho(entity);
            認定調査依頼情報 = 認定調査依頼情報.deleted();

            assertThat(sut.save認定調査依頼情報(認定調査依頼情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5201NinteichosaIraiJohoEntity entity = DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity();
            entity.initializeMd5();
            NinteichosaIraiJoho 認定調査依頼情報 = new NinteichosaIraiJoho(entity);

            assertThat(sut.save認定調査依頼情報(認定調査依頼情報), is(false));
        }
    }
}
