package jp.co.ndensan.reams.db.dbc.entity.db.basic.kogakushinsei;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 高額介護サービス費支給申請テーブルの項目定義クラスです。
 */
public enum DbT3056KogakuShikyuShinsei implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">
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
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 受付年月日
     */
    uketsukeYMD(2147483647, 0),
    /**
     * 申請年月日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 申請理由
     */
    shinseiRiyu(100, 0),
    /**
     * 申請者区分
     * <br/>1:本人,2:代理人,3:受領委任事業者
     */
    shinseishaKubun(1, 0),
    /**
     * 申請者氏名
     * <br/>申請者区分が”3”の場合、設定不要
     */
    shinseishaShimei(2147483647, 0),
    /**
     * 申請者氏名カナ
     * <br/>申請者区分が”3”の場合、設定不要
     */
    shinseishaShimeiKana(2147483647, 0),
    /**
     * 申請者住所
     * <br/>申請者区分が”3”の場合、設定不要
     */
    shinseishaJusho(100, 0),
    /**
     * 申請者電話番号
     * <br/>申請者区分が”3”の場合、設定不要
     */
    shinseishaTelNo(2147483647, 0),
    /**
     * 申請事業者番号
     * <br/>申請者区分が”3”の場合のみ、設定
     */
    shinseiJigyoshaNo(2147483647, 0),
    /**
     * 支払方法区分コード
     */
    shiharaiHohoKubunCode(1, 0),
    /**
     * 支払場所
     */
    shiharaiBasho(64, 0),
    /**
     * 支払期間開始年月日
     */
    shiharaiKaishiYMD(2147483647, 0),
    /**
     * 支払期間終了年月日
     */
    shiharaiShuryoYMD(2147483647, 0),
    /**
     * 閉庁内容
     */
    heichoNaiyo(50, 0),
    /**
     * 支払窓口開始時間
     */
    shiharaiKaishiTime(4, 0),
    /**
     * 支払窓口終了時間
     */
    shiharaiShuryoTime(4, 0),
    /**
     * 口座ID
     * <br/>口座テーブルとのリンクキー
     */
    kozaID(19, 0),
    /**
     * 受領委任契約番号
     */
    juryoininKeiyakuNo(8, 0);

    private final int maxLength;
    private final int scale;

    private DbT3056KogakuShikyuShinsei(int maxLength, int scale) {
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
