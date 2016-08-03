package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 通知書発行情報テーブルの項目定義クラスです。
 */
public enum DbT4122TsuchishoHakkoJoho implements IColumnDefinition {
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
     * 申請書管理番号
     * <br/>要介護認定申請情報
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 通知区分
     * <br/>00:認定、01:変更、02:サ変、03:却下、04:取消、05:延期、06:区却
     */
    tsuchiKubun(2147483647, 0),
    /**
     * 通知理由
     */
    tsuchiRiyu(2147483647, 0),
    /**
     * 通知年月日
     */
    tsuchiYMD(2147483647, 0),
    /**
     * 通知開始年月日
     */
    tsuchiKaishiYMD(2147483647, 0),
    /**
     * 通知終了年月日
     */
    tsuchiShuryoYMD(2147483647, 0),
    /**
     * 通知区分期限
     */
    tsuchiKubunKigenYMD(2147483647, 0),
    /**
     * 通知完了年月日
     */
    tsuchiKanryoYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT4122TsuchishoHakkoJoho(int maxLength, int scale) {
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
