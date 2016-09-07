package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護事業者・福祉Viewテーブルの項目定義クラスです。
 */
public enum DbV7516KaigoJigyoshaFukushi implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    /**
     * jigyoshaNo
     */
    jigyoshaNo(2147483647, 0),
    /**
     * yukoKaishiYMD
     */
    yukoKaishiYMD(2147483647, 0),
    /**
     * yukoShuryoYMD
     */
    yukoShuryoYMD(2147483647, 0),
    /**
     * idoYMD
     */
    idoYMD(2147483647, 0),
    /**
     * idoJiyuCode
     */
    idoJiyuCode(2, 0),
    /**
     * jigyoKaishiYMD
     */
    jigyoKaishiYMD(2147483647, 0),
    /**
     * jigyoKyushiYMD
     */
    jigyoKyushiYMD(2147483647, 0),
    /**
     * jigyoSaikaiYMD
     */
    jigyoSaikaiYMD(2147483647, 0),
    /**
     * jigyoHaishiYMD
     */
    jigyoHaishiYMD(2147483647, 0),
    /**
     * jigyoshaName
     */
    jigyoshaName(2147483647, 0),
    /**
     * jigyoshaNameKana
     */
    jigyoshaNameKana(2147483647, 0),
    /**
     * yubinNo
     */
    yubinNo(2147483647, 0),
    /**
     * jigyoshaAddress
     */
    jigyoshaAddress(2147483647, 0),
    /**
     * jigyoshaKanaAddress
     */
    jigyoshaKanaAddress(100, 0),
    /**
     * telNo
     */
    telNo(2147483647, 0),
    /**
     * faxNo
     */
    faxNo(2147483647, 0),
    /**
     * atesakiBusho
     */
    atesakiBusho(40, 0),
    /**
     * atesakininName
     */
    atesakininName(2147483647, 0),
    /**
     * atesakininNamekana
     */
    atesakininNamekana(2147483647, 0),
    /**
     * shiteiKijungaitoJigyoshaKubun
     */
    shiteiKijungaitoJigyoshaKubun(2147483647, 0),
    /**
     * shozaiShichoson
     */
    shozaiShichoson(3, 0),
    /**
     * serviceJisshiChiiki
     */
    serviceJisshiChiiki(30, 0),
    /**
     * hojinShubetsu
     */
    hojinShubetsu(2147483647, 0),
    /**
     * bedSu
     */
    bedSu(5, 0),
    /**
     * shozokuNinzu
     */
    shozokuNinzu(10, 0),
    /**
     * riyoshaSu
     */
    riyoshaSu(10, 0),
    /**
     * biko
     */
    biko(30, 0);

    private final int maxLength;
    private final int scale;

    private DbV7516KaigoJigyoshaFukushi(int maxLength, int scale) {
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
