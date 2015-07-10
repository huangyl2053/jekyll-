package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3059KagoMoshitateの項目定義クラスです
 *
 */
public enum DbT3059KagoMoshitate implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    jigyoshoNo(2147483647, 0),
    hiHokenshaNo(2147483647, 0),
    serviceTeikyoYM(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    moshitateYMD(2147483647, 0),
    moshitateshaKubunCode(1, 0),
    shokisaiHokenshaNo(2147483647, 0),
    moshitateJiyuCode(4, 0),
    kokuhorenSofuYM(2147483647, 0),
    kokuhirenSaiSofuAriFlag(1, 0),
    dogetsuShinsaAriFlag(1, 0),
    moshitateshoKubunCode(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3059KagoMoshitate(int maxLength, int scale) {
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
