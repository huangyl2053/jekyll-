package jp.co.ndensan.reams.db.dbx.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * DbT7064CareManegerの項目定義クラスです
 *
 * @author 自動生成
 * @jpName DbT7064介護支援専門員
 * @bizDomain 介護
 * @category ケアマネージャ
 * @subCategory
 * @mainClass
 * @reference
 */
@OnNextSchema("rgdb")
public enum DbT7064CareManeger implements IColumnDefinition {
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
     * 介護支援専門員番号
     */
    kaigoShienSenmoninNo(8, 0),
    /**
     * 介護支援専門員名
     */
    kaigoShienSenmoninMei(2147483647, 0),
    /**
     * 介護支援専門員名カナ
     */
    kaigoShienSenmoninMeiKana(2147483647, 0),
    /**
     * 所属事業者番号
     */
    shozokuJigyoshaNo(2147483647, 0),
    /**
     * 有効開始年月日
     */
    yukoKaishiDate(2147483647, 0),
    /**
     * 有効終了年月日
     */
    yukoShuryoDate(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7064CareManeger(int maxLength, int scale) {
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
