/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.persistence.basic.helper.NinteichosahyoInserter;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定調査票情報Dacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosahyoDacTest {

    private static NinteichosahyoDac sut;
    private static NinteichosahyoInserter chosahyoInserter;

    @BeforeClass
    public static void setUpBeforeClass() {
        sut = InstanceProvider.create(NinteichosahyoDac.class);
        chosahyoInserter = InstanceProvider.create(NinteichosahyoInserter.class);
    }

    public static class selectのテスト extends DbeTestDacBase {

        private DbT5009NinteichosahyoJohoEntity result;

        @Before
        public void setUp() {
            chosahyoInserter.insert(create認定調査票Entity("A001", 1));
            chosahyoInserter.insert(create認定調査票Entity("A001", 2));
            chosahyoInserter.insert(create認定調査票Entity("A001", 3));
            result = sut.select(new ShinseishoKanriNo(new RString("A001")));
        }

        @Test
        public void 申請書管理番号がA001の_認定調査票Entityが取得できる() {
            assertThat(result.getShinseishoKanriNo(), is(new ShinseishoKanriNo(new RString("A001"))));
        }

        @Test
        public void 履歴が存在するとき_最新の認定調査票Entityが取得できる() {
            int 最新履歴番号 = 3;
            assertThat(result.getNinteichosaRirekiNo(), is(最新履歴番号));
        }
    }

    private static DbT5009NinteichosahyoJohoEntity create認定調査票Entity(String 申請書管理番号, int 依頼履歴番号) {

        DbT5009NinteichosahyoJohoEntity entity = new DbT5009NinteichosahyoJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString(申請書管理番号)));
        entity.setKoroshoIfShikibetsuCode(KoroshoIFKubun.V02A.getCode());
        entity.setNinteichosaRirekiNo(依頼履歴番号);
        entity.setCk_mahiHidariJoshi(new RString("1"));
        entity.setCk_mahiMigiJoshi(new RString("1"));
        entity.setCk_mahiHidariKashi(new RString("1"));
        entity.setCk_mahiMigiKashi(new RString("1"));
        entity.setCk_mahiSonota(new RString("1"));
        entity.setCk_koshukuKata(new RString("1"));
        entity.setCk_koshukuHiji(new RString("1"));
        entity.setCk_koshukuMata(new RString("1"));
        entity.setCk_koshukuHiza(new RString("1"));
        entity.setCk_koshukuAshi(new RString("1"));
        entity.setCk_koshukuSonota(new RString("1"));
        entity.setCk_negaeri(new RString("1"));
        entity.setCk_okiagari(new RString("1"));
        entity.setCk_zaihoji(new RString("1"));
        entity.setCk_hisetchiZaihoji(new RString("1"));
        entity.setCk_ryoashiRitsui(new RString("1"));
        entity.setCk_hoko(new RString("1"));
        entity.setCk_tachiagari(new RString("1"));
        entity.setCk_kataashiRitsui(new RString("1"));
        entity.setCk_yokusoDeiri(new RString("1"));
        entity.setCk_senshin(new RString("1"));
        entity.setCk_jokuso(new RString("1"));
        entity.setCk_sonotaHihushikkan(new RString("1"));
        entity.setCk_katateMunamotoage(new RString("1"));
        entity.setCk_tumekiri(new RString("1"));
        entity.setCk_shiryoku(new RString("1"));
        entity.setCk_choryoku(new RString("1"));
        entity.setCk_ijo(new RString("1"));
        entity.setCk_ido(new RString("1"));
        entity.setCk_enge(new RString("1"));
        entity.setCk_shokujiSesshu(new RString("1"));
        entity.setCk_insui(new RString("1"));
        entity.setCk_hainyo(new RString("1"));
        entity.setCk_haiben(new RString("1"));
        entity.setCk_nyoi(new RString("1"));
        entity.setCk_beni(new RString("1"));
        entity.setCk_hainyogoShimatsu(new RString("1"));
        entity.setCk_haibengoShimatsu(new RString("1"));
        entity.setCk_kokoSeiketsu(new RString("1"));
        entity.setCk_sengan(new RString("1"));
        entity.setCk_seihatsu(new RString("1"));
        entity.setCk_buttonKakehazushi(new RString("1"));
        entity.setCk_joiChakudatsu(new RString("1"));
        entity.setCk_zubonChakudatsu(new RString("1"));
        entity.setCk_kutsushitaChakudatsu(new RString("1"));
        entity.setCk_koshitsuSeiso(new RString("1"));
        entity.setCk_gaishutsuHindo(new RString("1"));
        entity.setCk_ishiDentatsu(new RString("1"));
        entity.setCk_hanno(new RString("1"));
        entity.setCk_nikka(new RString("1"));
        entity.setCk_seinengappi(new RString("1"));
        entity.setCk_tankiKioku(new RString("1"));
        entity.setCk_namae(new RString("1"));
        entity.setCk_kisetsu(new RString("1"));
        entity.setCk_basho(new RString("1"));
        entity.setCk_haikai(new RString("1"));
        entity.setCk_gaishutsu(new RString("1"));
        entity.setCk_higaiteki(new RString("1"));
        entity.setCk_sakuwa(new RString("1"));
        entity.setCk_genshiGencho(new RString("1"));
        entity.setCk_kanjoHuantei(new RString("1"));
        entity.setCk_chuyaGyakuten(new RString("1"));
        entity.setCk_bogenBoko(new RString("1"));
        entity.setCk_onajiHanashi(new RString("1"));
        entity.setCk_ogoe(new RString("1"));
        entity.setCk_kaigoNiTeiko(new RString("1"));
        entity.setCk_ochitsuki(new RString("1"));
        entity.setCk_hitoriDeDetagaru(new RString("1"));
        entity.setCk_shushuheki(new RString("1"));
        entity.setCk_hiNoHushimatsu(new RString("1"));
        entity.setCk_monoYaIruiWoKowasu(new RString("1"));
        entity.setCk_huketsuKoi(new RString("1"));
        entity.setCk_ishokuKodo(new RString("1"));
        entity.setCk_hidoiMonowasure(new RString("1"));
        entity.setCk_seitekiMeiwakuKoi(new RString("1"));
        entity.setCk_hitorigotoHitoriwarai(new RString("1"));
        entity.setCk_jibunKatte(new RString("1"));
        entity.setCk_hanashiGaMatomaranai(new RString("1"));
        entity.setCk_kusuri(new RString("1"));
        entity.setCk_kinsenKanri(new RString("1"));
        entity.setCk_ishiKettei(new RString("1"));
        entity.setCk_mukanshin(new RString("1"));
        entity.setCk_shudanHutekio(new RString("1"));
        entity.setCk_denwa(new RString("1"));
        entity.setCk_kaimono(new RString("1"));
        entity.setCk_chori(new RString("1"));
        entity.setCk_tenteki(new RString("1"));
        entity.setCk_chushinJomyakuEiyo(new RString("1"));
        entity.setCk_toseki(new RString("1"));
        entity.setCk_stomaShochi(new RString("1"));
        entity.setCk_sansoRyoho(new RString("1"));
        entity.setCk_respirator(new RString("1"));
        entity.setCk_kikanSekkai(new RString("1"));
        entity.setCk_totsuKango(new RString("1"));
        entity.setCk_keikanEiyo(new RString("1"));
        entity.setCk_monitorSokutei(new RString("1"));
        entity.setCk_jokusoShochi(new RString("1"));
        entity.setCk_catheter(new RString("1"));
        entity.setCk_nitchuNoSeikatsuNiTsuite(new RString("1"));
        entity.setCk_gaishutsuHindoNiTsuite(new RString("1"));
        entity.setCk_jokyoHenka(new RString("1"));
        return entity;
    }
}
