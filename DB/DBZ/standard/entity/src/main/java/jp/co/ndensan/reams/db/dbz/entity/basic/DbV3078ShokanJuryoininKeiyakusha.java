package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還受領委任契約者Aliveテーブルの項目定義クラスです。
 */
public enum DbV3078ShokanJuryoininKeiyakusha implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    /**
     * insertDantaiCd
     */
    insertDantaiCd(2147483647, 0),
    /**
     * insertTimestamp
     */
    insertTimestamp(29, 0),
    /**
     * insertReamsLoginId
     */
    insertReamsLoginId(2147483647, 0),
    /**
     * insertContextId
     */
    insertContextId(2147483647, 0),
    /**
     * isDeleted
     */
    isDeleted(1, 0),
    /**
     * updateCount
     */
    updateCount(10, 0),
    /**
     * lastUpdateTimestamp
     */
    lastUpdateTimestamp(29, 0),
    /**
     * lastUpdateReamsLoginId
     */
    lastUpdateReamsLoginId(2147483647, 0),
    /**
     * hihokenshaNo
     */
    hihokenshaNo(2147483647, 0),
    /**
     * shoKisaiHokenshaNo
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * uketsukeYMD
     */
    uketsukeYMD(2147483647, 0),
    /**
     * rirekiNo
     */
    rirekiNo(5, 0),
    /**
     * shinseiYMD
     */
    shinseiYMD(2147483647, 0),
    /**
     * jigyoshaKeiyakuNo
     */
    jigyoshaKeiyakuNo(10, 0),
    /**
     * keiyakuServiceShurui
     */
    keiyakuServiceShurui(1, 0),
    /**
     * ketteiYMD
     */
    ketteiYMD(2147483647, 0),
    /**
     * shoninKekkaKubun
     */
    shoninKekkaKubun(1, 0),
    /**
     * juryoininKaishiYMD
     */
    juryoininKaishiYMD(2147483647, 0),
    /**
     * juryoininShuryoYMD
     */
    juryoininShuryoYMD(2147483647, 0),
    /**
     * keiyakuNo
     */
    keiyakuNo(8, 0),
    /**
     * fuShoninRiyu
     */
    fuShoninRiyu(80, 0),
    /**
     * hiyoGakuGokei
     */
    hiyoGakuGokei(9, 0),
    /**
     * hokenTaishoHiyoGaku
     */
    hokenTaishoHiyoGaku(9, 0),
    /**
     * riyoshaJikoFutanGaku
     */
    riyoshaJikoFutanGaku(9, 0),
    /**
     * hokenKyufuhiGaku
     */
    hokenKyufuhiGaku(9, 0),
    /**
     * shoninKekkaTsuchiSakuseiYMD
     */
    shoninKekkaTsuchiSakuseiYMD(2147483647, 0),
    /**
     * shoninKekkaTsuchiSaiHakkoKubun
     */
    shoninKekkaTsuchiSaiHakkoKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbV3078ShokanJuryoininKeiyakusha(int maxLength, int scale) {
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
