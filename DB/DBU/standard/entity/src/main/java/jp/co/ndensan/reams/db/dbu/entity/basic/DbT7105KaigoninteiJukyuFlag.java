package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護認定受給フラグテーブルの項目定義クラスです。
 */
public enum DbT7105KaigoninteiJukyuFlag implements IColumnDefinition {
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
     * 基本情報状況フラグ
     * <br/>0:無効　1:有効
     */
    kihonJokyoFlag(1, 0),
    /**
     * モバイルデータ出力フラグ
     * <br/>0:無し　1:有
     */
    mobileDataFlag(1, 0),
    /**
     * 認定情報提供希望有フラグ
     * <br/>0:無し　1:有
     */
    ninteiJohoTeikyoKiboAriFlag(1, 0),
    /**
     * 介護認定審査会審査順確定フラグ
     * <br/>0:不確定　1:確定
     */
    shinsakaiShinsajunKakuteiFlag(1, 0),
    /**
     * 合議体ダミーフラグ
     * <br/>0:正規　1:ダミー
     */
    gogitaiDummyFlag(1, 0),
    /**
     * 合議体精神科医存在フラグ
     * <br/>0:いない　1:いる
     */
    gogitaiSeishinkaiFlag(1, 0),
    /**
     * 介護認定審査会休会フラグ
     * <br/>0:開会　1:休会
     */
    shinsakaiKyukaiFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7105KaigoninteiJukyuFlag(int maxLength, int scale) {
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
