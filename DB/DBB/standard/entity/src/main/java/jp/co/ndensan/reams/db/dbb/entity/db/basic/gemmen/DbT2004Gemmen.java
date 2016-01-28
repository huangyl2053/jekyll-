package jp.co.ndensan.reams.db.dbb.entity.db.basic.gemmen;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護賦課減免テーブルの項目定義クラスです。
 */
public enum DbT2004Gemmen implements IColumnDefinition {
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
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 減免申請日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 減免決定日
     */
    ketteiYMD(2147483647, 0),
    /**
     * 減免取消日
     */
    torikeshiYMD(2147483647, 0),
    /**
     * 減免状態区分
     * <br/>0:申請　1:決定(承認)　2:決定(不承認)　3:取消　9:論理削除
     */
    jotaiKubun(1, 0),
    /**
     * 減免作成区分
     * <br/>0:申請　1:決定(承認)　2:決定(不承認)　3:取消　4:訂正　9:論理削除
     */
    sakuseiKubun(1, 0),
    /**
     * 申請事由
     */
    shinseiJiyu(2147483647, 0),
    /**
     * 減免種類コード
     */
    gemmenJiyuCode(2147483647, 0),
    /**
     * 減免事由
     */
    gemmenJiyu(2147483647, 0),
    /**
     * 減免取消種類コード
     */
    gemmenTorikeshiJiyuCode(2147483647, 0),
    /**
     * 減免取消事由
     */
    gemmenTorikeshiJiyu(2147483647, 0),
    /**
     * 申請減免額
     */
    shinseiGemmenGaku(131089, 0),
    /**
     * 決定減免額
     */
    ketteiGemmenGaku(131089, 0),
    /**
     * 取消減免額
     */
    torikeshiGemmenGaku(131089, 0);

    private final int maxLength;
    private final int scale;

    private DbT2004Gemmen(int maxLength, int scale) {
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
