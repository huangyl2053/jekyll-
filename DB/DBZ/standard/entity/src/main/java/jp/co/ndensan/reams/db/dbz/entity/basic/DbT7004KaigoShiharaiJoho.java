package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7004KaigoShiharaiJohoの項目定義クラスです
 *
 */
public enum DbT7004KaigoShiharaiJoho implements IColumnDefinition {
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
    shikibetsuCode(2147483647, 0),
    kamokuCode(2147483647, 0),
    ketteiYMD(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    shiharaiHohoKubun(1, 0),
    madoguchiShiharaiBashoCode(2147483647, 0),
    madoguchiShiharaiKaishiYMDHM(2147483647, 0),
    madoguchiShiharaiShuryoYMDHM(2147483647, 0),
    furikomiYoteiYMD(2147483647, 0),
    shiharaiKingaku(10, 0),
    shubetsuCode(2147483647, 0),
    yotoKubunCode(2147483647, 0),
    ninshoYMD1(2147483647, 0),
    ninshoshaCode1(2147483647, 0),
    ninshoYMD2(2147483647, 0),
    ninshoshaCode2(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7004KaigoShiharaiJoho(int maxLength, int scale) {
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
