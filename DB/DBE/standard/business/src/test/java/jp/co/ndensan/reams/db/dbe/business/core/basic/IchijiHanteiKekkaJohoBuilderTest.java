/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5116IchijiHanteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IchijiHanteiKekkaJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IchijiHanteiKekkaJohoBuilderTest extends DbeTestBase {

    private static DbT5116IchijiHanteiKekkaJohoEntity IchijiHanteiKekkaJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
//    private static 主キー型1 主キー名1;
//    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
//        主キー名1 = DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_主キー名1;
//        主キー名2 = DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends DbeTestBase {

        private static IchijiHanteiKekkaJohoBuilder sut;
        private static IchijiHanteiKekkaJoho business;

        @Before
        public void setUp() {
            IchijiHanteiKekkaJohoEntity = new DbT5116IchijiHanteiKekkaJohoEntity();

            business = new IchijiHanteiKekkaJoho(IchijiHanteiKekkaJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の要介護認定等基準時間は_設定した値と同じ要介護認定等基準時間を返す() {
            business = sut.set要介護認定等基準時間(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間).build();
            assertThat(business.get要介護認定等基準時間(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間));
        }

        @Test
        public void 戻り値の要介護認定等基準時間_食事は_設定した値と同じ要介護認定等基準時間_食事を返す() {
            business = sut.set要介護認定等基準時間_食事(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_食事).build();
            assertThat(business.get要介護認定等基準時間_食事(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_食事));
        }

        @Test
        public void 戻り値の要介護認定等基準時間_排泄は_設定した値と同じ要介護認定等基準時間_排泄を返す() {
            business = sut.set要介護認定等基準時間_排泄(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_排泄).build();
            assertThat(business.get要介護認定等基準時間_排泄(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_排泄));
        }

        @Test
        public void 戻り値の要介護認定等基準時間_移動は_設定した値と同じ要介護認定等基準時間_移動を返す() {
            business = sut.set要介護認定等基準時間_移動(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_移動).build();
            assertThat(business.get要介護認定等基準時間_移動(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_移動));
        }

        @Test
        public void 戻り値の要介護認定等基準時間_清潔保持は_設定した値と同じ要介護認定等基準時間_清潔保持を返す() {
            business = sut.set要介護認定等基準時間_清潔保持(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_清潔保持).build();
            assertThat(business.get要介護認定等基準時間_清潔保持(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_清潔保持));
        }

        @Test
        public void 戻り値の要介護認定等基準時間_間接ケアは_設定した値と同じ要介護認定等基準時間_間接ケアを返す() {
            business = sut.set要介護認定等基準時間_間接ケア(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_間接ケア).build();
            assertThat(business.get要介護認定等基準時間_間接ケア(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_間接ケア));
        }

        @Test
        public void 戻り値の要介護認定等基準時間_BPSD関連は_設定した値と同じ要介護認定等基準時間_BPSD関連を返す() {
            business = sut.set要介護認定等基準時間_BPSD関連(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_BPSD関連).build();
            assertThat(business.get要介護認定等基準時間_BPSD関連(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_BPSD関連));
        }

        @Test
        public void 戻り値の要介護認定等基準時間_機能訓練は_設定した値と同じ要介護認定等基準時間_機能訓練を返す() {
            business = sut.set要介護認定等基準時間_機能訓練(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_機能訓練).build();
            assertThat(business.get要介護認定等基準時間_機能訓練(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_機能訓練));
        }

        @Test
        public void 戻り値の要介護認定等基準時間_医療関連は_設定した値と同じ要介護認定等基準時間_医療関連を返す() {
            business = sut.set要介護認定等基準時間_医療関連(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_医療関連).build();
            assertThat(business.get要介護認定等基準時間_医療関連(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_医療関連));
        }

        @Test
        public void 戻り値の要介護認定等基準時間_認知症加算は_設定した値と同じ要介護認定等基準時間_認知症加算を返す() {
            business = sut.set要介護認定等基準時間_認知症加算(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_認知症加算).build();
            assertThat(business.get要介護認定等基準時間_認知症加算(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定等基準時間_認知症加算));
        }

        @Test
        public void 戻り値の中間評価項目得点第1群は_設定した値と同じ中間評価項目得点第1群を返す() {
            business = sut.set中間評価項目得点第1群(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_中間評価項目得点第1群).build();
            assertThat(business.get中間評価項目得点第1群(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_中間評価項目得点第1群));
        }

        @Test
        public void 戻り値の中間評価項目得点第2群は_設定した値と同じ中間評価項目得点第2群を返す() {
            business = sut.set中間評価項目得点第2群(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_中間評価項目得点第2群).build();
            assertThat(business.get中間評価項目得点第2群(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_中間評価項目得点第2群));
        }

        @Test
        public void 戻り値の中間評価項目得点第3群は_設定した値と同じ中間評価項目得点第3群を返す() {
            business = sut.set中間評価項目得点第3群(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_中間評価項目得点第3群).build();
            assertThat(business.get中間評価項目得点第3群(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_中間評価項目得点第3群));
        }

        @Test
        public void 戻り値の中間評価項目得点第4群は_設定した値と同じ中間評価項目得点第4群を返す() {
            business = sut.set中間評価項目得点第4群(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_中間評価項目得点第4群).build();
            assertThat(business.get中間評価項目得点第4群(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_中間評価項目得点第4群));
        }

        @Test
        public void 戻り値の中間評価項目得点第5群は_設定した値と同じ中間評価項目得点第5群を返す() {
            business = sut.set中間評価項目得点第5群(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_中間評価項目得点第5群).build();
            assertThat(business.get中間評価項目得点第5群(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_中間評価項目得点第5群));
        }

        @Test
        public void 戻り値の中間評価項目得点第6群は_設定した値と同じ中間評価項目得点第6群を返す() {
            business = sut.set中間評価項目得点第6群(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_中間評価項目得点第6群).build();
            assertThat(business.get中間評価項目得点第6群(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_中間評価項目得点第6群));
        }

        @Test
        public void 戻り値の中間評価項目得点第7群は_設定した値と同じ中間評価項目得点第7群を返す() {
            business = sut.set中間評価項目得点第7群(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_中間評価項目得点第7群).build();
            assertThat(business.get中間評価項目得点第7群(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_中間評価項目得点第7群));
        }

        @Test
        public void 戻り値の要介護認定一次判定警告コードは_設定した値と同じ要介護認定一次判定警告コードを返す() {
            business = sut.set要介護認定一次判定警告コード(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定一次判定警告コード).build();
            assertThat(business.get要介護認定一次判定警告コード(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定一次判定警告コード));
        }

        @Test
        public void 戻り値の要介護認定状態の安定性コードは_設定した値と同じ要介護認定状態の安定性コードを返す() {
            business = sut.set要介護認定状態の安定性コード(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定状態の安定性コード).build();
            assertThat(business.get要介護認定状態の安定性コード(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定状態の安定性コード));
        }

        @Test
        public void 戻り値の認知症自立度Ⅱ以上の蓋然性は_設定した値と同じ認知症自立度Ⅱ以上の蓋然性を返す() {
            business = sut.set認知症自立度Ⅱ以上の蓋然性(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_認知症自立度Ⅱ以上の蓋然性).build();
            assertThat(business.get認知症自立度Ⅱ以上の蓋然性(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_認知症自立度Ⅱ以上の蓋然性));
        }

        @Test
        public void 戻り値の認知機能及び状態安定性から推定される給付区分コードは_設定した値と同じ認知機能及び状態安定性から推定される給付区分コードを返す() {
            business = sut.set認知機能及び状態安定性から推定される給付区分コード(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_認知機能及び状態安定性から推定される給付区分コード).build();
            assertThat(business.get認知機能及び状態安定性から推定される給付区分コード(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_認知機能及び状態安定性から推定される給付区分コード));
        }

        @Test
        public void 戻り値の運動能力の低下していない認知症高齢者の指標コードは_設定した値と同じ運動能力の低下していない認知症高齢者の指標コードを返す() {
            business = sut.set運動能力の低下していない認知症高齢者の指標コード(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_運動能力の低下していない認知症高齢者の指標コード).build();
            assertThat(business.get運動能力の低下していない認知症高齢者の指標コード(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_運動能力の低下していない認知症高齢者の指標コード));
        }

        @Test
        public void 戻り値の日常生活自立度の組み合わせ_自立は_設定した値と同じ日常生活自立度の組み合わせ_自立を返す() {
            business = sut.set日常生活自立度の組み合わせ_自立(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_日常生活自立度の組み合わせ_自立).build();
            assertThat(business.get日常生活自立度の組み合わせ_自立(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_日常生活自立度の組み合わせ_自立));
        }

        @Test
        public void 戻り値の日常生活自立度の組み合わせ_要支援は_設定した値と同じ日常生活自立度の組み合わせ_要支援を返す() {
            business = sut.set日常生活自立度の組み合わせ_要支援(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_日常生活自立度の組み合わせ_要支援).build();
            assertThat(business.get日常生活自立度の組み合わせ_要支援(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_日常生活自立度の組み合わせ_要支援));
        }

        @Test
        public void 戻り値の日常生活自立度の組み合わせ_要介護１は_設定した値と同じ日常生活自立度の組み合わせ_要介護１を返す() {
            business = sut.set日常生活自立度の組み合わせ_要介護１(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_日常生活自立度の組み合わせ_要介護１).build();
            assertThat(business.get日常生活自立度の組み合わせ_要介護１(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_日常生活自立度の組み合わせ_要介護１));
        }

        @Test
        public void 戻り値の日常生活自立度の組み合わせ_要介護２は_設定した値と同じ日常生活自立度の組み合わせ_要介護２を返す() {
            business = sut.set日常生活自立度の組み合わせ_要介護２(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_日常生活自立度の組み合わせ_要介護２).build();
            assertThat(business.get日常生活自立度の組み合わせ_要介護２(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_日常生活自立度の組み合わせ_要介護２));
        }

        @Test
        public void 戻り値の日常生活自立度の組み合わせ_要介護３は_設定した値と同じ日常生活自立度の組み合わせ_要介護３を返す() {
            business = sut.set日常生活自立度の組み合わせ_要介護３(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_日常生活自立度の組み合わせ_要介護３).build();
            assertThat(business.get日常生活自立度の組み合わせ_要介護３(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_日常生活自立度の組み合わせ_要介護３));
        }

        @Test
        public void 戻り値の日常生活自立度の組み合わせ_要介護４は_設定した値と同じ日常生活自立度の組み合わせ_要介護４を返す() {
            business = sut.set日常生活自立度の組み合わせ_要介護４(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_日常生活自立度の組み合わせ_要介護４).build();
            assertThat(business.get日常生活自立度の組み合わせ_要介護４(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_日常生活自立度の組み合わせ_要介護４));
        }

        @Test
        public void 戻り値の日常生活自立度の組み合わせ_要介護５は_設定した値と同じ日常生活自立度の組み合わせ_要介護５を返す() {
            business = sut.set日常生活自立度の組み合わせ_要介護５(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_日常生活自立度の組み合わせ_要介護５).build();
            assertThat(business.get日常生活自立度の組み合わせ_要介護５(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_日常生活自立度の組み合わせ_要介護５));
        }

        @Test
        public void 戻り値の認知症高齢者の日常生活自立度の蓋然性評価コードは_設定した値と同じ認知症高齢者の日常生活自立度の蓋然性評価コードを返す() {
            business = sut.set認知症高齢者の日常生活自立度の蓋然性評価コード(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_認知症高齢者の日常生活自立度の蓋然性評価コード).build();
            assertThat(business.get認知症高齢者の日常生活自立度の蓋然性評価コード(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_認知症高齢者の日常生活自立度の蓋然性評価コード));
        }

        @Test
        public void 戻り値の認知症高齢者の日常生活自立度の蓋然性評価は_設定した値と同じ認知症高齢者の日常生活自立度の蓋然性評価を返す() {
            business = sut.set認知症高齢者の日常生活自立度の蓋然性評価(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_認知症高齢者の日常生活自立度の蓋然性評価).build();
            assertThat(business.get認知症高齢者の日常生活自立度の蓋然性評価(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_認知症高齢者の日常生活自立度の蓋然性評価));
        }

        @Test
        public void 戻り値の一次判定結果送付区分は_設定した値と同じ一次判定結果送付区分を返す() {
            business = sut.set一次判定結果送付区分(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_一次判定結果送付区分).build();
            assertThat(business.get一次判定結果送付区分(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_一次判定結果送付区分));
        }

        @Test
        public void 戻り値の一次判定結果送付年月日は_設定した値と同じ一次判定結果送付年月日を返す() {
            business = sut.set一次判定結果送付年月日(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_一次判定結果送付年月日).build();
            assertThat(business.get一次判定結果送付年月日(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_一次判定結果送付年月日));
        }

        @Test
        public void 戻り値のチャートは_設定した値と同じチャートを返す() {
            business = sut.setチャート(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_チャート).build();
            assertThat(business.getチャート(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_チャート));
        }

        @Test
        public void 戻り値の状態像は_設定した値と同じ状態像を返す() {
            business = sut.set状態像(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_状態像).build();
            assertThat(business.get状態像(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_状態像));
        }

    }
}
