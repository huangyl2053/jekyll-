/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5116IchijiHanteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IchijiHanteiKekkaJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IchijiHanteiKekkaJohoTest extends DbeTestBase {

    private static DbT5116IchijiHanteiKekkaJohoEntity IchijiHanteiKekkaJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    //private static 主キー型1 主キー名1;
    //private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        //主キー名1 = DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_主キー名1;
        //主キー名2 = DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbeTestBase {

        private static IchijiHanteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IchijiHanteiKekkaJohoEntity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            //sut = new IchijiHanteiKekkaJoho(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            //sut = new IchijiHanteiKekkaJoho(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5116IchijiHanteiKekkaJohoEntityにセットされている() {
            //sut = new IchijiHanteiKekkaJoho(主キー名1, 主キー名2);
            //assertThat(sut.get主キー名1(), is(主キー名1));
            //assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するIchijiHanteiKekkaJohoIdentifierにセットされている() {
//            sut = new IchijiHanteiKekkaJoho(主キー名1, 主キー名2);
//            assertThat(sut.identifier().getXXX(), is(主キー名1));
//            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbeTestBase {

        private static IchijiHanteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IchijiHanteiKekkaJohoEntity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new IchijiHanteiKekkaJoho(null);
        }

        @Test
        public void 指定したDbT5116IchijiHanteiKekkaJohoEntityのキー情報を識別子が持つ() {

            sut = new IchijiHanteiKekkaJoho(IchijiHanteiKekkaJohoEntity);

//            assertThat(sut.identifier().getXXX(), is(主キー名1));
//            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbeTestBase {

        private static IchijiHanteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IchijiHanteiKekkaJohoEntity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();

            sut = new IchijiHanteiKekkaJoho(IchijiHanteiKekkaJohoEntity);
        }

        @Test
        public void get要介護認定等基準時間は_entityが持つ要介護認定等基準時間を返す() {
            assertThat(sut.get要介護認定等基準時間(), is(IchijiHanteiKekkaJohoEntity.getKijunJikan()));
        }

        @Test
        public void get要介護認定等基準時間_食事は_entityが持つ要介護認定等基準時間_食事を返す() {
            assertThat(sut.get要介護認定等基準時間_食事(), is(IchijiHanteiKekkaJohoEntity.getKijunJikanShokuji()));
        }

        @Test
        public void get要介護認定等基準時間_排泄は_entityが持つ要介護認定等基準時間_排泄を返す() {
            assertThat(sut.get要介護認定等基準時間_排泄(), is(IchijiHanteiKekkaJohoEntity.getKijunJikanHaisetsu()));
        }

        @Test
        public void get要介護認定等基準時間_移動は_entityが持つ要介護認定等基準時間_移動を返す() {
            assertThat(sut.get要介護認定等基準時間_移動(), is(IchijiHanteiKekkaJohoEntity.getKijunJikanIdo()));
        }

        @Test
        public void get要介護認定等基準時間_清潔保持は_entityが持つ要介護認定等基準時間_清潔保持を返す() {
            assertThat(sut.get要介護認定等基準時間_清潔保持(), is(IchijiHanteiKekkaJohoEntity.getKijunJikanSeiketsuHoji()));
        }

        @Test
        public void get要介護認定等基準時間_間接ケアは_entityが持つ要介護認定等基準時間_間接ケアを返す() {
            assertThat(sut.get要介護認定等基準時間_間接ケア(), is(IchijiHanteiKekkaJohoEntity.getKijunJikanKansetsuCare()));
        }

        @Test
        public void get要介護認定等基準時間_BPSD関連は_entityが持つ要介護認定等基準時間_BPSD関連を返す() {
            assertThat(sut.get要介護認定等基準時間_BPSD関連(), is(IchijiHanteiKekkaJohoEntity.getKijunJikanBPSDKanren()));
        }

        @Test
        public void get要介護認定等基準時間_機能訓練は_entityが持つ要介護認定等基準時間_機能訓練を返す() {
            assertThat(sut.get要介護認定等基準時間_機能訓練(), is(IchijiHanteiKekkaJohoEntity.getKijunJikanKinoKunren()));
        }

        @Test
        public void get要介護認定等基準時間_医療関連は_entityが持つ要介護認定等基準時間_医療関連を返す() {
            assertThat(sut.get要介護認定等基準時間_医療関連(), is(IchijiHanteiKekkaJohoEntity.getKijunJikanIryoKanren()));
        }

        @Test
        public void get要介護認定等基準時間_認知症加算は_entityが持つ要介護認定等基準時間_認知症加算を返す() {
            assertThat(sut.get要介護認定等基準時間_認知症加算(), is(IchijiHanteiKekkaJohoEntity.getKijunJikanNinchishoKasan()));
        }

        @Test
        public void get中間評価項目得点第1群は_entityが持つ中間評価項目得点第1群を返す() {
            assertThat(sut.get中間評価項目得点第1群(), is(IchijiHanteiKekkaJohoEntity.getChukanHyokaKomoku1gun()));
        }

        @Test
        public void get中間評価項目得点第2群は_entityが持つ中間評価項目得点第2群を返す() {
            assertThat(sut.get中間評価項目得点第2群(), is(IchijiHanteiKekkaJohoEntity.getChukanHyokaKomoku2gun()));
        }

        @Test
        public void get中間評価項目得点第3群は_entityが持つ中間評価項目得点第3群を返す() {
            assertThat(sut.get中間評価項目得点第3群(), is(IchijiHanteiKekkaJohoEntity.getChukanHyokaKomoku3gun()));
        }

        @Test
        public void get中間評価項目得点第4群は_entityが持つ中間評価項目得点第4群を返す() {
            assertThat(sut.get中間評価項目得点第4群(), is(IchijiHanteiKekkaJohoEntity.getChukanHyokaKomoku4gun()));
        }

        @Test
        public void get中間評価項目得点第5群は_entityが持つ中間評価項目得点第5群を返す() {
            assertThat(sut.get中間評価項目得点第5群(), is(IchijiHanteiKekkaJohoEntity.getChukanHyokaKomoku5gun()));
        }

        @Test
        public void get中間評価項目得点第6群は_entityが持つ中間評価項目得点第6群を返す() {
            assertThat(sut.get中間評価項目得点第6群(), is(IchijiHanteiKekkaJohoEntity.getChukanHyokaKomoku6gun()));
        }

        @Test
        public void get中間評価項目得点第7群は_entityが持つ中間評価項目得点第7群を返す() {
            assertThat(sut.get中間評価項目得点第7群(), is(IchijiHanteiKekkaJohoEntity.getChukanHyokaKomoku7gun()));
        }

        @Test
        public void get要介護認定一次判定警告コードは_entityが持つ要介護認定一次判定警告コードを返す() {
            assertThat(sut.get要介護認定一次判定警告コード(), is(IchijiHanteiKekkaJohoEntity.getIchijiHnateiKeikokuCode()));
        }

        @Test
        public void get要介護認定状態の安定性コードは_entityが持つ要介護認定状態の安定性コードを返す() {
            assertThat(sut.get要介護認定状態の安定性コード(), is(IchijiHanteiKekkaJohoEntity.getJotaiAnteiseiCode()));
        }

        @Test
        public void get認知症自立度Ⅱ以上の蓋然性は_entityが持つ認知症自立度Ⅱ以上の蓋然性を返す() {
            assertThat(sut.get認知症自立度Ⅱ以上の蓋然性(), is(IchijiHanteiKekkaJohoEntity.getNinchishoJiritsudoIIijoNoGaizensei()));
        }

        @Test
        public void get認知機能及び状態安定性から推定される給付区分コードは_entityが持つ認知機能及び状態安定性から推定される給付区分コードを返す() {
            assertThat(sut.get認知機能及び状態安定性から推定される給付区分コード(), is(IchijiHanteiKekkaJohoEntity.getSuiteiKyufuKubunCode()));
        }

        @Test
        public void get運動能力の低下していない認知症高齢者の指標コードは_entityが持つ運動能力の低下していない認知症高齢者の指標コードを返す() {
            assertThat(sut.get運動能力の低下していない認知症高齢者の指標コード(), is(IchijiHanteiKekkaJohoEntity.getNinchishoKoreishaShihyoCode()));
        }

        @Test
        public void get日常生活自立度の組み合わせ_自立は_entityが持つ日常生活自立度の組み合わせ_自立を返す() {
            assertThat(sut.get日常生活自立度の組み合わせ_自立(), is(IchijiHanteiKekkaJohoEntity.getJiritsudoKumiawase1()));
        }

        @Test
        public void get日常生活自立度の組み合わせ_要支援は_entityが持つ日常生活自立度の組み合わせ_要支援を返す() {
            assertThat(sut.get日常生活自立度の組み合わせ_要支援(), is(IchijiHanteiKekkaJohoEntity.getJiritsudoKumiawase2()));
        }

        @Test
        public void get日常生活自立度の組み合わせ_要介護１は_entityが持つ日常生活自立度の組み合わせ_要介護１を返す() {
            assertThat(sut.get日常生活自立度の組み合わせ_要介護１(), is(IchijiHanteiKekkaJohoEntity.getJiritsudoKumiawase3()));
        }

        @Test
        public void get日常生活自立度の組み合わせ_要介護２は_entityが持つ日常生活自立度の組み合わせ_要介護２を返す() {
            assertThat(sut.get日常生活自立度の組み合わせ_要介護２(), is(IchijiHanteiKekkaJohoEntity.getJiritsudoKumiawase4()));
        }

        @Test
        public void get日常生活自立度の組み合わせ_要介護３は_entityが持つ日常生活自立度の組み合わせ_要介護３を返す() {
            assertThat(sut.get日常生活自立度の組み合わせ_要介護３(), is(IchijiHanteiKekkaJohoEntity.getJiritsudoKumiawase5()));
        }

        @Test
        public void get日常生活自立度の組み合わせ_要介護４は_entityが持つ日常生活自立度の組み合わせ_要介護４を返す() {
            assertThat(sut.get日常生活自立度の組み合わせ_要介護４(), is(IchijiHanteiKekkaJohoEntity.getJiritsudoKumiawase6()));
        }

        @Test
        public void get日常生活自立度の組み合わせ_要介護５は_entityが持つ日常生活自立度の組み合わせ_要介護５を返す() {
            assertThat(sut.get日常生活自立度の組み合わせ_要介護５(), is(IchijiHanteiKekkaJohoEntity.getJiritsudoKumiawase7()));
        }

        @Test
        public void get認知症高齢者の日常生活自立度の蓋然性評価コードは_entityが持つ認知症高齢者の日常生活自立度の蓋然性評価コードを返す() {
            assertThat(sut.get認知症高齢者の日常生活自立度の蓋然性評価コード(), is(IchijiHanteiKekkaJohoEntity.getGaizenseiHyokaCode()));
        }

        @Test
        public void get認知症高齢者の日常生活自立度の蓋然性評価は_entityが持つ認知症高齢者の日常生活自立度の蓋然性評価を返す() {
            assertThat(sut.get認知症高齢者の日常生活自立度の蓋然性評価(), is(IchijiHanteiKekkaJohoEntity.getGaizenseiHyokaPercent()));
        }

        @Test
        public void get一次判定結果送付区分は_entityが持つ一次判定結果送付区分を返す() {
            assertThat(sut.get一次判定結果送付区分(), is(IchijiHanteiKekkaJohoEntity.getIchijiHanteiSofuKubun()));
        }

        @Test
        public void get一次判定結果送付年月日は_entityが持つ一次判定結果送付年月日を返す() {
            assertThat(sut.get一次判定結果送付年月日(), is(IchijiHanteiKekkaJohoEntity.getIchijiHanteiKekkaSofuYMD()));
        }

        @Test
        public void getチャートは_entityが持つチャートを返す() {
            assertThat(sut.getチャート(), is(IchijiHanteiKekkaJohoEntity.getChert()));
        }

        @Test
        public void get状態像は_entityが持つ状態像を返す() {
            assertThat(sut.get状態像(), is(IchijiHanteiKekkaJohoEntity.getJotaizo()));
        }
    }

    public static class toEntityテスト extends DbeTestBase {

        private static IchijiHanteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IchijiHanteiKekkaJohoEntity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();

            sut = new IchijiHanteiKekkaJoho(IchijiHanteiKekkaJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(IchijiHanteiKekkaJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbeTestBase {

        private static IchijiHanteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IchijiHanteiKekkaJohoEntity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();

            sut = new IchijiHanteiKekkaJoho(IchijiHanteiKekkaJohoEntity);
        }

        @Test
        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbeTestBase {

        private static IchijiHanteiKekkaJoho sut;
        private static IchijiHanteiKekkaJoho result;

        @BeforeClass
        public static void setUpClass() {
            IchijiHanteiKekkaJohoEntity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();

        }

        @Test
        public void IchijiHanteiKekkaJohoが保持するDbT5116IchijiHanteiKekkaJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりIchijiHanteiKekkaJohoが保持するDbT5116IchijiHanteiKekkaJohoEntityのEntityDataStateがDeletedに指定されたIchijiHanteiKekkaJohoが返る() {
            sut = TestSupport.setStateIchijiHanteiKekkaJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void IchijiHanteiKekkaJohoが保持するDbT5116IchijiHanteiKekkaJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりIchijiHanteiKekkaJohoが保持するDbT5116IchijiHanteiKekkaJohoEntityのEntityDataStateがDeletedに指定されたIchijiHanteiKekkaJohoが返る() {
            sut = TestSupport.setStateIchijiHanteiKekkaJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void IchijiHanteiKekkaJohoが保持するDbT5116IchijiHanteiKekkaJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりIchijiHanteiKekkaJohoが保持するDbT5116IchijiHanteiKekkaJohoEntityのEntityDataStateがDeletedに指定されたIchijiHanteiKekkaJohoが返る() {
            sut = TestSupport.setStateIchijiHanteiKekkaJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void IchijiHanteiKekkaJohoが保持するDbT5116IchijiHanteiKekkaJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateIchijiHanteiKekkaJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static IchijiHanteiKekkaJoho setStateIchijiHanteiKekkaJoho(EntityDataState parentState) {
            IchijiHanteiKekkaJohoEntity.setState(parentState);
            return new IchijiHanteiKekkaJoho(IchijiHanteiKekkaJohoEntity);
        }
    }
}
