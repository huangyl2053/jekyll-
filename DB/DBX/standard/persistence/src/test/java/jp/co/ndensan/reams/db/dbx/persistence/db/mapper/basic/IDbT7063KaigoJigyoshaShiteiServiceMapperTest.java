/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LDNS 燕京
 */
public class IDbT7063KaigoJigyoshaShiteiServiceMapperTest {

    private static IDbT7063KaigoJigyoshaShiteiServiceMapper sut;
    private static DbT7063KaigoJigyoshaShiteiServiceDac dac;
    private static DbT7063KaigoJigyoshaShiteiServiceEntity entity;
    private static DbTestHelper dbTestHelper;

    @BeforeClass
    public static void setUpClass() {
        DbxTestDacBase.setUpClassInternal();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbxTestDacBase {

        @BeforeClass
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT7063KaigoJigyoshaShiteiServiceEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
            sut = sqlSession.getMapper(IDbT7063KaigoJigyoshaShiteiServiceMapper.class);
            entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            dac.save(entity);
        }

        @Test
        public void 正しくJigyoshaNoされている() {
            assertThat(sut.getEntity().getJigyoshaNo(), is(entity.getJigyoshaNo()));
        }

        @Test
        public void 正しくServiceShuruiCodeされている() {
            assertThat(sut.getEntity().getServiceShuruiCode(), is(entity.getServiceShuruiCode()));
        }

        @Test
        public void 正しくYukoKaishiYMDされている() {
            assertThat(sut.getEntity().getYukoKaishiYMD(), is(entity.getYukoKaishiYMD()));
        }

        @Test
        public void 正しくYukoShuryoYMDされている() {
            assertThat(sut.getEntity().getYukoShuryoYMD(), is(entity.getYukoShuryoYMD()));
        }

        @Test
        public void 正しくIdoYMDされている() {
            assertThat(sut.getEntity().getIdoYMD(), is(entity.getIdoYMD()));
        }

        @Test
        public void 正しくIdoJiyuされている() {
            assertThat(sut.getEntity().getIdoJiyu(), is(entity.getIdoJiyu()));
        }

        @Test
        public void 正しくShiteiNoされている() {
            assertThat(sut.getEntity().getShiteiNo(), is(entity.getShiteiNo()));
        }

        @Test
        public void 正しくKihonJohoJunkyoKubunされている() {
            assertThat(sut.getEntity().getKihonJohoJunkyoKubun(), is(entity.getKihonJohoJunkyoKubun()));
        }

        @Test
        public void 正しくJigyoKaishiYMDされている() {
            assertThat(sut.getEntity().getJigyoKaishiYMD(), is(entity.getJigyoKaishiYMD()));
        }

        @Test
        public void 正しくJigyoKyushiYMDされている() {
            assertThat(sut.getEntity().getJigyoKyushiYMD(), is(entity.getJigyoKyushiYMD()));
        }

        @Test
        public void 正しくJigyoSaikaiYMDされている() {
            assertThat(sut.getEntity().getJigyoSaikaiYMD(), is(entity.getJigyoSaikaiYMD()));
        }

        @Test
        public void 正しくJigyoHaishiYMDされている() {
            assertThat(sut.getEntity().getJigyoHaishiYMD(), is(entity.getJigyoHaishiYMD()));
        }

        @Test
        public void 正しくJigyoshaNameされている() {
            assertThat(sut.getEntity().getJigyoshaName(), is(entity.getJigyoshaName()));
        }

        @Test
        public void 正しくJigyoshaNameKanaされている() {
            assertThat(sut.getEntity().getJigyoshaNameKana(), is(entity.getJigyoshaNameKana()));
        }

        @Test
        public void 正しくJigyoshaYubinNoされている() {
            assertThat(sut.getEntity().getJigyoshaYubinNo(), is(entity.getJigyoshaYubinNo()));
        }

        @Test
        public void 正しくJigyoshaAddressされている() {
            assertThat(sut.getEntity().getJigyoshaAddress(), is(entity.getJigyoshaAddress()));
        }

        @Test
        public void 正しくJigyoshaAddressKanaされている() {
            assertThat(sut.getEntity().getJigyoshaAddressKana(), is(entity.getJigyoshaAddressKana()));
        }

        @Test
        public void 正しくJigyoshaTelNoされている() {
            assertThat(sut.getEntity().getJigyoshaTelNo(), is(entity.getJigyoshaTelNo()));
        }

        @Test
        public void 正しくJigyoshaFaxNoされている() {
            assertThat(sut.getEntity().getJigyoshaFaxNo(), is(entity.getJigyoshaFaxNo()));
        }

        @Test
        public void 正しくTorokuHokenshaNoされている() {
            assertThat(sut.getEntity().getTorokuHokenshaNo(), is(entity.getTorokuHokenshaNo()));
        }

        @Test
        public void 正しくJuryoininUmuされている() {
            assertThat(sut.getEntity().getJuryoininUmu(), is(entity.getJuryoininUmu()));
        }

        @Test
        public void 正しくTorokuKaishiYMDされている() {
            assertThat(sut.getEntity().getTorokuKaishiYMD(), is(entity.getTorokuKaishiYMD()));
        }

        @Test
        public void 正しくTorokuShuryoYMDされている() {
            assertThat(sut.getEntity().getTorokuShuryoYMD(), is(entity.getTorokuShuryoYMD()));
        }

        @Test
        public void 正しくKanrishaNameされている() {
            assertThat(sut.getEntity().getKanrishaName(), is(entity.getKanrishaName()));
        }

        @Test
        public void 正しくKanrishaNameKanaされている() {
            assertThat(sut.getEntity().getKanrishaNameKana(), is(entity.getKanrishaNameKana()));
        }

        @Test
        public void 正しくKanrishaYubinNoされている() {
            assertThat(sut.getEntity().getKanrishaYubinNo(), is(entity.getKanrishaYubinNo()));
        }

        @Test
        public void 正しくKanrishaAddressされている() {
            assertThat(sut.getEntity().getKanrishaAddress(), is(entity.getKanrishaAddress()));
        }

        @Test
        public void 正しくKanrishaAddressKanaされている() {
            assertThat(sut.getEntity().getKanrishaAddressKana(), is(entity.getKanrishaAddressKana()));
        }

        @Test
        public void 正しくKozaJohoJunkyoKubunされている() {
            assertThat(sut.getEntity().getKozaJohoJunkyoKubun(), is(entity.getKozaJohoJunkyoKubun()));
        }

        @Test
        public void 正しくGinkoCodeされている() {
            assertThat(sut.getEntity().getGinkoCode(), is(entity.getGinkoCode()));
        }

        @Test
        public void 正しくShitenCodeされている() {
            assertThat(sut.getEntity().getShitenCode(), is(entity.getShitenCode()));
        }

        @Test
        public void 正しくKozaShubetsuされている() {
            assertThat(sut.getEntity().getKozaShubetsu(), is(entity.getKozaShubetsu()));
        }

        @Test
        public void 正しくKozaNoされている() {
            assertThat(sut.getEntity().getKozaNo(), is(entity.getKozaNo()));
        }

        @Test
        public void 正しくKozaMeigininされている() {
            assertThat(sut.getEntity().getKozaMeiginin(), is(entity.getKozaMeiginin()));
        }

        @Test
        public void 正しくKozaMeigininKanaされている() {
            assertThat(sut.getEntity().getKozaMeigininKana(), is(entity.getKozaMeigininKana()));
        }

        @Test
        public void 正しくShakaiFukushihoujinKeigenjigyouJisshi_umuされている() {
            assertThat(sut.getEntity().getShakaiFukushihoujinKeigenjigyouJisshi_umu(), is(entity.getShakaiFukushihoujinKeigenjigyouJisshi_umu()));
        }

        @Test
        public void 正しくSeikatsuhogohouShitei_umuされている() {
            assertThat(sut.getEntity().getSeikatsuhogohouShitei_umu(), is(entity.getSeikatsuhogohouShitei_umu()));
        }

        @Test
        public void 正しくShisetsunadoKubunされている() {
            assertThat(sut.getEntity().getShisetsunadoKubun(), is(entity.getShisetsunadoKubun()));
        }

        @Test
        public void 正しくJininHaichiKubunされている() {
            assertThat(sut.getEntity().getJininHaichiKubun(), is(entity.getJininHaichiKubun()));
        }

        @Test
        public void 正しくTokubetsuChiikiKasan_umuされている() {
            assertThat(sut.getEntity().getTokubetsuChiikiKasan_umu(), is(entity.getTokubetsuChiikiKasan_umu()));
        }

        @Test
        public void 正しくKinkyujiHomonkaigoKasan_umuされている() {
            assertThat(sut.getEntity().getKinkyujiHomonkaigoKasan_umu(), is(entity.getKinkyujiHomonkaigoKasan_umu()));
        }

        @Test
        public void 正しくTokubetsuKanriTaiseiされている() {
            assertThat(sut.getEntity().getTokubetsuKanriTaisei(), is(entity.getTokubetsuKanriTaisei()));
        }

        @Test
        public void 正しくKinoKunrenShidoTaisei_umuされている() {
            assertThat(sut.getEntity().getKinoKunrenShidoTaisei_umu(), is(entity.getKinoKunrenShidoTaisei_umu()));
        }

        @Test
        public void 正しくShokujiTeikyoTaisei_umuされている() {
            assertThat(sut.getEntity().getShokujiTeikyoTaisei_umu(), is(entity.getShokujiTeikyoTaisei_umu()));
        }

        @Test
        public void 正しくNyuyokuKaijoTaisei_umuされている() {
            assertThat(sut.getEntity().getNyuyokuKaijoTaisei_umu(), is(entity.getNyuyokuKaijoTaisei_umu()));
        }

        @Test
        public void 正しくTokubetsuNyuyokuKaijoTaisei_umuされている() {
            assertThat(sut.getEntity().getTokubetsuNyuyokuKaijoTaisei_umu(), is(entity.getTokubetsuNyuyokuKaijoTaisei_umu()));
        }

        @Test
        public void 正しくJoukinsenjuIshiHaichi_umuされている() {
            assertThat(sut.getEntity().getJoukinsenjuIshiHaichi_umu(), is(entity.getJoukinsenjuIshiHaichi_umu()));
        }

        @Test
        public void 正しくIshiHaichiKijunされている() {
            assertThat(sut.getEntity().getIshiHaichiKijun(), is(entity.getIshiHaichiKijun()));
        }

        @Test
        public void 正しくSeisinkaIshiTeikitekiRyouyousidou_umuされている() {
            assertThat(sut.getEntity().getSeisinkaIshiTeikitekiRyouyousidou_umu(), is(entity.getSeisinkaIshiTeikitekiRyouyousidou_umu()));
        }

        @Test
        public void 正しくYakanKinmuJokenKijunされている() {
            assertThat(sut.getEntity().getYakanKinmuJokenKijun(), is(entity.getYakanKinmuJokenKijun()));
        }

        @Test
        public void 正しくNinchishouSenmontou_umuされている() {
            assertThat(sut.getEntity().getNinchishouSenmontou_umu(), is(entity.getNinchishouSenmontou_umu()));
        }

        @Test
        public void 正しくShokujiTeikyoJokyoされている() {
            assertThat(sut.getEntity().getShokujiTeikyoJokyo(), is(entity.getShokujiTeikyoJokyo()));
        }

        @Test
        public void 正しくSougeiTaiseiされている() {
            assertThat(sut.getEntity().getSougeiTaisei(), is(entity.getSougeiTaisei()));
        }

        @Test
        public void 正しくRehaTeikyoTaisei_SogoRehaShisetsu_umuされている() {
            assertThat(sut.getEntity().getRehaTeikyoTaisei_SogoRehaShisetsu_umu(), is(entity.getRehaTeikyoTaisei_SogoRehaShisetsu_umu()));
        }

        @Test
        public void 正しくRehaTeikyoTaisei_RigakuRyohoII_umuされている() {
            assertThat(sut.getEntity().getRehaTeikyoTaisei_RigakuRyohoII_umu(), is(entity.getRehaTeikyoTaisei_RigakuRyohoII_umu()));
        }

        @Test
        public void 正しくRehaTeikyoTaisei_RigakuRyohoIII_umuされている() {
            assertThat(sut.getEntity().getRehaTeikyoTaisei_RigakuRyohoIII_umu(), is(entity.getRehaTeikyoTaisei_RigakuRyohoIII_umu()));
        }

        @Test
        public void 正しくRehaTeikyoTaisei_SagyoRyohoII_umuされている() {
            assertThat(sut.getEntity().getRehaTeikyoTaisei_SagyoRyohoII_umu(), is(entity.getRehaTeikyoTaisei_SagyoRyohoII_umu()));
        }

        @Test
        public void 正しくRehaTeikyoTaisei_SeisinkaSagyouRyoho_umuされている() {
            assertThat(sut.getEntity().getRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu(), is(entity.getRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu()));
        }

        @Test
        public void 正しくRehaTeikyoTaisei_Sonota_umuされている() {
            assertThat(sut.getEntity().getRehaTeikyoTaisei_Sonota_umu(), is(entity.getRehaTeikyoTaisei_Sonota_umu()));
        }

        @Test
        public void 正しくRehabilitationKasanJokyoされている() {
            assertThat(sut.getEntity().getRehabilitationKasanJokyo(), is(entity.getRehabilitationKasanJokyo()));
        }

        @Test
        public void 正しくRyoyoKankyoKijunされている() {
            assertThat(sut.getEntity().getRyoyoKankyoKijun(), is(entity.getRyoyoKankyoKijun()));
        }

        @Test
        public void 正しくIshiKetuinGenzanJokyo_umuされている() {
            assertThat(sut.getEntity().getIshiKetuinGenzanJokyo_umu(), is(entity.getIshiKetuinGenzanJokyo_umu()));
        }

        @Test
        public void 正しくKangoShokuinKetsuinGenzanJokyo_umuされている() {
            assertThat(sut.getEntity().getKangoShokuinKetsuinGenzanJokyo_umu(), is(entity.getKangoShokuinKetsuinGenzanJokyo_umu()));
        }

        @Test
        public void 正しくRigakuRyouhousiKetsuinGenzanJokyo_umuされている() {
            assertThat(sut.getEntity().getRigakuRyouhousiKetsuinGenzanJokyo_umu(), is(entity.getRigakuRyouhousiKetsuinGenzanJokyo_umu()));
        }

        @Test
        public void 正しくSagyouRyouhousiKetsuinGenzanJokyo_umuされている() {
            assertThat(sut.getEntity().getSagyouRyouhousiKetsuinGenzanJokyo_umu(), is(entity.getSagyouRyouhousiKetsuinGenzanJokyo_umu()));
        }

        @Test
        public void 正しくKaigoShokuinKetsuinGenzanJokyo_umuされている() {
            assertThat(sut.getEntity().getKaigoShokuinKetsuinGenzanJokyo_umu(), is(entity.getKaigoShokuinKetsuinGenzanJokyo_umu()));
        }

        @Test
        public void 正しくKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umuされている() {
            assertThat(sut.getEntity().getKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu(), is(entity.getKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu()));
        }

        @Test
        public void 正しくKaigoJujishaKetsuinGenzanJokyo_umuされている() {
            assertThat(sut.getEntity().getKaigoJujishaKetsuinGenzanJokyo_umu(), is(entity.getKaigoJujishaKetsuinGenzanJokyo_umu()));
        }

        @Test
        public void 正しくKansenTaisakuSidoKanri_umuされている() {
            assertThat(sut.getEntity().getKansenTaisakuSidoKanri_umu(), is(entity.getKansenTaisakuSidoKanri_umu()));
        }

        @Test
        public void 正しくJushoHifuKaiyouShidoKanri_umuされている() {
            assertThat(sut.getEntity().getJushoHifuKaiyouShidoKanri_umu(), is(entity.getJushoHifuKaiyouShidoKanri_umu()));
        }

        @Test
        public void 正しくYakuzaiKaniriShido_umuされている() {
            assertThat(sut.getEntity().getYakuzaiKaniriShido_umu(), is(entity.getYakuzaiKaniriShido_umu()));
        }

        @Test
        public void 正しくShogaishaSeikatsuShienTaisei_umuされている() {
            assertThat(sut.getEntity().getShogaishaSeikatsuShienTaisei_umu(), is(entity.getShogaishaSeikatsuShienTaisei_umu()));
        }

        @Test
        public void 正しくChiikiKubunCodeされている() {
            assertThat(sut.getEntity().getChiikiKubunCode(), is(entity.getChiikiKubunCode()));
        }

        @Test
        public void 正しくJikanEnchoServiceTaiseiされている() {
            assertThat(sut.getEntity().getJikanEnchoServiceTaisei(), is(entity.getJikanEnchoServiceTaisei()));
        }

        @Test
        public void 正しくKobetsuRehabilitationTeikyoTaiseiされている() {
            assertThat(sut.getEntity().getKobetsuRehabilitationTeikyoTaisei(), is(entity.getKobetsuRehabilitationTeikyoTaisei()));
        }

        @Test
        public void 正しくKyojuhiTaisakuされている() {
            assertThat(sut.getEntity().getKyojuhiTaisaku(), is(entity.getKyojuhiTaisaku()));
        }

        @Test
        public void 正しくYakanCare_umuされている() {
            assertThat(sut.getEntity().getYakanCare_umu(), is(entity.getYakanCare_umu()));
        }

        @Test
        public void 正しくRehabilitationKinoKyoka_umuされている() {
            assertThat(sut.getEntity().getRehabilitationKinoKyoka_umu(), is(entity.getRehabilitationKinoKyoka_umu()));
        }

        @Test
        public void 正しくKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umuされている() {
            assertThat(sut.getEntity().getKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu(), is(entity.getKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu()));
        }

        @Test
        public void 正しくKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1されている() {
            assertThat(sut.getEntity().getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1(), is(entity.getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1()));
        }

        @Test
        public void 正しくKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umuされている() {
            assertThat(sut.getEntity().getKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu(), is(entity.getKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu()));
        }

        @Test
        public void 正しくKobetsuRehaTeikyoTaisei_SagyoRyohoII_umuされている() {
            assertThat(sut.getEntity().getKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu(), is(entity.getKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu()));
        }

        @Test
        public void 正しくKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umuされている() {
            assertThat(sut.getEntity().getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu(), is(entity.getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu()));
        }

        @Test
        public void 正しくKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umuされている() {
            assertThat(sut.getEntity().getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu(), is(entity.getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu()));
        }

        @Test
        public void 正しくGengoChokakushiKetsuinGenzanJokyo_umuされている() {
            assertThat(sut.getEntity().getGengoChokakushiKetsuinGenzanJokyo_umu(), is(entity.getGengoChokakushiKetsuinGenzanJokyo_umu()));
        }

        @Test
        public void 正しくEiyouKanriHyokaされている() {
            assertThat(sut.getEntity().getEiyouKanriHyoka(), is(entity.getEiyouKanriHyoka()));
        }

        @Test
        public void 正しくTokuteijigyoushoKasan_HomonKaigo_umuされている() {
            assertThat(sut.getEntity().getTokuteijigyoushoKasan_HomonKaigo_umu(), is(entity.getTokuteijigyoushoKasan_HomonKaigo_umu()));
        }

        @Test
        public void 正しくJakunenseiNinchishoCareTaisei_umuされている() {
            assertThat(sut.getEntity().getJakunenseiNinchishoCareTaisei_umu(), is(entity.getJakunenseiNinchishoCareTaisei_umu()));
        }

        @Test
        public void 正しくUndokiKinoKojoTaisei_umuされている() {
            assertThat(sut.getEntity().getUndokiKinoKojoTaisei_umu(), is(entity.getUndokiKinoKojoTaisei_umu()));
        }

        @Test
        public void 正しくEiyoManagement_KaizenTaisei_umuされている() {
            assertThat(sut.getEntity().getEiyoManagement_KaizenTaisei_umu(), is(entity.getEiyoManagement_KaizenTaisei_umu()));
        }

        @Test
        public void 正しくKokuKinoKojoTaisei_umuされている() {
            assertThat(sut.getEntity().getKokuKinoKojoTaisei_umu(), is(entity.getKokuKinoKojoTaisei_umu()));
        }

        @Test
        public void 正しくJigyoshoHyokaKasan_Moshide_umuされている() {
            assertThat(sut.getEntity().getJigyoshoHyokaKasan_Moshide_umu(), is(entity.getJigyoshoHyokaKasan_Moshide_umu()));
        }

        @Test
        public void 正しくJigyoshoHyokaKasan_Kettei_umuされている() {
            assertThat(sut.getEntity().getJigyoshoHyokaKasan_Kettei_umu(), is(entity.getJigyoshoHyokaKasan_Kettei_umu()));
        }

        @Test
        public void 正しくKinkyuUkeireTaisei_umuされている() {
            assertThat(sut.getEntity().getKinkyuUkeireTaisei_umu(), is(entity.getKinkyuUkeireTaisei_umu()));
        }

        @Test
        public void 正しくYakanKangoTaisei_umuされている() {
            assertThat(sut.getEntity().getYakanKangoTaisei_umu(), is(entity.getYakanKangoTaisei_umu()));
        }

        @Test
        public void 正しくTokuteijigyoshoKasan_Kyotakukaigoshien_umuされている() {
            assertThat(sut.getEntity().getTokuteijigyoshoKasan_Kyotakukaigoshien_umu(), is(entity.getTokuteijigyoshoKasan_Kyotakukaigoshien_umu()));
        }

        @Test
        public void 正しくKaigoShienSemmoninSenjuJokinshaNinsuされている() {
            assertThat(sut.getEntity().getKaigoShienSemmoninSenjuJokinshaNinsu(), is(entity.getKaigoShienSemmoninSenjuJokinshaNinsu()));
        }

        @Test
        public void 正しくKaigoSienSemmoninSenjuHijokinshaNinsuされている() {
            assertThat(sut.getEntity().getKaigoSienSemmoninSenjuHijokinshaNinsu(), is(entity.getKaigoSienSemmoninSenjuHijokinshaNinsu()));
        }

        @Test
        public void 正しくKaigoSienSemmoninKemmuJokinshaNinsuされている() {
            assertThat(sut.getEntity().getKaigoSienSemmoninKemmuJokinshaNinsu(), is(entity.getKaigoSienSemmoninKemmuJokinshaNinsu()));
        }

        @Test
        public void 正しくKaigoSienSemmoninKemmuHijokinshaNinsuされている() {
            assertThat(sut.getEntity().getKaigoSienSemmoninKemmuHijokinshaNinsu(), is(entity.getKaigoSienSemmoninKemmuHijokinshaNinsu()));
        }

        @Test
        public void 正しくHomonkaigoServiceTeikyoSekininshaNinsuされている() {
            assertThat(sut.getEntity().getHomonkaigoServiceTeikyoSekininshaNinsu(), is(entity.getHomonkaigoServiceTeikyoSekininshaNinsu()));
        }

        @Test
        public void 正しくHomonkaigoSenjuJokinshaNinsuされている() {
            assertThat(sut.getEntity().getHomonkaigoSenjuJokinshaNinsu(), is(entity.getHomonkaigoSenjuJokinshaNinsu()));
        }

        @Test
        public void 正しくHomonkaigoSenjuHijokinshaNinsuされている() {
            assertThat(sut.getEntity().getHomonkaigoSenjuHijokinshaNinsu(), is(entity.getHomonkaigoSenjuHijokinshaNinsu()));
        }

        @Test
        public void 正しくHomonkaigoKemmuJokinshaNinsuされている() {
            assertThat(sut.getEntity().getHomonkaigoKemmuJokinshaNinsu(), is(entity.getHomonkaigoKemmuJokinshaNinsu()));
        }

        @Test
        public void 正しくHomonkaigoKemmuHijokinshaNinsuされている() {
            assertThat(sut.getEntity().getHomonkaigoKemmuHijokinshaNinsu(), is(entity.getHomonkaigoKemmuHijokinshaNinsu()));
        }

        @Test
        public void 正しくHomonkaigoJokinKanzangoNinsuされている() {
            assertThat(sut.getEntity().getHomonkaigoJokinKanzangoNinsu(), is(entity.getHomonkaigoJokinKanzangoNinsu()));
        }

        @Test
        public void 正しくRiyoTeiinNinsuされている() {
            assertThat(sut.getEntity().getRiyoTeiinNinsu(), is(entity.getRiyoTeiinNinsu()));
        }

        @Test
        public void 正しくShiteiYukoKaishiYMDされている() {
            assertThat(sut.getEntity().getShiteiYukoKaishiYMD(), is(entity.getShiteiYukoKaishiYMD()));
        }

        @Test
        public void 正しくShiteiYukoShuryoYMDされている() {
            assertThat(sut.getEntity().getShiteiYukoShuryoYMD(), is(entity.getShiteiYukoShuryoYMD()));
        }

        @Test
        public void 正しくShiteiKoshinShinseichuKubunされている() {
            assertThat(sut.getEntity().getShiteiKoshinShinseichuKubun(), is(entity.getShiteiKoshinShinseichuKubun()));
        }

        @Test
        public void 正しくKoryokuTeishiKaishiYMDされている() {
            assertThat(sut.getEntity().getKoryokuTeishiKaishiYMD(), is(entity.getKoryokuTeishiKaishiYMD()));
        }

        @Test
        public void 正しくKoryokuTeishiShuryoYMDされている() {
            assertThat(sut.getEntity().getKoryokuTeishiShuryoYMD(), is(entity.getKoryokuTeishiShuryoYMD()));
        }

        @Test
        public void 正しくDaikiboJigyoshaGaito_umuされている() {
            assertThat(sut.getEntity().getDaikiboJigyoshaGaito_umu(), is(entity.getDaikiboJigyoshaGaito_umu()));
        }

        @Test
        public void 正しくJunUnitCareTaisei_umuされている() {
            assertThat(sut.getEntity().getJunUnitCareTaisei_umu(), is(entity.getJunUnitCareTaisei_umu()));
        }

        @Test
        public void 正しくJudokaTaioTaisei_umuされている() {
            assertThat(sut.getEntity().getJudokaTaioTaisei_umu(), is(entity.getJudokaTaioTaisei_umu()));
        }

        @Test
        public void 正しくIryoRenkeiTaisei_umuされている() {
            assertThat(sut.getEntity().getIryoRenkeiTaisei_umu(), is(entity.getIryoRenkeiTaisei_umu()));
        }

        @Test
        public void 正しくUnitCareTaisei_umuされている() {
            assertThat(sut.getEntity().getUnitCareTaisei_umu(), is(entity.getUnitCareTaisei_umu()));
        }

        @Test
        public void 正しくZaitaku_nyushoSogoRiyoTaisei_umuされている() {
            assertThat(sut.getEntity().getZaitaku_nyushoSogoRiyoTaisei_umu(), is(entity.getZaitaku_nyushoSogoRiyoTaisei_umu()));
        }

        @Test
        public void 正しくTerminalCareTaisei_umuされている() {
            assertThat(sut.getEntity().getTerminalCareTaisei_umu(), is(entity.getTerminalCareTaisei_umu()));
        }

        @Test
        public void 正しくShintaiKosokuHaishiTorikumi_umuされている() {
            assertThat(sut.getEntity().getShintaiKosokuHaishiTorikumi_umu(), is(entity.getShintaiKosokuHaishiTorikumi_umu()));
        }

        @Test
        public void 正しくShokiboKyotenShugoTaisei_umuされている() {
            assertThat(sut.getEntity().getShokiboKyotenShugoTaisei_umu(), is(entity.getShokiboKyotenShugoTaisei_umu()));
        }

        @Test
        public void 正しくNinchishoCareKasan_umuされている() {
            assertThat(sut.getEntity().getNinchishoCareKasan_umu(), is(entity.getNinchishoCareKasan_umu()));
        }

        @Test
        public void 正しくKobetsuKinoKunrenTaisei_umuされている() {
            assertThat(sut.getEntity().getKobetsuKinoKunrenTaisei_umu(), is(entity.getKobetsuKinoKunrenTaisei_umu()));
        }

        @Test
        public void 正しくKobetsuRehaTeikyoTaisei_RigakuRyohoI_umuされている() {
            assertThat(sut.getEntity().getKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu(), is(entity.getKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu()));
        }

        @Test
        public void 正しくKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2されている() {
            assertThat(sut.getEntity().getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2(), is(entity.getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2()));
        }

        @Test
        public void 正しくKobetsuRehaTeikyoTaisei_SagyoRyoho_umuされている() {
            assertThat(sut.getEntity().getKobetsuRehaTeikyoTaisei_SagyoRyoho_umu(), is(entity.getKobetsuRehaTeikyoTaisei_SagyoRyoho_umu()));
        }

        @Test
        public void 正しくKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umuされている() {
            assertThat(sut.getEntity().getKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu(), is(entity.getKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu()));
        }

        @Test
        public void 正しくKobetsuRehaTeikyoTaisei_Sonota_umuされている() {
            assertThat(sut.getEntity().getKobetsuRehaTeikyoTaisei_Sonota_umu(), is(entity.getKobetsuRehaTeikyoTaisei_Sonota_umu()));
        }

        @Test
        public void 正しくSetsubiKijunされている() {
            assertThat(sut.getEntity().getSetsubiKijun(), is(entity.getSetsubiKijun()));
        }

        @Test
        public void 正しくRyoyoTaiseiIjiTokubetsuKasanされている() {
            assertThat(sut.getEntity().getRyoyoTaiseiIjiTokubetsuKasan(), is(entity.getRyoyoTaiseiIjiTokubetsuKasan()));
        }

        @Test
        public void 正しくKobetsuRehaTeikyoTaisei_RehaShidoKanri_umuされている() {
            assertThat(sut.getEntity().getKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu(), is(entity.getKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu()));
        }

        @Test
        public void 正しくSankyuHelperTaiseiされている() {
            assertThat(sut.getEntity().getSankyuHelperTaisei(), is(entity.getSankyuHelperTaisei()));
        }

        @Test
        public void 正しくChuSankanChiikiShokiboJigyoshoKasan_chiikiされている() {
            assertThat(sut.getEntity().getChuSankanChiikiShokiboJigyoshoKasan_chiiki(), is(entity.getChuSankanChiikiShokiboJigyoshoKasan_chiiki()));
        }

        @Test
        public void 正しくChuSankanChiikiShokiboJigyoushoKasan_kiboされている() {
            assertThat(sut.getEntity().getChuSankanChiikiShokiboJigyoushoKasan_kibo(), is(entity.getChuSankanChiikiShokiboJigyoushoKasan_kibo()));
        }

        @Test
        public void 正しくServiceTeikyoTaiseiKyokaKasanされている() {
            assertThat(sut.getEntity().getServiceTeikyoTaiseiKyokaKasan(), is(entity.getServiceTeikyoTaiseiKyokaKasan()));
        }

        @Test
        public void 正しくNinchishoTankiShuchuRehabilitationKasanされている() {
            assertThat(sut.getEntity().getNinchishoTankiShuchuRehabilitationKasan(), is(entity.getNinchishoTankiShuchuRehabilitationKasan()));
        }

        @Test
        public void 正しくJakunenseiNinchishoRiyoushaUkeeireKasanされている() {
            assertThat(sut.getEntity().getJakunenseiNinchishoRiyoushaUkeeireKasan(), is(entity.getJakunenseiNinchishoRiyoushaUkeeireKasan()));
        }

        @Test
        public void 正しくKangoTaiseiKasanされている() {
            assertThat(sut.getEntity().getKangoTaiseiKasan(), is(entity.getKangoTaiseiKasan()));
        }

        @Test
        public void 正しくYakinShokuinHaichiKasanされている() {
            assertThat(sut.getEntity().getYakinShokuinHaichiKasan(), is(entity.getYakinShokuinHaichiKasan()));
        }

        @Test
        public void 正しくRyoyoShokuKasanされている() {
            assertThat(sut.getEntity().getRyoyoShokuKasan(), is(entity.getRyoyoShokuKasan()));
        }

        @Test
        public void 正しくNichijoSeikatsuKeizokuShienKasanされている() {
            assertThat(sut.getEntity().getNichijoSeikatsuKeizokuShienKasan(), is(entity.getNichijoSeikatsuKeizokuShienKasan()));
        }

        @Test
        public void 正しくNinchishoSemmonCareKasanされている() {
            assertThat(sut.getEntity().getNinchishoSemmonCareKasan(), is(entity.getNinchishoSemmonCareKasan()));
        }

        @Test
        public void 正しくTwentyFourHoursTsuhoTaioKasanされている() {
            assertThat(sut.getEntity().getTwentyFourHoursTsuhoTaioKasan(), is(entity.getTwentyFourHoursTsuhoTaioKasan()));
        }

        @Test
        public void 正しくKangoShokuinHaichiKasanされている() {
            assertThat(sut.getEntity().getKangoShokuinHaichiKasan(), is(entity.getKangoShokuinHaichiKasan()));
        }

        @Test
        public void 正しくYakanCareKasanされている() {
            assertThat(sut.getEntity().getYakanCareKasan(), is(entity.getYakanCareKasan()));
        }

        @Test
        public void 正しくShudanCommunicationRyoho_umuされている() {
            assertThat(sut.getEntity().getShudanCommunicationRyoho_umu(), is(entity.getShudanCommunicationRyoho_umu()));
        }

        @Test
        public void 正しくServiceTeikyoTaiseiKyokaKasan_Karadokogataされている() {
            assertThat(sut.getEntity().getServiceTeikyoTaiseiKyokaKasan_Karadokogata(), is(entity.getServiceTeikyoTaiseiKyokaKasan_Karadokogata()));
        }

        @Test
        public void 正しくNitchuShintaikaigoTaise_20funmiman_umuされている() {
            assertThat(sut.getEntity().getNitchuShintaikaigoTaise_20funmiman_umu(), is(entity.getNitchuShintaikaigoTaise_20funmiman_umu()));
        }

        @Test
        public void 正しくServiceTeikyoSekininshaTaisei_umuされている() {
            assertThat(sut.getEntity().getServiceTeikyoSekininshaTaisei_umu(), is(entity.getServiceTeikyoSekininshaTaisei_umu()));
        }

        @Test
        public void 正しくDoitsuTatemonoKyojuRiyoshaGenzan_umuされている() {
            assertThat(sut.getEntity().getDoitsuTatemonoKyojuRiyoshaGenzan_umu(), is(entity.getDoitsuTatemonoKyojuRiyoshaGenzan_umu()));
        }

        @Test
        public void 正しくKinkyuTankiNyushoTaiseiKakuhoKasanされている() {
            assertThat(sut.getEntity().getKinkyuTankiNyushoTaiseiKakuhoKasan(), is(entity.getKinkyuTankiNyushoTaiseiKakuhoKasan()));
        }

        @Test
        public void 正しくZaitakuFukki_ZaitakuRyoyoShienKinoKasanされている() {
            assertThat(sut.getEntity().getZaitakuFukki_ZaitakuRyoyoShienKinoKasan(), is(entity.getZaitakuFukki_ZaitakuRyoyoShienKinoKasan()));
        }

        @Test
        public void 正しくSeikatuKinoKojoGroupKatsudoKasanされている() {
            assertThat(sut.getEntity().getSeikatuKinoKojoGroupKatsudoKasan(), is(entity.getSeikatuKinoKojoGroupKatsudoKasan()));
        }

        @Test
        public void 正しくKaigoShokuinShoguKaizenKasanされている() {
            assertThat(sut.getEntity().getKaigoShokuinShoguKaizenKasan(), is(entity.getKaigoShokuinShoguKaizenKasan()));
        }
    }
}
