package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 受給者限度額管理テーブルの項目定義クラスです。
 */
public enum DbT7116JukyushaGendoGakuKanri implements IColumnDefinition {
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
     * 識別区分
     */
    shikibetsuKubun(1, 0),
    /**
     * 有効開始年月
     */
    yukoKaishiYM(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 有効終了年月
     */
    yukoShuryoYM(2147483647, 0),
    /**
     * 要介護状態区分
     */
    yoKaigoJotaiKubun(2, 0),
    /**
     * 拡大倍数
     */
    kakudaiBaisu(3, 0),
    /**
     * 切り分け単位数
     */
    kiriwakeTaniSu(10, 0),
    /**
     * 登録年月日
     */
    torokuYMD(2147483647, 0),
    /**
     * 変更年月日
     */
    henkoYMD(2147483647, 0),
    /**
     * 限度額管理期間数
     */
    gendoGakuKanriKikanSu(2, 0),
    /**
     * 新体系管理区分
     */
    shinTaikeiKanriKubun(1, 0),
    /**
     * 新体系拡大適用有無
     */
    shinTaikeiKakudaiTekiyoUmu(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7116JukyushaGendoGakuKanri(int maxLength, int scale) {
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
