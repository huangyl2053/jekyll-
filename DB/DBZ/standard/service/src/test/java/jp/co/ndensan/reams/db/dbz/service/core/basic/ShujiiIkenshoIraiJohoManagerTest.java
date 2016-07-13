/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5301ShujiiIkenshoIraiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5301ShujiiIkenshoIraiJohoDac;
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
 * {link ShujiiIkenshoIraiJohoManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ShujiiIkenshoIraiJohoManagerTest {

    private static DbT5301ShujiiIkenshoIraiJohoDac dac;
    private static ShujiiIkenshoIraiJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5301ShujiiIkenshoIraiJohoDac.class);
        sut = new ShujiiIkenshoIraiJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get主治医意見書作成依頼情報 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のShinseishoKanriNoにnullを指定した場合_NullPointerExceptionが発生する() {
            int 主治医意見書作成依頼履歴番号 = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
            sut.get主治医意見書作成依頼情報(null, 主治医意見書作成依頼履歴番号);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class))).thenReturn(null);

            ShinseishoKanriNo 申請書管理番号 = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_申請書管理番号;
            int 主治医意見書作成依頼履歴番号 = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
            ShujiiIkenshoIraiJoho result = sut.get主治医意見書作成依頼情報(申請書管理番号, 主治医意見書作成依頼履歴番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5301ShujiiIkenshoIraiJohoEntity entity = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class))).thenReturn(entity);

            ShinseishoKanriNo 申請書管理番号 = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_申請書管理番号;
            int 主治医意見書作成依頼履歴番号 = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
            ShujiiIkenshoIraiJoho result = sut.get主治医意見書作成依頼情報(申請書管理番号, 主治医意見書作成依頼履歴番号);

            assertThat(result.get申請書管理番号().value(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get主治医意見書作成依頼情報一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShujiiIkenshoIraiJoho> result = sut.get主治医意見書作成依頼情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5301ShujiiIkenshoIraiJohoEntity> entityList = Arrays.asList(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShujiiIkenshoIraiJoho> result = sut.get主治医意見書作成依頼情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save主治医意見書作成依頼情報 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5301ShujiiIkenshoIraiJohoEntity.class))).thenReturn(1);

            DbT5301ShujiiIkenshoIraiJohoEntity entity = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity();
            ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = new ShujiiIkenshoIraiJoho(entity);

            assertThat(sut.save主治医意見書作成依頼情報(主治医意見書作成依頼情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5301ShujiiIkenshoIraiJohoEntity.class))).thenReturn(0);

            DbT5301ShujiiIkenshoIraiJohoEntity entity = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity();
            ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = new ShujiiIkenshoIraiJoho(entity);

            assertThat(sut.save主治医意見書作成依頼情報(主治医意見書作成依頼情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5301ShujiiIkenshoIraiJohoEntity.class))).thenReturn(1);

            DbT5301ShujiiIkenshoIraiJohoEntity entity = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity();
            entity.initializeMd5();
            ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = new ShujiiIkenshoIraiJoho(entity);
            主治医意見書作成依頼情報 = 主治医意見書作成依頼情報.deleted();

            assertThat(sut.save主治医意見書作成依頼情報(主治医意見書作成依頼情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5301ShujiiIkenshoIraiJohoEntity.class))).thenReturn(0);

            DbT5301ShujiiIkenshoIraiJohoEntity entity = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity();
            entity.initializeMd5();
            ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = new ShujiiIkenshoIraiJoho(entity);
            主治医意見書作成依頼情報 = 主治医意見書作成依頼情報.deleted();

            assertThat(sut.save主治医意見書作成依頼情報(主治医意見書作成依頼情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5301ShujiiIkenshoIraiJohoEntity entity = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity();
            entity.initializeMd5();
            ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = new ShujiiIkenshoIraiJoho(entity);

            assertThat(sut.save主治医意見書作成依頼情報(主治医意見書作成依頼情報), is(false));
        }
    }
}
