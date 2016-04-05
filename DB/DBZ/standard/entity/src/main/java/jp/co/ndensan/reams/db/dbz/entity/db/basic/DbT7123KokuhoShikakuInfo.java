package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 国保資格情報テーブルの項目定義クラスです。
 */
public enum DbT7123KokuhoShikakuInfo implements IColumnDefinition {
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
     * 履歴番号
     */
    rirekiNo(4, 0),
    /**
     * 国保番号
     */
    kokuhoNo(14, 0),
    /**
     * 国保保険者番号
     */
    kokuhoHokenshaNo(8, 0),
    /**
     * 国保保険証番号
     */
    kokuhoHokenshoNo(20, 0),
    /**
     * 国保個人番号
     */
    kokuhoKojinNo(10, 0),
    /**
     * 資格取得日
     */
    shikakuShutokuYMD(8, 0),
    /**
     * 資格喪失日
     */
    shikakuSoshitsuYMD(8, 0),
    /**
     * 退職該当日
     */
    taishokuGaitoYMD(8, 0),
    /**
     * 退職非該当日
     */
    taishokuHigaitoYMD(8, 0),
    /**
     * 個人区分コード
     * <br/>1:住基、2:外国人、3:住登外
     */
    kojinKubunCode(1, 0),
    /**
     * 登録区分
     * <br/>1:画面登録、0:データ連携
     */
    torokuKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7123KokuhoShikakuInfo(int maxLength, int scale) {
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
