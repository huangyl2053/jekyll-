package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3014KyufuKanrihyo200004の項目定義クラスです
 *
 */
public enum DbT3014KyufuKanrihyo200004 implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shinsaYM(2147483647, 0),
    serviceTeikyoYM(2147483647, 0),
    shokisaiHokenshaNo(2147483647, 0),
    kyotakushienJigyoshoNo(2147483647, 0),
    kyufuKanrihyoSakuseiKubunCode(1, 0),
    kyufuKanrihyoSakuseiYMD(2147483647, 0),
    kyufuKanrihyoShubetsuKubunCode(1, 0),
    kyufuKanrihyoMeisaiLineNo(2, 0),
    hokenshaNo(2147483647, 0),
    hiHokenshaNo(2147483647, 0),
    hiHokenshaUmareYMD(2147483647, 0),
    seibetsuCode(1, 0),
    yoKaigoJotaiKubunCode(2, 0),
    gendogakuTekiyoKaishiYM(2147483647, 0),
    gendogakuTekiyoShuryoYM(2147483647, 0),
    kyotakuKaigoYoboShikyuGendogaku(6, 0),
    kyotakuServicePlanSakuseiKubunCode(1, 0),
    serviceJigyoshoNo(2147483647, 0),
    shiteiKijungaitoChiikimitchakuServiceShikibetsuCode(1, 0),
    serviceShuruiCode(2147483647, 0),
    kyufuKeikakuTanisuNissu(2, 0),
    kyufuKeikakuNissu(3, 0),
    shiteiServiceSubTotal(6, 0),
    kijyunGaitoServiceSubTotal(6, 0),
    kyufuKeikakuTotalTanisuNissu(6, 0),
    toshoTorokuYMD(2147483647, 0),
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3014KyufuKanrihyo200004(int maxLength, int scale) {
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
