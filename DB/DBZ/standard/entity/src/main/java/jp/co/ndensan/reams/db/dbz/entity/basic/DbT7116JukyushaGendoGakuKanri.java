package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7116JukyushaGendoGakuKanriの項目定義クラスです
 *
 */
public enum DbT7116JukyushaGendoGakuKanri implements IColumnDefinition {
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
    shikibetsuKubun(1, 0),
    yukoKaishiYM(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    yukoShuryoYM(2147483647, 0),
    yoKaigoJotaiKubun(2, 0),
    kakudaiBaisu(3, 0),
    kiriwakeTaniSu(10, 0),
    torokuYMD(2147483647, 0),
    henkoYMD(2147483647, 0),
    gendoGakuKanriKikanSu(2, 0),
    shinTaikeiKanriKubun(1, 0),
    shinTaikeiKakudaiTekiyoUmu(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7116JukyushaGendoGakuKanri(int maxLength, int scale) {
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
