package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定調査票情報を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum DbT5009NinteichosahyoJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shinseishoKanriNo(2147483647, 0),
    koroshoIfShikibetsuCode(3, 0),
    ninteichosaRirekiNo(5, 0),
    ck_mahiHidariJoshi(1, 0),
    ck_mahiMigiJoshi(1, 0),
    ck_mahiHidariKashi(1, 0),
    ck_mahiMigiKashi(1, 0),
    ck_mahiSonota(1, 0),
    ck_koshukuKata(1, 0),
    ck_koshukuHiji(1, 0),
    ck_koshukuMata(1, 0),
    ck_koshukuHiza(1, 0),
    ck_koshukuAshi(1, 0),
    ck_koshukuSonota(1, 0),
    ck_negaeri(1, 0),
    ck_okiagari(1, 0),
    ck_zaihoji(1, 0),
    ck_hisetchiZaihoji(1, 0),
    ck_ryoashiRitsui(1, 0),
    ck_hoko(1, 0),
    ck_tachiagari(1, 0),
    ck_kataashiRitsui(1, 0),
    ck_yokusoDeiri(1, 0),
    ck_senshin(1, 0),
    ck_jokuso(1, 0),
    ck_sonotaHihushikkan(1, 0),
    ck_katateMunamotoage(1, 0),
    ck_tumekiri(1, 0),
    ck_shiryoku(1, 0),
    ck_choryoku(1, 0),
    ck_ijo(1, 0),
    ck_ido(1, 0),
    ck_enge(1, 0),
    ck_shokujiSesshu(1, 0),
    ck_insui(1, 0),
    ck_hainyo(1, 0),
    ck_haiben(1, 0),
    ck_nyoi(1, 0),
    ck_beni(1, 0),
    ck_hainyogoShimatsu(1, 0),
    ck_haibengoShimatsu(1, 0),
    ck_kokoSeiketsu(1, 0),
    ck_sengan(1, 0),
    ck_seihatsu(1, 0),
    ck_buttonKakehazushi(1, 0),
    ck_joiChakudatsu(1, 0),
    ck_zubonChakudatsu(1, 0),
    ck_kutsushitaChakudatsu(1, 0),
    ck_koshitsuSeiso(1, 0),
    ck_gaishutsuHindo(1, 0),
    ck_ishiDentatsu(1, 0),
    ck_hanno(1, 0),
    ck_nikka(1, 0),
    ck_seinengappi(1, 0),
    ck_tankiKioku(1, 0),
    ck_namae(1, 0),
    ck_kisetsu(1, 0),
    ck_basho(1, 0),
    ck_haikai(1, 0),
    ck_gaishutsu(1, 0),
    ck_higaiteki(1, 0),
    ck_sakuwa(1, 0),
    ck_genshiGencho(1, 0),
    ck_kanjoHuantei(1, 0),
    ck_chuyaGyakuten(1, 0),
    ck_bogenBoko(1, 0),
    ck_onajiHanashi(1, 0),
    ck_ogoe(1, 0),
    ck_kaigoNiTeiko(1, 0),
    ck_ochitsuki(1, 0),
    ck_hitoriDeDetagaru(1, 0),
    ck_shushuheki(1, 0),
    ck_hiNoHushimatsu(1, 0),
    ck_monoYaIruiWoKowasu(1, 0),
    ck_huketsuKoi(1, 0),
    ck_ishokuKodo(1, 0),
    ck_hidoiMonowasure(1, 0),
    ck_seitekiMeiwakuKoi(1, 0),
    ck_hitorigotoHitoriwarai(1, 0),
    ck_jibunKatte(1, 0),
    ck_hanashiGaMatomaranai(1, 0),
    ck_kusuri(1, 0),
    ck_kinsenKanri(1, 0),
    ck_ishiKettei(1, 0),
    ck_mukanshin(1, 0),
    ck_shudanHutekio(1, 0),
    ck_denwa(1, 0),
    ck_kaimono(1, 0),
    ck_chori(1, 0),
    ck_tenteki(1, 0),
    ck_chushinJomyakuEiyo(1, 0),
    ck_toseki(1, 0),
    ck_stomaShochi(1, 0),
    ck_sansoRyoho(1, 0),
    ck_respirator(1, 0),
    ck_kikanSekkai(1, 0),
    ck_totsuKango(1, 0),
    ck_keikanEiyo(1, 0),
    ck_monitorSokutei(1, 0),
    ck_jokusoShochi(1, 0),
    ck_catheter(1, 0),
    ck_nitchuNoSeikatsuNiTsuite(1, 0),
    ck_gaishutsuHindoNiTsuite(1, 0),
    ck_jokyoHenka(1, 0),
    ninchishoNichijoSeikatsuJiritsudoCode(2147483647, 0),
    shogaiNichijoSeikatsuJiritsudoCode(2147483647, 0);
    private final int maxLength;
    private final int scale;

    private DbT5009NinteichosahyoJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }
// </editor-fold>
}
