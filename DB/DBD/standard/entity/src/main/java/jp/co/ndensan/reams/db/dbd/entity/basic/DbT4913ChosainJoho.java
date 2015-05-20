package jp.co.ndensan.reams.db.dbd.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 調査員情報（子）テーブルの項目定義クラスです。
 */
public enum DbT4913ChosainJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    /**
     * insertDantaiCd
     */
    insertDantaiCd(2147483647, 0),
    /**
     * insertTimestamp
     */
    insertTimestamp(29, 0),
    /**
     * insertReamsLoginId
     */
    insertReamsLoginId(2147483647, 0),
    /**
     * insertContextId
     */
    insertContextId(2147483647, 0),
    /**
     * isDeleted
     */
    isDeleted(1, 0),
    /**
     * updateCount
     */
    updateCount(10, 0),
    /**
     * lastUpdateTimestamp
     */
    lastUpdateTimestamp(29, 0),
    /**
     * lastUpdateReamsLoginId
     */
    lastUpdateReamsLoginId(2147483647, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 認定調査委託先コード
     */
    ninteichosaItakusakiCode(10, 0),
    /**
     * 認定調査員コード
     */
    ninteiChosainNo(8, 0),
    /**
     * 調査員氏名
     */
    chosainShimei(80, 0),
    /**
     * 調査員氏名カナ
     */
    chosainKanaShimei(80, 0),
    /**
     * 性別
     */
    seibetsu(1, 0),
    /**
     * 調査員資格
     */
    chosainShikaku(2, 0),
    /**
     * 地区コード
     */
    chikuCode(8, 0),
    /**
     * 調査可能人数／月
     */
    chosaKanoNinzuPerMonth(5, 0),
    /**
     * 郵便番号
     */
    yubinNo(2147483647, 0),
    /**
     * 住所
     */
    jusho(2147483647, 0),
    /**
     * 電話番号
     */
    telNo(2147483647, 0),
    /**
     * FAX番号
     */
    faxNo(2147483647, 0),
    /**
     * 状況フラグ
     */
    JokyoFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT4913ChosainJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長のgetメソッドです。
     * 
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下の桁数のgetメソッドです。
     * 
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
