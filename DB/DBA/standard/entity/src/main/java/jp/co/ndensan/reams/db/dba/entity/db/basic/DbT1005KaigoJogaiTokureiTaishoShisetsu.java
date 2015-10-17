package jp.co.ndensan.reams.db.dba.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護除外住所地特例対象施設テーブルの項目定義クラスです。
 */
public enum DbT1005KaigoJogaiTokureiTaishoShisetsu implements IColumnDefinition {
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
     * 事業者種別
     */
    jigyoshaShubetsu(2, 0),
    /**
     * 事業者番号
     */
    jigyoshaNo(10, 0),
    /**
     * 有効開始年月日
     */
    yukoKaishiYMD(2147483647, 0),
    /**
     * 有効終了年月日
     */
    yukoShuryoYMD(2147483647, 0),
    /**
     * 管内・管外区分
     * <br/>1:管内、2:管外
     */
    kannaiKangaiKubun(1, 0),
    /**
     * 事業者名称
     */
    jigyoshaMeisho(2147483647, 0),
    /**
     * 事業者名称カナ
     */
    jigyoshaKanaMeisho(2147483647, 0),
    /**
     * 郵便番号
     */
    yubinNo(2147483647, 0),
    /**
     * 事業者住所
     */
    jigyoshaJusho(100, 0),
    /**
     * 事業者住所カナ
     */
    jigyoshaKanaJusho(100, 0),
    /**
     * 電話番号
     */
    telNo(2147483647, 0),
    /**
     * FAX番号
     */
    faxNo(2147483647, 0),
    /**
     * 異動事由
     */
    idoJiyuCode(2, 0),
    /**
     * 異動年月日
     */
    idoYMD(2147483647, 0),
    /**
     * 代表者名称
     */
    daihyoshaMeisho(2147483647, 0),
    /**
     * 代表者名称カナ
     */
    daihyoshaKanaMeisho(2147483647, 0),
    /**
     * 役職
     */
    yakushoku(40, 0),
    /**
     * 備考
     */
    biko(200, 0),
    /**
     * 事業開始年月日
     */
    jigyoKaishiYMD(2147483647, 0),
    /**
     * 事業休止年月日
     */
    jigyoKyushiYMD(2147483647, 0),
    /**
     * 事業廃止年月日
     */
    jigyoHaishiYMD(2147483647, 0),
    /**
     * 事業再開年月日
     */
    jigyoSaikaiYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT1005KaigoJogaiTokureiTaishoShisetsu(int maxLength, int scale) {
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
