package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 受領委任契約事業者テーブルの項目定義クラスです。
 */
public enum DbT3077JuryoininKeiyakuJigyosha implements IColumnDefinition {
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
     * 契約事業者番号
     * <br/>1からの連番付番
     */
    keiyakuJigyoshaNo(10, 0),
    /**
     * 開始年月日
     */
    kaishiYMD(2147483647, 0),
    /**
     * 終了年月日
     * <br/>未設定時は最大日付
     */
    shuryoYMD(2147483647, 0),
    /**
     * 契約種類
     * <br/>01：住宅改修、02：福祉用具、03：住宅改修／福祉用具、11：償還払給付、21：高額給付費
     */
    keiyakuShurui(2, 0),
    /**
     * 契約事業者名称
     */
    keiyakuJigyoshaName(2147483647, 0),
    /**
     * 契約事業者カナ名称
     */
    keiyakuJigyoshaKanaName(2147483647, 0),
    /**
     * 契約事業者郵便番号
     */
    keiyakuJigyoshaYubinNo(2147483647, 0),
    /**
     * 契約事業者住所
     */
    keiyakuJigyoshaJusho(2147483647, 0),
    /**
     * 契約代表者氏名
     */
    keiyakuDaihyoshaName(2147483647, 0),
    /**
     * 契約事業者電話番号
     */
    keiyakuJigyoshaTelNo(2147483647, 0),
    /**
     * 契約事業者FAX番号
     */
    keiyakuJigyoshaFaxNo(2147483647, 0),
    /**
     * 送付先郵便番号
     */
    sofusakiYubinNo(2147483647, 0),
    /**
     * 送付先住所
     */
    sofusakiJusho(2147483647, 0),
    /**
     * 送付先部署
     */
    sofusakiBusho(40, 0),
    /**
     * 送付先事業者名称
     */
    sofusakiJigyoshaName(2147483647, 0),
    /**
     * 送付先事業者カナ名称
     */
    sofusakiJigyoshaKanaName(2147483647, 0),
    /**
     * 金融機関コード
     */
    kinyuKikanCode(2147483647, 0),
    /**
     * 支店コード
     */
    shitenCode(2147483647, 0),
    /**
     * 口座種別
     */
    kozaShubetsu(1, 0),
    /**
     * 口座番号
     */
    kozaNo(10, 0),
    /**
     * 口座名義人
     */
    kozaMeiginin(2147483647, 0),
    /**
     * 口座名義人カナ
     */
    kozaMeigininKana(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3077JuryoininKeiyakuJigyosha(int maxLength, int scale) {
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
