package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 住宅改修理由書作成手数料請求集計テーブルの項目定義クラスです。
 */
public enum DbT3096JutakuKaishuRiyushoTesuryoShukei implements IColumnDefinition {
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
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 介護住宅改修理由書作成事業者番号
     */
    riyushoSakuseiJigyoshaNo(2147483647, 0),
    /**
     * 集計関連付け番号
     * <br/>連番
     */
    shukeiNo(6, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 集計開始年月
     */
    shukeiKaishiYM(2147483647, 0),
    /**
     * 集計終了年月
     */
    shukeiShuryoYM(2147483647, 0),
    /**
     * 介護住宅改修事業者名称
     */
    jutakuKaishuJigyoshaMeisho(2147483647, 0),
    /**
     * 介護住宅改修理由書作成件数
     */
    riyushoSakuseiKensu(4, 0),
    /**
     * 介護住宅改修理由書作成単価
     */
    riyushoSakuseiTanka(6, 0),
    /**
     * 介護住宅改修理由書作成請求金額
     */
    riyushoSakuseiSeikyuKingaku(9, 0),
    /**
     * 識別コード
     * <br/>住宅改修理由書作成事業者の法人口座取得用
     */
    shikibetsuNo(2147483647, 0),
    /**
     * 介護支払方法区分
     */
    shiharaiHohoKubun(1, 0),
    /**
     * 金融機関コード
     */
    kinyuKikanCode(2147483647, 0),
    /**
     * 支店コード
     */
    shitenCode(2147483647, 0),
    /**
     * 口座種別
     */
    kozaShubetsu(1, 0),
    /**
     * 口座番号
     */
    kozaNo(10, 0),
    /**
     * 口座名義人
     */
    kozaMeiginin(2147483647, 0),
    /**
     * 口座名義人カナ
     */
    kozaMeigininKana(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3096JutakuKaishuRiyushoTesuryoShukei(int maxLength, int scale) {
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
