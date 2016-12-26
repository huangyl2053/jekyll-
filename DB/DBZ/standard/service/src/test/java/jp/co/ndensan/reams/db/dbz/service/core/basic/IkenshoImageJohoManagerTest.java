/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IkenshoImageJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5305IkenshoImageJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5305IkenshoImageJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5305IkenshoImageJohoDac;
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
 * {link IkenshoImageJohoManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class IkenshoImageJohoManagerTest {

    private static DbT5305IkenshoImageJohoDac dac;
    private static IkenshoImageJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5305IkenshoImageJohoDac.class);
        sut = new IkenshoImageJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get要介護認定意見書イメージ情報 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            int 主キー2 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
            Code 主キー3 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_帳票ID;
            RString 主キー4 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_マスキングデータ区分;
            int 主キー5 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_取込みページ番号;
            sut.get要介護認定意見書イメージ情報(null, 主キー2, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            ShinseishoKanriNo 主キー1 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_申請書管理番号;
            int 主キー2 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
            RString 主キー4 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_マスキングデータ区分;
            int 主キー5 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_取込みページ番号;
            sut.get要介護認定意見書イメージ情報(主キー1, 主キー2, null, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            ShinseishoKanriNo 主キー1 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_申請書管理番号;
            int 主キー2 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
            Code 主キー3 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_帳票ID;
            int 主キー5 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_取込みページ番号;
            sut.get要介護認定意見書イメージ情報(主キー1, 主キー2, 主キー3, null, 主キー5);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class), any(Code.class), any(RString.class), any(int.class))).thenReturn(null);
            ShinseishoKanriNo 主キー1 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_申請書管理番号;
            int 主キー2 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
            Code 主キー3 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_帳票ID;
            RString 主キー4 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_マスキングデータ区分;
            int 主キー5 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_取込みページ番号;
            IkenshoImageJoho result = sut.get要介護認定意見書イメージ情報(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5305IkenshoImageJohoEntity entity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class), any(Code.class), any(RString.class), any(int.class))).thenReturn(entity);
            ShinseishoKanriNo 主キー1 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_申請書管理番号;
            int 主キー2 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
            Code 主キー3 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_帳票ID;
            RString 主キー4 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_マスキングデータ区分;
            int 主キー5 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_取込みページ番号;
            IkenshoImageJoho result = sut.get要介護認定意見書イメージ情報(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result.get申請書管理番号().value(), is(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get要介護認定意見書イメージ情報一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<IkenshoImageJoho> result = sut.get要介護認定意見書イメージ情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5305IkenshoImageJohoEntity> entityList = Arrays.asList(DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<IkenshoImageJoho> result = sut.get要介護認定意見書イメージ情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save要介護認定意見書イメージ情報 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5305IkenshoImageJohoEntity.class))).thenReturn(1);

            DbT5305IkenshoImageJohoEntity entity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();
            IkenshoImageJoho 要介護認定意見書イメージ情報 = new IkenshoImageJoho(entity);

            assertThat(sut.save要介護認定意見書イメージ情報(要介護認定意見書イメージ情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5305IkenshoImageJohoEntity.class))).thenReturn(0);

            DbT5305IkenshoImageJohoEntity entity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();
            IkenshoImageJoho 要介護認定意見書イメージ情報 = new IkenshoImageJoho(entity);

            assertThat(sut.save要介護認定意見書イメージ情報(要介護認定意見書イメージ情報), is(false));
        }

//        @Test
//        public void updateに成功するとtrueが返る() {
//            when(dac.save(any(DbT5305IkenshoImageJohoEntity.class))).thenReturn(1);
//
//            DbT5305IkenshoImageJohoEntity entity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();
//            entity.initializeMd5();
//            IkenshoImageJoho 要介護認定意見書イメージ情報 = new IkenshoImageJoho(entity);
//            要介護認定意見書イメージ情報 = 要介護認定意見書イメージ情報.createBuilderForEdit().set認定申請年(1999).build();
//
//            assertThat(sut.save要介護認定意見書イメージ情報(要介護認定意見書イメージ情報), is(true));
//        }

//        @Test
//        public void updateに失敗するとfalseが返る() {
//            when(dac.save(any(DbT5305IkenshoImageJohoEntity.class))).thenReturn(0);
//
//            DbT5305IkenshoImageJohoEntity entity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();
//            entity.initializeMd5();
//            IkenshoImageJoho 要介護認定意見書イメージ情報 = new IkenshoImageJoho(entity);
//            要介護認定意見書イメージ情報 = 要介護認定意見書イメージ情報.createBuilderForEdit().set認定申請年(1999).build();
//
//            assertThat(sut.save要介護認定意見書イメージ情報(要介護認定意見書イメージ情報), is(false));
//        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5305IkenshoImageJohoEntity.class))).thenReturn(1);

            DbT5305IkenshoImageJohoEntity entity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();
            entity.initializeMd5();
            IkenshoImageJoho 要介護認定意見書イメージ情報 = new IkenshoImageJoho(entity);
            要介護認定意見書イメージ情報 = 要介護認定意見書イメージ情報.deleted();

            assertThat(sut.save要介護認定意見書イメージ情報(要介護認定意見書イメージ情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5305IkenshoImageJohoEntity.class))).thenReturn(0);

            DbT5305IkenshoImageJohoEntity entity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();
            entity.initializeMd5();
            IkenshoImageJoho 要介護認定意見書イメージ情報 = new IkenshoImageJoho(entity);
            要介護認定意見書イメージ情報 = 要介護認定意見書イメージ情報.deleted();

            assertThat(sut.save要介護認定意見書イメージ情報(要介護認定意見書イメージ情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5305IkenshoImageJohoEntity entity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();
            entity.initializeMd5();
            IkenshoImageJoho 要介護認定意見書イメージ情報 = new IkenshoImageJoho(entity);

            assertThat(sut.save要介護認定意見書イメージ情報(要介護認定意見書イメージ情報), is(false));
        }
    }
}
