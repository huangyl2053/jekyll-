package jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * DbT7130KaigoServiceShuruiテーブルの項目定義クラスです。
 */
@OnNextSchema("rgdb")
public enum DbT7130KaigoServiceShurui implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

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
     * サービス種類コード
     */
    serviceShuruiCd(2147483647, 0),
    /**
     * 提供開始年月
     */
    teikyoKaishiYM(2147483647, 0),
    /**
     * 提供終了年月
     */
    teikyoshuryoYM(2147483647, 0),
    /**
     * サービス種類名称
     */
    serviceShuruiMeisho(60, 0),
    /**
     * サービス種類略称
     */
    serviceShuruiRyakusho(30, 0),
    /**
     * サービス分類コード
     * <br/>01:居宅サービス
     * <br/>02:居宅介護支援
     * <br/>03:施設サービス
     * <br/>04:特定入所者介護サービス
     * <br/>05:介護予防サービス
     * <br/>06:介護予防支援
     * <br/>07:地域密着型サービス
     * <br/>08:地域密着型介護予防サービス
     * <br/>09:その他
     * <br/>10:総合事業
     * <br/>11:ケアマネジメント
     */
    serviceBunrruicode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7130KaigoServiceShurui(int maxLength, int scale) {
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
