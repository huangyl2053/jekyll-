package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査依頼情報テーブルの項目定義クラスです。
 */
public enum DbT5201NinteichosaIraiJoho implements IColumnDefinition {
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
     * 申請書管理番号
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 認定調査依頼履歴番号
     */
    ninteichosaIraiRirekiNo(5, 0),
    /**
     * 厚労省IF識別コード
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）パーテショニングのCheck項目
     */
    koroshoIfShikibetsuCode(2147483647, 0),
    /**
     * 認定調査委託先コード
     * <br/>認定調査委託先情報
     */
    ninteichosaItakusakiCode(2147483647, 0),
    /**
     * 認定調査員コード
     * <br/>認定調査員情報
     */
    ninteiChosainCode(8, 0),
    /**
     * 認定調査依頼区分コード
     * <br/>Enum（DBE：認定調査依頼区分コード）初回・再依頼・再調査
     */
    ninteichosaIraiKubunCode(2147483647, 0),
    /**
     * 認定調査回数
     */
    ninteichosaIraiKaisu(5, 0),
    /**
     * 認定調査依頼年月日
     */
    ninteichosaIraiYMD(2147483647, 0),
    /**
     * 認定調査期限年月日
     */
    ninteichosaKigenYMD(2147483647, 0),
    /**
     * 依頼書出力年月日
     */
    iraishoShutsuryokuYMD(2147483647, 0),
    /**
     * 調査票等出力年月日
     */
    chosahyoTouShutsuryokuYMD(2147483647, 0),
    /**
     * モバイルデータ出力済フラグ
     * <br/>Enum（DBE：モバイルデータ出力フラグ）
     */
    mobileDataShutsuryokuZumiFlag(1, 0),
    /**
     * 事前調査フラグ
     * <br/>Enum（DBE：事前調査フラグ）
     */
    jizenChosaFlag(1, 0),
    /**
     * 認定調査督促年月日
     */
    ninteichosaTokusokuYMD(2147483647, 0),
    /**
     * 認定調査督促方法
     * <br/>Enum（DBE：認定調査督促方法）
     */
    ninteichosaTokusokuHoho(1, 0),
    /**
     * 認定調査督促回数
     */
    ninteichosaTokusokuKaisu(5, 0),
    /**
     * 認定調査督促メモ
     */
    ninteichosaTokusokuMemo(2147483647, 0),
    /**
     * 論理削除フラグ
     * <br/>True：削除　False：通常
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT5201NinteichosaIraiJoho(int maxLength, int scale) {
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
