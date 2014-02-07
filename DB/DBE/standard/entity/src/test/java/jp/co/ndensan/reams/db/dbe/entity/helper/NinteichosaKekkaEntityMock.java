/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun1;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun2;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun3;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun4;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun5;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubunIryo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubunJiritsu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GenzaiJokyoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ServiceKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5008NinteichosaKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteiChosaTokkijikoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
        entity.setNinteichousaIraiKubunCode(ChosaIraiKubun.初回.getCode());
        entity.setNinteichosaJisshiYMD(new FlexibleDate("20140101"));
        entity.setNinteiChosaKubunCode(ChosaKubun.新規調査.getCode());
        entity.setChosaJisshiBashoCode(new RString("12345678"));
        entity.setChosaJisshiBashoMeisho(new RString("認定調査実施場所名称"));
        entity.setGenzainoJokyoCode(GenzaiJokyoKubun.指定介護療養型医療施設.getCode());
        entity.setServiceKubunCode(ServiceKubun.介護給付サービス.getCode());
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
        entity.setGaikyochosaTokkijiko(new RString("概況特記事項"));
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(ChosaKekkaKubunJiritsu.NinchishoNichijoSeikatsu.自立.getCode());
        entity.setShogaiNichijoSeikatsuJiritsudoCode(ChosaKekkaKubunJiritsu.ShogaiNichijoSeikatsu.自立.getCode());
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
        entity.setCk_mahiHidariJoshi(ChosaKekkaKubun1.MahiHidariJoshi.ない.getCode());
        entity.setCk_mahiMigiJoshi(ChosaKekkaKubun1.MahiMigiJoshi.ある.getCode());
        entity.setCk_mahiHidariKashi(ChosaKekkaKubun1.MahiHidariKashi.ない.getCode());
        entity.setCk_mahiMigiKashi(ChosaKekkaKubun1.MahiMigiKashi.ある.getCode());
        entity.setCk_mahiSonota(ChosaKekkaKubun1.MahiSonota.ない.getCode());
        entity.setCk_koshukuKata(ChosaKekkaKubun1.KoshukuKata.ある.getCode());
        entity.setCk_koshukuMata(ChosaKekkaKubun1.KoshukuMata.ない.getCode());
        entity.setCk_koshukuHiza(ChosaKekkaKubun1.KoshukuHiza.ある.getCode());
        entity.setCk_koshukuSonota(ChosaKekkaKubun1.KoshukuSonota.ない.getCode());
        entity.setCk_negaeri(ChosaKekkaKubun1.Negaeri.できる.getCode());
        entity.setCk_okiagari(ChosaKekkaKubun1.Okiagari.できない.getCode());
        entity.setCk_zaihoji(ChosaKekkaKubun1.Zaihoji.できる.getCode());
        entity.setCk_ryoashiRitsui(ChosaKekkaKubun1.RyoashiRitsui.できない.getCode());
        entity.setCk_hoko(ChosaKekkaKubun1.Hoko.できる.getCode());
        entity.setCk_tachiagari(ChosaKekkaKubun1.Tachiagari.できない.getCode());
        entity.setCk_kataashiRitsui(ChosaKekkaKubun1.KataashiRitsui.できる.getCode());
        entity.setCk_senshin(ChosaKekkaKubun1.Senshin.自立.getCode());
        entity.setCk_tumekiri(ChosaKekkaKubun1.Tsumekiri.全介助.getCode());
        entity.setCk_shiryoku(ChosaKekkaKubun1.Shiryoku.普通.getCode());
        entity.setCk_choryoku(ChosaKekkaKubun1.Choryoku.判断不能.getCode());
        entity.setCk_ijo(ChosaKekkaKubun2.Ijo.自立.getCode());
        entity.setCk_ido(ChosaKekkaKubun2.Ido.全介助.getCode());
        entity.setCk_enge(ChosaKekkaKubun2.Enge.できる.getCode());
        entity.setCk_shokujiSesshu(ChosaKekkaKubun2.ShokujiSesshu.自立.getCode());
        entity.setCk_hainyo(ChosaKekkaKubun2.Hainyo.一部介助.getCode());
        entity.setCk_haiben(ChosaKekkaKubun2.Haiben.見守り等.getCode());
        entity.setCk_kokoSeiketsu(ChosaKekkaKubun2.KokoSeiketsu.全介助.getCode());
        entity.setCk_sengan(ChosaKekkaKubun2.Sengan.自立.getCode());
        entity.setCk_seihatsu(ChosaKekkaKubun2.Seihatsu.一部介助.getCode());
        entity.setCk_joiChakudatsu(ChosaKekkaKubun2.JoiChakudatsu.見守り等.getCode());
        entity.setCk_zubonChakudatsu(ChosaKekkaKubun2.ZubonChakudatsu.全介助.getCode());
        entity.setCk_gaishutsuHindo(ChosaKekkaKubun2.GaishutsuHindo.週１回以上.getCode());
        entity.setCk_ishiDentatsu(ChosaKekkaKubun3.IshiDentatsu.できる.getCode());
        entity.setCk_nikka(ChosaKekkaKubun3.Nikka.できない.getCode());
        entity.setCk_seinengappi(ChosaKekkaKubun3.Seinengappi.できる.getCode());
        entity.setCk_tankiKioku(ChosaKekkaKubun3.TankiKioku.できない.getCode());
        entity.setCk_namae(ChosaKekkaKubun3.Namae.できる.getCode());
        entity.setCk_kisetsu(ChosaKekkaKubun3.Kisetsu.できない.getCode());
        entity.setCk_basho(ChosaKekkaKubun3.Basho.できる.getCode());
        entity.setCk_haikai(ChosaKekkaKubun3.Haikai.ない.getCode());
        entity.setCk_gaishutsu(ChosaKekkaKubun3.Gaishutsu.ある.getCode());
        entity.setCk_higaiteki(ChosaKekkaKubun4.Higaiteki.ない.getCode());
        entity.setCk_sakuwa(ChosaKekkaKubun4.Sakuwa.ある.getCode());
        entity.setCk_kanjoHuantei(ChosaKekkaKubun4.KanjoHuantei.ない.getCode());
        entity.setCk_chuyaGyakuten(ChosaKekkaKubun4.ChuyaGyakuten.ある.getCode());
        entity.setCk_onajiHanashi(ChosaKekkaKubun4.OnajiHanashi.ない.getCode());
        entity.setCk_ogoe(ChosaKekkaKubun4.Ogoe.ある.getCode());
        entity.setCk_kaigoNiTeiko(ChosaKekkaKubun4.KaigoNiTeiko.ない.getCode());
        entity.setCk_ochitsuki(ChosaKekkaKubun4.Ochitsuki.ある.getCode());
        entity.setCk_hitoriDeDetagaru(ChosaKekkaKubun4.HitoriDeDetagaru.ない.getCode());
        entity.setCk_shushuheki(ChosaKekkaKubun4.Shushuheki.ある.getCode());
        entity.setCk_monoYaIruiWoKowasu(ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない.getCode());
        entity.setCk_hidoiMonowasure(ChosaKekkaKubun4.HidoiMonowasure.ある.getCode());
        entity.setCk_hitorigotoHitoriwarai(ChosaKekkaKubun4.HitorigotoHitoriwarai.ない.getCode());
        entity.setCk_jibunKatte(ChosaKekkaKubun4.JibunKatte.ある.getCode());
        entity.setCk_hanashiGaMatomaranai(ChosaKekkaKubun4.HanashiGaMatomaranai.ない.getCode());
        entity.setCk_kusuri(ChosaKekkaKubun5.Kusuri.自立.getCode());
        entity.setCk_kinsenKanri(ChosaKekkaKubun5.KinsenKanri.全介助.getCode());
        entity.setCk_ishiKettei(ChosaKekkaKubun5.IshiKettei.できる.getCode());
        entity.setCk_shudanHutekio(ChosaKekkaKubun5.ShudanFutekio.ない.getCode());
        entity.setCk_kaimono(ChosaKekkaKubun5.Kaimono.自立.getCode());
        entity.setCk_chori(ChosaKekkaKubun5.Chori.全介助.getCode());
        entity.setCk_tenteki(ChosaKekkaKubunIryo.Tenteki.ない.getCode());
        entity.setCk_chushinJomyakuEiyo(ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある.getCode());
        entity.setCk_toseki(ChosaKekkaKubunIryo.Toseki.ない.getCode());
        entity.setCk_stomaShochi(ChosaKekkaKubunIryo.StomaShochi.ある.getCode());
        entity.setCk_sansoRyoho(ChosaKekkaKubunIryo.SansoRyoho.ない.getCode());
        entity.setCk_respirator(ChosaKekkaKubunIryo.Respirator.ある.getCode());
        entity.setCk_kikanSekkai(ChosaKekkaKubunIryo.KikanSekkai.ない.getCode());
        entity.setCk_totsuKango(ChosaKekkaKubunIryo.TotsuKango.ある.getCode());
        entity.setCk_keikanEiyo(ChosaKekkaKubunIryo.KeikanEiyo.ない.getCode());
        entity.setCk_monitorSokutei(ChosaKekkaKubunIryo.MonitorSokutei.ある.getCode());
        entity.setCk_jokusoShochi(ChosaKekkaKubunIryo.JokusoShochi.ない.getCode());
        entity.setCk_catheter(ChosaKekkaKubunIryo.Catheter.ある.getCode());
        return spy(entity);
    }

    /**
     * DbT5010NinteiChosaTokkijikoEntityを生成して返します。
     *
     * @return DbT5010NinteiChosaTokkijikoEntity
     */
    public static DbT5010NinteiChosaTokkijikoEntity getSpiedDbT5010NinteiChosaTokkijikoEntityInstance() {
        DbT5010NinteiChosaTokkijikoEntity entity = new DbT5010NinteiChosaTokkijikoEntity();
        entity.setShinseishoKanriNo(new RString("1234567890"));
        entity.setNinteichosaRirekiNo(0);
        entity.setNinteichosaTokkijikoNo(new RString("特記事項番号"));
        entity.setNinteichosaTokkijiko(new RString("特記事項"));
        return spy(entity);
    }
}
