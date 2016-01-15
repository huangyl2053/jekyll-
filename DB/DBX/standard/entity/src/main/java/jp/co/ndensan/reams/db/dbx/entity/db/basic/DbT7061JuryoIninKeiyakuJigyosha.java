package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 受領委任事業者テーブルの項目定義クラスです。
 * <br/> 受領委任契約をしている事業者を管理します。
 */
public enum DbT7061JuryoIninKeiyakuJigyosha implements IColumnDefinition {
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
     * 受領委任契約事業者番号
     */
    jigyoshaNo(2147483647, 0),
    /**
     * 受領委任契約開始日
     */
    keiyakuKaishiYMD(2147483647, 0),
    /**
     * 受領委任契約終了日
     */
    keiyakuShuryoYMD(2147483647, 0),
    /**
     * 契約サービス種別
     * <br/>＜Enumで管理＞

     * <br/>1：特定福祉用具販売事業者

     * <br/>2：住宅改修事業者

     * <br/>3：サービス提供事業者
     */
    serviceShubetsuCode(1, 0),
    /**
     * 契約事業者郵便番号
     */
    jigyoshaYubinNo(2147483647, 0),
    /**
     * 契約事業者住所
     */
    jigyoshaJusho(2147483647, 0),
    /**
     * 契約事業者電話番号
     */
    jigyoshaTelNo(2147483647, 0),
    /**
     * 契約事業者FAX番号
     */
    jigyoshaFaxNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7061JuryoIninKeiyakuJigyosha(int maxLength, int scale) {
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
