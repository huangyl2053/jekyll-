/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3014KyufuKanrihyo200004Entity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付管理票200004エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3014KyufuKanrihyo200004EntityGenerator {

    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYear("1990");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo();
    public static final JigyoshaNo DEFAULT_居宅支援事業所番号 = new JigyoshaNo();
    public static final RString DEFAULT_給付管理票情報作成区分コード = new RString("Data");
    public static final FlexibleDate DEFAULT_給付管理票作成年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_給付管理票種別区分コード = new RString("Data");
    public static final RString DEFAULT_給付管理票明細行番号 = new RString("Data");
    public static final HokenshaNo DEFAULT_保険者番号 = new HokenshaNo();
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleDate DEFAULT_被保険者生年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_性別コード = new RString("Data");
    public static final RString DEFAULT_要介護状態区分コード = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_限度額適用期間 = new FlexibleYear("1990");
    public static final FlexibleYearMonth DEFAULT_限度額適用期間 = new FlexibleYear("1990");
    public static final Decimal DEFAULT_居宅・介護予防支給限度額 = new Decimal(0);
    public static final RString DEFAULT_居宅サービス計画作成区分コード = new RString("Data");
    public static final JigyoshaNo DEFAULT_サービス事業所番号 = new JigyoshaNo();
    public static final RString DEFAULT_指定/基準該当/地域密着型サービス識別コード = new RString("Data");
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode();
    public static final Decimal DEFAULT_給付計画単位数／日数 = new Decimal(0);
    public static final Decimal DEFAULT_限度額管理期間における前月までの給付計画日数 = new Decimal(0);
    public static final Decimal DEFAULT_指定サービス分小計 = new Decimal(0);
    public static final Decimal DEFAULT_基準該当サービス分小計 = new Decimal(0);
    public static final Decimal DEFAULT_給付計画合計単位数/日数 = new Decimal(0);
    public static final FlexibleDate DEFAULT_当初登録年月日 = new FlexibleDate("19900101");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYear("1990");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3014KyufuKanrihyo200004EntityGenerator() {
    }

    public static DbT3014KyufuKanrihyo200004Entity createDbT3014KyufuKanrihyo200004Entity() {
        DbT3014KyufuKanrihyo200004Entity entity = new DbT3014KyufuKanrihyo200004Entity();
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setKyotakushienJigyoshoNo(DEFAULT_居宅支援事業所番号);
        entity.setKyufuKanrihyoSakuseiKubunCode(DEFAULT_給付管理票情報作成区分コード);
        entity.setKyufuKanrihyoSakuseiYMD(DEFAULT_給付管理票作成年月日);
        entity.setKyufuKanrihyoShubetsuKubunCode(DEFAULT_給付管理票種別区分コード);
        entity.setKyufuKanrihyoMeisaiLineNo(DEFAULT_給付管理票明細行番号);
        entity.setHokenshaNo(DEFAULT_保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setHiHokenshaUmareYMD(DEFAULT_被保険者生年月日);
        entity.setSeibetsuCode(DEFAULT_性別コード);
        entity.setYoKaigoJotaiKubunCode(DEFAULT_要介護状態区分コード);
        entity.setGendogakuTekiyoKaishiYM(DEFAULT_限度額適用期間);
        entity.setGendogakuTekiyoShuryoYM(DEFAULT_限度額適用期間);
        entity.setKyotakuKaigoYoboShikyuGendogaku(DEFAULT_居宅・介護予防支給限度額);
        entity.setKyotakuServicePlanSakuseiKubunCode(DEFAULT_居宅サービス計画作成区分コード);
        entity.setServiceJigyoshoNo(DEFAULT_サービス事業所番号);
        entity.setShiteiKijungaitoChiikimitchakuServiceShikibetsuCode(DEFAULT_指定/基準該当/地域密着型サービス識別コード);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setKyufuKeikakuTanisuNissu(DEFAULT_給付計画単位数／日数);
        entity.setKyufuKeikakuNissu(DEFAULT_限度額管理期間における前月までの給付計画日数);
        entity.setShiteiServiceSubTotal(DEFAULT_指定サービス分小計);
        entity.setKijyunGaitoServiceSubTotal(DEFAULT_基準該当サービス分小計);
        entity.setKyufuKeikakuTotalTanisuNissu(DEFAULT_給付計画合計単位数/日数);
        entity.setToshoTorokuYMD(DEFAULT_当初登録年月日);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
