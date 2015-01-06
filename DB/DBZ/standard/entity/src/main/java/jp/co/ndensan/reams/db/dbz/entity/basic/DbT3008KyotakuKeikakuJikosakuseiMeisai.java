package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3008KyotakuKeikakuJikosakuseiMeisaiの項目定義クラスです
 *
 */
public enum DbT3008KyotakuKeikakuJikosakuseiMeisai implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    shikibetsuNo(2147483647, 0),
    taishoYM(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    kyotakuServiceKubun(1, 0),
    serviceTeikyoJigyoshaNo(2147483647, 0),
    serviceShuruiCode(2147483647, 0),
    serviceKomokuCode(2147483647, 0),
    taniSu(6, 0),
    kaisu_Nissu(6, 0),
    shuruiGendoNaiTaniSu_Nissu(6, 0),
    shuruiGendoChokaTaniSu_Nissu(6, 0),
    kubunGendoNaiTaniSu_Nissu(6, 0),
    kubunGendoChokaTaniSu_Nissu(6, 0),
    taniSuTanka(4, 0),
    kyufuRitsu(2147483647, 0),
    waribikiGoTekiyoRitsu(2147483647, 0),
    waribikiGoTekiyoTaniSu(6, 0),
    kyufuTaishoNissu(3, 0);

    private final int maxLength;
    private final int scale;

    private DbT3008KyotakuKeikakuJikosakuseiMeisai(int maxLength, int scale) {
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
