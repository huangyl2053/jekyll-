package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 給付費貸付金償還期限変更テーブルの項目定義クラスです。
 */
public enum DbT3089KyufuhiKashitsukekinShokanKigenHenko implements IColumnDefinition {
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
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 貸付管理番号
     */
    kashitsukeKanriNo(10, 0),
    /**
     * 償還期限延長受付年月日
     */
    shokanKigenEnchoUketsukeYMD(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 償還期限延長申請年月日
     */
    shokanKigenEnchoShinseiYMD(2147483647, 0),
    /**
     * 借受人郵便番号
     */
    kariukeninYubinNo(2147483647, 0),
    /**
     * 借受人住所
     */
    kariukeninJusho(100, 0),
    /**
     * 借受人氏名カナ
     */
    kariukeninShimeiKana(2147483647, 0),
    /**
     * 借受人氏名
     */
    kariukeninShimei(2147483647, 0),
    /**
     * 借受人電話番号
     */
    kariukeninTelNo(2147483647, 0),
    /**
     * 未償還金額
     */
    miShokanKingaku(10, 0),
    /**
     * 償還期限延長希望期間開始年月日
     */
    enchoKiboKaishiYMD(2147483647, 0),
    /**
     * 償還期限延長希望期間終了年月日
     */
    enchoKiboShuryoYMD(2147483647, 0),
    /**
     * 償還期限延長理由等
     */
    enchoRiyu(200, 0),
    /**
     * 償還期限変更決定年月日
     */
    henkoKetteiYMD(2147483647, 0),
    /**
     * 償還期限変更承認・不承認区分
     */
    henkoShonin_FuShoninKubun(1, 0),
    /**
     * 変更後償還期限
     */
    henkoGoShokanKigenYMD(2147483647, 0),
    /**
     * 償還期限変更不承認理由
     */
    henkoFuShoninRiyu(100, 0);

    private final int maxLength;
    private final int scale;

    private DbT3089KyufuhiKashitsukekinShokanKigenHenko(int maxLength, int scale) {
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
