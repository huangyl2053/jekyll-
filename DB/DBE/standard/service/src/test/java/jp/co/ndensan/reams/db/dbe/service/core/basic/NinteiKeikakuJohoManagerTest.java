/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5123NinteiKeikakuJohoDac;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ninteikeikakujoho.NinteiKeikakuJohoManager;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link NinteiKeikakuJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class NinteiKeikakuJohoManagerTest {

    private static DbT5123NinteiKeikakuJohoDac dac;
    private static NinteiKeikakuJohoManager sut;
// TODO
//    @BeforeClass
//    public static void test() {
//        dac = mock(DbT5123NinteiKeikakuJohoDac.class);
//        sut = new NinteiKeikakuJohoManager(dac);
//    }
//
//    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
//    public static class get要介護認定計画情報 extends DbeTestBase {
//
//        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
//            sut.get要介護認定計画情報(null);
//        }
//
//        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
//        @Test
//        public void 検索結果がnullの場合() {
//            when(dac.selectByKey(any(ShinseishoKanriNo.class))).thenReturn(null);
//            ShinseishoKanriNo 主キー1 = DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_申請書管理番号;
//            NinteiKeikakuJoho result = sut.get要介護認定計画情報(主キー1);
//
//            assertThat(result, is(nullValue()));
//        }
//
//        @Test
//        public void 検索結果が存在する場合() {
//            DbT5123NinteiKeikakuJohoEntity entity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();
//            when(dac.selectByKey(any(ShinseishoKanriNo.class))).thenReturn(entity);
//            ShinseishoKanriNo 主キー1 = DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_申請書管理番号;
//            NinteiKeikakuJoho result = sut.get要介護認定計画情報(主キー1);
//
//            assertThat(result.get申請書管理番号().value(), is(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
//        }
//    }
//
//    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
//    public static class get要介護認定計画情報一覧 extends DbeTestBase {
//
//        @Test
//        public void 検索結果が空の場合() {
//            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);
//
//            List<NinteiKeikakuJoho> result = sut.get要介護認定計画情報一覧();
//
//            assertThat(result.isEmpty(), is(true));
//        }
//
//        @Test
//        public void 検索結果が存在する場合() {
//            List<DbT5123NinteiKeikakuJohoEntity> entityList = Arrays.asList(DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity());
//            when(dac.selectAll()).thenReturn(entityList);
//
//            List<NinteiKeikakuJoho> result = sut.get要介護認定計画情報一覧();
//
//            assertThat(result.size(), is(1));
//            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
//        }
//    }
//
//    public static class save要介護認定計画情報 extends DbeTestBase {
//
//        @Test
//        public void insertに成功するとtrueが返る() {
//            when(dac.save(any(DbT5123NinteiKeikakuJohoEntity.class))).thenReturn(1);
//
//            DbT5123NinteiKeikakuJohoEntity entity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();
//            NinteiKeikakuJoho 要介護認定計画情報 = new NinteiKeikakuJoho(entity);
//
//            assertThat(sut.save要介護認定計画情報(要介護認定計画情報), is(true));
//        }
//
//        @Test
//        public void insertに失敗するとfalseが返る() {
//            when(dac.save(any(DbT5123NinteiKeikakuJohoEntity.class))).thenReturn(0);
//
//            DbT5123NinteiKeikakuJohoEntity entity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();
//            NinteiKeikakuJoho 要介護認定計画情報 = new NinteiKeikakuJoho(entity);
//
//            assertThat(sut.save要介護認定計画情報(要介護認定計画情報), is(false));
//        }
//
//        @Test
//        public void updateに成功するとtrueが返る() {
//            when(dac.save(any(DbT5123NinteiKeikakuJohoEntity.class))).thenReturn(1);
//
//            DbT5123NinteiKeikakuJohoEntity entity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();
//            entity.initializeMd5();
//            NinteiKeikakuJoho 要介護認定計画情報 = new NinteiKeikakuJoho(entity);
//            要介護認定計画情報 = 要介護認定計画情報.createBuilderForEdit().setセンター送信予定年月日(new FlexibleDate("20100101")).build();
//
//            assertThat(sut.save要介護認定計画情報(要介護認定計画情報), is(true));
//        }
//
//        @Test
//        public void updateに失敗するとfalseが返る() {
//            when(dac.save(any(DbT5123NinteiKeikakuJohoEntity.class))).thenReturn(0);
//
//            DbT5123NinteiKeikakuJohoEntity entity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();
//            entity.initializeMd5();
//            NinteiKeikakuJoho 要介護認定計画情報 = new NinteiKeikakuJoho(entity);
//            要介護認定計画情報 = 要介護認定計画情報.createBuilderForEdit().setセンター送信予定年月日(new FlexibleDate("20100101")).build();
//
//            assertThat(sut.save要介護認定計画情報(要介護認定計画情報), is(false));
//        }
//
//        @Test
//        public void deleteに成功するとtrueが返る() {
//            when(dac.save(any(DbT5123NinteiKeikakuJohoEntity.class))).thenReturn(1);
//
//            DbT5123NinteiKeikakuJohoEntity entity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();
//            entity.initializeMd5();
//            NinteiKeikakuJoho 要介護認定計画情報 = new NinteiKeikakuJoho(entity);
//            要介護認定計画情報 = 要介護認定計画情報.deleted();
//
//            assertThat(sut.save要介護認定計画情報(要介護認定計画情報), is(true));
//        }
//
//        @Test
//        public void deleteに失敗するとfalseが返る() {
//            when(dac.save(any(DbT5123NinteiKeikakuJohoEntity.class))).thenReturn(0);
//
//            DbT5123NinteiKeikakuJohoEntity entity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();
//            entity.initializeMd5();
//            NinteiKeikakuJoho 要介護認定計画情報 = new NinteiKeikakuJoho(entity);
//            要介護認定計画情報 = 要介護認定計画情報.deleted();
//
//            assertThat(sut.save要介護認定計画情報(要介護認定計画情報), is(false));
//        }
//
//        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
//            DbT5123NinteiKeikakuJohoEntity entity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();
//            entity.initializeMd5();
//            NinteiKeikakuJoho 要介護認定計画情報 = new NinteiKeikakuJoho(entity);
//
//            assertThat(sut.save要介護認定計画情報(要介護認定計画情報), is(false));
//        }
//    }
}
