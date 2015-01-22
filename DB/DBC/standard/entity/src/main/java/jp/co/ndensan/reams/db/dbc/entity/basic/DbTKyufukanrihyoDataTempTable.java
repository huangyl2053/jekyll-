package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbTKyufukanrihyoDataTempTableの項目定義クラスです
 *
 */
public enum DbTKyufukanrihyoDataTempTable implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">
    recordShubetsu(1, 0),
    renban(9, 0),
    kokanjohoShikibetsuNo(4, 0),
    chohyoRecordShubetsu(2, 0),
    shinsaYM(6, 0),
    taishoYM(6, 0),
    hokenshaNo(8, 0),
    KyotakuShienJigyoshoNo(10, 0),
    kyufukanrihyoSakuseiKubunCode(1, 0),
    kyufukanrihyoSakuseiYMD(8, 0),
    kyufukanrihyoShubetsuKubunCode(1, 0),
    kyufukanrihyoMeisaigyoNo(2, 0),
    hihokenshaNo(10, 0),
    seinengappiYMD(8, 0),
    seibetsuCode(1, 0),
    yokaigojotaiKubunCode(2, 0),
    gendogakuTekiyoKaishiYMD(6, 0),
    gendogakuTekiyoShuryoYMD(6, 0),
    kyotakuKaigoyoboShikyugendogaku(6, 0),
    kyotakuKeikakuSakuseiKubunCode(1, 0),
    serviceTeikyoJigyoshoNo(10, 0),
    shiteiKijunGaitoJigyoshoKubunCode(1, 0),
    serviceShuruiCode(2, 0),
    kyufuKeikakuTanisuNissu(6, 0),
    zentsukiMadeKyufuKeikakuNissu(3, 0),
    shiteiServiceShokei(6, 0),
    kijunGaitoServiceShokei(6, 0),
    kyufuKeikakuGokeiTanisuNissu(6, 0),
    kaigoshienSenmoninNo(8, 0),
    itakusakiKyotakuKaigoshienJigyoshoNo(10, 0),
    itakusakiKaigoshienSenmoninNo(8, 0),
    hihoNoHenkanShichosonCode(6, 0),
    shinHihokenshaNo(10, 0),
    shichosonCode(6, 0),
    koikiJutokuSochimotoShichosonCode(6, 0),
    kyoShichosonCode(6, 0),
    shikibetsuCode(15, 0),
    kanjiMeisho(120, 0),
    jigyoshoMeisho(120, 0),
    shokisaiHokenshaNo(6, 0);

    private final int maxLength;
    private final int scale;

    private DbTKyufukanrihyoDataTempTable(int maxLength, int scale) {
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
