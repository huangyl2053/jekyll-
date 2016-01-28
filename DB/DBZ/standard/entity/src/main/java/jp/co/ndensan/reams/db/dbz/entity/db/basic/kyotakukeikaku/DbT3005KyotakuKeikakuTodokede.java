package jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3005KyotakuKeikakuTodokedeの項目定義クラスです
 *
 */
public enum DbT3005KyotakuKeikakuTodokede implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">
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
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 対象年月
     */
    taishoYM(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 届出区分
     * <br/>1:新規,2:変更,3:暫定
     */
    todokedeKubun(1, 0),
    /**
     * 届出年月日
     */
    todokedeYMD(2147483647, 0),
    /**
     * 届出者氏名
     */
    todokedeshaShimei(2147483647, 0),
    /**
     * 届出者氏名カナ
     */
    todokedeshaShimeiKana(2147483647, 0),
    /**
     * 届出者郵便番号
     */
    todokedeshaYubinNo(2147483647, 0),
    /**
     * 届出者住所
     */
    todokedeshaJusho(100, 0),
    /**
     * 届出者電話番号
     */
    todokedeshaTelNo(2147483647, 0),
    /**
     * 届出者関係区分
     * <br/>1:本人,2:家族,3:代理人,4:サービス事業者,5:ケアマネージャ
     */
    todokedeshaKankeiKubun(20, 0),
    /**
     * 暫定区分
     */
    zanteiKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3005KyotakuKeikakuTodokede(int maxLength, int scale) {
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
