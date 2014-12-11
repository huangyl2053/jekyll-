package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3062SaishinsaMoshitateの項目定義クラスです
 *
 */
public enum DbT3062SaishinsaMoshitate implements IColumnDefinition {
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
    serviceTeikyoShuruiCode(2147483647, 0),
    serviceKomokuCode(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    moshitateYMD(2147483647, 0),
    moshitateshaKubunCode(1, 0),
    shokisaiHokenshaNo(2147483647, 0),
    moshitateTanisu(10, 0),
    moshitateJiyuCode(4, 0),
    kokuhorenSofuYM(2147483647, 0),
    kokuhirenSaiSofuAriFlag(1, 0),
    biko(100, 0);

    private final int maxLength;
    private final int scale;

    private DbT3062SaishinsaMoshitate(int maxLength, int scale) {
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
