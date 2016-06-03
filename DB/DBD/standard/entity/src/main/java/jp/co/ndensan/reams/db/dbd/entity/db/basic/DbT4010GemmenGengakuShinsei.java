package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 減免減額申請テーブルの項目定義クラスです。
 * <br/> 減免・減額の申請届出に関する情報を一元管理する。
 */
public enum DbT4010GemmenGengakuShinsei implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
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
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 減免減額種類
     * <br/>DBDEnum.減免減額種類
     * <br/> 01：標準負担額減免
     * <br/> 02：特定標準負担額減額
     * <br/> 03：利用者負担額減額
     * <br/> 04：社会福祉法人等利用者負担軽減
     * <br/> 05：訪問介護利用者負担額減額
     * <br/> 06：特別地域加算減免
     * <br/> 07：負担限度額認定
     * <br/> 08：特定負担限度額認定
     * <br/> 09：市民課税特例減額
     */
    gemmenGengakuShurui(2, 0),
    /**
     * 履歴番号
     * <br/>各申請の履歴とリンクする履歴番号
     */
    shinseiRirekiNo(5, 0),
    /**
     * 申請届出代行区分
     * <br/>DBDEnum.申請届出代行区分
     * <br/>1:本人
     * <br/>2:家族
     * <br/>3:委任者
     * <br/>4:代行事業者等
     */
    shinseiTodokedeDaikoKubun(2, 0),
    /**
     * 申請届出者氏名
     */
    shinseiTodokedeshaShimei(2147483647, 0),
    /**
     * 申請届出者氏名カナ
     */
    shinseiTodokedeshaKanaShimei(2147483647, 0),
    /**
     * 申請届出者続柄
     */
    shinseiTodokedeshaTsuzukigara(10, 0),
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

    private DbT4010GemmenGengakuShinsei(int maxLength, int scale) {
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
