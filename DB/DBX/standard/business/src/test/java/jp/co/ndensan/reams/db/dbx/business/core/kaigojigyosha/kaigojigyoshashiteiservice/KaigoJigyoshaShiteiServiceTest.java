/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoJigyoshaShiteiService}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaShiteiServiceTest extends DbxTestBase {

    private static DbT7063KaigoJigyoshaShiteiServiceEntity KaigoJigyoshaShiteiServiceEntity;
    private static KaigoJigyoshaNo 事業者番号;
    private static KaigoServiceShuruiCode サービス種類コード;
    private static FlexibleDate 有効開始日;

    @BeforeClass
    public static void setUpClass() {

        事業者番号 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者番号;
        サービス種類コード = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス種類コード;
        有効開始日 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_有効開始日;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static KaigoJigyoshaShiteiService sut;

        @Before
        public void setUp() {
            KaigoJigyoshaShiteiServiceEntity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaShiteiServiceEntity.setJigyoshaNo(事業者番号);
            KaigoJigyoshaShiteiServiceEntity.setServiceShuruiCode(サービス種類コード);
            KaigoJigyoshaShiteiServiceEntity.setYukoKaishiYMD(有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 事業者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoJigyoshaShiteiService(null, サービス種類コード, 有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void サービス種類コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoJigyoshaShiteiService(事業者番号, null, 有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 有効開始日がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoJigyoshaShiteiService(事業者番号, サービス種類コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT7063KaigoJigyoshaShiteiServiceEntityにセットされている() {
            sut = new KaigoJigyoshaShiteiService(事業者番号, サービス種類コード, 有効開始日);
            assertThat(sut.get事業者番号(), is(事業者番号));
            assertThat(sut.getサービス種類コード(), is(サービス種類コード));
            assertThat(sut.identifier().get有効開始日(), is(有効開始日));
        }

        @Test
        public void 指定したキーが保持するKaigoJigyoshaShiteiServiceIdentifierにセットされている() {
            sut = new KaigoJigyoshaShiteiService(事業者番号, サービス種類コード, 有効開始日);
            assertThat(sut.identifier().get事業者番号(), is(事業者番号));
            assertThat(sut.identifier().getサービス種類コード(), is(サービス種類コード));
            assertThat(sut.identifier().get有効開始日(), is(有効開始日));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static KaigoJigyoshaShiteiService sut;

        @Before
        public void setUp() {
            KaigoJigyoshaShiteiServiceEntity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaShiteiServiceEntity.setJigyoshaNo(事業者番号);
            KaigoJigyoshaShiteiServiceEntity.setServiceShuruiCode(サービス種類コード);
            KaigoJigyoshaShiteiServiceEntity.setYukoKaishiYMD(有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoJigyoshaShiteiService(null);
        }

        @Test
        public void 指定したDbT7063KaigoJigyoshaShiteiServiceEntityのキー情報を識別子が持つ() {

            sut = new KaigoJigyoshaShiteiService(KaigoJigyoshaShiteiServiceEntity);
            assertThat(sut.identifier().get事業者番号(), is(事業者番号));
            assertThat(sut.identifier().getサービス種類コード(), is(サービス種類コード));
            assertThat(sut.identifier().get有効開始日(), is(有効開始日));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static KaigoJigyoshaShiteiService sut;

        @Before
        public void setUp() {
            KaigoJigyoshaShiteiServiceEntity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaShiteiServiceEntity.setJigyoshaNo(事業者番号);
            KaigoJigyoshaShiteiServiceEntity.setServiceShuruiCode(サービス種類コード);
            KaigoJigyoshaShiteiServiceEntity.setYukoKaishiYMD(有効開始日);

            sut = new KaigoJigyoshaShiteiService(KaigoJigyoshaShiteiServiceEntity);
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(KaigoJigyoshaShiteiServiceEntity.getJigyoshaNo()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KaigoJigyoshaShiteiServiceEntity.getServiceShuruiCode()));
        }

        @Test
        public void get有効開始日は_entityが持つ有効開始日を返す() {
            assertThat(sut.get有効開始日(), is(KaigoJigyoshaShiteiServiceEntity.getYukoKaishiYMD()));
        }

        @Test
        public void get有効終了日は_entityが持つ有効終了日を返す() {
            assertThat(sut.get有効終了日(), is(KaigoJigyoshaShiteiServiceEntity.getYukoShuryoYMD()));
        }

        @Test
        public void get異動日は_entityが持つ異動日を返す() {
            assertThat(sut.get異動日(), is(KaigoJigyoshaShiteiServiceEntity.getIdoYMD()));
        }

        @Test
        public void get異動事由は_entityが持つ異動事由を返す() {
            assertThat(sut.get異動事由(), is(KaigoJigyoshaShiteiServiceEntity.getIdoJiyu()));
        }

        @Test
        public void get指定番号は_entityが持つ指定番号を返す() {
            assertThat(sut.get指定番号(), is(KaigoJigyoshaShiteiServiceEntity.getShiteiNo()));
        }

        @Test
        public void get基本情報準拠区分は_entityが持つ基本情報準拠区分を返す() {
            assertThat(sut.get基本情報準拠区分(), is(KaigoJigyoshaShiteiServiceEntity.getKihonJohoJunkyoKubun()));
        }

        @Test
        public void get事業開始日は_entityが持つ事業開始日を返す() {
            assertThat(sut.get事業開始日(), is(KaigoJigyoshaShiteiServiceEntity.getJigyoKaishiYMD()));
        }

        @Test
        public void get事業休止日は_entityが持つ事業休止日を返す() {
            assertThat(sut.get事業休止日(), is(KaigoJigyoshaShiteiServiceEntity.getJigyoKyushiYMD()));
        }

        @Test
        public void get事業再開日は_entityが持つ事業再開日を返す() {
            assertThat(sut.get事業再開日(), is(KaigoJigyoshaShiteiServiceEntity.getJigyoSaikaiYMD()));
        }

        @Test
        public void get事業廃止日は_entityが持つ事業廃止日を返す() {
            assertThat(sut.get事業廃止日(), is(KaigoJigyoshaShiteiServiceEntity.getJigyoHaishiYMD()));
        }

        @Test
        public void get事業者名称は_entityが持つ事業者名称を返す() {
            assertThat(sut.get事業者名称(), is(KaigoJigyoshaShiteiServiceEntity.getJigyoshaName()));
        }

        @Test
        public void get事業者名称カナは_entityが持つ事業者名称カナを返す() {
            assertThat(sut.get事業者名称カナ(), is(KaigoJigyoshaShiteiServiceEntity.getJigyoshaNameKana()));
        }

        @Test
        public void get事業者郵便番号は_entityが持つ事業者郵便番号を返す() {
            assertThat(sut.get事業者郵便番号(), is(KaigoJigyoshaShiteiServiceEntity.getJigyoshaYubinNo()));
        }

        @Test
        public void get事業者住所は_entityが持つ事業者住所を返す() {
            assertThat(sut.get事業者住所(), is(KaigoJigyoshaShiteiServiceEntity.getJigyoshaAddress()));
        }

        @Test
        public void get事業者住所カナは_entityが持つ事業者住所カナを返す() {
            assertThat(sut.get事業者住所カナ(), is(KaigoJigyoshaShiteiServiceEntity.getJigyoshaAddressKana()));
        }

        @Test
        public void get事業者電話番号は_entityが持つ事業者電話番号を返す() {
            assertThat(sut.get事業者電話番号(), is(KaigoJigyoshaShiteiServiceEntity.getJigyoshaTelNo()));
        }

        @Test
        public void get事業者FAX番号は_entityが持つ事業者FAX番号を返す() {
            assertThat(sut.get事業者FAX番号(), is(KaigoJigyoshaShiteiServiceEntity.getJigyoshaFaxNo()));
        }

        @Test
        public void get登録保険者番号は_entityが持つ登録保険者番号を返す() {
            assertThat(sut.get登録保険者番号(), is(KaigoJigyoshaShiteiServiceEntity.getTorokuHokenshaNo()));
        }

        @Test
        public void get受領委任の有無は_entityが持つ受領委任の有無を返す() {
            assertThat(sut.get受領委任の有無(), is(KaigoJigyoshaShiteiServiceEntity.getJuryoininUmu()));
        }

        @Test
        public void get登録開始日は_entityが持つ登録開始日を返す() {
            assertThat(sut.get登録開始日(), is(KaigoJigyoshaShiteiServiceEntity.getTorokuKaishiYMD()));
        }

        @Test
        public void get登録終了日は_entityが持つ登録終了日を返す() {
            assertThat(sut.get登録終了日(), is(KaigoJigyoshaShiteiServiceEntity.getTorokuShuryoYMD()));
        }

        @Test
        public void get管理者氏名は_entityが持つ管理者氏名を返す() {
            assertThat(sut.get管理者氏名(), is(KaigoJigyoshaShiteiServiceEntity.getKanrishaName()));
        }

        @Test
        public void get管理者氏名カナは_entityが持つ管理者氏名カナを返す() {
            assertThat(sut.get管理者氏名カナ(), is(KaigoJigyoshaShiteiServiceEntity.getKanrishaNameKana()));
        }

        @Test
        public void get管理者住所郵便番号は_entityが持つ管理者住所郵便番号を返す() {
            assertThat(sut.get管理者住所郵便番号(), is(KaigoJigyoshaShiteiServiceEntity.getKanrishaYubinNo()));
        }

        @Test
        public void get管理者住所は_entityが持つ管理者住所を返す() {
            assertThat(sut.get管理者住所(), is(KaigoJigyoshaShiteiServiceEntity.getKanrishaAddress()));
        }

        @Test
        public void get管理者住所カナは_entityが持つ管理者住所カナを返す() {
            assertThat(sut.get管理者住所カナ(), is(KaigoJigyoshaShiteiServiceEntity.getKanrishaAddressKana()));
        }

        @Test
        public void get口座情報準拠区分は_entityが持つ口座情報準拠区分を返す() {
            assertThat(sut.get口座情報準拠区分(), is(KaigoJigyoshaShiteiServiceEntity.getKozaJohoJunkyoKubun()));
        }

        @Test
        public void get社会福祉法人軽減事業実施の有無は_entityが持つ社会福祉法人軽減事業実施の有無を返す() {
            assertThat(sut.get社会福祉法人軽減事業実施の有無(), is(KaigoJigyoshaShiteiServiceEntity.getShakaiFukushihoujinKeigenjigyouJisshi_umu()));
        }

        @Test
        public void get生活保護法による指定の有無は_entityが持つ生活保護法による指定の有無を返す() {
            assertThat(sut.get生活保護法による指定の有無(), is(KaigoJigyoshaShiteiServiceEntity.getSeikatsuhogohouShitei_umu()));
        }

        @Test
        public void get施設等の区分は_entityが持つ施設等の区分を返す() {
            assertThat(sut.get施設等の区分(), is(KaigoJigyoshaShiteiServiceEntity.getShisetsunadoKubun()));
        }

        @Test
        public void get人員配置区分は_entityが持つ人員配置区分を返す() {
            assertThat(sut.get人員配置区分(), is(KaigoJigyoshaShiteiServiceEntity.getJininHaichiKubun()));
        }

        @Test
        public void get特別地域加算の有無は_entityが持つ特別地域加算の有無を返す() {
            assertThat(sut.get特別地域加算の有無(), is(KaigoJigyoshaShiteiServiceEntity.getTokubetsuChiikiKasan_umu()));
        }

        @Test
        public void get緊急時訪問介護加算の有無は_entityが持つ緊急時訪問介護加算の有無を返す() {
            assertThat(sut.get緊急時訪問介護加算の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKinkyujiHomonkaigoKasan_umu()));
        }

        @Test
        public void get特別管理体制は_entityが持つ特別管理体制を返す() {
            assertThat(sut.get特別管理体制(), is(KaigoJigyoshaShiteiServiceEntity.getTokubetsuKanriTaisei()));
        }

        @Test
        public void get機能訓練指導体制の有無は_entityが持つ機能訓練指導体制の有無を返す() {
            assertThat(sut.get機能訓練指導体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKinoKunrenShidoTaisei_umu()));
        }

        @Test
        public void get食事提供体制の有無は_entityが持つ食事提供体制の有無を返す() {
            assertThat(sut.get食事提供体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getShokujiTeikyoTaisei_umu()));
        }

        @Test
        public void get入浴介助体制の有無は_entityが持つ入浴介助体制の有無を返す() {
            assertThat(sut.get入浴介助体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getNyuyokuKaijoTaisei_umu()));
        }

        @Test
        public void get特別入浴介助体制の有無は_entityが持つ特別入浴介助体制の有無を返す() {
            assertThat(sut.get特別入浴介助体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getTokubetsuNyuyokuKaijoTaisei_umu()));
        }

        @Test
        public void get常勤専従医師配置の有無は_entityが持つ常勤専従医師配置の有無を返す() {
            assertThat(sut.get常勤専従医師配置の有無(), is(KaigoJigyoshaShiteiServiceEntity.getJoukinsenjuIshiHaichi_umu()));
        }

        @Test
        public void get医師の配置基準は_entityが持つ医師の配置基準を返す() {
            assertThat(sut.get医師の配置基準(), is(KaigoJigyoshaShiteiServiceEntity.getIshiHaichiKijun()));
        }

        @Test
        public void get精神科医師定期的療養指導の有無は_entityが持つ精神科医師定期的療養指導の有無を返す() {
            assertThat(sut.get精神科医師定期的療養指導の有無(), is(KaigoJigyoshaShiteiServiceEntity.getSeisinkaIshiTeikitekiRyouyousidou_umu()));
        }

        @Test
        public void get夜間勤務条件基準は_entityが持つ夜間勤務条件基準を返す() {
            assertThat(sut.get夜間勤務条件基準(), is(KaigoJigyoshaShiteiServiceEntity.getYakanKinmuJokenKijun()));
        }

        @Test
        public void get認知症専門棟の有無は_entityが持つ認知症専門棟の有無を返す() {
            assertThat(sut.get認知症専門棟の有無(), is(KaigoJigyoshaShiteiServiceEntity.getNinchishouSenmontou_umu()));
        }

        @Test
        public void get食事提供の状況は_entityが持つ食事提供の状況を返す() {
            assertThat(sut.get食事提供の状況(), is(KaigoJigyoshaShiteiServiceEntity.getShokujiTeikyoJokyo()));
        }

        @Test
        public void get送迎体制は_entityが持つ送迎体制を返す() {
            assertThat(sut.get送迎体制(), is(KaigoJigyoshaShiteiServiceEntity.getSougeiTaisei()));
        }

        @Test
        public void getリハビリテーション提供体制_総合リハビリテーション施設_の有無は_entityが持つリハビリテーション提供体制_総合リハビリテーション施設_の有無を返す() {
            assertThat(sut.getリハビリテーション提供体制_総合リハビリテーション施設_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getRehaTeikyoTaisei_SogoRehaShisetsu_umu()));
        }

        @Test
        public void getリハビリテーション提供体制_理学療法Ⅱ_の有無は_entityが持つリハビリテーション提供体制_理学療法Ⅱ_の有無を返す() {
            assertThat(sut.getリハビリテーション提供体制_理学療法Ⅱ_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getRehaTeikyoTaisei_RigakuRyohoII_umu()));
        }

        @Test
        public void getリハビリテーション提供体制_理学療法Ⅲ_の有無は_entityが持つリハビリテーション提供体制_理学療法Ⅲ_の有無を返す() {
            assertThat(sut.getリハビリテーション提供体制_理学療法Ⅲ_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getRehaTeikyoTaisei_RigakuRyohoIII_umu()));
        }

        @Test
        public void getリハビリテーション提供体制_作業療法Ⅱ_の有無は_entityが持つリハビリテーション提供体制_作業療法Ⅱ_の有無を返す() {
            assertThat(sut.getリハビリテーション提供体制_作業療法Ⅱ_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getRehaTeikyoTaisei_SagyoRyohoII_umu()));
        }

        @Test
        public void getリハビリテーション提供体制_精神科作業療法_の有無は_entityが持つリハビリテーション提供体制_精神科作業療法_の有無を返す() {
            assertThat(sut.getリハビリテーション提供体制_精神科作業療法_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu()));
        }

        @Test
        public void getリハビリテーション提供体制_その他_の有無は_entityが持つリハビリテーション提供体制_その他_の有無を返す() {
            assertThat(sut.getリハビリテーション提供体制_その他_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getRehaTeikyoTaisei_Sonota_umu()));
        }

        @Test
        public void getリハビリテーションの加算状況の有無は_entityが持つリハビリテーションの加算状況の有無を返す() {
            assertThat(sut.getリハビリテーションの加算状況の有無(), is(KaigoJigyoshaShiteiServiceEntity.getRehabilitationKasanJokyo()));
        }

        @Test
        public void get療養環境基準は_entityが持つ療養環境基準を返す() {
            assertThat(sut.get療養環境基準(), is(KaigoJigyoshaShiteiServiceEntity.getRyoyoKankyoKijun()));
        }

        @Test
        public void get医師の欠員による減算の状況の有無は_entityが持つ医師の欠員による減算の状況の有無を返す() {
            assertThat(sut.get医師の欠員による減算の状況の有無(), is(KaigoJigyoshaShiteiServiceEntity.getIshiKetuinGenzanJokyo_umu()));
        }

        @Test
        public void get看護職員の欠員による減算の状況の有無は_entityが持つ看護職員の欠員による減算の状況の有無を返す() {
            assertThat(sut.get看護職員の欠員による減算の状況の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKangoShokuinKetsuinGenzanJokyo_umu()));
        }

        @Test
        public void get理学療法士の欠員による減算の状況の有無は_entityが持つ理学療法士の欠員による減算の状況の有無を返す() {
            assertThat(sut.get理学療法士の欠員による減算の状況の有無(), is(KaigoJigyoshaShiteiServiceEntity.getRigakuRyouhousiKetsuinGenzanJokyo_umu()));
        }

        @Test
        public void get作業療法士の欠員による減算の状況の有無は_entityが持つ作業療法士の欠員による減算の状況の有無を返す() {
            assertThat(sut.get作業療法士の欠員による減算の状況の有無(), is(KaigoJigyoshaShiteiServiceEntity.getSagyouRyouhousiKetsuinGenzanJokyo_umu()));
        }

        @Test
        public void get介護職員の欠員による減算の状況の有無は_entityが持つ介護職員の欠員による減算の状況の有無を返す() {
            assertThat(sut.get介護職員の欠員による減算の状況の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKaigoShokuinKetsuinGenzanJokyo_umu()));
        }

        @Test
        public void get介護支援専門員の欠員による減算の状況の有無は_entityが持つ介護支援専門員の欠員による減算の状況の有無を返す() {
            assertThat(sut.get介護支援専門員の欠員による減算の状況の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu()));
        }

        @Test
        public void get介護従業者の欠員による減算の状況の有無は_entityが持つ介護従業者の欠員による減算の状況の有無を返す() {
            assertThat(sut.get介護従業者の欠員による減算の状況の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKaigoJujishaKetsuinGenzanJokyo_umu()));
        }

        @Test
        public void get感染対策指導管理の有無は_entityが持つ感染対策指導管理の有無を返す() {
            assertThat(sut.get感染対策指導管理の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKansenTaisakuSidoKanri_umu()));
        }

        @Test
        public void get重症皮膚潰瘍指導管理の有無は_entityが持つ重症皮膚潰瘍指導管理の有無を返す() {
            assertThat(sut.get重症皮膚潰瘍指導管理の有無(), is(KaigoJigyoshaShiteiServiceEntity.getJushoHifuKaiyouShidoKanri_umu()));
        }

        @Test
        public void get薬剤管理指導の有無は_entityが持つ薬剤管理指導の有無を返す() {
            assertThat(sut.get薬剤管理指導の有無(), is(KaigoJigyoshaShiteiServiceEntity.getYakuzaiKaniriShido_umu()));
        }

        @Test
        public void get障害者生活支援体制の有無は_entityが持つ障害者生活支援体制の有無を返す() {
            assertThat(sut.get障害者生活支援体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getShogaishaSeikatsuShienTaisei_umu()));
        }

        @Test
        public void get地域区分コードは_entityが持つ地域区分コードを返す() {
            assertThat(sut.get地域区分コード(), is(KaigoJigyoshaShiteiServiceEntity.getChiikiKubunCode()));
        }

        @Test
        public void get時間延長サービス体制は_entityが持つ時間延長サービス体制を返す() {
            assertThat(sut.get時間延長サービス体制(), is(KaigoJigyoshaShiteiServiceEntity.getJikanEnchoServiceTaisei()));
        }

        @Test
        public void get個別リハビリテーション提供体制は_entityが持つ個別リハビリテーション提供体制を返す() {
            assertThat(sut.get個別リハビリテーション提供体制(), is(KaigoJigyoshaShiteiServiceEntity.getKobetsuRehabilitationTeikyoTaisei()));
        }

        @Test
        public void get居住費対策は_entityが持つ居住費対策を返す() {
            assertThat(sut.get居住費対策(), is(KaigoJigyoshaShiteiServiceEntity.getKyojuhiTaisaku()));
        }

        @Test
        public void get夜間ケアの有無は_entityが持つ夜間ケアの有無を返す() {
            assertThat(sut.get夜間ケアの有無(), is(KaigoJigyoshaShiteiServiceEntity.getYakanCare_umu()));
        }

        @Test
        public void getリハビリテーション機能強化の有無は_entityが持つリハビリテーション機能強化の有無を返す() {
            assertThat(sut.getリハビリテーション機能強化の有無(), is(KaigoJigyoshaShiteiServiceEntity.getRehabilitationKinoKyoka_umu()));
        }

        @Test
        public void get個別リハビリテーション提供体制_総合リハビリテーション施設_の有無は_entityが持つ個別リハビリテーション提供体制_総合リハビリテーション施設_の有無を返す() {
            assertThat(sut.get個別リハビリテーション提供体制_総合リハビリテーション施設_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu()));
        }

        @Test
        public void get個別リハビリテーション提供体制_理学療法Ⅱ_の有無1は_entityが持つ個別リハビリテーション提供体制_理学療法Ⅱ_の有無1を返す() {
            assertThat(sut.get個別リハビリテーション提供体制_理学療法Ⅱ_の有無1(), is(KaigoJigyoshaShiteiServiceEntity.getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1()));
        }

        @Test
        public void get個別リハビリテーション提供体制_理学療法Ⅲ_の有無は_entityが持つ個別リハビリテーション提供体制_理学療法Ⅲ_の有無を返す() {
            assertThat(sut.get個別リハビリテーション提供体制_理学療法Ⅲ_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu()));
        }

        @Test
        public void get個別リハビリテーション提供体制_作業療法Ⅱ_の有無は_entityが持つ個別リハビリテーション提供体制_作業療法Ⅱ_の有無を返す() {
            assertThat(sut.get個別リハビリテーション提供体制_作業療法Ⅱ_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu()));
        }

        @Test
        public void get個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無は_entityが持つ個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無を返す() {
            assertThat(sut.get個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu()));
        }

        @Test
        public void get個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無は_entityが持つ個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無を返す() {
            assertThat(sut.get個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu()));
        }

        @Test
        public void get言語聴覚士の欠員による減算の状況の有無は_entityが持つ言語聴覚士の欠員による減算の状況の有無を返す() {
            assertThat(sut.get言語聴覚士の欠員による減算の状況の有無(), is(KaigoJigyoshaShiteiServiceEntity.getGengoChokakushiKetsuinGenzanJokyo_umu()));
        }

        @Test
        public void get栄養管理の評価は_entityが持つ栄養管理の評価を返す() {
            assertThat(sut.get栄養管理の評価(), is(KaigoJigyoshaShiteiServiceEntity.getEiyouKanriHyoka()));
        }

        @Test
        public void get特定事業所加算_訪問介護_の有無は_entityが持つ特定事業所加算_訪問介護_の有無を返す() {
            assertThat(sut.get特定事業所加算_訪問介護_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getTokuteijigyoushoKasan_HomonKaigo_umu()));
        }

        @Test
        public void get若年性認知症ケア体制の有無は_entityが持つ若年性認知症ケア体制の有無を返す() {
            assertThat(sut.get若年性認知症ケア体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getJakunenseiNinchishoCareTaisei_umu()));
        }

        @Test
        public void get運動器機能向上体制の有無は_entityが持つ運動器機能向上体制の有無を返す() {
            assertThat(sut.get運動器機能向上体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getUndokiKinoKojoTaisei_umu()));
        }

        @Test
        public void get栄養マネジメント_改善_体制の有無は_entityが持つ栄養マネジメント_改善_体制の有無を返す() {
            assertThat(sut.get栄養マネジメント_改善_体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getEiyoManagement_KaizenTaisei_umu()));
        }

        @Test
        public void get口腔機能向上体制の有無は_entityが持つ口腔機能向上体制の有無を返す() {
            assertThat(sut.get口腔機能向上体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKokuKinoKojoTaisei_umu()));
        }

        @Test
        public void get事業所評価加算_申出_の有無は_entityが持つ事業所評価加算_申出_の有無を返す() {
            assertThat(sut.get事業所評価加算_申出_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getJigyoshoHyokaKasan_Moshide_umu()));
        }

        @Test
        public void get事業所評価加算_決定_の有無は_entityが持つ事業所評価加算_決定_の有無を返す() {
            assertThat(sut.get事業所評価加算_決定_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getJigyoshoHyokaKasan_Kettei_umu()));
        }

        @Test
        public void get緊急受入体制の有無は_entityが持つ緊急受入体制の有無を返す() {
            assertThat(sut.get緊急受入体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKinkyuUkeireTaisei_umu()));
        }

        @Test
        public void get夜間看護体制の有無は_entityが持つ夜間看護体制の有無を返す() {
            assertThat(sut.get夜間看護体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getYakanKangoTaisei_umu()));
        }

        @Test
        public void get特定事業所加算_居宅介護支援_の有無は_entityが持つ特定事業所加算_居宅介護支援_の有無を返す() {
            assertThat(sut.get特定事業所加算_居宅介護支援_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getTokuteijigyoshoKasan_Kyotakukaigoshien_umu()));
        }

        @Test
        public void get介護支援専門員数_専従の常勤者_は_entityが持つ介護支援専門員数_専従の常勤者_を返す() {
            assertThat(sut.get介護支援専門員数_専従の常勤者_(), is(KaigoJigyoshaShiteiServiceEntity.getKaigoShienSemmoninSenjuJokinshaNinsu()));
        }

        @Test
        public void get介護支援専門員数_専従の非常勤者_は_entityが持つ介護支援専門員数_専従の非常勤者_を返す() {
            assertThat(sut.get介護支援専門員数_専従の非常勤者_(), is(KaigoJigyoshaShiteiServiceEntity.getKaigoSienSemmoninSenjuHijokinshaNinsu()));
        }

        @Test
        public void get介護支援専門員数_兼務の常勤者_は_entityが持つ介護支援専門員数_兼務の常勤者_を返す() {
            assertThat(sut.get介護支援専門員数_兼務の常勤者_(), is(KaigoJigyoshaShiteiServiceEntity.getKaigoSienSemmoninKemmuJokinshaNinsu()));
        }

        @Test
        public void get介護支援専門員数_兼務の非常勤者_は_entityが持つ介護支援専門員数_兼務の非常勤者_を返す() {
            assertThat(sut.get介護支援専門員数_兼務の非常勤者_(), is(KaigoJigyoshaShiteiServiceEntity.getKaigoSienSemmoninKemmuHijokinshaNinsu()));
        }

        @Test
        public void get訪問介護サービス提供責任者数は_entityが持つ訪問介護サービス提供責任者数を返す() {
            assertThat(sut.get訪問介護サービス提供責任者数(), is(KaigoJigyoshaShiteiServiceEntity.getHomonkaigoServiceTeikyoSekininshaNinsu()));
        }

        @Test
        public void get訪問介護員数_専従の常勤者_は_entityが持つ訪問介護員数_専従の常勤者_を返す() {
            assertThat(sut.get訪問介護員数_専従の常勤者_(), is(KaigoJigyoshaShiteiServiceEntity.getHomonkaigoSenjuJokinshaNinsu()));
        }

        @Test
        public void get訪問介護員数_専従の非常勤者_は_entityが持つ訪問介護員数_専従の非常勤者_を返す() {
            assertThat(sut.get訪問介護員数_専従の非常勤者_(), is(KaigoJigyoshaShiteiServiceEntity.getHomonkaigoSenjuHijokinshaNinsu()));
        }

        @Test
        public void get訪問介護員数_兼務の常勤者_は_entityが持つ訪問介護員数_兼務の常勤者_を返す() {
            assertThat(sut.get訪問介護員数_兼務の常勤者_(), is(KaigoJigyoshaShiteiServiceEntity.getHomonkaigoKemmuJokinshaNinsu()));
        }

        @Test
        public void get訪問介護員数_兼務の非常勤者_は_entityが持つ訪問介護員数_兼務の非常勤者_を返す() {
            assertThat(sut.get訪問介護員数_兼務の非常勤者_(), is(KaigoJigyoshaShiteiServiceEntity.getHomonkaigoKemmuHijokinshaNinsu()));
        }

        @Test
        public void get訪問介護員数_常勤換算後の人数_は_entityが持つ訪問介護員数_常勤換算後の人数_を返す() {
            assertThat(sut.get訪問介護員数_常勤換算後の人数_(), is(KaigoJigyoshaShiteiServiceEntity.getHomonkaigoJokinKanzangoNinsu()));
        }

        @Test
        public void get利用定員数は_entityが持つ利用定員数を返す() {
            assertThat(sut.get利用定員数(), is(KaigoJigyoshaShiteiServiceEntity.getRiyoTeiinNinsu()));
        }

        @Test
        public void get指定有効開始日は_entityが持つ指定有効開始日を返す() {
            assertThat(sut.get指定有効開始日(), is(KaigoJigyoshaShiteiServiceEntity.getShiteiYukoKaishiYMD()));
        }

        @Test
        public void get指定有効終了日は_entityが持つ指定有効終了日を返す() {
            assertThat(sut.get指定有効終了日(), is(KaigoJigyoshaShiteiServiceEntity.getShiteiYukoShuryoYMD()));
        }

        @Test
        public void get指定更新申請中区分は_entityが持つ指定更新申請中区分を返す() {
            assertThat(sut.get指定更新申請中区分(), is(KaigoJigyoshaShiteiServiceEntity.getShiteiKoshinShinseichuKubun()));
        }

        @Test
        public void get効力停止開始日は_entityが持つ効力停止開始日を返す() {
            assertThat(sut.get効力停止開始日(), is(KaigoJigyoshaShiteiServiceEntity.getKoryokuTeishiKaishiYMD()));
        }

        @Test
        public void get効力停止終了日は_entityが持つ効力停止終了日を返す() {
            assertThat(sut.get効力停止終了日(), is(KaigoJigyoshaShiteiServiceEntity.getKoryokuTeishiShuryoYMD()));
        }

        @Test
        public void get大規模事業所該当の有無は_entityが持つ大規模事業所該当の有無を返す() {
            assertThat(sut.get大規模事業所該当の有無(), is(KaigoJigyoshaShiteiServiceEntity.getDaikiboJigyoshaGaito_umu()));
        }

        @Test
        public void get準ユニットケア体制の有無は_entityが持つ準ユニットケア体制の有無を返す() {
            assertThat(sut.get準ユニットケア体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getJunUnitCareTaisei_umu()));
        }

        @Test
        public void get重度化対応体制の有無は_entityが持つ重度化対応体制の有無を返す() {
            assertThat(sut.get重度化対応体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getJudokaTaioTaisei_umu()));
        }

        @Test
        public void get医療連携体制の有無は_entityが持つ医療連携体制の有無を返す() {
            assertThat(sut.get医療連携体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getIryoRenkeiTaisei_umu()));
        }

        @Test
        public void getユニットケア体制の有無は_entityが持つユニットケア体制の有無を返す() {
            assertThat(sut.getユニットケア体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getUnitCareTaisei_umu()));
        }

        @Test
        public void get在宅_入所相互利用体制の有無は_entityが持つ在宅_入所相互利用体制の有無を返す() {
            assertThat(sut.get在宅_入所相互利用体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getZaitaku_nyushoSogoRiyoTaisei_umu()));
        }

        @Test
        public void getターミナルケア体制_看取り介護体制_の有無は_entityが持つターミナルケア体制_看取り介護体制_の有無を返す() {
            assertThat(sut.getターミナルケア体制_看取り介護体制_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getTerminalCareTaisei_umu()));
        }

        @Test
        public void get身体拘束廃止取組の有無は_entityが持つ身体拘束廃止取組の有無を返す() {
            assertThat(sut.get身体拘束廃止取組の有無(), is(KaigoJigyoshaShiteiServiceEntity.getShintaiKosokuHaishiTorikumi_umu()));
        }

        @Test
        public void get小規模拠点集合体制の有無は_entityが持つ小規模拠点集合体制の有無を返す() {
            assertThat(sut.get小規模拠点集合体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getShokiboKyotenShugoTaisei_umu()));
        }

        @Test
        public void get認知症ケア加算の有無は_entityが持つ認知症ケア加算の有無を返す() {
            assertThat(sut.get認知症ケア加算の有無(), is(KaigoJigyoshaShiteiServiceEntity.getNinchishoCareKasan_umu()));
        }

        @Test
        public void get個別機能訓練体制の有無は_entityが持つ個別機能訓練体制の有無を返す() {
            assertThat(sut.get個別機能訓練体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKobetsuKinoKunrenTaisei_umu()));
        }

        @Test
        public void get個別リハビリテーション提供体制_理学療法Ⅰ_の有無は_entityが持つ個別リハビリテーション提供体制_理学療法Ⅰ_の有無を返す() {
            assertThat(sut.get個別リハビリテーション提供体制_理学療法Ⅰ_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu()));
        }

        @Test
        public void get個別リハビリテーション提供体制_理学療法Ⅱ_の有無2は_entityが持つ個別リハビリテーション提供体制_理学療法Ⅱ_の有無2を返す() {
            assertThat(sut.get個別リハビリテーション提供体制_理学療法Ⅱ_の有無2(), is(KaigoJigyoshaShiteiServiceEntity.getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2()));
        }

        @Test
        public void get個別リハビリテーション提供体制_作業療法_の有無は_entityが持つ個別リハビリテーション提供体制_作業療法_の有無を返す() {
            assertThat(sut.get個別リハビリテーション提供体制_作業療法_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKobetsuRehaTeikyoTaisei_SagyoRyoho_umu()));
        }

        @Test
        public void get個別リハビリテーション提供体制_言語聴覚療法_の有無は_entityが持つ個別リハビリテーション提供体制_言語聴覚療法_の有無を返す() {
            assertThat(sut.get個別リハビリテーション提供体制_言語聴覚療法_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu()));
        }

        @Test
        public void get個別リハビリテーション提供体制_その他_の有無は_entityが持つ個別リハビリテーション提供体制_その他_の有無を返す() {
            assertThat(sut.get個別リハビリテーション提供体制_その他_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKobetsuRehaTeikyoTaisei_Sonota_umu()));
        }

        @Test
        public void get設備基準は_entityが持つ設備基準を返す() {
            assertThat(sut.get設備基準(), is(KaigoJigyoshaShiteiServiceEntity.getSetsubiKijun()));
        }

        @Test
        public void get療養体制維持特別加算は_entityが持つ療養体制維持特別加算を返す() {
            assertThat(sut.get療養体制維持特別加算(), is(KaigoJigyoshaShiteiServiceEntity.getRyoyoTaiseiIjiTokubetsuKasan()));
        }

        @Test
        public void get個別リハビリテーション提供体制_リハビリテーション指導管理_の有無は_entityが持つ個別リハビリテーション提供体制_リハビリテーション指導管理_の有無を返す() {
            assertThat(sut.get個別リハビリテーション提供体制_リハビリテーション指導管理_の有無(), is(KaigoJigyoshaShiteiServiceEntity.getKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu()));
        }

        @Test
        public void get３級ヘルパー体制は_entityが持つ３級ヘルパー体制を返す() {
            assertThat(sut.get３級ヘルパー体制(), is(KaigoJigyoshaShiteiServiceEntity.getSankyuHelperTaisei()));
        }

        @Test
        public void get中山間地域等における小規模事業所加算_地域に関する状況_は_entityが持つ中山間地域等における小規模事業所加算_地域に関する状況_を返す() {
            assertThat(sut.get中山間地域等における小規模事業所加算_地域に関する状況_(), is(KaigoJigyoshaShiteiServiceEntity.getChuSankanChiikiShokiboJigyoshoKasan_chiiki()));
        }

        @Test
        public void get中山間地域等における小規模事業所加算_規模に関する状況_は_entityが持つ中山間地域等における小規模事業所加算_規模に関する状況_を返す() {
            assertThat(sut.get中山間地域等における小規模事業所加算_規模に関する状況_(), is(KaigoJigyoshaShiteiServiceEntity.getChuSankanChiikiShokiboJigyoushoKasan_kibo()));
        }

        @Test
        public void getサービス提供体制強化加算は_entityが持つサービス提供体制強化加算を返す() {
            assertThat(sut.getサービス提供体制強化加算(), is(KaigoJigyoshaShiteiServiceEntity.getServiceTeikyoTaiseiKyokaKasan()));
        }

        @Test
        public void get認知症短期集中リハビリテーション加算は_entityが持つ認知症短期集中リハビリテーション加算を返す() {
            assertThat(sut.get認知症短期集中リハビリテーション加算(), is(KaigoJigyoshaShiteiServiceEntity.getNinchishoTankiShuchuRehabilitationKasan()));
        }

        @Test
        public void get若年性認知症利用者_入所者_患者_受入加算は_entityが持つ若年性認知症利用者_入所者_患者_受入加算を返す() {
            assertThat(sut.get若年性認知症利用者_入所者_患者_受入加算(), is(KaigoJigyoshaShiteiServiceEntity.getJakunenseiNinchishoRiyoushaUkeeireKasan()));
        }

        @Test
        public void get看護体制加算は_entityが持つ看護体制加算を返す() {
            assertThat(sut.get看護体制加算(), is(KaigoJigyoshaShiteiServiceEntity.getKangoTaiseiKasan()));
        }

        @Test
        public void get夜勤職員配置加算は_entityが持つ夜勤職員配置加算を返す() {
            assertThat(sut.get夜勤職員配置加算(), is(KaigoJigyoshaShiteiServiceEntity.getYakinShokuinHaichiKasan()));
        }

        @Test
        public void get療養食加算は_entityが持つ療養食加算を返す() {
            assertThat(sut.get療養食加算(), is(KaigoJigyoshaShiteiServiceEntity.getRyoyoShokuKasan()));
        }

        @Test
        public void get日常生活継続支援加算は_entityが持つ日常生活継続支援加算を返す() {
            assertThat(sut.get日常生活継続支援加算(), is(KaigoJigyoshaShiteiServiceEntity.getNichijoSeikatsuKeizokuShienKasan()));
        }

        @Test
        public void get認知症専門ケア加算は_entityが持つ認知症専門ケア加算を返す() {
            assertThat(sut.get認知症専門ケア加算(), is(KaigoJigyoshaShiteiServiceEntity.getNinchishoSemmonCareKasan()));
        }

        @Test
        public void get２４時間通報対応加算は_entityが持つ２４時間通報対応加算を返す() {
            assertThat(sut.get２４時間通報対応加算(), is(KaigoJigyoshaShiteiServiceEntity.getTwentyFourHoursTsuhoTaioKasan()));
        }

        @Test
        public void get看護職員配置加算は_entityが持つ看護職員配置加算を返す() {
            assertThat(sut.get看護職員配置加算(), is(KaigoJigyoshaShiteiServiceEntity.getKangoShokuinHaichiKasan()));
        }

        @Test
        public void get夜間ケア加算は_entityが持つ夜間ケア加算を返す() {
            assertThat(sut.get夜間ケア加算(), is(KaigoJigyoshaShiteiServiceEntity.getYakanCareKasan()));
        }

        @Test
        public void get集団コミュニケーション療法の有無は_entityが持つ集団コミュニケーション療法の有無を返す() {
            assertThat(sut.get集団コミュニケーション療法の有無(), is(KaigoJigyoshaShiteiServiceEntity.getShudanCommunicationRyoho_umu()));
        }

        @Test
        public void getサービス提供体制強化加算_空床型_は_entityが持つサービス提供体制強化加算_空床型_を返す() {
            assertThat(sut.getサービス提供体制強化加算_空床型_(), is(KaigoJigyoshaShiteiServiceEntity.getServiceTeikyoTaiseiKyokaKasan_Karadokogata()));
        }

        @Test
        public void get日中の身体介護２０分未満体制の有無は_entityが持つ日中の身体介護２０分未満体制の有無を返す() {
            assertThat(sut.get日中の身体介護２０分未満体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getNitchuShintaikaigoTaise_20funmiman_umu()));
        }

        @Test
        public void getサービス提供責任者体制の有無は_entityが持つサービス提供責任者体制の有無を返す() {
            assertThat(sut.getサービス提供責任者体制の有無(), is(KaigoJigyoshaShiteiServiceEntity.getServiceTeikyoSekininshaTaisei_umu()));
        }

        @Test
        public void get同一建物に居住する利用者の減算の有無は_entityが持つ同一建物に居住する利用者の減算の有無を返す() {
            assertThat(sut.get同一建物に居住する利用者の減算の有無(), is(KaigoJigyoshaShiteiServiceEntity.getDoitsuTatemonoKyojuRiyoshaGenzan_umu()));
        }

        @Test
        public void get緊急短期入所体制確保加算は_entityが持つ緊急短期入所体制確保加算を返す() {
            assertThat(sut.get緊急短期入所体制確保加算(), is(KaigoJigyoshaShiteiServiceEntity.getKinkyuTankiNyushoTaiseiKakuhoKasan()));
        }

        @Test
        public void get在宅復帰_在宅療養支援機能加算は_entityが持つ在宅復帰_在宅療養支援機能加算を返す() {
            assertThat(sut.get在宅復帰_在宅療養支援機能加算(), is(KaigoJigyoshaShiteiServiceEntity.getZaitakuFukki_ZaitakuRyoyoShienKinoKasan()));
        }

        @Test
        public void get生活機能向上グループ活動加算は_entityが持つ生活機能向上グループ活動加算を返す() {
            assertThat(sut.get生活機能向上グループ活動加算(), is(KaigoJigyoshaShiteiServiceEntity.getSeikatuKinoKojoGroupKatsudoKasan()));
        }

        @Test
        public void get介護職員処遇改善加算は_entityが持つ介護職員処遇改善加算を返す() {
            assertThat(sut.get介護職員処遇改善加算(), is(KaigoJigyoshaShiteiServiceEntity.getKaigoShokuinShoguKaizenKasan()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static KaigoJigyoshaShiteiService sut;

        @Before
        public void setUp() {
            KaigoJigyoshaShiteiServiceEntity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaShiteiServiceEntity.setJigyoshaNo(事業者番号);
            KaigoJigyoshaShiteiServiceEntity.setServiceShuruiCode(サービス種類コード);
            KaigoJigyoshaShiteiServiceEntity.setYukoKaishiYMD(有効開始日);

            sut = new KaigoJigyoshaShiteiService(KaigoJigyoshaShiteiServiceEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KaigoJigyoshaShiteiServiceEntity));
        }
    }

    @Ignore
    public static class SerializationProxyテスト extends DbxTestBase {

        private static KaigoJigyoshaShiteiService sut;

        @Before
        public void setUp() {
            KaigoJigyoshaShiteiServiceEntity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaShiteiServiceEntity.setJigyoshaNo(事業者番号);
            KaigoJigyoshaShiteiServiceEntity.setServiceShuruiCode(サービス種類コード);
            KaigoJigyoshaShiteiServiceEntity.setYukoKaishiYMD(有効開始日);

            sut = new KaigoJigyoshaShiteiService(KaigoJigyoshaShiteiServiceEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static KaigoJigyoshaShiteiService sut;
        private static KaigoJigyoshaShiteiService result;

        @Before
        public void setUp() {
            KaigoJigyoshaShiteiServiceEntity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaShiteiServiceEntity.setJigyoshaNo(事業者番号);
            KaigoJigyoshaShiteiServiceEntity.setServiceShuruiCode(サービス種類コード);
            KaigoJigyoshaShiteiServiceEntity.setYukoKaishiYMD(有効開始日);

        }

        @Test
        public void KaigoJigyoshaShiteiServiceが保持するDbT7063KaigoJigyoshaShiteiServiceEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoJigyoshaShiteiServiceが保持するDbT7063KaigoJigyoshaShiteiServiceEntityのEntityDataStateがDeletedに指定されたKaigoJigyoshaShiteiServiceが返る() {
            sut = TestSupport.setStateKaigoJigyoshaShiteiService(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoJigyoshaShiteiServiceが保持するDbT7063KaigoJigyoshaShiteiServiceEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoJigyoshaShiteiServiceが保持するDbT7063KaigoJigyoshaShiteiServiceEntityのEntityDataStateがDeletedに指定されたKaigoJigyoshaShiteiServiceが返る() {
            sut = TestSupport.setStateKaigoJigyoshaShiteiService(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoJigyoshaShiteiServiceが保持するDbT7063KaigoJigyoshaShiteiServiceEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoJigyoshaShiteiServiceが保持するDbT7063KaigoJigyoshaShiteiServiceEntityのEntityDataStateがDeletedに指定されたKaigoJigyoshaShiteiServiceが返る() {
            sut = TestSupport.setStateKaigoJigyoshaShiteiService(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoJigyoshaShiteiServiceが保持するDbT7063KaigoJigyoshaShiteiServiceEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoJigyoshaShiteiService(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KaigoJigyoshaShiteiService setStateKaigoJigyoshaShiteiService(EntityDataState parentState) {
            KaigoJigyoshaShiteiServiceEntity.setState(parentState);
            return new KaigoJigyoshaShiteiService(KaigoJigyoshaShiteiServiceEntity);
        }
    }
}
