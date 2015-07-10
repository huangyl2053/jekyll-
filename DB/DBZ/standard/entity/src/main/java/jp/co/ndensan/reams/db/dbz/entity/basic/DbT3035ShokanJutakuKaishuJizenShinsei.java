package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3035ShokanJutakuKaishuJizenShinseiの項目定義クラスです
 *
 */
public enum DbT3035ShokanJutakuKaishuJizenShinsei implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    hiHokenshaNo(2147483647, 0),
    serviceTeikyoYM(2147483647, 0),
    seiriNo(10, 0),
    shoriTimestamp(2147483647, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    uketsukeYMD(2147483647, 0),
    shinseiYMD(2147483647, 0),
    jigyoshaNo(2147483647, 0),
    jigyoshaNameKanji(40, 0),
    jigyoshaNameKana(40, 0),
    jigyoshaYubunNo(2147483647, 0),
    jigyoshaAddress(60, 0),
    jigyoshaTelNo(14, 0),
    jigyoshaFaxNo(14, 0),
    riyushoSakuseishaKanji(60, 0),
    riyushoSakuseishaKana(40, 0),
    serviceShuruiCode(2147483647, 0),
    keiyakuKetteiYMD(2147483647, 0),
    shoninKubun(1, 0),
    fushoninRiyu(45, 0),
    kyufugakuHiyogakuTotal(10, 0),
    kyufugakuHokenTaishoHiyogaku(10, 0),
    kyufugakuRiyoshaJikofutangaku(10, 0),
    kyufugakuHokenkyufuhigaku(10, 0),
    sekoKanryoYoteiYMD(2147483647, 0),
    shinseiTorikeshiJiyuCode(2, 0),
    biko(50, 0);

    private final int maxLength;
    private final int scale;

    private DbT3035ShokanJutakuKaishuJizenShinsei(int maxLength, int scale) {
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
