/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・認定調査依頼（調査結果入力用調査員データ（モバイル））出力用CSVEntityクラスです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosainInfoMobileCsvEntity {

    @CsvField(order = 1, name = "市町村コード")
    private final RString shichosonCode;
    @CsvField(order = 2, name = "市町村")
    private final RString shichosonMeisho;
    @CsvField(order = 3, name = "調査委託先コード")
    private final RString ninteichosaItakusakiCode;
    @CsvField(order = 4, name = "事業者番号")
    private final RString jigyoshaNo;
    @CsvField(order = 5, name = "調査委託先名称")
    private final RString jigyoshaMeisho;
    @CsvField(order = 6, name = "調査委託先カナ名称")
    private final RString jigyoshaMeishoKana;
    @CsvField(order = 7, name = "郵便番号")
    private final RString yubinNo;
    @CsvField(order = 8, name = "住所")
    private final RString jusho;
    @CsvField(order = 9, name = "電話番号")
    private final RString telNo;
    @CsvField(order = 10, name = "ＦＡＸ番号")
    private final RString faxNo;
    @CsvField(order = 11, name = "機関代表者氏名")
    private final RString daihyoshaName;
    @CsvField(order = 12, name = "機関代表者カナ氏名")
    private final RString daihyoshaNameKana;
    @CsvField(order = 13, name = "調査委託区分")
    private final RString chosaItakuKubun;
    @CsvField(order = 14, name = "特定調査員表示フラグ")
    private final RString tokuteiChosainDisplayFlag;
    @CsvField(order = 15, name = "割付定員")
    private final RString waritsukeTeiin;
    @CsvField(order = 16, name = "割付地区コード")
    private final RString waritsukeChiku;
    @CsvField(order = 17, name = "割付地区名称")
    private final RString waritsukeChikuName;
    @CsvField(order = 18, name = "自動割付フラグ")
    private final RString autoWaritsukeFlag;
    @CsvField(order = 19, name = "機関の区分")
    private final RString kikanKubun;
    @CsvField(order = 20, name = "状況フラグ")
    private final RString jokyoFlag;
    @CsvField(order = 21, name = "調査員コード")
    private final RString ninteiChosainCode;
    @CsvField(order = 22, name = "調査員氏名")
    private final RString chosainShimei;
    @CsvField(order = 23, name = "調査員カナ氏名")
    private final RString chosainKanaShimei;
    @CsvField(order = 24, name = "性別")
    private final RString seibetsu;
    @CsvField(order = 25, name = "地区コード")
    private final RString chikuCode;
    @CsvField(order = 26, name = "地区名称")
    private final RString chikuName;
    @CsvField(order = 27, name = "調査員資格")
    private final RString chosainShikaku;
    @CsvField(order = 28, name = "調査可能人数")
    private final RString chosaKanoNinzuPerMonth;
    @CsvField(order = 29, name = "状況フラグ")
    private final RString chosainJokyoFlag;
    @CsvField(order = 30, name = "郵便番号")
    private final RString chosainYubinNo;
    @CsvField(order = 31, name = "住所")
    private final RString chosainJusho;
    @CsvField(order = 32, name = "電話番号")
    private final RString chosainTelNo;
    @CsvField(order = 33, name = "ＦＡＸ番号")
    private final RString chosainFaxNo;
    @CsvField(order = 34, name = "所属機関名称")
    private final RString shozokuKikanName;

    /**
     * コンストラクタです。
     *
     * @param shichosonCode 市町村コード
     * @param shichosonMeisho 市町村
     * @param ninteichosaItakusakiCode 調査委託先コード
     * @param jigyoshaNo 事業者番号
     * @param jigyoshaMeisho 調査委託先名称
     * @param jigyoshaMeishoKana 調査委託先カナ名称
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param telNo 電話番号
     * @param faxNo ＦＡＸ番号
     * @param daihyoshaName 機関代表者氏名
     * @param daihyoshaNameKana 機関代表者カナ氏名
     * @param chosaItakuKubun 調査委託区分
     * @param tokuteiChosainDisplayFlag 特定調査員表示フラグ
     * @param waritsukeTeiin 割付定員
     * @param waritsukeChiku 割付地区コード
     * @param waritsukeChikuName 割付地区名称
     * @param autoWaritsukeFlag 自動割付フラグ
     * @param kikanKubun 機関の区分
     * @param jokyoFlag 状況フラグ
     * @param ninteiChosainCode 調査員コード
     * @param chosainShimei 調査員氏名
     * @param chosainKanaShimei 調査員カナ氏名
     * @param seibetsu 性別
     * @param chikuCode 地区コード
     * @param chikuName 地区名称
     * @param chosainShikaku 調査員資格
     * @param chosaKanoNinzuPerMonth 調査可能人数
     * @param chosainJokyoFlag 状況フラグ
     * @param chosainYubinNo 郵便番号
     * @param chosainJusho 住所
     * @param chosainTelNo 電話番号
     * @param chosainFaxNo ＦＡＸ番号
     * @param shozokuKikanName 所属機関名称
     *
     */
    public ChosainInfoMobileCsvEntity(
            RString shichosonCode,
            RString shichosonMeisho,
            RString ninteichosaItakusakiCode,
            RString jigyoshaNo,
            RString jigyoshaMeisho,
            RString jigyoshaMeishoKana,
            RString yubinNo,
            RString jusho,
            RString telNo,
            RString faxNo,
            RString daihyoshaName,
            RString daihyoshaNameKana,
            RString chosaItakuKubun,
            RString tokuteiChosainDisplayFlag,
            RString waritsukeTeiin,
            RString waritsukeChiku,
            RString waritsukeChikuName,
            RString autoWaritsukeFlag,
            RString kikanKubun,
            RString jokyoFlag,
            RString ninteiChosainCode,
            RString chosainShimei,
            RString chosainKanaShimei,
            RString seibetsu,
            RString chikuCode,
            RString chikuName,
            RString chosainShikaku,
            RString chosaKanoNinzuPerMonth,
            RString chosainJokyoFlag,
            RString chosainYubinNo,
            RString chosainJusho,
            RString chosainTelNo,
            RString chosainFaxNo,
            RString shozokuKikanName) {
        this.shichosonCode = shichosonCode;
        this.shichosonMeisho = shichosonMeisho;
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
        this.jigyoshaNo = jigyoshaNo;
        this.jigyoshaMeisho = jigyoshaMeisho;
        this.jigyoshaMeishoKana = jigyoshaMeishoKana;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.telNo = telNo;
        this.faxNo = faxNo;
        this.daihyoshaName = daihyoshaName;
        this.daihyoshaNameKana = daihyoshaNameKana;
        this.chosaItakuKubun = chosaItakuKubun;
        this.tokuteiChosainDisplayFlag = tokuteiChosainDisplayFlag;
        this.waritsukeTeiin = waritsukeTeiin;
        this.waritsukeChiku = waritsukeChiku;
        this.waritsukeChikuName = waritsukeChikuName;
        this.autoWaritsukeFlag = autoWaritsukeFlag;
        this.kikanKubun = kikanKubun;
        this.jokyoFlag = jokyoFlag;
        this.ninteiChosainCode = ninteiChosainCode;
        this.chosainShimei = chosainShimei;
        this.chosainKanaShimei = chosainKanaShimei;
        this.seibetsu = seibetsu;
        this.chikuCode = chikuCode;
        this.chikuName = chikuName;
        this.chosainShikaku = chosainShikaku;
        this.chosaKanoNinzuPerMonth = chosaKanoNinzuPerMonth;
        this.chosainJokyoFlag = chosainJokyoFlag;
        this.chosainYubinNo = chosainYubinNo;
        this.chosainJusho = chosainJusho;
        this.chosainTelNo = chosainTelNo;
        this.chosainFaxNo = chosainFaxNo;
        this.shozokuKikanName = shozokuKikanName;
    }
}
