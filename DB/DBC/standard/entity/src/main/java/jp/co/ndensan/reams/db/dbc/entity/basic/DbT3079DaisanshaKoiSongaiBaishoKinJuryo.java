package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護第三者行為損害賠償金受領テーブルの項目定義クラスです。
 */
public enum DbT3079DaisanshaKoiSongaiBaishoKinJuryo implements IColumnDefinition {
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
     * 第三者行為求償請求番号
     */
    kyushoSeikyuNo(10, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 入金確認年月日
     */
    nyukinKakuninYMD(2147483647, 0),
    /**
     * 領収年月日
     */
    ryoshuYMD(2147483647, 0),
    /**
     * 領収金額
     */
    ryoshuKingaku(9, 0),
    /**
     * 過不足金有無
     */
    mabusokuKinUMU(1, 0),
    /**
     * 過不足額
     */
    kabusokuGaku(9, 0);

    private final int maxLength;
    private final int scale;

    private DbT3079DaisanshaKoiSongaiBaishoKinJuryo(int maxLength, int scale) {
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
