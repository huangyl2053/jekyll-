package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定インタフェース情報・福祉Viewテーブルの項目定義クラスです。
 */
public enum DbV7513YokaigoNinteiInterfaceFukushi implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    /**
     * shinseishoKanriNo
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * hihokenshaNo
     */
    hihokenshaNo(2147483647, 0),
    /**
     * rirekiNo
     */
    rirekiNo(4, 0),
    /**
     * torikomiTimestamp
     */
    torikomiTimestamp(2147483647, 0),
    /**
     * torikomiKubun
     */
    torikomiKubun(1, 0),
    /**
     * shinseiShubetsuCode
     */
    shinseiShubetsuCode(1, 0),
    /**
     * torisageKubunCode
     */
    torisageKubunCode(1, 0),
    /**
     * shinseiYMD
     */
    shinseiYMD(2147483647, 0),
    /**
     * iryoKikanCode
     */
    iryoKikanCode(10, 0),
    /**
     * shujiiCode
     */
    shujiiCode(8, 0),
    /**
     * ikenshoIraiYMD
     */
    ikenshoIraiYMD(2147483647, 0),
    /**
     * ikenshoToriyoseYMD
     */
    ikenshoToriyoseYMD(2147483647, 0),
    /**
     * chosaItakuYMD
     */
    chosaItakuYMD(2147483647, 0),
    /**
     * chosaShuryoYMD
     */
    chosaShuryoYMD(2147483647, 0),
    /**
     * chosaItakusakiCode
     */
    chosaItakusakiCode(2147483647, 0),
    /**
     * chosainCode
     */
    chosainCode(8, 0),
    /**
     * ichijiHanteiYMD
     */
    ichijiHanteiYMD(2147483647, 0),
    /**
     * ichijiHanteiKekkaCode
     */
    ichijiHanteiKekkaCode(2, 0),
    /**
     * ichijiHanteiKekkaKasanCode
     */
    ichijiHanteiKekkaKasanCode(2, 0),
    /**
     * shinsakaiShiryoSakuseiYMD
     */
    shinsakaiShiryoSakuseiYMD(2147483647, 0),
    /**
     * shinsakaiYoteiYMD
     */
    shinsakaiYoteiYMD(2147483647, 0),
    /**
     * gogitaiNo
     */
    gogitaiNo(5, 0),
    /**
     * nijiHanteiYMD
     */
    nijiHanteiYMD(2147483647, 0),
    /**
     * nijiHanteiKekkaCode
     */
    nijiHanteiKekkaCode(2, 0),
    /**
     * ninteiYukoKikanStart
     */
    ninteiYukoKikanStart(2147483647, 0),
    /**
     * ninteiYukoKikanEnd
     */
    ninteiYukoKikanEnd(2147483647, 0),
    /**
     * serviceHenkoRiyuCode
     */
    serviceHenkoRiyuCode(2, 0),
    /**
     * tokuteiShippeiCode
     */
    tokuteiShippeiCode(2, 0),
    /**
     * shogaiKoreiJiritsudo
     */
    shogaiKoreiJiritsudo(1, 0),
    /**
     * ninchishoKoreiJiritsudo
     */
    ninchishoKoreiJiritsudo(1, 0),
    /**
     * shinsakaiIken
     */
    shinsakaiIken(400, 0),
    /**
     * versionNo
     */
    versionNo(3, 0),
    /**
     * ichijiHanteiNaiyo
     */
    ichijiHanteiNaiyo(2000, 0),
    /**
     * ichijiHanteiNaiyo2
     */
    ichijiHanteiNaiyo2(2000, 0),
    /**
     * zenTorikomiTimestamp
     */
    zenTorikomiTimestamp(2147483647, 0),
    /**
     * keshikomiFlag
     */
    keshikomiFlag(1, 0),
    /**
     * keshikomiTimestamp
     */
    keshikomiTimestamp(2147483647, 0),
    /**
     * yobiKomoku1
     */
    yobiKomoku1(12, 0),
    /**
     * yobiKomoku2
     */
    yobiKomoku2(12, 0),
    /**
     * yobiKomoku3
     */
    yobiKomoku3(12, 0),
    /**
     * yobiKomoku4
     */
    yobiKomoku4(12, 0),
    /**
     * yobiKomoku5
     */
    yobiKomoku5(12, 0),
    /**
     * yobiKubun1
     */
    yobiKubun1(4, 0),
    /**
     * yobiKubun2
     */
    yobiKubun2(2, 0),
    /**
     * yobiKubun3
     */
    yobiKubun3(2, 0),
    /**
     * yobiKubun4
     */
    yobiKubun4(1, 0),
    /**
     * yobiKubun5
     */
    yobiKubun5(1, 0),
    /**
     * reserve
     */
    reserve(200, 0);

    private final int maxLength;
    private final int scale;

    private DbV7513YokaigoNinteiInterfaceFukushi(int maxLength, int scale) {
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
