package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 市町村特別給付サービス事業者テーブルの項目定義クラスです。
 */
public enum DbT3065ShichosonTokubetsuKyufuJigyosha implements IColumnDefinition {
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
     * 市町村特別給付用事業者番号
     */
    jigyoshaNo(2147483647, 0),
    /**
     * 市町村特別給付用サービスコード
     */
    serviceCode(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 介護国保連ＩＦ異動区分
     */
    idoKubun(2, 0),
    /**
     * 介護国保連ＩＦ異動年月日
     */
    idoYMD(2147483647, 0),
    /**
     * 介護国保連ＩＦ法人種別
     */
    hojinShubetsu(2, 0),
    /**
     * 申請者氏名（漢字）
     */
    shinseishaNameKanji(30, 0),
    /**
     * 申請者氏名（カナ）
     */
    shinseishaNameKana(40, 0),
    /**
     * 申請者郵便番号
     */
    shinseishaYubinNo(2147483647, 0),
    /**
     * 申請者住所
     */
    shinseishaAddressKanji(60, 0),
    /**
     * 申請者住所（カナ）
     */
    shinseishaAddressKana(80, 0),
    /**
     * 申請者電話番号
     */
    shinseishaTelNo(14, 0),
    /**
     * 申請者FAX番号
     */
    shinseishaFaxNo(14, 0),
    /**
     * 事業所代表者役職
     */
    jigyoshoDaihyoshaYakushoku(20, 0),
    /**
     * 事業所代表者氏名
     */
    jigyoshoDaihyoshaNameKanji(40, 0),
    /**
     * 事業所代表者氏名カナ
     */
    jigyoshoDaihyoshaNameKana(40, 0),
    /**
     * 事業所代表者郵便番号
     */
    jigyoshoDaihyoshaYubinNo(2147483647, 0),
    /**
     * 事業所代表者住所
     */
    jigyoshoDaihyoshaAddressKanji(60, 0),
    /**
     * 事業所代表者住所カナ
     */
    jigyoshoDaihyoshaAddressKana(80, 0),
    /**
     * 事業所管理者氏名
     */
    jigyoshoKanrishaNameKanji(30, 0),
    /**
     * 事業所管理者氏名カナ
     */
    jigyoshoKanrishaNameKana(40, 0),
    /**
     * 事業所管理者郵便番号
     */
    jigyoshoKanrishaYubinNo(2147483647, 0),
    /**
     * 事業所管理者住所
     */
    jigyoshoKanrishaAddressKanji(60, 0),
    /**
     * 事業所管理者住所カナ
     */
    jigyoshoKanrishaAddressKana(80, 0),
    /**
     * サービス事業所名
     */
    serviceJigyoshoNameKanji(40, 0),
    /**
     * サービス事業所名カナ
     */
    serviceJigyoshoNameKana(40, 0),
    /**
     * サービス事業所郵便番号
     */
    serviceJigyoshoYubinNo(2147483647, 0),
    /**
     * サービス事業所住所
     */
    serviceJigyoshoAddressKanji(60, 0),
    /**
     * サービス事業所住所カナ
     */
    serviceJigyoshoAddressKana(80, 0),
    /**
     * サービス事業所電話番号
     */
    serviceJigyoshoTelNo(14, 0),
    /**
     * サービス事業所FAX番号
     */
    serviceJigyoshoFaxNo(14, 0),
    /**
     * サービス事業所事業開始年月日
     */
    serviceJigyoshoJigyoKaisiYMD(2147483647, 0),
    /**
     * サービス事業所事業休止年月日
     */
    serviceJigyoshoJigyoKyushiYMD(2147483647, 0),
    /**
     * サービス事業所事業廃止年月日
     */
    serviceJigyoshoJigyoHaishiYMD(2147483647, 0),
    /**
     * サービス事業所事業再開年月日
     */
    serviceJigyoshoJigyoSaikaiYMD(2147483647, 0),
    /**
     * 受領委任区分
     */
    juryoIninKubu(1, 0),
    /**
     * 市町村特別給付登録開始年月日
     */
    torokuKaishiYMD(2147483647, 0),
    /**
     * 市町村特別給付登録終了年月日
     */
    torokuShuryoYMD(2147483647, 0),
    /**
     * 生活保護法による指定の有
     */
    seikatsuhogoShiteiFlag(1, 0),
    /**
     * 論理削除フラグ
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3065ShichosonTokubetsuKyufuJigyosha(int maxLength, int scale) {
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
