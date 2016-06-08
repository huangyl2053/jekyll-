package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 市町村単独助成金給付申請テーブルの項目定義クラスです。
 */
public enum DbT3098TandokuJoseikinKyufuShinsei implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 受付年月日
     */
    uketsukeYMD(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 申請年月日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 申請者区分
     */
    shinseishaKubun(1, 0),
    /**
     * 申請代行事業者番号
     */
    daikoJigyoshaNo(2147483647, 0),
    /**
     * 事業者区分
     */
    jigyoshaKubun(1, 0),
    /**
     * 申請者郵便番号
     */
    shinseishaYubinNo(2147483647, 0),
    /**
     * 申請者住所
     */
    shinseishaJusho(100, 0),
    /**
     * 申請者電話番号
     */
    shinseishaTelNo(2147483647, 0),
    /**
     * 申請理由
     */
    shinseiRiyu(200, 0),
    /**
     * 市町村単独助成種類
     */
    tandokuJoseiShuruiCode(2, 0);

    private final int maxLength;
    private final int scale;

    private DbT3098TandokuJoseikinKyufuShinsei(int maxLength, int scale) {
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
