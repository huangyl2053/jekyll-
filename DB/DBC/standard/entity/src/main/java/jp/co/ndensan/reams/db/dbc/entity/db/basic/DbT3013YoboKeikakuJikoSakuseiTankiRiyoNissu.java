package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 予防給付計画自己作成短期利用日数テーブルの項目定義クラスです。
 */
public enum DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissu implements IColumnDefinition {
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
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 対象年月
     */
    taishoYM(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 利用年月
     */
    riyoYM(2147483647, 0),
    /**
     * 前回迄利用日数
     */
    zenkaiRiyoNissu(3, 0),
    /**
     * 今回計画利用日数
     */
    konkaiKeikakuRiyoNissu(3, 0),
    /**
     * 暫定区分
     */
    zanteiKubun(1, 0),
    /**
     * 更新区分
     * <br/>DBC.Enum.給付管理表情報作成区分コード
     */
    koshinKubun(1, 0),
    /**
     * 更新年月日
     */
    koshinYMD(2147483647, 0),
    /**
     * 送付年月
     */
    sofuYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissu(int maxLength, int scale) {
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
