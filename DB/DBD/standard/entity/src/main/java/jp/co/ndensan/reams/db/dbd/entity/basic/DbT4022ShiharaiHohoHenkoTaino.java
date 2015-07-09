package jp.co.ndensan.reams.db.dbd.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 支払方法変更滞納テーブルの項目定義クラスです。
 */
public enum DbT4022ShiharaiHohoHenkoTaino implements IColumnDefinition {
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
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 管理区分
     * <br/>1：２号差止,2：１号償還払化,3：１号給付額減額
     */
    kanriKubun(1, 0),
    /**
     * 滞納判定区分
     * <br/>1:予告登録,2:償還払化登録,3:差止登録,4:控除登録,5:給付額減額登録
     */
    tainoHanteiKubun(1, 0),
    /**
     * 調定年度
     */
    choteiNendo(2147483647, 0),
    /**
     * 賦課年度
     */
    fukaNendo(2147483647, 0),
    /**
     * 通知書番号
     */
    tsuchishoNo(2147483647, 0),
    /**
     * 特徴・普徴区分
     * <br/>1:特別徴収,2:普通徴収
     */
    Tokucho_fuchoKubun(1, 0),
    /**
     * 収納期・月
     */
    shuno_Ki_Tsuki(3, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 滞納判定年月日
     */
    tainoHanteiYMD(2147483647, 0),
    /**
     * 判定基準年月日
     * <br/>当日以前の基準年月日（当日：判定処理日は収入が確定していないため含まない）
     */
    hanteiKijunYMD(2147483647, 0),
    /**
     * 時効起算年月日
     */
    jikoKisanYMD(2147483647, 0),
    /**
     * 時効起算日区分
     * <br/>1:納期限翌日（収）,2:督促状発行日（収）,3:収入日（収）,4:債務者の債務の承認,5:差押,6:仮差押,7:仮処分,8:裁判上の請求等、被保険者に対する請求,9:不明（調定無し）（収）,A:その他,B:分納契約日（収）
     */
    jikoKisanKubun(1, 0),
    /**
     * 完納・未納区分
     * <br/>1:完納,2:過納,3:未納有り,4:未来納期,9:0円調定／0円収入
     */
    kanno_MinoKubun(1, 0),
    /**
     * 時効区分
     * <br/>1:時効未到来,2:時効到来
     */
    jikoKubun(1, 0),
    /**
     * 時効後収入区分
     * <br/>1:時効後収入有り
     */
    jikoAtoShunyuKubun(1, 0),
    /**
     * 対象管理区分
     */
    taishoKanriKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT4022ShiharaiHohoHenkoTaino(int maxLength, int scale) {
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
