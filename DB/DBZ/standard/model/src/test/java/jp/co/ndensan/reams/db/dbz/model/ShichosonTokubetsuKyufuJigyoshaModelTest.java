/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShichosonTokubetsuKyufuJigyoshaModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShichosonTokubetsuKyufuJigyoshaModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShichosonTokubetsuKyufuJigyoshaModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShichosonTokubetsuKyufuJigyoshaModel();
        }

        @Test
        public void 戻り値の市町村特別給付用事業者番号は_設定した値と同じ市町村特別給付用事業者番号を返す() {
            sut.set市町村特別給付用事業者番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用事業者番号);
            assertThat(sut.get市町村特別給付用事業者番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用事業者番号));
        }

        @Test
        public void 戻り値の市町村特別給付用サービスコードは_設定した値と同じ市町村特別給付用サービスコードを返す() {
            sut.set市町村特別給付用サービスコード(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用サービスコード);
            assertThat(sut.get市町村特別給付用サービスコード(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用サービスコード));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の介護国保連ＩＦ異動区分は_設定した値と同じ介護国保連ＩＦ異動区分を返す() {
            sut.set介護国保連ＩＦ異動区分(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ異動区分);
            assertThat(sut.get介護国保連ＩＦ異動区分(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ異動区分));
        }

        @Test
        public void 戻り値の介護国保連ＩＦ異動年月日は_設定した値と同じ介護国保連ＩＦ異動年月日を返す() {
            sut.set介護国保連ＩＦ異動年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ異動年月日);
            assertThat(sut.get介護国保連ＩＦ異動年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ異動年月日));
        }

        @Test
        public void 戻り値の介護国保連ＩＦ訂正区分は_設定した値と同じ介護国保連ＩＦ訂正区分を返す() {
            sut.set介護国保連ＩＦ訂正区分(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ訂正区分);
            assertThat(sut.get介護国保連ＩＦ訂正区分(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ訂正区分));
        }

        @Test
        public void 戻り値の介護国保連ＩＦ訂正年月日は_設定した値と同じ介護国保連ＩＦ訂正年月日を返す() {
            sut.set介護国保連ＩＦ訂正年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ訂正年月日);
            assertThat(sut.get介護国保連ＩＦ訂正年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ訂正年月日));
        }

        @Test
        public void 戻り値の介護国保連ＩＦ法人種別は_設定した値と同じ介護国保連ＩＦ法人種別を返す() {
            sut.set介護国保連ＩＦ法人種別(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ法人種別);
            assertThat(sut.get介護国保連ＩＦ法人種別(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ法人種別));
        }

        @Test
        public void 戻り値の申請者氏名_漢字は_設定した値と同じ申請者氏名_漢字を返す() {
            sut.set申請者氏名_漢字(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者氏名_漢字);
            assertThat(sut.get申請者氏名_漢字(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者氏名_漢字));
        }

        @Test
        public void 戻り値の申請者氏名_カナは_設定した値と同じ申請者氏名_カナを返す() {
            sut.set申請者氏名_カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者氏名_カナ);
            assertThat(sut.get申請者氏名_カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者氏名_カナ));
        }

        @Test
        public void 戻り値の申請者郵便番号は_設定した値と同じ申請者郵便番号を返す() {
            sut.set申請者郵便番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者郵便番号);
            assertThat(sut.get申請者郵便番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者郵便番号));
        }

        @Test
        public void 戻り値の申請者住所は_設定した値と同じ申請者住所を返す() {
            sut.set申請者住所(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者住所);
            assertThat(sut.get申請者住所(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者住所));
        }

        @Test
        public void 戻り値の申請者住所_カナは_設定した値と同じ申請者住所_カナを返す() {
            sut.set申請者住所_カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者住所_カナ);
            assertThat(sut.get申請者住所_カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者住所_カナ));
        }

        @Test
        public void 戻り値の申請者電話番号は_設定した値と同じ申請者電話番号を返す() {
            sut.set申請者電話番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者電話番号);
            assertThat(sut.get申請者電話番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者電話番号));
        }

        @Test
        public void 戻り値の申請者FAX番号は_設定した値と同じ申請者FAX番号を返す() {
            sut.set申請者FAX番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者FAX番号);
            assertThat(sut.get申請者FAX番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者FAX番号));
        }

        @Test
        public void 戻り値の事業所代表者役職は_設定した値と同じ事業所代表者役職を返す() {
            sut.set事業所代表者役職(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者役職);
            assertThat(sut.get事業所代表者役職(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者役職));
        }

        @Test
        public void 戻り値の事業所代表者氏名は_設定した値と同じ事業所代表者氏名を返す() {
            sut.set事業所代表者氏名(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者氏名);
            assertThat(sut.get事業所代表者氏名(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者氏名));
        }

        @Test
        public void 戻り値の事業所代表者氏名カナは_設定した値と同じ事業所代表者氏名カナを返す() {
            sut.set事業所代表者氏名カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者氏名カナ);
            assertThat(sut.get事業所代表者氏名カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者氏名カナ));
        }

        @Test
        public void 戻り値の事業所代表者郵便番号は_設定した値と同じ事業所代表者郵便番号を返す() {
            sut.set事業所代表者郵便番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者郵便番号);
            assertThat(sut.get事業所代表者郵便番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者郵便番号));
        }

        @Test
        public void 戻り値の事業所代表者住所は_設定した値と同じ事業所代表者住所を返す() {
            sut.set事業所代表者住所(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者住所);
            assertThat(sut.get事業所代表者住所(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者住所));
        }

        @Test
        public void 戻り値の事業所代表者住所カナは_設定した値と同じ事業所代表者住所カナを返す() {
            sut.set事業所代表者住所カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者住所カナ);
            assertThat(sut.get事業所代表者住所カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者住所カナ));
        }

        @Test
        public void 戻り値の事業所管理者氏名は_設定した値と同じ事業所管理者氏名を返す() {
            sut.set事業所管理者氏名(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者氏名);
            assertThat(sut.get事業所管理者氏名(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者氏名));
        }

        @Test
        public void 戻り値の事業所管理者氏名カナは_設定した値と同じ事業所管理者氏名カナを返す() {
            sut.set事業所管理者氏名カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者氏名カナ);
            assertThat(sut.get事業所管理者氏名カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者氏名カナ));
        }

        @Test
        public void 戻り値の事業所管理者郵便番号は_設定した値と同じ事業所管理者郵便番号を返す() {
            sut.set事業所管理者郵便番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者郵便番号);
            assertThat(sut.get事業所管理者郵便番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者郵便番号));
        }

        @Test
        public void 戻り値の事業所管理者住所は_設定した値と同じ事業所管理者住所を返す() {
            sut.set事業所管理者住所(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者住所);
            assertThat(sut.get事業所管理者住所(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者住所));
        }

        @Test
        public void 戻り値の事業所管理者住所カナは_設定した値と同じ事業所管理者住所カナを返す() {
            sut.set事業所管理者住所カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者住所カナ);
            assertThat(sut.get事業所管理者住所カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者住所カナ));
        }

        @Test
        public void 戻り値のサービス事業所名は_設定した値と同じサービス事業所名を返す() {
            sut.setサービス事業所名(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所名);
            assertThat(sut.getサービス事業所名(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所名));
        }

        @Test
        public void 戻り値のサービス事業所名カナは_設定した値と同じサービス事業所名カナを返す() {
            sut.setサービス事業所名カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所名カナ);
            assertThat(sut.getサービス事業所名カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所名カナ));
        }

        @Test
        public void 戻り値のサービス事業所郵便番号は_設定した値と同じサービス事業所郵便番号を返す() {
            sut.setサービス事業所郵便番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所郵便番号);
            assertThat(sut.getサービス事業所郵便番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所郵便番号));
        }

        @Test
        public void 戻り値のサービス事業所住所は_設定した値と同じサービス事業所住所を返す() {
            sut.setサービス事業所住所(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所住所);
            assertThat(sut.getサービス事業所住所(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所住所));
        }

        @Test
        public void 戻り値のサービス事業所住所カナは_設定した値と同じサービス事業所住所カナを返す() {
            sut.setサービス事業所住所カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所住所カナ);
            assertThat(sut.getサービス事業所住所カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所住所カナ));
        }

        @Test
        public void 戻り値のサービス事業所電話番号は_設定した値と同じサービス事業所電話番号を返す() {
            sut.setサービス事業所電話番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所電話番号);
            assertThat(sut.getサービス事業所電話番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所電話番号));
        }

        @Test
        public void 戻り値のサービス事業所FAX番号は_設定した値と同じサービス事業所FAX番号を返す() {
            sut.setサービス事業所FAX番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所FAX番号);
            assertThat(sut.getサービス事業所FAX番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所FAX番号));
        }

        @Test
        public void 戻り値のサービス事業所事業開始年月日は_設定した値と同じサービス事業所事業開始年月日を返す() {
            sut.setサービス事業所事業開始年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業開始年月日);
            assertThat(sut.getサービス事業所事業開始年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業開始年月日));
        }

        @Test
        public void 戻り値のサービス事業所事業休止年月日は_設定した値と同じサービス事業所事業休止年月日を返す() {
            sut.setサービス事業所事業休止年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業休止年月日);
            assertThat(sut.getサービス事業所事業休止年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業休止年月日));
        }

        @Test
        public void 戻り値のサービス事業所事業廃止年月日は_設定した値と同じサービス事業所事業廃止年月日を返す() {
            sut.setサービス事業所事業廃止年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業廃止年月日);
            assertThat(sut.getサービス事業所事業廃止年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業廃止年月日));
        }

        @Test
        public void 戻り値のサービス事業所事業再開年月日は_設定した値と同じサービス事業所事業再開年月日を返す() {
            sut.setサービス事業所事業再開年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業再開年月日);
            assertThat(sut.getサービス事業所事業再開年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業再開年月日));
        }

        @Test
        public void 戻り値の介護保険証記載保険者番号は_設定した値と同じ介護保険証記載保険者番号を返す() {
            sut.set介護保険証記載保険者番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護保険証記載保険者番号);
            assertThat(sut.get介護保険証記載保険者番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護保険証記載保険者番号));
        }

        @Test
        public void 戻り値の受領委任区分は_設定した値と同じ受領委任区分を返す() {
            sut.set受領委任区分(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_受領委任区分);
            assertThat(sut.get受領委任区分(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_受領委任区分));
        }

        @Test
        public void 戻り値の市町村特別給付登録開始年月日は_設定した値と同じ市町村特別給付登録開始年月日を返す() {
            sut.set市町村特別給付登録開始年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付登録開始年月日);
            assertThat(sut.get市町村特別給付登録開始年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付登録開始年月日));
        }

        @Test
        public void 戻り値の市町村特別給付登録終了年月日は_設定した値と同じ市町村特別給付登録終了年月日を返す() {
            sut.set市町村特別給付登録終了年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付登録終了年月日);
            assertThat(sut.get市町村特別給付登録終了年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付登録終了年月日));
        }

        @Test
        public void 戻り値の生活保護法による指定の有は_設定した値と同じ生活保護法による指定の有を返す() {
            sut.set生活保護法による指定の有(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_生活保護法による指定の有);
            assertThat(sut.get生活保護法による指定の有(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_生活保護法による指定の有));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の地域区分は_設定した値と同じ地域区分を返す() {
            sut.set地域区分(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_地域区分);
            assertThat(sut.get地域区分(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_地域区分));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShichosonTokubetsuKyufuJigyoshaModel sut = new ShichosonTokubetsuKyufuJigyoshaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShichosonTokubetsuKyufuJigyoshaModel sut = new ShichosonTokubetsuKyufuJigyoshaModel();
        //sut.setEntity(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShichosonTokubetsuKyufuJigyoshaModel sut = new ShichosonTokubetsuKyufuJigyoshaModel();
            sut.setEntity(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShichosonTokubetsuKyufuJigyoshaModel sut = new ShichosonTokubetsuKyufuJigyoshaModel();
            sut.setEntity(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
