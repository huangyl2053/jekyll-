/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5102NinteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5102NinteiKekkaJohoDac;
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
 * {link NinteiKekkaJohoManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class NinteiKekkaJohoManagerTest {

    private static DbT5102NinteiKekkaJohoDac dac;
    private static NinteiKekkaJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5102NinteiKekkaJohoDac.class);
        sut = new NinteiKekkaJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get要介護認定結果情報 extends DbzTestBase {

        ShinseishoKanriNo 申請書管理番号 = DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の申請書管理番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get要介護認定結果情報(null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class))).thenReturn(null);

            NinteiKekkaJoho result = sut.get要介護認定結果情報(null);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5102NinteiKekkaJohoEntity entity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class))).thenReturn(entity);

            NinteiKekkaJoho result = sut.get要介護認定結果情報(申請書管理番号);

            assertThat(result.get申請書管理番号().value(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get要介護認定結果情報一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NinteiKekkaJoho> result = sut.get要介護認定結果情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5102NinteiKekkaJohoEntity> entityList = Arrays.asList(DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NinteiKekkaJoho> result = sut.get要介護認定結果情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save要介護認定結果情報 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5102NinteiKekkaJohoEntity.class))).thenReturn(1);

            DbT5102NinteiKekkaJohoEntity entity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();
            NinteiKekkaJoho 要介護認定結果情報 = new NinteiKekkaJoho(entity);

            assertThat(sut.save要介護認定結果情報(要介護認定結果情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5102NinteiKekkaJohoEntity.class))).thenReturn(0);

            DbT5102NinteiKekkaJohoEntity entity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();
            NinteiKekkaJoho 要介護認定結果情報 = new NinteiKekkaJoho(entity);

            assertThat(sut.save要介護認定結果情報(要介護認定結果情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5102NinteiKekkaJohoEntity.class))).thenReturn(1);

            DbT5102NinteiKekkaJohoEntity entity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();
            entity.initializeMd5();
            NinteiKekkaJoho 要介護認定結果情報 = new NinteiKekkaJoho(entity);
            要介護認定結果情報 = 要介護認定結果情報.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save要介護認定結果情報(要介護認定結果情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5102NinteiKekkaJohoEntity.class))).thenReturn(0);

            DbT5102NinteiKekkaJohoEntity entity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();
            entity.initializeMd5();
            NinteiKekkaJoho 要介護認定結果情報 = new NinteiKekkaJoho(entity);
            要介護認定結果情報 = 要介護認定結果情報.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save要介護認定結果情報(要介護認定結果情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5102NinteiKekkaJohoEntity.class))).thenReturn(1);

            DbT5102NinteiKekkaJohoEntity entity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();
            entity.initializeMd5();
            NinteiKekkaJoho 要介護認定結果情報 = new NinteiKekkaJoho(entity);
            要介護認定結果情報 = 要介護認定結果情報.deleted();

            assertThat(sut.save要介護認定結果情報(要介護認定結果情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5102NinteiKekkaJohoEntity.class))).thenReturn(0);

            DbT5102NinteiKekkaJohoEntity entity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();
            entity.initializeMd5();
            NinteiKekkaJoho 要介護認定結果情報 = new NinteiKekkaJoho(entity);
            要介護認定結果情報 = 要介護認定結果情報.deleted();

            assertThat(sut.save要介護認定結果情報(要介護認定結果情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5102NinteiKekkaJohoEntity entity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();
            entity.initializeMd5();
            NinteiKekkaJoho 要介護認定結果情報 = new NinteiKekkaJoho(entity);

            assertThat(sut.save要介護認定結果情報(要介護認定結果情報), is(false));
        }
    }
}
