package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7053ShinseitodokedeJohoの項目定義クラスです
 *
 */
public enum DbT7053ShinseitodokedeJoho implements IColumnDefinition {
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
    hihokenshaNo(2147483647, 0),
    shinseiTodokedeYMD(13, 0),
    shinseishoKanriNo(2147483647, 0),
    shinseiTodokedeShubetsuCode(2, 0),
    shinseiTodokedeDaikoKubunCode(2147483647, 0),
    shinseiTodokedeshaShimei(2147483647, 0),
    shinseiTodokedeshaKanaShimei(2147483647, 0),
    shinseiTodokedeshaTsuzukigaraCode(32, 0),
    shinseiTodokedeDaikoJigyoshaNo(2147483647, 0),
    jigyoshaKubun(2, 0),
    shinseiTodokedeshaYubinNo(2147483647, 0),
    shinseiTodokedeshaJusho(2147483647, 0),
    shinseiTodokedeshaTelNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7053ShinseitodokedeJoho(int maxLength, int scale) {
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
