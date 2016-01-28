package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 被保険者台帳管理テーブルの項目定義クラスです。
 * <br/> 介護保険被保険者の資格を管理する
 */
public enum DbT1001HihokenshaDaicho implements IColumnDefinition {
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
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 異動日
     */
    idoYMD(2147483647, 0),
    /**
     * 枝番
     */
    edaNo(4, 0),
    /**
     * 異動事由コード
     */
    idoJiyuCode(2, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 資格取得事由コード
     */
    shikakuShutokuJiyuCode(2, 0),
    /**
     * 資格取得年月日
     */
    shikakuShutokuYMD(2147483647, 0),
    /**
     * 資格取得届出年月日
     */
    shikakuShutokuTodokedeYMD(2147483647, 0),
    /**
     * 第1号資格取得年月日
     */
    ichigoShikakuShutokuYMD(2147483647, 0),
    /**
     * 被保険者区分コード
     * <br/>１号・２号
     */
    hihokennshaKubunCode(1, 0),
    /**
     * 資格喪失事由コード
     */
    shikakuSoshitsuJiyuCode(2, 0),
    /**
     * 資格喪失年月日
     */
    shikakuSoshitsuYMD(2147483647, 0),
    /**
     * 資格喪失届出年月日
     */
    shikakuSoshitsuTodokedeYMD(2147483647, 0),
    /**
     * 資格変更事由コード
     */
    shikakuHenkoJiyuCode(2, 0),
    /**
     * 資格変更年月日
     */
    shikakuHenkoYMD(2147483647, 0),
    /**
     * 資格変更届出年月日
     */
    shikakuHenkoTodokedeYMD(2147483647, 0),
    /**
     * 住所地特例適用事由コード
     */
    jushochitokureiTekiyoJiyuCode(2, 0),
    /**
     * 適用年月日
     */
    jushochitokureiTekiyoYMD(2147483647, 0),
    /**
     * 適用届出年月日
     */
    jushochitokureiTekiyoTodokedeYMD(2147483647, 0),
    /**
     * 住所地特例解除事由コード
     */
    jushochitokureiKaijoJiyuCode(2, 0),
    /**
     * 解除年月日
     */
    jushochitokureiKaijoYMD(2147483647, 0),
    /**
     * 解除届出年月日
     */
    jushochitokureiKaijoTodokedeYMD(2147483647, 0),
    /**
     * 住所地特例フラグ
     */
    jushochiTokureiFlag(1, 0),
    /**
     * 広域内住所地特例フラグ
     */
    koikinaiJushochiTokureiFlag(1, 0),
    /**
     * 広住特措置元市町村コード
     */
    koikinaiTokureiSochimotoShichosonCode(2147483647, 0),
    /**
     * 旧市町村コード
     * <br/>合併市町村の時は、旧市町村コードを設定
     */
    kyuShichosonCode(2147483647, 0),
    /**
     * 論理削除フラグ
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT1001HihokenshaDaicho(int maxLength, int scale) {
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
