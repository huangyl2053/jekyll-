package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3041ShokanTokuteiShinryohiの項目定義クラスです
 *
 */
public enum DbT3041ShokanTokuteiShinryohi implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    hiHokenshaNo(2147483647, 0),
    serviceTeikyoYM(2147483647, 0),
    seiriNo(10, 0),
    jigyoshaNo(2147483647, 0),
    yoshikiNo(4, 0),
    junjiNo(4, 0),
    shoriTimestamp(2147483647, 0),
    shobyoName(20, 0),
    shidoKanriryoTanisu(10, 0),
    tanjunXsenTanisu(10, 0),
    rehabilitationTanisu(10, 0),
    seishinkaSemmonRyoyohouTanisu(10, 0),
    TotalTanisu(10, 0),
    tekiyo1(32, 0),
    tekiyo2(32, 0),
    tekiyo3(32, 0),
    tekiyo4(32, 0),
    tekiyo5(32, 0),
    tekiyo6(32, 0),
    tekiyo7(32, 0),
    tekiyo8(32, 0),
    tekiyo9(32, 0),
    tekiyo10(32, 0),
    tekiyo11(32, 0),
    tekiyo12(32, 0),
    tekiyo13(32, 0),
    tekiyo14(32, 0),
    tekiyo15(32, 0),
    tekiyo16(32, 0),
    tekiyo17(32, 0),
    tekiyo18(32, 0),
    tekiyo19(32, 0),
    tekiyo20(32, 0);

    private final int maxLength;
    private final int scale;

    private DbT3041ShokanTokuteiShinryohi(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
