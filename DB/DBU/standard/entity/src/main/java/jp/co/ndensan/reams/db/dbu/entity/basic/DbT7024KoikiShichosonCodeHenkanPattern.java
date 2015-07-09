package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 広域市町村管理コード変換パターンテーブルの項目定義クラスです。
 */
public enum DbT7024KoikiShichosonCodeHenkanPattern implements IColumnDefinition {
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
     * 広域内市町村番号
     */
    koikiShichosonNo(2, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * コード区分
     * <br/>変換対象となるコードを表す
     */
    codeKubun(1, 0),
    /**
     * コード変換テーブル使用区分
     */
    codeHenkanTableShiyoUmu(1, 0),
    /**
     * 自動採番区分
     */
    jidoSaibanKubun(1, 0),
    /**
     * 市町村用コード桁数
     */
    shichosonCodeKetasu(5, 0),
    /**
     * 市町村用コード開始位置
     */
    shichosonCodeKaishiIchi(5, 0),
    /**
     * 市町村用コード使用桁数
     */
    shichosonCodeShiyoKetasu(5, 0),
    /**
     * 市町村用チェックディジット有無区分
     */
    shichosonNinshoNoUmu(1, 0),
    /**
     * 広域用コード桁数
     */
    koikiCodeKetasu(5, 0),
    /**
     * 広域用コード開始位置
     */
    koikiCodeKaishiIchi(5, 0),
    /**
     * 広域用コード使用桁数
     */
    koikiCodeShiyoKetasu(5, 0),
    /**
     * 広域用チェックディジット有無区分
     */
    koikiNinshoNoUmu(1, 0),
    /**
     * 広域内市町村番号付加区分
     */
    shichosonNoFukaKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7024KoikiShichosonCodeHenkanPattern(int maxLength, int scale) {
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
