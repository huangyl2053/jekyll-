/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付管理票一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT1121KyufuKanrihyoTempEntity {

    private int 連番;
    private RString 交換情報識別番号;
    private FlexibleYearMonth 審査年月;
    private FlexibleYearMonth サービス提供年月;
    private RString 給付管理票種別区分コード;
    private RString 給付管理票明細行番号;
    private RString 居宅支援事業所番号;
    private RString 給付管理票情報作成区分コード;
    private FlexibleDate 給付管理票作成年月日;
    private RString 保険者番号;
    private FlexibleDate 被保険者生年月日;
    private RString 性別コード;
    private RString 要介護状態区分コード;
    private FlexibleYearMonth 限度額適用開始年月;
    private FlexibleYearMonth 限度額適用終了年月;
    private Decimal 居宅_介護予防支給限度額;
    private RString 居宅サービス計画作成区分コード;
    private RString サービス事業所番号;
    private RString 指定_基準該当_地域密着型サービス識別コード;
    private RString サービス種類コード;
    private Decimal 給付計画単位数_日数;
    private Decimal 限度額管理期間における前月までの給付計画日数;
    private Decimal 指定サービス分小計;
    private Decimal 基準該当サービス分小計;
    private Decimal 給付計画合計単位数_日数;
    private RString 担当介護支援専門員番号;
    private RString 委託先の居宅介護支援事業所番号;
    private RString 委託先の担当介護支援専門員番号;
    private FlexibleDate 当初登録年月日;
    private FlexibleYearMonth 取込年月;
    private RString コントロールレコード保険者番号;
    private RString コントロールレコード保険者名;
    private RString 事業者名称;

    /**
     * DbWT0001HihokenshaIchijiEntityにかわる。
     *
     * @return DbWT0001HihokenshaIchijiEntity
     */
    public DbWT1121KyufuKanrihyoEntity toEntity() {
        DbWT1121KyufuKanrihyoEntity entity = new DbWT1121KyufuKanrihyoEntity();
        entity.setRenban(連番);
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        entity.setShinsaYM(審査年月);
        entity.setServiceTeikyoYM(サービス提供年月);
        entity.setKyufuShubetsuKubunCode(給付管理票種別区分コード);
        entity.setKyufuMeisaiLineNo(給付管理票明細行番号);
        entity.setKyotakushienJigyoshoNo(居宅支援事業所番号);
        entity.setKyufuSakuseiKubunCode(給付管理票情報作成区分コード);
        entity.setKyufuSakuseiYMD(給付管理票作成年月日);
        entity.setMeisaiHokenshaNo(保険者番号);
        entity.setHiHokenshaUmareYMD(被保険者生年月日);
        entity.setSeibetsuCode(性別コード);
        entity.setYoKaigoJotaiKubunCode(要介護状態区分コード);
        entity.setGendogakuTekiyoKaishiYM(限度額適用開始年月);
        entity.setGendogakuTekiyoShuryoYM(限度額適用終了年月);
        entity.setKyotakuKaigoYoboShikyuGendogaku(居宅_介護予防支給限度額);
        entity.setKyotakuServicePlanSakuseiKubunCode(居宅サービス計画作成区分コード);
        entity.setServiceJigyoshoNo(サービス事業所番号);
        entity.setShiteiKijungaitoChiikimitchakuServiceShikibetsuCode(指定_基準該当_地域密着型サービス識別コード);
        entity.setServiceShuruiCode(サービス種類コード);
        entity.setKyufuKeikakuTanisuNissu(給付計画単位数_日数);
        entity.setKyufuKeikakuNissu(限度額管理期間における前月までの給付計画日数);
        entity.setShiteiServiceSubTotal(指定サービス分小計);
        entity.setKijyunGaitoServiceSubTotal(基準該当サービス分小計);
        entity.setKyufuKeikakuTotalTanisuNissu(給付計画合計単位数_日数);
        entity.setTantoKaigoShienSemmoninNo(担当介護支援専門員番号);
        entity.setKaigoShienJigyoshaNo(委託先の居宅介護支援事業所番号);
        entity.setItakusakiTantoKaigoShienSemmoninNo(委託先の担当介護支援専門員番号);
        entity.setToshoTorokuYMD(当初登録年月日);
        entity.setTorikomiYM(取込年月);
        entity.setHokenshaNo(コントロールレコード保険者番号);
        entity.setHokenshaName(コントロールレコード保険者名);
        entity.setJigyoshaName(事業者名称);
        return entity;
    }

}
