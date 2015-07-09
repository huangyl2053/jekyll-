package jp.co.ndensan.reams.db.dba.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 被保険者台帳管理テーブルの項目定義クラスです。
 * <br/> 介護保険被保険者の資格を管理する （介護被保険者台帳管理の親share）
 */
public enum DbT1001HihokenshaDaicho implements IColumnDefinition {
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
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(10, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
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
     * 住所地特例フラグ
     */
    jushochiTokureiFlag(1, 0);

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
