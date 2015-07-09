package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 広域外字変換エラーログテーブルの項目定義クラスです。
 */
public enum DbT7034KoikiGaijiHenkanErrorLog implements IColumnDefinition {
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
     * 処理番号
     */
    shoriNo(18, 0),
    /**
     * 連番
     */
    renNo(8, 0),
    /**
     * 市町村番号
     */
    shichosonCode(2147483647, 0),
    /**
     * 種別
     */
    shubetsu(2, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 送信元市町村コード
     */
    motoShichosonCode(2147483647, 0),
    /**
     * 送信元市町村名称
     */
    motoShichosonMeisho(20, 0),
    /**
     * 送信先市町村コード
     */
    sakiShichosonCode(2147483647, 0),
    /**
     * 送信先市町村名称
     */
    sakiShichosonMeisho(20, 0),
    /**
     * 住基識別コード
     */
    jukiShikibetsuCode(2147483647, 0),
    /**
     * 確認区分
     */
    kakuninKubun(1, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * レコードＮｏ
     */
    recoadNo(6, 0),
    /**
     * 変換エラーフィールド名称
     */
    errorKomokuMeisho(20, 0),
    /**
     * 変換エラーフィールドＮｏ
     */
    errorKomokuNo(4, 0),
    /**
     * 変換エラーコード
     */
    errorCode(4, 0),
    /**
     * エラー表示連番
     */
    errorHyojiRenban(2, 0),
    /**
     * エラー表示フィールド名称
     */
    errorHyojiKomokuMeisho(20, 0),
    /**
     * エラー表示フィールド
     */
    errorHyojiKomoku(50, 0);

    private final int maxLength;
    private final int scale;

    private DbT7034KoikiGaijiHenkanErrorLog(int maxLength, int scale) {
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
