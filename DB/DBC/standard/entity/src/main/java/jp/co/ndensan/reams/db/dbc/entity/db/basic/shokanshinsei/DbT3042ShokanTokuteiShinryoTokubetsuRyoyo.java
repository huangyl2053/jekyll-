package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還払請求特定診療費・特別療養費テーブルの項目定義クラスです。
 */
public enum DbT3042ShokanTokuteiShinryoTokubetsuRyoyo implements IColumnDefinition {
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
    hiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 整理番号
     */
    seiriNo(10, 0),
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
     * <br/>複数レコード対応のため
     */
    meisaiNo(4, 0),
    /**
     * 連番
     */
    renban(2, 0),
    /**
     * 傷病名
     */
    shobyoName(50, 0),
    /**
     * 識別番号
     */
    shikibetsuNo(2, 0),
    /**
     * 単位数
     */
    tanisu(5, 0),
    /**
     * 回数
     */
    kaisu(5, 0),
    /**
     * サービス単位数
     */
    serviceTanisu(10, 0),
    /**
     * 合計単位数
     */
    totalTanisu(10, 0),
    /**
     * 摘要
     */
    tekiyo(50, 0);

    private final int maxLength;
    private final int scale;

    private DbT3042ShokanTokuteiShinryoTokubetsuRyoyo(int maxLength, int scale) {
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
