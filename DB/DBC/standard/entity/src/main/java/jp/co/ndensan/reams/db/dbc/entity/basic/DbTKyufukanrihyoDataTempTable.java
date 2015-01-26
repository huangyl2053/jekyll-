package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbTKyufukanrihyoDataTempTableの項目定義クラスです
 *
 */
public enum DbTKyufukanrihyoDataTempTable implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    recordShubetsu(2147483647, 0),
    renban(2147483647, 0),
    kokanjohoShikibetsuNo(2147483647, 0),
    chohyoRecordShubetsu(2147483647, 0),
    shinsaYM(2147483647, 0),
    taishoYM(2147483647, 0),
    hokenshaNo(2147483647, 0),
    KyotakuShienJigyoshoNo(2147483647, 0),
    kyufukanrihyoSakuseiKubunCode(2147483647, 0),
    kyufukanrihyoSakuseiYMD(2147483647, 0),
    kyufukanrihyoShubetsuKubunCode(2147483647, 0),
    kyufukanrihyoMeisaigyoNo(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    seinengappiYMD(2147483647, 0),
    seibetsuCode(2147483647, 0),
    yokaigojotaiKubunCode(2147483647, 0),
    gendogakuTekiyoKaishiYMD(2147483647, 0),
    gendogakuTekiyoShuryoYMD(2147483647, 0),
    kyotakuKaigoyoboShikyugendogaku(2147483647, 0),
    kyotakuKeikakuSakuseiKubunCode(2147483647, 0),
    serviceTeikyoJigyoshoNo(2147483647, 0),
    shiteiKijunGaitoJigyoshoKubunCode(2147483647, 0),
    serviceShuruiCode(2147483647, 0),
    kyufuKeikakuTanisuNissu(2147483647, 0),
    zentsukiMadeKyufuKeikakuNissu(2147483647, 0),
    shiteiServiceShokei(2147483647, 0),
    kijunGaitoServiceShokei(2147483647, 0),
    kyufuKeikakuGokeiTanisuNissu(2147483647, 0),
    kaigoshienSenmoninNo(2147483647, 0),
    itakusakiKyotakuKaigoshienJigyoshoNo(2147483647, 0),
    itakusakiKaigoshienSenmoninNo(2147483647, 0),
    hihoNoHenkanShichosonCode(2147483647, 0),
    shinHihokenshaNo(2147483647, 0),
    shichosonCode(2147483647, 0),
    koikiJutokuSochimotoShichosonCode(2147483647, 0),
    kyoShichosonCode(2147483647, 0),
    shikibetsuCode(2147483647, 0),
    kanjiMeisho(2147483647, 0),
    jigyoshoMeisho(2147483647, 0),
    shokisaiHokenshaNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbTKyufukanrihyoDataTempTable(int maxLength, int scale) {
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
