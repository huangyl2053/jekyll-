/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteichosaItakusakiJoho}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class NinteichosaItakusakiJohoTest extends DbzTestBase {
//
//    private static DbT5910NinteichosaItakusakiJohoEntity NinteichosaItakusakiJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
////TODO 主キー型と変数名を置換してください
////TODO 主キーの数が足りない場合、追加してください。
//    private static LasdecCode 市町村コード;
//    private static ChosaItakusakiCode 認定調査委託先コード;
//
//    @BeforeClass
//    public static void setUpClass() {
////TODO 主キー値を適切な値に置換してください
//        市町村コード = DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード;
//        認定調査委託先コード = DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_認定調査委託先コード;
//    }
//
//    public static class 主キーコンストラクタテスト extends DbzTestBase {
//
//        private static NinteichosaItakusakiJoho sut;
//
//        @BeforeClass
//        public static void setUpClass() {
//            NinteichosaItakusakiJohoEntity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
//        }
//
////TODO 主キー名を置換してください
//        @Test(expected = NullPointerException.class)
//        public void 市町村コードがnullである場合に_NullPointerExceptionが発生する() {
//            sut = new NinteichosaItakusakiJoho(null, 認定調査委託先コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 認定調査委託先コードがnullである場合に_NullPointerExceptionが発生する() {
//            sut = new NinteichosaItakusakiJoho(市町村コード, null);
//        }
//
//        @Test
//        public void 指定したキーが保持するDbT5910NinteichosaItakusakiJohoEntityにセットされている() {
//            sut = new NinteichosaItakusakiJoho(市町村コード, 認定調査委託先コード);
//            assertThat(sut.get市町村コード(), is(市町村コード));
//            assertThat(sut.get認定調査委託先コード(), is(認定調査委託先コード));
//        }
//
//        @Test
//        public void 指定したキーが保持するNinteichosaItakusakiJohoIdentifierにセットされている() {
//            sut = new NinteichosaItakusakiJoho(市町村コード, 認定調査委託先コード);
//            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
//            assertThat(sut.identifier().get認定調査委託先コード(), is(認定調査委託先コード));
//        }
//    }
//
//    public static class Entityコンストラクタテスト extends DbzTestBase {
//
//        private static NinteichosaItakusakiJoho sut;
//
//        @BeforeClass
//        public static void setUpClass() {
//            NinteichosaItakusakiJohoEntity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
//            sut = new NinteichosaItakusakiJoho(null);
//        }
//
//        @Test
//        public void 指定したDbT5910NinteichosaItakusakiJohoEntityのキー情報を識別子が持つ() {
//
//            sut = new NinteichosaItakusakiJoho(NinteichosaItakusakiJohoEntity);
//
//            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
//            assertThat(sut.identifier().get認定調査委託先コード(), is(認定調査委託先コード));
//        }
//    }
//
//    public static class getterテスト extends DbzTestBase {
//
//        private static NinteichosaItakusakiJoho sut;
//
//        @BeforeClass
//        public static void setUpClass() {
//            NinteichosaItakusakiJohoEntity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
//
//            sut = new NinteichosaItakusakiJoho(NinteichosaItakusakiJohoEntity);
//        }
//
//        @Test
//        public void get市町村コードは_entityが持つ市町村コードを返す() {
//            assertThat(sut.get市町村コード(), is(NinteichosaItakusakiJohoEntity.getShichosonCode()));
//        }
//
//        @Test
//        public void get認定調査委託先コードは_entityが持つ認定調査委託先コードを返す() {
//            assertThat(sut.get認定調査委託先コード(), is(NinteichosaItakusakiJohoEntity.getNinteichosaItakusakiCode()));
//        }
//
//        @Test
//        public void get事業者番号は_entityが持つ事業者番号を返す() {
//            assertThat(sut.get事業者番号(), is(NinteichosaItakusakiJohoEntity.getJigyoshaNo()));
//        }
//
//        @Test
//        public void get事業者名称は_entityが持つ事業者名称を返す() {
//            assertThat(sut.get事業者名称(), is(NinteichosaItakusakiJohoEntity.getJigyoshaMeisho()));
//        }
//
//        @Test
//        public void get事業者名称カナは_entityが持つ事業者名称カナを返す() {
//            assertThat(sut.get事業者名称カナ(), is(NinteichosaItakusakiJohoEntity.getJigyoshaMeishoKana()));
//        }
//
//        @Test
//        public void get郵便番号は_entityが持つ郵便番号を返す() {
//            assertThat(sut.get郵便番号(), is(NinteichosaItakusakiJohoEntity.getYubinNo()));
//        }
//
//        @Test
//        public void get住所は_entityが持つ住所を返す() {
//            assertThat(sut.get住所(), is(NinteichosaItakusakiJohoEntity.getJusho()));
//        }
//
//        @Test
//        public void get電話番号は_entityが持つ電話番号を返す() {
//            assertThat(sut.get電話番号(), is(NinteichosaItakusakiJohoEntity.getTelNo()));
//        }
//
//        @Test
//        public void getFAX番号は_entityが持つFAX番号を返す() {
//            assertThat(sut.getFAX番号(), is(NinteichosaItakusakiJohoEntity.getFaxNo()));
//        }
//
//        @Test
//        public void get代表者名は_entityが持つ代表者名を返す() {
//            assertThat(sut.get代表者名(), is(NinteichosaItakusakiJohoEntity.getDaihyoshaName()));
//        }
//
//        @Test
//        public void get調査委託区分は_entityが持つ調査委託区分を返す() {
//            assertThat(sut.get調査委託区分(), is(NinteichosaItakusakiJohoEntity.getChosaItakuKubun()));
//        }
//
//        @Test
//        public void get割付定員は_entityが持つ割付定員を返す() {
//            assertThat(sut.get割付定員(), is(NinteichosaItakusakiJohoEntity.getWaritsukeTeiin()));
//        }
//
//        @Test
//        public void get割付地区は_entityが持つ割付地区を返す() {
//            assertThat(sut.get割付地区(), is(NinteichosaItakusakiJohoEntity.getWaritsukeChiku()));
//        }
//
//        @Test
//        public void is自動割付フラグは_entityが持つ自動割付フラグを返す() {
//            assertThat(sut.is自動割付フラグ(), is(NinteichosaItakusakiJohoEntity.getAutoWaritsukeFlag()));
//        }
//
//        @Test
//        public void get機関の区分は_entityが持つ機関の区分を返す() {
//            assertThat(sut.get機関の区分(), is(NinteichosaItakusakiJohoEntity.getKikanKubun()));
//        }
//
//        @Test
//        public void is状況フラグは_entityが持つ状況フラグを返す() {
//            assertThat(sut.is状況フラグ(), is(NinteichosaItakusakiJohoEntity.getJokyoFlag()));
//        }
//    }
//
//    public static class toEntityテスト extends DbzTestBase {
//
//        private static NinteichosaItakusakiJoho sut;
//
//        @BeforeClass
//        public static void setUpClass() {
//            NinteichosaItakusakiJohoEntity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
//
//            sut = new NinteichosaItakusakiJoho(NinteichosaItakusakiJohoEntity);
//        }
//
//        @Test
//        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
//            assertThat(sut.toEntity(), not(NinteichosaItakusakiJohoEntity));
//        }
//    }
//
//    public static class SerializationProxyテスト extends DbzTestBase {
//
//        private static NinteichosaItakusakiJoho sut;
//
//        @BeforeClass
//        public static void setUpClass() {
//            NinteichosaItakusakiJohoEntity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
//
//            sut = new NinteichosaItakusakiJoho(NinteichosaItakusakiJohoEntity);
//        }
//
//        @Test
//        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
//        }
//    }
//
//    public static class deletedテスト extends DbzTestBase {
//
//        private static NinteichosaItakusakiJoho sut;
//        private static NinteichosaItakusakiJoho result;
//
//        @BeforeClass
//        public static void setUpClass() {
//            NinteichosaItakusakiJohoEntity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
//
//        }
//
//        @Test
//        public void NinteichosaItakusakiJohoが保持するDbT5910NinteichosaItakusakiJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteichosaItakusakiJohoが保持するDbT5910NinteichosaItakusakiJohoEntityのEntityDataStateがDeletedに指定されたNinteichosaItakusakiJohoが返る() {
//            sut = TestSupport.setStateNinteichosaItakusakiJoho(EntityDataState.Unchanged);
//            result = sut.deleted();
//            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
//        }
//
//        @Test
//        public void NinteichosaItakusakiJohoが保持するDbT5910NinteichosaItakusakiJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteichosaItakusakiJohoが保持するDbT5910NinteichosaItakusakiJohoEntityのEntityDataStateがDeletedに指定されたNinteichosaItakusakiJohoが返る() {
//            sut = TestSupport.setStateNinteichosaItakusakiJoho(EntityDataState.Modified);
//            result = sut.deleted();
//            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
//        }
//
//        @Test
//        public void NinteichosaItakusakiJohoが保持するDbT5910NinteichosaItakusakiJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteichosaItakusakiJohoが保持するDbT5910NinteichosaItakusakiJohoEntityのEntityDataStateがDeletedに指定されたNinteichosaItakusakiJohoが返る() {
//            sut = TestSupport.setStateNinteichosaItakusakiJoho(EntityDataState.Deleted);
//            result = sut.deleted();
//            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
//        }
//
//        @Test(expected = IllegalStateException.class)
//        public void NinteichosaItakusakiJohoが保持するDbT5910NinteichosaItakusakiJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
//            sut = TestSupport.setStateNinteichosaItakusakiJoho(EntityDataState.Added);
//            result = sut.deleted();
//        }
//    }
//
//    private static class TestSupport {
//
//        public static NinteichosaItakusakiJoho setStateNinteichosaItakusakiJoho(EntityDataState parentState) {
//            NinteichosaItakusakiJohoEntity.setState(parentState);
//            return new NinteichosaItakusakiJoho(NinteichosaItakusakiJohoEntity);
//        }
//    }
}
