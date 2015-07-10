/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * KyufuKanrihyoCSVDataEntityのcsv項目定義クラスです
 *
* @author N2810 久保 里史
 */
public class KyufuKanrihyoCSVDataEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString recordShubetsu;
    @CsvField(order = 20, name = "連番")
    private RString renban;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString kokanjohoShikibetsuNo;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString chohyoRecordShubetsu;
    @CsvField(order = 50, name = "審査年月")
    private RString shinsaYM;
    @CsvField(order = 60, name = "対象年月")
    private RString taishoYM;
    @CsvField(order = 70, name = "保険者番号")
    private RString hokenshaNo;
    @CsvField(order = 80, name = "事業所番号（居宅介護支援事業所）")
    private RString KyotakuShienJigyoshoNo;
    @CsvField(order = 90, name = "給付管理票情報作成区分コード")
    private RString kyufukanrihyoSakuseiKubunCode;
    @CsvField(order = 100, name = "給付管理票作成年月日")
    private RString kyufukanrihyoSakuseiYMD;
    @CsvField(order = 110, name = "給付管理票種別区分コード")
    private RString kyufukanrihyoShubetsuKubunCode;
    @CsvField(order = 120, name = "給付管理票明細行番号")
    private RString kyufukanrihyoMeisaigyoNo;
    @CsvField(order = 130, name = "被保険者番号")
    private RString hihokenshaNo;
    @CsvField(order = 140, name = "被保険者生年月日")
    private RString seinengappiYMD;
    @CsvField(order = 150, name = "被保険者性別コード")
    private RString seibetsuCode;
    @CsvField(order = 160, name = "要介護状態区分コード")
    private RString yokaigojotaiKubunCode;
    @CsvField(order = 170, name = "限度額適用期間（開始）")
    private RString gendogakuTekiyoKaishiYMD;
    @CsvField(order = 180, name = "限度額適用期間（終了）")
    private RString gendogakuTekiyoShuryoYMD;
    @CsvField(order = 190, name = "居宅・介護予防支給限度額")
    private RString kyotakuKaigoyoboShikyugendogaku;
    @CsvField(order = 200, name = "居宅サービス計画作成区分コード")
    private RString kyotakuKeikakuSakuseiKubunCode;
    @CsvField(order = 210, name = "事業所番号（サービス事業所）")
    private RString serviceTeikyoJigyoshoNo;
    @CsvField(order = 220, name = "指定/基準該当等事業所区分コード")
    private RString shiteiKijunGaitoJigyoshoKubunCode;
    @CsvField(order = 230, name = "サービス種類コード")
    private RString serviceShuruiCode;
    @CsvField(order = 240, name = "給付計画単位数/日数")
    private RString kyufuKeikakuTanisuNissu;
    @CsvField(order = 250, name = "限度額管理期間における前月までの給付計画日数")
    private RString zentsukiMadeKyufuKeikakuNissu;
    @CsvField(order = 260, name = "指定サービス分小計")
    private RString shiteiServiceShokei;
    @CsvField(order = 270, name = "基準該当サービス分小計")
    private RString kijunGaitoServiceShokei;
    @CsvField(order = 280, name = "給付計画合計単位数/日数")
    private RString kyufuKeikakuGokeiTanisuNissu;
    @CsvField(order = 290, name = "担当介護支援専門員番号")
    private RString kaigoshienSenmoninNo;
    @CsvField(order = 300, name = "委託先の居宅介護支援事業所番号")
    private RString itakusakiKyotakuKaigoshienJigyoshoNo;
    @CsvField(order = 310, name = "委託先の担当介護支援専門員番号")
    private RString itakusakiKaigoshienSenmoninNo;
    @CsvField(order = 320, name = "被保険者番号変更用市町村コード")
    private RString hihoNoHenkanShityosonCode;
    @CsvField(order = 330, name = "新被保険者番号")
    private RString shinHihokenshaNo;
    @CsvField(order = 340, name = "市町村コード")
    private RString shichosonCode;
    @CsvField(order = 350, name = "広住特措置元市町村コード")
    private RString koikiJutokuSochimotoShichosonCode;
    @CsvField(order = 360, name = "旧市町村コード")
    private RString kyoShichosonCode;
    @CsvField(order = 370, name = "識別コード")
    private RString shikibetsuCode;
    @CsvField(order = 380, name = "漢字氏名")
    private RString kanjiMeisho;
    @CsvField(order = 390, name = "事業所名称")
    private RString jigyoshoMeisho;

    public KyufuKanrihyoCSVDataEntity() {
    }

    /**
     * getrecordShubetsu
     *
     * @return recordShubetsu
     */
    public RString getRecordshubetsu() {
        return recordShubetsu;
    }

    /**
     * getrenban
     *
     * @return renban
     */
    public RString getRenban() {
        return renban;
    }

    /**
     * getkokanjohoShikibetsuNo
     *
     * @return kokanjohoShikibetsuNo
     */
    public RString getKokanjohoshikibetsuno() {
        return kokanjohoShikibetsuNo;
    }

    /**
     * getchohyoRecordShubetsu
     *
     * @return chohyoRecordShubetsu
     */
    public RString getChohyorecordshubetsu() {
        return chohyoRecordShubetsu;
    }

    /**
     * getshinsaYM
     *
     * @return shinsaYM
     */
    public RString getShinsaym() {
        return shinsaYM;
    }

    /**
     * gettaishoYM
     *
     * @return taishoYM
     */
    public RString getTaishoym() {
        return taishoYM;
    }

    /**
     * gethokenshaNo
     *
     * @return hokenshaNo
     */
    public RString getHokenshano() {
        return hokenshaNo;
    }

    /**
     * getKyotakuShienJigyoshoNo
     *
     * @return KyotakuShienJigyoshoNo
     */
    public RString getKyotakushienjigyoshono() {
        return KyotakuShienJigyoshoNo;
    }

    /**
     * getkyufukanrihyoSakuseiKubunCode
     *
     * @return kyufukanrihyoSakuseiKubunCode
     */
    public RString getKyufukanrihyosakuseikubuncode() {
        return kyufukanrihyoSakuseiKubunCode;
    }

    /**
     * getkyufukanrihyoSakuseiYMD
     *
     * @return kyufukanrihyoSakuseiYMD
     */
    public RString getKyufukanrihyosakuseiymd() {
        return kyufukanrihyoSakuseiYMD;
    }

    /**
     * getkyufukanrihyoShubetsuKubunCode
     *
     * @return kyufukanrihyoShubetsuKubunCode
     */
    public RString getKyufukanrihyoshubetsukubuncode() {
        return kyufukanrihyoShubetsuKubunCode;
    }

    /**
     * getkyufukanrihyoMeisaigyoNo
     *
     * @return kyufukanrihyoMeisaigyoNo
     */
    public RString getKyufukanrihyomeisaigyono() {
        return kyufukanrihyoMeisaigyoNo;
    }

    /**
     * gethihokenshaNo
     *
     * @return hihokenshaNo
     */
    public RString getHihokenshano() {
        return hihokenshaNo;
    }

    /**
     * getseinengappiYMD
     *
     * @return seinengappiYMD
     */
    public RString getSeinengappiymd() {
        return seinengappiYMD;
    }

    /**
     * getseibetsuCode
     *
     * @return seibetsuCode
     */
    public RString getSeibetsucode() {
        return seibetsuCode;
    }

    /**
     * getyokaigojotaiKubunCode
     *
     * @return yokaigojotaiKubunCode
     */
    public RString getYokaigojotaikubuncode() {
        return yokaigojotaiKubunCode;
    }

    /**
     * getgendogakuTekiyoKaishiYMD
     *
     * @return gendogakuTekiyoKaishiYMD
     */
    public RString getGendogakutekiyokaishiymd() {
        return gendogakuTekiyoKaishiYMD;
    }

    /**
     * getgendogakuTekiyoShuryoYMD
     *
     * @return gendogakuTekiyoShuryoYMD
     */
    public RString getGendogakutekiyoshuryoymd() {
        return gendogakuTekiyoShuryoYMD;
    }

    /**
     * getkyotakuKaigoyoboShikyugendogaku
     *
     * @return kyotakuKaigoyoboShikyugendogaku
     */
    public RString getKyotakukaigoyoboshikyugendogaku() {
        return kyotakuKaigoyoboShikyugendogaku;
    }

    /**
     * getkyotakuKeikakuSakuseiKubunCode
     *
     * @return kyotakuKeikakuSakuseiKubunCode
     */
    public RString getKyotakukeikakusakuseikubuncode() {
        return kyotakuKeikakuSakuseiKubunCode;
    }

    /**
     * getserviceTeikyoJigyoshoNo
     *
     * @return serviceTeikyoJigyoshoNo
     */
    public RString getServiceteikyojigyoshono() {
        return serviceTeikyoJigyoshoNo;
    }

    /**
     * getshiteiKijunGaitoJigyoshoKubunCode
     *
     * @return shiteiKijunGaitoJigyoshoKubunCode
     */
    public RString getShiteikijungaitojigyoshokubuncode() {
        return shiteiKijunGaitoJigyoshoKubunCode;
    }

    /**
     * getserviceShuruiCode
     *
     * @return serviceShuruiCode
     */
    public RString getServiceshuruicode() {
        return serviceShuruiCode;
    }

    /**
     * getkyufuKeikakuTanisuNissu
     *
     * @return kyufuKeikakuTanisuNissu
     */
    public RString getKyufukeikakutanisunissu() {
        return kyufuKeikakuTanisuNissu;
    }

    /**
     * getzentsukiMadeKyufuKeikakuNissu
     *
     * @return zentsukiMadeKyufuKeikakuNissu
     */
    public RString getZentsukimadekyufukeikakunissu() {
        return zentsukiMadeKyufuKeikakuNissu;
    }

    /**
     * getshiteiServiceShokei
     *
     * @return shiteiServiceShokei
     */
    public RString getShiteiserviceshokei() {
        return shiteiServiceShokei;
    }

    /**
     * getkijunGaitoServiceShokei
     *
     * @return kijunGaitoServiceShokei
     */
    public RString getKijungaitoserviceshokei() {
        return kijunGaitoServiceShokei;
    }

    /**
     * getkyufuKeikakuGokeiTanisuNissu
     *
     * @return kyufuKeikakuGokeiTanisuNissu
     */
    public RString getKyufukeikakugokeitanisunissu() {
        return kyufuKeikakuGokeiTanisuNissu;
    }

    /**
     * getkaigoshienSenmoninNo
     *
     * @return kaigoshienSenmoninNo
     */
    public RString getKaigoshiensenmoninno() {
        return kaigoshienSenmoninNo;
    }

    /**
     * getitakusakiKyotakuKaigoshienJigyoshoNo
     *
     * @return itakusakiKyotakuKaigoshienJigyoshoNo
     */
    public RString getItakusakikyotakukaigoshienjigyoshono() {
        return itakusakiKyotakuKaigoshienJigyoshoNo;
    }

    /**
     * getitakusakiKaigoshienSenmoninNo
     *
     * @return itakusakiKaigoshienSenmoninNo
     */
    public RString getItakusakikaigoshiensenmoninno() {
        return itakusakiKaigoshienSenmoninNo;
    }

    /**
     * gethihoNoHenkanShityosonCode
     *
     * @return hihoNoHenkanShityosonCode
     */
    public RString getHihonohenkanshityosoncode() {
        return hihoNoHenkanShityosonCode;
    }

    /**
     * getshinHihokenshaNo
     *
     * @return shinHihokenshaNo
     */
    public RString getShinhihokenshano() {
        return shinHihokenshaNo;
    }

    /**
     * getshichosonCode
     *
     * @return shichosonCode
     */
    public RString getShichosoncode() {
        return shichosonCode;
    }

    /**
     * getkoikiJutokuSochimotoShichosonCode
     *
     * @return koikiJutokuSochimotoShichosonCode
     */
    public RString getKoikijutokusochimotoshichosoncode() {
        return koikiJutokuSochimotoShichosonCode;
    }

    /**
     * getkyoShichosonCode
     *
     * @return kyoShichosonCode
     */
    public RString getKyoshichosoncode() {
        return kyoShichosonCode;
    }

    /**
     * getshikibetsuCode
     *
     * @return shikibetsuCode
     */
    public RString getShikibetsucode() {
        return shikibetsuCode;
    }

    /**
     * getkanjiMeisho
     *
     * @return kanjiMeisho
     */
    public RString getKanjimeisho() {
        return kanjiMeisho;
    }

    /**
     * getjigyoshoMeisho
     *
     * @return jigyoshoMeisho
     */
    public RString getJigyoshomeisho() {
        return jigyoshoMeisho;
    }

    /**
     * setrecordShubetsu
     *
     * @param recordShubetsu
     */
    public void setRecordshubetsu(RString recordShubetsu) {
        this.recordShubetsu = recordShubetsu;
    }

    /**
     * setrenban
     *
     * @param renban
     */
    public void setRenban(RString renban) {
        this.renban = renban;
    }

    /**
     * setkokanjohoShikibetsuNo
     *
     * @param kokanjohoShikibetsuNo
     */
    public void setKokanjohoshikibetsuno(RString kokanjohoShikibetsuNo) {
        this.kokanjohoShikibetsuNo = kokanjohoShikibetsuNo;
    }

    /**
     * setchohyoRecordShubetsu
     *
     * @param chohyoRecordShubetsu
     */
    public void setChohyorecordshubetsu(RString chohyoRecordShubetsu) {
        this.chohyoRecordShubetsu = chohyoRecordShubetsu;
    }

    /**
     * setshinsaYM
     *
     * @param shinsaYM
     */
    public void setShinsaym(RString shinsaYM) {
        this.shinsaYM = shinsaYM;
    }

    /**
     * settaishoYM
     *
     * @param taishoYM
     */
    public void setTaishoym(RString taishoYM) {
        this.taishoYM = taishoYM;
    }

    /**
     * sethokenshaNo
     *
     * @param hokenshaNo
     */
    public void setHokenshano(RString hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * setKyotakuShienJigyoshoNo
     *
     * @param KyotakuShienJigyoshoNo
     */
    public void setKyotakushienjigyoshono(RString KyotakuShienJigyoshoNo) {
        this.KyotakuShienJigyoshoNo = KyotakuShienJigyoshoNo;
    }

    /**
     * setkyufukanrihyoSakuseiKubunCode
     *
     * @param kyufukanrihyoSakuseiKubunCode
     */
    public void setKyufukanrihyosakuseikubuncode(RString kyufukanrihyoSakuseiKubunCode) {
        this.kyufukanrihyoSakuseiKubunCode = kyufukanrihyoSakuseiKubunCode;
    }

    /**
     * setkyufukanrihyoSakuseiYMD
     *
     * @param kyufukanrihyoSakuseiYMD
     */
    public void setKyufukanrihyosakuseiymd(RString kyufukanrihyoSakuseiYMD) {
        this.kyufukanrihyoSakuseiYMD = kyufukanrihyoSakuseiYMD;
    }

    /**
     * setkyufukanrihyoShubetsuKubunCode
     *
     * @param kyufukanrihyoShubetsuKubunCode
     */
    public void setKyufukanrihyoshubetsukubuncode(RString kyufukanrihyoShubetsuKubunCode) {
        this.kyufukanrihyoShubetsuKubunCode = kyufukanrihyoShubetsuKubunCode;
    }

    /**
     * setkyufukanrihyoMeisaigyoNo
     *
     * @param kyufukanrihyoMeisaigyoNo
     */
    public void setKyufukanrihyomeisaigyono(RString kyufukanrihyoMeisaigyoNo) {
        this.kyufukanrihyoMeisaigyoNo = kyufukanrihyoMeisaigyoNo;
    }

    /**
     * sethihokenshaNo
     *
     * @param hihokenshaNo
     */
    public void setHihokenshano(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * setseinengappiYMD
     *
     * @param seinengappiYMD
     */
    public void setSeinengappiymd(RString seinengappiYMD) {
        this.seinengappiYMD = seinengappiYMD;
    }

    /**
     * setseibetsuCode
     *
     * @param seibetsuCode
     */
    public void setSeibetsucode(RString seibetsuCode) {
        this.seibetsuCode = seibetsuCode;
    }

    /**
     * setyokaigojotaiKubunCode
     *
     * @param yokaigojotaiKubunCode
     */
    public void setYokaigojotaikubuncode(RString yokaigojotaiKubunCode) {
        this.yokaigojotaiKubunCode = yokaigojotaiKubunCode;
    }

    /**
     * setgendogakuTekiyoKaishiYMD
     *
     * @param gendogakuTekiyoKaishiYMD
     */
    public void setGendogakutekiyokaishiymd(RString gendogakuTekiyoKaishiYMD) {
        this.gendogakuTekiyoKaishiYMD = gendogakuTekiyoKaishiYMD;
    }

    /**
     * setgendogakuTekiyoShuryoYMD
     *
     * @param gendogakuTekiyoShuryoYMD
     */
    public void setGendogakutekiyoshuryoymd(RString gendogakuTekiyoShuryoYMD) {
        this.gendogakuTekiyoShuryoYMD = gendogakuTekiyoShuryoYMD;
    }

    /**
     * setkyotakuKaigoyoboShikyugendogaku
     *
     * @param kyotakuKaigoyoboShikyugendogaku
     */
    public void setKyotakukaigoyoboshikyugendogaku(RString kyotakuKaigoyoboShikyugendogaku) {
        this.kyotakuKaigoyoboShikyugendogaku = kyotakuKaigoyoboShikyugendogaku;
    }

    /**
     * setkyotakuKeikakuSakuseiKubunCode
     *
     * @param kyotakuKeikakuSakuseiKubunCode
     */
    public void setKyotakukeikakusakuseikubuncode(RString kyotakuKeikakuSakuseiKubunCode) {
        this.kyotakuKeikakuSakuseiKubunCode = kyotakuKeikakuSakuseiKubunCode;
    }

    /**
     * setserviceTeikyoJigyoshoNo
     *
     * @param serviceTeikyoJigyoshoNo
     */
    public void setServiceteikyojigyoshono(RString serviceTeikyoJigyoshoNo) {
        this.serviceTeikyoJigyoshoNo = serviceTeikyoJigyoshoNo;
    }

    /**
     * setshiteiKijunGaitoJigyoshoKubunCode
     *
     * @param shiteiKijunGaitoJigyoshoKubunCode
     */
    public void setShiteikijungaitojigyoshokubuncode(RString shiteiKijunGaitoJigyoshoKubunCode) {
        this.shiteiKijunGaitoJigyoshoKubunCode = shiteiKijunGaitoJigyoshoKubunCode;
    }

    /**
     * setserviceShuruiCode
     *
     * @param serviceShuruiCode
     */
    public void setServiceshuruicode(RString serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * setkyufuKeikakuTanisuNissu
     *
     * @param kyufuKeikakuTanisuNissu
     */
    public void setKyufukeikakutanisunissu(RString kyufuKeikakuTanisuNissu) {
        this.kyufuKeikakuTanisuNissu = kyufuKeikakuTanisuNissu;
    }

    /**
     * setzentsukiMadeKyufuKeikakuNissu
     *
     * @param zentsukiMadeKyufuKeikakuNissu
     */
    public void setZentsukimadekyufukeikakunissu(RString zentsukiMadeKyufuKeikakuNissu) {
        this.zentsukiMadeKyufuKeikakuNissu = zentsukiMadeKyufuKeikakuNissu;
    }

    /**
     * setshiteiServiceShokei
     *
     * @param shiteiServiceShokei
     */
    public void setShiteiserviceshokei(RString shiteiServiceShokei) {
        this.shiteiServiceShokei = shiteiServiceShokei;
    }

    /**
     * setkijunGaitoServiceShokei
     *
     * @param kijunGaitoServiceShokei
     */
    public void setKijungaitoserviceshokei(RString kijunGaitoServiceShokei) {
        this.kijunGaitoServiceShokei = kijunGaitoServiceShokei;
    }

    /**
     * setkyufuKeikakuGokeiTanisuNissu
     *
     * @param kyufuKeikakuGokeiTanisuNissu
     */
    public void setKyufukeikakugokeitanisunissu(RString kyufuKeikakuGokeiTanisuNissu) {
        this.kyufuKeikakuGokeiTanisuNissu = kyufuKeikakuGokeiTanisuNissu;
    }

    /**
     * setkaigoshienSenmoninNo
     *
     * @param kaigoshienSenmoninNo
     */
    public void setKaigoshiensenmoninno(RString kaigoshienSenmoninNo) {
        this.kaigoshienSenmoninNo = kaigoshienSenmoninNo;
    }

    /**
     * setitakusakiKyotakuKaigoshienJigyoshoNo
     *
     * @param itakusakiKyotakuKaigoshienJigyoshoNo
     */
    public void setItakusakikyotakukaigoshienjigyoshono(RString itakusakiKyotakuKaigoshienJigyoshoNo) {
        this.itakusakiKyotakuKaigoshienJigyoshoNo = itakusakiKyotakuKaigoshienJigyoshoNo;
    }

    /**
     * setitakusakiKaigoshienSenmoninNo
     *
     * @param itakusakiKaigoshienSenmoninNo
     */
    public void setItakusakikaigoshiensenmoninno(RString itakusakiKaigoshienSenmoninNo) {
        this.itakusakiKaigoshienSenmoninNo = itakusakiKaigoshienSenmoninNo;
    }

    /**
     * sethihoNoHenkanShityosonCode
     *
     * @param hihoNoHenkanShityosonCode
     */
    public void setHihonohenkanshityosoncode(RString hihoNoHenkanShityosonCode) {
        this.hihoNoHenkanShityosonCode = hihoNoHenkanShityosonCode;
    }

    /**
     * setshinHihokenshaNo
     *
     * @param shinHihokenshaNo
     */
    public void setShinhihokenshano(RString shinHihokenshaNo) {
        this.shinHihokenshaNo = shinHihokenshaNo;
    }

    /**
     * setshichosonCode
     *
     * @param shichosonCode
     */
    public void setShichosoncode(RString shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * setkoikiJutokuSochimotoShichosonCode
     *
     * @param koikiJutokuSochimotoShichosonCode
     */
    public void setKoikijutokusochimotoshichosoncode(RString koikiJutokuSochimotoShichosonCode) {
        this.koikiJutokuSochimotoShichosonCode = koikiJutokuSochimotoShichosonCode;
    }

    /**
     * setkyoShichosonCode
     *
     * @param kyoShichosonCode
     */
    public void setKyoshichosoncode(RString kyoShichosonCode) {
        this.kyoShichosonCode = kyoShichosonCode;
    }

    /**
     * setshikibetsuCode
     *
     * @param shikibetsuCode
     */
    public void setShikibetsucode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * setkanjiMeisho
     *
     * @param kanjiMeisho
     */
    public void setKanjimeisho(RString kanjiMeisho) {
        this.kanjiMeisho = kanjiMeisho;
    }

    /**
     * setjigyoshoMeisho
     *
     * @param jigyoshoMeisho
     */
    public void setJigyoshomeisho(RString jigyoshoMeisho) {
        this.jigyoshoMeisho = jigyoshoMeisho;
    }

}
