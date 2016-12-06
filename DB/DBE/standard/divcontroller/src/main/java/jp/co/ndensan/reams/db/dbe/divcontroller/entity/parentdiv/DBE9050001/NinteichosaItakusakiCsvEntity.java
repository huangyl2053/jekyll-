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

    @CsvField(order = 10, name = "保険者")
    private final RString hokensha;
    @CsvField(order = 20, name = "その他機関コード")
    private final RString sonotaKikanCode;
    @CsvField(order = 30, name = "機関名称")
    private final RString kikanMeisho;
    @CsvField(order = 40, name = "機関名称カナ")
    private final RString kikanMeishoKana;
    @CsvField(order = 50, name = "郵便番号")
    private final RString yubinNo;
    @CsvField(order = 60, name = "住所")
    private final RString jusho;
    @CsvField(order = 70, name = "住所カナ")
    private final RString jushoKana;
    @CsvField(order = 80, name = "電話番号")
    private final RString telNo;
    @CsvField(order = 90, name = "調査委託区分")
    private final RString chosaItakuKubun;
    @CsvField(order = 100, name = "割付定員")
    private final RString waritsukeTeiin;
    @CsvField(order = 110, name = "割付地区")
    private final RString waritsukeChiku;
    @CsvField(order = 120, name = "機関の区分")
    private final RString kikanKubun;
    @CsvField(order = 130, name = "廃止フラグ")
    private final RString haishiFlag;

    /**
     * コンストラクタです。
     *
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
     */
    public NinteichosaItakusakiCsvEntity(
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
            RString haishiFlag) {
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
    }
}
