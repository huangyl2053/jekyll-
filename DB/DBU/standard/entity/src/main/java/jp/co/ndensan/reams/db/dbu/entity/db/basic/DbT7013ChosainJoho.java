package jp.co.ndensan.reams.db.dbu.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 調査員情報　継承テーブルの項目定義クラスです。
 */
public enum DbT7013ChosainJoho implements IColumnDefinition {
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
     * 介護事業者番号
     */
    kaigoJigyoshaNo(10, 0),
    /**
     * 介護調査員番号
     */
    kaigoChosainNo(8, 0),
    /**
     * 事業者番号
     */
    jigyoshaNo(10, 0),
    /**
     * 介護調査員状況
     */
    kaigoChosainJokyo(1, 0),
    /**
     * 調査員氏名
     */
    chosainShimei(2147483647, 0),
    /**
     * 調査員氏名カナ
     */
    chosainKanaShimei(2147483647, 0),
    /**
     * 性別
     */
    seibetsu(1, 0),
    /**
     * 調査員資格コード
     */
    chosainShikakuCode(2147483647, 0),
    /**
     * 地区コード
     */
    chikuCode(2147483647, 0),
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
    telNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7013ChosainJoho(int maxLength, int scale) {
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
