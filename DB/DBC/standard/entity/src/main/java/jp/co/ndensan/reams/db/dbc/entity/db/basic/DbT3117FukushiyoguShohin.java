package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 福祉用具商品テーブルの項目定義クラスです。
 */
@OnNextSchema("rgdb")
public enum DbT3117FukushiyoguShohin implements IColumnDefinition {
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
     * 商品番号
     */
    shohinNo(4, 0),
    /**
     * 管理開始年月日
     */
    kanriKaishiYMD(2147483647, 0),
    /**
     * 管理終了年月日
     */
    kanriShuryoYMD(2147483647, 0),
    /**
     * 商品名
     */
    shohinmei(20, 0),
    /**
     * 製造事業者名
     */
    seizoJigyoshamei(20, 0),
    /**
     * 品目コード
     */
    hinmokuCode(20, 0);

    private final int maxLength;
    private final int scale;

    private DbT3117FukushiyoguShohin(int maxLength, int scale) {
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
