/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.csv.ninteichosainmaster;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査員情報出力用CSVBusinessクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosainMasterCsvBusiness {

    private final RString shichosonCode;
    private final RString shichosonMeisho;
    private final RString ninteiChosainNo;
    private final RString chosainShimei;
    private final RString chosainKanaShimei;
    private final RString ninteichosaItakusakiCode;
    private final RString jigyoshaMeisho;
    private final RString seibetsu;
    private final RString chikuCode;
    private final RString chikuMeisho;
    private final RString chosainShikaku;
    private final RString chosaKanoNinzuPerMonth;
    private final RString jokyoFlag;
    private final RString yubinNo;
    private final RString jusho;
    private final RString telNo;
    private final RString faxNo;
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
     * @param seibetsu 性別
     * @param chikuCode 地区コード
     * @param chikuMeisho 地区名称
     * @param chosainShikaku 調査員資格
     * @param chosaKanoNinzuPerMonth 調査可能人数
     * @param jokyoFlag 状況フラグ
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param telNo 電話番号
     * @param faxNo ＦＡＸ番号
     * @param shozokuKikanName 所属機関名称
     */
    public NinteiChosainMasterCsvBusiness(
            RString shichosonCode,
            RString shichosonMeisho,
            RString ninteiChosainNo,
            RString chosainShimei,
            RString chosainKanaShimei,
            RString ninteichosaItakusakiCode,
            RString jigyoshaMeisho,
            RString seibetsu,
            RString chikuCode,
            RString chikuMeisho,
            RString chosainShikaku,
            RString chosaKanoNinzuPerMonth,
            RString jokyoFlag,
            RString yubinNo,
            RString jusho,
            RString telNo,
            RString faxNo,
            RString shozokuKikanName) {
        this.shichosonCode = shichosonCode;
        this.shichosonMeisho = shichosonMeisho;
        this.ninteiChosainNo = ninteiChosainNo;
        this.chosainShimei = chosainShimei;
        this.chosainKanaShimei = chosainKanaShimei;
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
        this.jigyoshaMeisho = jigyoshaMeisho;
        this.seibetsu = seibetsu;
        this.chikuCode = chikuCode;
        this.chikuMeisho = chikuMeisho;
        this.chosainShikaku = chosainShikaku;
        this.chosaKanoNinzuPerMonth = chosaKanoNinzuPerMonth;
        this.jokyoFlag = jokyoFlag;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.telNo = telNo;
        this.faxNo = faxNo;
        this.shozokuKikanName = shozokuKikanName;
    }
}
