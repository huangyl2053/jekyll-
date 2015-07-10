package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3047ShokanServicePlan200904の項目定義クラスです
 *
 */
public enum DbT3047ShokanServicePlan200904 implements IColumnDefinition {
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
    seiriNp(10, 0),
    jigyoshaNo(2147483647, 0),
    yoshikiNo(4, 0),
    shoriTimestamp(2147483647, 0),
    shiteiKijunGaitoJigyoshaKubunCode(1, 0),
    meisaiLineNo(2, 0),
    kyotakuServiceSakuseiIraiYMD(2147483647, 0),
    serviceCode(2147483647, 0),
    tanisu(10, 0),
    kaisu(10, 0),
    serviceTanisu(10, 0),
    tanisuTanka(6, 0),
    serviceTanisuTotal(10, 0),
    seikyuKingaku(10, 0),
    tantokangoshienSemmoninNo(8, 0),
    tekiyo(20, 0),
    shinsaHohoKubunCode(1, 0),
    shinsaYM(2147483647, 0),
    shikyuKubunCode(1, 0),
    tensuKingaku(10, 0),
    shikyuKingaku(10, 0),
    zougenTen(10, 0),
    sagakuKingaku(10, 0),
    zougenRiyu(40, 0),
    fushikyuRiyu(76, 0),
    kounyuKaishuRireki(76, 0);

    private final int maxLength;
    private final int scale;

    private DbT3047ShokanServicePlan200904(int maxLength, int scale) {
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
