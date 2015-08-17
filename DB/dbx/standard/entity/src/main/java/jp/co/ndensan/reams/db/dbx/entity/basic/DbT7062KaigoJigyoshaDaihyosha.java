package jp.co.ndensan.reams.db.dbx.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * DbT7062KaigoJigyoshaDaihyoshaの項目定義クラスです
 *
 */
@OnNextSchema("rgdb")
public enum DbT7062KaigoJigyoshaDaihyosha implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    jigyoshaNo(2147483647, 0),
    yukoKaishiYMD(2147483647, 0),
    daihyoshaShimei(2147483647, 0),
    daihyoshaKanaShimei(2147483647, 0),
    daihyoshaYubinNo(2147483647, 0),
    daihyoshaJusho(2147483647, 0),
    daihyoshaKanaJusho(100, 0),
    daihyoshaYakushokuMei(40, 0),
    kaisetsushaShimei(2147483647, 0),
    kaisetsushaKanaShimei(2147483647, 0),
    kaisetsushaYubinNo(2147483647, 0),
    kaisetsushaJusho(2147483647, 0),
    kaisetsushaKanaJusho(100, 0),
    kaisetsushaTelNo(2147483647, 0),
    kaisetsushaFaxNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7062KaigoJigyoshaDaihyosha(int maxLength, int scale) {
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
