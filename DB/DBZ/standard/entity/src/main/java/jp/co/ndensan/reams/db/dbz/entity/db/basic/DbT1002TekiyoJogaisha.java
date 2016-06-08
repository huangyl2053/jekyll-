package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 適用除外者テーブルの項目定義クラスです。
 */
public enum DbT1002TekiyoJogaisha implements IColumnDefinition {
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
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 異動日
     */
    idoYMD(2147483647, 0),
    /**
     * 枝番
     */
    edaNo(4, 0),
    /**
     * 異動事由コード
     */
    idoJiyuCode(2, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 適用除外適用事由コード
     */
    tekiyoJogaiTekiyoJiyuCode(2, 0),
    /**
     * 適用年月日
     */
    tekiyoYMD(2147483647, 0),
    /**
     * 適用届出年月日
     */
    tekiyoTodokedeYMD(2147483647, 0),
    /**
     * 適用受付年月日
     */
    tekiyoUketsukeYMD(2147483647, 0),
    /**
     * 適用除外解除事由コード
     */
    tekiyoJogaikaijokaijoJiyuCode(2, 0),
    /**
     * 解除年月日
     */
    kaijoYMD(2147483647, 0),
    /**
     * 解除届出年月日
     */
    kaijoTodokedeYMD(2147483647, 0),
    /**
     * 解除受付年月日
     */
    kaijoUketsukeYMD(2147483647, 0),
    /**
     * 入所通知発行日
     */
    nyushoTsuchiHakkoYMD(2147483647, 0),
    /**
     * 退所通知発行日
     */
    taishoTsuchiHakkoYMD(2147483647, 0),
    /**
     * 変更通知発行日
     */
    henkoTsuchiHakkoYMD(2147483647, 0),
    /**
     * 論理削除フラグ
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT1002TekiyoJogaisha(int maxLength, int scale) {
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
