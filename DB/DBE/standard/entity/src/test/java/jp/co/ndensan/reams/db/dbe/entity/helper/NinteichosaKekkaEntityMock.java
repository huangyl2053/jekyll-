/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5008NinteichosaKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.*;
import static org.mockito.Mockito.spy;

/**
 * NinteichosaKekkaEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaKekkaEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private NinteichosaKekkaEntityMock() {
    }

    /**
     * DbT5008NinteichosaKekkaJohoEntityを生成して返します。
     *
     * @return DbT5008NinteichosaKekkaJohoEntity
     */
    public static DbT5008NinteichosaKekkaJohoEntity getSpiedDbT5008NinteichosaKekkaJohoEntityInstance() {
        DbT5008NinteichosaKekkaJohoEntity entity = new DbT5008NinteichosaKekkaJohoEntity();
        entity.setShinseishoKanriNo(new RString("1234567890"));
        entity.setNinteichosaRirekiNo(0);
        entity.setNinteichousaIraiKubunCode(NinteichosaIraiKubunCode.初回.getCode());
        entity.setNinteichosaJisshiYMD(new FlexibleDate("20140101"));
        entity.setNinteiChosaKubunCode(ChosaKubun.新規調査.getCode());
        entity.setChosaJisshiBashoCode(new RString("12345678"));
        entity.setChosaJisshiBashoMeisho(new RString("認定調査実施場所名称"));
        entity.setGenzainoJokyoCode(new RString("3"));
        entity.setServiceKubunCode(new RString("2"));
        entity.setHomonKaigo(0);
        entity.setHomonNyuyokuKaigo(1);
        entity.setHomonKango(2);
        entity.setHomonRehabilitation(3);
        entity.setKyotakuRyoyoKanriShido(4);
        entity.setTushoKaigo(5);
        entity.setTushoRehabilitation(6);
        entity.setTankiNyushoSeikatsuKaigo(7);
        entity.setTankiNyushoRyoyoKaigo(8);
        entity.setTokuteiShisetsuNyushoshaSeikatsuKaigo(9);
        entity.setHukushiYoguTaiyo(0);
        entity.setTokuteiHukushiYoguHanbai(1);
        entity.setJutakuKaishu(2);
        entity.setYakanTaiogataHomonKaigo(3);
        entity.setNinchishoTaiogataTushoKaigo(4);
        entity.setShokiboTakinogataKyotakuKaigo(5);
        entity.setNinchishoTaiogataKyodoSeikatsuKaigo(6);
        entity.setChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo(7);
        entity.setChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo(8);
        entity.setTeikijunkaiZuijiTaiogataHomonKaigoKango(9);
        entity.setHukugogataService(0);
        entity.setShichosonTokubetsuKyufu(new RString("市町村特別給付"));
        entity.setKaigohokenKyufuIgaiNoZaitakuService(new RString("介護保険給付以外の在宅サービス"));
        entity.setRiyoShisetsuCode(new RString("利用施設コード"));
        entity.setRiyoShisetsuShimei(new RString("利用施設名"));
        entity.setRiyoShisetsuJusho(new RString("利用施設住所"));
        entity.setRiyoShisetsuTelNo(new RString("利用施設電話番号"));
        entity.setRiyoShisetsuYubinNo(new RString("利用施設郵便番号"));
        entity.setGaikyochosaTokkijiko(new RString("概況特記事項"));
        entity.setShogaiNichijoSeikatsuJiritsudoCode(ShogaiJiritsu.Ａ１.getCode());
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(NinchishoJiritsu.Ⅱａ.getCode());
        entity.setShinsakaiYusenWaritsukeKubunCode(ShinsakaiFuriwakeKubun.希望無し.getCode());
        return spy(entity);
    }

    /**
     * DbT5009NinteichosahyoJohoEntityを生成して返します。
     *
     * @return DbT5009NinteichosahyoJohoEntity
     */
    public static DbT5009NinteichosahyoJohoEntity getSpiedDbT5009NinteichosahyoJohoEntityInstance() {
        DbT5009NinteichosahyoJohoEntity entity = new DbT5009NinteichosahyoJohoEntity();
        entity.setShinseishoKanriNo(new RString("1234567890"));
        entity.setNinteichosaRirekiNo(0);
        entity.setCk_mahiHidariJoshi(NaiAru.ない.getCode());
        entity.setCk_mahiMigiJoshi(NaiAru.ある.getCode());
        entity.setCk_mahiHidariKashi(NaiAru.ない.getCode());
        entity.setCk_mahiMigiKashi(NaiAru.ある.getCode());
        entity.setCk_mahiSonota(NaiAru.ない.getCode());
        entity.setCk_koshukuKata(NaiAru.ない.getCode());
        entity.setCk_koshukuMata(NaiAru.ある.getCode());
        entity.setCk_koshukuHiza(NaiAru.ない.getCode());
        entity.setCk_koshukuSonota(NaiAru.ある.getCode());
        entity.setCk_negaeri(DekiruDekinai3.できる.getCode());
        entity.setCk_okiagari(DekiruDekinai3.できない.getCode());
        entity.setCk_zaihoji(DekiruDekinai6.できる.getCode());
        entity.setCk_ryoashiRitsui(DekiruDekinai5.できない.getCode());
        entity.setCk_hoko(DekiruDekinai3.できる.getCode());
        entity.setCk_tachiagari(DekiruDekinai3.できない.getCode());
        entity.setCk_kataashiRitsui(DekiruDekinai5.できる.getCode());
        entity.setCk_senshin(Kaijo2.自立.getCode());
        entity.setCk_tumekiri(Kaijo.全介助.getCode());
        entity.setCk_shiryoku(Shiryoku.普通.getCode());
        entity.setCk_choryoku(Choryoku.判断不能.getCode());
        entity.setCk_ijo(Kaijo3.自立.getCode());
        entity.setCk_ido(Kaijo3.全介助.getCode());
        entity.setCk_enge(DekiruDekinai4.できる.getCode());
        entity.setCk_shokujiSesshu(Kaijo3.自立.getCode());
        entity.setCk_hainyo(Kaijo3.全介助.getCode());
        entity.setCk_haiben(Kaijo3.自立.getCode());
        entity.setCk_kokoSeiketsu(Kaijo.全介助.getCode());
        entity.setCk_sengan(Kaijo.自立.getCode());
        entity.setCk_seihatsu(Kaijo.全介助.getCode());
        entity.setCk_joiChakudatsu(Kaijo3.自立.getCode());
        entity.setCk_zubonChakudatsu(Kaijo3.全介助.getCode());
        entity.setCk_gaishutsuHindo(Gaishutsu.月１回以上.getCode());
        entity.setCk_ishiDentatsu(DekiruDekinai2.できる.getCode());
        entity.setCk_nikka(DekiruDekinai.できない.getCode());
        entity.setCk_seinengappi(DekiruDekinai.できる.getCode());
        entity.setCk_tankiKioku(DekiruDekinai.できない.getCode());
        entity.setCk_namae(DekiruDekinai.できる.getCode());
        entity.setCk_kisetsu(DekiruDekinai.できない.getCode());
        entity.setCk_basho(DekiruDekinai.できる.getCode());
        entity.setCk_haikai(NaiAru2.ない.getCode());
        entity.setCk_gaishutsu(NaiAru2.ある.getCode());
        entity.setCk_higaiteki(NaiAru2.ない.getCode());
        entity.setCk_sakuwa(NaiAru2.ある.getCode());
        entity.setCk_kanjoHuantei(NaiAru2.ない.getCode());
        entity.setCk_chuyaGyakuten(NaiAru2.ある.getCode());
        entity.setCk_onajiHanashi(NaiAru2.ない.getCode());
        entity.setCk_ogoe(NaiAru2.ある.getCode());
        entity.setCk_kaigoNiTeiko(NaiAru2.ない.getCode());
        entity.setCk_ochitsuki(NaiAru2.ある.getCode());
        entity.setCk_hitoriDeDetagaru(NaiAru2.ない.getCode());
        entity.setCk_shushuheki(NaiAru2.ある.getCode());
        entity.setCk_monoYaIruiWoKowasu(NaiAru2.ない.getCode());
        entity.setCk_hidoiMonowasure(NaiAru2.ある.getCode());
        entity.setCk_hitorigotoHitoriwarai(NaiAru2.ない.getCode());
        entity.setCk_jibunKatte(NaiAru2.ある.getCode());
        entity.setCk_hanashiGaMatomaranai(NaiAru2.ない.getCode());
        entity.setCk_kusuri(Kaijo.自立.getCode());
        entity.setCk_kinsenKanri(Kaijo.全介助.getCode());
        entity.setCk_ishiKettei(DekiruDekinai7.できる.getCode());
        entity.setCk_shudanHutekio(NaiAru2.ない.getCode());
        entity.setCk_kaimono(Kaijo3.自立.getCode());
        entity.setCk_chori(Kaijo3.全介助.getCode());
        entity.setCk_tenteki(NaiAru.ない.getCode());
        entity.setCk_chushinJomyakuEiyo(NaiAru.ある.getCode());
        entity.setCk_toseki(NaiAru.ない.getCode());
        entity.setCk_stomaShochi(NaiAru.ある.getCode());
        entity.setCk_sansoRyoho(NaiAru.ない.getCode());
        entity.setCk_respirator(NaiAru.ある.getCode());
        entity.setCk_kikanSekkai(NaiAru.ない.getCode());
        entity.setCk_totsuKango(NaiAru.ある.getCode());
        entity.setCk_keikanEiyo(NaiAru.ない.getCode());
        entity.setCk_monitorSokutei(NaiAru.ある.getCode());
        entity.setCk_jokusoShochi(NaiAru.ない.getCode());
        entity.setCk_catheter(NaiAru.ある.getCode());
        return spy(entity);
    }
}
