package jp.co.ndensan.reams.db.dbx.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * DbT7060KaigoJigyoshaの項目定義クラスです
 *
 */
@OnNextSchema("rgdb")
public enum DbT7060KaigoJigyosha implements IColumnDefinition {
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
    yukoShuryoYMD(2147483647, 0),
    idoYMD(2147483647, 0),
    idoJiyuCode(2, 0),
    jigyoKaishiYMD(2147483647, 0),
    jigyoKyushiYMD(2147483647, 0),
    jigyoSaikaiYMD(2147483647, 0),
    jigyoHaishiYMD(2147483647, 0),
    jigyoshaName(2147483647, 0),
    jigyoshaNameKana(2147483647, 0),
    yubinNo(2147483647, 0),
    jigyoshaAddress(2147483647, 0),
    jigyoshaKanaAddress(100, 0),
    telNo(2147483647, 0),
    faxNo(2147483647, 0),
    atesakiBusho(40, 0),
    atesakininName(2147483647, 0),
    atesakininNamekana(2147483647, 0),
    ginkoCode(2147483647, 0),
    shitenCode(2147483647, 0),
    kozaShubetsu(2147483647, 0),
    kozaNo(2147483647, 0),
    kozaMeiginin(2147483647, 0),
    kozaMeigininKana(2147483647, 0),
    shiteiKijungaitoJigyoshaKubun(2147483647, 0),
    shozaiShichoson(3, 0),
    serviceJisshiChiiki(30, 0),
    hojinShubetsu(2147483647, 0),
    bedSu(5, 0),
    shozokuNinzu(10, 0),
    riyoshaSu(10, 0),
    biko(30, 0);

    private final int maxLength;
    private final int scale;

    private DbT7060KaigoJigyosha(int maxLength, int scale) {
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
