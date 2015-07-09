package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護事業者テーブルの項目定義クラスです。
 * <br/> 介護事業者を管理する。
 */
public enum DbT7060KaigoJigyosha implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
     * 事業者番号
     */
    jigyoshaNo(2147483647, 0),
    /**
     * 有効開始日
     */
    yukoKaishiYMD(2147483647, 0),
    /**
     * 有効終了日
     */
    yukoShuryoYMD(2147483647, 0),
    /**
     * 異動日
     */
    idoYMD(2147483647, 0),
    /**
     * 異動事由
     */
    idoJiyuCode(2, 0),
    /**
     * 事業開始日
     */
    jigyoKaishiYMD(2147483647, 0),
    /**
     * 事業休止日
     */
    jigyoKyushiYMD(2147483647, 0),
    /**
     * 事業再開日
     */
    jigyoSaikaiYMD(2147483647, 0),
    /**
     * 事業廃止日
     */
    jigyoHaishiYMD(2147483647, 0),
    /**
     * 事業者名称
     */
    jigyoshaName(2147483647, 0),
    /**
     * 事業者名称カナ
     */
    jigyoshaNameKana(2147483647, 0),
    /**
     * 郵便番号
     */
    yubinNo(2147483647, 0),
    /**
     * 事業者住所
     */
    jigyoshaAddress(2147483647, 0),
    /**
     * 事業者住所カナ
     */
    jigyoshaKanaAddress(100, 0),
    /**
     * 電話番号
     */
    telNo(2147483647, 0),
    /**
     * FAX番号
     */
    faxNo(2147483647, 0),
    /**
     * 宛先部署
     */
    atesakiBusho(40, 0),
    /**
     * 宛先人名
     */
    atesakininName(2147483647, 0),
    /**
     * 宛先人名カナ
     */
    atesakininNamekana(2147483647, 0),
    /**
     * 銀行コード
     */
    ginkoCode(2147483647, 0),
    /**
     * 支店コード
     */
    shitenCode(2147483647, 0),
    /**
     * 口座種別
     */
    kozaShubetsu(2147483647, 0),
    /**
     * 口座番号
     */
    kozaNo(2147483647, 0),
    /**
     * 口座名義人
     */
    kozaMeiginin(2147483647, 0),
    /**
     * 口座名義人カナ
     */
    kozaMeigininKana(2147483647, 0),
    /**
     * 指定／基準該当等事業所区分
     */
    shiteiKijungaitoJigyoshaKubun(2147483647, 0),
    /**
     * 所在市町村
     */
    shozaiShichoson(3, 0),
    /**
     * サービス実施地域
     */
    serviceJisshiChiiki(30, 0),
    /**
     * 法人等種別
     */
    hojinShubetsu(2147483647, 0),
    /**
     * ベッド数
     */
    bedSu(5, 0),
    /**
     * 所属人数
     */
    shozokuNinzu(10, 0),
    /**
     * 利用者数
     */
    riyoshaSu(10, 0),
    /**
     * 備考
     */
    biko(30, 0);

    private final int maxLength;
    private final int scale;

    private DbT7060KaigoJigyosha(int maxLength, int scale) {
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
