package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT5103GogitaiJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public enum DbT5103GogitaiJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    gogitaiNo(5, 0),
    gogitaiMei(40, 0),
    gogitaiYukoKikanKaishiYMD(2147483647, 0),
    gogitaiYukoKikanShuryoYMD(2147483647, 0),
    gogitaiKaishiYoteiTime(4, 0),
    gogitaiShuryoYoteiTime(4, 0),
    shinsakaiKaisaiBashoCode(9, 0),
    shinsakaiYoteiTeiin(5, 0),
    shinsakaiJidoWariateTeiin(5, 0),
    shinsakaiIinTeiin(5, 0),
    gogitaiSeishinkaSonzaiFlag(1, 0),
    gogitaiDummyFlag(1, 0);
    private final int maxLength;
    private final int scale;

    private DbT5103GogitaiJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }
// </editor-fold>
}
