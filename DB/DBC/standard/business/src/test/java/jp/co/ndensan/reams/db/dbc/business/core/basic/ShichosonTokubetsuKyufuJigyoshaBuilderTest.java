/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShichosonTokubetsuKyufuJigyoshaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShichosonTokubetsuKyufuJigyoshaBuilderTest extends DbcTestBase {

    private static DbT3065ShichosonTokubetsuKyufuJigyoshaEntity ShichosonTokubetsuKyufuJigyoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static JigyoshaNo 主キー名1;
    private static ServiceCode 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用事業者番号;
        主キー名2 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用サービスコード;
        主キー名3 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShichosonTokubetsuKyufuJigyoshaBuilder sut;
        private static ShichosonTokubetsuKyufuJigyosha business;

        @Before
        public void setUp() {
            ShichosonTokubetsuKyufuJigyoshaEntity = new DbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            ShichosonTokubetsuKyufuJigyoshaEntity.setJigyoshaNo(主キー名1);
            ShichosonTokubetsuKyufuJigyoshaEntity.setServiceCode(主キー名2);

            business = new ShichosonTokubetsuKyufuJigyosha(ShichosonTokubetsuKyufuJigyoshaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の市町村特別給付用事業者番号は_設定した値と同じ市町村特別給付用事業者番号を返す() {
            business = sut.set市町村特別給付用事業者番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用事業者番号).build();
            assertThat(business.get市町村特別給付用事業者番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用事業者番号));
        }

        @Test
        public void 戻り値の市町村特別給付用サービスコードは_設定した値と同じ市町村特別給付用サービスコードを返す() {
            business = sut.set市町村特別給付用サービスコード(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用サービスコード).build();
            assertThat(business.get市町村特別給付用サービスコード(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用サービスコード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の介護国保連ＩＦ異動区分は_設定した値と同じ介護国保連ＩＦ異動区分を返す() {
            business = sut.set介護国保連ＩＦ異動区分(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ異動区分).build();
            assertThat(business.get介護国保連ＩＦ異動区分(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ異動区分));
        }

        @Test
        public void 戻り値の介護国保連ＩＦ異動年月日は_設定した値と同じ介護国保連ＩＦ異動年月日を返す() {
            business = sut.set介護国保連ＩＦ異動年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ異動年月日).build();
            assertThat(business.get介護国保連ＩＦ異動年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ異動年月日));
        }

        @Test
        public void 戻り値の介護国保連ＩＦ法人種別は_設定した値と同じ介護国保連ＩＦ法人種別を返す() {
            business = sut.set介護国保連ＩＦ法人種別(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ法人種別).build();
            assertThat(business.get介護国保連ＩＦ法人種別(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_介護国保連ＩＦ法人種別));
        }

        @Test
        public void 戻り値の申請者氏名_漢字は_設定した値と同じ申請者氏名_漢字を返す() {
            business = sut.set申請者氏名_漢字(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者氏名_漢字).build();
            assertThat(business.get申請者氏名_漢字(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者氏名_漢字));
        }

        @Test
        public void 戻り値の申請者氏名_カナは_設定した値と同じ申請者氏名_カナを返す() {
            business = sut.set申請者氏名_カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者氏名_カナ).build();
            assertThat(business.get申請者氏名_カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者氏名_カナ));
        }

        @Test
        public void 戻り値の申請者郵便番号は_設定した値と同じ申請者郵便番号を返す() {
            business = sut.set申請者郵便番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者郵便番号).build();
            assertThat(business.get申請者郵便番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者郵便番号));
        }

        @Test
        public void 戻り値の申請者住所は_設定した値と同じ申請者住所を返す() {
            business = sut.set申請者住所(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者住所).build();
            assertThat(business.get申請者住所(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者住所));
        }

        @Test
        public void 戻り値の申請者住所_カナは_設定した値と同じ申請者住所_カナを返す() {
            business = sut.set申請者住所_カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者住所_カナ).build();
            assertThat(business.get申請者住所_カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者住所_カナ));
        }

        @Test
        public void 戻り値の申請者電話番号は_設定した値と同じ申請者電話番号を返す() {
            business = sut.set申請者電話番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者電話番号).build();
            assertThat(business.get申請者電話番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者電話番号));
        }

        @Test
        public void 戻り値の申請者FAX番号は_設定した値と同じ申請者FAX番号を返す() {
            business = sut.set申請者FAX番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者FAX番号).build();
            assertThat(business.get申請者FAX番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_申請者FAX番号));
        }

        @Test
        public void 戻り値の事業所代表者役職は_設定した値と同じ事業所代表者役職を返す() {
            business = sut.set事業所代表者役職(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者役職).build();
            assertThat(business.get事業所代表者役職(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者役職));
        }

        @Test
        public void 戻り値の事業所代表者氏名は_設定した値と同じ事業所代表者氏名を返す() {
            business = sut.set事業所代表者氏名(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者氏名).build();
            assertThat(business.get事業所代表者氏名(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者氏名));
        }

        @Test
        public void 戻り値の事業所代表者氏名カナは_設定した値と同じ事業所代表者氏名カナを返す() {
            business = sut.set事業所代表者氏名カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者氏名カナ).build();
            assertThat(business.get事業所代表者氏名カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者氏名カナ));
        }

        @Test
        public void 戻り値の事業所代表者郵便番号は_設定した値と同じ事業所代表者郵便番号を返す() {
            business = sut.set事業所代表者郵便番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者郵便番号).build();
            assertThat(business.get事業所代表者郵便番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者郵便番号));
        }

        @Test
        public void 戻り値の事業所代表者住所は_設定した値と同じ事業所代表者住所を返す() {
            business = sut.set事業所代表者住所(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者住所).build();
            assertThat(business.get事業所代表者住所(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者住所));
        }

        @Test
        public void 戻り値の事業所代表者住所カナは_設定した値と同じ事業所代表者住所カナを返す() {
            business = sut.set事業所代表者住所カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者住所カナ).build();
            assertThat(business.get事業所代表者住所カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所代表者住所カナ));
        }

        @Test
        public void 戻り値の事業所管理者氏名は_設定した値と同じ事業所管理者氏名を返す() {
            business = sut.set事業所管理者氏名(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者氏名).build();
            assertThat(business.get事業所管理者氏名(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者氏名));
        }

        @Test
        public void 戻り値の事業所管理者氏名カナは_設定した値と同じ事業所管理者氏名カナを返す() {
            business = sut.set事業所管理者氏名カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者氏名カナ).build();
            assertThat(business.get事業所管理者氏名カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者氏名カナ));
        }

        @Test
        public void 戻り値の事業所管理者郵便番号は_設定した値と同じ事業所管理者郵便番号を返す() {
            business = sut.set事業所管理者郵便番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者郵便番号).build();
            assertThat(business.get事業所管理者郵便番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者郵便番号));
        }

        @Test
        public void 戻り値の事業所管理者住所は_設定した値と同じ事業所管理者住所を返す() {
            business = sut.set事業所管理者住所(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者住所).build();
            assertThat(business.get事業所管理者住所(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者住所));
        }

        @Test
        public void 戻り値の事業所管理者住所カナは_設定した値と同じ事業所管理者住所カナを返す() {
            business = sut.set事業所管理者住所カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者住所カナ).build();
            assertThat(business.get事業所管理者住所カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_事業所管理者住所カナ));
        }

        @Test
        public void 戻り値のサービス事業所名は_設定した値と同じサービス事業所名を返す() {
            business = sut.setサービス事業所名(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所名).build();
            assertThat(business.getサービス事業所名(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所名));
        }

        @Test
        public void 戻り値のサービス事業所名カナは_設定した値と同じサービス事業所名カナを返す() {
            business = sut.setサービス事業所名カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所名カナ).build();
            assertThat(business.getサービス事業所名カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所名カナ));
        }

        @Test
        public void 戻り値のサービス事業所郵便番号は_設定した値と同じサービス事業所郵便番号を返す() {
            business = sut.setサービス事業所郵便番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所郵便番号).build();
            assertThat(business.getサービス事業所郵便番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所郵便番号));
        }

        @Test
        public void 戻り値のサービス事業所住所は_設定した値と同じサービス事業所住所を返す() {
            business = sut.setサービス事業所住所(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所住所).build();
            assertThat(business.getサービス事業所住所(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所住所));
        }

        @Test
        public void 戻り値のサービス事業所住所カナは_設定した値と同じサービス事業所住所カナを返す() {
            business = sut.setサービス事業所住所カナ(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所住所カナ).build();
            assertThat(business.getサービス事業所住所カナ(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所住所カナ));
        }

        @Test
        public void 戻り値のサービス事業所電話番号は_設定した値と同じサービス事業所電話番号を返す() {
            business = sut.setサービス事業所電話番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所電話番号).build();
            assertThat(business.getサービス事業所電話番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所電話番号));
        }

        @Test
        public void 戻り値のサービス事業所FAX番号は_設定した値と同じサービス事業所FAX番号を返す() {
            business = sut.setサービス事業所FAX番号(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所FAX番号).build();
            assertThat(business.getサービス事業所FAX番号(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所FAX番号));
        }

        @Test
        public void 戻り値のサービス事業所事業開始年月日は_設定した値と同じサービス事業所事業開始年月日を返す() {
            business = sut.setサービス事業所事業開始年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業開始年月日).build();
            assertThat(business.getサービス事業所事業開始年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業開始年月日));
        }

        @Test
        public void 戻り値のサービス事業所事業休止年月日は_設定した値と同じサービス事業所事業休止年月日を返す() {
            business = sut.setサービス事業所事業休止年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業休止年月日).build();
            assertThat(business.getサービス事業所事業休止年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業休止年月日));
        }

        @Test
        public void 戻り値のサービス事業所事業廃止年月日は_設定した値と同じサービス事業所事業廃止年月日を返す() {
            business = sut.setサービス事業所事業廃止年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業廃止年月日).build();
            assertThat(business.getサービス事業所事業廃止年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業廃止年月日));
        }

        @Test
        public void 戻り値のサービス事業所事業再開年月日は_設定した値と同じサービス事業所事業再開年月日を返す() {
            business = sut.setサービス事業所事業再開年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業再開年月日).build();
            assertThat(business.getサービス事業所事業再開年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_サービス事業所事業再開年月日));
        }

        @Test
        public void 戻り値の受領委任区分は_設定した値と同じ受領委任区分を返す() {
            business = sut.set受領委任区分(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_受領委任区分).build();
            assertThat(business.get受領委任区分(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_受領委任区分));
        }

        @Test
        public void 戻り値の市町村特別給付登録開始年月日は_設定した値と同じ市町村特別給付登録開始年月日を返す() {
            business = sut.set市町村特別給付登録開始年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付登録開始年月日).build();
            assertThat(business.get市町村特別給付登録開始年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付登録開始年月日));
        }

        @Test
        public void 戻り値の市町村特別給付登録終了年月日は_設定した値と同じ市町村特別給付登録終了年月日を返す() {
            business = sut.set市町村特別給付登録終了年月日(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付登録終了年月日).build();
            assertThat(business.get市町村特別給付登録終了年月日(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付登録終了年月日));
        }

        @Test
        public void 戻り値の生活保護法による指定の有は_設定した値と同じ生活保護法による指定の有を返す() {
            business = sut.set生活保護法による指定の有(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_生活保護法による指定の有).build();
            assertThat(business.is生活保護法による指定の有(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_生活保護法による指定の有));
        }

    }
}
