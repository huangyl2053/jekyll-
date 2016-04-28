package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 支払方法変更テーブルの項目定義クラスです。
 */
public enum DbT4021ShiharaiHohoHenko implements IColumnDefinition {
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
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 管理区分
     * <br/>DBDEnum.支払方法変更管理区分 

     * <br/>1：２号差止 

     * <br/>2：１号償還払い化 

     * <br/>3：１号給付額減額
     */
    kanriKubun(1, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 登録区分
     * <br/>DBDEnum.支払方法変更登録区分 

     * <br/>01：２号予告登録者 

     * <br/>02：２号差止登録 

     * <br/>11：１号予告者登録 

     * <br/>12：１号償還払い化登録 

     * <br/>21：１号給付額減額登録
     */
    torokuKubun(2, 0),
    /**
     * 適用開始年月日
     */
    tekiyoKaishiYMD(2147483647, 0),
    /**
     * 適用終了年月日
     */
    tekiyoShuryoYMD(2147483647, 0),
    /**
     * 終了区分
     * <br/>DBDEnum.支払方法変更終了区分 

     * <br/>01：差止措置終了依頼書受理 

     * <br/>02：弁明書受理 

     * <br/>03：終了申請書受理 

     * <br/>04：減額免除申請書受理 

     * <br/>98：職権 

     * <br/>99：その他
     */
    shuryoKubun(2, 0),
    /**
     * 予告登録年月日
     */
    yokoku_TorokuYMD(2147483647, 0),
    /**
     * 差止依頼書受理年月日
     */
    sashitome_IraiJuriYMD(2147483647, 0),
    /**
     * 予告通知書発行年月日
     */
    yokoku_TsuchiHakkoYMD(2147483647, 0),
    /**
     * 予告通知書再発行フラグ
     * <br/>true：再発行対象, false：再発行対象外
     */
    yokoku_TsuchiSaiHakkoFlag(1, 0),
    /**
     * 弁明書提出期限
     */
    bemmei_TeishutsuYMD(2147483647, 0),
    /**
     * 弁明書受付年月日
     */
    bemmei_UketsukeYMD(2147483647, 0),
    /**
     * 弁明理由コード
     * <br/>DBDEnum.支払方法変更弁明理由コード 

     * <br/>01：公費負担医療の受給 

     * <br/>02：災害 

     * <br/>03：重大な障害または長期入院 

     * <br/>04：滞納保険料の減少 

     * <br/>05：保険料完納 

     * <br/>99：その他
     */
    bemmei_RiyuCode(2, 0),
    /**
     * 弁明審査決定年月日
     */
    bemmei_ShinsaKetteiYMD(2147483647, 0),
    /**
     * 弁明審査結果区分
     * <br/>DBDEnum.支払方法変更弁明審査結果区分 

     * <br/>1：申請受理 

     * <br/>2：申請却下
     */
    bemmei_ShinsaKekkaKubun(1, 0),
    /**
     * 償還払化決定年月日
     */
    shokan_KetteiYMD(2147483647, 0),
    /**
     * 償還払化通知書発行年月日
     */
    shokan_TsuchiHakkoYMD(2147483647, 0),
    /**
     * 償還払化通知書再発行フラグ
     * <br/>true：再発行対象, false：再発行対象外
     */
    shokan_TsuchiSaiHakkoFlag(1, 0),
    /**
     * 被保険者証提出期限
     */
    hihokenshaShoTeishutsuYMD(2147483647, 0),
    /**
     * 差止対象フラグ
     * <br/>true：差止対象, false：差止対象外
     */
    sashitome_Flag(1, 0),
    /**
     * 差止対象決定年月日
     */
    sashitome_KetteiYMD(2147483647, 0),
    /**
     * 差止対象解除年月日
     */
    sashitome_KaijoYMD(2147483647, 0),
    /**
     * 減額決定年月日
     */
    gemmen_KetteiYMD(2147483647, 0),
    /**
     * 減額通知書発行年月日
     */
    gemmen_TsuchiHakkoYMD(2147483647, 0),
    /**
     * 減額通知書再発行フラグ
     * <br/>true：再発行対象, false：再発行対象外
     */
    gemmen_TsuchiSaiHakkoFlag(1, 0),
    /**
     * 給付率
     * <br/>％で設定（70％の場合、070）
     */
    kyufuRitsu(2147483647, 0),
    /**
     * 終了申請書受付年月日
     */
    shuryoShinsei_UketsukeYMD(2147483647, 0),
    /**
     * 終了申請年月日
     */
    shuryoShinsei_YMD(2147483647, 0),
    /**
     * 終了申請理由コード
     * <br/>DBDEnum.支払方法変更終了申請理由コード 

     * <br/>01：公費負担医療の受給 

     * <br/>02：災害 

     * <br/>03：重大な障害または長期入院 

     * <br/>04：滞納保険料の減少 

     * <br/>99：その他 

     * <br/>（支払方法変更管理区分：2）

     * <br/>05：保険料完納 

     * <br/>06：特別な事情 

     * <br/>（支払方法変更管理区分：3）

     * <br/>98：職権
     */
    shuryoShinsei_RiyuCode(2, 0),
    /**
     * 終了申請審査決定年月日
     */
    shuryoShinsei_ShinsaKetteiYMD(2147483647, 0),
    /**
     * 終了申請審査結果区分
     * <br/>DBDEnum.支払方法変更終了申請審査結果区分 

     * <br/>1：申請受理 

     * <br/>2：申請却下
     */
    shuryoShinsei_ShinsaKekkaKubun(1, 0),
    /**
     * 無効区分
     * <br/>DBDEnum.支払方法変更無効区分 0:有効 1:無効
     */
    mukoKubun(1, 0),
    /**
     * 論理削除フラグ
     * <br/>true：論理削除
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT4021ShiharaiHohoHenko(int maxLength, int scale) {
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
