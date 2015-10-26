package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護認定審査会開催場所情報テーブルの項目定義クラスです。
 */
public enum DbT5592ShinsakaiKaisaiBashoJoho implements IColumnDefinition {
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
     * 介護認定審査会開催場所コード
     */
    shinsakaiKaisaiBashoCode(9, 0),
    /**
     * 介護認定審査会開催場所名称
     */
    shinsakaiKaisaiBashoName(512, 0),
    /**
     * 介護認定審査会開催地区コード
     * <br/>Code（DBE：5001）
     */
    shinsakaiKaisaiChikuCode(2147483647, 0),
    /**
     * 介護認定審査会開催場所住所
     */
    shinsakaiKaisaiBashoJusho(512, 0),
    /**
     * 介護認定審査会開催場所電話番号
     */
    shinsakaiKaisaiBashoTelNo(2147483647, 0),
    /**
     * 介護認定審査会開催場所状況
     * <br/>Enum（DBE:審査会開催場所状況）
     */
    shinsakaiKaisaiBashoJokyo(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT5592ShinsakaiKaisaiBashoJoho(int maxLength, int scale) {
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
