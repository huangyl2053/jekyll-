package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3086KyufuhiKashitsukekinShinseiの項目定義クラスです
 *
 */
public enum DbT3086KyufuhiKashitsukekinShinsei implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    kariireShinseiYMD(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    shinseishaYubinNo(2147483647, 0),
    shinseishaJusho(100, 0),
    shinseishaShimeiKana(2147483647, 0),
    shinseishaShimei(2147483647, 0),
    shinseishaTelNo(2147483647, 0),
    shinseishaKankei(20, 0),
    kariireRiyoKaishiYMD(2147483647, 0),
    kariireRiyoShuryoYMD(2147483647, 0),
    kashitsuke_KogakuUmu(1, 0),
    kashitsuke_JutakuKaishuUmu(1, 0),
    kahitsuke_YoguKonyuUmu(1, 0),
    kashitsuke_TokureiServiceUmu(1, 0),
    hoshonin_ShimeiKana(2147483647, 0),
    hoshonin_Shimei(2147483647, 0),
    hoshonin_UmareYMD(2147483647, 0),
    hoshinin_SeibetsuCd(2147483647, 0),
    hoshonin_YubinNo(2147483647, 0),
    hoshonin_Jusho(100, 0),
    hoshonin_TelNo(2147483647, 0),
    kariireShinseishaKankei(20, 0),
    hoshonin_KinmusakiMeisho(2147483647, 0),
    hoshonin_KinmusakiYubinNo(2147483647, 0),
    hoshonin_KinmusakiJusho(100, 0),
    hoshonin_KinmusakiTelNo(2147483647, 0),
    seikyusho_RyoshushoUmu(1, 0),
    teishutsubutsuKanriNo(5, 0);

    private final int maxLength;
    private final int scale;

    private DbT3086KyufuhiKashitsukekinShinsei(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
