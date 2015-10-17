package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT5101ShinsakaiJohoの項目定義クラスです
 *
 */
public enum DbT5101ShinsakaiJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shinsakaiKaisaiNo(5, 0),
    shinsakaiKaisaiYMD(2147483647, 0),
    shinsakaiKaishiTime(4, 0),
    shinsakaiShuryoTime(4, 0),
    shinsakaiKaisaiBashoCode(9, 0),
    gogitaiNo(5, 0),
    shinsakaiYoteiTeiin(5, 0),
    shinsakaiSaidaiTeiin(5, 0),
    shinsakaiJidoWariateTeiin(5, 0),
    shinsakaiIinTeiin(5, 0),
    gogitaiSeishinkaiSonzaiFlag(1, 0),
    gogitaiDummyFlag(1, 0),
    shinsakaiShiryoSakuseiYMD(2147483647, 0),
    shinsakaiKyukaiFlag(1, 0),
    shinsakaiWariateZumiNinzu(5, 0),
    shiryoSakuseiKubun(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5101ShinsakaiJoho(int maxLength, int scale) {
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
