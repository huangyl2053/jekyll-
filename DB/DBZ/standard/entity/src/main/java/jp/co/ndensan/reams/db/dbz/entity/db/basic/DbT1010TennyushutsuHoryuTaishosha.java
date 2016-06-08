package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT1010TennyushutsuHoryuTaishoshaの項目定義クラスです
 *
 */
public enum DbT1010TennyushutsuHoryuTaishosha implements IColumnDefinition {
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
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 作成事由コード
     */
    sakuseiJiyuCode(4, 0),
    /**
     * 世帯コード
     */
    setaiCode(2147483647, 0),
    /**
     * 住民種別コード
     */
    juminShubetsuCode(1, 0),
    /**
     * 住民状態コード
     */
    juminJotaiCode(1, 0),
    /**
     * 宛名氏名
     */
    atenaShimei(2147483647, 0),
    /**
     * 宛名カナ氏名
     */
    atenaKanaShimei(2147483647, 0),
    /**
     * 生年月日
     */
    seinengappiYMD(2147483647, 0),
    /**
     * 性別コード
     */
    seibetsuCode(1, 0),
    /**
     * 異動事由コード
     */
    idoJiyuCode(2, 0),
    /**
     * 登録異動年月日
     */
    torokuIdoYMD(2147483647, 0),
    /**
     * 登録届出年月日
     */
    torokuTodokedeYMD(2147483647, 0),
    /**
     * 消除異動年月日
     */
    shojoIdoYMD(2147483647, 0),
    /**
     * 消除届出年月日
     */
    shojoIdoTodokedeYMD(2147483647, 0),
    /**
     * 転出予定異動年月日
     */
    tenshutsuYoteiIdoYMD(2147483647, 0),
    /**
     * 転出確定異動年月日
     */
    tenshutsuKakuteiIdoYMD(2147483647, 0),
    /**
     * 転出確定異動通知年月日
     */
    tenshutsuKakuteiIdoTsuchiYMD(2147483647, 0),
    /**
     * 全国住所コード
     */
    zenkokuJushoCode(11, 0),
    /**
     * 住所
     */
    jusho(2147483647, 0),
    /**
     * 番地
     */
    banchi(2147483647, 0),
    /**
     * 方書
     */
    katagaki(2147483647, 0),
    /**
     * 前住所全国住所コード
     */
    maeJushoZenkokuJushoCode(2147483647, 0),
    /**
     * 前住所住所
     */
    maeJushoJusho(2147483647, 0),
    /**
     * 前住所番地
     */
    maeJushoBanchi(2147483647, 0),
    /**
     * 前住所方書
     */
    maeJushoKatagaki(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT1010TennyushutsuHoryuTaishosha(int maxLength, int scale) {
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
