package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT1008IryohokenKanyuJokyoの項目定義クラスです
 *
 */
public enum DbT1008IryohokenKanyuJokyo implements IColumnDefinition {
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
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 医療保険種別コード
     */
    iryoHokenShubetsuCode(2, 0),
    /**
     * 医療保険者番号
     */
    iryoHokenshaNo(8, 0),
    /**
     * 医療保険者名称
     */
    iryoHokenshaMeisho(20, 0),
    /**
     * 医療保険記号番号
     */
    iryoHokenKigoNo(30, 0),
    /**
     * 医療保険加入年月日
     */
    iryoHokenKanyuYMD(2147483647, 0),
    /**
     * 医療保険脱退年月日
     */
    iryoHokenDattaiYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT1008IryohokenKanyuJokyo(int maxLength, int scale) {
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
