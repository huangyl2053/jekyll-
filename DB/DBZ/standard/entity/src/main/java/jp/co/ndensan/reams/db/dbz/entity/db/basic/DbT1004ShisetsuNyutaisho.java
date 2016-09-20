package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護保険施設入退所テーブルの項目定義クラスです。
 */
public enum DbT1004ShisetsuNyutaisho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

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
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 台帳種別
     * <br/>1:被保険者台帳,2:他市町村住所地特例者台帳、3:適用除外者台帳
     */
    daichoShubetsu(1, 0),
    /**
     * 入所施設種類
     * <br/>11:介護保険施設、12:住所地特例対象施設、21:適用除外施設
     */
    nyushoShisetsuShurui(2, 0),
    /**
     * 入所施設コード
     */
    nyushoShisetsuCode(2147483647, 0),
    /**
     * 入所処理年月日
     */
    nyushoShoriYMD(2147483647, 0),
    /**
     * 入所年月日
     */
    nyushoYMD(2147483647, 0),
    /**
     * 退所処理年月日
     */
    taishoShoriYMD(2147483647, 0),
    /**
     * 退所年月日
     */
    taishoYMD(2147483647, 0),
    /**
     * 部屋記号番号
     * <br/>部屋の記号番号
     */
    roomKigoNo(20, 0),
    /**
     * 保険者番号
     */
    hokenshaNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT1004ShisetsuNyutaisho(int maxLength, int scale) {
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
