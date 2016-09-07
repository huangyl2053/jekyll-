package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 高額合算給付実績テーブルの項目定義クラスです。
 */
public enum DbT3075KogakuGassanKyufuJisseki implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
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
     * 交換情報識別番号
     */
    kokanJohoShikibetsuNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 支給申請書整理番号
     */
    shikyuShinseiSeiriNo(17, 0),
    /**
     * 整理番号
     */
    seiriNo(10, 0),
    /**
     * 自己負担額証明書整理番号
     */
    jikoFutanSeiriNo(20, 0),
    /**
     * 保険制度コード
     */
    hokenSeidoCode(1, 0),
    /**
     * 給付実績作成区分コード
     */
    kyufuJissekiSakuseiKubunCode(1, 0),
    /**
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 国保 被保険者証記号
     */
    kokuho_HihokenshaShoKigo(20, 0),
    /**
     * 申請年月日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 決定年月日
     */
    ketteiYMD(2147483647, 0),
    /**
     * 自己負担総額
     */
    jikoFutanSogaku(10, 0),
    /**
     * 支給額
     */
    shikyuGaku(10, 0),
    /**
     * 処理年月
     */
    shoriYM(2147483647, 0),
    /**
     * 受取年月
     */
    uketoriYM(2147483647, 0),
    /**
     * 送付年月
     */
    sofuYM(2147483647, 0),
    /**
     * データ区分
     */
    dataKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3075KogakuGassanKyufuJisseki(int maxLength, int scale) {
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
