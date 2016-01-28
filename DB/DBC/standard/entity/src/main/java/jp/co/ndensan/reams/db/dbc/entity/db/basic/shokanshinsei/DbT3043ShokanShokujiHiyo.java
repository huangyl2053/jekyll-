package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還払請求食事費用テーブルの項目定義クラスです。
 */
public enum DbT3043ShokanShokujiHiyo implements IColumnDefinition {
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
    hiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 整理番号
     */
    seiriNp(10, 0),
    /**
     * 事業者番号
     */
    jigyoshaNo(2147483647, 0),
    /**
     * 様式番号
     */
    yoshikiNo(4, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 基本提供日数
     */
    kihonTeikyoNissu(5, 0),
    /**
     * 基本提供単価
     */
    kihonTeikyoTanka(5, 0),
    /**
     * 基本提供金額
     */
    kihonTeikyoKingaku(10, 0),
    /**
     * 特別提供日数
     */
    tokubetsuTeikyoNissu(5, 0),
    /**
     * 特別提供単価
     */
    tokubetsuTeikyoTanka(5, 0),
    /**
     * 特別提供金額
     */
    tokubetsuTeikyoKingaku(10, 0),
    /**
     * 食事提供延べ日数
     */
    shokujiTeikyoTotalNissu(5, 0),
    /**
     * 食事提供費合計
     */
    shokujiTeikyohiTotal(10, 0),
    /**
     * 標準負担額（月額）
     */
    getsugakuHyojunFutangaku(10, 0),
    /**
     * 食事提供費請求額
     */
    shokujiTeikyohiSeikyugaku(10, 0),
    /**
     * 標準負担額（日額）
     */
    nichigakuHyojunFutangaku(5, 0),
    /**
     * 支給区分コード
     * <br/>支給・不支給決定情報
     */
    shikyuKubunCode(1, 0),
    /**
     * 点数／金額
     * <br/>支給・不支給決定情報
     */
    tensuKingaku(10, 0),
    /**
     * 支給金額
     * <br/>支給・不支給決定情報
     */
    shikyuKingaku(10, 0),
    /**
     * 増減点
     * <br/>支給・不支給決定情報
     */
    zougenTen(10, 0);

    private final int maxLength;
    private final int scale;

    private DbT3043ShokanShokujiHiyo(int maxLength, int scale) {
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
