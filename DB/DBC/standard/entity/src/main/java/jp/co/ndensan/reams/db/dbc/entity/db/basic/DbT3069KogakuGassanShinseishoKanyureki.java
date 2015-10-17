package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 高額合算申請書加入歴テーブルの項目定義クラスです。
 */
public enum DbT3069KogakuGassanShinseishoKanyureki implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
     * 対象年度
     */
    taishoNendo(2147483647, 0),
    /**
     * 保険者番号
     * <br/>証記載保険者番号では無い
     */
    hokenshaNo(2147483647, 0),
    /**
     * 整理番号
     * <br/>年度単位で”000001”からの連番
     */
    seiriNo(6, 0),
    /**
     * 加入歴番号
     * <br/>”01”からの連番
     */
    kanyurekiNo(2, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 保険者名
     */
    hokenshaMei(20, 0),
    /**
     * 加入期間開始年月日
     */
    kanyuKaishiYMD(2147483647, 0),
    /**
     * 加入期間終了年月日
     */
    kanyuShuryoYMD(2147483647, 0),
    /**
     * 自己負担額証明書整理番号
     */
    jikoFutanShomeisho_SeiriNo(20, 0);

    private final int maxLength;
    private final int scale;

    private DbT3069KogakuGassanShinseishoKanyureki(int maxLength, int scale) {
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
