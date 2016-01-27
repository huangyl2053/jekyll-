package jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 給付実績食事費用テーブルの項目定義クラスです。
 */
public enum DbT3022KyufujissekiShokujiHiyo implements IColumnDefinition {
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
     * 交換情報識別番号
     */
    kokanJohoShikibetsuNo(2147483647, 0),
    /**
     * 入力識別番号
     */
    inputShikibetsuNo(2147483647, 0),
    /**
     * レコード種別コード
     */
    recodeShubetsuCode(2, 0),
    /**
     * 証記載保険者番号
     */
    shokisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 事業所番号
     */
    jigyoshoNo(2147483647, 0),
    /**
     * 通し番号
     */
    toshiNo(10, 0),
    /**
     * 基本・提供日数
     */
    kihonTeikyoNissu(5, 0),
    /**
     * 基本・提供単価
     */
    kihonTeikyoTanka(5, 0),
    /**
     * 基本・提供金額
     */
    kihonTeikyoKingaku(5, 0),
    /**
     * 特別・提供日数
     */
    tokubestuTeikyoNissu(5, 0),
    /**
     * 特別・提供単価
     */
    tokubestuTeikyoTanka(5, 0),
    /**
     * 特別・提供金額
     */
    tokubestuTeikyoKingaku(5, 0),
    /**
     * 食事提供延べ日数
     */
    syokujiTeikyoNissu(5, 0),
    /**
     * 公費１対象食事提供延べ日数
     */
    kohi1SyokujiTeikyoNissu(5, 0),
    /**
     * 公費２対象食事提供延べ日数
     */
    kohi2SyokujiTeikyoNissu(5, 0),
    /**
     * 公費３対象食事提供延べ日数
     */
    kohi3SyokujiTeikyoNissu(5, 0),
    /**
     * 食事提供費合計
     */
    syokujiTeikyohiTotal(5, 0),
    /**
     * 標準負担額（月額）
     */
    getsugakuHyojunFutanGaku(5, 0),
    /**
     * 食事提供費請求額
     */
    syokujiTeikyohiSeikyugaku(5, 0),
    /**
     * 公費１食事提供費請求額
     */
    kohi1SyokujiTeikyohiSeikyugaku(5, 0),
    /**
     * 公費２食事提供費請求額
     */
    kohi2SyokujiTeikyohiSeikyugaku(5, 0),
    /**
     * 公費３食事提供費請求額
     */
    kohi3SyokujiTeikyohiSeikyugaku(5, 0),
    /**
     * 標準負担額（日額）
     */
    nichigakuHyojunFutanGaku(5, 0),
    /**
     * 後・基本食提供費用提供単価
     */
    atoKihonTeikyoTanka(5, 0),
    /**
     * 後・特別食提供費用提供単価
     */
    atoTokubestuTeikyoTanka(5, 0),
    /**
     * 後・食事提供費請求額
     */
    atoSyokujiTeikyohiSeikyugaku(5, 0),
    /**
     * 再審査回数
     */
    saishinsaKaisu(5, 0),
    /**
     * 過誤回数
     */
    kagoKaisu(5, 0),
    /**
     * 審査年月
     */
    shinsaYM(2147483647, 0),
    /**
     * 整理番号
     */
    seiriNo(10, 0),
    /**
     * 取込年月
     */
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3022KyufujissekiShokujiHiyo(int maxLength, int scale) {
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
