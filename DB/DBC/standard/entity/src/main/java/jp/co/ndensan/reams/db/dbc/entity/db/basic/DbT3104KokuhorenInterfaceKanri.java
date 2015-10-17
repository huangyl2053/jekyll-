package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 国保連インターフェース管理テーブルの項目定義クラスです。
 * <br/> 国保連インターフェース管理
 */
public enum DbT3104KokuhorenInterfaceKanri implements IColumnDefinition {
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
     * 処理年月
     */
    shoriYM(2147483647, 0),
    /**
     * 交換情報識別番号
     * <br/>交換情報識別番号の上3桁
     */
    kokanShikibetsuNo(3, 0),
    /**
     * 送付取込区分
     * <br/>1:送付 2:取込 3:それ以外
     */
    sofuTorikomiKubun(1, 0),
    /**
     * 処理状態区分
     * <br/>1:処理前 2:起動 3:終了 9:処理なし
     */
    shoriJotaiKubun(1, 0),
    /**
     * 処理実施日時
     */
    shoriJisshiTimestamp(2147483647, 0),
    /**
     * 抽出開始日時
     */
    chushutsuKaishiTimestamp(2147483647, 0),
    /**
     * 抽出終了日時
     */
    chushutsuShuryoTimestamp(2147483647, 0),
    /**
     * 再処理可能区分
     * <br/>True:再処理可能 False:再処理不可
     */
    saiShoriKahiKubun(1, 0),
    /**
     * 処理実行回数
     */
    shoriJikkoKaisu(3, 0),
    /**
     * ファイル名称１
     */
    fileName1(20, 0),
    /**
     * ファイル名称２
     */
    fileName2(20, 0),
    /**
     * ファイル名称３
     */
    fileName3(20, 0),
    /**
     * ファイル名称４
     */
    fileName4(20, 0),
    /**
     * ファイル名称５
     */
    fileName5(20, 0),
    /**
     * ファイル件数１
     */
    fileKensu1(10, 0),
    /**
     * ファイル件数２
     */
    fileKensu2(10, 0),
    /**
     * ファイル件数３
     */
    fileKensu3(10, 0),
    /**
     * ファイル件数４
     */
    fileKensu4(10, 0),
    /**
     * ファイル件数５
     */
    fileKensu5(10, 0),
    /**
     * 再処理設定不可区分
     * <br/>True:再処理設定不可 false:再処理設定可能
     */
    saiShoriFukaKubun(1, 0),
    /**
     * コントロール上レコード件数
     */
    ctrlRecordKensu(10, 0),
    /**
     * コントロール上処理年月
     */
    ctrlShoriYM(2147483647, 0),
    /**
     * 過誤コントロール上レコード件数
     */
    kagoCtrlRecordKensu(10, 0),
    /**
     * 過誤コントロール上処理年月
     */
    kagoCtrlShoriYM(2147483647, 0),
    /**
     * 実績データ上審査年月
     */
    jissekiDataShinsaYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3104KokuhorenInterfaceKanri(int maxLength, int scale) {
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
