package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護サービス種類テーブルの項目定義クラスです。
 * <br/> 介護サービス種類を管理します
 */
public enum DbT7130KaigoServiceShurui implements IColumnDefinition {
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
     * サービス種類コード
     */
    serviceShuruiCd(2147483647, 0),
    /**
     * 提供開始年月
     */
    teikyoKaishiYM(2147483647, 0),
    /**
     * 提供終了年月
     */
    teikyoshuryoYM(2147483647, 0),
    /**
     * サービス種類名称
     */
    serviceShuruiMeisho(60, 0),
    /**
     * サービス種類略称
     */
    serviceShuruiRyakusho(30, 0),
    /**
     * サービス分類コード
     * <br/>共通コード＜サブ業務：DBZ、種別：0020＞
     */
    serviceBunrruicode(2147483647, 0),
    /**
     * サービス種類内部コード
     */
    serviceShuruiNaibuCd(2147483647, 0),
    /**
     * 限度額区分
     * <br/>1：種類支給限度額認定可能対象、0：種類支給限度額認定可能対象外
     */
    gendogakuKubun(1, 0),
    /**
     * 優先順位
     */
    yusenJuni(2, 0),
    /**
     * 居宅サービス区分
     * <br/>0：区分支給限度額対象外、1：訪問通所系区分限度額対象、2：短期入所系区分限度額対象
     */
    kyotakuServiceKubun(1, 0),
    /**
     * 指定サービス区分
     * <br/>1：事業所指定対象サービス該当、0：事業所指定対象サービス非該当
     */
    shiteiServiceKubun(1, 0),
    /**
     * 基準該当サービス区分
     * <br/>1：基準該当対象サービス該当、0：基準該当対象サービス非該当
     */
    kijunGaitoServiceKubun(1, 0),
    /**
     * みなし区分
     * <br/>1:（地域密着型サービスの）みなし指定、0:みなし指定なし
     */
    minashiKubun(1, 0),
    /**
     * 画面表示区分
     * <br/>0:表示しない、1:表示する
     */
    gamenHyojiKubun(1, 0),
    /**
     * 要支援１入力可否区分
     * <br/>1：入力可、0：入力不可
     */
    shien1InKahiKubun(1, 0),
    /**
     * 要支援２入力可否区分
     * <br/>1：入力可、0：入力不可
     */
    shien2InKahiKubun(1, 0),
    /**
     * 二次予防入力可否区分
     * <br/>1：入力可、0：入力不可
     */
    nijiyoboInKahiKubun(1, 0),
    /**
     * サービス小分類
     * <br/>0：みなしサービス（サービス種類：A1、A5）、1：保険者独自サービス（サービス種類：A2、A6、AF）、2：保険者独自（定率）サービス（サービス種類：A3、A7、A9、AB、AD）、3：保険者独自（定額）サービス
     */
    serviceShoBunrui(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7130KaigoServiceShurui(int maxLength, int scale) {
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
