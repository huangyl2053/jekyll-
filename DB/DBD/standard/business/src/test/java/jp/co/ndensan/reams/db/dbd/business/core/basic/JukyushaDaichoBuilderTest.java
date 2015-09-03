/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT4001JukyushaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JukyushaDaichoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JukyushaDaichoBuilderTest extends DbdTestBase {

    private static DbT4001JukyushaDaichoEntity JukyushaDaichoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 主キー名1;
    private static HihokenshaNo 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード;
        主キー名2 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号;
    }

    public static class getterSetterTest extends DbdTestBase {

        private static JukyushaDaichoBuilder sut;
        private static JukyushaDaicho business;

        @Before
        public void setUp() {
            JukyushaDaichoEntity = new DbT4001JukyushaDaichoEntity();
            JukyushaDaichoEntity.setShichosonCode(主キー名1);
            JukyushaDaichoEntity.setHihokenshaNo(主キー名2);

            business = new JukyushaDaicho(JukyushaDaichoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の枝番は_設定した値と同じ枝番を返す() {
            business = sut.set枝番(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_枝番).build();
            assertThat(business.get枝番(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_枝番));
        }

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の申請状況区分は_設定した値と同じ申請状況区分を返す() {
            business = sut.set申請状況区分(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請状況区分).build();
            assertThat(business.get申請状況区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請状況区分));
        }

        @Test
        public void 戻り値の支所コードは_設定した値と同じ支所コードを返す() {
            business = sut.set支所コード(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支所コード).build();
            assertThat(business.get支所コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支所コード));
        }

        @Test
        public void 戻り値の直近フラグは_設定した値と同じ直近フラグを返す() {
            business = sut.set直近フラグ(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近フラグ).build();
            assertThat(business.get直近フラグ(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近フラグ));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の受給申請事由は_設定した値と同じ受給申請事由を返す() {
            business = sut.set受給申請事由(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請事由).build();
            assertThat(business.get受給申請事由(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請事由));
        }

        @Test
        public void 戻り値の申請理由は_設定した値と同じ申請理由を返す() {
            business = sut.set申請理由(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請理由).build();
            assertThat(business.get申請理由(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請理由));
        }

        @Test
        public void 戻り値の届出者_申請者関係コードは_設定した値と同じ届出者_申請者関係コードを返す() {
            business = sut.set届出者_申請者関係コード(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_届出者_申請者関係コード).build();
            assertThat(business.get届出者_申請者関係コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_届出者_申請者関係コード
            ));
        }

        @Test
        public void 戻り値の_届出者_本人との関係は_設定した値と同じ_届出者_本人との関係を返す() {
            business = sut.set届出者_本人との関係(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_届出者_本人との関係).build();
            assertThat(business.get届出者_本人との関係(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_届出者_本人との関係));
        }

        @Test
        public void 戻り値の受給申請年月日は_設定した値と同じ受給申請年月日を返す() {
            business = sut.set受給申請年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請年月日).build();
            assertThat(business.get受給申請年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請年月日));
        }

        @Test
        public void 戻り値の２号特定疾病コードは_設定した値と同じ２号特定疾病コードを返す() {
            business = sut.set２号特定疾病コード(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_２号特定疾病コード).build();
            assertThat(business.get２号特定疾病コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_２号特定疾病コード));
        }

        @Test
        public void 戻り値の審査会依頼年月日は_設定した値と同じ審査会依頼年月日を返す() {
            business = sut.set審査会依頼年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_審査会依頼年月日).build();
            assertThat(business.get審査会依頼年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_審査会依頼年月日));
        }

        @Test
        public void 戻り値の要介護認定状態区分コードは_設定した値と同じ要介護認定状態区分コードを返す() {
            business = sut.set要介護認定状態区分コード(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_要介護認定状態区分コード).build();
            assertThat(business.get要介護認定状態区分コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_要介護認定状態区分コード));
        }

        @Test
        public void 戻り値の認定有効期間開始年月日は_設定した値と同じ認定有効期間開始年月日を返す() {
            business = sut.set認定有効期間開始年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定有効期間開始年月日).build();
            assertThat(business.get認定有効期間開始年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定有効期間開始年月日));
        }

        @Test
        public void 戻り値の認定有効期間終了年月日は_設定した値と同じ認定有効期間終了年月日を返す() {
            business = sut.set認定有効期間終了年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定有効期間終了年月日).build();
            assertThat(business.get認定有効期間終了年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定有効期間終了年月日));
        }

        @Test
        public void 戻り値の認定年月日は_設定した値と同じ認定年月日を返す() {
            business = sut.set認定年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定年月日).build();
            assertThat(business.get認定年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定年月日));
        }

        @Test
        public void 戻り値のみなし要介護区分コードは_設定した値と同じみなし要介護区分コードを返す() {
            business = sut.setみなし要介護区分コード(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_みなし要介護区分コード).build();
            assertThat(business.getみなし要介護区分コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_みなし要介護区分コード));
        }

        @Test
        public void 戻り値の指定サービス種類01は_設定した値と同じ指定サービス種類01を返す() {
            business = sut.set指定サービス種類01(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類01).build();
            assertThat(business.get指定サービス種類01(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類01));
        }

        @Test
        public void 戻り値の指定サービス種類02は_設定した値と同じ指定サービス種類02を返す() {
            business = sut.set指定サービス種類02(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類02).build();
            assertThat(business.get指定サービス種類02(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類02));
        }

        @Test
        public void 戻り値の指定サービス種類03は_設定した値と同じ指定サービス種類03を返す() {
            business = sut.set指定サービス種類03(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類03).build();
            assertThat(business.get指定サービス種類03(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類03));
        }

        @Test
        public void 戻り値の指定サービス種類04は_設定した値と同じ指定サービス種類04を返す() {
            business = sut.set指定サービス種類04(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類04).build();
            assertThat(business.get指定サービス種類04(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類04));
        }

        @Test
        public void 戻り値の指定サービス種類05は_設定した値と同じ指定サービス種類05を返す() {
            business = sut.set指定サービス種類05(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類05).build();
            assertThat(business.get指定サービス種類05(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類05));
        }

        @Test
        public void 戻り値の指定サービス種類06は_設定した値と同じ指定サービス種類06を返す() {
            business = sut.set指定サービス種類06(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類06).build();
            assertThat(business.get指定サービス種類06(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類06));
        }

        @Test
        public void 戻り値の指定サービス種類07は_設定した値と同じ指定サービス種類07を返す() {
            business = sut.set指定サービス種類07(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類07).build();
            assertThat(business.get指定サービス種類07(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類07));
        }

        @Test
        public void 戻り値の指定サービス種類08は_設定した値と同じ指定サービス種類08を返す() {
            business = sut.set指定サービス種類08(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類08).build();
            assertThat(business.get指定サービス種類08(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類08));
        }

        @Test
        public void 戻り値の指定サービス種類09は_設定した値と同じ指定サービス種類09を返す() {
            business = sut.set指定サービス種類09(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類09).build();
            assertThat(business.get指定サービス種類09(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類09));
        }

        @Test
        public void 戻り値の指定サービス種類10は_設定した値と同じ指定サービス種類10を返す() {
            business = sut.set指定サービス種類10(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類10).build();
            assertThat(business.get指定サービス種類10(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類10));
        }

        @Test
        public void 戻り値の指定サービス種類11は_設定した値と同じ指定サービス種類11を返す() {
            business = sut.set指定サービス種類11(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類11).build();
            assertThat(business.get指定サービス種類11(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類11));
        }

        @Test
        public void 戻り値の指定サービス種類12は_設定した値と同じ指定サービス種類12を返す() {
            business = sut.set指定サービス種類12(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類12).build();
            assertThat(business.get指定サービス種類12(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類12));
        }

        @Test
        public void 戻り値の指定サービス種類13は_設定した値と同じ指定サービス種類13を返す() {
            business = sut.set指定サービス種類13(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類13).build();
            assertThat(business.get指定サービス種類13(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類13));
        }

        @Test
        public void 戻り値の指定サービス種類14は_設定した値と同じ指定サービス種類14を返す() {
            business = sut.set指定サービス種類14(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類14).build();
            assertThat(business.get指定サービス種類14(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類14));
        }

        @Test
        public void 戻り値の指定サービス種類15は_設定した値と同じ指定サービス種類15を返す() {
            business = sut.set指定サービス種類15(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類15).build();
            assertThat(business.get指定サービス種類15(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類15));
        }

        @Test
        public void 戻り値の指定サービス種類16は_設定した値と同じ指定サービス種類16を返す() {
            business = sut.set指定サービス種類16(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類16).build();
            assertThat(business.get指定サービス種類16(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類16));
        }

        @Test
        public void 戻り値の指定サービス種類17は_設定した値と同じ指定サービス種類17を返す() {
            business = sut.set指定サービス種類17(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類17).build();
            assertThat(business.get指定サービス種類17(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類17));
        }

        @Test
        public void 戻り値の指定サービス種類18は_設定した値と同じ指定サービス種類18を返す() {
            business = sut.set指定サービス種類18(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類18).build();
            assertThat(business.get指定サービス種類18(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類18));
        }

        @Test
        public void 戻り値の指定サービス種類19は_設定した値と同じ指定サービス種類19を返す() {
            business = sut.set指定サービス種類19(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類19).build();
            assertThat(business.get指定サービス種類19(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類19));
        }

        @Test
        public void 戻り値の指定サービス種類20は_設定した値と同じ指定サービス種類20を返す() {
            business = sut.set指定サービス種類20(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類20).build();
            assertThat(business.get指定サービス種類20(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類20));
        }

        @Test
        public void 戻り値の指定サービス種類21は_設定した値と同じ指定サービス種類21を返す() {
            business = sut.set指定サービス種類21(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類21).build();
            assertThat(business.get指定サービス種類21(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類21));
        }

        @Test
        public void 戻り値の指定サービス種類22は_設定した値と同じ指定サービス種類22を返す() {
            business = sut.set指定サービス種類22(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類22).build();
            assertThat(business.get指定サービス種類22(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類22));
        }

        @Test
        public void 戻り値の指定サービス種類23は_設定した値と同じ指定サービス種類23を返す() {
            business = sut.set指定サービス種類23(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類23).build();
            assertThat(business.get指定サービス種類23(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類23));
        }

        @Test
        public void 戻り値の指定サービス種類24は_設定した値と同じ指定サービス種類24を返す() {
            business = sut.set指定サービス種類24(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類24).build();
            assertThat(business.get指定サービス種類24(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類24));
        }

        @Test
        public void 戻り値の指定サービス種類25は_設定した値と同じ指定サービス種類25を返す() {
            business = sut.set指定サービス種類25(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類25).build();
            assertThat(business.get指定サービス種類25(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類25));
        }

        @Test
        public void 戻り値の指定サービス種類26は_設定した値と同じ指定サービス種類26を返す() {
            business = sut.set指定サービス種類26(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類26).build();
            assertThat(business.get指定サービス種類26(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類26));
        }

        @Test
        public void 戻り値の指定サービス種類27は_設定した値と同じ指定サービス種類27を返す() {
            business = sut.set指定サービス種類27(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類27).build();
            assertThat(business.get指定サービス種類27(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類27));
        }

        @Test
        public void 戻り値の指定サービス種類28は_設定した値と同じ指定サービス種類28を返す() {
            business = sut.set指定サービス種類28(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類28).build();
            assertThat(business.get指定サービス種類28(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類28));
        }

        @Test
        public void 戻り値の指定サービス種類29は_設定した値と同じ指定サービス種類29を返す() {
            business = sut.set指定サービス種類29(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類29).build();
            assertThat(business.get指定サービス種類29(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類29));
        }

        @Test
        public void 戻り値の指定サービス種類30は_設定した値と同じ指定サービス種類30を返す() {
            business = sut.set指定サービス種類30(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類30).build();
            assertThat(business.get指定サービス種類30(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類30));
        }

        @Test
        public void 戻り値の喪失年月日は_設定した値と同じ喪失年月日を返す() {
            business = sut.set喪失年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_喪失年月日).build();
            assertThat(business.get喪失年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_喪失年月日));
        }

        @Test
        public void 戻り値の直近異動年月日は_設定した値と同じ直近異動年月日を返す() {
            business = sut.set直近異動年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近異動年月日).build();
            assertThat(business.get直近異動年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近異動年月日));
        }

        @Test
        public void 戻り値の直近異動事由コードは_設定した値と同じ直近異動事由コードを返す() {
            business = sut.set直近異動事由コード(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近異動事由コード).build();
            assertThat(business.get直近異動事由コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近異動事由コード));
        }

        @Test
        public void 戻り値の有効無効区分は_設定した値と同じ有効無効区分を返す() {
            business = sut.set有効無効区分(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_有効無効区分).build();
            assertThat(business.get有効無効区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_有効無効区分));
        }

        @Test
        public void 戻り値のデータ区分は_設定した値と同じデータ区分を返す() {
            business = sut.setデータ区分(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_データ区分).build();
            assertThat(business.getデータ区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_データ区分));
        }

        @Test
        public void 戻り値の同一連番は_設定した値と同じ同一連番を返す() {
            business = sut.set同一連番(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_同一連番).build();
            assertThat(business.get同一連番(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_同一連番));
        }

        @Test
        public void 戻り値の異動理由は_設定した値と同じ異動理由を返す() {
            business = sut.set異動理由(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_異動理由).build();
            assertThat(business.get異動理由(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_異動理由));
        }

        @Test
        public void 戻り値の申請書区分は_設定した値と同じ申請書区分を返す() {
            business = sut.set申請書区分(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請書区分).build();
            assertThat(business.get申請書区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請書区分));
        }

        @Test
        public void 戻り値の削除事由コードは_設定した値と同じ削除事由コードを返す() {
            business = sut.set削除事由コード(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_削除事由コード).build();
            assertThat(business.get削除事由コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_削除事由コード));
        }

        @Test
        public void 戻り値の要支援者認定申請区分は_設定した値と同じ要支援者認定申請区分を返す() {
            business = sut.set要支援者認定申請区分(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_要支援者認定申請区分).build();
            assertThat(business.get要支援者認定申請区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_要支援者認定申請区分));
        }

        @Test
        public void 戻り値の支給限度単位数は_設定した値と同じ支給限度単位数を返す() {
            business = sut.set支給限度単位数(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度単位数).build();
            assertThat(business.get支給限度単位数(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度単位数));
        }

        @Test
        public void 戻り値の支給限度有効開始年月日は_設定した値と同じ支給限度有効開始年月日を返す() {
            business = sut.set支給限度有効開始年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度有効開始年月日).build();
            assertThat(business.get支給限度有効開始年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度有効開始年月日));
        }

        @Test
        public void 戻り値の支給限度有効終了年月日は_設定した値と同じ支給限度有効終了年月日を返す() {
            business = sut.set支給限度有効終了年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度有効終了年月日).build();
            assertThat(business.get支給限度有効終了年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度有効終了年月日));
        }

        @Test
        public void 戻り値の短期入所支給限度日数は_設定した値と同じ短期入所支給限度日数を返す() {
            business = sut.set短期入所支給限度日数(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度日数).build();
            assertThat(business.get短期入所支給限度日数(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度日数));
        }

        @Test
        public void 戻り値の短期入所支給限度開始年月日は_設定した値と同じ短期入所支給限度開始年月日を返す() {
            business = sut.set短期入所支給限度開始年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度開始年月日).build();
            assertThat(business.get短期入所支給限度開始年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度開始年月日));
        }

        @Test
        public void 戻り値の短期入所支給限度終了年月日は_設定した値と同じ短期入所支給限度終了年月日を返す() {
            business = sut.set短期入所支給限度終了年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度終了年月日).build();
            assertThat(business.get短期入所支給限度終了年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度終了年月日));
        }

        @Test
        public void 戻り値の当初認定有効開始年月日は_設定した値と同じ当初認定有効開始年月日を返す() {
            business = sut.set当初認定有効開始年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_当初認定有効開始年月日).build();
            assertThat(business.get当初認定有効開始年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_当初認定有効開始年月日));
        }

        @Test
        public void 戻り値の当初認定有効終了年月日は_設定した値と同じ当初認定有効終了年月日を返す() {
            business = sut.set当初認定有効終了年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_当初認定有効終了年月日).build();
            assertThat(business.get当初認定有効終了年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_当初認定有効終了年月日));
        }

        @Test
        public void 戻り値の受給資格証明書発行年月日１は_設定した値と同じ受給資格証明書発行年月日１を返す() {
            business = sut.set受給資格証明書発行年月日１(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給資格証明書発行年月日１).build();
            assertThat(business.get受給資格証明書発行年月日１(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給資格証明書発行年月日１));
        }

        @Test
        public void 戻り値の受給資格証明書発行年月日２は_設定した値と同じ受給資格証明書発行年月日２を返す() {
            business = sut.set受給資格証明書発行年月日２(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給資格証明書発行年月日２).build();
            assertThat(business.get受給資格証明書発行年月日２(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給資格証明書発行年月日２));
        }

        @Test
        public void 戻り値の診断命令書発行年月日は_設定した値と同じ診断命令書発行年月日を返す() {
            business = sut.set診断命令書発行年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_診断命令書発行年月日).build();
            assertThat(business.get診断命令書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_診断命令書発行年月日));
        }

        @Test
        public void 戻り値の２号申請受理通知書発行年月日は_設定した値と同じ２号申請受理通知書発行年月日を返す() {
            business = sut.set２号申請受理通知書発行年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_２号申請受理通知書発行年月日).build();
            assertThat(business.get２号申請受理通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_２号申請受理通知書発行年月日));
        }

        @Test
        public void 戻り値の認定結果通知書発行年月日は_設定した値と同じ認定結果通知書発行年月日を返す() {
            business = sut.set認定結果通知書発行年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定結果通知書発行年月日).build();
            assertThat(business.get認定結果通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定結果通知書発行年月日));
        }

        @Test
        public void 戻り値の区分変更通知書発行年月日は_設定した値と同じ区分変更通知書発行年月日を返す() {
            business = sut.set区分変更通知書発行年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_区分変更通知書発行年月日).build();
            assertThat(business.get区分変更通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_区分変更通知書発行年月日));
        }

        @Test
        public void 戻り値のサービス変更通知書発行年月日は_設定した値と同じサービス変更通知書発行年月日を返す() {
            business = sut.setサービス変更通知書発行年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_サービス変更通知書発行年月日).build();
            assertThat(business.getサービス変更通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_サービス変更通知書発行年月日));
        }

        @Test
        public void 戻り値の認定却下通知書発行年月日は_設定した値と同じ認定却下通知書発行年月日を返す() {
            business = sut.set認定却下通知書発行年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定却下通知書発行年月日).build();
            assertThat(business.get認定却下通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定却下通知書発行年月日));
        }

        @Test
        public void 戻り値の認定取消通知書発行年月日は_設定した値と同じ認定取消通知書発行年月日を返す() {
            business = sut.set認定取消通知書発行年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定取消通知書発行年月日).build();
            assertThat(business.get認定取消通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定取消通知書発行年月日));
        }

        @Test
        public void 戻り値の資格取得前申請フラグは_設定した値と同じ資格取得前申請フラグを返す() {
            business = sut.set資格取得前申請フラグ(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_資格取得前申請フラグ).build();
            assertThat(business.get資格取得前申請フラグ(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_資格取得前申請フラグ));
        }

        @Test
        public void 戻り値の旧措置者フラグは_設定した値と同じ旧措置者フラグを返す() {
            business = sut.set旧措置者フラグ(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_旧措置者フラグ).build();
            assertThat(business.get旧措置者フラグ(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_旧措置者フラグ));
        }

        @Test
        public void 戻り値の論理削除フラグは_設定した値と同じ論理削除フラグを返す() {
            business = sut.set論理削除フラグ(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_論理削除フラグ).build();
            assertThat(business.get論理削除フラグ(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_論理削除フラグ));
        }

    }
}
