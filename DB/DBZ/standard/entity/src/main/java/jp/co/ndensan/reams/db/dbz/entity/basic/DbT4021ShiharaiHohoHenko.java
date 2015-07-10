package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT4021ShiharaiHohoHenkoの項目定義クラスです
 *
 */
public enum DbT4021ShiharaiHohoHenko implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    kanriKubun(1, 0),
    shoriTimestamp(2147483647, 0),
    torokuKubun(2, 0),
    tekiyoKaishiYMD(2147483647, 0),
    tekiyoShuryoYMD(2147483647, 0),
    shuryoKubun(2, 0),
    yokoku_TorokuYMD(2147483647, 0),
    sashitome_IraiJuriYMD(2147483647, 0),
    yokoku_TsuchiHakkoYMD(2147483647, 0),
    yokoku_TsuchiSaiHakkoFlag(1, 0),
    bemmei_TeishutsuYMD(2147483647, 0),
    bemmei_UketsukeYMD(2147483647, 0),
    bemmei_RiyuCode(2, 0),
    bemmei_ShinsaKetteiYMD(2147483647, 0),
    bemmei_ShinsaKekkaKubun(1, 0),
    shokan_KetteiYMD(2147483647, 0),
    shokan_TsuchiHakkoYMD(2147483647, 0),
    shokan_TsuchiSaiHakkoFlag(1, 0),
    hihokenshaShoTeishutsuYMD(2147483647, 0),
    sashitome_Flag(1, 0),
    sashitome_KetteiYMD(2147483647, 0),
    sashitome_KaijoYMD(2147483647, 0),
    gemmen_KetteiYMD(2147483647, 0),
    gemmen_TsuchiHakkoYMD(2147483647, 0),
    gemmen_TsuchiSaiHakkoFlag(1, 0),
    kyufuRitsu(2147483647, 0),
    shuryoShinsei_UketsukeYMD(2147483647, 0),
    shuryoShinsei_YMD(2147483647, 0),
    shuryoShinsei_RiyuCode(2, 0),
    shuryoShinsei_ShinsaKetteiYMD(2147483647, 0),
    shuryoShinsei_ShinsaKekkaKubun(1, 0),
    mukoKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT4021ShiharaiHohoHenko(int maxLength, int scale) {
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
