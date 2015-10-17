package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 主治医意見書作成報酬実績情報テーブルの項目定義クラスです。
 */
public enum DbT5602ShujiiIkenshoHoshuJissekiJoho implements IColumnDefinition {
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
     * 主治医医療機関コード
     * <br/>主治医医療機関情報
     */
    shujiiIryoKikanCode(10, 0),
    /**
     * 主治医コード
     * <br/>主治医情報
     */
    shujiiCode(8, 0),
    /**
     * 申請書管理番号
     * <br/>要介護認定申請情報
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 主治医意見書作成依頼履歴番号
     * <br/>主治医意見書作成依頼情報
     */
    ikenshoIraiRirekiNo(5, 0),
    /**
     * 主治医意見書作成依頼年月日
     */
    iraishoSakuseiIraiYMD(2147483647, 0),
    /**
     * 主治医意見書記入年月日
     */
    ikenshoKinyuYMD(2147483647, 0),
    /**
     * 主治医意見書受領年月日
     */
    ikenshoJuryoYMD(2147483647, 0),
    /**
     * 医師区分コード
     * <br/>Enum（DBE：医師区分コード）
     */
    ishiKubunCode(2147483647, 0),
    /**
     * 主治医意見書作成料
     */
    ikenshoSakuseiryo(10, 0),
    /**
     * 主治医意見書別途診療費
     */
    ikenshoBettoShinryohi(10, 0),
    /**
     * 主治医意見書報酬
     */
    ikenshoHoshu(10, 0),
    /**
     * 主治医意見書報酬支払年月日
     */
    hoshuShiharaiYMD(2147483647, 0),
    /**
     * 主治医意見書報酬支払メモ
     */
    hoshuShiharaiMemo(2147483647, 0),
    /**
     * 銀行振込出力フラグ
     * <br/>Enum（DBE：銀行振込出力フラグ）
     */
    ginkoFurikomiShutsuryokuFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT5602ShujiiIkenshoHoshuJissekiJoho(int maxLength, int scale) {
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
