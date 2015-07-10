package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3072KogakuGassanShikyuGakuKeisanKekkaの項目定義クラスです
 *
 */
public enum DbT3072KogakuGassanShikyuGakuKeisanKekka implements IColumnDefinition {
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
    taishoNendo(2147483647, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    shikyuShinseishoSeiriNo(17, 0),
    shoriTimestamp(2147483647, 0),
    hokenSeidoCode(1, 0),
    jikoFutanSeiriNo(20, 0),
    taishoKeisanKaishiYMD(2147483647, 0),
    taishoKeisanShuryoYMD(2147483647, 0),
    setaiFutanSogaku(10, 0),
    setaiGassanGaku(10, 0),
    over70_SetaiGassanGaku(10, 0),
    shotokuKubun(1, 0),
    over70_ShotokuKubun(1, 0),
    santeiKijunGaku(7, 0),
    over70_SanteiKijyunGaku(6, 0),
    setaiShikyuSogaku(10, 0),
    over70_SetaiShikyuSogaku(10, 0),
    honninShikyugaku(10, 0),
    over70_honninShikyugaku(10, 0),
    teiShotoku_1_SaiKeisanUmu(1, 0),
    biko(500, 0),
    kekkaRenrakusakiYubinNo(2147483647, 0),
    kekkaRenrakusakiJusho(100, 0),
    ketteRenrakusakiMeisho1(60, 0),
    kekkaRenrakusakiMeisho2(60, 0),
    tsuchiYMD(2147483647, 0),
    renrakuhyoHakkoshaMei(2147483647, 0),
    renrakuhyoHakkoshaYubinNo(2147483647, 0),
    renrakuhyoHakkoshaJusho(100, 0),
    toiawasesakiYobinNo(2147483647, 0),
    toiawasesakiJusho(100, 0),
    toiawasesakiMeisho1(60, 0),
    toiawasesakiMeisho2(60, 0),
    toiawasesakiTelNo(2147483647, 0),
    over70_FutangakuGokei(10, 0),
    over70_ShikyugakuGokei(10, 0),
    under70_FutangakuGokei(10, 0),
    futangakuGokei(10, 0),
    under70_ShikyugakuGokei(10, 0),
    shikyugakuGokei(10, 0),
    dataKubun(1, 0),
    uketoriYM(2147483647, 0),
    sofuYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3072KogakuGassanShikyuGakuKeisanKekka(int maxLength, int scale) {
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
