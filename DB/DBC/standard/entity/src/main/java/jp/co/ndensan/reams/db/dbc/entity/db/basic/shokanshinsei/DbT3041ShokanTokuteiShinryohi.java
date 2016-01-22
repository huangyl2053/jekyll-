package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還払請求特定診療費テーブルの項目定義クラスです。
 */
public enum DbT3041ShokanTokuteiShinryohi implements IColumnDefinition {
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
    shobyoName(20, 0),
    /**
     * 指導管理料等単位数
     */
    shidoKanriryoTanisu(10, 0),
    /**
     * 単純エックス線単位数
     */
    tanjunXsenTanisu(10, 0),
    /**
     * リハビリテーション単位数
     */
    rehabilitationTanisu(10, 0),
    /**
     * 精神科専門療法単位数
     */
    seishinkaSemmonRyoyohouTanisu(10, 0),
    /**
     * 合計単位数
     */
    TotalTanisu(10, 0),
    /**
     * 摘要１
     */
    tekiyo1(32, 0),
    /**
     * 摘要２
     */
    tekiyo2(32, 0),
    /**
     * 摘要３
     */
    tekiyo3(32, 0),
    /**
     * 摘要４
     */
    tekiyo4(32, 0),
    /**
     * 摘要５
     */
    tekiyo5(32, 0),
    /**
     * 摘要６
     */
    tekiyo6(32, 0),
    /**
     * 摘要７
     */
    tekiyo7(32, 0),
    /**
     * 摘要８
     */
    tekiyo8(32, 0),
    /**
     * 摘要９
     */
    tekiyo9(32, 0),
    /**
     * 摘要１０
     */
    tekiyo10(32, 0),
    /**
     * 摘要１１
     */
    tekiyo11(32, 0),
    /**
     * 摘要１２
     */
    tekiyo12(32, 0),
    /**
     * 摘要１３
     */
    tekiyo13(32, 0),
    /**
     * 摘要１４
     */
    tekiyo14(32, 0),
    /**
     * 摘要１５
     */
    tekiyo15(32, 0),
    /**
     * 摘要１６
     */
    tekiyo16(32, 0),
    /**
     * 摘要１７
     */
    tekiyo17(32, 0),
    /**
     * 摘要１８
     */
    tekiyo18(32, 0),
    /**
     * 摘要１９
     */
    tekiyo19(32, 0),
    /**
     * 摘要２０
     */
    tekiyo20(32, 0);

    private final int maxLength;
    private final int scale;

    private DbT3041ShokanTokuteiShinryohi(int maxLength, int scale) {
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
