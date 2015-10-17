package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 主治医意見書作成依頼情報テーブルの項目定義クラスです。
 */
public enum DbT5301ShujiiIkenshoIraiJoho implements IColumnDefinition {
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
     * 申請書管理番号
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 主治医意見書作成依頼履歴番号
     */
    ikenshoIraiRirekiNo(5, 0),
    /**
     * 厚労省IF識別コード
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）パーティショニングのCheck項目
     */
    koroshoIfShikibetsuCode(2147483647, 0),
    /**
     * 主治医医療機関コード
     * <br/>主治医医療機関情報
     */
    shujiiIryokikanCode(10, 0),
    /**
     * 主治医コード
     * <br/>主治医情報
     */
    shujiiCode(8, 0),
    /**
     * 主治医意見書依頼区分
     * <br/>Enum（DBE：主治医意見書依頼区分）初回・再依頼・再意見書
     */
    ikenshoIraiKubun(1, 0),
    /**
     * 主治医意見書作成回数
     * <br/>主治医意見書を作成した回数（申請単位）
     */
    ikenshoIraiKaisu(5, 0),
    /**
     * 医師区分コード
     * <br/>Enum（DBE：医師区分コード）主治医・指定医
     */
    ishiKubunCode(2147483647, 0),
    /**
     * 主治医意見書作成依頼年月日
     */
    ikenshoSakuseiIraiYMD(2147483647, 0),
    /**
     * 主治医意見書作成期限年月日
     */
    ikenshoSakuseiKigenYMD(2147483647, 0),
    /**
     * 依頼書出力年月日
     */
    iraishoShutsuryokuYMD(2147483647, 0),
    /**
     * 意見書出力年月日
     */
    ikenshoShutsuryokuYMD(2147483647, 0),
    /**
     * 請求書出力年月日
     */
    seikyushoShutsuryokuYMD(2147483647, 0),
    /**
     * 作成料請求区分
     * <br/>Enum（DBE：作成料請求区分）
     */
    sakuseiryoSeikyuKubun(2147483647, 0),
    /**
     * 主治医意見書作成督促年月日
     */
    ikenshoSakuseiTokusokuYMD(2147483647, 0),
    /**
     * 主治医意見書作成督促方法
     * <br/>Enum（DBE：意見書作成督促方法）電話・ＦＡＸ・督促状
     */
    ikenshoSakuseiTokusokuHoho(1, 0),
    /**
     * 主治医意見書作成督促回数
     */
    ikenshoTokusokuKaisu(5, 0),
    /**
     * 主治医意見書作成督促メモ
     */
    ikenshoTokusokuMemo(2147483647, 0),
    /**
     * 認定情報提供希望フラグ
     * <br/>Enum（DBE：認定情報提供希望フラグ）
     */
    ninteiJohoTeikyoKiboFlag(1, 0),
    /**
     * 認定状況提供年月日
     */
    ninteiJohoTeikyoYMD(2147483647, 0),
    /**
     * 論理削除フラグ
     * <br/>True：削除　False：通常
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT5301ShujiiIkenshoIraiJoho(int maxLength, int scale) {
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
