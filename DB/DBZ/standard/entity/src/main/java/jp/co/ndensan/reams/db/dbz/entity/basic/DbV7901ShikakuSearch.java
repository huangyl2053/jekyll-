package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbV7901ShikakuSearchの項目定義クラスです
 *
 */
public enum DbV7901ShikakuSearch implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    shikibetsuCode(2147483647, 0),
    shichosonCode(2147483647, 0),
    hihokenshaNo(10, 0),
    shikakuShutokuJiyuCode(2, 0),
    shikakuShutokuYMD(2147483647, 0),
    hihokennshaKubunCode(1, 0),
    shikakuSoshitsuJiyuCode(2, 0),
    shikakuSoshitsuYMD(2147483647, 0),
    jushochiTokureiFlag(1, 0),
    shikakuHenkoJiyuCode(2, 0),
    shikakuHenkoYMD(2147483647, 0),
    jushochitokureiTekiyoJiyuCode(2, 0),
    jushochitokureiTekiyoYMD(2147483647, 0),
    jushochitokureiKaijoJiyuCode(2, 0),
    jushochitokureiKaijoYMD(2147483647, 0),
    koikinaiJushochiTokureiFlag(1, 0),
    koikinaiTokureiSochimotoShichosonCode(2147483647, 0),
    tekiyoJogaiTekiyoJiyuCode(2, 0),
    tekiyoJogaiTekiyoYMD(2147483647, 0),
    tekiyoJogaikaijokaijoJiyuCode(2, 0),
    tekiyoJogaiKaijoYMD(2147483647, 0),
    tatokureiTekiyoJiyuCode(2, 0),
    tatokureiTekiyoYMD(2147483647, 0),
    tatokureiKaijoJiyuCode(2, 0),
    tatokureiKaijoYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbV7901ShikakuSearch(int maxLength, int scale) {
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
