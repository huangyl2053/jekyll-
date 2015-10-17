/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5105NinteiKanryoJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {link NinteiKanryoJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteiKanryoJohoManagerTest {

    private static DbT5105NinteiKanryoJohoDac dac;
    private static NinteiKanryoJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5105NinteiKanryoJohoDac.class);
        sut = new NinteiKanryoJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get要介護認定完了情報 extends DbeTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get要介護認定完了情報(null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class))).thenReturn(null);
            ShinseishoKanriNo 主キー1 = DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_申請書管理番号;
            NinteiKanryoJoho result = sut.get要介護認定完了情報(主キー1);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5105NinteiKanryoJohoEntity entity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class))).thenReturn(entity);
            ShinseishoKanriNo 主キー1 = DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_申請書管理番号;
            NinteiKanryoJoho result = sut.get要介護認定完了情報(主キー1);

            assertThat(result.get申請書管理番号().value(), is(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get要介護認定完了情報一覧 extends DbeTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NinteiKanryoJoho> result = sut.get要介護認定完了情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5105NinteiKanryoJohoEntity> entityList = Arrays.asList(DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NinteiKanryoJoho> result = sut.get要介護認定完了情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save要介護認定完了情報 extends DbeTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5105NinteiKanryoJohoEntity.class))).thenReturn(1);

            DbT5105NinteiKanryoJohoEntity entity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();
            NinteiKanryoJoho 要介護認定完了情報 = new NinteiKanryoJoho(entity);

            assertThat(sut.save要介護認定完了情報(要介護認定完了情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5105NinteiKanryoJohoEntity.class))).thenReturn(0);

            DbT5105NinteiKanryoJohoEntity entity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();
            NinteiKanryoJoho 要介護認定完了情報 = new NinteiKanryoJoho(entity);

            assertThat(sut.save要介護認定完了情報(要介護認定完了情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5105NinteiKanryoJohoEntity.class))).thenReturn(1);

            DbT5105NinteiKanryoJohoEntity entity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();
            entity.initializeMd5();
            NinteiKanryoJoho 要介護認定完了情報 = new NinteiKanryoJoho(entity);
            要介護認定完了情報 = 要介護認定完了情報.createBuilderForEdit().set要介護認定一次判定完了年月日(new FlexibleDate("20160101")).build();

            assertThat(sut.save要介護認定完了情報(要介護認定完了情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5105NinteiKanryoJohoEntity.class))).thenReturn(0);

            DbT5105NinteiKanryoJohoEntity entity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();
            entity.initializeMd5();
            NinteiKanryoJoho 要介護認定完了情報 = new NinteiKanryoJoho(entity);
            要介護認定完了情報 = 要介護認定完了情報.createBuilderForEdit().set要介護認定一次判定完了年月日(new FlexibleDate("20160101")).build();

            assertThat(sut.save要介護認定完了情報(要介護認定完了情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5105NinteiKanryoJohoEntity.class))).thenReturn(1);

            DbT5105NinteiKanryoJohoEntity entity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();
            entity.initializeMd5();
            NinteiKanryoJoho 要介護認定完了情報 = new NinteiKanryoJoho(entity);
            要介護認定完了情報 = 要介護認定完了情報.deleted();

            assertThat(sut.save要介護認定完了情報(要介護認定完了情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5105NinteiKanryoJohoEntity.class))).thenReturn(0);

            DbT5105NinteiKanryoJohoEntity entity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();
            entity.initializeMd5();
            NinteiKanryoJoho 要介護認定完了情報 = new NinteiKanryoJoho(entity);
            要介護認定完了情報 = 要介護認定完了情報.deleted();

            assertThat(sut.save要介護認定完了情報(要介護認定完了情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5105NinteiKanryoJohoEntity entity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();
            entity.initializeMd5();
            NinteiKanryoJoho 要介護認定完了情報 = new NinteiKanryoJoho(entity);

            assertThat(sut.save要介護認定完了情報(要介護認定完了情報), is(false));
        }
    }
}
