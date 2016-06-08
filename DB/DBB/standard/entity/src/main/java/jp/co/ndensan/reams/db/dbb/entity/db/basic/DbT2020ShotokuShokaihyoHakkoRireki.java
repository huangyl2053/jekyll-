package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 所得照会票発行履歴テーブルの項目定義クラスです。
 * <br/> 所得照会票の発行履歴を管理します。リアル・バッチともに対象とします。）
 */
public enum DbT2020ShotokuShokaihyoHakkoRireki implements IColumnDefinition {
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
     * 照会年度
     */
    shoriNendo(2147483647, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 照会先地方公共団体コード
     */
    shokaisakiLasdecCode(2147483647, 0),
    /**
     * 世帯コード
     */
    setaiCode(2147483647, 0),
    /**
     * 発行ユーザーID
     */
    hakkoReamsLoginId(2147483647, 0),
    /**
     * 発行日
     */
    hakkoYMD(2147483647, 0),
    /**
     * 作成日時
     */
    sakuseiTimestamp(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT2020ShotokuShokaihyoHakkoRireki(int maxLength, int scale) {
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
