package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7131KaigoServiceNaiyouの項目定義クラスです
 *
 * @author 自動生成
 * @jpName 介護サービス内容テーブル項目
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public enum DbT7131KaigoServiceNaiyou implements IColumnDefinition {
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
     * <br/>介護サービス種類TBLとのLinkキー
     */
    serviceShuruiCd(2147483647, 0),
    /**
     * サービス項目コード
     * <br/>サービス種類コードと合わせてサービスコードを示す。
     * <br/>サービス名称に対するコード
     */
    serviceKoumokuCd(4, 0),
    /**
     * 提供開始年月
     */
    teikyoKaishiYM(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(3, 0),
    /**
     * 提供終了年月
     */
    teikyoShuryoYM(2147483647, 0),
    /**
     * サービス名称
     */
    serviceName(100, 0),
    /**
     * サービス略称
     */
    serviceNameRyaku(50, 0),
    /**
     * 単位数
     */
    taniSu(10, 0),
    /**
     * 単位数識別
     * <br/>共通コード＜サブ業務：DBZ、種別：0021＞
     * <br/>01：単位数　　　　 
     * <br/>02：金額(円)
     * <br/>03：％値　　　　　 
     * <br/>04：きざみ基準単位
     * <br/>05：法定単位数なし(記載省略)
     * <br/>06：単位数(記載省略)
     * <br/>07：％値(記載省略) 
     * <br/>08：1/1000値
     * <br/>09：1/1000値(記載省略)
     * <br/>13：％値：上限
     */
    tanisuShikibetsuCode(2147483647, 0),
    /**
     * 単位数算定単位
     * <br/>共通コード＜サブ業務：DBZ、種別：0022＞
     * <br/>01:1回につき
     * <br/>02:1日につき
     * <br/>03:1月につき
     * <br/>04:算定単位無し
     * <br/>05:1週間につき
     */
    tanisuSanteiTaniCode(2147483647, 0),
    /**
     * 異動事由
     * <br/>共通コード＜サブ業務：DBZ、種別：0023＞
     * <br/>010：厚生省改定による 等
     * <br/>
     * <br/>介護サービス異動事由
     */
    idouJiyuCode(2147483647, 0),
    /**
     * 限度額対象外フラグ
     */
    gendogakuTaishogaiFlag(1, 0),
    /**
     * 外部サービス利用型区分
     */
    gaibuServiceRiyoKataKubun(1, 0),
    /**
     * 特別地域加算フラグ
     */
    tokubetsuChiikiKasanFlag(1, 0),
    /**
     * 利用者負担定率・定額区分
     */
    riyosyaFutanTeiritsuTeigakuKubun(1, 0),
    /**
     * 更新有無フラグ
     */
    koshinUmuFoag(1, 0),
    /**
     * 元点数
     */
    motoTensu(6, 0),
    /**
     * 元限度額対象外フラグ
     */
    motoGendogakuTaishogaiFlag(1, 0),
    /**
     * 元単位数識別コード
     */
    motoTaniShikibetsuCd(2, 0),
    /**
     * 利用者負担額
     */
    riyoshaFutanGaku(5, 0),
    /**
     * 給付率
     */
    kyufuRitsu(3, 0),
    /**
     * 二次予防事業対象者実施区分（非該当）
     */
    nijiyoboJigyoTaishaJishiKubunHigaito(1, 0),
    /**
     * 要支援１受給者実施区分
     */
    yoshien1JukyushaJishiKubun(1, 0),
    /**
     * 要支援２受給者実施区分
     */
    yoshien2JukyushaJishiKubun(1, 0),
    /**
     * 対象事業者実施区分
     */
    taishoJigyoJishiKubun(1, 0),
    /**
     * 総合事業サービス区分
     */
    sogoJigyoServiceKubun(1, 0),
    /**
     * 制限日数回数
     */
    seigenNissuKaisu(2, 0),
    /**
     * 算定回数制限期間区分
     */
    santeiKaisuSeigenKikanKubun(2, 0);

    private final int maxLength;
    private final int scale;

    private DbT7131KaigoServiceNaiyou(int maxLength, int scale) {
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
