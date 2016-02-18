package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 通知書発行後異動者テーブルの項目定義クラスです。
 * <br/> 通知書の一括発行時、発行対象とした賦課の情報を登録しておくテーブル。
     * <br/>その後、住基や資格情報に異動があったかどうかを検証する際に用いる。
 */
public enum DbT2017TsuchishoHakkogoIdosha implements IColumnDefinition {
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
     * 帳票ID
     * <br/>一括発行対象となった帳票ID。
     */
    reportID(2147483647, 0),
    /**
     * 帳票作成日時
     * <br/>一括発行の日時（同じ一括発行であれば、同じ日時とする）。
     */
    chohyosakuseiTimestamp(2147483647, 0),
    /**
     * 通知書番号
     * <br/>通知書発行対象となった賦課の通知書番号。
     */
    tsuchishoNo(2147483647, 0),
    /**
     * 賦課年度
     * <br/>通知書発行対象となった賦課の賦課年度。
     */
    fukaNendo(2147483647, 0),
    /**
     * 識別コード
     * <br/>賦課・通知書発行の対象となった被保険者の識別コード。
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 被保険者番号
     * <br/>賦課、通知書発行の対象となった被保険者の被保険者番号。
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 計算処理日時
     * <br/>賦課の計算が行われた日時（＝調定日時）。
     */
    keisanTimestamp(2147483647, 0),
    /**
     * 該当連番
     * <br/>バッチの一括発行時、発行順に振られた連番。
     */
    gaitoRemban(10, 0),
    /**
     * 異動年月日
     * <br/>通知書発行後に異動のあった年月日。
     */
    idoYMD(2147483647, 0),
    /**
     * 異動内容
     * <br/>通知書発行後にあった異動の内容。
     * <br/>0：なし 1:資格異動 2:氏名変更 3:本人住所変更
     */
    idoNaiyo(1, 0),
    /**
     * 異動ありフラグ
     * <br/>異動チェック時、通知書発行後に異動があった場合、trueを設定する。チェック処理の前はすべてfalse。
     */
    idoAriFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT2017TsuchishoHakkogoIdosha(int maxLength, int scale) {
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
