package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護認定審査会委員所属機関情報テーブルの項目定義クラスです。
 */
public enum DbT5595KaigoNinteiShinsakaiIinShozokuKikanJoho implements IColumnDefinition {
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
     */
    shinsakaiIinCode(8, 0),
    /**
     * 連番
     */
    remban(10, 0),
    /**
     * 事業者区分
     */
    jigyoshaKubun(1, 0),
    /**
     * 所属開始年月日
     */
    shozokuKaishiYMD(2147483647, 0),
    /**
     * 所属終了年月日
     */
    shozokuShuryoYMD(2147483647, 0),
    /**
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 主治医医療機関コード
     * <br/>証記載保険者番号＋主治医医療機関コード
     */
    shujiiIryokikanCode(10, 0),
    /**
     * 主治医コード
     * <br/>証記載保険者番号＋主治医医療機関コード＋主治医コード
     */
    shujiiCode(8, 0),
    /**
     * 認定調査委託先コード
     * <br/>証記載保険者番号＋認定調査委託先コード
     */
    ninteichosaItakusakiCode(10, 0),
    /**
     * 認定調査員コード
     * <br/>証記載保険者番号＋認定調査委託先コード＋認定調査員コード
     */
    ninteiChosainNo(8, 0),
    /**
     * その他機関コード
     * <br/>証記載保険者番号＋その他機関コード
     */
    sonotaKikanCode(10, 0);

    private final int maxLength;
    private final int scale;

    private DbT5595KaigoNinteiShinsakaiIinShozokuKikanJoho(int maxLength, int scale) {
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
