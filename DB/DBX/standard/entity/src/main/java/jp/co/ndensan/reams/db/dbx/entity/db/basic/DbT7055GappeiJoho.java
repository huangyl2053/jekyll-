package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 合併情報テーブルの項目定義クラスです。
 */
public enum DbT7055GappeiJoho implements IColumnDefinition {
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
     * 合併年月日
     */
    gappeiYMD(2147483647, 0),
    /**
     * 地域番号
     */
    chiikiNo(2, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 合併種類
     * <br/>1:対等合併 2:吸収合併
     */
    gappeiShurui(1, 0),
    /**
     * 保険者番号
     */
    hokenshaNo(2147483647, 0),
    /**
     * 旧市町村情報付与終了年月日
     * <br/>旧市町村情報を合併日以降、いつまで管理するかを設定
     */
    kyuJohoFuyoToYMD(2147483647, 0),
    /**
     * 国保連データ連携開始年月日
     */
    kokuhorenDataFromYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7055GappeiJoho(int maxLength, int scale) {
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
