package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT4206GaikyoTokkiテーブルの項目定義クラスです。
 */
public enum DbT4206GaikyoTokki implements IColumnDefinition {
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
     * shinseishoKanriNo
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * ninteichosaRirekiNo
     */
    ninteichosaRirekiNo(5, 0),
    /**
     * gaikyoTokkiTextImageKubun
     */
    gaikyoTokkiTextImageKubun(1, 0),
    /**
     * jutakuKaishu
     */
    jutakuKaishu(2147483647, 0),
    /**
     * tokubetsuKyufuService
     */
    tokubetsuKyufuService(2147483647, 0),
    /**
     * zaitakuService
     */
    zaitakuService(2147483647, 0),
    /**
     * shuso
     */
    shuso(2147483647, 0),
    /**
     * kazokuJokyo
     */
    kazokuJokyo(2147483647, 0),
    /**
     * kyojuKankyo
     */
    kyojuKankyo(2147483647, 0),
    /**
     * kikaiKiki
     */
    kikaiKiki(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT4206GaikyoTokki(int maxLength, int scale) {
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
