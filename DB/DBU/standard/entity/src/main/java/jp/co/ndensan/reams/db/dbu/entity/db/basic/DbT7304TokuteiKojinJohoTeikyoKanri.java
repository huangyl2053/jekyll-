package jp.co.ndensan.reams.db.dbu.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 特定個人情報提供管理テーブルの項目定義クラスです。
 */
public enum DbT7304TokuteiKojinJohoTeikyoKanri implements IColumnDefinition {
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
     * 被保険者番号
     * <br/>年報時は、年度を設定
     */
    hihokenshaNo(2147483647, 0),
    /**
     * データセットレコードキー
     * <br/>年報時は、「00」を設定
     */
    dataSetRecordKey(2, 0),
    /**
     * 提供日時
     * <br/>年報時は、年度を設定
     */
    teikyoNichiji(2147483647, 0),
    /**
     * 新規異動区分
     * <br/>年報時は、「00」を設定
     */
    shinkiIdoKubun(1, 0),
    /**
     * 提供区分
     * <br/>広域の場合、広域保険者か構成市町村か、 合併市町村の場合、新市町村か旧市町村か
     */
    teikyoKubun(1, 0),
    /**
     * 特定個人情報名コード
     */
    tokuteiKojinJohoMeiCode(16, 0),
    /**
     * 版番号
     */
    hanNo(4, 0),
    /**
     * データセット番号
     */
    dataSetNo(4, 0),
    /**
     * 公開年月日
     */
    kokaiYMD(2147483647, 0),
    /**
     * 識別コード
     */
    tateNo(2147483647, 0),
    /**
     * 送信内容１
     */
    soshinNaiyo01(2147483647, 0),
    /**
     * 未設定事由１
     */
    misetteiJiyu01(2147483647, 0),
    /**
     * 送信内容２
     */
    soshinNaiyo02(2147483647, 0),
    /**
     * 未設定事由２
     */
    misetteiJiyu02(2147483647, 0),
    /**
     * 送信内容３
     */
    soshinNaiyo03(2147483647, 0),
    /**
     * 未設定事由３
     */
    misetteiJiyu03(2147483647, 0),
    /**
     * 送信内容４
     */
    soshinNaiyo04(2147483647, 0),
    /**
     * 未設定事由４
     */
    misetteiJiyu04(2147483647, 0),
    /**
     * 送信内容５
     */
    soshinNaiyo05(2147483647, 0),
    /**
     * 未設定事由５
     */
    misetteiJiyu05(2147483647, 0),
    /**
     * 送信内容６
     */
    soshinNaiyo06(2147483647, 0),
    /**
     * 未設定事由６
     */
    misetteiJiyu06(2147483647, 0),
    /**
     * 送信内容７
     */
    soshinNaiyo07(2147483647, 0),
    /**
     * 未設定事由７
     */
    misetteiJiyu07(2147483647, 0),
    /**
     * 送信内容８
     */
    soshinNaiyo08(2147483647, 0),
    /**
     * 未設定事由８
     */
    misetteiJiyu08(2147483647, 0),
    /**
     * 送信内容９
     */
    soshinNaiyo09(2147483647, 0),
    /**
     * 未設定事由９
     */
    misetteiJiyu09(2147483647, 0),
    /**
     * 送信内容１０
     */
    soshinNaiyo10(2147483647, 0),
    /**
     * 未設定事由１０
     */
    misetteiJiyu10(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7304TokuteiKojinJohoTeikyoKanri(int maxLength, int scale) {
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
