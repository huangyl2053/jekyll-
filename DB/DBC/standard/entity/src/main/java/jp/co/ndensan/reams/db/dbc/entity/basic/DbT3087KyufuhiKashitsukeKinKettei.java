package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 給付費貸付金決定テーブルの項目定義クラスです。
 */
public enum DbT3087KyufuhiKashitsukeKinKettei implements IColumnDefinition {
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
     * 借入申請年月日
     */
    kariireShinseiYMD(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 貸付審査決定年月日
     */
    kashitsukeShinsaKetteiYMD(2147483647, 0),
    /**
     * 貸付承認・不承認区分
     */
    kashitsukeShonin_FuShoninKubun(1, 0),
    /**
     * 貸付管理番号
     */
    kashitsukeKanriNo(10, 0),
    /**
     * 貸付金額
     */
    kashitsukeKingaku(10, 0),
    /**
     * 償還方法
     */
    shokanHoho(1, 0),
    /**
     * 償還期限
     */
    shokanKigenYMD(2147483647, 0),
    /**
     * 貸付年月日
     */
    kashitsukeYMD(2147483647, 0),
    /**
     * 貸付支払方法
     * <br/>1:窓口払い,2:口座払い
     */
    kashitsukeShiharaiHoho(1, 0),
    /**
     * 貸付窓口支払場所
     */
    kashitsukeMadoguchiShiharaiBasho(64, 0),
    /**
     * 貸付窓口開始年月日
     */
    kashitsukeMadoguchiKaishiYMD(2147483647, 0),
    /**
     * 貸付窓口終了年月日
     */
    kashitsukeMadoguchiShuryoYMD(2147483647, 0),
    /**
     * 貸付窓口閉庁内容
     */
    kashitsukeMadoguchiHeichoNaiyo(50, 0),
    /**
     * 貸付窓口開始時間
     */
    kashitsukeMadoguchiKaishiTime(4, 0),
    /**
     * 貸付窓口終了時間
     */
    kashitsukeMadoguchiShuryoTime(4, 0),
    /**
     * 貸付不承認理由
     */
    kashitsukeFuShoninRiyu(100, 0),
    /**
     * 識別コード
     * <br/>口座情報取得用
     */
    shikibetsuCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3087KyufuhiKashitsukeKinKettei(int maxLength, int scale) {
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
