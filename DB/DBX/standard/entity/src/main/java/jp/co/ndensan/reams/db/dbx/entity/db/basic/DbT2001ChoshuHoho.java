package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護徴収方法テーブルの項目定義クラスです。
 */
public enum DbT2001ChoshuHoho implements IColumnDefinition {
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
     * 賦課年度
     */
    fukaNendo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 徴収方法4月
     */
    choshuHoho4gatsu(1, 0),
    /**
     * 徴収方法5月
     */
    choshuHoho5gatsu(1, 0),
    /**
     * 徴収方法6月
     */
    choshuHoho6gatsu(1, 0),
    /**
     * 徴収方法7月
     */
    choshuHoho7gatsu(1, 0),
    /**
     * 徴収方法8月
     */
    choshuHoho8gatsu(1, 0),
    /**
     * 徴収方法9月
     */
    choshuHoho9gatsu(1, 0),
    /**
     * 徴収方法10月
     */
    choshuHoho10gatsu(1, 0),
    /**
     * 徴収方法11月
     */
    choshuHoho11gatsu(1, 0),
    /**
     * 徴収方法12月
     */
    choshuHoho12gatsu(1, 0),
    /**
     * 徴収方法1月
     */
    choshuHoho1gatsu(1, 0),
    /**
     * 徴収方法2月
     */
    choshuHoho2gatsu(1, 0),
    /**
     * 徴収方法3月
     */
    choshuHoho3gatsu(1, 0),
    /**
     * 徴収方法翌4月
     */
    choshuHohoYoku4gatsu(1, 0),
    /**
     * 徴収方法翌5月
     */
    choshuHohoYoku5gatsu(1, 0),
    /**
     * 徴収方法翌6月
     */
    choshuHohoYoku6gatsu(1, 0),
    /**
     * 徴収方法翌7月
     */
    choshuHohoYoku7gatsu(1, 0),
    /**
     * 徴収方法翌8月
     */
    choshuHohoYoku8gatsu(1, 0),
    /**
     * 徴収方法翌9月
     */
    choshuHohoYoku9gatsu(1, 0),
    /**
     * 仮徴収・基礎年金番号
     */
    kariNenkinNo(10, 0),
    /**
     * 仮徴収・年金コード
     */
    kariNenkinCode(4, 0),
    /**
     * 仮徴収・捕捉月
     */
    kariHosokuM(2, 0),
    /**
     * 本徴収・基礎年金番号
     */
    honNenkinNo(10, 0),
    /**
     * 本徴収・年金コード
     */
    honNenkinCode(4, 0),
    /**
     * 本徴収・捕捉月
     */
    honHosokuM(2, 0),
    /**
     * 翌年度仮徴収・基礎年金番号
     */
    yokunendoKariNenkinNo(10, 0),
    /**
     * 翌年度仮徴収・年金コード
     */
    yokunendoKariNenkinCode(4, 0),
    /**
     * 翌年度仮徴収・捕捉月
     */
    yokunendoKariHosokuM(2, 0),
    /**
     * 依頼情報送付済みフラグ
     */
    iraiSohuzumiFlag(1, 0),
    /**
     * 追加依頼情報送付済みフラグ
     */
    tsuikaIraiSohuzumiFlag(1, 0),
    /**
     * 特別徴収停止日時
     */
    tokuchoTeishiNichiji(2147483647, 0),
    /**
     * 特別徴収停止事由コード
     */
    tokuchoTeishiJiyuCode(2, 0);

    private final int maxLength;
    private final int scale;

    private DbT2001ChoshuHoho(int maxLength, int scale) {
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
