package jp.co.ndensan.reams.db.dbx.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import jp.co.ndensan.reams.uz.uza.util.db.OnRshareSchema;

/**
 * DbT3057KogakuShikyuHanteiKekkaの項目定義クラスです
 *
 * @author 自動生成
 * @jpName 高額支給判定結果テーブル
 * @bizDomain 介護
 * @category 高額介護給付費
 * @subCategory
 * @mainClass
 * @reference
 * @author n8178 城間篤人
 * @jpName 高額支給判定結果テーブル
 * @bizDomain 介護
 * @category 高額介護給付費
 * @subCategory
 * @mainClass
 * @reference
 */
@OnRshareSchema
public enum DbT3057KogakuShikyuHanteiKekka implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    hihokenshaNo(10, 0),
    serviceTeikyoYM(2147483647, 0),
    shoKisaiHokenshaNo(6, 0),
    shoriTimestamp(29, 0),
    honninShiharaiGaku(6, 0),
    shiharaiKubunCode(1, 0),
    shiharaiKingaku(6, 0),
    shinsaKekkaHaneiKubun(1, 0);
    private final int maxLength;
    private final int scale;

    private DbT3057KogakuShikyuHanteiKekka(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }
// </editor-fold>
}
