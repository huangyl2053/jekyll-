package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7001FufukuMoshitateの項目定義クラスです
 *
 */
public enum DbT7001FufukuMoshitate implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    shikibetsuCode(2147483647, 0),
    genshobunsHihokennshaNo(2147483647, 0),
    shinsaSeikyuTodokedeYMD(2147483647, 0),
    genshobunHihokenshaYubinNo(2147483647, 0),
    genshobunHihokenshaJusho(2147483647, 0),
    genshobunHihokenshaShimei(2147483647, 0),
    genshobunHihokenshaTelNo(2147483647, 0),
    genshobunHihokenshaBirthYMD(2147483647, 0),
    shinsaSeikyuninYubinNo(2147483647, 0),
    shinsaSeikyuninJusho(2147483647, 0),
    shinsaSeikyuninShimei(2147483647, 0),
    shinsaSeikyuninTelNo(2147483647, 0),
    hihokenshaTonoKankeiCode(2147483647, 0),
    dairininYubinNo(2147483647, 0),
    dairininJusho(2147483647, 0),
    dairininShimei(2147483647, 0),
    dairininTelNo(2147483647, 0),
    shobunCho(80, 0),
    shobunYMD(2147483647, 0),
    shobunShuruiCode(2147483647, 0),
    shobunKakuninYMD(2147483647, 0),
    shinsaSeikyuRiyu(2147483647, 0),
    shobunChoKyojiNaiyo(2147483647, 0),
    tempuShoruiTo(1, 0),
    shinsaSeikyuTorisageYMD(2147483647, 0),
    bemmeishoTorokuFlag(1, 0),
    bemmeishoSakuseiYMD(2147483647, 0),
    saiketsuYMD(2147483647, 0),
    saiketsuKekka(2147483647, 0),
    saiketsuRiyu(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7001FufukuMoshitate(int maxLength, int scale) {
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
