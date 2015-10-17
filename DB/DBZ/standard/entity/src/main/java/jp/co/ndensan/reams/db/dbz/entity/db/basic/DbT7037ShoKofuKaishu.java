package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 証交付回収テーブルの項目定義クラスです。
 * <br/> 被保険者証および資格者証の交付記録および回収記録を管理します。
 */
public enum DbT7037ShoKofuKaishu implements IColumnDefinition {
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
     * 交付証種類
     * <br/>コード定義
     */
    kofuShoShurui(3, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 交付年月日
     */
    kofuYMD(2147483647, 0),
    /**
     * 有効期限
     */
    yukoKigenYMD(2147483647, 0),
    /**
     * 交付事由
     * <br/>コード定義
     */
    kofuJiyu(2, 0),
    /**
     * 交付理由
     */
    kofuRiyu(2147483647, 0),
    /**
     * 回収年月日
     */
    kaishuYMD(2147483647, 0),
    /**
     * 回収事由
     * <br/>コード定義
     */
    kaishuJiyu(2, 0),
    /**
     * 回収理由
     */
    kaishuRiyu(2147483647, 0),
    /**
     * 単票発行有無フラグ
     * <br/>True：単票発行した、False：単票発行していない
     */
    tanpyoHakkoUmuFlag(1, 0),
    /**
     * 発行処理日時
     */
    hakkoShoriTimestamp(2147483647, 0),
    /**
     * 新様式印書済区分コード
     * <br/>00：初期値、01：新様式印書済
     */
    shinYoshikiSumiKubunCode(2, 0),
    /**
     * 証様式区分コード
     * <br/>00：旧様式、01：新様式、02：新様式２
     */
    shoYoshikiKubunCode(2, 0),
    /**
     * 論理削除フラグ
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7037ShoKofuKaishu(int maxLength, int scale) {
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
