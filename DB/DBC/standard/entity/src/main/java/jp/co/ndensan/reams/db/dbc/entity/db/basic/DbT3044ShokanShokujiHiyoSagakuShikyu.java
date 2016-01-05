package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還払請求食事費用差額支給テーブルの項目定義クラスです。
 */
public enum DbT3044ShokanShokujiHiyoSagakuShikyu implements IColumnDefinition {
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
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 整理番号
     */
    seiriNp(10, 0),
    /**
     * 事業者番号
     */
    jigyoshaNo(2147483647, 0),
    /**
     * 様式番号
     */
    yoshikiNo(4, 0),
    /**
     * 明細番号
     */
    meisaiNo(4, 0),
    /**
     * 連番
     */
    renban(2, 0),
    /**
     * 差額金額
     */
    sagakuKingaku(10, 0),
    /**
     * 支給区分コード
     */
    shikyuKubunCode(1, 0),
    /**
     * 点数／金額
     */
    tensuKingaku(10, 0),
    /**
     * 支給金額
     */
    shikyuKingaku(10, 0),
    /**
     * 支給・不支給理由
     */
    shikyuFushikyuRiyu(76, 0);

    private final int maxLength;
    private final int scale;

    private DbT3044ShokanShokujiHiyoSagakuShikyu(int maxLength, int scale) {
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
