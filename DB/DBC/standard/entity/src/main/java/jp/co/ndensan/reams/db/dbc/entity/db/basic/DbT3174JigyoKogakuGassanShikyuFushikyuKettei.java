package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 事業高額合算支給不支給決定テーブルの項目定義クラスです。
 */
public enum DbT3174JigyoKogakuGassanShikyuFushikyuKettei implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
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
     * 対象年度
     */
    taishoNendo(2147483647, 0),
    /**
     * 保険者番号
     */
    hokenshaNo(2147483647, 0),
    /**
     * 支給申請書整理番号
     * <br/>IF上は「連絡票整理番号」
     */
    shikyuSeiriNo(17, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 自己負担額証明書整理番号
     */
    jikoFutanSeiriNo(20, 0),
    /**
     * 保険制度コード
     */
    hokenSeidoCode(1, 0),
    /**
     * 国保 被保険者証記号
     */
    kokuho_HihokenshaShoKigo(20, 0),
    /**
     * 対象計算期間開始年月日
     */
    keisanKaishiYMD(2147483647, 0),
    /**
     * 対象計算期間終了年月日
     */
    keisanShuryoYMD(2147483647, 0),
    /**
     * 申請年月日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 決定年月日
     */
    ketteiYMD(2147483647, 0),
    /**
     * 自己負担総額
     */
    jikoFutanSogaku(10, 0),
    /**
     * 支給区分コード
     */
    shikyuKubunCode(1, 0),
    /**
     * 支給額
     */
    shikyugaku(10, 0),
    /**
     * 給付の種類
     */
    kyufuShurui(50, 0),
    /**
     * 不支給理由
     */
    fushikyuRiyu(100, 0),
    /**
     * 備考
     */
    biko(100, 0),
    /**
     * 支払方法区分
     */
    shiharaiHohoKubun(1, 0),
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
     * 支払期間開始時間
     */
    shiharaiKaishiTime(4, 0),
    /**
     * 支払期間終了時間
     */
    shiharaiShuryoTime(4, 0),
    /**
     * 決定通知書作成年月日
     */
    ketteiTsuchiSakuseiYMD(2147483647, 0),
    /**
     * 振込通知書作成年月日
     */
    furikomiTsuchiSakuseiYMD(2147483647, 0),
    /**
     * 受取年月
     */
    uketoriYM(2147483647, 0),
    /**
     * 口座ID
     */
    kozaid(19, 0),
    /**
     * データ作成区分
     */
    dataSakuseiKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3174JigyoKogakuGassanShikyuFushikyuKettei(int maxLength, int scale) {
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
