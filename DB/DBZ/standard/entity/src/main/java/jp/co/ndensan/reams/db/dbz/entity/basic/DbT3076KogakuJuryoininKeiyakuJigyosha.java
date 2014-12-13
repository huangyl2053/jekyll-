package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3076KogakuJuryoininKeiyakuJigyoshaの項目定義クラスです
 *
 */
public enum DbT3076KogakuJuryoininKeiyakuJigyosha implements IColumnDefinition {
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
    shikibetsuCode(2147483647, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    uketsukeYMD(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    shinseiYMD(2147483647, 0),
    jigyoshaNo(2147483647, 0),
    ketteiYMD(2147483647, 0),
    shoninKekkaKubun(1, 0),
    juryoininKaishiYMD(2147483647, 0),
    juryoininShuryoYMD(2147483647, 0),
    keiyakuNo(8, 0),
    fuShoninRiyu(100, 0),
    riyoshaFutanJogenGaku(9, 0),
    shoninKekkaTsuchiSakuseiYMD(2147483647, 0),
    shoninKekkaTsuchiSaiHakkoKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3076KogakuJuryoininKeiyakuJigyosha(int maxLength, int scale) {
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
