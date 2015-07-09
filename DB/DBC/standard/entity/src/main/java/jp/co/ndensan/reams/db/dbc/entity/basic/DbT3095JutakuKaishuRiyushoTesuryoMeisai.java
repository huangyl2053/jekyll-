package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 住宅改修理由書作成手数料請求明細テーブルの項目定義クラスです。
 */
public enum DbT3095JutakuKaishuRiyushoTesuryoMeisai implements IColumnDefinition {
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
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * サービスコード
     */
    serviceCode(2147483647, 0),
    /**
     * 介護住宅改修事業者名称
     */
    jutakuKaishuJigyoshaMeisho(2147483647, 0),
    /**
     * 介護住宅改修着工年月日
     */
    jutakuKaishuChakkoYMD(2147483647, 0),
    /**
     * 介護住宅改修住宅所有者
     */
    jutakuKaishuJushoShozaisha(2147483647, 0),
    /**
     * 改修対象住宅住所
     */
    kaishuTaishoJutakuJusho(100, 0),
    /**
     * 改修内容・箇所及び規模
     */
    kaishuNaiyo_kasho_Kibo(500, 0),
    /**
     * 介護住宅改修理由書作成年月日
     */
    riyushoSakuseiYMD(2147483647, 0),
    /**
     * 介護住宅改修理由書作成事業者番号
     */
    riyushoSakuseiJigyoshaNo(2147483647, 0),
    /**
     * 介護住宅改修理由書作成者名
     */
    riyushoSakuseishaMei(2147483647, 0),
    /**
     * 介護住宅改修理由書作成者資格
     */
    riyushoSakuseishaShikaku(50, 0),
    /**
     * 介護住宅改修理由書作成申請年月日
     */
    riyushoSakuseiShinseiYMD(2147483647, 0),
    /**
     * 介護住宅改修理由書作成受付年月日
     */
    riyushoSakuseiUketsukeYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3095JutakuKaishuRiyushoTesuryoMeisai(int maxLength, int scale) {
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
