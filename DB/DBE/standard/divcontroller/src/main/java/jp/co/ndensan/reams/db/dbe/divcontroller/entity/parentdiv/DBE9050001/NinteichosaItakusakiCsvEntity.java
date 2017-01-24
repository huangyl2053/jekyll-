/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * その他機関情報出力用CSVEntityクラスです。
 *
 * @reamsid_L DBE-1360-010 suguangjun
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaItakusakiCsvEntity {

    @CsvField(order = 10, name = "証記載保険者番号")
    private final RString hokenshaNo;
    @CsvField(order = 20, name = "証記載保険者")
    private final RString hokensha;
    @CsvField(order = 30, name = "その他機関コード")
    private final RString sonotaKikanCode;
    @CsvField(order = 40, name = "機関名称")
    private final RString kikanMeisho;
    @CsvField(order = 50, name = "機関名称カナ")
    private final RString kikanMeishoKana;
    @CsvField(order = 60, name = "郵便番号")
    private final RString yubinNo;
    @CsvField(order = 70, name = "住所")
    private final RString jusho;
    @CsvField(order = 80, name = "住所カナ")
    private final RString jushoKana;
    @CsvField(order = 90, name = "電話番号")
    private final RString telNo;
    @CsvField(order = 100, name = "調査委託区分")
    private final RString chosaItakuKubun;
    @CsvField(order = 110, name = "割付定員")
    private final RString waritsukeTeiin;
    @CsvField(order = 120, name = "割付地区")
    private final RString waritsukeChiku;
    @CsvField(order = 130, name = "機関の区分")
    private final RString kikanKubun;
    @CsvField(order = 140, name = "その他機関の状況")
    private final RString haishiFlag;
    @CsvField(order = 150, name = "金融機関コード")
    private final RString kinyuKikan;
    @CsvField(order = 160, name = "支店コード")
    private final RString kinyuKikanShiten;
    @CsvField(order = 170, name = "預金種別")
    private final RString yokinShubetsu;
    @CsvField(order = 180, name = "口座番号")
    private final RString kozaNo;
    @CsvField(order = 190, name = "口座名義人")
    private final RString kozaMeiginin;
    @CsvField(order = 200, name = "漢字名義人")
    private final RString kanjiMeiginin;

    /**
     * コンストラクタです。
     *
     * @param hokenshaNo
     * @param hokensha
     * @param sonotaKikanCode
     * @param kikanMeisho
     * @param kikanMeishoKana
     * @param yubinNo
     * @param jusho
     * @param jushoKana
     * @param telNo
     * @param chosaItakuKubun
     * @param waritsukeTeiin
     * @param waritsukeChiku
     * @param kikanKubun
     * @param haishiFlag
     * @param kinyuKikan
     * @param kinyuKikanShiten
     * @param yokinShubetsu
     * @param kozaNo
     * @param kozaMeiginin
     * @param kanjiMeiginin
     */
    public NinteichosaItakusakiCsvEntity(
            RString hokenshaNo,
            RString hokensha,
            RString sonotaKikanCode,
            RString kikanMeisho,
            RString kikanMeishoKana,
            RString yubinNo,
            RString jusho,
            RString jushoKana,
            RString telNo,
            RString chosaItakuKubun,
            RString waritsukeTeiin,
            RString waritsukeChiku,
            RString kikanKubun,
            RString haishiFlag,
            RString kinyuKikan,
            RString kinyuKikanShiten,
            RString yokinShubetsu,
            RString kozaNo,
            RString kozaMeiginin,
            RString kanjiMeiginin) {
        this.hokenshaNo = hokenshaNo;
        this.hokensha = hokensha;
        this.sonotaKikanCode = sonotaKikanCode;
        this.kikanMeisho = kikanMeisho;
        this.kikanMeishoKana = kikanMeishoKana;
        this.chosaItakuKubun = chosaItakuKubun;
        this.waritsukeTeiin = waritsukeTeiin;
        this.waritsukeChiku = waritsukeChiku;
        this.kikanKubun = kikanKubun;
        this.haishiFlag = haishiFlag;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.telNo = telNo;
        this.jushoKana = jushoKana;
        this.kinyuKikan = kinyuKikan;
        this.kinyuKikanShiten = kinyuKikanShiten;
        this.yokinShubetsu = yokinShubetsu;
        this.kozaNo = kozaNo;
        this.kozaMeiginin = kozaMeiginin;
        this.kanjiMeiginin = kanjiMeiginin;
    }
}
