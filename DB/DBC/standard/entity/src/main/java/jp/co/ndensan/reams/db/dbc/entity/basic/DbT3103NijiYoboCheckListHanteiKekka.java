package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 二次予防チェックリスト判定結果テーブルの項目定義クラスです。
 */
public enum DbT3103NijiYoboCheckListHanteiKekka implements IColumnDefinition {
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
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 受付年月日
     */
    uketsukeYMD(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 点数・生活機能全般
     */
    tensu_SeikatsuKinoZenpan(10, 0),
    /**
     * 点数・運動器機能
     */
    tensu_UndokiKino(10, 0),
    /**
     * 点数・栄養
     */
    tensu_Eiyo(10, 0),
    /**
     * 点数・口腔
     */
    tensu_Koku(10, 0),
    /**
     * 点数・閉じこもり
     */
    tensu_Tojikomori(10, 0),
    /**
     * 点数・認知能力
     */
    tensu_NinchiNoryoku(10, 0),
    /**
     * 点数・うつ
     */
    tensu_Utsu(10, 0),
    /**
     * 支援必要性・生活機能全般
     */
    shien_SeikatsuKinoZenpan(5, 0),
    /**
     * 支援必要性・運動器機能
     */
    shien_UndokiKino(5, 0),
    /**
     * 支援必要性・栄養
     */
    shien_Eiyo(5, 0),
    /**
     * 支援必要性・口腔
     */
    shien_Koku(5, 0),
    /**
     * 支援必要性・閉じこもり
     */
    shien_Tojikomori(5, 0),
    /**
     * 支援必要性・認知能力
     */
    shien_NinchiNoryoku(5, 0),
    /**
     * 支援必要性・うつ
     */
    shien_Utsu(5, 0),
    /**
     * 二次予防・主観的健康感
     */
    nijiYobo_ShukantekiKenkouKan(200, 0);

    private final int maxLength;
    private final int scale;

    private DbT3103NijiYoboCheckListHanteiKekka(int maxLength, int scale) {
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
