package jp.co.ndensan.reams.db.dbd.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 申請届出情報テーブルの項目定義クラスです。
 * <br/> 申請届出情報を一元管理する
 */
public enum DbT5120ShinseitodokedeJoho implements IColumnDefinition {
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
     * 申請書管理番号
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 申請届出代行区分コード
     * <br/>本人・家族・委任者・代行事業者等
     */
    shinseiTodokedeDaikoKubunCode(2147483647, 0),
    /**
     * 申請届出者氏名
     */
    shinseiTodokedeshaShimei(2147483647, 0),
    /**
     * 申請届出者氏名カナ
     */
    shinseiTodokedeshaKanaShimei(2147483647, 0),
    /**
     * 申請届出者続柄コード
     */
    shinseiTodokedeshaTsuzukigaraCode(32, 0),
    /**
     * 申請届出代行事業者番号
     */
    shinseiTodokedeDaikoJigyoshaNo(2147483647, 0),
    /**
     * 事業者区分
     */
    jigyoshaKubun(2, 0),
    /**
     * 申請届出者郵便番号
     */
    shinseiTodokedeshaYubinNo(2147483647, 0),
    /**
     * 申請届出者住所
     */
    shinseiTodokedeshaJusho(2147483647, 0),
    /**
     * 申請届出者電話番号
     */
    shinseiTodokedeshaTelNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5120ShinseitodokedeJoho(int maxLength, int scale) {
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
