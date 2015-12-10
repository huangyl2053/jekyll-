///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbz.business.core.basic;
//
//import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
//import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
//import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator;
//import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
//import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.experimental.runners.Enclosed;
//import org.junit.runner.RunWith;
//
///**
// * {@link NinteichosaItakusakiJohoBuilder}のテストクラスです。
// */
//@Ignore
//@RunWith(Enclosed.class)
//public class NinteichosaItakusakiJohoBuilderTest extends DbzTestBase {
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
//    public static class getterSetterTest extends DbzTestBase {
//
//        private static NinteichosaItakusakiJohoBuilder sut;
//        private static NinteichosaItakusakiJoho business;
//
//        @Before
//        public void setUp() {
//            NinteichosaItakusakiJohoEntity = new DbT5910NinteichosaItakusakiJohoEntity();
//
//            business = new NinteichosaItakusakiJoho(NinteichosaItakusakiJohoEntity);
//
//            sut = business.createBuilderForEdit();
//        }
////TODO Key項目のテストメソッドは削除して下さい。
//
//        @Test
//        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
//            business = sut.set市町村コード(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード).build();
//            assertThat(business.get市町村コード(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード));
//        }
//
//        @Test
//        public void 戻り値の認定調査委託先コードは_設定した値と同じ認定調査委託先コードを返す() {
//            business = sut.set認定調査委託先コード(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_認定調査委託先コード).build();
//            assertThat(business.get認定調査委託先コード(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_認定調査委託先コード));
//        }
//
//        @Test
//        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
//            business = sut.set事業者番号(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_事業者番号).build();
//            assertThat(business.get事業者番号(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_事業者番号));
//        }
//
//        @Test
//        public void 戻り値の事業者名称は_設定した値と同じ事業者名称を返す() {
//            business = sut.set事業者名称(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_事業者名称).build();
//            assertThat(business.get事業者名称(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_事業者名称));
//        }
//
//        @Test
//        public void 戻り値の事業者名称カナは_設定した値と同じ事業者名称カナを返す() {
//            business = sut.set事業者名称カナ(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_事業者名称カナ).build();
//            assertThat(business.get事業者名称カナ(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_事業者名称カナ));
//        }
//
//        @Test
//        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
//            business = sut.set郵便番号(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_郵便番号).build();
//            assertThat(business.get郵便番号(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_郵便番号));
//        }
//
//        @Test
//        public void 戻り値の住所は_設定した値と同じ住所を返す() {
//            business = sut.set住所(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_住所).build();
//            assertThat(business.get住所(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_住所));
//        }
//
//        @Test
//        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
//            business = sut.set電話番号(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_電話番号).build();
//            assertThat(business.get電話番号(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_電話番号));
//        }
//
//        @Test
//        public void 戻り値のFAX番号は_設定した値と同じFAX番号を返す() {
//            business = sut.setFax番号(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_FAX番号).build();
//            assertThat(business.getFAX番号(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_FAX番号));
//        }
//
//        @Test
//        public void 戻り値の代表者名は_設定した値と同じ代表者名を返す() {
//            business = sut.set代表者名(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_代表者名).build();
//            assertThat(business.get代表者名(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_代表者名));
//        }
//
//        @Test
//        public void 戻り値の調査委託区分は_設定した値と同じ調査委託区分を返す() {
//            business = sut.set調査委託区分(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_調査委託区分).build();
//            assertThat(business.get調査委託区分(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_調査委託区分));
//        }
//
//        @Test
//        public void 戻り値の割付定員は_設定した値と同じ割付定員を返す() {
//            business = sut.set割付定員(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_割付定員).build();
//            assertThat(business.get割付定員(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_割付定員));
//        }
//
//        @Test
//        public void 戻り値の割付地区は_設定した値と同じ割付地区を返す() {
//            business = sut.set割付地区(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_割付地区).build();
//            assertThat(business.get割付地区(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_割付地区));
//        }
//
//        @Test
//        public void 戻り値の自動割付フラグは_設定した値と同じ自動割付フラグを返す() {
//            business = sut.set自動割付フラグ(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_自動割付フラグ).build();
//            assertThat(business.is自動割付フラグ(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_自動割付フラグ));
//        }
//
//        @Test
//        public void 戻り値の機関の区分は_設定した値と同じ機関の区分を返す() {
//            business = sut.set機関の区分(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_機関の区分).build();
//            assertThat(business.get機関の区分(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_機関の区分));
//        }
//
//        @Test
//        public void 戻り値の状況フラグは_設定した値と同じ状況フラグを返す() {
//            business = sut.set状況フラグ(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_状況フラグ).build();
//            assertThat(business.is状況フラグ(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_状況フラグ));
//        }
//
//    }
//}
