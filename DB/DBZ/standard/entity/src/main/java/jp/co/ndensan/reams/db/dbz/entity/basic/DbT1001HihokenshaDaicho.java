package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT1001HihokenshaDaichoの項目定義クラスです
 *
 */
public enum DbT1001HihokenshaDaicho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shichosonCode(2147483647, 0),
    hihokenshaNo(10, 0),
    shoriTimestamp(2147483647, 0),
    shikibetsuCode(2147483647, 0),
    shikakuShutokuJiyuCode(2, 0),
    shikakuShutokuYMD(2147483647, 0),
    shikakuShutokuTodokedeYMD(2147483647, 0),
    ichigoHihokenshaNenreiTotatsuYMD(2147483647, 0),
    hihokennshaKubunCode(1, 0),
    shikakuSoshitsuJiyuCode(2, 0),
    shikakuSoshitsuYMD(2147483647, 0),
    shikakuSoshitsuTodokedeYMD(2147483647, 0),
    jushochiTokureiFlag(1, 0),
    shikakuHenkoJiyuCode(2, 0),
    shikakuHenkoYMD(2147483647, 0),
    shikakuHenkoTodokedeYMD(2147483647, 0),
    jushochitokureiTekiyoJiyuCode(2, 0),
    jushochitokureiTekiyoYMD(2147483647, 0),
    jushochitokureiTekiyoTodokedeYMD(2147483647, 0),
    jushochitokureiKaijoJiyuCode(2, 0),
    jushochitokureiKaijoYMD(2147483647, 0),
    jushochitokureiKaijoTodokedeYMD(2147483647, 0),
    koikinaiJushochiTokureiFlag(1, 0),
    koikinaiTokureiSochimotoShichosonCode(2147483647, 0),
    kyuShichosonCode(2147483647, 0),
    saikofuKubun(1, 0),
    saikofuJiyuCode(2, 0),
    chohyoKofuRirekiID(10, 0);

    private final int maxLength;
    private final int scale;

    private DbT1001HihokenshaDaicho(int maxLength, int scale) {
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
