package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT5016IchijiHanteiKekkaJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public enum DbT5016IchijiHanteiKekkaJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shinseishoKanriNo(2147483647, 0),
    koroshoIfShikibetsuCode(3, 0),
    kariIchijiHanteiKubun(1, 0),
    ichijiHanteiYMD(2147483647, 0),
    ichijiHanteiKekkaCode(2147483647, 0),
    ichijiHanteiKekkaNinchishoKasanCode(2147483647, 0),
    kijunJikan(5, 0),
    kijunJikanShokuji(5, 0),
    kijunJikanHaisetsu(5, 0),
    kijunJikanIdo(5, 0),
    kijunJikanSeiketsuHoji(5, 0),
    kijunJikanKansetsuCare(5, 0),
    kijunJikanBPSDKanren(5, 0),
    kijunJikanKinoKunren(5, 0),
    kijunJikanIryoKanren(5, 0),
    kijunJikanNinchishoKasan(5, 0),
    chukanHyokaKomoku1gun(5, 0),
    chukanHyokaKomoku2gun(5, 0),
    chukanHyokaKomoku3gun(5, 0),
    chukanHyokaKomoku4gun(5, 0),
    chukanHyokaKomoku5gun(5, 0),
    chukanHyokaKomoku6gun(5, 0),
    chukanHyokaKomoku7gun(5, 0),
    ichijiHanteiKeikokuCode(2147483647, 0),
    jotaiAnteiseiCode(2147483647, 0),
    ninchishoJiritsudoIIijoNoGaizensei(131089, 0),
    suiteiKyufuKubunCode(2147483647, 0),
    ninchishoKoreishaShihyoCode(2147483647, 0),
    jiritsudoKumiawase1(5, 0),
    jiritsudoKumiawase2(5, 0),
    jiritsudoKumiawase3(5, 0),
    jiritsudoKumiawase4(5, 0),
    jiritsudoKumiawase5(5, 0),
    jiritsudoKumiawase6(5, 0),
    jiritsudoKumiawase7(5, 0),
    gaizenseiHyokaCode(2147483647, 0),
    gaizenseiHyokaPercent(5, 0),
    ichijiHanteiSofuKubun(1, 0),
    ichijiHanteiKekkaSofuYMD(2147483647, 0);
    private final int maxLength;
    private final int scale;

    private DbT5016IchijiHanteiKekkaJoho(int maxLength, int scale) {
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
