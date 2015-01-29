package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT2001ChoshuHohoの項目定義クラスです
 *
 */
public enum DbT2001ChoshuHoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    fukaNendo(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    shoriTimestamp(29, 0),
    choshuHoho4gatsu(1, 0),
    choshuHoho5gatsu(1, 0),
    choshuHoho6gatsu(1, 0),
    choshuHoho7gatsu(1, 0),
    choshuHoho8gatsu(1, 0),
    choshuHoho9gatsu(1, 0),
    choshuHoho10gatsu(1, 0),
    choshuHoho11gatsu(1, 0),
    choshuHoho12gatsu(1, 0),
    choshuHoho1gatsu(1, 0),
    choshuHoho2gatsu(1, 0),
    choshuHoho3gatsu(1, 0),
    choshuHohoYoku4gatsu(1, 0),
    choshuHohoYoku5gatsu(1, 0),
    choshuHohoYoku6gatsu(1, 0),
    choshuHohoYoku7gatsu(1, 0),
    choshuHohoYoku8gatsu(1, 0),
    choshuHohoYoku9gatsu(1, 0),
    kariNenkinNo(10, 0),
    kariNenkinCode(4, 0),
    kariHosokuM(2, 0),
    honNenkinNo(10, 0),
    honNenkinCode(4, 0),
    honHosokuM(2, 0),
    yokunendoKariNenkinNo(10, 0),
    yokunendoKariNenkinCode(4, 0),
    yokunendoKariHosokuM(2, 0),
    iraiSohuzumiFlag(1, 0),
    tsuikaIraiSohuzumiFlag(1, 0),
    tokuchoTeishiTimestamp(2147483647, 0),
    tokuchoTeishiJiyuCode(2, 0);

    private final int maxLength;
    private final int scale;

    private DbT2001ChoshuHoho(int maxLength, int scale) {
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
