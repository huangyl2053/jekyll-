package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 事業高額合算自己負担額明細テーブルの項目定義クラスです。
 *
 * @reamsid_L DBC-9999-012 zhujun
 */
public enum DbT3171JigyoKogakuGassanJikoFutanGakuMeisai implements IColumnDefinition {
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
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 対象年度
     */
    taishoNendo(2147483647, 0),
    /**
     * 保険者番号
     * <br/>証記載保険者番号
     */
    hokenshaNo(2147483647, 0),
    /**
     * 支給申請書整理番号
     */
    shikyuShinseishoSeiriNo(17, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 対象月
     * <br/>平成20年度：当年004月-012月＋翌年101月-107月、以降の年度：当年008月-012月＋翌年101月-107月
     */
    taishoM(3, 0),
    /**
     * 自己負担額
     */
    jikoFutanGaku(10, 0),
    /**
     * 70-74自己負担額（内数）
     */
    uchisu_70_74JikoFutanGaku(10, 0),
    /**
     * 70未満高額支給額
     */
    under_70KogakuShikyuGaku(10, 0),
    /**
     * 70-74高額支給額
     */
    over_70_74KogakuShikyuGaku(10, 0),
    /**
     * 摘要
     */
    tekiyo(20, 0),
    /**
     * 補正済・自己負担額
     */
    sumi_JikoFutanGaku(10, 0),
    /**
     * 補正済・70-74自己負担額（内数）
     */
    sumi_70_74JikoFutanGaku(10, 0),
    /**
     * 補正済・70未満高額支給額
     */
    sumi_under_70KogakuShikyuGaku(10, 0),
    /**
     * 補正済・70-74高額支給額
     */
    sumi_70_74KogakuShikyuGaku(10, 0),
    /**
     * 補正済・摘要
     */
    sumi_Tekiyo(20, 0);

    private final int maxLength;
    private final int scale;

    private DbT3171JigyoKogakuGassanJikoFutanGakuMeisai(int maxLength, int scale) {
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
