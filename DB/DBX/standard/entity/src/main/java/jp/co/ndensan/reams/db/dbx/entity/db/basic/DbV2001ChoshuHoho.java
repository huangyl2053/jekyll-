package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 徴収方法Aliveテーブルの項目定義クラスです。
 */
public enum DbV2001ChoshuHoho implements IColumnDefinition {
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
     * fukaNendo
     */
    fukaNendo(2147483647, 0),
    /**
     * hihokenshaNo
     */
    hihokenshaNo(2147483647, 0),
    /**
     * rirekiNo
     */
    rirekiNo(5, 0),
    /**
     * choshuHoho4gatsu
     */
    choshuHoho4gatsu(1, 0),
    /**
     * choshuHoho5gatsu
     */
    choshuHoho5gatsu(1, 0),
    /**
     * choshuHoho6gatsu
     */
    choshuHoho6gatsu(1, 0),
    /**
     * choshuHoho7gatsu
     */
    choshuHoho7gatsu(1, 0),
    /**
     * choshuHoho8gatsu
     */
    choshuHoho8gatsu(1, 0),
    /**
     * choshuHoho9gatsu
     */
    choshuHoho9gatsu(1, 0),
    /**
     * choshuHoho10gatsu
     */
    choshuHoho10gatsu(1, 0),
    /**
     * choshuHoho11gatsu
     */
    choshuHoho11gatsu(1, 0),
    /**
     * choshuHoho12gatsu
     */
    choshuHoho12gatsu(1, 0),
    /**
     * choshuHoho1gatsu
     */
    choshuHoho1gatsu(1, 0),
    /**
     * choshuHoho2gatsu
     */
    choshuHoho2gatsu(1, 0),
    /**
     * choshuHoho3gatsu
     */
    choshuHoho3gatsu(1, 0),
    /**
     * choshuHohoYoku4gatsu
     */
    choshuHohoYoku4gatsu(1, 0),
    /**
     * choshuHohoYoku5gatsu
     */
    choshuHohoYoku5gatsu(1, 0),
    /**
     * choshuHohoYoku6gatsu
     */
    choshuHohoYoku6gatsu(1, 0),
    /**
     * choshuHohoYoku7gatsu
     */
    choshuHohoYoku7gatsu(1, 0),
    /**
     * choshuHohoYoku8gatsu
     */
    choshuHohoYoku8gatsu(1, 0),
    /**
     * choshuHohoYoku9gatsu
     */
    choshuHohoYoku9gatsu(1, 0),
    /**
     * kariNenkinNo
     */
    kariNenkinNo(10, 0),
    /**
     * kariNenkinCode
     */
    kariNenkinCode(4, 0),
    /**
     * kariHosokuM
     */
    kariHosokuM(2, 0),
    /**
     * honNenkinNo
     */
    honNenkinNo(10, 0),
    /**
     * honNenkinCode
     */
    honNenkinCode(4, 0),
    /**
     * honHosokuM
     */
    honHosokuM(2, 0),
    /**
     * yokunendoKariNenkinNo
     */
    yokunendoKariNenkinNo(10, 0),
    /**
     * yokunendoKariNenkinCode
     */
    yokunendoKariNenkinCode(4, 0),
    /**
     * yokunendoKariHosokuM
     */
    yokunendoKariHosokuM(2, 0),
    /**
     * iraiSohuzumiFlag
     */
    iraiSohuzumiFlag(1, 0),
    /**
     * tsuikaIraiSohuzumiFlag
     */
    tsuikaIraiSohuzumiFlag(1, 0),
    /**
     * tokuchoTeishiNichiji
     */
    tokuchoTeishiNichiji(2147483647, 0),
    /**
     * tokuchoTeishiJiyuCode
     */
    tokuchoTeishiJiyuCode(2, 0);

    private final int maxLength;
    private final int scale;

    private DbV2001ChoshuHoho(int maxLength, int scale) {
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
