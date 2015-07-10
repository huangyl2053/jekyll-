package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3103NijiYoboCheckListHanteiKekkaの項目定義クラスです
 *
 */
public enum DbT3103NijiYoboCheckListHanteiKekka implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shikibetsuCode(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    uketsukeYMD(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    tensu_SeikatsuKinoZenpan(10, 0),
    tensu_UndokiKino(10, 0),
    tensu_Eiyo(10, 0),
    tensu_Koku(10, 0),
    tensu_Tojikomori(10, 0),
    tensu_NinchiNoryoku(10, 0),
    tensu_Utsu(10, 0),
    shien_SeikatsuKinoZenpan(5, 0),
    shien_UndokiKino(5, 0),
    shien_Eiyo(5, 0),
    shien_Koku(5, 0),
    shien_Tojikomori(5, 0),
    shien_NinchiNoryoku(5, 0),
    shien_Utsu(5, 0),
    nijiYobo_ShukantekiKenkouKan(200, 0);

    private final int maxLength;
    private final int scale;

    private DbT3103NijiYoboCheckListHanteiKekka(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
