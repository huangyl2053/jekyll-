/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.convertparameter;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 非課税年金対象者情報取込の句切り位置を表す列挙型です。
 *
 * @reamsid_L DBD-4910-030 x_youyj
 */
public enum TorikomiRecordPunctuation {

    /**
     * 市町村コードの、startIndex、endIndex
     */
    提出元ID("0", "6"),
    /**
     * レコード区分の、startIndex、endIndex
     */
    レコード区分("0", "1"),
    /**
     * 市町村コードの、startIndex、endIndex
     */
    市町村コード("1", "6"),
    /**
     * 年金保険者コードの、startIndex、endIndex
     */
    年金保険者コード("6", "9"),
    /**
     * 通知内容コードの、startIndex、endIndex
     */
    通知内容コード("9", "11"),
    /**
     * 予備1の、startIndex、endIndex
     */
    予備1("11", "12"),
    /**
     * 制度コードの、startIndex、endIndex
     */
    制度コード("12", "13"),
    /**
     * 作成年月日の、startIndex、endIndex
     */
    作成年月日("13", "21"),
    /**
     * 基礎年金番号の、startIndex、endIndex
     */
    基礎年金番号("21", "31"),
    /**
     * 年金コードの、startIndex、endIndex
     */
    年金コード("31", "35"),
    /**
     * 予備2の、startIndex、endIndex
     */
    予備2("35", "38"),
    /**
     * 生年月日の、startIndex、endIndex
     */
    生年月日("38", "46"),
    /**
     * 性別の、startIndex、endIndex
     */
    性別("46", "47"),
    /**
     * カナ氏名の、startIndex、endIndex
     */
    カナ氏名("47", "72"),
    /**
     * カナ氏名の、startIndex、endIndex
     */
    シフトコード1("72", "75"),
    /**
     * 漢字氏名の、startIndex、endIndex
     */
    漢字氏名("75", "125"),
    /**
     * シフトコード2の、startIndex、endIndex
     */
    シフトコード2("125", "128"),
    /**
     * 郵便番号の、startIndex、endIndex
     */
    郵便番号("128", "135"),
    /**
     * カナ住所の、startIndex、endIndex
     */
    カナ住所("135", "215"),
    /**
     * シフトコード3の、startIndex、endIndex
     */
    シフトコード3("215", "218"),
    /**
     * 漢字住所の、startIndex、endIndex
     */
    漢字住所("218", "378"),
    /**
     * シフトコード4の、startIndex、endIndex
     */
    シフトコード4("378", "381"),
    /**
     * 対象年の、startIndex、endIndex
     */
    対象年("381", "385"),
    /**
     * 訂正表示の、startIndex、endIndex
     */
    訂正表示("385", "386"),
    /**
     * 各種区分の、startIndex、endIndex
     */
    各種区分("386", "388"),
    /**
     * 処理結果の、startIndex、endIndex
     */
    処理結果("388", "390"),
    /**
     * 予備3の、startIndex、endIndex
     */
    予備3("390", "391"),
    /**
     * 予備4の、startIndex、endIndex
     */
    予備4("391", "399"),
    /**
     * 金額1の、startIndex、endIndex
     */
    金額１("399", "410"),
    /**
     * 金額予備1の、startIndex、endIndex
     */
    金額予備1("410", "421"),
    /**
     * 金額予備2の、startIndex、endIndex
     */
    金額予備2("421", "432"),
    /**
     * 予備5の、startIndex、endIndex
     */
    予備5("432", "485"),
    /**
     * 共済年金証書記号番号の、startIndex、endIndex
     */
    共済年金証書記号番号("485", "500");

    private final RString startIndex;
    private final RString endIndex;

    private TorikomiRecordPunctuation(String startIndex, String endIndex) {
        this.startIndex = new RString(startIndex);
        this.endIndex = new RString(endIndex);
    }

    /**
     * 項目の開始位置を取得します。
     *
     * @return 項目の開始位置
     */
    public int get開始位置() {
        return Integer.valueOf(startIndex.toString());
    }

    /**
     * 項目の終了位置を取得します。
     *
     * @return 項目の終了位置
     */
    public int get終了位置() {
        return Integer.valueOf(endIndex.toString());
    }

}
