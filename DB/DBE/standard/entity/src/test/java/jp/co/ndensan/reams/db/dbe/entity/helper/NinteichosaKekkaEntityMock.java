/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5008NinteichosaKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
     * NinteichosaKekkaEntityを生成して返します。
     *
     * @return NinteichosaKekkaEntity
     */
    public static NinteichosaKekkaEntity getSpiedNinteichosaKekkaEntityInstance() {
        NinteichosaKekkaEntity entity = new NinteichosaKekkaEntity();
        entity.setDbT5008NinteichosaKekkaJohoEntity(getSpiedDbT5008NinteichosaKekkaJohoEntityInstance());
        entity.setDbT5009NinteichosahyoJohoEntity(getSpiedDbT5009NinteichosahyoJohoEntityInstance());
        return spy(entity);
    }

    /**
     * DbT5008NinteichosaKekkaJohoEntityを生成して返します。
     *
     * @return DbT5008NinteichosaKekkaJohoEntity
     */
    public static DbT5008NinteichosaKekkaJohoEntity getSpiedDbT5008NinteichosaKekkaJohoEntityInstance() {
        DbT5008NinteichosaKekkaJohoEntity entity = new DbT5008NinteichosaKekkaJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("1234567890")));
        entity.setNinteichosaRirekiNo(0);
        entity.setKoroshoIfShikibetsuCode(new RString("09A"));
        entity.setNinteichousaIraiKubunCode(new Code(NinteichosaIraiKubunCode.初回.getCode()));
        entity.setNinteichosaIraiKaisu(1);
        entity.setNinteichosaJisshiYMD(new FlexibleDate("20140101"));
        entity.setNinteichosaJuryoYMD(new FlexibleDate("20140202"));
        entity.setNinteiChosaKubunCode(new Code(NinteichosaKubun.新規調査.getCode()));
        entity.setChosainCode(new RString("12345678"));
        entity.setChosaJisshiBashoCode(new Code(new RString("12345678")));
        entity.setChosaJisshiBashoMeisho(new RString("認定調査実施場所名称"));
        entity.setGenzainoJokyoCode(new Code(new RString("3")));
        entity.setServiceKubunCode(new Code(new RString("2")));
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
        entity.setRiyoShisetsuCode(new JigyoshaNo(new RString("利用施設コード")));
        entity.setRiyoShisetsuShimei(new RString("利用施設名"));
        entity.setRiyoShisetsuJusho(new AtenaJusho(new RString("利用施設住所")));
        entity.setRiyoShisetsuTelNo(new TelNo(new RString("利用施設電話番号")));
        entity.setRiyoShisetsuYubinNo(new YubinNo(new RString("1234567")));
        entity.setGaikyochosaTokkijiko(new RString("概況特記事項"));
        return spy(entity);
    }

    /**
     * DbT5009NinteichosahyoJohoEntityを生成して返します。
     *
     * @return DbT5009NinteichosahyoJohoEntity
     */
    public static DbT5009NinteichosahyoJohoEntity getSpiedDbT5009NinteichosahyoJohoEntityInstance() {
        DbT5009NinteichosahyoJohoEntity entity = new DbT5009NinteichosahyoJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("1234567890")));
        entity.setNinteichosaRirekiNo(0);
        entity.setKoroshoIfShikibetsuCode(new RString("09A"));
        entity.setCk_mahiHidariJoshi(NaiAru.ない.getValue());
        entity.setCk_mahiMigiJoshi(NaiAru.ある.getValue());
        entity.setCk_mahiHidariKashi(NaiAru.ない.getValue());
        entity.setCk_mahiMigiKashi(NaiAru.ある.getValue());
        entity.setCk_mahiSonota(NaiAru.ない.getValue());
        entity.setCk_koshukuKata(NaiAru.ない.getValue());
        entity.setCk_koshukuMata(NaiAru.ある.getValue());
        entity.setCk_koshukuHiza(NaiAru.ない.getValue());
        entity.setCk_koshukuSonota(NaiAru.ある.getValue());
        entity.setCk_negaeri(DekiruDekinai3.できる.getValue());
        entity.setCk_okiagari(DekiruDekinai3.できない.getValue());
        entity.setCk_zaihoji(DekiruDekinai6.できる.getValue());
        entity.setCk_ryoashiRitsui(DekiruDekinai5.できない.getValue());
        entity.setCk_hoko(DekiruDekinai3.できる.getValue());
        entity.setCk_tachiagari(DekiruDekinai3.できない.getValue());
        entity.setCk_kataashiRitsui(DekiruDekinai5.できる.getValue());
        entity.setCk_senshin(Kaijo2.自立.getValue());
        entity.setCk_tumekiri(Kaijo.全介助.getValue());
        entity.setCk_shiryoku(Shiryoku.普通.getValue());
        entity.setCk_choryoku(Choryoku.判断不能.getValue());
        entity.setCk_ijo(Kaijo3.自立.getValue());
        entity.setCk_ido(Kaijo3.全介助.getValue());
        entity.setCk_enge(DekiruDekinai4.できる.getValue());
        entity.setCk_shokujiSesshu(Kaijo3.自立.getValue());
        entity.setCk_hainyo(Kaijo3.全介助.getValue());
        entity.setCk_haiben(Kaijo3.自立.getValue());
        entity.setCk_kokoSeiketsu(Kaijo.全介助.getValue());
        entity.setCk_sengan(Kaijo.自立.getValue());
        entity.setCk_seihatsu(Kaijo.全介助.getValue());
        entity.setCk_joiChakudatsu(Kaijo3.自立.getValue());
        entity.setCk_zubonChakudatsu(Kaijo3.全介助.getValue());
        entity.setCk_gaishutsuHindo(Gaishutsu.月１回以上.getValue());
        entity.setCk_ishiDentatsu(DekiruDekinai2.できる.getValue());
        entity.setCk_nikka(DekiruDekinai.できない.getValue());
        entity.setCk_seinengappi(DekiruDekinai.できる.getValue());
        entity.setCk_tankiKioku(DekiruDekinai.できない.getValue());
        entity.setCk_namae(DekiruDekinai.できる.getValue());
        entity.setCk_kisetsu(DekiruDekinai.できない.getValue());
        entity.setCk_basho(DekiruDekinai.できる.getValue());
        entity.setCk_haikai(NaiAru2.ない.getValue());
        entity.setCk_gaishutsu(NaiAru2.ある.getValue());
        entity.setCk_higaiteki(NaiAru2.ない.getValue());
        entity.setCk_sakuwa(NaiAru2.ある.getValue());
        entity.setCk_kanjoHuantei(NaiAru2.ない.getValue());
        entity.setCk_chuyaGyakuten(NaiAru2.ある.getValue());
        entity.setCk_onajiHanashi(NaiAru2.ない.getValue());
        entity.setCk_ogoe(NaiAru2.ある.getValue());
        entity.setCk_kaigoNiTeiko(NaiAru2.ない.getValue());
        entity.setCk_ochitsuki(NaiAru2.ある.getValue());
        entity.setCk_hitoriDeDetagaru(NaiAru2.ない.getValue());
        entity.setCk_shushuheki(NaiAru2.ある.getValue());
        entity.setCk_monoYaIruiWoKowasu(NaiAru2.ない.getValue());
        entity.setCk_hidoiMonowasure(NaiAru2.ある.getValue());
        entity.setCk_hitorigotoHitoriwarai(NaiAru2.ない.getValue());
        entity.setCk_jibunKatte(NaiAru2.ある.getValue());
        entity.setCk_hanashiGaMatomaranai(NaiAru2.ない.getValue());
        entity.setCk_kusuri(Kaijo.自立.getValue());
        entity.setCk_kinsenKanri(Kaijo.全介助.getValue());
        entity.setCk_ishiKettei(DekiruDekinai7.できる.getValue());
        entity.setCk_shudanHutekio(NaiAru2.ない.getValue());
        entity.setCk_kaimono(Kaijo3.自立.getValue());
        entity.setCk_chori(Kaijo3.全介助.getValue());
        entity.setCk_tenteki(NaiAru.ない.getValue());
        entity.setCk_chushinJomyakuEiyo(NaiAru.ある.getValue());
        entity.setCk_toseki(NaiAru.ない.getValue());
        entity.setCk_stomaShochi(NaiAru.ある.getValue());
        entity.setCk_sansoRyoho(NaiAru.ない.getValue());
        entity.setCk_respirator(NaiAru.ある.getValue());
        entity.setCk_kikanSekkai(NaiAru.ない.getValue());
        entity.setCk_totsuKango(NaiAru.ある.getValue());
        entity.setCk_keikanEiyo(NaiAru.ない.getValue());
        entity.setCk_monitorSokutei(NaiAru.ある.getValue());
        entity.setCk_jokusoShochi(NaiAru.ない.getValue());
        entity.setCk_catheter(NaiAru.ある.getValue());
        entity.setShogaiNichijoSeikatsuJiritsudoCode(new Code(ShogaiJiritsu.Ａ１.getValue()));
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(new Code(NinchishoJiritsu.Ⅱａ.getValue()));
        return spy(entity);
    }
}
