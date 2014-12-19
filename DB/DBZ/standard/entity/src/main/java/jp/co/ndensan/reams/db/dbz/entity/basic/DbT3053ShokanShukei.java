package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3053ShokanShukeiの項目定義クラスです
 *
 */
public enum DbT3053ShokanShukei implements IColumnDefinition {
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
    serviceShuruiCode(2147483647, 0),
    serviceJitsunissu(5, 0),
    planTanisu(10, 0),
    gendogakuKanriTaishoTanisu(10, 0),
    gendogakuKanriTaishogaiTanisu(10, 0),
    tankiNyushoPlanNissu(5, 0),
    tankiNyushoJitsunissu(5, 0),
    tanisuTotal(10, 0),
    tanisuTanka(6, 0),
    seikyugaku(9, 0),
    riyoshaFutangaku(10, 0),
    dekidakaIryohiTanisuTotal(10, 0),
    dekidakaIryohiSeikyugaku(9, 0),
    dekidakaIryohiRiyoshaFutangaku(9, 0),
    shinsaHohoKubunCode(1, 0),
    shinsaYM(2147483647, 0),
    shikyuKubunCode(1, 0),
    tensuKingaku(10, 0),
    shikyuKingaku(10, 0),
    zougenten(10, 0),
    seikyugakuSagakuKingaku(10, 0),
    dekidakaSeikyugakuSagaku(10, 0),
    zougenRiyu(20, 0),
    hushikyuRiyu(38, 0),
    kounyuKaishuRireki(38, 0);

    private final int maxLength;
    private final int scale;

    private DbT3053ShokanShukei(int maxLength, int scale) {
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
