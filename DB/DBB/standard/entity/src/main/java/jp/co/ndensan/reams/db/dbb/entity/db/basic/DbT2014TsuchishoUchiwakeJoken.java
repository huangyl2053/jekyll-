package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 通知書打ち分け条件テーブルの項目定義クラスです。
 * <br/> 決定通知書・変更通知書を任意の条件で打ち分けする際の条件を保存するテーブル。
 */
public enum DbT2014TsuchishoUchiwakeJoken implements IColumnDefinition {
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
     * 打ち分け条件
     * <br/>任意で付けられた通知書を打ち分けるための条件の名称
     */
    uchiwakeJoken(128, 0),
    /**
     * 保存日時
     */
    hozonDateTime(2147483647, 0),
    /**
     * 賦課処理区分
     * <br/>0:本算定賦課、1:異動賦課
     */
    fukaShoriKubun(1, 0),
    /**
     * 選択通知書01
     * <br/>0:発行しない、1:決定通知書、2：変更通知書（以下同様）
     */
    selectTsuchisho01(1, 0),
    /**
     * 選択現金口座01
     * <br/>0:現金、1:口座、2:全て（以下同様）
     */
    selectGenkinKoza01(1, 0),
    /**
     * 出力順グループ名01
     */
    sortGroupName01(128, 0),
    /**
     * 選択通知書02
     */
    selectTsuchisho02(1, 0),
    /**
     * 選択現金口座02
     */
    selectGenkinKoza02(1, 0),
    /**
     * 出力順グループ名02
     */
    sortGroupName02(128, 0),
    /**
     * 選択通知書03
     */
    selectTsuchisho03(1, 0),
    /**
     * 選択現金口座03
     */
    selectGenkinKoza03(1, 0),
    /**
     * 出力順グループ名03
     */
    sortGroupName03(128, 0),
    /**
     * 選択通知書04
     */
    selectTsuchisho04(1, 0),
    /**
     * 選択現金口座04
     */
    selectGenkinKoza04(1, 0),
    /**
     * 出力順グループ名04
     */
    sortGroupName04(128, 0),
    /**
     * 選択通知書05
     */
    selectTsuchisho05(1, 0),
    /**
     * 選択現金口座05
     */
    selectGenkinKoza05(1, 0),
    /**
     * 出力順グループ名05
     */
    sortGroupName05(128, 0),
    /**
     * 選択通知書06
     */
    selectTsuchisho06(1, 0),
    /**
     * 選択現金口座06
     */
    selectGenkinKoza06(1, 0),
    /**
     * 出力順グループ名06
     */
    sortGroupName06(128, 0),
    /**
     * 選択通知書07
     */
    selectTsuchisho07(1, 0),
    /**
     * 選択現金口座07
     */
    selectGenkinKoza07(1, 0),
    /**
     * 出力順グループ名07
     */
    sortGroupName07(128, 0),
    /**
     * 選択通知書08
     */
    selectTsuchisho08(1, 0),
    /**
     * 選択現金口座08
     */
    selectGenkinKoza08(1, 0),
    /**
     * 出力順グループ名08
     */
    sortGroupName08(128, 0),
    /**
     * 選択通知書09
     */
    selectTsuchisho09(1, 0),
    /**
     * 選択現金口座09
     */
    selectGenkinKoza09(1, 0),
    /**
     * 出力順グループ名09
     */
    sortGroupName09(128, 0),
    /**
     * 選択通知書10
     */
    selectTsuchisho10(1, 0),
    /**
     * 選択現金口座10
     */
    selectGenkinKoza10(1, 0),
    /**
     * 出力順グループ名10
     */
    sortGroupName10(128, 0),
    /**
     * 選択通知書11
     */
    selectTsuchisho11(1, 0),
    /**
     * 選択現金口座11
     */
    selectGenkinKoza11(1, 0),
    /**
     * 出力順グループ名11
     */
    sortGroupName11(128, 0),
    /**
     * 選択通知書12
     */
    selectTsuchisho12(1, 0),
    /**
     * 選択現金口座12
     */
    selectGenkinKoza12(1, 0),
    /**
     * 出力順グループ名12
     */
    sortGroupName12(128, 0),
    /**
     * 選択通知書13
     */
    selectTsuchisho13(1, 0),
    /**
     * 選択現金口座13
     */
    selectGenkinKoza13(1, 0),
    /**
     * 出力順グループ名13
     */
    sortGroupName13(128, 0),
    /**
     * 選択通知書14
     */
    selectTsuchisho14(1, 0),
    /**
     * 選択現金口座14
     */
    selectGenkinKoza14(1, 0),
    /**
     * 出力順グループ名14
     */
    sortGroupName14(128, 0),
    /**
     * 選択通知書15
     */
    selectTsuchisho15(1, 0),
    /**
     * 選択現金口座15
     */
    selectGenkinKoza15(1, 0),
    /**
     * 出力順グループ名15
     */
    sortGroupName15(128, 0);

    private final int maxLength;
    private final int scale;

    private DbT2014TsuchishoUchiwakeJoken(int maxLength, int scale) {
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
