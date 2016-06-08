package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護第三者行為示談テーブルの項目定義クラスです。
 */
public enum DbT3080DaisanshaKoiJidan implements IColumnDefinition {
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
     * 第三者行為届出管理番号
     */
    todokedeKanriNo(10, 0),
    /**
     * 示談報告書受付年月日
     */
    jidanHokokushoUketukeYMD(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 第三者行為求償協議区分
     */
    kyushoKyogiKubun(1, 0),
    /**
     * 示談報告書提出年月日
     */
    jidanHokokushoTeishutsuYMD(2147483647, 0),
    /**
     * 示談成立年月日
     */
    jidanSeiritsuYMD(2147483647, 0),
    /**
     * 給付期間開始年月
     */
    kyufuKaishiYMD(2147483647, 0),
    /**
     * 給付期間終了年月
     */
    kyufuShuryoYMD(2147483647, 0),
    /**
     * 過失割合・加害者
     */
    kashitsuWariai_Kagaisha(3, 0),
    /**
     * 過失割合・被害者
     */
    kashitsuWariai_Higaisha(3, 0);

    private final int maxLength;
    private final int scale;

    private DbT3080DaisanshaKoiJidan(int maxLength, int scale) {
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
