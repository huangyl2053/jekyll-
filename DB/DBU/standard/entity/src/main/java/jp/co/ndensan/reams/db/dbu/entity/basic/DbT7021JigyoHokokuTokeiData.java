package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 事業報告統計データテーブルの項目定義クラスです。
 */
public enum DbT7021JigyoHokokuTokeiData implements IColumnDefinition {
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
     * 報告年
     * <br/>年報時は、年度を設定
     */
    hokokuYSeireki(2147483647, 0),
    /**
     * 報告月
     * <br/>年報時は、「00」を設定
     */
    hokokuM(2, 0),
    /**
     * 集計対象年
     * <br/>年報時は、年度を設定
     */
    shukeiTaishoYSeireki(2147483647, 0),
    /**
     * 集計対象月
     * <br/>年報時は、「00」を設定
     */
    shukeiTaishoM(2, 0),
    /**
     * 統計対象区分
     * <br/>広域の場合、広域保険者か構成市町村か、 合併市町村の場合、新市町村か旧市町村か
     */
    toukeiTaishoKubun(1, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 表番号
     */
    hyoNo(2147483647, 0),
    /**
     * 集計番号
     */
    shukeiNo(2147483647, 0),
    /**
     * 集計単位
     */
    shukeiTani(2147483647, 0),
    /**
     * 縦番号
     */
    tateNo(4, 0),
    /**
     * 横番号
     */
    yokoNo(4, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 集計結果値
     */
    shukeiKekkaAtai(14, 0),
    /**
     * 縦項目コード
     */
    tateKomokuCode(2147483647, 0),
    /**
     * 横項目コード
     */
    yokoKomokuCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7021JigyoHokokuTokeiData(int maxLength, int scale) {
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
