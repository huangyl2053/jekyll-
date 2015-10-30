/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4116IchijiHanteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4116IchijiHanteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link IchijiHanteiKekkaJohoManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class IchijiHanteiKekkaJohoManagerTest {

    private static DbT4116IchijiHanteiKekkaJohoDac dac;
    private static IchijiHanteiKekkaJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT4116IchijiHanteiKekkaJohoDac.class);
        sut = new IchijiHanteiKekkaJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get要介護認定一次判定結果情報 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get要介護認定一次判定結果情報(null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class))).thenReturn(null);
            ShinseishoKanriNo 主キー1 = DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号;
            IchijiHanteiKekkaJoho result = sut.get要介護認定一次判定結果情報(主キー1);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT4116IchijiHanteiKekkaJohoEntity entity = DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class))).thenReturn(entity);
            ShinseishoKanriNo 主キー1 = DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号;
            IchijiHanteiKekkaJoho result = sut.get要介護認定一次判定結果情報(主キー1);

            assertThat(result.get申請書管理番号().value(), is(DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get要介護認定一次判定結果情報一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<IchijiHanteiKekkaJoho> result = sut.get要介護認定一次判定結果情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT4116IchijiHanteiKekkaJohoEntity> entityList = Arrays.asList(DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<IchijiHanteiKekkaJoho> result = sut.get要介護認定一次判定結果情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save要介護認定一次判定結果情報 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT4116IchijiHanteiKekkaJohoEntity.class))).thenReturn(1);

            DbT4116IchijiHanteiKekkaJohoEntity entity = DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity();
            IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 = new IchijiHanteiKekkaJoho(entity);

            assertThat(sut.save要介護認定一次判定結果情報(要介護認定一次判定結果情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT4116IchijiHanteiKekkaJohoEntity.class))).thenReturn(0);

            DbT4116IchijiHanteiKekkaJohoEntity entity = DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity();
            IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 = new IchijiHanteiKekkaJoho(entity);

            assertThat(sut.save要介護認定一次判定結果情報(要介護認定一次判定結果情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT4116IchijiHanteiKekkaJohoEntity.class))).thenReturn(1);

            DbT4116IchijiHanteiKekkaJohoEntity entity = DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity();
            entity.initializeMd5();
            IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 = new IchijiHanteiKekkaJoho(entity);
            要介護認定一次判定結果情報 = 要介護認定一次判定結果情報.createBuilderForEdit().set要介護認定一次判定結果コード(new Code("3")).build();

            assertThat(sut.save要介護認定一次判定結果情報(要介護認定一次判定結果情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT4116IchijiHanteiKekkaJohoEntity.class))).thenReturn(0);

            DbT4116IchijiHanteiKekkaJohoEntity entity = DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity();
            entity.initializeMd5();
            IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 = new IchijiHanteiKekkaJoho(entity);
            要介護認定一次判定結果情報 = 要介護認定一次判定結果情報.createBuilderForEdit().set要介護認定一次判定結果コード(new Code("3")).build();

            assertThat(sut.save要介護認定一次判定結果情報(要介護認定一次判定結果情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT4116IchijiHanteiKekkaJohoEntity.class))).thenReturn(1);

            DbT4116IchijiHanteiKekkaJohoEntity entity = DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity();
            entity.initializeMd5();
            IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 = new IchijiHanteiKekkaJoho(entity);
            要介護認定一次判定結果情報 = 要介護認定一次判定結果情報.deleted();

            assertThat(sut.save要介護認定一次判定結果情報(要介護認定一次判定結果情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT4116IchijiHanteiKekkaJohoEntity.class))).thenReturn(0);

            DbT4116IchijiHanteiKekkaJohoEntity entity = DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity();
            entity.initializeMd5();
            IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 = new IchijiHanteiKekkaJoho(entity);
            要介護認定一次判定結果情報 = 要介護認定一次判定結果情報.deleted();

            assertThat(sut.save要介護認定一次判定結果情報(要介護認定一次判定結果情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT4116IchijiHanteiKekkaJohoEntity entity = DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity();
            entity.initializeMd5();
            IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 = new IchijiHanteiKekkaJoho(entity);

            assertThat(sut.save要介護認定一次判定結果情報(要介護認定一次判定結果情報), is(false));
        }
    }
}
