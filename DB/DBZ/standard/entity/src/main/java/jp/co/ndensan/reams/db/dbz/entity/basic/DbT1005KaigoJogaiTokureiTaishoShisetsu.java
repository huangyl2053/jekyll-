package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT1005KaigoJogaiTokureiTaishoShisetsuの項目定義クラスです
 *
 */
public enum DbT1005KaigoJogaiTokureiTaishoShisetsu implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    jigyoshaShubetsu(2, 0),
    jigyoshaNo(10, 0),
    yukoKaishiYMD(2147483647, 0),
    yukoShuryoYMD(2147483647, 0),
    kannaiKangaiKubun(1, 0),
    jigyoshaMeisho(2147483647, 0),
    jigyoshaKanaMeisho(2147483647, 0),
    yubinNo(2147483647, 0),
    jigyoshaJusho(100, 0),
    jigyoshaKanaJusho(100, 0),
    telNo(2147483647, 0),
    faxNo(2147483647, 0),
    idoJiyuCode(2, 0),
    idoYMD(2147483647, 0),
    daihyoshaMeisho(2147483647, 0),
    daihyoshaKanaMeisho(2147483647, 0),
    yakushoku(40, 0),
    biko(200, 0),
    jigyoKaishiYMD(2147483647, 0),
    jigyoKyushiYMD(2147483647, 0),
    jigyoHaishiYMD(2147483647, 0),
    jigyoSaikaiYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT1005KaigoJogaiTokureiTaishoShisetsu(int maxLength, int scale) {
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
