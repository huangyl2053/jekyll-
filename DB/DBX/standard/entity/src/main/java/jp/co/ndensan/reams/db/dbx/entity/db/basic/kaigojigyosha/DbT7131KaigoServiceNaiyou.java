package jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * DbT7131KaigoServiceNaiyouの項目定義クラスです
 *
 * @author 自動生成
 * @jpName 介護サービス内容テーブル項目
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
@OnNextSchema("rgdb")
public enum DbT7131KaigoServiceNaiyou implements IColumnDefinition {
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
    serviceShuruiCode(2147483647, 0),
    /**
     * サービス項目コード
     */
    serviceKoumokuCode(4, 0),
    /**
     * 提供開始年月
     */
    teikyoKaishiYM(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(3, 0),
    /**
     * 提供終了年月
     */
    teikyoShuryoYM(2147483647, 0),
    /**
     * サービス名称
     */
    serviceName(60, 0),
    /**
     * サービス略称
     */
    serviceNameRyaku(30, 0),
    /**
     * 単位数
     */
    taniSu(10, 0),
    /**
     * 単位数識別
     * <br/>01：単位数
     * <br/>02：金額(円)
     * <br/>03：％値
     * <br/>04：きざみ基準単位
     * <br/>05：法定単位数なし
     * <br/>06：単位数(記載省略)
     * <br/>07：％値(記載省略)
     * <br/>08：1/1000値
     * <br/>09：1/1000値(記載省略)
     * <br/>13：％値：上限
     */
    tanisuShikibetsuCode(2147483647, 0),
    /**
     * 単位数算定単位
     * <br/>01:1回につき
     * <br/>02:1日につき
     * <br/>03:1月につき
     * <br/>04:算定単位無し
     * <br/>05:1週間につき
     */
    tanisuSanteiTani(2147483647, 0),
    /**
     * 異動事由
     * <br/>010：厚生省改定による 等
     */
    idouJiyuCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7131KaigoServiceNaiyou(int maxLength, int scale) {
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
