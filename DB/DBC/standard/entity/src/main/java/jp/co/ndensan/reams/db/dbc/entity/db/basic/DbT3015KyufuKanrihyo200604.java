package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3015KyufuKanrihyo200604の項目定義クラスです
 *
 */
public enum DbT3015KyufuKanrihyo200604 implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">
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
     * 審査年月
     */
    shinsaYM(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 証記載保険者番号
     * <br/>当該被保険者の証記載保険者番号を設定。
     * <br/>国保連IF上にはないため、広域の場合は被保険者台帳ﾏｽﾀより市町村ｺｰﾄﾞを判定し保険者番号を求め設定する。
     */
    shokisaiHokenshaNo(2147483647, 0),
    /**
     * 居宅支援事業所番号
     * <br/>事業所作成の場合必須
     */
    kyotakushienJigyoshoNo(2147483647, 0),
    /**
     * 給付管理票情報作成区分コード
     */
    kyufuSakuseiKubunCode(1, 0),
    /**
     * 給付管理票作成年月日
     */
    kyufuSakuseiYMD(2147483647, 0),
    /**
     * 給付管理票種別区分コード
     */
    kyufuShubetsuKubunCode(1, 0),
    /**
     * 給付管理票明細行番号
     */
    kyufuMeisaiLineNo(2, 0),
    /**
     * 保険者番号
     */
    hokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * 被保険者生年月日
     */
    hiHokenshaUmareYMD(2147483647, 0),
    /**
     * 性別コード
     */
    seibetsuCode(1, 0),
    /**
     * 要介護状態区分コード
     */
    yoKaigoJotaiKubunCode(2, 0),
    /**
     * 限度額適用開始年月
     */
    gendogakuTekiyoKaishiYM(2147483647, 0),
    /**
     * 限度額適用終了年月
     */
    gendogakuTekiyoShuryoYM(2147483647, 0),
    /**
     * 居宅・介護予防支給限度額
     */
    kyotakuKaigoYoboShikyuGendogaku(10, 0),
    /**
     * 居宅サービス計画作成区分コード
     */
    kyotakuServicePlanSakuseiKubunCode(1, 0),
    /**
     * サービス事業所番号
     */
    serviceJigyoshoNo(2147483647, 0),
    /**
     * 指定/基準該当/地域密着型サービス識別コード
     */
    shiteiKijungaitoChiikimitchakuServiceShikibetsuCode(1, 0),
    /**
     * サービス種類コード
     */
    serviceShuruiCode(2147483647, 0),
    /**
     * 給付計画単位数／日数
     */
    kyufuKeikakuTanisuNissu(10, 0),
    /**
     * 限度額管理期間における前月までの給付計画日数
     * <br/>短期入所サービス給付管理票の場合、必須
     */
    kyufuKeikakuNissu(5, 0),
    /**
     * 指定サービス分小計
     */
    shiteiServiceSubTotal(10, 0),
    /**
     * 基準該当サービス分小計
     */
    kijyunGaitoServiceSubTotal(10, 0),
    /**
     * 給付計画合計単位数/日数
     */
    kyufuKeikakuTotalTanisuNissu(10, 0),
    /**
     * 担当介護支援専門員番号
     * <br/>対象年月が平成１８年４月以降の場合のみ
     */
    tantoKaigoShienSemmoninNo(8, 0),
    /**
     * 委託先の居宅介護支援事業所番号
     * <br/>対象年月が平成１８年４月以降の場合のみ
     */
    kaigoShienJigyoshaNo(2147483647, 0),
    /**
     * 委託先の担当介護支援専門員番号
     * <br/>対象年月が平成１８年４月以降の場合のみ
     */
    itakusakiTantoKaigoShienSemmoninNo(8, 0),
    /**
     * 当初登録年月日
     */
    toshoTorokuYMD(2147483647, 0),
    /**
     * 取込年月
     */
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3015KyufuKanrihyo200604(int maxLength, int scale) {
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
