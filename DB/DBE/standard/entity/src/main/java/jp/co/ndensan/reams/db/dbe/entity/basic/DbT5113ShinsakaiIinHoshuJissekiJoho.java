package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護認定審査会委員報酬実績情報テーブルの項目定義クラスです。
 */
public enum DbT5113ShinsakaiIinHoshuJissekiJoho implements IColumnDefinition {
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
     * 合議体番号
     */
    gogitaiNo(5, 0),
    /**
     * 介護認定審査会委員コード
     */
    shinsakaiIinCode(8, 0),
    /**
     * 介護認定審査会委員所属機関コード
     */
    shinsakaiIinShozokuKikanCode(2147483647, 0),
    /**
     * 介護認定審査会開催番号
     */
    shinsakaiKaisaiNo(5, 0),
    /**
     * 介護認定審査会開催年月日
     */
    shinsakaiKaisaiYMD(2147483647, 0),
    /**
     * 介護認定審査会開始時間
     */
    shinsakaiKaishiTime(4, 0),
    /**
     * 介護認定審査会終了時間
     */
    shinsakaiShuryoTime(4, 0),
    /**
     * 委員出席
     */
    isShusseki(1, 0),
    /**
     * 委員出席時間
     */
    shussekiTime(4, 0),
    /**
     * 委員退席時間
     */
    taisekiTime(4, 0),
    /**
     * 合議体長区分コード
     */
    gogitaichoKubunCode(2147483647, 0),
    /**
     * 介護認定審査会報酬税率
     */
    shinsakaiHoshuZeiritsu(5, 0),
    /**
     * 介護認定審査報酬
     */
    shinsakaiHoshu(10, 0),
    /**
     * 介護認定審査その他報酬
     */
    shinsakaiSonotaHoshu(10, 0),
    /**
     * 介護認定審査交通費等
     */
    shinsakaiKotsuhi(10, 0),
    /**
     * 介護認定審査控除税額
     */
    shinsakaiKojoZeigaku(10, 0),
    /**
     * 介護認定審査報酬合計
     */
    shinsakaiHoshuGokei(10, 0),
    /**
     * 介護認定審査報酬支払年月日
     */
    hoshuShiharaiYMD(2147483647, 0),
    /**
     * 介護認定審査報酬支払メモ
     */
    hoshushiharaiMemo(2147483647, 0),
    /**
     * 銀行振込出力済フラグ
     */
    isGinkoFurikomiShutsuryokuZumi(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT5113ShinsakaiIinHoshuJissekiJoho(int maxLength, int scale) {
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
