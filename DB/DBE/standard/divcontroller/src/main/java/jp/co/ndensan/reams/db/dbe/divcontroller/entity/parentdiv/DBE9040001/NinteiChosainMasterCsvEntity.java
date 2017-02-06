/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査員情報出力用CSVEntityクラスです。
 *
 * @reamsid_L DBE-0280-010 sunhaidi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosainMasterCsvEntity {

    @CsvField(order = 10, name = "市町村コード")
    private final RString shichosonCode;
    @CsvField(order = 20, name = "市町村")
    private final RString shichosonMeisho;
    @CsvField(order = 30, name = "調査員コード")
    private final RString ninteiChosainNo;
    @CsvField(order = 40, name = "調査員氏名")
    private final RString chosainShimei;
    @CsvField(order = 50, name = "調査員カナ氏名")
    private final RString chosainKanaShimei;
    @CsvField(order = 60, name = "調査委託先コード")
    private final RString ninteichosaItakusakiCode;
    @CsvField(order = 70, name = "調査委託先名称")
    private final RString jigyoshaMeisho;
    @CsvField(order = 80, name = "性別コード")
    private final RString seibetsuCode;
    @CsvField(order = 90, name = "性別")
    private final RString seibetsu;
    @CsvField(order = 100, name = "地区コード")
    private final RString chikuCode;
    @CsvField(order = 110, name = "地区名称")
    private final RString chikuMeisho;
    @CsvField(order = 120, name = "調査員資格コード")
    private final RString chosainShikakuCode;
    @CsvField(order = 130, name = "調査員資格")
    private final RString chosainShikaku;
    @CsvField(order = 140, name = "調査可能人数")
    private final RString chosaKanoNinzuPerMonth;
    @CsvField(order = 150, name = "郵便番号")
    private final RString yubinNo;
    @CsvField(order = 160, name = "住所")
    private final RString jusho;
    @CsvField(order = 170, name = "電話番号")
    private final RString telNo;
    @CsvField(order = 180, name = "ＦＡＸ番号")
    private final RString faxNo;
    @CsvField(order = 190, name = "調査員の状況")
    private final RString jokyoFlag;
    @CsvField(order = 200, name = "所属機関名称")
    private final RString shozokuKikanName;

    /**
     * コンストラクタです。
     *
     * @param shichosonCode 市町村コード
     * @param shichosonMeisho 市町村
     * @param ninteiChosainNo 調査員コード
     * @param chosainShimei 調査員氏名
     * @param chosainKanaShimei 調査員カナ氏名
     * @param ninteichosaItakusakiCode 調査委託先コード
     * @param jigyoshaMeisho 調査委託先名称
     * @param seibetsuCode 性別コード
     * @param seibetsu 性別
     * @param chikuCode 地区コード
     * @param chikuMeisho 地区名称
     * @param chosainShikakuCode 調査員資格コード
     * @param chosainShikaku 調査員資格
     * @param chosaKanoNinzuPerMonth 調査可能人数
     * @param jokyoFlag 状況フラグ
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param telNo 電話番号
     * @param faxNo ＦＡＸ番号
     * @param shozokuKikanName 所属機関名称
     */
    public NinteiChosainMasterCsvEntity(
            RString shichosonCode,
            RString shichosonMeisho,
            RString ninteiChosainNo,
            RString chosainShimei,
            RString chosainKanaShimei,
            RString ninteichosaItakusakiCode,
            RString jigyoshaMeisho,
            RString seibetsuCode,
            RString seibetsu,
            RString chikuCode,
            RString chikuMeisho,
            RString chosainShikakuCode,
            RString chosainShikaku,
            RString chosaKanoNinzuPerMonth,
            RString yubinNo,
            RString jusho,
            RString telNo,
            RString faxNo,
            RString jokyoFlag,
            RString shozokuKikanName) {
        this.shichosonCode = shichosonCode;
        this.shichosonMeisho = shichosonMeisho;
        this.ninteiChosainNo = ninteiChosainNo;
        this.chosainShimei = chosainShimei;
        this.chosainKanaShimei = chosainKanaShimei;
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
        this.jigyoshaMeisho = jigyoshaMeisho;
        this.seibetsuCode = seibetsuCode;
        this.seibetsu = seibetsu;
        this.chikuCode = chikuCode;
        this.chikuMeisho = chikuMeisho;
        this.chosainShikakuCode = chosainShikakuCode;
        this.chosainShikaku = chosainShikaku;
        this.chosaKanoNinzuPerMonth = chosaKanoNinzuPerMonth;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.telNo = telNo;
        this.faxNo = faxNo;
        this.jokyoFlag = jokyoFlag;
        this.shozokuKikanName = shozokuKikanName;
    }

}
