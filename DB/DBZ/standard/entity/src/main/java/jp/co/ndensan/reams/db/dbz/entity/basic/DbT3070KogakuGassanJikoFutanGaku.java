package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3070KogakuGassanJikoFutanGakuの項目定義クラスです
 *
 */
public enum DbT3070KogakuGassanJikoFutanGaku implements IColumnDefinition {
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
    hokenshaNo(2147483647, 0),
    shikyuShinseishoSeiriNo(17, 0),
    shoriTimestamp(2147483647, 0),
    hokenSeidoCode(1, 0),
    hokenshaMei(20, 0),
    kokuho_HihokenshaShoKigo(20, 0),
    hihokenshaShimeiKana(2147483647, 0),
    hihokenshaShimei(2147483647, 0),
    umareYMD(2147483647, 0),
    seibetsuCode(2147483647, 0),
    shotokuKubun(1, 0),
    over70_ShotokuKubun(1, 0),
    jikoFutanSeiriNo(20, 0),
    koki_HokenshaNo(8, 0),
    koki_HihokenshaNo(8, 0),
    kokuho_HokenshaNo(8, 0),
    kokuho_HihokenshaShoNo(20, 0),
    kokuho_KojinNo(10, 0),
    idoKubun(1, 0),
    hoseiZumiSofuKubun(1, 0),
    taishoKeisanKaishiYMD(2147483647, 0),
    taishoKeisanShuryoYMD(2147483647, 0),
    hihokenshaKaishiYMD(2147483647, 0),
    hihokenshaShuryoYMD(2147483647, 0),
    shinseiYMD(2147483647, 0),
    gokei_JikoFutanGaku(10, 0),
    gokei_70_74JikoFutanGaku(10, 0),
    gokei_Under70KogakuShikyuGaku(10, 0),
    gokei_70_74KogakuShikyuGaku(10, 0),
    sumi_Gokei_JikoFutanGaku(10, 0),
    sumi_Gokei_70_74JikoFutanGaku(10, 0),
    sumi_Gokei_Under70KogakuShikyuGaku(10, 0),
    sumi_Gokei_70_74KogakuShikyuGaku(10, 0),
    atesakiShimei(2147483647, 0),
    atesakiYubinNo(2147483647, 0),
    atesakiJusho(100, 0),
    madoguchi_TaishoshaHanteiCode(1, 0),
    shiharaiBasho(64, 0),
    shikaraiKaishiYMD(2147483647, 0),
    shiharaiShuryoYMD(2147483647, 0),
    heichoNaiyo(50, 0),
    shiharaiKaishiTime(4, 0),
    shiharaiShuryoTime(4, 0),
    biko(200, 0),
    dataSakuseiKubun(1, 0),
    kakunin_UketoriYM(2147483647, 0),
    hoseiZumi_SofuYM(2147483647, 0),
    shomeisho_UketoriYM(2147483647, 0),
    saisoFlag(1, 0),
    sofuTaishoGaiFlag(1, 0),
    jikoFutanKeisanYMD(2147483647, 0),
    shomeiShoSakuseiYMD(2147483647, 0),
    koki_KokuhoShoriKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3070KogakuGassanJikoFutanGaku(int maxLength, int scale) {
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
