package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT5001NinteiShinseiJohoの項目定義クラスです
 *
 */
public enum DbT5001NinteiShinseiJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shinseishoKanriNo(10, 0),
    shoriTimestamp(2147483647, 0),
    shoKisaiHokenshaNo(6, 0),
    shishoCode(9, 0),
    hihokenshaNo(10, 0),
    shikibetsuCode(2147483647, 0),
    ninteiShinseiYMD(2147483647, 0),
    ninteiShinseiEdabanCode(2147483647, 0),
    ninteiShinseiShinseijiKubunCode(2147483647, 0),
    ninteiShinseiHoreiKubunCode(2147483647, 0),
    ninteiShinseiYukoKubunCode(2147483647, 0),
    shienShinseiKubun(1, 0),
    shinseiRiyu(2147483647, 0),
    zenYokaigoKubunCode(2147483647, 0),
    zenYukoKikan(5, 0),
    johoteikyoDouiUmuKubun(1, 0),
    ninteichosaIraiRirekiNo(5, 0),
    ninteichosaShikibetsuCode(2147483647, 0),
    ikenshoIraiRirekiNo(5, 0),
    kaigoIryokikanCode(10, 0),
    kaigoIshiCode(8, 0),
    minashiCode(1, 0),
    enkitsuchiDoiUmuKubun(1, 0),
    shisetsuNyushoUmuKubun(1, 0),
    sichosonRenrakuJiko(2147483647, 0),
    torisageKubunCode(2147483647, 0),
    torisageRiyu(2147483647, 0),
    torisageYMD(2147483647, 0),
    shinsaKeizokuKubun(1, 0),
    shinsakaiYusenWaritsukeKubunCode(2147483647, 0),
    ifSofuYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5001NinteiShinseiJoho(int maxLength, int scale) {
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
