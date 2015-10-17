package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護認定審査会委員報酬実績情報テーブルの項目定義クラスです。
 */
public enum DbT5603ShinsakaiIinHoshuJissekiJoho implements IColumnDefinition {
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
     * 介護認定審査会委員コード
     * <br/>介護認定審査会委員情報
     */
    shinsakaiIinCode(8, 0),
    /**
     * 審査会委員報酬区分
     * <br/>Enum（DBE：審査会委員報酬区分）1:審査報酬、2:その他報酬
     */
    shinsakaiIinHoshuKubun(2147483647, 0),
    /**
     * 実施年月日
     */
    shinsakaiKaisaiYMD(2147483647, 0),
    /**
     * 連番
     */
    remban(5, 0),
    /**
     * 介護認定審査会開催番号
     * <br/>介護認定審査会開催結果情報
     */
    shinsakaiKaisaiNo(5, 0),
    /**
     * 介護認定審査会報酬税率
     */
    shinsakaiHoshuZeiritsu(5, 0),
    /**
     * 介護認定審査報酬
     */
    shinsakaiHoshu(10, 0),
    /**
     * 介護認定審査その他報酬
     */
    shinsakaiSonotaHoshu(10, 0),
    /**
     * 介護認定審査交通費等
     */
    shinsakaiKotsuhi(10, 0),
    /**
     * 介護認定審査控除税額
     */
    shinsakaiKojoZeigaku(10, 0),
    /**
     * 介護認定審査報酬合計
     */
    shinsakaiHoshuGokei(10, 0),
    /**
     * 介護認定審査報酬支払年月日
     */
    hoshuShiharaiYMD(2147483647, 0),
    /**
     * 介護認定審査報酬支払メモ
     */
    hoshuShiharaiMemo(2147483647, 0),
    /**
     * 銀行振込出力フラグ
     * <br/>Enum（DBE：銀行振込出力フラグ）
     */
    ginkoFurikomiShutsuryokuFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT5603ShinsakaiIinHoshuJissekiJoho(int maxLength, int scale) {
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
