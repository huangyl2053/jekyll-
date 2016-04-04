package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 特徴未同定情報テーブルの項目定義クラスです。
 * <br/> バッチの通知書一括発行のリアル発行された通知書を除外する考慮のため、リアル発行の履歴を通知書番号単位で管理する。
 */
public enum DbT2019TokuchoMidoteiJoho implements IColumnDefinition {
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
     * 処理年度
     */
    shoriNendo(2147483647, 0),
    /**
     * 基礎年金番号
     */
    kisoNenkinNo(10, 0),
    /**
     * 年金コード
     */
    nenkinCode(4, 0),
    /**
     * 捕捉月
     */
    hosokuM(2, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 開始月
     */
    kaishiM(2, 0),
    /**
     * 不一致理由コード
     */
    fuichiRiyuCode(2, 0),
    /**
     * 確認状況区分
     * <br/>0：未同定　1：同定済み　2：対象外
     */
    kakuninJokyoKbn(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT2019TokuchoMidoteiJoho(int maxLength, int scale) {
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
