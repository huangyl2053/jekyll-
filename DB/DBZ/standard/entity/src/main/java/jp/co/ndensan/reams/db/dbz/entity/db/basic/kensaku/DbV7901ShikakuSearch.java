package jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbV7901ShikakuSearchの項目定義クラスです
 *
 */
public enum DbV7901ShikakuSearch implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    /**
     * shikibetsuCode
     */
    shikibetsuCode(2147483647, 0),
    /**
     * shichosonCode
     */
    shichosonCode(2147483647, 0),
    /**
     * hihokenshaNo
     */
    hihokenshaNo(2147483647, 0),
    /**
     * shikakuShutokuJiyuCode
     */
    shikakuShutokuJiyuCode(2, 0),
    /**
     * shikakuShutokuYMD
     */
    shikakuShutokuYMD(2147483647, 0),
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
     * jushochiTokureiFlag
     */
    jushochiTokureiFlag(1, 0),
    /**
     * shikakuHenkoJiyuCode
     */
    shikakuHenkoJiyuCode(2, 0),
    /**
     * shikakuHenkoYMD
     */
    shikakuHenkoYMD(2147483647, 0),
    /**
     * jushochitokureiTekiyoJiyuCode
     */
    jushochitokureiTekiyoJiyuCode(2, 0),
    /**
     * jushochitokureiTekiyoYMD
     */
    jushochitokureiTekiyoYMD(2147483647, 0),
    /**
     * jushochitokureiKaijoJiyuCode
     */
    jushochitokureiKaijoJiyuCode(2, 0),
    /**
     * jushochitokureiKaijoYMD
     */
    jushochitokureiKaijoYMD(2147483647, 0),
    /**
     * koikinaiJushochiTokureiFlag
     */
    koikinaiJushochiTokureiFlag(1, 0),
    /**
     * koikinaiTokureiSochimotoShichosonCode
     */
    koikinaiTokureiSochimotoShichosonCode(2147483647, 0),
    /**
     * tekiyoJogaiTekiyoJiyuCode
     */
    tekiyoJogaiTekiyoJiyuCode(2, 0),
    /**
     * tekiyoJogaiTekiyoYMD
     */
    tekiyoJogaiTekiyoYMD(2147483647, 0),
    /**
     * tekiyoJogaikaijokaijoJiyuCode
     */
    tekiyoJogaikaijokaijoJiyuCode(2, 0),
    /**
     * tekiyoJogaiKaijoYMD
     */
    tekiyoJogaiKaijoYMD(2147483647, 0),
    /**
     * tatokureiTekiyoJiyuCode
     */
    tatokureiTekiyoJiyuCode(2, 0),
    /**
     * tatokureiTekiyoYMD
     */
    tatokureiTekiyoYMD(2147483647, 0),
    /**
     * tatokureiKaijoJiyuCode
     */
    tatokureiKaijoJiyuCode(2, 0),
    /**
     * tatokureiKaijoYMD
     */
    tatokureiKaijoYMD(2147483647, 0),
    /**
     * JukyushaDaichoHihokenshaNo
     */
    JukyushaDaichoHihokenshaNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbV7901ShikakuSearch(int maxLength, int scale) {
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
