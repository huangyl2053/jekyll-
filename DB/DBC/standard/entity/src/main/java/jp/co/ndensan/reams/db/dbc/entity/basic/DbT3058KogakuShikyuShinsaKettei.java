package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 高額介護サービス費支給審査決定テーブルの項目定義クラスです。
 */
public enum DbT3058KogakuShikyuShinsaKettei implements IColumnDefinition {
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
     * 決定者受取年月
     */
    ketteishaUketoriYM(2147483647, 0),
    /**
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 通知書番号
     */
    tsuchishoNo(6, 0),
    /**
     * 利用者負担額
     */
    riyoshaFutanGaku(9, 0),
    /**
     * 支給区分コード
     * <br/>1:支給,2:不支給
     */
    shikyuKubunCode(1, 0),
    /**
     * 決定年月
     */
    ketteiYM(2147483647, 0),
    /**
     * 高額支給額
     */
    kogakuShikyuGaku(9, 0);

    private final int maxLength;
    private final int scale;

    private DbT3058KogakuShikyuShinsaKettei(int maxLength, int scale) {
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
