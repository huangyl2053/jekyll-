package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3065ShichosonTokubetsuKyufuJigyoshaの項目定義クラスです
 *
 */
public enum DbT3065ShichosonTokubetsuKyufuJigyosha implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    jigyoshaNo(2147483647, 0),
    serviceCode(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    idoKubun(2, 0),
    idoYMD(2147483647, 0),
    teiseiKubun(2, 0),
    teiseiYMD(2147483647, 0),
    hojinShubetsu(2, 0),
    shinseishaNameKanji(30, 0),
    shinseishaNameKana(40, 0),
    shinseishaYubinNo(2147483647, 0),
    shinseishaAddressKanji(60, 0),
    shinseishaAddressKana(80, 0),
    shinseishaTelNo(14, 0),
    shinseishaFaxNo(14, 0),
    jigyoshoDaihyoshaYakushoku(20, 0),
    jigyoshoDaihyoshaNameKanji(40, 0),
    jigyoshoDaihyoshaNameKana(40, 0),
    jigyoshoDaihyoshaYubinNo(2147483647, 0),
    jigyoshoDaihyoshaAddressKanji(60, 0),
    jigyoshoDaihyoshaAddressKana(80, 0),
    jigyoshoKanrishaNameKanji(30, 0),
    jigyoshoKanrishaNameKana(40, 0),
    jigyoshoKanrishaYubinNo(2147483647, 0),
    jigyoshoKanrishaAddressKanji(60, 0),
    jigyoshoKanrishaAddressKana(80, 0),
    serviceJigyoshoNameKanji(40, 0),
    serviceJigyoshoNameKana(40, 0),
    serviceJigyoshoYubinNo(2147483647, 0),
    serviceJigyoshoAddressKanji(60, 0),
    serviceJigyoshoAddressKana(80, 0),
    serviceJigyoshoTelNo(14, 0),
    serviceJigyoshoFaxNo(14, 0),
    serviceJigyoshoJigyoKaisiYMD(2147483647, 0),
    serviceJigyoshoJigyoKyushiYMD(2147483647, 0),
    serviceJigyoshoJigyoHaishiYMD(2147483647, 0),
    serviceJigyoshoJigyoSaikaiYMD(2147483647, 0),
    shokisaiHokenshaNo(2147483647, 0),
    juryoIninKubu(1, 0),
    torokuKaishiYMD(2147483647, 0),
    torokuShuryoYMD(2147483647, 0),
    seikatsuhogoShiteiFlag(1, 0),
    shichosonCode(2147483647, 0),
    chiikiKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3065ShichosonTokubetsuKyufuJigyosha(int maxLength, int scale) {
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
