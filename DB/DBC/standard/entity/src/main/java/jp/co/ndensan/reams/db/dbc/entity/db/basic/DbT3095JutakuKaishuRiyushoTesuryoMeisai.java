package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 住宅改修理由書作成手数料請求明細テーブルの項目定義クラスです。
 */
public enum DbT3095JutakuKaishuRiyushoTesuryoMeisai implements IColumnDefinition {
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
     * <br/>償還払請求住宅改修TBL.サービスコード
     */
    serviceCode(2147483647, 0),
    /**
     * 介護住宅改修事業者名称
     * <br/>償還払請求住宅改修TBL.住宅改修事業者名
     */
    jutakuKaishuJigyoshaMeisho(2147483647, 0),
    /**
     * 介護住宅改修着工年月日
     * <br/>償還払請求住宅改修TBL.住宅改修着工年月日
     */
    jutakuKaishuChakkoYMD(2147483647, 0),
    /**
     * 介護住宅改修住宅所有者
     * <br/>償還払支給申請TBL. 住宅所有者
     */
    jutakuKaishuJushoShozaisha(2147483647, 0),
    /**
     * 改修対象住宅住所
     * <br/>償還払請求住宅改修TBL.住宅改修住宅住所
     */
    kaishuTaishoJutakuJusho(64, 0),
    /**
     * 改修内容・箇所及び規模
     * <br/>償還払請求住宅改修TBL.住宅改修内容
     */
    kaishuNaiyo_kasho_Kibo(100, 0),
    /**
     * 介護住宅改修理由書作成年月日
     * <br/>償還払支給申請TBL. 理由書作成日
     */
    riyushoSakuseiYMD(2147483647, 0),
    /**
     * 介護住宅改修理由書作成事業者番号
     * <br/>償還払支給申請TBL. 理由書作成事業者番号
     */
    riyushoSakuseiJigyoshaNo(2147483647, 0),
    /**
     * 介護住宅改修理由書作成者名
     * <br/>償還払支給申請TBL. 理由書作成者
     */
    riyushoSakuseishaMei(2147483647, 0),
    /**
     * 介護住宅改修理由書作成者名カナ
     * <br/>償還払支給申請TBL. 理由書作成者カナ
     */
    riyushoSakuseishaMeiKana(40, 0),
    /**
     * 介護住宅改修理由書作成申請年月日
     * <br/>償還払支給申請TBL.申請年月日
     */
    riyushoSakuseiShinseiYMD(2147483647, 0),
    /**
     * 介護住宅改修理由書作成受付年月日
     * <br/>償還払支給申請TBL.受付年月日
     */
    riyushoSakuseiUketsukeYMD(2147483647, 0),
    /**
     * 集計関連付け番号
     * <br/>連番
     */
    shukeiNo(6, 0),
    /**
     * 対象外フラグ
     * <br/>True：対象外、False：対象
     */
    TaishogaiFlag(1, 0),
    /**
     * 集計フラグ
     * <br/>True：集計済み、False：集計未
     */
    shukeiFlag(1, 0);

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
