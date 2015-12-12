package jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護事業者テーブルの項目定義クラスです。
 * <br/> 介護事業者を管理します。
 */
public enum DbT7060KaigoJigyosha implements IColumnDefinition {
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
     * <br/>＜Enumで管理＞
     * <br/>01：固定値
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
     * 指定／基準該当等事業所区分
     * <br/>共通コード＜サブ業務：DBZ、種別：0009＞
     * <br/>1:指定事業所
     * <br/>2:基準該当事業所
     * <br/>3:相当サービス事業所（地域密着型事業所も含む）
     * <br/>4:その他
     * <br/>5:地域密着型事業所
     * <br/>6:混在型事業所Ⅰ
     * <br/>7:混在型事業所Ⅱ
     * <br/>8:介護予防・日常生活支援総合事業事業所
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
     * <br/>共通コード＜サブ業務：DBZ、種別：0241＞
     * <br/>01:社会福祉法人（社協以外）
     * <br/>02:社会福祉法人（社協）
     * <br/>03:医療法人
     * <br/>04:民法法人（社団・財団）
     * <br/>05:営利法人
     * <br/>06:非営利法人（ＮＰＯ）
     * <br/>07:農協
     * <br/>08:生協
     * <br/>09:その他法人
     * <br/>10:地方公共団体（都道府県）
     * <br/>11:地方公共団体（市町村）
     * <br/>12:地方公共団体（広域連合・一部事務組合等）
     * <br/>13:非法人
     * <br/>99:その他
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
