package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護第三者行為求償テーブルの項目定義クラスです。
 */
public enum DbT3082DaisanshaKoiKyusho implements IColumnDefinition {
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
     * 給付額合計
     */
    kyufuGakuGokei(9, 0),
    /**
     * 過失相殺額
     */
    kashitsuSosatsuGaku(9, 0),
    /**
     * 保険給付請求額
     */
    hokenKyufuSeikyuGaku(9, 0),
    /**
     * 損害賠償金納入期限
     */
    songaiBaishoKinNonyuYMD(2147483647, 0),
    /**
     * 請求先郵便番号
     */
    seikyusakiYubinNo(2147483647, 0),
    /**
     * 請求先住所
     */
    seikyusakiJusho(100, 0),
    /**
     * 請求先名称
     */
    seikyusakiMeisho(2147483647, 0),
    /**
     * 請求先部署
     */
    seikyusakiBusho(80, 0),
    /**
     * 請求先担当者
     */
    seikyusakiTantosha(2147483647, 0),
    /**
     * 請求先電話番号
     */
    seikyusakiTelNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3082DaisanshaKoiKyusho(int maxLength, int scale) {
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
