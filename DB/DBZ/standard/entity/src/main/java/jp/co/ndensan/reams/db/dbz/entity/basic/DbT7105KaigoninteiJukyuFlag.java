package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7105KaigoninteiJukyuFlagの項目定義クラスです
 *
 */
public enum DbT7105KaigoninteiJukyuFlag implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    kihonJokyoFlag(1, 0),
    mobileDataFlag(1, 0),
    ninteiJohoTeikyoKiboAriFlag(1, 0),
    shinsakaiShinsajunKakuteiFlag(1, 0),
    gogitaiDummyFlag(1, 0),
    gogitaiSeishinkaiFlag(1, 0),
    shinsakaiKyukaiFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7105KaigoninteiJukyuFlag(int maxLength, int scale) {
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
