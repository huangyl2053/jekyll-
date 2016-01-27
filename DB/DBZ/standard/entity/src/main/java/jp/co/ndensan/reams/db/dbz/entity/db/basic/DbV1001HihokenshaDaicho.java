package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbV1001HihokenshaDaichoの項目定義クラスです
 *
 */
public enum DbV1001HihokenshaDaicho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    /**
     * hihokenshaNo
     */
    hihokenshaNo(2147483647, 0),
    /**
     * idoYMD
     */
    idoYMD(2147483647, 0),
    /**
     * edaNo
     */
    edaNo(4, 0),
    /**
     * idoJiyuCode
     */
    idoJiyuCode(2, 0),
    /**
     * shichosonCode
     */
    shichosonCode(2147483647, 0),
    /**
     * shikibetsuCode
     */
    shikibetsuCode(2147483647, 0),
    /**
     * shikakuShutokuJiyuCode
     */
    shikakuShutokuJiyuCode(2, 0),
    /**
     * shikakuShutokuYMD
     */
    shikakuShutokuYMD(2147483647, 0),
    /**
     * shikakuShutokuTodokedeYMD
     */
    shikakuShutokuTodokedeYMD(2147483647, 0),
    /**
     * ichigoShikakuShutokuYMD
     */
    ichigoShikakuShutokuYMD(2147483647, 0),
    /**
     * hihokennshaKubunCode
     */
    hihokennshaKubunCode(1, 0),
    /**
     * shikakuSoshitsuJiyuCode
     */
    shikakuSoshitsuJiyuCode(2, 0),
    /**
     * shikakuSoshitsuYMD
     */
    shikakuSoshitsuYMD(2147483647, 0),
    /**
     * shikakuSoshitsuTodokedeYMD
     */
    shikakuSoshitsuTodokedeYMD(2147483647, 0),
    /**
     * shikakuHenkoJiyuCode
     */
    shikakuHenkoJiyuCode(2, 0),
    /**
     * shikakuHenkoYMD
     */
    shikakuHenkoYMD(2147483647, 0),
    /**
     * shikakuHenkoTodokedeYMD
     */
    shikakuHenkoTodokedeYMD(2147483647, 0),
    /**
     * jushochitokureiTekiyoJiyuCode
     */
    jushochitokureiTekiyoJiyuCode(2, 0),
    /**
     * jushochitokureiTekiyoYMD
     */
    jushochitokureiTekiyoYMD(2147483647, 0),
    /**
     * jushochitokureiTekiyoTodokedeYMD
     */
    jushochitokureiTekiyoTodokedeYMD(2147483647, 0),
    /**
     * jushochitokureiKaijoJiyuCode
     */
    jushochitokureiKaijoJiyuCode(2, 0),
    /**
     * jushochitokureiKaijoYMD
     */
    jushochitokureiKaijoYMD(2147483647, 0),
    /**
     * jushochitokureiKaijoTodokedeYMD
     */
    jushochitokureiKaijoTodokedeYMD(2147483647, 0),
    /**
     * jushochiTokureiFlag
     */
    jushochiTokureiFlag(1, 0),
    /**
     * koikinaiJushochiTokureiFlag
     */
    koikinaiJushochiTokureiFlag(1, 0),
    /**
     * koikinaiTokureiSochimotoShichosonCode
     */
    koikinaiTokureiSochimotoShichosonCode(2147483647, 0),
    /**
     * kyuShichosonCode
     */
    kyuShichosonCode(2147483647, 0),
    /**
     * logicalDeletedFlag
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbV1001HihokenshaDaicho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長のgetメソッドです。
     * 
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下の桁数のgetメソッドです。
     * 
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
