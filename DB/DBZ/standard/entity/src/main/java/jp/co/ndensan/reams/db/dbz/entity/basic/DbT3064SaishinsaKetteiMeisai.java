package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3064SaishinsaKetteiMeisaiの項目定義クラスです
 *
 */
public enum DbT3064SaishinsaKetteiMeisai implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    toriatsukaiYM(2147483647, 0),
    hokenshaKubun(1, 0),
    shoriTimestamp(2147483647, 0),
    jigyoshoNo(2147483647, 0),
    jigyoshoName(20, 0),
    hiHokenshaNo(2147483647, 0),
    kohiJukyushaNo(7, 0),
    shokisaiHokenshaNo(2147483647, 0),
    serviceTeikyoYM(2147483647, 0),
    serviceShuruiCode(2147483647, 0),
    serviceShuruiName(12, 0),
    moushitateJiyuCode(4, 0),
    moushitateJiyu(12, 0),
    saishinsaResultCode(2, 0),
    toshoSeikyuTanisu(12, 0),
    genshinSeikyuTanisu(12, 0),
    moushitateTanisu(12, 0),
    ketteiTanisu(12, 0),
    choseiTanisu(13, 0),
    hokenshaFutangaku(13, 0),
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3064SaishinsaKetteiMeisai(int maxLength, int scale) {
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
