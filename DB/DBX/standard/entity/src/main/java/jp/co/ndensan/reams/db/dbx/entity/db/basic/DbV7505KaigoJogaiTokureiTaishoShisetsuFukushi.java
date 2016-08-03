package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護除外住所地特例対象施設・福祉Viewテーブルの項目定義クラスです。
 */
public enum DbV7505KaigoJogaiTokureiTaishoShisetsuFukushi implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    /**
     * jigyoshaShubetsu
     */
    jigyoshaShubetsu(2, 0),
    /**
     * jigyoshaNo
     */
    jigyoshaNo(10, 0),
    /**
     * yukoKaishiYMD
     */
    yukoKaishiYMD(2147483647, 0),
    /**
     * yukoShuryoYMD
     */
    yukoShuryoYMD(2147483647, 0),
    /**
     * kannaiKangaiKubun
     */
    kannaiKangaiKubun(1, 0),
    /**
     * jigyoshaMeisho
     */
    jigyoshaMeisho(2147483647, 0),
    /**
     * jigyoshaKanaMeisho
     */
    jigyoshaKanaMeisho(2147483647, 0),
    /**
     * yubinNo
     */
    yubinNo(2147483647, 0),
    /**
     * jigyoshaJusho
     */
    jigyoshaJusho(100, 0),
    /**
     * jigyoshaKanaJusho
     */
    jigyoshaKanaJusho(100, 0),
    /**
     * telNo
     */
    telNo(2147483647, 0),
    /**
     * faxNo
     */
    faxNo(2147483647, 0),
    /**
     * idoJiyuCode
     */
    idoJiyuCode(2, 0),
    /**
     * idoYMD
     */
    idoYMD(2147483647, 0),
    /**
     * daihyoshaMeisho
     */
    daihyoshaMeisho(2147483647, 0),
    /**
     * daihyoshaKanaMeisho
     */
    daihyoshaKanaMeisho(2147483647, 0),
    /**
     * yakushoku
     */
    yakushoku(40, 0),
    /**
     * biko
     */
    biko(200, 0),
    /**
     * jigyoKaishiYMD
     */
    jigyoKaishiYMD(2147483647, 0),
    /**
     * jigyoKyushiYMD
     */
    jigyoKyushiYMD(2147483647, 0),
    /**
     * jigyoHaishiYMD
     */
    jigyoHaishiYMD(2147483647, 0),
    /**
     * jigyoSaikaiYMD
     */
    jigyoSaikaiYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbV7505KaigoJogaiTokureiTaishoShisetsuFukushi(int maxLength, int scale) {
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
