package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査票（概況調査）09Aテーブルの項目定義クラスです。
 */
public enum DbT5202NinteichosahyoGaikyoChosa09A implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
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
     * 認定調査依頼履歴番号
     * <br/>認定調査依頼情報
     */
    ninteichosaRirekiNo(5, 0),
    /**
     * gaikyoChosaTextImageKubun
     */
    gaikyoChosaTextImageKubun(1, 0),
    /**
     * koroshoIfShikibetsuCode
     */
    koroshoIfShikibetsuCode(2147483647, 0),
    /**
     * ninteichousaIraiKubunCode
     */
    ninteichousaIraiKubunCode(2147483647, 0),
    /**
     * ninteichosaIraiKaisu
     */
    ninteichosaIraiKaisu(5, 0),
    /**
     * ninteichosaJisshiYMD
     */
    ninteichosaJisshiYMD(2147483647, 0),
    /**
     * ninteichosaJuryoYMD
     */
    ninteichosaJuryoYMD(2147483647, 0),
    /**
     * ninteiChosaKubunCode
     */
    ninteiChosaKubunCode(2147483647, 0),
    /**
     * chosaItakusakiCode
     */
    chosaItakusakiCode(2147483647, 0),
    /**
     * chosainCode
     */
    chosainCode(8, 0),
    /**
     * chosaJisshiBashoCode
     */
    chosaJisshiBashoCode(2147483647, 0),
    /**
     * chosaJisshiBashoMeisho
     */
    chosaJisshiBashoMeisho(64, 0),
    /**
     * serviceKubunCode
     */
    serviceKubunCode(2147483647, 0),
    /**
     * riyoShisetsuShimei
     */
    riyoShisetsuShimei(80, 0),
    /**
     * riyoShisetsuJusho
     */
    riyoShisetsuJusho(64, 0),
    /**
     * riyoShisetsuTelNo
     */
    riyoShisetsuTelNo(32, 0),
    /**
     * riyoShisetsuYubinNo
     */
    riyoShisetsuYubinNo(2147483647, 0),
    /**
     * tokki
     */
    tokki(2147483647, 0),
    /**
     * tokkijikoUketsukeYMD
     */
    tokkijikoUketsukeYMD(2147483647, 0),
    /**
     * tokkijikoJuryoYMD
     */
    tokkijikoJuryoYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5202NinteichosahyoGaikyoChosa09A(int maxLength, int scale) {
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
