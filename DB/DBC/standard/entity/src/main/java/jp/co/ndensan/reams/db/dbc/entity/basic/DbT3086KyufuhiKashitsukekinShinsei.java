package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 給付費貸付金申請テーブルの項目定義クラスです。
 */
public enum DbT3086KyufuhiKashitsukekinShinsei implements IColumnDefinition {
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
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 借入申請年月日
     */
    kariireShinseiYMD(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 申請者郵便番号
     */
    shinseishaYubinNo(2147483647, 0),
    /**
     * 申請者住所
     */
    shinseishaJusho(100, 0),
    /**
     * 申請者氏名カナ
     */
    shinseishaShimeiKana(2147483647, 0),
    /**
     * 申請者氏名
     */
    shinseishaShimei(2147483647, 0),
    /**
     * 申請者電話番号
     */
    shinseishaTelNo(2147483647, 0),
    /**
     * 申請者との関係
     * <br/>被保険者からの申請者との関係
     */
    shinseishaKankei(20, 0),
    /**
     * 借入利用期間開始年月日
     */
    kariireRiyoKaishiYMD(2147483647, 0),
    /**
     * 借入利用期間終了年月日
     */
    kariireRiyoShuryoYMD(2147483647, 0),
    /**
     * 貸付対象・高額介護サービス費等有無
     */
    kashitsuke_KogakuUmu(1, 0),
    /**
     * 貸付対象・住宅改修費等有無
     */
    kashitsuke_JutakuKaishuUmu(1, 0),
    /**
     * 貸付対象・福祉用具購入費等有無
     */
    kahitsuke_YoguKonyuUmu(1, 0),
    /**
     * 貸付対象・特例介護サービス費等有無
     */
    kashitsuke_TokureiServiceUmu(1, 0),
    /**
     * 保証人氏名カナ
     */
    hoshonin_ShimeiKana(2147483647, 0),
    /**
     * 保証人氏名
     */
    hoshonin_Shimei(2147483647, 0),
    /**
     * 保証人生年月日
     */
    hoshonin_UmareYMD(2147483647, 0),
    /**
     * 保証人性別
     */
    hoshinin_SeibetsuCd(2147483647, 0),
    /**
     * 保証人郵便番号
     */
    hoshonin_YubinNo(2147483647, 0),
    /**
     * 保証人住所
     */
    hoshonin_Jusho(100, 0),
    /**
     * 保証人電話番号
     */
    hoshonin_TelNo(2147483647, 0),
    /**
     * 借入申請者との関係
     * <br/>保証人からの申請者との関係
     */
    kariireShinseishaKankei(20, 0),
    /**
     * 保証人勤務先名称
     */
    hoshonin_KinmusakiMeisho(2147483647, 0),
    /**
     * 保証人勤務先郵便番号
     */
    hoshonin_KinmusakiYubinNo(2147483647, 0),
    /**
     * 保証人勤務先所在地
     */
    hoshonin_KinmusakiJusho(100, 0),
    /**
     * 保証人勤務先電話番号
     */
    hoshonin_KinmusakiTelNo(2147483647, 0),
    /**
     * 請求書・領収書の有無
     */
    seikyusho_RyoshushoUmu(1, 0),
    /**
     * 提出物管理番号
     */
    teishutsubutsuKanriNo(5, 0);

    private final int maxLength;
    private final int scale;

    private DbT3086KyufuhiKashitsukekinShinsei(int maxLength, int scale) {
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
