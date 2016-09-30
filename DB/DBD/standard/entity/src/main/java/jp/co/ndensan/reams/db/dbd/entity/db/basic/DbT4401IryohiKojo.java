package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 医療費控除テーブルの項目定義クラスです。
 */
public enum DbT4401IryohiKojo implements IColumnDefinition {
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
     * 控除対象年
     */
    kojoTaishoNen(2147483647, 0),
    /**
     * データ区分
     * <br/>1：おむつ使用証明書発行、2：主治医意見書の確認書発行
     */
    dataKubun(1, 0),
    /**
     * 登録年月日
     */
    torokuYMD(2147483647, 0),
    /**
     * 申請年月日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 認定有効期間開始年月日
     */
    ninteiYukoKikanKaishiYMD(2147483647, 0),
    /**
     * 認定有効期間終了年月日
     */
    ninteiYukoKikanShuryoYMD(2147483647, 0),
    /**
     * 主治医意見書受領年月日
     */
    shujiiIkenshoJuryoYMD(2147483647, 0),
    /**
     * 日常生活自立度
     * <br/>1:「B1」、2:「B2」、3:「C1」、4:「C2」、5：以外を登録する
     */
    nichijoSeikatsuJiritsudo(2, 0),
    /**
     * 尿失禁の発生
     * <br/>True:有、False:無
     */
    nyoshikkinHassei(1, 0),
    /**
     * 発行年月日
     */
    hakkoYMD(2147483647, 0),
    /**
     * 論理削除フラグ
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT4401IryohiKojo(int maxLength, int scale) {
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
