package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT1005KaigoJogai_TokureiTaishoShisetsuの項目定義クラスです
 *
 */
public enum DbT1005KaigoJogai_TokureiTaishoShisetsu implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    nyushoShisetsuShurui(2, 0),
    nyushoShisetsuCode(10, 0),
    shoriTimestamp(29, 0),
    yukoKaishiYMD(2147483647, 0),
    yukoShuryoYMD(2147483647, 0),
    shikibetsuCode(2147483647, 0),
    shisetsuRyakusho(40, 0),
    shisetsuKanaRyakusho(40, 0),
    shisetsuKanaJusho(100, 0),
    idoJiyuCode(2, 0),
    idoYMD(2147483647, 0),
    hojinShubetsuCode(2, 0),
    shisetsuKaishiYMD(2147483647, 0),
    shisetsuKyushiYMD(2147483647, 0),
    shisetsuHaishiYMD(2147483647, 0),
    shisetsuSaikaiYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT1005KaigoJogai_TokureiTaishoShisetsu(int maxLength, int scale) {
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
