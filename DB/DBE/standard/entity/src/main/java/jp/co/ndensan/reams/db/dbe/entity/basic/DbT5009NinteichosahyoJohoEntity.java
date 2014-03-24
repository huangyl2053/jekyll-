package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 要介護認定調査票情報のエンティティクラスです。
 *
 * @author N8156 宮本 康
 */
public class DbT5009NinteichosahyoJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5009NinteichosahyoJoho");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    private RString koroshoIfShikibetsuCode;
    @PrimaryKey
    private int ninteichosaRirekiNo;
    private RString ck_mahiHidariJoshi;
    private RString ck_mahiMigiJoshi;
    private RString ck_mahiHidariKashi;
    private RString ck_mahiMigiKashi;
    private RString ck_mahiSonota;
    private RString ck_koshukuKata;
    private RString ck_koshukuHiji;
    private RString ck_koshukuMata;
    private RString ck_koshukuHiza;
    private RString ck_koshukuAshi;
    private RString ck_koshukuSonota;
    private RString ck_negaeri;
    private RString ck_okiagari;
    private RString ck_zaihoji;
    private RString ck_hisetchiZaihoji;
    private RString ck_ryoashiRitsui;
    private RString ck_hoko;
    private RString ck_tachiagari;
    private RString ck_kataashiRitsui;
    private RString ck_yokusoDeiri;
    private RString ck_senshin;
    private RString ck_jokuso;
    private RString ck_sonotaHihushikkan;
    private RString ck_katateMunamotoage;
    private RString ck_tumekiri;
    private RString ck_shiryoku;
    private RString ck_choryoku;
    private RString ck_ijo;
    private RString ck_ido;
    private RString ck_enge;
    private RString ck_shokujiSesshu;
    private RString ck_insui;
    private RString ck_hainyo;
    private RString ck_haiben;
    private RString ck_nyoi;
    private RString ck_beni;
    private RString ck_hainyogoShimatsu;
    private RString ck_haibengoShimatsu;
    private RString ck_kokoSeiketsu;
    private RString ck_sengan;
    private RString ck_seihatsu;
    private RString ck_buttonKakehazushi;
    private RString ck_joiChakudatsu;
    private RString ck_zubonChakudatsu;
    private RString ck_kutsushitaChakudatsu;
    private RString ck_koshitsuSeiso;
    private RString ck_gaishutsuHindo;
    private RString ck_ishiDentatsu;
    private RString ck_hanno;
    private RString ck_nikka;
    private RString ck_seinengappi;
    private RString ck_tankiKioku;
    private RString ck_namae;
    private RString ck_kisetsu;
    private RString ck_basho;
    private RString ck_haikai;
    private RString ck_gaishutsu;
    private RString ck_higaiteki;
    private RString ck_sakuwa;
    private RString ck_genshiGencho;
    private RString ck_kanjoHuantei;
    private RString ck_chuyaGyakuten;
    private RString ck_bogenBoko;
    private RString ck_onajiHanashi;
    private RString ck_ogoe;
    private RString ck_kaigoNiTeiko;
    private RString ck_ochitsuki;
    private RString ck_hitoriDeDetagaru;
    private RString ck_shushuheki;
    private RString ck_hiNoHushimatsu;
    private RString ck_monoYaIruiWoKowasu;
    private RString ck_huketsuKoi;
    private RString ck_ishokuKodo;
    private RString ck_hidoiMonowasure;
    private RString ck_seitekiMeiwakuKoi;
    private RString ck_hitorigotoHitoriwarai;
    private RString ck_jibunKatte;
    private RString ck_hanashiGaMatomaranai;
    private RString ck_kusuri;
    private RString ck_kinsenKanri;
    private RString ck_ishiKettei;
    private RString ck_mukanshin;
    private RString ck_shudanHutekio;
    private RString ck_denwa;
    private RString ck_kaimono;
    private RString ck_chori;
    private RString ck_tenteki;
    private RString ck_chushinJomyakuEiyo;
    private RString ck_toseki;
    private RString ck_stomaShochi;
    private RString ck_sansoRyoho;
    private RString ck_respirator;
    private RString ck_kikanSekkai;
    private RString ck_totsuKango;
    private RString ck_keikanEiyo;
    private RString ck_monitorSokutei;
    private RString ck_jokusoShochi;
    private RString ck_catheter;
    private RString ck_nitchuNoSeikatsuNiTsuite;
    private RString ck_gaishutsuHindoNiTsuite;
    private RString ck_jokyoHenka;
    private Code ninchishoNichijoSeikatsuJiritsudoCode;
    private Code shogaiNichijoSeikatsuJiritsudoCode;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShinseishoKanriNo
     *
     * @return shinseishoKanriNo
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * setShinseishoKanriNo
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * getKoroshoIfShikibetsuCode
     *
     * @return koroshoIfShikibetsuCode
     */
    public RString getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * setKoroshoIfShikibetsuCode
     *
     * @param koroshoIfShikibetsuCode koroshoIfShikibetsuCode
     */
    public void setKoroshoIfShikibetsuCode(RString koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * getNinteichosaRirekiNo
     *
     * @return ninteichosaRirekiNo
     */
    public int getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    /**
     * setNinteichosaRirekiNo
     *
     * @param ninteichosaRirekiNo ninteichosaRirekiNo
     */
    public void setNinteichosaRirekiNo(int ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /**
     * getCk_mahiHidariJoshi
     *
     * @return ck_mahiHidariJoshi
     */
    public RString getCk_mahiHidariJoshi() {
        return ck_mahiHidariJoshi;
    }

    /**
     * setCk_mahiHidariJoshi
     *
     * @param ck_mahiHidariJoshi ck_mahiHidariJoshi
     */
    public void setCk_mahiHidariJoshi(RString ck_mahiHidariJoshi) {
        this.ck_mahiHidariJoshi = ck_mahiHidariJoshi;
    }

    /**
     * getCk_mahiMigiJoshi
     *
     * @return ck_mahiMigiJoshi
     */
    public RString getCk_mahiMigiJoshi() {
        return ck_mahiMigiJoshi;
    }

    /**
     * setCk_mahiMigiJoshi
     *
     * @param ck_mahiMigiJoshi ck_mahiMigiJoshi
     */
    public void setCk_mahiMigiJoshi(RString ck_mahiMigiJoshi) {
        this.ck_mahiMigiJoshi = ck_mahiMigiJoshi;
    }

    /**
     * getCk_mahiHidariKashi
     *
     * @return ck_mahiHidariKashi
     */
    public RString getCk_mahiHidariKashi() {
        return ck_mahiHidariKashi;
    }

    /**
     * setCk_mahiHidariKashi
     *
     * @param ck_mahiHidariKashi ck_mahiHidariKashi
     */
    public void setCk_mahiHidariKashi(RString ck_mahiHidariKashi) {
        this.ck_mahiHidariKashi = ck_mahiHidariKashi;
    }

    /**
     * getCk_mahiMigiKashi
     *
     * @return ck_mahiMigiKashi
     */
    public RString getCk_mahiMigiKashi() {
        return ck_mahiMigiKashi;
    }

    /**
     * setCk_mahiMigiKashi
     *
     * @param ck_mahiMigiKashi ck_mahiMigiKashi
     */
    public void setCk_mahiMigiKashi(RString ck_mahiMigiKashi) {
        this.ck_mahiMigiKashi = ck_mahiMigiKashi;
    }

    /**
     * getCk_mahiSonota
     *
     * @return ck_mahiSonota
     */
    public RString getCk_mahiSonota() {
        return ck_mahiSonota;
    }

    /**
     * setCk_mahiSonota
     *
     * @param ck_mahiSonota ck_mahiSonota
     */
    public void setCk_mahiSonota(RString ck_mahiSonota) {
        this.ck_mahiSonota = ck_mahiSonota;
    }

    /**
     * getCk_koshukuKata
     *
     * @return ck_koshukuKata
     */
    public RString getCk_koshukuKata() {
        return ck_koshukuKata;
    }

    /**
     * setCk_koshukuKata
     *
     * @param ck_koshukuKata ck_koshukuKata
     */
    public void setCk_koshukuKata(RString ck_koshukuKata) {
        this.ck_koshukuKata = ck_koshukuKata;
    }

    /**
     * getCk_koshukuHiji
     *
     * @return ck_koshukuHiji
     */
    public RString getCk_koshukuHiji() {
        return ck_koshukuHiji;
    }

    /**
     * setCk_koshukuHiji
     *
     * @param ck_koshukuHiji ck_koshukuHiji
     */
    public void setCk_koshukuHiji(RString ck_koshukuHiji) {
        this.ck_koshukuHiji = ck_koshukuHiji;
    }

    /**
     * getCk_koshukuMata
     *
     * @return ck_koshukuMata
     */
    public RString getCk_koshukuMata() {
        return ck_koshukuMata;
    }

    /**
     * setCk_koshukuMata
     *
     * @param ck_koshukuMata ck_koshukuMata
     */
    public void setCk_koshukuMata(RString ck_koshukuMata) {
        this.ck_koshukuMata = ck_koshukuMata;
    }

    /**
     * getCk_koshukuHiza
     *
     * @return ck_koshukuHiza
     */
    public RString getCk_koshukuHiza() {
        return ck_koshukuHiza;
    }

    /**
     * setCk_koshukuHiza
     *
     * @param ck_koshukuHiza ck_koshukuHiza
     */
    public void setCk_koshukuHiza(RString ck_koshukuHiza) {
        this.ck_koshukuHiza = ck_koshukuHiza;
    }

    /**
     * getCk_koshukuAshi
     *
     * @return ck_koshukuAshi
     */
    public RString getCk_koshukuAshi() {
        return ck_koshukuAshi;
    }

    /**
     * setCk_koshukuAshi
     *
     * @param ck_koshukuAshi ck_koshukuAshi
     */
    public void setCk_koshukuAshi(RString ck_koshukuAshi) {
        this.ck_koshukuAshi = ck_koshukuAshi;
    }

    /**
     * getCk_koshukuSonota
     *
     * @return ck_koshukuSonota
     */
    public RString getCk_koshukuSonota() {
        return ck_koshukuSonota;
    }

    /**
     * setCk_koshukuSonota
     *
     * @param ck_koshukuSonota ck_koshukuSonota
     */
    public void setCk_koshukuSonota(RString ck_koshukuSonota) {
        this.ck_koshukuSonota = ck_koshukuSonota;
    }

    /**
     * getCk_negaeri
     *
     * @return ck_negaeri
     */
    public RString getCk_negaeri() {
        return ck_negaeri;
    }

    /**
     * setCk_negaeri
     *
     * @param ck_negaeri ck_negaeri
     */
    public void setCk_negaeri(RString ck_negaeri) {
        this.ck_negaeri = ck_negaeri;
    }

    /**
     * getCk_okiagari
     *
     * @return ck_okiagari
     */
    public RString getCk_okiagari() {
        return ck_okiagari;
    }

    /**
     * setCk_okiagari
     *
     * @param ck_okiagari ck_okiagari
     */
    public void setCk_okiagari(RString ck_okiagari) {
        this.ck_okiagari = ck_okiagari;
    }

    /**
     * getCk_zaihoji
     *
     * @return ck_zaihoji
     */
    public RString getCk_zaihoji() {
        return ck_zaihoji;
    }

    /**
     * setCk_zaihoji
     *
     * @param ck_zaihoji ck_zaihoji
     */
    public void setCk_zaihoji(RString ck_zaihoji) {
        this.ck_zaihoji = ck_zaihoji;
    }

    /**
     * getCk_hisetchiZaihoji
     *
     * @return ck_hisetchiZaihoji
     */
    public RString getCk_hisetchiZaihoji() {
        return ck_hisetchiZaihoji;
    }

    /**
     * setCk_hisetchiZaihoji
     *
     * @param ck_hisetchiZaihoji ck_hisetchiZaihoji
     */
    public void setCk_hisetchiZaihoji(RString ck_hisetchiZaihoji) {
        this.ck_hisetchiZaihoji = ck_hisetchiZaihoji;
    }

    /**
     * getCk_ryoashiRitsui
     *
     * @return ck_ryoashiRitsui
     */
    public RString getCk_ryoashiRitsui() {
        return ck_ryoashiRitsui;
    }

    /**
     * setCk_ryoashiRitsui
     *
     * @param ck_ryoashiRitsui ck_ryoashiRitsui
     */
    public void setCk_ryoashiRitsui(RString ck_ryoashiRitsui) {
        this.ck_ryoashiRitsui = ck_ryoashiRitsui;
    }

    /**
     * getCk_hoko
     *
     * @return ck_hoko
     */
    public RString getCk_hoko() {
        return ck_hoko;
    }

    /**
     * setCk_hoko
     *
     * @param ck_hoko ck_hoko
     */
    public void setCk_hoko(RString ck_hoko) {
        this.ck_hoko = ck_hoko;
    }

    /**
     * getCk_tachiagari
     *
     * @return ck_tachiagari
     */
    public RString getCk_tachiagari() {
        return ck_tachiagari;
    }

    /**
     * setCk_tachiagari
     *
     * @param ck_tachiagari ck_tachiagari
     */
    public void setCk_tachiagari(RString ck_tachiagari) {
        this.ck_tachiagari = ck_tachiagari;
    }

    /**
     * getCk_kataashiRitsui
     *
     * @return ck_kataashiRitsui
     */
    public RString getCk_kataashiRitsui() {
        return ck_kataashiRitsui;
    }

    /**
     * setCk_kataashiRitsui
     *
     * @param ck_kataashiRitsui ck_kataashiRitsui
     */
    public void setCk_kataashiRitsui(RString ck_kataashiRitsui) {
        this.ck_kataashiRitsui = ck_kataashiRitsui;
    }

    /**
     * getCk_yokusoDeiri
     *
     * @return ck_yokusoDeiri
     */
    public RString getCk_yokusoDeiri() {
        return ck_yokusoDeiri;
    }

    /**
     * setCk_yokusoDeiri
     *
     * @param ck_yokusoDeiri ck_yokusoDeiri
     */
    public void setCk_yokusoDeiri(RString ck_yokusoDeiri) {
        this.ck_yokusoDeiri = ck_yokusoDeiri;
    }

    /**
     * getCk_senshin
     *
     * @return ck_senshin
     */
    public RString getCk_senshin() {
        return ck_senshin;
    }

    /**
     * setCk_senshin
     *
     * @param ck_senshin ck_senshin
     */
    public void setCk_senshin(RString ck_senshin) {
        this.ck_senshin = ck_senshin;
    }

    /**
     * getCk_jokuso
     *
     * @return ck_jokuso
     */
    public RString getCk_jokuso() {
        return ck_jokuso;
    }

    /**
     * setCk_jokuso
     *
     * @param ck_jokuso ck_jokuso
     */
    public void setCk_jokuso(RString ck_jokuso) {
        this.ck_jokuso = ck_jokuso;
    }

    /**
     * getCk_sonotaHihushikkan
     *
     * @return ck_sonotaHihushikkan
     */
    public RString getCk_sonotaHihushikkan() {
        return ck_sonotaHihushikkan;
    }

    /**
     * setCk_sonotaHihushikkan
     *
     * @param ck_sonotaHihushikkan ck_sonotaHihushikkan
     */
    public void setCk_sonotaHihushikkan(RString ck_sonotaHihushikkan) {
        this.ck_sonotaHihushikkan = ck_sonotaHihushikkan;
    }

    /**
     * getCk_katateMunamotoage
     *
     * @return ck_katateMunamotoage
     */
    public RString getCk_katateMunamotoage() {
        return ck_katateMunamotoage;
    }

    /**
     * setCk_katateMunamotoage
     *
     * @param ck_katateMunamotoage ck_katateMunamotoage
     */
    public void setCk_katateMunamotoage(RString ck_katateMunamotoage) {
        this.ck_katateMunamotoage = ck_katateMunamotoage;
    }

    /**
     * getCk_tumekiri
     *
     * @return ck_tumekiri
     */
    public RString getCk_tumekiri() {
        return ck_tumekiri;
    }

    /**
     * setCk_tumekiri
     *
     * @param ck_tumekiri ck_tumekiri
     */
    public void setCk_tumekiri(RString ck_tumekiri) {
        this.ck_tumekiri = ck_tumekiri;
    }

    /**
     * getCk_shiryoku
     *
     * @return ck_shiryoku
     */
    public RString getCk_shiryoku() {
        return ck_shiryoku;
    }

    /**
     * setCk_shiryoku
     *
     * @param ck_shiryoku ck_shiryoku
     */
    public void setCk_shiryoku(RString ck_shiryoku) {
        this.ck_shiryoku = ck_shiryoku;
    }

    /**
     * getCk_choryoku
     *
     * @return ck_choryoku
     */
    public RString getCk_choryoku() {
        return ck_choryoku;
    }

    /**
     * setCk_choryoku
     *
     * @param ck_choryoku ck_choryoku
     */
    public void setCk_choryoku(RString ck_choryoku) {
        this.ck_choryoku = ck_choryoku;
    }

    /**
     * getCk_ijo
     *
     * @return ck_ijo
     */
    public RString getCk_ijo() {
        return ck_ijo;
    }

    /**
     * setCk_ijo
     *
     * @param ck_ijo ck_ijo
     */
    public void setCk_ijo(RString ck_ijo) {
        this.ck_ijo = ck_ijo;
    }

    /**
     * getCk_ido
     *
     * @return ck_ido
     */
    public RString getCk_ido() {
        return ck_ido;
    }

    /**
     * setCk_ido
     *
     * @param ck_ido ck_ido
     */
    public void setCk_ido(RString ck_ido) {
        this.ck_ido = ck_ido;
    }

    /**
     * getCk_enge
     *
     * @return ck_enge
     */
    public RString getCk_enge() {
        return ck_enge;
    }

    /**
     * setCk_enge
     *
     * @param ck_enge ck_enge
     */
    public void setCk_enge(RString ck_enge) {
        this.ck_enge = ck_enge;
    }

    /**
     * getCk_shokujiSesshu
     *
     * @return ck_shokujiSesshu
     */
    public RString getCk_shokujiSesshu() {
        return ck_shokujiSesshu;
    }

    /**
     * setCk_shokujiSesshu
     *
     * @param ck_shokujiSesshu ck_shokujiSesshu
     */
    public void setCk_shokujiSesshu(RString ck_shokujiSesshu) {
        this.ck_shokujiSesshu = ck_shokujiSesshu;
    }

    /**
     * getCk_insui
     *
     * @return ck_insui
     */
    public RString getCk_insui() {
        return ck_insui;
    }

    /**
     * setCk_insui
     *
     * @param ck_insui ck_insui
     */
    public void setCk_insui(RString ck_insui) {
        this.ck_insui = ck_insui;
    }

    /**
     * getCk_hainyo
     *
     * @return ck_hainyo
     */
    public RString getCk_hainyo() {
        return ck_hainyo;
    }

    /**
     * setCk_hainyo
     *
     * @param ck_hainyo ck_hainyo
     */
    public void setCk_hainyo(RString ck_hainyo) {
        this.ck_hainyo = ck_hainyo;
    }

    /**
     * getCk_haiben
     *
     * @return ck_haiben
     */
    public RString getCk_haiben() {
        return ck_haiben;
    }

    /**
     * setCk_haiben
     *
     * @param ck_haiben ck_haiben
     */
    public void setCk_haiben(RString ck_haiben) {
        this.ck_haiben = ck_haiben;
    }

    /**
     * getCk_nyoi
     *
     * @return ck_nyoi
     */
    public RString getCk_nyoi() {
        return ck_nyoi;
    }

    /**
     * setCk_nyoi
     *
     * @param ck_nyoi ck_nyoi
     */
    public void setCk_nyoi(RString ck_nyoi) {
        this.ck_nyoi = ck_nyoi;
    }

    /**
     * getCk_beni
     *
     * @return ck_beni
     */
    public RString getCk_beni() {
        return ck_beni;
    }

    /**
     * setCk_beni
     *
     * @param ck_beni ck_beni
     */
    public void setCk_beni(RString ck_beni) {
        this.ck_beni = ck_beni;
    }

    /**
     * getCk_hainyogoShimatsu
     *
     * @return ck_hainyogoShimatsu
     */
    public RString getCk_hainyogoShimatsu() {
        return ck_hainyogoShimatsu;
    }

    /**
     * setCk_hainyogoShimatsu
     *
     * @param ck_hainyogoShimatsu ck_hainyogoShimatsu
     */
    public void setCk_hainyogoShimatsu(RString ck_hainyogoShimatsu) {
        this.ck_hainyogoShimatsu = ck_hainyogoShimatsu;
    }

    /**
     * getCk_haibengoShimatsu
     *
     * @return ck_haibengoShimatsu
     */
    public RString getCk_haibengoShimatsu() {
        return ck_haibengoShimatsu;
    }

    /**
     * setCk_haibengoShimatsu
     *
     * @param ck_haibengoShimatsu ck_haibengoShimatsu
     */
    public void setCk_haibengoShimatsu(RString ck_haibengoShimatsu) {
        this.ck_haibengoShimatsu = ck_haibengoShimatsu;
    }

    /**
     * getCk_kokoSeiketsu
     *
     * @return ck_kokoSeiketsu
     */
    public RString getCk_kokoSeiketsu() {
        return ck_kokoSeiketsu;
    }

    /**
     * setCk_kokoSeiketsu
     *
     * @param ck_kokoSeiketsu ck_kokoSeiketsu
     */
    public void setCk_kokoSeiketsu(RString ck_kokoSeiketsu) {
        this.ck_kokoSeiketsu = ck_kokoSeiketsu;
    }

    /**
     * getCk_sengan
     *
     * @return ck_sengan
     */
    public RString getCk_sengan() {
        return ck_sengan;
    }

    /**
     * setCk_sengan
     *
     * @param ck_sengan ck_sengan
     */
    public void setCk_sengan(RString ck_sengan) {
        this.ck_sengan = ck_sengan;
    }

    /**
     * getCk_seihatsu
     *
     * @return ck_seihatsu
     */
    public RString getCk_seihatsu() {
        return ck_seihatsu;
    }

    /**
     * setCk_seihatsu
     *
     * @param ck_seihatsu ck_seihatsu
     */
    public void setCk_seihatsu(RString ck_seihatsu) {
        this.ck_seihatsu = ck_seihatsu;
    }

    /**
     * getCk_buttonKakehazushi
     *
     * @return ck_buttonKakehazushi
     */
    public RString getCk_buttonKakehazushi() {
        return ck_buttonKakehazushi;
    }

    /**
     * setCk_buttonKakehazushi
     *
     * @param ck_buttonKakehazushi ck_buttonKakehazushi
     */
    public void setCk_buttonKakehazushi(RString ck_buttonKakehazushi) {
        this.ck_buttonKakehazushi = ck_buttonKakehazushi;
    }

    /**
     * getCk_joiChakudatsu
     *
     * @return ck_joiChakudatsu
     */
    public RString getCk_joiChakudatsu() {
        return ck_joiChakudatsu;
    }

    /**
     * setCk_joiChakudatsu
     *
     * @param ck_joiChakudatsu ck_joiChakudatsu
     */
    public void setCk_joiChakudatsu(RString ck_joiChakudatsu) {
        this.ck_joiChakudatsu = ck_joiChakudatsu;
    }

    /**
     * getCk_zubonChakudatsu
     *
     * @return ck_zubonChakudatsu
     */
    public RString getCk_zubonChakudatsu() {
        return ck_zubonChakudatsu;
    }

    /**
     * setCk_zubonChakudatsu
     *
     * @param ck_zubonChakudatsu ck_zubonChakudatsu
     */
    public void setCk_zubonChakudatsu(RString ck_zubonChakudatsu) {
        this.ck_zubonChakudatsu = ck_zubonChakudatsu;
    }

    /**
     * getCk_kutsushitaChakudatsu
     *
     * @return ck_kutsushitaChakudatsu
     */
    public RString getCk_kutsushitaChakudatsu() {
        return ck_kutsushitaChakudatsu;
    }

    /**
     * setCk_kutsushitaChakudatsu
     *
     * @param ck_kutsushitaChakudatsu ck_kutsushitaChakudatsu
     */
    public void setCk_kutsushitaChakudatsu(RString ck_kutsushitaChakudatsu) {
        this.ck_kutsushitaChakudatsu = ck_kutsushitaChakudatsu;
    }

    /**
     * getCk_koshitsuSeiso
     *
     * @return ck_koshitsuSeiso
     */
    public RString getCk_koshitsuSeiso() {
        return ck_koshitsuSeiso;
    }

    /**
     * setCk_koshitsuSeiso
     *
     * @param ck_koshitsuSeiso ck_koshitsuSeiso
     */
    public void setCk_koshitsuSeiso(RString ck_koshitsuSeiso) {
        this.ck_koshitsuSeiso = ck_koshitsuSeiso;
    }

    /**
     * getCk_gaishutsuHindo
     *
     * @return ck_gaishutsuHindo
     */
    public RString getCk_gaishutsuHindo() {
        return ck_gaishutsuHindo;
    }

    /**
     * setCk_gaishutsuHindo
     *
     * @param ck_gaishutsuHindo ck_gaishutsuHindo
     */
    public void setCk_gaishutsuHindo(RString ck_gaishutsuHindo) {
        this.ck_gaishutsuHindo = ck_gaishutsuHindo;
    }

    /**
     * getCk_ishiDentatsu
     *
     * @return ck_ishiDentatsu
     */
    public RString getCk_ishiDentatsu() {
        return ck_ishiDentatsu;
    }

    /**
     * setCk_ishiDentatsu
     *
     * @param ck_ishiDentatsu ck_ishiDentatsu
     */
    public void setCk_ishiDentatsu(RString ck_ishiDentatsu) {
        this.ck_ishiDentatsu = ck_ishiDentatsu;
    }

    /**
     * getCk_hanno
     *
     * @return ck_hanno
     */
    public RString getCk_hanno() {
        return ck_hanno;
    }

    /**
     * setCk_hanno
     *
     * @param ck_hanno ck_hanno
     */
    public void setCk_hanno(RString ck_hanno) {
        this.ck_hanno = ck_hanno;
    }

    /**
     * getCk_nikka
     *
     * @return ck_nikka
     */
    public RString getCk_nikka() {
        return ck_nikka;
    }

    /**
     * setCk_nikka
     *
     * @param ck_nikka ck_nikka
     */
    public void setCk_nikka(RString ck_nikka) {
        this.ck_nikka = ck_nikka;
    }

    /**
     * getCk_seinengappi
     *
     * @return ck_seinengappi
     */
    public RString getCk_seinengappi() {
        return ck_seinengappi;
    }

    /**
     * setCk_seinengappi
     *
     * @param ck_seinengappi ck_seinengappi
     */
    public void setCk_seinengappi(RString ck_seinengappi) {
        this.ck_seinengappi = ck_seinengappi;
    }

    /**
     * getCk_tankiKioku
     *
     * @return ck_tankiKioku
     */
    public RString getCk_tankiKioku() {
        return ck_tankiKioku;
    }

    /**
     * setCk_tankiKioku
     *
     * @param ck_tankiKioku ck_tankiKioku
     */
    public void setCk_tankiKioku(RString ck_tankiKioku) {
        this.ck_tankiKioku = ck_tankiKioku;
    }

    /**
     * getCk_namae
     *
     * @return ck_namae
     */
    public RString getCk_namae() {
        return ck_namae;
    }

    /**
     * setCk_namae
     *
     * @param ck_namae ck_namae
     */
    public void setCk_namae(RString ck_namae) {
        this.ck_namae = ck_namae;
    }

    /**
     * getCk_kisetsu
     *
     * @return ck_kisetsu
     */
    public RString getCk_kisetsu() {
        return ck_kisetsu;
    }

    /**
     * setCk_kisetsu
     *
     * @param ck_kisetsu ck_kisetsu
     */
    public void setCk_kisetsu(RString ck_kisetsu) {
        this.ck_kisetsu = ck_kisetsu;
    }

    /**
     * getCk_basho
     *
     * @return ck_basho
     */
    public RString getCk_basho() {
        return ck_basho;
    }

    /**
     * setCk_basho
     *
     * @param ck_basho ck_basho
     */
    public void setCk_basho(RString ck_basho) {
        this.ck_basho = ck_basho;
    }

    /**
     * getCk_haikai
     *
     * @return ck_haikai
     */
    public RString getCk_haikai() {
        return ck_haikai;
    }

    /**
     * setCk_haikai
     *
     * @param ck_haikai ck_haikai
     */
    public void setCk_haikai(RString ck_haikai) {
        this.ck_haikai = ck_haikai;
    }

    /**
     * getCk_gaishutsu
     *
     * @return ck_gaishutsu
     */
    public RString getCk_gaishutsu() {
        return ck_gaishutsu;
    }

    /**
     * setCk_gaishutsu
     *
     * @param ck_gaishutsu ck_gaishutsu
     */
    public void setCk_gaishutsu(RString ck_gaishutsu) {
        this.ck_gaishutsu = ck_gaishutsu;
    }

    /**
     * getCk_higaiteki
     *
     * @return ck_higaiteki
     */
    public RString getCk_higaiteki() {
        return ck_higaiteki;
    }

    /**
     * setCk_higaiteki
     *
     * @param ck_higaiteki ck_higaiteki
     */
    public void setCk_higaiteki(RString ck_higaiteki) {
        this.ck_higaiteki = ck_higaiteki;
    }

    /**
     * getCk_sakuwa
     *
     * @return ck_sakuwa
     */
    public RString getCk_sakuwa() {
        return ck_sakuwa;
    }

    /**
     * setCk_sakuwa
     *
     * @param ck_sakuwa ck_sakuwa
     */
    public void setCk_sakuwa(RString ck_sakuwa) {
        this.ck_sakuwa = ck_sakuwa;
    }

    /**
     * getCk_genshiGencho
     *
     * @return ck_genshiGencho
     */
    public RString getCk_genshiGencho() {
        return ck_genshiGencho;
    }

    /**
     * setCk_genshiGencho
     *
     * @param ck_genshiGencho ck_genshiGencho
     */
    public void setCk_genshiGencho(RString ck_genshiGencho) {
        this.ck_genshiGencho = ck_genshiGencho;
    }

    /**
     * getCk_kanjoHuantei
     *
     * @return ck_kanjoHuantei
     */
    public RString getCk_kanjoHuantei() {
        return ck_kanjoHuantei;
    }

    /**
     * setCk_kanjoHuantei
     *
     * @param ck_kanjoHuantei ck_kanjoHuantei
     */
    public void setCk_kanjoHuantei(RString ck_kanjoHuantei) {
        this.ck_kanjoHuantei = ck_kanjoHuantei;
    }

    /**
     * getCk_chuyaGyakuten
     *
     * @return ck_chuyaGyakuten
     */
    public RString getCk_chuyaGyakuten() {
        return ck_chuyaGyakuten;
    }

    /**
     * setCk_chuyaGyakuten
     *
     * @param ck_chuyaGyakuten ck_chuyaGyakuten
     */
    public void setCk_chuyaGyakuten(RString ck_chuyaGyakuten) {
        this.ck_chuyaGyakuten = ck_chuyaGyakuten;
    }

    /**
     * getCk_bogenBoko
     *
     * @return ck_bogenBoko
     */
    public RString getCk_bogenBoko() {
        return ck_bogenBoko;
    }

    /**
     * setCk_bogenBoko
     *
     * @param ck_bogenBoko ck_bogenBoko
     */
    public void setCk_bogenBoko(RString ck_bogenBoko) {
        this.ck_bogenBoko = ck_bogenBoko;
    }

    /**
     * getCk_onajiHanashi
     *
     * @return ck_onajiHanashi
     */
    public RString getCk_onajiHanashi() {
        return ck_onajiHanashi;
    }

    /**
     * setCk_onajiHanashi
     *
     * @param ck_onajiHanashi ck_onajiHanashi
     */
    public void setCk_onajiHanashi(RString ck_onajiHanashi) {
        this.ck_onajiHanashi = ck_onajiHanashi;
    }

    /**
     * getCk_ogoe
     *
     * @return ck_ogoe
     */
    public RString getCk_ogoe() {
        return ck_ogoe;
    }

    /**
     * setCk_ogoe
     *
     * @param ck_ogoe ck_ogoe
     */
    public void setCk_ogoe(RString ck_ogoe) {
        this.ck_ogoe = ck_ogoe;
    }

    /**
     * getCk_kaigoNiTeiko
     *
     * @return ck_kaigoNiTeiko
     */
    public RString getCk_kaigoNiTeiko() {
        return ck_kaigoNiTeiko;
    }

    /**
     * setCk_kaigoNiTeiko
     *
     * @param ck_kaigoNiTeiko ck_kaigoNiTeiko
     */
    public void setCk_kaigoNiTeiko(RString ck_kaigoNiTeiko) {
        this.ck_kaigoNiTeiko = ck_kaigoNiTeiko;
    }

    /**
     * getCk_ochitsuki
     *
     * @return ck_ochitsuki
     */
    public RString getCk_ochitsuki() {
        return ck_ochitsuki;
    }

    /**
     * setCk_ochitsuki
     *
     * @param ck_ochitsuki ck_ochitsuki
     */
    public void setCk_ochitsuki(RString ck_ochitsuki) {
        this.ck_ochitsuki = ck_ochitsuki;
    }

    /**
     * getCk_hitoriDeDetagaru
     *
     * @return ck_hitoriDeDetagaru
     */
    public RString getCk_hitoriDeDetagaru() {
        return ck_hitoriDeDetagaru;
    }

    /**
     * setCk_hitoriDeDetagaru
     *
     * @param ck_hitoriDeDetagaru ck_hitoriDeDetagaru
     */
    public void setCk_hitoriDeDetagaru(RString ck_hitoriDeDetagaru) {
        this.ck_hitoriDeDetagaru = ck_hitoriDeDetagaru;
    }

    /**
     * getCk_shushuheki
     *
     * @return ck_shushuheki
     */
    public RString getCk_shushuheki() {
        return ck_shushuheki;
    }

    /**
     * setCk_shushuheki
     *
     * @param ck_shushuheki ck_shushuheki
     */
    public void setCk_shushuheki(RString ck_shushuheki) {
        this.ck_shushuheki = ck_shushuheki;
    }

    /**
     * getCk_hiNoHushimatsu
     *
     * @return ck_hiNoHushimatsu
     */
    public RString getCk_hiNoHushimatsu() {
        return ck_hiNoHushimatsu;
    }

    /**
     * setCk_hiNoHushimatsu
     *
     * @param ck_hiNoHushimatsu ck_hiNoHushimatsu
     */
    public void setCk_hiNoHushimatsu(RString ck_hiNoHushimatsu) {
        this.ck_hiNoHushimatsu = ck_hiNoHushimatsu;
    }

    /**
     * getCk_monoYaIruiWoKowasu
     *
     * @return ck_monoYaIruiWoKowasu
     */
    public RString getCk_monoYaIruiWoKowasu() {
        return ck_monoYaIruiWoKowasu;
    }

    /**
     * setCk_monoYaIruiWoKowasu
     *
     * @param ck_monoYaIruiWoKowasu ck_monoYaIruiWoKowasu
     */
    public void setCk_monoYaIruiWoKowasu(RString ck_monoYaIruiWoKowasu) {
        this.ck_monoYaIruiWoKowasu = ck_monoYaIruiWoKowasu;
    }

    /**
     * getCk_huketsuKoi
     *
     * @return ck_huketsuKoi
     */
    public RString getCk_huketsuKoi() {
        return ck_huketsuKoi;
    }

    /**
     * setCk_huketsuKoi
     *
     * @param ck_huketsuKoi ck_huketsuKoi
     */
    public void setCk_huketsuKoi(RString ck_huketsuKoi) {
        this.ck_huketsuKoi = ck_huketsuKoi;
    }

    /**
     * getCk_ishokuKodo
     *
     * @return ck_ishokuKodo
     */
    public RString getCk_ishokuKodo() {
        return ck_ishokuKodo;
    }

    /**
     * setCk_ishokuKodo
     *
     * @param ck_ishokuKodo ck_ishokuKodo
     */
    public void setCk_ishokuKodo(RString ck_ishokuKodo) {
        this.ck_ishokuKodo = ck_ishokuKodo;
    }

    /**
     * getCk_hidoiMonowasure
     *
     * @return ck_hidoiMonowasure
     */
    public RString getCk_hidoiMonowasure() {
        return ck_hidoiMonowasure;
    }

    /**
     * setCk_hidoiMonowasure
     *
     * @param ck_hidoiMonowasure ck_hidoiMonowasure
     */
    public void setCk_hidoiMonowasure(RString ck_hidoiMonowasure) {
        this.ck_hidoiMonowasure = ck_hidoiMonowasure;
    }

    /**
     * getCk_seitekiMeiwakuKoi
     *
     * @return ck_seitekiMeiwakuKoi
     */
    public RString getCk_seitekiMeiwakuKoi() {
        return ck_seitekiMeiwakuKoi;
    }

    /**
     * setCk_seitekiMeiwakuKoi
     *
     * @param ck_seitekiMeiwakuKoi ck_seitekiMeiwakuKoi
     */
    public void setCk_seitekiMeiwakuKoi(RString ck_seitekiMeiwakuKoi) {
        this.ck_seitekiMeiwakuKoi = ck_seitekiMeiwakuKoi;
    }

    /**
     * getCk_hitorigotoHitoriwarai
     *
     * @return ck_hitorigotoHitoriwarai
     */
    public RString getCk_hitorigotoHitoriwarai() {
        return ck_hitorigotoHitoriwarai;
    }

    /**
     * setCk_hitorigotoHitoriwarai
     *
     * @param ck_hitorigotoHitoriwarai ck_hitorigotoHitoriwarai
     */
    public void setCk_hitorigotoHitoriwarai(RString ck_hitorigotoHitoriwarai) {
        this.ck_hitorigotoHitoriwarai = ck_hitorigotoHitoriwarai;
    }

    /**
     * getCk_jibunKatte
     *
     * @return ck_jibunKatte
     */
    public RString getCk_jibunKatte() {
        return ck_jibunKatte;
    }

    /**
     * setCk_jibunKatte
     *
     * @param ck_jibunKatte ck_jibunKatte
     */
    public void setCk_jibunKatte(RString ck_jibunKatte) {
        this.ck_jibunKatte = ck_jibunKatte;
    }

    /**
     * getCk_hanashiGaMatomaranai
     *
     * @return ck_hanashiGaMatomaranai
     */
    public RString getCk_hanashiGaMatomaranai() {
        return ck_hanashiGaMatomaranai;
    }

    /**
     * setCk_hanashiGaMatomaranai
     *
     * @param ck_hanashiGaMatomaranai ck_hanashiGaMatomaranai
     */
    public void setCk_hanashiGaMatomaranai(RString ck_hanashiGaMatomaranai) {
        this.ck_hanashiGaMatomaranai = ck_hanashiGaMatomaranai;
    }

    /**
     * getCk_kusuri
     *
     * @return ck_kusuri
     */
    public RString getCk_kusuri() {
        return ck_kusuri;
    }

    /**
     * setCk_kusuri
     *
     * @param ck_kusuri ck_kusuri
     */
    public void setCk_kusuri(RString ck_kusuri) {
        this.ck_kusuri = ck_kusuri;
    }

    /**
     * getCk_kinsenKanri
     *
     * @return ck_kinsenKanri
     */
    public RString getCk_kinsenKanri() {
        return ck_kinsenKanri;
    }

    /**
     * setCk_kinsenKanri
     *
     * @param ck_kinsenKanri ck_kinsenKanri
     */
    public void setCk_kinsenKanri(RString ck_kinsenKanri) {
        this.ck_kinsenKanri = ck_kinsenKanri;
    }

    /**
     * getCk_ishiKettei
     *
     * @return ck_ishiKettei
     */
    public RString getCk_ishiKettei() {
        return ck_ishiKettei;
    }

    /**
     * setCk_ishiKettei
     *
     * @param ck_ishiKettei ck_ishiKettei
     */
    public void setCk_ishiKettei(RString ck_ishiKettei) {
        this.ck_ishiKettei = ck_ishiKettei;
    }

    /**
     * getCk_mukanshin
     *
     * @return ck_mukanshin
     */
    public RString getCk_mukanshin() {
        return ck_mukanshin;
    }

    /**
     * setCk_mukanshin
     *
     * @param ck_mukanshin ck_mukanshin
     */
    public void setCk_mukanshin(RString ck_mukanshin) {
        this.ck_mukanshin = ck_mukanshin;
    }

    /**
     * getCk_shudanHutekio
     *
     * @return ck_shudanHutekio
     */
    public RString getCk_shudanHutekio() {
        return ck_shudanHutekio;
    }

    /**
     * setCk_shudanHutekio
     *
     * @param ck_shudanHutekio ck_shudanHutekio
     */
    public void setCk_shudanHutekio(RString ck_shudanHutekio) {
        this.ck_shudanHutekio = ck_shudanHutekio;
    }

    /**
     * getCk_denwa
     *
     * @return ck_denwa
     */
    public RString getCk_denwa() {
        return ck_denwa;
    }

    /**
     * setCk_denwa
     *
     * @param ck_denwa ck_denwa
     */
    public void setCk_denwa(RString ck_denwa) {
        this.ck_denwa = ck_denwa;
    }

    /**
     * getCk_kaimono
     *
     * @return ck_kaimono
     */
    public RString getCk_kaimono() {
        return ck_kaimono;
    }

    /**
     * setCk_kaimono
     *
     * @param ck_kaimono ck_kaimono
     */
    public void setCk_kaimono(RString ck_kaimono) {
        this.ck_kaimono = ck_kaimono;
    }

    /**
     * getCk_chori
     *
     * @return ck_chori
     */
    public RString getCk_chori() {
        return ck_chori;
    }

    /**
     * setCk_chori
     *
     * @param ck_chori ck_chori
     */
    public void setCk_chori(RString ck_chori) {
        this.ck_chori = ck_chori;
    }

    /**
     * getCk_tenteki
     *
     * @return ck_tenteki
     */
    public RString getCk_tenteki() {
        return ck_tenteki;
    }

    /**
     * setCk_tenteki
     *
     * @param ck_tenteki ck_tenteki
     */
    public void setCk_tenteki(RString ck_tenteki) {
        this.ck_tenteki = ck_tenteki;
    }

    /**
     * getCk_chushinJomyakuEiyo
     *
     * @return ck_chushinJomyakuEiyo
     */
    public RString getCk_chushinJomyakuEiyo() {
        return ck_chushinJomyakuEiyo;
    }

    /**
     * setCk_chushinJomyakuEiyo
     *
     * @param ck_chushinJomyakuEiyo ck_chushinJomyakuEiyo
     */
    public void setCk_chushinJomyakuEiyo(RString ck_chushinJomyakuEiyo) {
        this.ck_chushinJomyakuEiyo = ck_chushinJomyakuEiyo;
    }

    /**
     * getCk_toseki
     *
     * @return ck_toseki
     */
    public RString getCk_toseki() {
        return ck_toseki;
    }

    /**
     * setCk_toseki
     *
     * @param ck_toseki ck_toseki
     */
    public void setCk_toseki(RString ck_toseki) {
        this.ck_toseki = ck_toseki;
    }

    /**
     * getCk_stomaShochi
     *
     * @return ck_stomaShochi
     */
    public RString getCk_stomaShochi() {
        return ck_stomaShochi;
    }

    /**
     * setCk_stomaShochi
     *
     * @param ck_stomaShochi ck_stomaShochi
     */
    public void setCk_stomaShochi(RString ck_stomaShochi) {
        this.ck_stomaShochi = ck_stomaShochi;
    }

    /**
     * getCk_sansoRyoho
     *
     * @return ck_sansoRyoho
     */
    public RString getCk_sansoRyoho() {
        return ck_sansoRyoho;
    }

    /**
     * setCk_sansoRyoho
     *
     * @param ck_sansoRyoho ck_sansoRyoho
     */
    public void setCk_sansoRyoho(RString ck_sansoRyoho) {
        this.ck_sansoRyoho = ck_sansoRyoho;
    }

    /**
     * getCk_respirator
     *
     * @return ck_respirator
     */
    public RString getCk_respirator() {
        return ck_respirator;
    }

    /**
     * setCk_respirator
     *
     * @param ck_respirator ck_respirator
     */
    public void setCk_respirator(RString ck_respirator) {
        this.ck_respirator = ck_respirator;
    }

    /**
     * getCk_kikanSekkai
     *
     * @return ck_kikanSekkai
     */
    public RString getCk_kikanSekkai() {
        return ck_kikanSekkai;
    }

    /**
     * setCk_kikanSekkai
     *
     * @param ck_kikanSekkai ck_kikanSekkai
     */
    public void setCk_kikanSekkai(RString ck_kikanSekkai) {
        this.ck_kikanSekkai = ck_kikanSekkai;
    }

    /**
     * getCk_totsuKango
     *
     * @return ck_totsuKango
     */
    public RString getCk_totsuKango() {
        return ck_totsuKango;
    }

    /**
     * setCk_totsuKango
     *
     * @param ck_totsuKango ck_totsuKango
     */
    public void setCk_totsuKango(RString ck_totsuKango) {
        this.ck_totsuKango = ck_totsuKango;
    }

    /**
     * getCk_keikanEiyo
     *
     * @return ck_keikanEiyo
     */
    public RString getCk_keikanEiyo() {
        return ck_keikanEiyo;
    }

    /**
     * setCk_keikanEiyo
     *
     * @param ck_keikanEiyo ck_keikanEiyo
     */
    public void setCk_keikanEiyo(RString ck_keikanEiyo) {
        this.ck_keikanEiyo = ck_keikanEiyo;
    }

    /**
     * getCk_monitorSokutei
     *
     * @return ck_monitorSokutei
     */
    public RString getCk_monitorSokutei() {
        return ck_monitorSokutei;
    }

    /**
     * setCk_monitorSokutei
     *
     * @param ck_monitorSokutei ck_monitorSokutei
     */
    public void setCk_monitorSokutei(RString ck_monitorSokutei) {
        this.ck_monitorSokutei = ck_monitorSokutei;
    }

    /**
     * getCk_jokusoShochi
     *
     * @return ck_jokusoShochi
     */
    public RString getCk_jokusoShochi() {
        return ck_jokusoShochi;
    }

    /**
     * setCk_jokusoShochi
     *
     * @param ck_jokusoShochi ck_jokusoShochi
     */
    public void setCk_jokusoShochi(RString ck_jokusoShochi) {
        this.ck_jokusoShochi = ck_jokusoShochi;
    }

    /**
     * getCk_catheter
     *
     * @return ck_catheter
     */
    public RString getCk_catheter() {
        return ck_catheter;
    }

    /**
     * setCk_catheter
     *
     * @param ck_catheter ck_catheter
     */
    public void setCk_catheter(RString ck_catheter) {
        this.ck_catheter = ck_catheter;
    }

    /**
     * getCk_nitchuNoSeikatsuNiTsuite
     *
     * @return ck_nitchuNoSeikatsuNiTsuite
     */
    public RString getCk_nitchuNoSeikatsuNiTsuite() {
        return ck_nitchuNoSeikatsuNiTsuite;
    }

    /**
     * setCk_nitchuNoSeikatsuNiTsuite
     *
     * @param ck_nitchuNoSeikatsuNiTsuite ck_nitchuNoSeikatsuNiTsuite
     */
    public void setCk_nitchuNoSeikatsuNiTsuite(RString ck_nitchuNoSeikatsuNiTsuite) {
        this.ck_nitchuNoSeikatsuNiTsuite = ck_nitchuNoSeikatsuNiTsuite;
    }

    /**
     * getCk_gaishutsuHindoNiTsuite
     *
     * @return ck_gaishutsuHindoNiTsuite
     */
    public RString getCk_gaishutsuHindoNiTsuite() {
        return ck_gaishutsuHindoNiTsuite;
    }

    /**
     * setCk_gaishutsuHindoNiTsuite
     *
     * @param ck_gaishutsuHindoNiTsuite ck_gaishutsuHindoNiTsuite
     */
    public void setCk_gaishutsuHindoNiTsuite(RString ck_gaishutsuHindoNiTsuite) {
        this.ck_gaishutsuHindoNiTsuite = ck_gaishutsuHindoNiTsuite;
    }

    /**
     * getCk_jokyoHenka
     *
     * @return ck_jokyoHenka
     */
    public RString getCk_jokyoHenka() {
        return ck_jokyoHenka;
    }

    /**
     * setCk_jokyoHenka
     *
     * @param ck_jokyoHenka ck_jokyoHenka
     */
    public void setCk_jokyoHenka(RString ck_jokyoHenka) {
        this.ck_jokyoHenka = ck_jokyoHenka;
    }

    /**
     * getNinchishoNichijoSeikatsuJiritsudoCode
     *
     * @return ninchishoNichijoSeikatsuJiritsudoCode
     */
    public Code getNinchishoNichijoSeikatsuJiritsudoCode() {
        return ninchishoNichijoSeikatsuJiritsudoCode;
    }

    /**
     * setNinchishoNichijoSeikatsuJiritsudoCode
     *
     * @param ninchishoNichijoSeikatsuJiritsudoCode
     * ninchishoNichijoSeikatsuJiritsudoCode
     */
    public void setNinchishoNichijoSeikatsuJiritsudoCode(Code ninchishoNichijoSeikatsuJiritsudoCode) {
        this.ninchishoNichijoSeikatsuJiritsudoCode = ninchishoNichijoSeikatsuJiritsudoCode;
    }

    /**
     * getShogaiNichijoSeikatsuJiritsudoCode
     *
     * @return shogaiNichijoSeikatsuJiritsudoCode
     */
    public Code getShogaiNichijoSeikatsuJiritsudoCode() {
        return shogaiNichijoSeikatsuJiritsudoCode;
    }

    /**
     * setShogaiNichijoSeikatsuJiritsudoCode
     *
     * @param shogaiNichijoSeikatsuJiritsudoCode
     * shogaiNichijoSeikatsuJiritsudoCode
     */
    public void setShogaiNichijoSeikatsuJiritsudoCode(Code shogaiNichijoSeikatsuJiritsudoCode) {
        this.shogaiNichijoSeikatsuJiritsudoCode = shogaiNichijoSeikatsuJiritsudoCode;
    }
// </editor-fold>
}
