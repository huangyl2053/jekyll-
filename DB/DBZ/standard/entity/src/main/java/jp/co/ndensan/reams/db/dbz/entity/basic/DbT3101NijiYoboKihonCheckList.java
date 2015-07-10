package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3101NijiYoboKihonCheckListの項目定義クラスです
 *
 */
public enum DbT3101NijiYoboKihonCheckList implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shikibetsuCode(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    uketsukeYMD(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    kinyuYMD(2147483647, 0),
    shitsumonJiko01(5, 0),
    shitsumonJiko02(5, 0),
    shitsumonJiko03(5, 0),
    shitsumonJiko04(5, 0),
    shitsumonJiko05(5, 0),
    shitsumonJiko06(5, 0),
    shitsumonJiko07(5, 0),
    shitsumonJiko08(5, 0),
    shitsumonJiko09(5, 0),
    shitsumonJiko10(5, 0),
    shitsumonJiko11(5, 0),
    shitsumonJiko12Shincho(3, 0),
    shitsumonJiko12Taiju(3, 0),
    shitsumonJiko13(5, 0),
    shitsumonJiko14(5, 0),
    shitsumonJiko15(5, 0),
    shitsumonJiko16(5, 0),
    shitsumonJiko17(5, 0),
    shitsumonJiko18(5, 0),
    shitsumonJiko19(5, 0),
    shitsumonJiko20(5, 0),
    shitsumonJiko21(5, 0),
    shitsumonJiko22(5, 0),
    shitsumonJiko23(5, 0),
    shitsumonJiko24(5, 0),
    shitsumonJiko25(5, 0);

    private final int maxLength;
    private final int scale;

    private DbT3101NijiYoboKihonCheckList(int maxLength, int scale) {
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
