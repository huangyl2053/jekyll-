package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護認定審査会開催予定情報テーブルの項目定義クラスです。
 */
public enum DbT5501ShinsakaiKaisaiYoteiJoho implements IColumnDefinition {
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
     * 介護認定審査会開催番号
     */
    shinsakaiKaisaiNo(8, 0),
    /**
     * 介護認定審査会開催予定年月日
     */
    shinsakaiKaisaiYoteiYMD(2147483647, 0),
    /**
     * 介護認定審査会開始予定時刻
     */
    shinsakaiKaishiYoteiTime(4, 0),
    /**
     * 介護認定審査会終了予定時刻
     */
    shinsakaiShuryoYoteiTime(4, 0),
    /**
     * 介護認定審査会開催予定場所コード
     * <br/>介護認定審査会開催場所情報
     */
    shinsakaiKaisaiYoteiBashoCode(9, 0),
    /**
     * 合議体番号
     * <br/>合議体情報
     */
    gogitaiNo(5, 0),
    /**
     * 介護認定審査会予定定員
     */
    shinsakaiYoteiTeiin(5, 0),
    /**
     * 介護認定審査会最大定員
     */
    shinsakaiSaidaiTeiin(5, 0),
    /**
     * 介護認定審査会自動割当定員
     */
    shinsakaiJidoWariateTeiin(5, 0),
    /**
     * 介護認定審査会委員定員
     */
    shinsakaiIinTeiin(5, 0),
    /**
     * 介護認定審査会資料作成年月日
     */
    shinsakaiShiryoSakuseiYMD(2147483647, 0),
    /**
     * 介護認定審査会進捗状況
     * <br/>Enum（DBE：介護認定審査会進捗状況）1:未開催、2:中止、3:完了
     */
    ShinsakaiShinchokuJokyo(2147483647, 0),
    /**
     * 介護認定審査会割当済み人数
     */
    shinsakaiWariateZumiNinzu(5, 0),
    /**
     * 資料作成済フラグ
     * <br/>Enum（DBE：資料作成済区分）
     */
    shiryoSakuseiZumiFlag(1, 0),
    /**
     * モバイルデータ出力年月日
     */
    mobileDataOutputYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5501ShinsakaiKaisaiYoteiJoho(int maxLength, int scale) {
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
