package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3066ShichosonTokubetuKyufuServiceの項目定義クラスです
 *
 */
public enum DbT3066ShichosonTokubetuKyufuService implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    serviceCode(6, 0),
    serviceYukoKikanKaishiYMD(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    serviceSeishikiName(15, 0),
    serviceRyakushoName(5, 0),
    serviceYukoKikanShuryoYMD(2147483647, 0),
    serviceKubun(1, 0),
    tanisuNissu(10, 0),
    shikyuGendoKijungaku(10, 0),
    kyufuritsuHikisageAriFlag(1, 0),
    torokuYMD(2147483647, 0),
    henkoYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3066ShichosonTokubetuKyufuService(int maxLength, int scale) {
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
