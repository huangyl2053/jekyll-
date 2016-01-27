package jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護事業者代表者テーブルの項目定義クラスです。
 * <br/> 介護サービス事業者の代表者を管理します。
 */
public enum DbT7062KaigoJigyoshaDaihyosha implements IColumnDefinition {
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
     * 代表者名
     */
    daihyoshaShimei(2147483647, 0),
    /**
     * 代表者名カナ
     */
    daihyoshaKanaShimei(2147483647, 0),
    /**
     * 代表者郵便番号
     */
    daihyoshaYubinNo(2147483647, 0),
    /**
     * 代表者住所
     */
    daihyoshaJusho(2147483647, 0),
    /**
     * 代表者住所カナ
     */
    daihyoshaKanaJusho(100, 0),
    /**
     * 代表者役職名
     */
    daihyoshaYakushokuMei(40, 0),
    /**
     * 開設者名称
     */
    kaisetsushaShimei(2147483647, 0),
    /**
     * 開設者名称カナ
     */
    kaisetsushaKanaShimei(2147483647, 0),
    /**
     * 開設者郵便番号
     */
    kaisetsushaYubinNo(2147483647, 0),
    /**
     * 開設者住所
     */
    kaisetsushaJusho(2147483647, 0),
    /**
     * 開設者住所カナ
     */
    kaisetsushaKanaJusho(100, 0),
    /**
     * 開設者電話番号
     */
    kaisetsushaTelNo(2147483647, 0),
    /**
     * 開設者ＦＡＸ番号
     */
    kaisetsushaFaxNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7062KaigoJigyoshaDaihyosha(int maxLength, int scale) {
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
