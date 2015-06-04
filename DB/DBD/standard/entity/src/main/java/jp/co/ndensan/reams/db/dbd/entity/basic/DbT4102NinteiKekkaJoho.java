package jp.co.ndensan.reams.db.dbd.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定結果情報テーブルの項目定義クラスです。
 */
public enum DbT4102NinteiKekkaJoho implements IColumnDefinition {
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
     * <br/>要介護認定申請情報
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 二次判定年月日
     */
    nijiHanteiYMD(2147483647, 0),
    /**
     * 二次判定要介護状態区分コード
     * <br/>Enum（DBZ：要介護状態区分コード09）
     */
    nijiHanteiYokaigoJotaiKubunCode(2147483647, 0),
    /**
     * 二次判定認定有効期間
     */
    nijiHanteiNinteiYukoKikan(5, 0),
    /**
     * 二次判定認定有効開始年月日
     */
    nijiHanteiNinteiYukoKaishiYMD(2147483647, 0),
    /**
     * 二次判定認定有効終了年月日
     */
    nijiHanteiNinteiYukoShuryoYMD(2147483647, 0),
    /**
     * 介護認定審査会開催番号
     * <br/>介護認定審査会開催予定情報
     */
    shinsakaiKaisaiNo(5, 0),
    /**
     * 介護認定審査会意見
     */
    shinsakaiIken(2147483647, 0),
    /**
     * 一次判定結果変更理由
     */
    ichijiHnateiKekkaHenkoRiyu(2147483647, 0),
    /**
     * 要介護状態像例コード
     * <br/>Enum（DBE：要介護状態像例コード）要介護１の場合の状態像
     */
    yokaigoJotaizoReiCode(2147483647, 0),
    /**
     * 認定審査会意見種類
     * <br/>Enum（DBE：認定審査会意見種類）
     */
    ninteishinsakaiIkenShurui(1, 0),
    /**
     * 審査会メモ
     */
    shinsakaiMemo(2147483647, 0),
    /**
     * 二次判定結果入力方法
     * <br/>Enum（DBE：二次判定結果入力方法）1:画面入力、2:モバイル取込、3:ＯＣＲ取込
     */
    nijiHanteiKekkaInputHoho(2147483647, 0),
    /**
     * 二次判定結果入力年月日
     */
    niniHanteiKekkaInputYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT4102NinteiKekkaJoho(int maxLength, int scale) {
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
