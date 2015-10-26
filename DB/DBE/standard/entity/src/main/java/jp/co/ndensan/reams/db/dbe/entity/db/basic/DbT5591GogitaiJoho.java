package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 合議体情報テーブルの項目定義クラスです。
 */
public enum DbT5591GogitaiJoho implements IColumnDefinition {
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
     * 合議体番号
     */
    gogitaiNo(5, 0),
    /**
     * 合議体名称
     */
    gogitaiMei(40, 0),
    /**
     * 合議体有効期間開始年月日
     */
    gogitaiYukoKikanKaishiYMD(2147483647, 0),
    /**
     * 合議体有効期間終了年月日
     */
    gogitaiYukoKikanShuryoYMD(2147483647, 0),
    /**
     * 合議体開始予定時刻
     */
    gogitaiKaishiYoteiTime(4, 0),
    /**
     * 合議体終了予定時刻
     */
    gogitaiShuryoYoteiTime(4, 0),
    /**
     * 介護認定審査会開催場所コード
     */
    shinsakaiKaisaiBashoCode(9, 0),
    /**
     * 介護認定審査会予定定員
     */
    shinsakaiYoteiTeiin(5, 0),
    /**
     * 介護認定審査会自動割当定員
     */
    shinsakaiJidoWariateTeiin(5, 0),
    /**
     * 介護認定審査会委員定員
     */
    shinsakaiIinTeiin(5, 0),
    /**
     * 合議体精神科医存在フラグ
     */
    gogitaiSeishinkaSonzaiFlag(1, 0),
    /**
     * 合議体ダミーフラグ
     */
    gogitaiDummyFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT5591GogitaiJoho(int maxLength, int scale) {
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
