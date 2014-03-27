/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosahyoResult;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 認定調査票の項目を、一次判定で利用する形にマッピングを行うクラスです。
 *
 * @author n8178 城間篤人
 */
public final class NinteichosahyoResultMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private NinteichosahyoResultMapper() {
    }

    /**
     * 認定調査票の内容を、一次判定で使用する形にマッピングします。<br/>
     * 引数にnullを渡した場合はnullが返ります。
     *
     * @param entity 認定調査票Entity
     * @return 認定調査結果
     */
    public static NinteichosahyoResult to認定調査結果(DbT5009NinteichosahyoJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new NinteichosahyoResult(create調査項目回答(entity),
                entity.getShinseishoKanriNo(),
                new NinteichosaRirekiNo(entity.getNinteichosaRirekiNo()),
                KoroshoIFKubun.toValue(entity.getKoroshoIfShikibetsuCode()));
    }

    private static RString create調査項目回答(DbT5009NinteichosahyoJohoEntity entity) {
        RStringBuilder 回答 = new RStringBuilder();
        回答.append(entity.getCk_mahiHidariJoshi());
        回答.append(entity.getCk_mahiMigiJoshi());
        回答.append(entity.getCk_mahiHidariKashi());
        回答.append(entity.getCk_mahiMigiKashi());
        回答.append(entity.getCk_mahiSonota());
        回答.append(entity.getCk_koshukuKata());
        回答.append(entity.getCk_koshukuHiji());
        回答.append(entity.getCk_koshukuMata());
        回答.append(entity.getCk_koshukuHiza());
        回答.append(entity.getCk_koshukuAshi());
        回答.append(entity.getCk_koshukuSonota());
        回答.append(entity.getCk_negaeri());
        回答.append(entity.getCk_okiagari());
        回答.append(entity.getCk_zaihoji());
        回答.append(entity.getCk_hisetchiZaihoji());
        回答.append(entity.getCk_ryoashiRitsui());
        回答.append(entity.getCk_hoko());
        回答.append(entity.getCk_tachiagari());
        回答.append(entity.getCk_kataashiRitsui());
        回答.append(entity.getCk_yokusoDeiri());
        回答.append(entity.getCk_senshin());
        回答.append(entity.getCk_jokuso());
        回答.append(entity.getCk_sonotaHihushikkan());
        回答.append(entity.getCk_katateMunamotoage());
        回答.append(entity.getCk_tumekiri());
        回答.append(entity.getCk_shiryoku());
        回答.append(entity.getCk_choryoku());
        回答.append(entity.getCk_ijo());
        回答.append(entity.getCk_ido());
        回答.append(entity.getCk_enge());
        回答.append(entity.getCk_shokujiSesshu());
        回答.append(entity.getCk_insui());
        回答.append(entity.getCk_hainyo());
        回答.append(entity.getCk_haiben());
        回答.append(entity.getCk_nyoi());
        回答.append(entity.getCk_beni());
        回答.append(entity.getCk_hainyogoShimatsu());
        回答.append(entity.getCk_haibengoShimatsu());
        回答.append(entity.getCk_kokoSeiketsu());
        回答.append(entity.getCk_sengan());
        回答.append(entity.getCk_seihatsu());
        回答.append(entity.getCk_buttonKakehazushi());
        回答.append(entity.getCk_joiChakudatsu());
        回答.append(entity.getCk_zubonChakudatsu());
        回答.append(entity.getCk_kutsushitaChakudatsu());
        回答.append(entity.getCk_koshitsuSeiso());
        回答.append(entity.getCk_gaishutsuHindo());
        回答.append(entity.getCk_ishiDentatsu());
        回答.append(entity.getCk_hanno());
        回答.append(entity.getCk_nikka());
        回答.append(entity.getCk_seinengappi());
        回答.append(entity.getCk_tankiKioku());
        回答.append(entity.getCk_namae());
        回答.append(entity.getCk_kisetsu());
        回答.append(entity.getCk_basho());
        回答.append(entity.getCk_haikai());
        回答.append(entity.getCk_gaishutsu());
        回答.append(entity.getCk_higaiteki());
        回答.append(entity.getCk_sakuwa());
        回答.append(entity.getCk_genshiGencho());
        回答.append(entity.getCk_kanjoHuantei());
        回答.append(entity.getCk_chuyaGyakuten());
        回答.append(entity.getCk_bogenBoko());
        回答.append(entity.getCk_onajiHanashi());
        回答.append(entity.getCk_ogoe());
        回答.append(entity.getCk_kaigoNiTeiko());
        回答.append(entity.getCk_ochitsuki());
        回答.append(entity.getCk_hitoriDeDetagaru());
        回答.append(entity.getCk_shushuheki());
        回答.append(entity.getCk_hiNoHushimatsu());
        回答.append(entity.getCk_monoYaIruiWoKowasu());
        回答.append(entity.getCk_huketsuKoi());
        回答.append(entity.getCk_ishokuKodo());
        回答.append(entity.getCk_hidoiMonowasure());
        回答.append(entity.getCk_seitekiMeiwakuKoi());
        回答.append(entity.getCk_hitorigotoHitoriwarai());
        回答.append(entity.getCk_jibunKatte());
        回答.append(entity.getCk_hanashiGaMatomaranai());
        回答.append(entity.getCk_kusuri());
        回答.append(entity.getCk_kinsenKanri());
        回答.append(entity.getCk_ishiKettei());
        回答.append(entity.getCk_mukanshin());
        回答.append(entity.getCk_shudanHutekio());
        回答.append(entity.getCk_denwa());
        回答.append(entity.getCk_kaimono());
        回答.append(entity.getCk_chori());
        回答.append(entity.getCk_tenteki());
        回答.append(entity.getCk_chushinJomyakuEiyo());
        回答.append(entity.getCk_toseki());
        回答.append(entity.getCk_stomaShochi());
        回答.append(entity.getCk_sansoRyoho());
        回答.append(entity.getCk_respirator());
        回答.append(entity.getCk_kikanSekkai());
        回答.append(entity.getCk_totsuKango());
        回答.append(entity.getCk_keikanEiyo());
        回答.append(entity.getCk_monitorSokutei());
        回答.append(entity.getCk_jokusoShochi());
        回答.append(entity.getCk_catheter());
        回答.append(entity.getCk_nitchuNoSeikatsuNiTsuite());
        回答.append(entity.getCk_gaishutsuHindoNiTsuite());
        回答.append(entity.getCk_jokyoHenka());
        return 回答.toRString();
    }
}
