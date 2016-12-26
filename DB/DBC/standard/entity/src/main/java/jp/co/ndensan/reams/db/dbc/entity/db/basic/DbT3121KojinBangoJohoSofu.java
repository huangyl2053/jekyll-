package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 個人番号情報送付テーブルの項目定義クラスです。
 */
public enum DbT3121KojinBangoJohoSofu implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
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
     * 異動年月日
     * <br/>個人番号情報の登録または変更等が生じた年月日
     */
    idoYMD(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 個人番号
     */
    kojinNo(12, 0),
    /**
     * 証記載保険者番号
     * <br/>Not（地方公共団体コード（導入団体）⇒保険者番号）	被保険者証記載の保険者番号　　広域連合の場合は市町村コード
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 処理年月
     */
    shoriYM(2147483647, 0),
    /**
     * 訂正年月日
     * <br/>個人番号情報に訂正が生じた日
     */
    teiseiYMD(2147483647, 0),
    /**
     * 訂正区分
     * <br/>1：（未使用）　2：修正　3：削除
     */
    teiseiKubunCode(1, 0),
    /**
     * 異動事由
     * <br/>01：受給者台帳の異動（新規、区間異動等）　02：個人番号の変更による異動
     */
    idoJiyu(2, 0),
    /**
     * 異動区分
     * <br/>1：新規　2：変更　3：終了
     */
    idoKubunCode(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3121KojinBangoJohoSofu(int maxLength, int scale) {
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
