package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3068KogakuGassanShinseishoの項目定義クラスです
 *
 */
public enum DbT3068KogakuGassanShinseisho implements IColumnDefinition {
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
    seiriNo(6, 0),
    shoriTimestamp(2147483647, 0),
    shinseiJokyoKubun(1, 0),
    shinseiYMD(2147483647, 0),
    shikyuShinseishoSeiriNo(17, 0),
    kokuhoShikyuShinseishoSeiriNo(17, 0),
    shikyuShinseiKubun(1, 0),
    taishoKeisanKaishiYMD(2147483647, 0),
    taishoKeisanShuryoYMD(2147483647, 0),
    shikyuShinseiKeitai(1, 0),
    jikoFutanKofuUmu(1, 0),
    shinseiDaihyoshaShimei(2147483647, 0),
    shinseiDaihyoshaYubinNo(2147483647, 0),
    shinseiDaihyoshaJusho(100, 0),
    shinseiDaihyoshaTelNo(2147483647, 0),
    shotokuKubun(1, 0),
    over70_ShotokuKubun(1, 0),
    shikakuSoshitsuYMD(2147483647, 0),
    shikakuSoshitsuJiyu(1, 0),
    kanyuKaishiYMD(2147483647, 0),
    kanyuShuryoYMD(2147483647, 0),
    kokuho_HokenshaNo(8, 0),
    kokuho_HokenshaMeisho(20, 0),
    kokuho_HihokenshaShoKigo(20, 0),
    kokuho_HihokenshaShoNo(20, 0),
    kokuho_SetaiNo(11, 0),
    kokuho_Zokugara(1, 0),
    kokuho_KanyuKaishiYMD(2147483647, 0),
    kokuho_KanyuShuryoYMD(2147483647, 0),
    koki_HokenshaNo(8, 0),
    koki_KoikiRengoMeisho(20, 0),
    koki_HihokenshaNo(8, 0),
    koki_KanyuKaishiYMD(2147483647, 0),
    koki_KanyuShuryoYMD(2147483647, 0),
    shiharaiHohoKubun(1, 0),
    shiharaiBasho(64, 0),
    shiharaiKaishiYMD(2147483647, 0),
    shiharaiShuryoYMD(2147483647, 0),
    heichoNaiyo(50, 0),
    shiharaiKaishiTime(8, 0),
    shiharaiShuryoTime(8, 0),
    biko(250, 0),
    shikyuShinseisho_SofuYM(2147483647, 0),
    saiSofuFlag(1, 0),
    jikoFutan_KeisanYM(2147483647, 0),
    saiKeisanKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3068KogakuGassanShinseisho(int maxLength, int scale) {
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
