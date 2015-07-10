package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3095JutakuKaishuRiyushoTesuryoMeisaiの項目定義クラスです
 *
 */
public enum DbT3095JutakuKaishuRiyushoTesuryoMeisai implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
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
    shoriTimestamp(2147483647, 0),
    shikibetsuCode(2147483647, 0),
    serviceCode(2147483647, 0),
    jutakuKaishuJigyoshaMeisho(2147483647, 0),
    jutakuKaishuChakkoYMD(2147483647, 0),
    jutakuKaishuJushoShozaisha(2147483647, 0),
    kaishuTaishoJutakuJusho(100, 0),
    kaishuNaiyo_kasho_Kibo(500, 0),
    riyushoSakuseiYMD(2147483647, 0),
    riyushoSakuseiJigyoshaNo(2147483647, 0),
    riyushoSakuseishaMei(2147483647, 0),
    riyushoSakuseishaShikaku(50, 0),
    riyushoSakuseiShinseiYMD(2147483647, 0),
    riyushoSakuseiUketsukeYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3095JutakuKaishuRiyushoTesuryoMeisai(int maxLength, int scale) {
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
